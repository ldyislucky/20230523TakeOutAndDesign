package com.ldy.reggie.service.impl;

import com.ldy.reggie.dto.SetmealDTO;
import com.ldy.reggie.entity.SetmealDish;
import com.ldy.reggie.mapper.SetmealDishMapper;
import com.ldy.reggie.service.ISetmealDishService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 套餐菜品关系 服务实现类
 * </p>
 *
 * @author author
 * @since 2023-11-30
 */
@Service
public class SetmealDishServiceImpl extends ServiceImpl<SetmealDishMapper, SetmealDish> implements ISetmealDishService {

    @Override
    public void updateBatch(SetmealDTO setmealDTO) {
        List<SetmealDish> addList = setmealDTO.getSetmealDishes();
        String addSetmealId = setmealDTO.getId().toString();
        for (SetmealDish setmealDish : addList) {
            setmealDish.setSetmealId(addSetmealId);
        }
        Long setmealId = setmealDTO.getId();
        List<SetmealDish> removeList = lambdaQuery().eq(SetmealDish::getSetmealId, setmealId).list();
        this.removeBatchByIds(removeList);
        this.saveBatch(addList);
    }
}
