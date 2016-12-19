package com.pujjr.common.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;

/**
 * @author wen
 * @date 创建时间：2016年10月19日 上午9:24:00
 *
 */
public class BaseDateUtils {

	private void DateFormat() {
		// TODO 自动生成的方法存根

	}

	public static Date Format(String date, String pattern) throws ParseException {
		SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
		if (StringUtils.isNotBlank(date)) {
			return dateFormat.parse(date);
		}
		return null;
	}

}
