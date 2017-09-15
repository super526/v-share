package com.supan.vshare.service.impl;

import com.supan.vshare.mapper.StatisticsMapper;
import com.supan.vshare.model.Statistics;
import com.supan.vshare.service.StatisticsService;
import com.supan.vshare.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by supan on 2017-09-15 12:43:26.
 */
@Service
@Transactional
public class StatisticsServiceImpl extends AbstractService<Statistics> implements StatisticsService {
    @Resource
    private StatisticsMapper statisticsMapper;

}
