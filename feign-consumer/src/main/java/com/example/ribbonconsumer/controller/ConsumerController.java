package com.example.ribbonconsumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
public class ConsumerController {
    @Autowired
    RestTemplate restTemplate;

    @RequestMapping(value = "/ribbon-consumer", method = RequestMethod.GET)
    public String helloConsumer() {
        return restTemplate.getForEntity("http://HELLO-SERVICE/hello", String.class).getBody();
    }

    @RequestMapping(value="/ribbon-param", method = RequestMethod.GET)
    public String helloConsumerParam() {
        return restTemplate.getForEntity("http://HELLO-SERVICE/getParam?inputValue={1}", String.class, "didi").getBody();
    }

    @RequestMapping(value="/ribbon-urlparam", method = RequestMethod.GET)
    public String helloConsumerUrlParam() {
        return restTemplate.getForEntity("http://HELLO-SERVICE/getParam/{1}", String.class, "didi").getBody();
    }

    @RequestMapping(value = "ribbon-uri", method = RequestMethod.GET)
    public String getUriReturn() {
        UriComponents uriComponents = UriComponentsBuilder.fromUriString(
                "http://HELLO-SERVICE/getParam?inputValue={name}"
        ).build().expand("dodo").encode();
        URI uri =uriComponents.toUri();
        String responseEntity = restTemplate.getForEntity(uri, String.class).getBody();
        return responseEntity;
    }
}
