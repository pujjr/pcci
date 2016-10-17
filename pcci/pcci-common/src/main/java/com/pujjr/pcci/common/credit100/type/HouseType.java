package com.pujjr.pcci.common.credit100.type;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wen
 * @date 创建时间：2016年10月13日 15:07:11 住房性质
 */
public enum HouseType {
	A("a", "有房有贷款"),
	B("b", "有房无贷款"),
	C("c", "租借房"),
	D("d", "其他");

	private String code;
	private String name;

	private static Map<String, HouseType> codeMappingCache = new HashMap<String, HouseType>();
	static {
		for (HouseType type : HouseType.values()) {
			codeMappingCache.put(type.getCode(), type);
		}
	}

	private HouseType(String code, String name) {
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

	public static HouseType fromCode(String code) {
		return codeMappingCache.get(code);
	}
}
