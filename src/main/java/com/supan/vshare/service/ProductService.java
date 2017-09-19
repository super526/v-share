package com.supan.vshare.service;

import com.github.pagehelper.PageInfo;
import com.supan.vshare.core.Service;
import com.supan.vshare.dto.request.ProductReq;
import com.supan.vshare.model.Product;


/**
 * Created by supan on 2017-09-15 12:43:26.
 */
public interface ProductService extends Service<Product> {
     PageInfo queryPageList(ProductReq productReq);

}
