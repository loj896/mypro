package com.example.springbootweb.controller;

import com.example.springbootweb.model.Test;
import com.example.springbootweb.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author liuhai
 * @date 2018-08-09 11:04
 * @description
 */
@RestController
@RequestMapping("/test")
public class TestController {
    @Autowired
    private TestService testService;

    @RequestMapping("/findAll")
    public List<Test> findAll(){
        List<Test> list = testService.findAll();
        return list;
    }

    @RequestMapping("test")
    public String test(){
        return "Hello World";
    }


}

