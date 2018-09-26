package com.example.springbootweb.mapper;

import com.example.springbootweb.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author liuhai
 * @date 2018-08-07 14:17
 * @description
 */
@Mapper
@Component(value = "userMapper")
@CacheConfig(cacheNames = "users")
public interface UserMapper {

    List<User> findAll(User user);

    //@Cacheable将查询结果缓存到redis中，（key="#p0"）指定传入的第一个参数作为redis的key。
    @Cacheable(key ="#p0")
    User findById(Integer userid);

    void insert(User user);

    void insertSelective(User user);

    //@CacheEvict，指定key，删除缓存数据，allEntries=true,方法调用后将立即清除缓存
    @CacheEvict(key ="#p0",allEntries=true)
    void deleteById(Integer userid);

    //@CachePut，指定key，将更新的结果同步到redis中
    @CachePut(key = "#user.userid")
    void update(User user);

    void updateSelective(User user);
}
