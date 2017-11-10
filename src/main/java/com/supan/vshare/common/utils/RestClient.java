package com.supan.vshare.common.utils;

import com.supan.vshare.common.constants.SeedConst;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;

/**
 * @Author supan
 * @Date 2017/11/9 19:36
 * @Copyright(c) gome inc Gome Co.,LTD
 */
@Component
@Slf4j
public class RestClient {
    @Autowired
    private RestTemplate restTemplate;

    private static RestTemplate client;

    @PostConstruct
    public void init() {
        client = this.restTemplate;
    }

    /**
     * 根据域名名称，获取域名信息
     *
     * @param domainName 域名名称
     */
    public static String getDomainInfoByDoName(String domainName) {
        try {
            String url = SeedConst.REMOTE_ACCESS_URL +  domainName;
            return client.getForObject(url, String.class);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    public static void main(String[] args) {
        String doName = getDomainInfoByDoName("给排水设备.商城\n");
        System.out.println(doName);
    }
}
