package com.supan.vshare.service.impl;

import com.supan.vshare.dao.ProductDavMapper;
import com.supan.vshare.model.ProductDav;
import com.supan.vshare.service.ProductDavService;
import com.supan.vshare.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by supan on 2017-09-15 12:43:26.
 */
@Service
@Transactional
public class ProductDavServiceImpl extends AbstractService<ProductDav> implements ProductDavService {
    @Resource
    private ProductDavMapper productDavMapper;

}
