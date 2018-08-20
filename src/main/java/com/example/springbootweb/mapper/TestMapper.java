package com.example.springbootweb.mapper;

import com.example.springbootweb.model.Test;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author liuhai
 * @date 2018-08-09 11:00
 * @description
 */
@Mapper
@Component(value = "testMapper")
public interface TestMapper {

    @Select("select * from t_test")
    List<Test> findAll();
}
