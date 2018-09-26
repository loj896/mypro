package com.example.springbootweb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
//@MapperScan("com.example.springbootweb.mapper") 该注解和 @Mapper（用于Mapper接口） 二选一
//@EnableScheduling 用于定时任务
//开启Redis缓存
@EnableCaching
public class SpringBootWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootWebApplication.class, args);
    }
}
