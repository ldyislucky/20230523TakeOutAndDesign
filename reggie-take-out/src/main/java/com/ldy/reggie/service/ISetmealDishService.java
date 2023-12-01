package com.ldy.reggie.service;

import com.ldy.reggie.dto.SetmealDTO;
import com.ldy.reggie.entity.SetmealDish;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 套餐菜品关系 服务类
 * </p>
 *
 * @author author
 * @since 2023-11-30
 */
public interface ISetmealDishService extends IService<SetmealDish> {

    void updateBatch(SetmealDTO setmealDTO);
}
