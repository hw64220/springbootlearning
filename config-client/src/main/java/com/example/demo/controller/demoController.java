package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class demoController {

   @Value("${book.name}")
    private String bookName;

    @Value("${server.port}")
    private String serverPort;

    @RequestMapping("/bookName")
    public Object getBookName() {
        return  this.bookName;
    }

    @RequestMapping("/serverPort")
    public Object getServerPost() {return  this.serverPort;}
}
