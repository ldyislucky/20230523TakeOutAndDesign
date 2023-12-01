package com.ldy.reggie.service;

import com.ldy.reggie.common.R;
import com.ldy.reggie.dto.SetmealDTO;
import com.ldy.reggie.entity.Setmeal;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 套餐 服务类
 * </p>
 *
 * @author author
 * @since 2023-11-09
 */
public interface ISetmealService extends IService<Setmeal> {

    void addSetmealDTO(SetmealDTO setmealDTO);

    R<SetmealDTO> getSetmealDTO(long id);
}
