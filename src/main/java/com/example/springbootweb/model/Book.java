package com.example.springbootweb.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

/**
 * @author liuhai
 * @date 2018-09-18 10:30
 * @description
 */
@Component
//@PropertySource("classpath:application.yml")
@ConfigurationProperties(prefix = "book")
public class Book {

    @Autowired
    private Environment env;

    @Value("${book.name}")
    private String name;

    @Value("${book.author}")
    private String author;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void printName(){
        System.out.printf("name:" + env.getProperty("book.name")+",author:" + env.getProperty("book.author"));
    }

}
