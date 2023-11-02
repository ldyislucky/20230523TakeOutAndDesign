package com.ldy.reggie.controller;


import com.ldy.reggie.common.R;
import com.ldy.reggie.entity.Employee;
import com.ldy.reggie.service.IEmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 员工信息 前端控制器
 * </p>
 *
 * @author author
 * @since 2023-11-02
 */
@RestController
@RequestMapping("/employee")
@RequiredArgsConstructor
public class EmployeeController {
    private final IEmployeeService iEmployeeService;

    @PostMapping("/login")
    public R<Employee> Login(@RequestBody Employee employee){
        return iEmployeeService.login(employee);
    }

}
