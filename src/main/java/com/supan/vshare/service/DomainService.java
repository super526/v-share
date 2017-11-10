package com.supan.vshare.service;

import com.supan.vshare.core.Service;
import com.supan.vshare.model.DomainInfo;


/**
 * Created by supan on 2017-09-15 12:43:26.
 */
public interface DomainService extends Service<DomainInfo> {

    void deleteAll();


}
