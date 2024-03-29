package com.ldy.mpp.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.handlers.JacksonTypeHandler;
import lombok.Data;

/**
 * @author : ldy
 * @version : 1.0
 */
@Data
@TableName("users")//代表会映射数据库中的 users 表，去掉这个注解会报错
public class Users {
    private Integer id          ;  //integer可以映射数据库中的空值，int不行
    private String username    ;
    private String birthday    ;
    private String sex         ;
    private String address     ;
    private Integer balance;
    private Character status;
    private Double minBalance;
    private Double maxBalance;
}
