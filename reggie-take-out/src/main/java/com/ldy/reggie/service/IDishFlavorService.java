package com.ldy.reggie.service;

import com.ldy.reggie.entity.DishFlavor;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 菜品口味关系表 服务类
 * </p>
 *
 * @author author
 * @since 2023-11-10
 */
public interface IDishFlavorService extends IService<DishFlavor> {

    List<DishFlavor> getByDishId(Long id);
}
