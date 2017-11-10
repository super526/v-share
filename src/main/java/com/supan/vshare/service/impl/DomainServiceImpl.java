package com.supan.vshare.service.impl;

import com.supan.vshare.core.AbstractService;
import com.supan.vshare.mapper.DomainMapper;
import com.supan.vshare.model.DomainInfo;
import com.supan.vshare.service.DomainService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by supan on 2017-09-15 12:43:26.
 */
@Service
@Transactional
public class DomainServiceImpl extends AbstractService<DomainInfo> implements DomainService {
    @Resource
    private DomainMapper domainMapper;

    @Override
    public void deleteAll() {
        domainMapper.deleteAll();
    }
}
