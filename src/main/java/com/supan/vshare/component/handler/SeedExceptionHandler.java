package com.supan.vshare.component.handler;


import com.supan.vshare.common.enums.ErrorMsgEnum;
import com.supan.vshare.common.exception.SeedException;
import com.supan.vshare.common.exception.SeedParamException;
import com.supan.vshare.dto.response.SeedResp;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * 报表系统错误异常统一处理
 */
@Slf4j
@ControllerAdvice
public class SeedExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public SeedResp handleException(Exception e) {
        log.error("服务调用错误,错误信息为：{}", e);
        if (e instanceof SeedParamException) {
            return SeedResp.fail(e.getMessage());
        } else if (e instanceof SeedException) {
            return SeedResp.fail((SeedException) e);
        } else {
            log.error(e.getMessage(), e);
            return SeedResp.fail(ErrorMsgEnum.INTERNAL_SERVER_ERROR);
        }
    }

}
