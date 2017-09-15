package com.supan.vshare.rep;

import com.supan.vshare.model.es.EsProduct;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * 商品 检索库
 * @Author supan
 * @Date 2017/9/15 16:08
 * @Copyright(c) gome inc Gome Co.,LTD
 */
public interface EsProductRep extends ElasticsearchRepository<EsProduct,String> {
}
