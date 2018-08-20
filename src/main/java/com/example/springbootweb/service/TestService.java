package com.example.springbootweb.service;

import com.example.springbootweb.model.Test;

import java.util.List;

/**
 * @author liuhai
 * @date 2018-08-09 11:01
 * @description
 */
public interface TestService {

    List<Test> findAll();
}
