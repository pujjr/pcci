package com.pujjr.pcci.common.credit100.type;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wen
 * @date 创建时间：2016年10月13日 15:07:11 申请来源
 */
public enum ApplySourceType {
	A("a", "网络申请"),
	B("b", "柜台申请"),
	C("c", "销售人员办理"),
	D("d", "其他");

	private String code;
	private String name;

	private static Map<String, ApplySourceType> codeMappingCache = new HashMap<String, ApplySourceType>();
	static {
		for (ApplySourceType type : ApplySourceType.values()) {
			codeMappingCache.put(type.getCode(), type);
		}
	}

	private ApplySourceType(String code, String name) {
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

	public static ApplySourceType fromCode(String code) {
		return codeMappingCache.get(code);
	}
}
