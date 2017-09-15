package com.supan.vshare.service.impl;

import com.supan.vshare.dao.ProductMapper;
import com.supan.vshare.model.Product;
import com.supan.vshare.service.ProductService;
import com.supan.vshare.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by supan on 2017-09-15 12:43:26.
 */
@Service
@Transactional
public class ProductServiceImpl extends AbstractService<Product> implements ProductService {
    @Resource
    private ProductMapper productMapper;

}
