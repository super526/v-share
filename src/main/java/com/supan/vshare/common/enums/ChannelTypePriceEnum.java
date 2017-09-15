package com.supan.vshare.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

/**
 * 渠道信息枚举
 *
 * @author supan
 */
@Getter
@ToString
@AllArgsConstructor
public enum ChannelTypePriceEnum {
  GM(0,"国美"),
  JD(1,"京东"),
  SNYG(2,"苏宁易购");
  /**
   * 渠道类型
   */
  private Integer type;
  /**
   * 渠道名称
   */
  private String channelName;

  public static ChannelTypePriceEnum getChnnByType(Integer channelType) {
    for (ChannelTypePriceEnum codeEnum : ChannelTypePriceEnum.values()) {
      if (channelType.equals(codeEnum .getType())) {
        return codeEnum;
      }
    }
    return null;
  }

}
