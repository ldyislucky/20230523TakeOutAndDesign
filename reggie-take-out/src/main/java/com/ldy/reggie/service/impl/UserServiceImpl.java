package com.ldy.reggie.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.ldy.reggie.entity.User;

import com.ldy.reggie.mapper.UserMapper;

import com.ldy.reggie.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Override
    @Transactional
    public void transfer(int money) {

        User li = lambdaQuery().eq(User::getId, 1).one();
        User zhang = lambdaQuery().eq(User::getId, 2).one();

        li.setMoney(li.getMoney() - money);
        zhang.setMoney(zhang.getMoney() + money);
        Integer versionsZhang = zhang.getVersions();

        log.info(li.toString());
        log.info(zhang.toString());

        lambdaUpdate()
                .eq(User::getId,li.getId())
                .eq(User::getVersions,li.getVersions())
                .set(User::getMoney,li.getMoney())
                .set(User::getVersions,li.getVersions()+1)
                .update();

        //int i = 1/0;

        lambdaUpdate()
                .eq(User::getId,zhang.getId())
                .eq(User::getVersions,versionsZhang)
                .set(User::getMoney,zhang.getMoney())
                .set(User::getVersions,versionsZhang+1)
                .update();


    }
}
