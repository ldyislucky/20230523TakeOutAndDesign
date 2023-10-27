package com.ldy.mpp.domain.dto;

import lombok.Data;

import java.util.List;

/**
 * 封装的页面展示信息结果
 */
@Data
public class PageDTO<T> {
    //条数
    private long total;
    //页码
    private long pages;
    //结果集合
    private List<T> list;
}
