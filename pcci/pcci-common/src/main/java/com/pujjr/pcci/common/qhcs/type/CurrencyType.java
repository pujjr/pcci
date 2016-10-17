package com.pujjr.pcci.common.qhcs.type;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wen
 * @date 创建时间：2016年10月10日 下午4:38:50 币种
 */
public enum CurrencyType {
	/** 人民币 */
	CNY("CNY", "人民币"),
	/** 港元 */
	HKD("HKD", "港元"),
	/** 美元 */
	USD("USD", "美元"),
	/** 欧元 */
	EUR("EUR", "欧元"),
	/** 日元 */
	JPY("JPY", "日元"),
	/** 澳门元 */
	MOP("MOP", "澳门元"),
	/** 瑞士法郎 */
	CHF("CHF", "瑞士法郎"),
	/** 英镑 */
	GBP("GBP", "英镑"),
	/** 俄罗斯卢布 */
	RUR("RUR", "俄罗斯卢布"),
	/** 加拿大元 */
	CAD("CAD", "加拿大元"),
	/** 丹麦克朗 */
	DKK("DKK", "丹麦克朗"),
	/** 澳大利亚元 */
	AUD("AUD", "澳大利亚元"),
	/** 瑞典克朗 */
	SEK("SEK", "瑞典克朗");

	private String code;
	private String name;

	private static Map<String, CurrencyType> codeMappingCache = new HashMap<String, CurrencyType>();
	static {
		for (CurrencyType type : CurrencyType.values()) {
			codeMappingCache.put(type.getCode(), type);
		}
	}

	private CurrencyType(String code, String name) {
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

	public static CurrencyType fromCode(String code) {
		return codeMappingCache.get(code);
	}
}
