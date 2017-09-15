package com.supan.vshare.controller;

import com.supan.vshare.common.utils.AccessRemoteIPUtil;
import com.supan.vshare.core.Result;
import com.supan.vshare.core.ResultGenerator;
import com.supan.vshare.model.Operation;
import com.supan.vshare.service.OperationService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
* Created by supan on 2017-09-15 12:49:26.
*/
@RestController
@RequestMapping("/operation")
public class OperationController {
    @Resource
    private OperationService operationService;

    @GetMapping("/add")
    public Result add(@RequestParam Integer typeid, HttpServletRequest request) {
        String ipAddress = AccessRemoteIPUtil.getIpAddress(request);
        Operation operation = new Operation();
        operation.setIp(ipAddress);
        operation.setTypeid(typeid);
        operationService.save(operation);
        return ResultGenerator.genSuccessResult();
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        operationService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PutMapping
    public Result update(Operation operation) {
        operationService.update(operation);
        return ResultGenerator.genSuccessResult();
    }
    @GetMapping("/{id}")
    public Result detail(@PathVariable Integer id) {
        Operation operation = operationService.findById(id);
        return ResultGenerator.genSuccessResult(operation);
    }

    @GetMapping
    public Result list(Integer page, Integer size) {
        PageHelper.startPage(page, size);
        List<Operation> list = operationService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
}
