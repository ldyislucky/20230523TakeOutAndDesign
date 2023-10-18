package com.ldy.mpp.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ldy.mpp.entity.Users;

import java.util.List;

/**
 * @author : ldy
 * @version : 1.0
 */
//@Service  接口上的这个注解好像不是特别必要，但是实现类上的是很必要的
public interface UsersService extends IService<Users> {
    List<Users> queryUsers(String username, Integer status, Double minBalance, Double maxBalance);
}
