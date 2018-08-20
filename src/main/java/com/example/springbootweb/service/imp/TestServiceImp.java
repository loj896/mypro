package com.example.springbootweb.service.imp;

import com.example.springbootweb.mapper.TestMapper;
import com.example.springbootweb.model.Test;
import com.example.springbootweb.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author liuhai
 * @date 2018-08-09 11:01
 * @description
 */
@Service
public class TestServiceImp implements TestService {
    @Autowired
    private TestMapper testMapper;
    @Override
    public List<Test> findAll() {
        List<Test> list = testMapper.findAll();
        return  list;
    }
}
