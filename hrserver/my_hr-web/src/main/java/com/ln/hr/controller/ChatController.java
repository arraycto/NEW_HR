package com.ln.hr.controller;

import com.ln.hr.model.Hr;
import com.ln.hr.service.HrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/chat")
public class ChatController {

    @Autowired
    HrService hrService;

    @GetMapping("/hrs")
    public List<Hr> getAllHr(){
        return hrService.getAllHrWithoutCurrent();
    }
}
