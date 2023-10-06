package com.ldy.mpp.service.imp;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ldy.mpp.entity.User;
import com.ldy.mpp.mapper.UserMapper;
import com.ldy.mpp.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author : ldy
 * @version : 1.0
 */
@Service//这个注解必须添加，否则会报找不到UserService的bean的错
public class UserServiceImp extends ServiceImpl<UserMapper, User> implements UserService {

    @Override
    public List<User> queryUsers(String username, Integer status, Double minBalance, Double maxBalance) {
        return lambdaQuery()
                .like(username!=null,User::getUsername,username)
                .eq(status!=null,User::getStatus,status)
                .gt(minBalance!=null,User::getMinBalance,minBalance)
                .lt(maxBalance!=null,User::getMaxBalance,maxBalance)
                .list();
    }
}
