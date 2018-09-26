package com.example.springbootweb.controller;

import com.example.springbootweb.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author liuhai
 * @date 2018-09-18 10:40
 * @description
 */
@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    private Book book;

    @RequestMapping("/getBook")
    public Book getBook(){
        book.printName();
        return book;
    }
}
