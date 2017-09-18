package com.supan.vshare.service;

import com.supan.vshare.model.es.EsProduct;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * EsProduct服务接口
 * @Author supan
 * @Date 2017/9/18 11:15
 * @Copyright(c) gome inc Gome Co.,LTD
 */
public interface EsProductService {
    /**
     * 更新 EsProduct
     * @param esProduct
     * @return
     */
    EsProduct updateEsProduct(EsProduct esProduct);

    /**
     * 根据id获取Product
     * @param productId
     * @return
     */
   // EsProduct getEsProductByProductId(Integer productId);
    /**
     * 最新博客列表，分页
     * @param keyword
     * @param pageable
     * @return
     */
    Page<EsProduct> listNewestEsProducts(String keyword, Pageable pageable);
}
