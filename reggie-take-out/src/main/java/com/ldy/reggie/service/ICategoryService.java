package com.ldy.reggie.service;

import com.ldy.reggie.common.R;
import com.ldy.reggie.entity.Category;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 菜品及套餐分类 服务类
 * </p>
 *
 * @author author
 * @since 2023-11-08
 */
public interface ICategoryService extends IService<Category> {

    Category current(Category category);

    R<List<Category>> getListByType(Integer type);
}
