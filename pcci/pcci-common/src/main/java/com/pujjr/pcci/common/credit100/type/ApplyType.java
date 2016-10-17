package com.pujjr.pcci.common.credit100.type;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wen
 * @date 创建时间：2016年10月13日 15:07:11 申请渠道类型
 */
public enum ApplyType {
	/** 网络申请_网页版 */
	A("a", "网络申请_网页版"),
	/** 网络申请_安卓版 */
	B("b", "网络申请_安卓版"),
	/** 网络申请-ios版 */
	C("c", "网络申请-ios版"),
	/** 网络申请-WP版 */
	D("d", "网络申请-WP版"),
	/** 柜台申请 */
	E("e", "柜台申请"),
	/** 人民币 */
	F("f", "销售人员办理"),
	/** 人民币 */
	G("g", "其他");

	private String code;
	private String name;

	private static Map<String, ApplyType> codeMappingCache = new HashMap<String, ApplyType>();
	static {
		for (ApplyType type : ApplyType.values()) {
			codeMappingCache.put(type.getCode(), type);
		}
	}

	private ApplyType(String code, String name) {
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

	public static ApplyType fromCode(String code) {
		return codeMappingCache.get(code);
	}
}
