package com.ldy.mpp.controller;

import com.ldy.mpp.domain.query.UserQuery;
import com.ldy.mpp.entity.User;
import com.ldy.mpp.service.UserService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author : ldy
 * @version : 1.0
 */
@RequestMapping("/user")
@RestController
@RequiredArgsConstructor//可以自动装配带final修饰的成员变量
public class UserContrller {
    private final UserService userService;
    @GetMapping("/list")
    public List<User> getUsers(UserQuery userQuery){
        return userService.queryUsers(userQuery.getUsername(),
                userQuery.getStatus(),userQuery.getMinBalance(),userQuery.getMaxBalance());
    }
}
