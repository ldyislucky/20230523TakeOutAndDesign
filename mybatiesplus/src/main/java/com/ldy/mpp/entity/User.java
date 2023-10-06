package com.ldy.mpp.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author : ldy
 * @version : 1.0
 */
@Data
@TableName("users")
public class User {
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
