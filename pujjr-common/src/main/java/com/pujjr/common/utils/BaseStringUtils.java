package com.pujjr.common.utils;

import org.apache.commons.lang3.StringUtils;

import com.pujjr.common.exception.CheckFailException;

/**
 * @author wen
 * @date 创建时间：2016年10月19日 上午9:25:41
 *
 */
public class BaseStringUtils {

	public static String notBlank(String str) throws CheckFailException {
		if (StringUtils.isNotBlank(str)) {
			return str;
		}
		throw new CheckFailException("");
	}

	/**
	 * 如果有任何相等于第一个字符串参数的字符串,则返回true
	 * 
	 * @param str1
	 * @param strArray
	 * @return
	 */
	public static boolean equalsAny(String str1, String... strArray) {
		if (strArray != null) {
			for (String str2 : strArray) {
				if (StringUtils.equals(str1, str2)) {
					return true;
				}
			}
		}
		return false;
	}

	public static void main(String[] args) {
		System.out.println(BaseStringUtils.equalsAny("4"));
	}

}
