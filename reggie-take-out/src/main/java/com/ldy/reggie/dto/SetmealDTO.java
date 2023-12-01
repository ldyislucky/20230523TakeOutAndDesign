package com.ldy.reggie.dto;

import com.ldy.reggie.entity.Dish;
import com.ldy.reggie.entity.Setmeal;
import com.ldy.reggie.entity.SetmealDish;
import lombok.Data;

import java.util.List;

@Data
public class SetmealDTO extends Setmeal {
    private List<SetmealDish> setmealDishes;
}
