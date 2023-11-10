package com.ldy.reggie.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ldy.reggie.common.R;
import com.ldy.reggie.entity.Dish;
import com.ldy.reggie.service.IDishService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 菜品管理 前端控制器
 * </p>
 *
 * @author author
 * @since 2023-11-08
 */
@RestController
@RequestMapping("/dish")
@RequiredArgsConstructor
public class DishController {
    private final IDishService iDishService;
    @GetMapping("/page")
    public R<Page<Dish>> getPage(Integer page,Integer pageSize){
        Page<Dish> dishPage = new Page<>(page,pageSize);
        iDishService.page(dishPage);
        return R.success(dishPage);
    }
    @GetMapping("/{id}")
    public R<Dish> getById(@PathVariable("id") Integer id){
        Dish dish = iDishService.getById(id);
        return R.success(dish);
    }

}
