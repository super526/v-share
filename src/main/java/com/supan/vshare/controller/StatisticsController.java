package com.supan.vshare.controller;

import com.supan.vshare.core.Result;
import com.supan.vshare.core.ResultGenerator;
import com.supan.vshare.model.Statistics;
import com.supan.vshare.service.StatisticsService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
* Created by supan on 2017-09-15 12:49:26.
*/
@RestController
@RequestMapping("/statistics")
public class StatisticsController {
    @Resource
    private StatisticsService statisticsService;

    @PostMapping
    public Result add(Statistics statistics) {
        statisticsService.save(statistics);
        return ResultGenerator.genSuccessResult();
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        statisticsService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PutMapping
    public Result update(Statistics statistics) {
        statisticsService.update(statistics);
        return ResultGenerator.genSuccessResult();
    }
    @GetMapping("/{id}")
    public Result detail(@PathVariable Integer id) {
        Statistics statistics = statisticsService.findById(id);
        return ResultGenerator.genSuccessResult(statistics);
    }

    @GetMapping("/list")
    public Result list() {
        PageHelper.startPage(0, 10);
        List<Statistics> list = statisticsService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
}
