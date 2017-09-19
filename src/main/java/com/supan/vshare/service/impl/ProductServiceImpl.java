package com.supan.vshare.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.supan.vshare.core.AbstractService;
import com.supan.vshare.dto.request.ProductReq;
import com.supan.vshare.mapper.ProductMapper;
import com.supan.vshare.mapper.StatisticsMapper;
import com.supan.vshare.model.Product;
import com.supan.vshare.model.Statistics;
import com.supan.vshare.model.es.EsProduct;
import com.supan.vshare.service.EsProductService;
import com.supan.vshare.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

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
    @Resource
    private StatisticsMapper mapper;
    @Override
    public void save(Product model) {
        super.save(model);
    }

    @Override
    public void save(List<Product> products) {
        products.forEach(item -> {
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

    /**
     * 多条件--分页查询
     *
     * @param productReq
     * @return
     */
    @Override
    public PageInfo queryPageList(ProductReq productReq) {
        /**记录用户的访问时,同时记录用户操作类型(网站访问量,搜索量)的数据*/
        Statistics statistics = mapper.selectByPrimaryKey(productReq.getSeachType());
        statistics.setNum(statistics.getNum()+1);
        mapper.updateByPrimaryKeySelective(statistics);
        Example example = new Example(Product.class);
        example.setDistinct(true);
        Example.Criteria criteria = example.createCriteria();
        /**根据商品名称和大V名称来查询商品*/
        criteria.andLike("productDavName","%"+productReq.getProductDavName()+"%")
                .andLike("productName", productReq.getProductName())
                .andLike("productDesc", productReq.getProductDesc())
                .andEqualTo("productCategory", productReq.getProductCategory());
        /**根据创建时间倒叙排列*/
        example.orderBy("createTime").desc();
        PageHelper.startPage(productReq.getPageNum(), productReq.getPageSize());
        List<Product> lists = productMapper.selectByExample(example);
        PageInfo<Product> pageInfo = new PageInfo<>(lists);
        return pageInfo;
    }
}
