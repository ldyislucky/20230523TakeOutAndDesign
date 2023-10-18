package com.ldy.mpp.controller;


import com.ldy.mpp.service.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 用户表 前端控制器
 * </p>
 *
 * @author author
 * @since 2023-10-12
 */
@RestController
@RequestMapping("/user")
@RequiredArgsConstructor//可以自动装配带final修饰的成员变量
public class UserController {
    private final IUserService iUserService;
    public void getUserVo(int id){
        iUserService.getUserVo(id);
    }
}
