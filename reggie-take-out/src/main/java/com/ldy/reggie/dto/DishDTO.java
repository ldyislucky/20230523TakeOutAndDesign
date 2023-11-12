package com.ldy.reggie.dto;

import com.ldy.reggie.entity.Dish;
import com.ldy.reggie.entity.DishFlavor;
import lombok.Data;

import java.util.List;

@Data
public class DishDTO extends Dish {
    private List<DishFlavor> flavors;
}
