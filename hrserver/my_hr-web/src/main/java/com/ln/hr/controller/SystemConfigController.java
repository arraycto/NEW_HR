package com.ln.hr.controller;

import com.ln.hr.model.Menu;
import com.ln.hr.service.MenusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/system/config")
public class SystemConfigController {

    @Autowired
    MenusService menusService;

    @GetMapping("/menu")
    public List<Menu> getMenusByHrId(){
        return menusService.getMenusByHrId();
    }
}
