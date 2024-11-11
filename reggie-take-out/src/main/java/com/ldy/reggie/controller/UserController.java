package com.ldy.reggie.controller;

import com.ldy.reggie.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/User")
public class UserController {
    @Autowired
    private IUserService userService;
    @GetMapping("/transfer")
    public void m1(){
        userService.transfer(100);
    }
}
