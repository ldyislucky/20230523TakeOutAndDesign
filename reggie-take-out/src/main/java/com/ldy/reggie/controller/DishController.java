package com.ldy.reggie.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ldy.reggie.common.R;
import com.ldy.reggie.dto.DishDTO;
import com.ldy.reggie.entity.Category;
import com.ldy.reggie.entity.Dish;
import com.ldy.reggie.entity.DishFlavor;
import com.ldy.reggie.service.ICategoryService;
import com.ldy.reggie.service.IDishFlavorService;
import com.ldy.reggie.service.IDishService;
import com.xiaoleilu.hutool.bean.BeanUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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
    private final ICategoryService iCategoryService;

    @GetMapping("/page")
    public R<Page<DishDTO>> getPage(Integer page,Integer pageSize){
        Page<Dish> dishPage = new Page<>(page,pageSize);
        Page<DishDTO> dishDTOPage = new Page<>();
        iDishService.page(dishPage);
        BeanUtil.copyProperties(dishPage,dishDTOPage,"records");
        List<Dish> dishList = dishPage.getRecords();
        List<Long> categoryidList = dishList.stream().map(Dish::getCategoryId).collect(Collectors.toList());
        List<Category> categoryList = iCategoryService.listByIds(categoryidList);
        Map<Long, String> map = categoryList.stream().collect(Collectors.toMap(Category::getId, Category::getName));
        ArrayList<DishDTO> dishDTOS = new ArrayList<>();
        for (Dish dish : dishList){
            DishDTO dishDTO = new DishDTO();
            BeanUtil.copyProperties(dish,dishDTO);
            dishDTO.setCategoryName(map.get(dish.getCategoryId()));
            dishDTOS.add(dishDTO);
        }
        dishDTOPage.setRecords(dishDTOS);
        return R.success(dishDTOPage);
    }
    @GetMapping("/{id}")
    public R<DishDTO> getById(@PathVariable("id") Long id){
        Dish dish = iDishService.getById(id);
        List<DishFlavor> dishFlavorList = iDishFlavorService.getByDishId(dish.getId());
        DishDTO dishDTO = new DishDTO();
        BeanUtil.copyProperties(dish,dishDTO);
        dishDTO.setFlavors(dishFlavorList);
        return R.success(dishDTO);
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
    @GetMapping("/list")
    public R<List<Dish>> getDishList(Long categoryId){
        return iDishService.getdishList(categoryId);
    }
}
