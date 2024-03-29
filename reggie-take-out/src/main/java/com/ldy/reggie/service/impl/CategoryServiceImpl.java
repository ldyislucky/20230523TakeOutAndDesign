package com.ldy.reggie.service.impl;

import com.ldy.reggie.common.R;
import com.ldy.reggie.entity.Category;
import com.ldy.reggie.mapper.CategoryMapper;
import com.ldy.reggie.service.ICategoryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 菜品及套餐分类 服务实现类
 * </p>
 *
 * @author author
 * @since 2023-11-08
 */
@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements ICategoryService {

    @Override
    public Category current(Category category) {
        return lambdaQuery().eq(Category::getName, category.getName()).one();
    }

    @Override
    public R<List<Category>> getListByType(Integer type) {
        List<Category> list = lambdaQuery().eq(Category::getType, type).list();
        return R.success(list);
    }
}
