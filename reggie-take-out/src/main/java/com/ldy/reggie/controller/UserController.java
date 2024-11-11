package com.ldy.reggie.controller;

import com.ldy.reggie.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private IUserService userService;


    @GetMapping("/transfer")
  // @Transactional
    public void m1(){
        /**
         * 目前的这种方式带上@Transactional这个事务也是可以回滚的
         * 但是注释@Transactional之后，上面这个userService.transfer(100)；就无法正常回滚了
         */

        userService.transfer(100);
        int a= 1/0;
        userService.transfer(100);
        /**
         * m1方法上的@Transactional无论是否注释掉，如果在事务之后突然有一个报错 事务是不会回滚的。
         * 但是int a= 1/0;放到userService.transfer(100);中之后就可以正常回滚了
         */
        //int a= 1/0; 在注释到m1方法上的@Transactional之后，如果在事务之后突然有一个报错 事务是不会回滚的。
    }
}
