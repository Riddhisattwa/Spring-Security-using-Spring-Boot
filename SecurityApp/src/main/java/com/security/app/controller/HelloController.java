package com.security.app.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//this is the hello controller to be used for checking spring security
@RestController
@RequestMapping("/hello/sendhello")
public class HelloController {

    @GetMapping
    public String sendHello(){
        return "Hello World";
    }
}
