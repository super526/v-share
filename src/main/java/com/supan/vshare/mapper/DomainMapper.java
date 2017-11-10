package com.supan.vshare.mapper;

import com.supan.vshare.core.Mapper;
import com.supan.vshare.model.DomainInfo;
import org.apache.ibatis.annotations.Delete;

public interface DomainMapper extends Mapper<DomainInfo> {

    @Delete("DELETE FROM domain_info")
    void deleteAll();
}