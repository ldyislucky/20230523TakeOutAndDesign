package com.ldy.mpp.service.impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ldy.mpp.entity.AddressTest;
import com.ldy.mpp.entity.User;
import com.ldy.mpp.entity.vo.UserVoAddress;
import com.ldy.mpp.mapper.AddressTestMapper;
import com.ldy.mpp.mapper.UserMapper;
import com.ldy.mpp.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author author
 * @since 2023-10-12
 */
@Service
@RequiredArgsConstructor//可以自动装配带final修饰的成员变量
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {
    private final AddressTestMapper addressTestMapper;
    @Override
    public void getUserVo(int id) {
        User user = getById(id);
        if (user.getStatus()==2){
            throw new RuntimeException("用户状态异常！");
        }
        UserVoAddress userVoAddress = new UserVoAddress();
        BeanUtils.copyProperties(user,userVoAddress);
        QueryWrapper<AddressTest> wrapper = new QueryWrapper<>();
        wrapper.lambda()
                .eq(AddressTest::getUserId,id);
        List<AddressTest> addressTests = addressTestMapper.selectList(wrapper);
        userVoAddress.setAddressTests(addressTests);
        String s = JSON.toJSONString(userVoAddress);
        System.out.println(s);


    }
}
