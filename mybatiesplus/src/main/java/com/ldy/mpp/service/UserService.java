package com.ldy.mpp.service;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ldy.mpp.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author : ldy
 * @version : 1.0
 */
//@Service  接口上的这个注解好像不是特别必要，但是实现类上的是很必要的
public interface UserService extends IService<User> {
    List<User> queryUsers(String username, Integer status, Double minBalance, Double maxBalance);
}
