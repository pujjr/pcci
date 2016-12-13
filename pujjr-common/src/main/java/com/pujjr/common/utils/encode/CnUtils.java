package com.pujjr.common.utils.encode;

/**
 * @author wen
 * @date 创建时间：2016年11月1日 下午1:54:43
 *
 */
public class CnUtils {

	/**
	 * 中文转Unicode
	 * 
	 * @param zhStr
	 * @return
	 */
	public static String toUnicode(String zhStr) {
		StringBuffer unicode = new StringBuffer();
		for (int i = 0; i < zhStr.length(); i++) {
			char c = zhStr.charAt(i);
			unicode.append("\\u" + Integer.toHexString(c));
		}
		return unicode.toString();
	}

}
