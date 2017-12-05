package com.supan.vshare.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.supan.vshare.core.Result;
import com.supan.vshare.core.ResultGenerator;
import com.supan.vshare.dto.request.HttpRequest;
import com.supan.vshare.dto.request.ProductReq;
import com.supan.vshare.model.Product;
import com.supan.vshare.service.OperationService;
import com.supan.vshare.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
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
//    @Resource
//    private EsProductService esProductService;
    @Autowired
    private OperationService operationService;

    /**
     * 添加商品时,同步向商品索引库中添加商品数据
     *
     * @param product
     * @return
     */
    @PostMapping
    public Result add(Product product) {
        productService.save(product);
        return ResultGenerator.genSuccessResult();
    }

    /**
     * 批量写入商品数据
     *
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

    @PostMapping("/query")
    public Result queryPageList(@RequestBody ProductReq productReq) {
        PageInfo pageInfo  = productService.queryPageList(productReq);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

    /***
     * es 模糊查询商品数据
     * @param order
     * @param keyword
     * @param pageIndex
     * @param pageSize
     * @return
     */
//    @GetMapping("/list")
//    public Page<EsProduct> listEsProducts(
//            @RequestParam(value = "order", required = false, defaultValue = "new") String order,
//            @RequestParam(value = "keyword", required = false, defaultValue = "") String keyword,
//            @RequestParam(value = "pageIndex", required = false, defaultValue = "0") int pageIndex,
//            @RequestParam(value = "pageSize", required = false, defaultValue = "10") int pageSize
//    ) {
//        Page<EsProduct> page = null;
//        if (order.equals("new")) { // 最新查询
//            Sort sort = new Sort(Direction.DESC, "createTime");
//            Pageable pageable = new PageRequest(pageIndex, pageSize, sort);
//            page = esProductService.listNewestEsProducts(keyword, pageable);
//        }
//        return page;
//    }


}
