package com.ldy.reggie.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ldy.reggie.common.R;
import com.ldy.reggie.dto.SetmealDTO;
import com.ldy.reggie.entity.Setmeal;
import com.ldy.reggie.service.ISetmealService;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 套餐 前端控制器
 * </p>
 *
 * @author author
 * @since 2023-11-09
 */
@RestController
@RequestMapping("/setmeal")
@RequiredArgsConstructor
public class SetmealController {

    private final ISetmealService iSetmealService;

    @GetMapping("/page")
    public R<Page<Setmeal>> getPage(Integer page,Integer pageSize){
        Page<Setmeal> setmealPage = new Page<>(page, pageSize);
        iSetmealService.page(setmealPage);
        return R.success(setmealPage);
    }
    @GetMapping("{id}")//这种请求方式@PathVariable("id")必不可少，不然路径匹配不上
    public R<SetmealDTO> getSetmealDTO(@PathVariable("id") long id){
        return iSetmealService.getSetmealDTO(id);
    }
    @PostMapping
    public R<String> addSetmealDTO(@RequestBody SetmealDTO setmealDTO){
        iSetmealService.addSetmealDTO(setmealDTO);
        return R.success("新增套餐成功！");
    }
    @PutMapping
    public R<String> updateSetmealDTO(@RequestBody SetmealDTO setmealDTO){
        iSetmealService.updateSetmealDTO(setmealDTO);
        return R.success("修改套餐成功！");
    }

}
