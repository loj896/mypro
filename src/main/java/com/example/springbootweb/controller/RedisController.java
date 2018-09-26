package com.example.springbootweb.controller;

import com.example.springbootweb.model.Test;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author liuhai
 * @date 2018-09-04 23:42
 * @description
 */
@RestController
@RequestMapping("/redis")
public class RedisController {

    @RequestMapping("/setKey")
    public String setKey(){
        return "set ok";
    }

    @RequestMapping("/getKey")
    public String getKey(){
        return "key result";
    }
}
