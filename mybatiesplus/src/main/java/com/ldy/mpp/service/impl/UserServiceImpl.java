package com.ldy.mpp.service.impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.toolkit.Db;
import com.ldy.mpp.domain.enu.UserStatus;
import com.ldy.mpp.domain.query.UserQuery;
import com.ldy.mpp.entity.AddressTest;
import com.ldy.mpp.entity.User;
import com.ldy.mpp.domain.vo.UserVoAddress;
import com.ldy.mpp.mapper.AddressTestMapper;
import com.ldy.mpp.mapper.UserMapper;
import com.ldy.mpp.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xiaoleilu.hutool.bean.BeanUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.jws.soap.SOAPBinding;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;


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
        if (user.getStatus()== UserStatus.FREEZE){
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

    @Override
    public List<UserVoAddress> getUserVoAddress(UserQuery userQuery) {
        System.out.println(userQuery.toString());
        Page<User> page = Page.of(userQuery.getPageNo(),userQuery.getPageSize());
        // 1.2.排序条件
        if (userQuery.getSortBy() != null) {
            page.addOrder(new OrderItem(userQuery.getSortBy(), userQuery.getIsAsc()));
        }else{
            // 默认按照更新时间排序
            page.addOrder(new OrderItem("update_time", false));
        }
        String username = userQuery.getUsername();
        System.out.println(username);
        Integer status = userQuery.getStatus();
        Double maxBalance = userQuery.getMaxBalance();
        Double minBalance = userQuery.getMinBalance();
        List<User> users = lambdaQuery()
                .like(username.isEmpty(), User::getUsername, username)
                .page(page).getRecords();
        List<AddressTest> addressTestList = Db.lambdaQuery(AddressTest.class).list();
        Map<Long, List<AddressTest>> listMap = addressTestList.stream()
                .collect(Collectors.groupingBy(AddressTest::getUserId));
        List<UserVoAddress> userVoAddressList = new ArrayList<>();
        for (User user : users){
            UserVoAddress userVoAddress = new UserVoAddress();
            BeanUtil.copyProperties(user,userVoAddress);
            List<AddressTest> addressTests = listMap.get(user.getId());
            userVoAddress.setAddressTests(addressTests);
            userVoAddressList.add(userVoAddress);
        }
        return userVoAddressList;
    }
}
