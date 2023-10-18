package com.ldy.mpp.controller;

import com.ldy.mpp.domain.query.UserQuery;
import com.ldy.mpp.entity.Users;
import com.ldy.mpp.service.UsersService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author : ldy
 * @version : 1.0
 */
@Component
@RequestMapping("/user")
@RestController
@RequiredArgsConstructor//可以自动装配带final修饰的成员变量
public class UsersController {
    private final UsersService usersService;
    @GetMapping("/list")
    public List<Users> queryUsers(UserQuery userQuery){
        return usersService.queryUsers(userQuery.getUsername(),
                userQuery.getStatus(),userQuery.getMinBalance(),userQuery.getMaxBalance());
    }
}
