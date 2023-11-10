package com.ldy.reggie.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ldy.reggie.common.R;
import com.ldy.reggie.entity.Category;
import com.ldy.reggie.service.ICategoryService;
import com.ldy.reggie.service.IEmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 菜品及套餐分类 前端控制器
 * </p>
 *
 * @author author
 * @since 2023-11-08
 */
@RestController
@RequestMapping("/category")
@RequiredArgsConstructor
public class CategoryController {
    private final ICategoryService iCategoryService;
    @GetMapping("/page")
    public R<Page<Category>> getPage(Integer page,Integer pageSize){
        Page<Category> categoryPage = new Page<>(page,pageSize);
        OrderItem sort = new OrderItem("sort", true);
        categoryPage.addOrder(sort);
        iCategoryService.page(categoryPage);
        return R.success(categoryPage);
    }
    @PostMapping
    public R<String> addCategory(@RequestBody Category category){
        iCategoryService.save(category);
        return R.success("分类添加成功!");
    }
    @PutMapping
    public R<String> updateCategory(@RequestBody Category category){
        Category category1 = iCategoryService.current(category);
        category.setId(category1.getId());
        iCategoryService.updateById(category);
        return R.success("修改成功！");
    }
    @GetMapping("/list")
    public R<List<Category>> getListByType(Integer type){
        LambdaQueryWrapper<Category> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Category::getType,type )
                .orderByAsc(Category::getSort)
                .orderByAsc(Category::getName);
        List<Category> list = iCategoryService.list(wrapper);
        return R.success(list);
    }

}
