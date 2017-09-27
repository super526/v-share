package com.supan.vshare.common.utils;

import java.text.Format;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * 时间日期工具类
 */
public class DateUtil {
    /**
     * 构造函数
     */
    private DateUtil() {
        super();
    }
    public static final String FORMAT_LONG = "yyyy-MM-dd HH:mm:ss";

    public static final String FORMAT_LONG2 = "yyyy/MM/dd HH:mm:ss";
    /**
     * 日期格式化 yyyy/MM/dd
     */
    public static final String YYYYMMDD_SLASH = "yyyy/MM/dd";
    /**
     * 日期格式化 yyyy-MM-dd
     */
    public static final String YYYYMMDD_HYPHEN = "yyyy-MM-dd";

    /**
     * 日期格式化 yyyy-MM-dd
     */
    public static final String HHMMSS_COLON = "HH:mm:ss";

    private static String valueOfString(String str, int len) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len - str.length(); i++) {
            sb.append("0");
        }
        return (sb.length() == 0) ? (str) : (sb.toString() + str);
    }

    private static String getTimeString(Calendar calendar) {
        return String.valueOf(calendar.get(Calendar.YEAR))
                + valueOfString(String.valueOf(calendar.get(Calendar.MONTH) + 1), 2)
                + valueOfString(String.valueOf(calendar.get(Calendar.DAY_OF_MONTH)), 2)
                + valueOfString(String.valueOf(calendar.get(Calendar.HOUR_OF_DAY)), 2)
                + valueOfString(String.valueOf(calendar.get(Calendar.MINUTE)), 2)
                + valueOfString(String.valueOf(calendar.get(Calendar.SECOND)), 2)
                + valueOfString(String.valueOf(calendar.get(Calendar.MILLISECOND)), 3);
    }

    public static String getCurtTimeString() {
        Calendar calendar = new GregorianCalendar();
        return getTimeString(calendar);
    }

    public static String cnvtDate2Str(int type, Date date, String defaultVl) {
        if (date == null) {
            return defaultVl;
        } else {
            return cnvtDate2Str(type, date);
        }
    }

    public static String cnvtDate2Str(int type, Date date) {
        if (date == null) {
            return null;
        }
        // declare default format
        String asFormat = "yyyy-MM-dd HH:mm:ss";
        if (type == 1) {
            asFormat = YYYYMMDD_SLASH;
        } else if (type == 2) {
            asFormat = HHMMSS_COLON;
        } else if (type == 3) {
            asFormat = YYYYMMDD_HYPHEN;
        }
        SimpleDateFormat sdf = new SimpleDateFormat(asFormat);
        return sdf.format(date);
    }

    /**
     * 根据给定的格式把Date转换成字符串文字<BR>
     *
     * @param aoDate 日期
     * @param asFormat 格式化格式
     * @return null或者日期字符串
     */
    public static String converDateToString(Date aoDate, String asFormat) {
        // 日期为null的时候
        if (aoDate == null) {
            return null;
        }

        // 转换成文字
        SimpleDateFormat oSdf = new SimpleDateFormat(asFormat);
        return oSdf.format(aoDate);
    }

    /**
     * 日期类型检查<BR>
     *
     * @param asDate yyyyMMdd型、yyyy/MM/dd型、yyyy-MM-dd型的字符串
     * @return 正常的日期true，其他情况返回false。
     */
    public static boolean checkDate(String asDate) {
        // null或者空白文字
        if (TextUtil.isNullTrim(asDate)) {
            return false;
        }
        asDate = asDate.replaceAll("/", "");
        asDate = asDate.replaceAll("-", "");

        // 位数超过8位以上
        if (asDate.length() != 8) {
            return false;
        }
        // 不是整数
        if (!NumUtil.isInteger(asDate)) {
            return false;
        }

        int iYear = Integer.parseInt(asDate.substring(0, 4));
        int iMonth = Integer.parseInt(asDate.substring(4, 6));
        int iDay = Integer.parseInt(asDate.substring(6));
        return checkDate(iYear, iMonth, iDay);
    }

    /**
     * 日期类型检查<BR>
     *
     * @param aiYear 年
     * @param aiMonth 月
     * @param aiDay 日
     * @return 正常的日期true，其他情况返回false。
     */
    private static boolean checkDate(int aiYear, int aiMonth, int aiDay) {
        try {
            Calendar oCal = Calendar.getInstance();
            oCal.set(Calendar.YEAR, aiYear);
            oCal.set(Calendar.MONTH, aiMonth - 1);
            oCal.set(Calendar.DATE, aiDay);
            // 设定日期进行严格解析
            oCal.setLenient(false);
            @SuppressWarnings("unused")
            Date date = oCal.getTime();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static Date parse(String strDate){
        return parse(strDate, FORMAT_LONG);
    }

    /**
     * 指定文字转换成日期型。<BR>
     *
     * @param asValue 时间文字
     * @return null或者空白文字的场合返回null，日期文字意外的场合返回null，其他返回Date类型
     */
    public static Date converStringToDate(String asValue) {
        // null或者空白文字的场合返回null
        if (TextUtil.isNull(asValue)) {
            return null;
        }

        // 日期文字意外的场合返回null
        if (asValue.length() < 8) {
            return null;
        }

        // 日期文字的正确性检查
        if (!checkDate(asValue)) {
            return null;
        }

        // 日期转换
        ParsePosition oPos = new ParsePosition(0);
        oPos.setIndex(0);
        if (asValue.indexOf('/') != -1) {
            // 斜线的场合
            Format oFromat = new SimpleDateFormat(YYYYMMDD_SLASH);
            return (Date) oFromat.parseObject(asValue, oPos);
        } else if (asValue.indexOf('-') != -1) {
            // 横线的场合
            Format oFromat = new SimpleDateFormat(YYYYMMDD_HYPHEN);
            return (Date) oFromat.parseObject(asValue, oPos);
        } else {
            Calendar oCal = Calendar.getInstance();
            int iYear = Integer.parseInt(asValue.substring(0, 4));
            int iMonth = Integer.parseInt(asValue.substring(4, 6));
            int iDay = Integer.parseInt(asValue.substring(6, 8));
            oCal.set(Calendar.YEAR, iYear);
            oCal.set(Calendar.MONTH, iMonth - 1);
            oCal.set(Calendar.DATE, iDay);
            return oCal.getTime();
        }
    }

    public static Date parse(String strDate, String pattern) {
        SimpleDateFormat df = new SimpleDateFormat(pattern);
        try {
            return df.parse(strDate);
        } catch (ParseException e) {
            return null;
        }
    }

    /**
     * 根据xlsx中的日期时间列获得一个date对象
     * @param date 日期字符串 格式yyyy/MM/dd
     * @param time 时间字符串 格式HH:mm:ss
     * @return {@link Date}
     */
    public static Date parseXlsx(String date, String time){
        return parse(date + " " + time, FORMAT_LONG2);
    }
}