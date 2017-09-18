package com.supan.vshare.service.impl;

import com.supan.vshare.core.AbstractService;
import com.supan.vshare.mapper.ProductMapper;
import com.supan.vshare.model.Product;
import com.supan.vshare.model.es.EsProduct;
import com.supan.vshare.service.EsProductService;
import com.supan.vshare.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;


/**
 * Created by supan on 2017-09-15 12:43:26.
 */
@Service
@Transactional
public class ProductServiceImpl extends AbstractService<Product> implements ProductService {
    @Resource
    private ProductMapper productMapper;
    @Autowired
    private EsProductService esProductService;

    @Override
    public void save(Product model) {
        super.save(model);
    }

    @Override
    public void save(List<Product> products) {
        products.forEach(item->{
            EsProduct esProduct = new EsProduct(item);
 //           BeanUtils.copyProperties(item,esProduct);
//            esProduct.setProductId(8888);
//            esProduct.setProductNm(item.getProductName());
//            esProduct.setProductDavNm(item.getProductDavName());
//            esProduct.setProductDesc(item.getProductDesc());
//            esProduct.setProductCat(item.getProductCategory());
            /**添加商品数据到--es索引库*/
            esProductService.updateEsProduct(esProduct);
        });
        super.save(products);
    }
}
