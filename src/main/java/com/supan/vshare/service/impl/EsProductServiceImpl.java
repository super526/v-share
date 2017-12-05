//package com.supan.vshare.service.impl;
//
//import com.supan.vshare.model.es.EsProduct;
//import com.supan.vshare.rep.EsProductRep;
//import com.supan.vshare.service.EsProductService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.PageRequest;
//import org.springframework.data.domain.Pageable;
//import org.springframework.data.domain.Sort;
//import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
//import org.springframework.stereotype.Service;
//
///**
// * EsProduct 服务接口
// * @Author supan
// * @Date 2017/9/18 11:15
// * @Copyright(c) gome inc Gome Co.,LTD
// */
//@Service
//public class EsProductServiceImpl implements EsProductService {
//    @Autowired
//    private ElasticsearchTemplate elasticsearchTemplate;
//    @Autowired
//    private EsProductRep esProductRep;
//
//    @Override
//    public EsProduct updateEsProduct(EsProduct esProduct) {
//        return esProductRep.save(esProduct);
//    }
//
//    @Override
//    public Page<EsProduct> listNewestEsProducts(String keyword, Pageable pageable) {
////        elasticsearchTemplate.putMapping(EsProduct.class);
//        Page<EsProduct> pages = null;
//        Sort sort = new Sort(Sort.Direction.DESC,"createTime");
//        if (pageable.getSort() == null) {
//            pageable = new PageRequest(pageable.getPageNumber(), pageable.getPageSize(), sort);
//        }
//        pages = esProductRep.findDistinctEsProductByProductNameContainingOrProductDavNameContainingOrProductDescContainingOrProductCategoryContaining(keyword,keyword,keyword,keyword, pageable);
//        return pages;
//    }
//
////    @Override
////    public EsProduct getEsProductByProductId(Integer productId) {
////        return esProductRep.findByProductId(productId);
////    }
//}
