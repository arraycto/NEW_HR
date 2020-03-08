package com.ln.hr.controller;

import com.ln.hr.model.RespBean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @GetMapping("/login")
    public RespBean login(){
        return new RespBean(500, "请先登录", null);
    }
}
