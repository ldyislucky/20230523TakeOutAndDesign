package com.ldy.reggie.service.impl;

import com.baomidou.mybatisplus.extension.conditions.query.LambdaQueryChainWrapper;
import com.baomidou.mybatisplus.extension.toolkit.Db;
import com.ldy.reggie.dto.SetmealDTO;
import com.ldy.reggie.entity.Dish;
import com.ldy.reggie.entity.Setmeal;
import com.ldy.reggie.entity.SetmealDish;
import com.ldy.reggie.mapper.SetmealMapper;
import com.ldy.reggie.service.IDishService;
import com.ldy.reggie.service.ISetmealService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <p>
 * 套餐 服务实现类
 * </p>
 *
 * @author author
 * @since 2023-11-09
 */
@Service
public class SetmealServiceImpl extends ServiceImpl<SetmealMapper, Setmeal> implements ISetmealService {

    @Transactional
    @Override
    public void addSetmealDTO(SetmealDTO setmealDTO) {
        this.save(setmealDTO);
        Setmeal setmeal = lambdaQuery().eq(Setmeal::getName, setmealDTO.getName()).one();
        Long setmealId = setmeal.getId();
        List<SetmealDish> setmealDishes = setmealDTO.getSetmealDishes();
        /**
         * db是mybatisplus版本3.5之后才有的
         */
        for (SetmealDish setmealDish : setmealDishes) {
            setmealDish.setSetmealId(setmealId.toString());
        }
        Db.saveOrUpdateBatch(setmealDishes);
    }
}
