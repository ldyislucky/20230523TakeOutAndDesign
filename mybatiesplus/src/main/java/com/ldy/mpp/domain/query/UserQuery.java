package com.ldy.mpp.domain.query;

import lombok.Data;

/**
 * @author : ldy
 * @version : 1.0
 */
@Data
public class UserQuery {
    private String  username;
    private Integer  status;
    private Double  minBalance;
    private Double  maxBalance;
}
