package com.supan.vshare.common.utils;

import java.math.BigDecimal;

/**
 * 计算工具类
 *
 * @author yanliwei
 */
public class CalculateUtil{
	/**
	 * 精度，精确到小数点后多少位，默认是2位
	 */
	private static int scale = 2;
	/**
	 * 结果保存方式，默认四舍五入
	 */
	private static int mode = BigDecimal.ROUND_HALF_UP;

	private static BigDecimal convert(Number number){
		if (number instanceof Integer){
			return new BigDecimal(number.intValue());
		}else if (number instanceof Float){
			return new BigDecimal(number.floatValue());
		}else if(number instanceof Double){
			return new BigDecimal(number.floatValue());
		}else if (number instanceof Long){
			return new BigDecimal(number.longValue());
		}
		return new BigDecimal(0);
	}

	/**
	 * 两数相加
	 *
	 * @param t  第一个数字
	 * @param p  第二个数字
	 *
	 * @return
	 */
	public static <T extends Number, P extends Number> BigDecimal add(T t, P p){
		return convert(t).add(convert(p)).setScale(scale, mode);
	}

	/**
	 * 两数相减
	 *
	 * @param t  第一个数字
	 * @param p  第二个数字
	 *
	 * @return
	 */
	public static <T extends Number, P extends Number> BigDecimal subtract(T t, P p){
		return convert(t).subtract(convert(p)).setScale(scale, mode);
	}

	/**
	 * 两数相乘
	 *
	 * @param t  第一个数字
	 * @param p  第二个数字
	 *
	 * @return
	 */
	public static <T extends Number, P extends Number> BigDecimal multiply(T t, P p){
		return convert(t).multiply(convert(p)).setScale(scale, mode);
	}

	/**
	 * 两数相除
	 *
	 * @param t  第一个数字
	 * @param p  第二个数字
	 *
	 * @return
	 */
	public static <T extends Number, P extends Number> BigDecimal divide(T t, P p){
		return convert(t).divide(convert(p)).setScale(scale, mode);
	}

}
