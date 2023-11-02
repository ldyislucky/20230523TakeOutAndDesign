package com.ldy.reggie.service;

import com.ldy.reggie.common.R;
import com.ldy.reggie.entity.Employee;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 员工信息 服务类
 * </p>
 *
 * @author author
 * @since 2023-11-02
 */
public interface IEmployeeService extends IService<Employee> {

    R<Employee> login(Employee employee);
}
