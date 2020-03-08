package com.ln.hr.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/hello")
    public String hello(){
        return "A test";
    }

    @GetMapping("/employee/basic/hello")
    public String hello2(){
        return "employee/basic/hello";
    }

    @GetMapping("/employee/advanced/hello")
    public String hello3(){
        return "employee/advanced/hello";
    }
}
