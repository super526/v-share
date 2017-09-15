package com.supan.vshare.service.impl;

import com.supan.vshare.mapper.OperationMapper;
import com.supan.vshare.mapper.StatisticsMapper;
import com.supan.vshare.model.Operation;
import com.supan.vshare.model.Statistics;
import com.supan.vshare.service.OperationService;
import com.supan.vshare.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by supan on 2017-09-15 12:43:26.
 */
@Service
@Transactional
public class OperationServiceImpl extends AbstractService<Operation> implements OperationService {
    @Resource
    private OperationMapper operationMapper;
    @Resource
    private StatisticsMapper mapper;

    @Override
    public void save(Operation model) {
        /**记录用户的访问时,同时记录用户操作类型(网站访问量,搜索量)的数据*/
        Statistics statistics = mapper.selectByPrimaryKey(model.getTypeid());
        statistics.setNum(statistics.getNum()+1);
        mapper.updateByPrimaryKeySelective(statistics);
        super.save(model);
    }
}
