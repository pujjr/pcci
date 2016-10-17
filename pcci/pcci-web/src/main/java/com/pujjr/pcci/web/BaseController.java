package com.pujjr.pcci.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.context.request.ServletWebRequest;

public class BaseController {

	protected Logger logger = LoggerFactory.getLogger(this.getClass());

	public static Object getAttribute(String name) {
		ServletRequestAttributes sra = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		return sra.getAttribute(name, ServletWebRequest.SCOPE_REQUEST);
	}

	public static void setAttribute(String name, Object value) {
		ServletRequestAttributes sra = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		sra.setAttribute(name, value, ServletWebRequest.SCOPE_REQUEST);
	}

	public static String getParameter(String name) {
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
		return request.getParameter(name);
	}

	public static HttpServletRequest getRequest() {
		return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
	}

	public static HttpSession getSession() {
		return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest().getSession();
	}

	public static HttpServletRequest getCurrentRequest() {
		ServletRequestAttributes sra = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		return sra.getRequest();
	}

}
