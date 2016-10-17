package com.pujjr.pcci.common.credit100.type;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wen
 * @date 创建时间：2016年10月13日 15:07:11 职位
 */
public enum BizPositonType {
	A("a", "员工"),
	B("b", "基层主管"),
	C("c", "中层主管"),
	D("d", "高层主管"),
	E("e", "其他");

	private String code;
	private String name;

	private static Map<String, BizPositonType> codeMappingCache = new HashMap<String, BizPositonType>();
	static {
		for (BizPositonType type : BizPositonType.values()) {
			codeMappingCache.put(type.getCode(), type);
		}
	}

	private BizPositonType(String code, String name) {
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

	public static BizPositonType fromCode(String code) {
		return codeMappingCache.get(code);
	}
}
