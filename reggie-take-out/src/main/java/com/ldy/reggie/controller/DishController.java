package com.ldy.reggie.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ldy.reggie.common.R;
import com.ldy.reggie.dto.DishDTO;
import com.ldy.reggie.entity.Dish;
import com.ldy.reggie.entity.DishFlavor;
import com.ldy.reggie.service.IDishFlavorService;
import com.ldy.reggie.service.IDishService;
import com.xiaoleilu.hutool.bean.BeanUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    private final IDishFlavorService iDishFlavorService;
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

    @PostMapping
    public R<String> addDishDTO(@RequestBody DishDTO dishDTO){
//        Dish dish = new Dish();
//        BeanUtil.copyProperties(dishDTO,dish);
//        List<DishFlavor> dishFlavorList = dishDTO.getFlavors();
//        iDishService.save(dishDTO);
//        Long dishId = iDishService.getByName(dishDTO.getName());
//        for (DishFlavor dishFlavor : dishFlavorList){
//            dishFlavor.setDishId(dishId);
//        }
//        iDishFlavorService.saveBatch(dishFlavorList);
//        System.out.println(dishFlavorList);
        iDishService.addDishDTO(dishDTO);
        return R.success("菜品添加成功！");
    }
}
