package com.example.demo.Hello;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HelloController {

    @Value("${welcome.message}")  // can be used to read values from properties file
    private String welcomeMessage;

    @RequestMapping("/hello101")
    public String Hello2(){
        return welcomeMessage;
    }

    @RequestMapping("/hello")
    public List Hello(){
        return List.of("Hello"," World");
    }
}
