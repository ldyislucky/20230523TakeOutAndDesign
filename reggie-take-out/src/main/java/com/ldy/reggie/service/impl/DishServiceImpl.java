package com.ldy.reggie.service.impl;

import com.ldy.reggie.dto.DishDTO;
import com.ldy.reggie.entity.Dish;
import com.ldy.reggie.entity.DishFlavor;
import com.ldy.reggie.mapper.DishMapper;
import com.ldy.reggie.service.IDishFlavorService;
import com.ldy.reggie.service.IDishService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.ibatis.javassist.compiler.ast.Variable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <p>
 * 菜品管理 服务实现类
 * </p>
 *
 * @author author
 * @since 2023-11-08
 */
@Service
public class DishServiceImpl extends ServiceImpl<DishMapper, Dish> implements IDishService {
    @Autowired
    private IDishFlavorService iDishFlavorService;
    @Override
    public Long getByName(String name) {
        Dish dish = lambdaQuery().eq(Dish::getName, name).one();
        return dish.getId();
    }
    @Transactional
    @Override
    public void addDishDTO(DishDTO dishDTO) {
        save(dishDTO);
        Long dishId = getByName(dishDTO.getName());
        List<DishFlavor> flavors = dishDTO.getFlavors();
        for (DishFlavor dishFlavor : flavors){
            dishFlavor.setDishId(dishId);
        }
        iDishFlavorService.saveBatch(flavors);
    }
}
