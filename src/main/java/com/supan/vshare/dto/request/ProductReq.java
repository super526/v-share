package com.supan.vshare.dto.request;

import com.supan.vshare.dto.PageRequest;
import com.supan.vshare.model.Product;
import lombok.Data;

/**
 * @Author supan
 * @Date 2017/9/18 16:48
 * @Copyright(c) gome inc Gome Co.,LTD
 */
@Data
public class ProductReq extends PageRequest<Product> {

    private String productName;//商品名称
    private String productDavName;//商品大V名称
    private String productCategory;//商品品类
    private String productDesc;//商品描述
    private Integer seachType;

}
