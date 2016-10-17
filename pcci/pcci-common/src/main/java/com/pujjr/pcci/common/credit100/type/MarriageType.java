package com.pujjr.pcci.common.credit100.type;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wen
 * @date 创建时间：2016年10月13日 15:07:11 婚姻状况
 */
public enum MarriageType {
	A("a", "未婚"),
	B("b", "已婚"),
	C("c", "离异"),
	D("d", "丧偶");

	private String code;
	private String name;

	private static Map<String, MarriageType> codeMappingCache = new HashMap<String, MarriageType>();
	static {
		for (MarriageType type : MarriageType.values()) {
			codeMappingCache.put(type.getCode(), type);
		}
	}

	private MarriageType(String code, String name) {
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

	public static MarriageType fromCode(String code) {
		return codeMappingCache.get(code);
	}
}
