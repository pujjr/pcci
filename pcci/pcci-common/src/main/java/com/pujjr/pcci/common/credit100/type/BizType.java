package com.pujjr.pcci.common.credit100.type;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wen
 * @date 创建时间：2016年10月13日 15:07:11 商业性质
 */
public enum BizType {
	A("a", "外资企业"),
	B("b", "合资企业"),
	C("c", "国营企业"),
	D("d", "民营企业"),
	E("e", "上市公司"),
	F("f", "非盈利组织"),
	G("g", "政府机关"),
	H("h", "事业单位"),
	I("i", "个体工商"),
	J("j", "其他");

	private String code;
	private String name;

	private static Map<String, BizType> codeMappingCache = new HashMap<String, BizType>();
	static {
		for (BizType type : BizType.values()) {
			codeMappingCache.put(type.getCode(), type);
		}
	}

	private BizType(String code, String name) {
		this.code = code;
		this.name = name;
	}

	public String getCode() {
		return this.code;
	}

	public String getName() {
		return this.name;
	}

	public static boolean contains(String code) {
		return codeMappingCache.get(code) != null;
	}

	public static BizType fromCode(String code) {
		return codeMappingCache.get(code);
	}
}
