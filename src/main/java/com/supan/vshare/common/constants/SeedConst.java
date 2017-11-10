package com.supan.vshare.common.constants;

public interface SeedConst {

  /**
   * 系统名称
   */
  String SYSYEM_NAME = "GSR";
  /**
   * 匹配时间正则
   */
  String REGEX_DATE = "\\d{4}-\\d{2}-\\d{2}T\\d{2}:\\d{2}:\\d{2}Z";

  String REGEX_DATE_REGISTER = "Creation Date: \\d{4}-\\d{2}-\\d{2}T\\d{2}:\\d{2}:\\d{2}";
  String REGEX_DATE_EXPIRY = "Registry Expiry Date: \\d{4}-\\d{2}-\\d{2}T\\d{2}:\\d{2}:\\d{2}";

  /**
   * domain查询接口
   */
  String REMOTE_ACCESS_URL = "http://whois.wang/whois/?domainName=";
  /**
   * 匹配名称正则
   */
  String REGEX_NAME = "Registrant Name: .{3}";
  /**
   * 默认门店代码
   */
  String DEFAULT_SITE_CODE = "SITE888";
  /**
   * 商品编码前缀位数
   */
  Integer GOODS_CODE_PREFIX_NUM = 9;
  /**
   * 全国统一价销售组织代码
   */
  String UNITY_SALE_ORG = "GOME";
  /**
   * 自定义渠道
   */
  String[] CUSTOM_CHANNEL = {"A01", "A02"};
  /**
   * 连接符号
   */
  String HYPHEN = "-";
  /**
   * 逗号
   */
  String COMMA = ",";
  /**
   * 冒号
   */
  String COLON = ":";
  /**
   * 冒号
   */
  String LIKE_PERCENT = "%";
  /**
   * 单位-元
   */
  String UNIT_CNY = "CNY";
  /**
   * 返回code-警告
   */
  String RESULT_CODE_WARNING = "2";
  /**
   * 返回code-正常
   */
  String RESULT_CODE_SUCCESS = "1";
  /**
   * 返回message-成功
   */
  String RESULT_MESSAGE_SUCCESS = "成功";
  /**
   * 返回code-异常
   */
  String RESULT_CODE_FAILURE = "0";
  /**
   * 2007版本后Excel文件的后缀
   */
  String EXCEL_SUFFIX = ".xlsx";
  /**
   * 价格对比excel导出模版名称
   */
  String REPORT_EXCEL_TEMPLATE = "DOMAIN_TEMPLATE_REPORT";

  Integer RECIEVE_STATUS_INIT = 0;

  Integer RECIEVE_STATUS_SUCCESS = 1;

  Integer RECIEVE_STATUS_PROCESS = 2;

  String DOMAIN_EXCEL_TEMPLATE = "DOMAIN_TEMPLATE_REPORT.xlsx" ;
}
