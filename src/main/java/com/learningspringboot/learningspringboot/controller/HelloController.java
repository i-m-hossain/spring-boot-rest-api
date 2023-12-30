package com.learningspringboot.learningspringboot.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @Value("${welcome.message}")
    private String message;
    @GetMapping(path = "/hello")
    public String sayHello(){
        return this.message;
    }
    @GetMapping(path="/random-number")
    public Integer getRandomNumber(){
        return (int) (Math.random()*100);
    }
}
