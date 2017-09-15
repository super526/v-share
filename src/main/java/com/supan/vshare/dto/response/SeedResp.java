package com.supan.vshare.dto.response;


import com.supan.vshare.common.constants.SeedConst;
import com.supan.vshare.common.enums.ErrorMsgEnum;
import com.supan.vshare.common.exception.SeedException;
import lombok.Builder;

/**
 * Seed 系统统一响应对象
 */
@Builder
public class SeedResp<T> {

  /**
   * 应答码
   */
  private String code;
  /**
   * 应答消息
   */
  private String message;
  /**
   * 应答数据
   */
  private T data;

  public static <T> SeedResp success(T t) {
    return SeedResp.builder()
                      .data(t)
                      .code(SeedConst.RESULT_CODE_SUCCESS)
                      .message(SeedConst.RESULT_MESSAGE_SUCCESS)
                      .build();
  }

  public static <T> SeedResp fail(String errorMsg) {
    return SeedResp.builder()
                      .code(SeedConst.RESULT_CODE_FAILURE)
                      .message(errorMsg)
                      .build();
  }
  public static SeedResp fail(SeedException SeedException){
    return SeedResp.builder()
            .code(SeedException.getCode())
            .message(SeedException.getMessage())
            .build();
  }
  public static SeedResp fail(ErrorMsgEnum errorMsgEnum){
    return SeedResp.builder()
            .code(errorMsgEnum.getCode())
            .message(errorMsgEnum.getMessage())
            .build();
  }
}
