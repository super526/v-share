//package com.supan.vshare.rep;
//
//import com.supan.vshare.model.es.EsProduct;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.Pageable;
//import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
//import org.springframework.stereotype.Repository;
//
//
///**
// * 商品 存储库
// * @Author supan
// * @Date 2017/9/15 16:08
// * @Copyright(c) gome inc Gome Co.,LTD
// */
//@Repository
//public interface EsProductRep extends ElasticsearchRepository<EsProduct,String> {
//
//
//    /**
//     * 根据商品的信息 模糊查询(去重)
//     * @param productNm
//     * @param productDavNm
//     * @param productDesc
//     * @param productCat
//     * @param pageable
//     * @return
//     */
//    Page<EsProduct> findDistinctEsProductByProductNameContainingOrProductDavNameContainingOrProductDescContainingOrProductCategoryContaining(String productName, String productDavName, String productDesc, String productCategory, Pageable pageable);
//
//    /**
//     * 根据商品id查询商品
//     * @param productId
//     * @return
//     */
//   // EsProduct findByProductId(Integer productId);
//
//
//
//}
