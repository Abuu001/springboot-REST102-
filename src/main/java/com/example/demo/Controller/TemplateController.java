package com.example.demo.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class TemplateController {

    @GetMapping("login")
    public String getLoginView(){
        return "login"; //name of the file without the extension
    }

    @GetMapping("courses")
    public String getCourses(){
        return "courses"; //name of the file without the extension
    }
}
