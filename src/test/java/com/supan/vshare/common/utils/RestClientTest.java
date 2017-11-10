package com.supan.vshare.common.utils;

import com.conpany.project.Tester;
import com.google.gson.Gson;
import com.supan.vshare.model.DomainInfo;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @Author supan
 * @Date 2017/11/10 10:15
 * @Copyright(c) gome inc Gome Co.,LTD
 */
@Slf4j
public class RestClientTest extends Tester {
    @Test
    public void getDomainInfoByDoName() throws Exception {
        String doName = RestClient.getDomainInfoByDoName("珍宝岛药业.商城");
        DomainInfo domainInfo = StringCovert.setDomainInfo(new DomainInfo(), doName);
        log.info("data is {}",new Gson().toJson(domainInfo));
//        System.out.println(doName);
    }

}