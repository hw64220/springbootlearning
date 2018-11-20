package com.example.demo.controller;

import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RequestMapping;

public class demoController {

    @RequestMapping("hello")
    public Object getHelloWorld() {
        return  "helloWorld";
    }
}
