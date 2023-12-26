package com.learningspringboot.learningspringboot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @GetMapping(path = "/hello")
    public String sayHello(){
        return "hello world!!!!";
    }
    @GetMapping(path="/random-number")
    public Integer getRandomNumber(){
        return (int) (Math.random()*100);
    }
}
