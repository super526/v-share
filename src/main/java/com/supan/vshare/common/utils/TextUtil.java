package com.supan.vshare.common.utils;

import org.apache.commons.lang3.StringUtils;

/**
 * 文字处理工具类。
 */
public class TextUtil {
    /**
     * 数值型转换成文字
     *
     * @param value Integer
     * @return value String
     */
    public static String convertIntegetToString(Integer value) {
        if (value == null) {
            return "";
        }
        return String.valueOf(value);
    }

    /**
     * double型转换成文字
     *
     * @param value Integer
     * @return value String
     */
    public static String convertDoubleToString(Double value) {
        if (value == null) {
            return "";
        }
        return String.valueOf(value);
    }

    /**
     * double型转换成文字
     *
     * @param value Integer
     * @return value String
     */
    public static double convertStringToDouble(String value) {
        if (StringUtils.isEmpty(value) || !NumUtil.isNumber(value)){
            return 0;
        }
        return Double.valueOf(value);
    }

    /**
     * 文字转换成数值型
     *
     * @param value Integer
     * @return value String
     */
    public static int convertStringToInteger(String value) {
        if (TextUtil.isNullTrim(value) || !NumUtil.isNumber(value)) {
            return 0;
        }
        return (int) Double.parseDouble(value);
    }

    /**
     * 文字转换成数值型
     *
     * @param value Integer
     * @return value String
     */
    public static Integer convertStringToIntegerForNull(String value) {
        if (TextUtil.isNullTrim(value) || !NumUtil.isInteger(value)) {
            return null;
        }
        return (int) Double.parseDouble(value);
    }

    /**
     * Null转换成空白文字
     *
     * @param value Integer
     * @return value String
     */
    public static String convertNullToString(String value) {
        if (value == null) {
            return "";
        }
        return value;
    }

    /**
     * 对象类转换成字符文字
     *
     * @param value Integer
     * @return value String
     */
    public static String convertToString(Object value) {
        if (value == null) {
            return "";
        }
        return value.toString().trim();
    }

    /**
     * 检查String的值是否是null或者空白文字(没有Trim)。<BR>
     *
     * @param asValue 检查字符串
     * @return null或者空白文字true，其他返回false。
     */
    public static boolean isNull(String asValue) {
        return asValue == null || asValue.length() == 0 || asValue.equals("null");
    }

    /**
     * 检查Trim处理之后String的值是否是null或者空白文字<BR>
     *
     * @param asValue 检查字符串
     * @return null或者空白文字true，其他返回false。
     */
    public static boolean isNullTrim(String asValue) {
        return isNull(asValue) || isNull(asValue.trim());
    }

    /**
     * 去除给定字符串前后的空字串。
     * <p/>
     * <li>去除指定字符串的前后指定类型的空白字符串。 <li>文字中的空白字符不会删除
     *
     * @param strVal String 需要进行处理的文字列
     * @param mode   int 需要去除的空白字串模式（0=仅仅去除全角空白 , 1=仅仅去除半角空白 , 2=全角，半角空白都去除）
     * @return String 去空白处理后的字符串
     */
    public static String trim(String strVal, int mode) {
        if (strVal == null) {
            return "";
        }
        if (2 < mode || mode < 0) {
            mode = 1;
        }

        return TextUtil.trimHead((TextUtil.trimTail(strVal, mode)), mode);
    }

    /**
     * 去除给定字符串之前的空字串。
     * <p/>
     * <li>去除指定字符串的前后指定类型的空白字符串。 <li>文字中的空白字符不会删除
     *
     * @param strVal String 需要进行处理的文字列
     * @param mode   int 需要去除的空白字串模式（0=仅仅去除全角空白 , 1=仅仅去除半角空白 , 2=全角，半角空白都去除）
     * @return String 去空白处理后的字符串
     */
    public static String trimHead(String strVal, int mode) {
        if (strVal == null) {
            return "";
        }
        if (2 < mode || mode < 0) {
            mode = 2;
        }

        boolean loopFlg = true;
        StringBuilder rtnVal = new StringBuilder("");

        char[] chars = strVal.toCharArray();

        if (mode == 0) {
            // 仅仅去除全角空白
            for (char aChar : chars) {
                if (aChar != '　' || !loopFlg) {
                    loopFlg = false;
                    rtnVal.append(aChar);
                }
            }
        } else if (mode == 1) {
            // 仅仅去除半角空白
            for (char aChar : chars) {
                if (aChar != ' ' || !loopFlg) {
                    rtnVal.append(aChar);
                    loopFlg = false;
                }
            }
        } else if (mode == 2) {
            // 全角，半角空白都去除
            for (char aChar : chars) {
                if ((aChar != ' ' && aChar != '　') || !loopFlg) {
                    rtnVal.append(aChar);
                    loopFlg = false;
                }
            }
        }

        return rtnVal.toString();
    }

    public static String trimAll(String strVal, int mode) {
        if (strVal == null) {
            return "";
        }
        if (2 < mode || mode < 0) {
            mode = 2;
        }

        StringBuilder rtnVal = new StringBuilder("");

        char[] chars = strVal.toCharArray();

        if (mode == 0) {
            // 仅仅去除全角空白
            for (char aChar : chars) {
                if (aChar != '　') {
                    rtnVal.append(aChar);
                }
            }
        } else if (mode == 1) {
            // 仅仅去除半角空白
            for (char aChar : chars) {
                if (aChar != ' ') {
                    rtnVal.append(aChar);
                }
            }
        } else if (mode == 2) {
            // 全角，半角空白都去除
            for (char aChar : chars) {
                if ((aChar != ' ' && aChar != '　')) {
                    rtnVal.append(aChar);
                }
            }
        }

        return rtnVal.toString();
    }

    /**
     * 去除给定字符串之后的空字串。
     * <p/>
     * <li>去除指定字符串的前后指定类型的空白字符串。 <li>文字中的空白字符不会删除
     *
     * @param strVal String 需要进行处理的文字列
     * @param mode   int 需要去除的空白字串模式（0=仅仅去除全角空白 , 1=仅仅去除半角空白 , 2=全角，半角空白都去除）
     * @return String 去空白处理后的字符串
     */
    public static String trimTail(String strVal, int mode) {
        if (strVal == null) {
            return "";
        }
        if (2 < mode || mode < 0) {
            mode = 1;
        }

        boolean loopFlg = true;
        StringBuilder rtnVal = new StringBuilder("");
        StringBuilder rtnValList = new StringBuilder("");
        char[] chars = strVal.toCharArray();
        if (mode == 0) {
            // 仅仅去除全角空白
            for (int i = (chars.length - 1); 0 <= i; i--) {
                if (chars[i] != '　' || !loopFlg) {
                    rtnValList.append(chars[i]);
                    loopFlg = false;
                }
            }

        }
        if (mode == 1) {
            // 仅仅去除半角空白
            for (int i = (chars.length - 1); 0 <= i; i--) {
                if (chars[i] != ' ' || !loopFlg) {
                    rtnValList.append(chars[i]);
                    loopFlg = false;
                }
            }
        }
        if (mode == 2) {
            // 全角，半角空白都去除
            for (int i = (chars.length - 1); 0 <= i; i--) {
                if ((chars[i] != ' ' && chars[i] != '　') || !loopFlg) {
                    rtnValList.append(chars[i]);
                    loopFlg = false;
                }
            }
        }
        for (int i = (rtnValList.length() - 1); 0 <= i; i--) {
            rtnVal.append(rtnValList.charAt(i));
        }
        return rtnVal.toString();
    }
}