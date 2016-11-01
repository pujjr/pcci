package com.pujjr.common.type;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wen
 * @date 创建时间 2016年10月31日 16:28:27 币种
 */
public enum CurrencyType {
	/** 人民币 */
	CNY("人民币"),
	/** 港元 */
	HKD("港元"),
	/** 美元 */
	USD("美元"),
	/** 欧元 */
	EUR("欧元"),
	/** 日元 */
	JPY("日元"),
	/** 澳门元 */
	MOP("澳门元"),
	/** 瑞士法郎 */
	CHF("瑞士法郎"),
	/** 英镑 */
	GBP("英镑"),
	/** 俄罗斯卢布 */
	RUR("俄罗斯卢布"),
	/** 加拿大元 */
	CAD("加拿大元"),
	/** 丹麦克朗 */
	DKK("丹麦克朗"),
	/** 澳大利亚澳元 */
	AUD("澳大利亚澳元"),
	/** 瑞典克朗 */
	SEK("瑞典克朗");

	private String remark;

	private static Map<String, CurrencyType> codeMappingCache = new HashMap<String, CurrencyType>();
	static {
		for (CurrencyType type : CurrencyType.values()) {
			codeMappingCache.put(type.name(), type);
		}
	}

	private CurrencyType(String remark) {
		this.remark = remark;
	}

	public String getRemark() {
		return remark;
	}

	public static boolean contains(String name) {
		return codeMappingCache.get(name) != null;
	}

	public static CurrencyType fromCode(String name) {
		return codeMappingCache.get(name);
	}
}
