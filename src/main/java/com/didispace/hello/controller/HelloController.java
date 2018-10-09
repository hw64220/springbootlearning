package com.didispace.hello.controller;

import com.didispace.hello.bean.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Autowired
    Book book;

    @RequestMapping("/hello")
    public String helloWorld() {
        return "hello world";
    }

    @RequestMapping("/book")
    public String getBook() {
        return book.getName() + ": " + book.getAuthor();
    }
}
