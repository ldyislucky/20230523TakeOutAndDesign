package com.ldy.mpp.controller;


import com.ldy.mpp.domain.query.UserQuery;
import com.ldy.mpp.domain.vo.UserVoAddress;
import com.ldy.mpp.service.IUserService;
import com.xiaoleilu.hutool.bean.BeanUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;

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
    @GetMapping("/{id}")//{}不能丢
    public void getUserVo(@PathVariable("id") int id){
         iUserService.getUserVo(id);
    }
//    @GetMapping("/test")   get不支持json
//    public UserVoAddress gettest(@RequestBody UserQuery userQuery){
//        return new UserVoAddress();
//    }

    @PostMapping("/test")  //接收json格式的数据
    public UserVoAddress gettest(@RequestBody UserQuery userQuery){
        return new UserVoAddress();
    }

}
