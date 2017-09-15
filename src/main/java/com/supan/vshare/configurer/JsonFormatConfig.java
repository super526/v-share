package com.supan.vshare.configurer;

import com.supan.vshare.component.validator.SeedMethodValidationPostProcessor;
import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;
import com.google.gson.GsonBuilder;
import org.springframework.boot.autoconfigure.web.HttpMessageConverters;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.GsonHttpMessageConverter;

/**
 * json 相关自定义配置
 * @author supan
 * @date 2017年8月16日, AM 11:32:12
 */
@Configuration
public class JsonFormatConfig {

  /*配置json的解析*/
  @Bean
  public HttpMessageConverters GsonHttpMessageConverter() {
    GsonHttpMessageConverter converter = new GsonHttpMessageConverter();
    converter.setGson(new GsonBuilder()
        // null序列化
        .serializeNulls()
        // 不转义html
        .disableHtmlEscaping()
        // 自定义忽略策略
        .setExclusionStrategies(new ExclusionStrategy() {
          @Override
          public boolean shouldSkipField(FieldAttributes f) {
            // 跳过规则json规则
            return false;
          }

          @Override
          public boolean shouldSkipClass(Class<?> clazz) {
            return false;
          }
        }).create());
    HttpMessageConverter<?> httpMessageConverters = converter;
    return new HttpMessageConverters(httpMessageConverters);
  }

  @Bean
  public SeedMethodValidationPostProcessor methodValidationPostProcessor() {
    return new SeedMethodValidationPostProcessor();
  }
}
