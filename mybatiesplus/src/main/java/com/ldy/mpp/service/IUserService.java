package com.ldy.mpp.service;

import com.ldy.mpp.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 用户表 服务类
 * </p>
 *
 * @author author
 * @since 2023-10-12
 */
public interface IUserService extends IService<User> {

    void getUserVo(int id);
}
