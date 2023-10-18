package com.ldy.mpp.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ldy.mpp.entity.Users;
import com.ldy.mpp.mapper.UsersMapper;
import com.ldy.mpp.service.UsersService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author : ldy
 * @version : 1.0
 */
@Service//这个注解必须添加，否则会报找不到UserService的bean的错
public class UsersServiceImp extends ServiceImpl<UsersMapper, Users> implements UsersService {

    @Override
    public List<Users> queryUsers(String username, Integer status, Double minBalance, Double maxBalance) {
        return lambdaQuery()  //前面默认的是select * from users
                .like(username!=null, Users::getUsername,username)
                .eq(status!=null, Users::getStatus,status)
                .gt(minBalance!=null, Users::getMinBalance,minBalance)
                .lt(maxBalance!=null, Users::getMaxBalance,maxBalance)
                .list();
    }
}
