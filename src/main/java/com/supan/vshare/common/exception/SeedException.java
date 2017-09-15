package com.supan.vshare.common.exception;


import com.supan.vshare.common.enums.ErrorMsgEnum;
import lombok.Data;


/**
 * 报表系统统一业务异常
 *
 * @author yanliwei
 * @data 2017年7月31日, AM 10:31:14
 */
@Data
public class SeedException extends RuntimeException {

  private String code;
  private String msg;

  public SeedException() {
    super();
  }

  public SeedException(Throwable throwable) {
    super(throwable);
  }

  public SeedException(String code, String msg) {
    super(msg);
    this.code = code;
    this.msg = msg;
  }


  public SeedException(ErrorMsgEnum msgEnum) {
    super(msgEnum.getMessage());
    this.code = msgEnum.getCode();
    this.msg = msgEnum.getMessage();
  }

}
