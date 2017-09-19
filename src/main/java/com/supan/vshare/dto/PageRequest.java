package com.supan.vshare.dto;

import lombok.Data;

/**
 * @Author supan
 * @Date 2017/7/21 18:21
 * @Copyright(c) gome inc Gome Co.,LTD
 */

@Data
public class PageRequest<T> extends BaseDto {

//    //结果集
//    private List<T> list;
    //页大小
    private int pageSize=10;
    //当前页码
    private int pageNum=1;
    //总记录数
    private long total;
    //总页数
    private int pages;

}
