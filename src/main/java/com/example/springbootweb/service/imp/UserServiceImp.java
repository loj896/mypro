package com.example.springbootweb.service.imp;

import com.example.springbootweb.mapper.UserMapper;
import com.example.springbootweb.model.User;
import com.example.springbootweb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author liuhai
 * @date 2018-08-07 14:19
 * @description
 */
@Service
public class UserServiceImp implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> findAll(User user) {
        List<User> list = userMapper.findAll(user);
        return list;
    }

    @Override
    public User findById(Integer userid) {
        User user = userMapper.findById(userid);
        return user;
    }

    @Override
    public void insert(User user) {
        userMapper.insert(user);
    }

    @Override
    public void insertSelective(User user) {
        userMapper.insertSelective(user);
    }

    @Override
    public void deleteById(Integer userid) {
        userMapper.deleteById(userid);
    }

    @Override
    public void update(User user) {
        userMapper.update(user);
    }

    @Override
    public void updateSelective(User user) {
        userMapper.updateSelective(user);
    }
}
