package com.ldy.reggie.service.impl;

import com.baomidou.mybatisplus.extension.conditions.query.LambdaQueryChainWrapper;
import com.ldy.reggie.entity.DishFlavor;
import com.ldy.reggie.mapper.DishFlavorMapper;
import com.ldy.reggie.service.IDishFlavorService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 菜品口味关系表 服务实现类
 * </p>
 *
 * @author author
 * @since 2023-11-10
 */
@Service
public class DishFlavorServiceImpl extends ServiceImpl<DishFlavorMapper, DishFlavor> implements IDishFlavorService {

    @Override
    public List<DishFlavor> getByDishId(Long id) {
        List<DishFlavor> list = lambdaQuery().eq(DishFlavor::getDishId, id).list();
        return list;
    }
}
