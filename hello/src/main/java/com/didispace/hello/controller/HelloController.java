package com.didispace.hello.controller;

import com.didispace.hello.bean.Book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.serviceregistry.Registration;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.logging.Logger;


@RestController
public class HelloController {

    private static Logger logger =  Logger.getLogger("HelloController");
    @Autowired
    Book book;

    @Autowired
    private Registration registration;

    @Autowired
    private DiscoveryClient client;

    @Autowired
    private Environment environment;


    @RequestMapping("/hello")
    public String helloWorld() {
        logger.info("call me hello");
        return "hello world";
    }

    @RequestMapping("/book")
    public String getBook() {
        return book.getName() + ": " + book.getAuthor();
    }

    @RequestMapping("/bookDesc")
    public String getBookDesc() {
        return book.getDesc();
    }

    @RequestMapping("/eureka")
    public String testEureka() {
        ServiceInstance instance = client.getInstances(registration.getServiceId()).get(0);
        logger.info("/eureka, host:" + instance.getHost() + ", service id: " + instance.getServiceId());
        return ("/eureka, host:" + instance.getHost() + ", service id: " + instance.getServiceId());
    }

    @RequestMapping(value = "/getParam", method = RequestMethod.GET)
    public String getParameterReturn(@RequestParam("inputValue") String inputValue) {
        logger.info("current port: " + environment.getProperty("local.server.port"));

        return "This is input VALUE: " + inputValue;
    }

    @RequestMapping(value = "/getParam/{urlparam}", method = RequestMethod.GET)
    public String getUrlReturn(@PathVariable("urlparam") String urlValue) {
        return "This is input url param: " + urlValue;
    }
}
