package com.example.springbootweb.mapper;

import com.example.springbootweb.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author liuhai
 * @date 2018-08-07 14:17
 * @description
 */
@Mapper
@Component(value = "userMapper")
public interface UserMapper {

    List<User> findAll(User user);

    User findById(Integer userid);

    void insert(User user);

    void insertSelective(User user);

    void deleteById(Integer userid);

    void update(User user);

    void updateSelective(User user);
}
