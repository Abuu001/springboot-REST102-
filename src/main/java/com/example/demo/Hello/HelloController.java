package com.example.demo.Hello;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HelloController {

    @RequestMapping("/hello")
    public List Hello(){
        return List.of("Hello"," World");
    }
}
