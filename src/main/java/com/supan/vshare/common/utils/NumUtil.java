package com.supan.vshare.common.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 数值处理工具类。
 */
public class NumUtil {

    /**
     * 构造函数。
     */
    private NumUtil() {
        super();
    }

    /**
     * 整数检查<BR>
     *
     * @param asValue 检查字符串
     * @return 整数的情况true，其他情况false。
     */
    public static boolean isInteger(String asValue) {
        // null或空白文字
        if (TextUtil.isNullTrim(asValue)) {
            return false;
        }
        String asValueRep = asValue.replaceFirst("-", "");

        // 数值检查
        char cTmp;
        for (int i = 0, iSize = asValueRep.length(); i < iSize; i++) {
            cTmp = asValueRep.charAt(i);
            // 数值以外的情况
            if (!(cTmp >= '0' && cTmp <= '9')) {
                return false;
            }
        }
        return true;
    }

    /**
     * 数值检查<BR>
     *
     * @param asValue 检查字符串
     * @return 数值的情况true，其他情况false。
     */
    public static boolean isNumber(String asValue) {
        // null或空白文字
        if (TextUtil.isNullTrim(asValue)) {
            return false;
        }
        Pattern pattern = Pattern.compile("[-]?[0-9]*[.]?[0-9]+|[-]?[0-9]+[.]");
        Matcher isNum = pattern.matcher(asValue);
        return isNum.matches();
    }
}