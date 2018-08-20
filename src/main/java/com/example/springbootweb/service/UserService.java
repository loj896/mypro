package com.example.springbootweb.service;

import com.example.springbootweb.model.User;

import java.util.List;

/**
 * @author liuhai
 * @date 2018-08-07 14:18
 * @description
 */
public interface UserService {

    List<User> findAll(User user);

    User findById(Integer userid);

    void insert(User user);

    void insertSelective(User user);

    void deleteById(Integer userid);

    void update(User user);

    void updateSelective(User user);
}
