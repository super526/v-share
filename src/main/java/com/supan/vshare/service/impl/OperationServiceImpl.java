package com.supan.vshare.service.impl;

import com.supan.vshare.dao.OperationMapper;
import com.supan.vshare.model.Operation;
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

}
