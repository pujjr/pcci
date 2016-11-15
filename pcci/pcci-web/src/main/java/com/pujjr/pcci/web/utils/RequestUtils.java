package com.pujjr.pcci.web.utils;

import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

/**
 * @author wen
 * @date 创建时间：2016年10月17日 10:08:59
 *
 */
public class RequestUtils {
	public static Object getAttribute(String sessionKey) {
		return RequestContextHolder.currentRequestAttributes().getAttribute(sessionKey, RequestAttributes.SCOPE_REQUEST);
	}

	public static void setAttribute(String key, Object value) {
		RequestContextHolder.currentRequestAttributes().setAttribute(key, value, RequestAttributes.SCOPE_REQUEST);
	}

	public static void removeAttribute(String key) {
		RequestContextHolder.currentRequestAttributes().removeAttribute(key, RequestAttributes.SCOPE_REQUEST);
	}

	/**
	 * Request中是否存在
	 * 
	 * @param key
	 * @return
	 */
	public static boolean isAbsentAttribute(String key) {
		return null == getAttribute(key) ? true : false;
	}
}
