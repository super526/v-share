package com.supan.vshare.dto.request;

import com.supan.vshare.model.DomainInfo;
import lombok.Data;

import java.util.List;

/**
 * @Author supan
 * @Date 2017/11/9 19:25
 * @Copyright(c) gome inc Gome Co.,LTD
 */
@Data
class DomainReq {
   private List<DomainInfo> domains;
}
