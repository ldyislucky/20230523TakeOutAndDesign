package com.ldy.reggie.service.impl;

import com.ldy.reggie.common.R;
import com.ldy.reggie.entity.Employee;
import com.ldy.reggie.mapper.EmployeeMapper;
import com.ldy.reggie.service.IEmployeeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;

/**
 * <p>
 * 员工信息 服务实现类
 * </p>
 *
 * @author author
 * @since 2023-11-02
 */
@Service
public class EmployeeServiceImpl extends ServiceImpl<EmployeeMapper, Employee> implements IEmployeeService {

    @Override
    public R<Employee> login(HttpServletRequest request, Employee employee) {
        String username = employee.getUsername();
        Employee dbemployee = lambdaQuery().eq(Employee::getUsername, username).one();
        if (dbemployee == null){
            return R.error("用户名错误！");
        }
        String password = employee.getPassword();
        password = DigestUtils.md5DigestAsHex(password.getBytes());
        if (!dbemployee.getPassword().equals(password)){
            return R.error("用户密码错误！");
        }
        if (dbemployee.getStatus()==0){
            return R.error("账户已禁用");
        }
        request.getSession().setAttribute("username",dbemployee.getId());
        return R.success(dbemployee);
    }

    @Override
    public R<String> addUser(HttpServletRequest request, Employee employee) {
//        1、根据session获取登录用户id
        Long id = (Long) request.getSession().getAttribute("username");
//        2、获取登录用户信息,用户id是long型的，不知道用integer传参是否可以正常执行
        Employee loginEmployee = getById(id);
//        3、完善新增用户的信息
        String password = DigestUtils.md5DigestAsHex("123456".getBytes());
        LocalDateTime now = LocalDateTime.now();
        employee.setPassword(password);
        employee.setCreateTime(now);
        employee.setUpdateTime(now);
        employee.setCreateUser(id);
        employee.setUpdateUser(id);
//        4、插入新增用户
        save(employee);
        return R.success("用户添加成功！");
    }

}
