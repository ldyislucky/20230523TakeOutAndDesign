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
    private int id          ;
    private String username    ;
    private String birthday    ;
    private String sex         ;
    private String address     ;
    private int balance;
    private char status;
    private double minBalance;
    private double maxBalance;
}
