package com.ldy.reggie.service;

import com.ldy.reggie.common.R;
import com.ldy.reggie.dto.DishDTO;
import com.ldy.reggie.entity.Dish;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 菜品管理 服务类
 * </p>
 *
 * @author author
 * @since 2023-11-08
 */
public interface IDishService extends IService<Dish> {

    Long getByName(String name);

    void addDishDTO(DishDTO dishDTO);

    R<List<Dish>> getdishList(Long categoryId);
}
