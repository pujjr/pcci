package com.pujjr.pcci.common.credit100.type;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wen
 * @date 创建时间：2016年10月13日 15:07:11 学历
 */
public enum EducationalLevelType {
	A("a", "高中及以下"),
	B("b", "大专"),
	C("c", "本科"),
	D("d", "硕士"),
	E("e", "博士"),
	F("f", "其他");

	private String code;
	private String name;

	private static Map<String, EducationalLevelType> codeMappingCache = new HashMap<String, EducationalLevelType>();
	static {
		for (EducationalLevelType type : EducationalLevelType.values()) {
			codeMappingCache.put(type.getCode(), type);
		}
	}

	private EducationalLevelType(String code, String name) {
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

	public static EducationalLevelType fromCode(String code) {
		return codeMappingCache.get(code);
	}
}
