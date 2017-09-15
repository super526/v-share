package com.supan.vshare.controller;

import com.supan.vshare.core.Result;
import com.supan.vshare.core.ResultGenerator;
import com.supan.vshare.model.ProductDav;
import com.supan.vshare.service.ProductDavService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
* Created by supan on 2017-09-15 12:49:26.
*/
@RestController
@RequestMapping("/product/dav")
public class ProductDavController {
    @Resource
    private ProductDavService productDavService;

    @PostMapping
    public Result add(ProductDav productDav) {
        productDavService.save(productDav);
        return ResultGenerator.genSuccessResult();
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        productDavService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PutMapping
    public Result update(ProductDav productDav) {
        productDavService.update(productDav);
        return ResultGenerator.genSuccessResult();
    }
    @GetMapping("/{id}")
    public Result detail(@PathVariable Integer id) {
        ProductDav productDav = productDavService.findById(id);
        return ResultGenerator.genSuccessResult(productDav);
    }

    @GetMapping
    public Result list(Integer page, Integer size) {
        PageHelper.startPage(page, size);
        List<ProductDav> list = productDavService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
}
