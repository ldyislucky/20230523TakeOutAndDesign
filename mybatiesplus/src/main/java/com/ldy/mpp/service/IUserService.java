package com.ldy.mpp.service;

import com.ldy.mpp.domain.query.UserQuery;
import com.ldy.mpp.domain.vo.UserVoAddress;
import com.ldy.mpp.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

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

    List<UserVoAddress> getUserVoAddress(UserQuery userQuery);
}
