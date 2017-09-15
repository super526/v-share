package com.supan.vshare.dto.request;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author supan
 * @Date 2017/7/24 15:17
 * @Copyright(c) gome inc Gome Co.,LTD
 */
@Data
public class HttpRequest<T> implements Serializable {
    private T data;
}
