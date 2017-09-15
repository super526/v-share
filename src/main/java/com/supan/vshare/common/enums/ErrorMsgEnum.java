package com.supan.vshare.common.enums;
import lombok.Getter;

/**
 * 错误信息枚举类
 *
 * @author yanliwei
 * @2017年7月31日, PM 02:26:08
 */
@Getter
public enum ErrorMsgEnum {
    //参数异常错误码1XX,101开始
    ILLEGAL_ARGUMENT("101", "参数错误"),
    //业务异常错误码2XX,201开始
    CONDITION_TYPE_NOT_DEFINED("201", "条件类型未定义"),
    INTERNAL_SERVER_ERROR("99", "系统错误");
    private String code;
    private String message;

    ErrorMsgEnum(String code, String message){
        this.code = code;
        this.message = message;
    }
}
