package com.pujjr.common.utils;

import java.util.UUID;

/**
 * @author wen
 * @date 创建时间：2016年10月19日 上午9:25:41
 *
 */
public class BaseUtils {
	public static void main(String[] args) {
		System.out.println(UUID.randomUUID().toString());
		System.out.println(BaseUtils.newUUID());
	}

	public static String newUUID() {
		return UUID.randomUUID().toString().toUpperCase().replaceAll("-", "");
	}

}
