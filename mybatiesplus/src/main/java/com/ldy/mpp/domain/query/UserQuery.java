package com.ldy.mpp.domain.query;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author : ldy
 * @version : 1.0
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class UserQuery extends PageQuery {
    private String  username;
    private Integer  status;
    private Double  minBalance;
    private Double  maxBalance;
}
