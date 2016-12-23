package com.pujjr.common.utils.http;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.params.HttpMethodParams;
import org.apache.commons.io.IOUtils;

import com.pujjr.common.utils.bean.BeanPropertyUtils;

/**
 * @author wen
 * @date 创建时间：2016年11月4日 下午12:47:12
 *
 */
public class HttpUtils {
	/**
	 * http请求编码
	 */
	private String charset;
	/**
	 * http请求地址
	 */
	private String url;

	public HttpUtils(String url, String charset) {
		this.url = url;
		this.charset = charset;
	}

	public String send(Object obj) throws HttpException, IOException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		// HttpClient方法创建
		HttpClient httpClient = new HttpClient();
		httpClient.getParams().setParameter(HttpMethodParams.HTTP_CONTENT_CHARSET, charset);
		// Post方法创建
		PostMethod postMethod = new PostMethod(url);
		// 填入各个表单域的值
		NameValuePair[] data = beanToNameValuePairArray(obj);
		// 将表单的值放入postMethod中
		postMethod.setRequestBody(data);
		// 执行postMethod
		int statusCode = httpClient.executeMethod(postMethod);
		if (HttpStatus.SC_OK == statusCode) {
			// 读取内容
			InputStream resInputStream = postMethod.getResponseBodyAsStream();
			String resMes = IOUtils.toString(resInputStream);
			return resMes;
		}
		return String.valueOf(statusCode);
	}

	public static NameValuePair[] beanToNameValuePairArray(Object obj) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Map<String, Object> map;
		map = BeanPropertyUtils.beanToMap(obj);
		List<NameValuePair> list = new ArrayList<>();
		for (String key : map.keySet()) {
			String value = map.get(key) == null ? "" : map.get(key).toString();
			list.add(new NameValuePair(key, value));
		}
		return list.toArray(new NameValuePair[list.size()]);
	}

	/**
	 * @return http请求编码
	 */
	public String getCharset() {
		return charset;
	}

	/**
	 * @param http请求编码
	 *            要设置的 charset
	 */
	public void setCharset(String charset) {
		this.charset = charset;
	}

	/**
	 * @return http请求地址
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * @param http请求地址
	 *            要设置的 url
	 */
	public void setUrl(String url) {
		this.url = url;
	}

}
