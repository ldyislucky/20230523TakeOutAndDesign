package com.ldy.reggie.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ldy.reggie.common.R;
import com.ldy.reggie.common.ThreadLocalLong;
import com.ldy.reggie.entity.Employee;
import com.ldy.reggie.service.IEmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

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
    public R<Employee> Login(HttpServletRequest request, @RequestBody Employee employee){
        return iEmployeeService.login(request,employee);
    }

    @PostMapping("/logout")
    public R<String> logout(HttpServletRequest request){
        Long i = (Long) request.getSession().getAttribute("username");
        request.getSession().removeAttribute("username");
        String username = "移除的session属性是"+i;
        return R.success(username);
    }

    @PostMapping
    public R<String> addUser(HttpServletRequest request,@RequestBody Employee employee){
        return iEmployeeService.addUser(request,employee);
    }
    @GetMapping("/page")
    public R<Page<Employee>> getPageUser(@RequestParam("page") Integer page, Integer pageSize, String name){
        return iEmployeeService.getPageUser(page,pageSize,name);
    }

    @PutMapping
    public R<String> updateEmployee(@RequestBody Employee employee){
        ThreadLocalLong.setLong(employee.getId());
        iEmployeeService.updateById(employee);
        ThreadLocalLong.removeLong();
        return R.success("员工信息更新成功！");
    }

    @GetMapping("/{id}")
    public R<Employee> getEmployee(@PathVariable("id") Long id){ //@PathVariable必不可少，不然匹配不上路径上的参数
        Employee byId = iEmployeeService.getById(id);
        return R.success(byId);
    }

}
