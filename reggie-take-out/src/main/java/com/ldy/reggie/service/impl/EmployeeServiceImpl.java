package com.ldy.reggie.service.impl;

import cn.hutool.crypto.digest.DigestUtil;
import cn.hutool.crypto.digest.MD5;
import com.ldy.reggie.common.R;
import com.ldy.reggie.entity.Employee;
import com.ldy.reggie.mapper.EmployeeMapper;
import com.ldy.reggie.service.IEmployeeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

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
    public R<Employee> login(Employee employee) {
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
        return R.success(dbemployee);
    }
}
