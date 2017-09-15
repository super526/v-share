package com.supan.vshare.controller;

import com.supan.vshare.core.Result;
import com.supan.vshare.core.ResultGenerator;
import com.supan.vshare.dto.request.HttpRequest;
import com.supan.vshare.model.Product;
import com.supan.vshare.service.ProductService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by supan on 2017-09-15 12:49:26.
 */
@RestController
@RequestMapping("/product")
public class ProductController {
    @Resource
    private ProductService productService;

    @PostMapping
    public Result add(Product product) {
        productService.save(product);
        return ResultGenerator.genSuccessResult();
    }

    /**
     * 批量写入商品数据
     * @param products
     * @return
     */
    @PostMapping("/save")
    public Result save(@RequestBody HttpRequest<List<Product>> products) {
        productService.save(products.getData());
        return ResultGenerator.genSuccessResult();
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        productService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PutMapping
    public Result update(Product product) {
        productService.update(product);
        return ResultGenerator.genSuccessResult();
    }

    @GetMapping("/{id}")
    public Result detail(@PathVariable Integer id) {
        Product product = productService.findById(id);
        return ResultGenerator.genSuccessResult(product);
    }

    @GetMapping
    public Result list(Integer page, Integer size) {
        PageHelper.startPage(page, size);
        List<Product> list = productService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
}
