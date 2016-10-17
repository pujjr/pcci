package com.pujjr.pcci.common.credit100.type;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wen
 * @date 创建时间：2016年10月13日 15:07:11 单位所属行业
 */
public enum BizIndustryType {
	A("a", "金融/保险"),
	B("b", "政府机关"),
	C("c", "旅游/饭店/宾馆/娱乐"),
	D("d", "能源及通信服务"),
	E("e", "公共事业"),
	F("f", "邮政/交通运输/物流业"),
	G("g", "批发/零售/百货业"),
	H("h", "轻工业"),
	I("i", "房地产/基础建设/物管"),
	J("j", "国内贸易公司"),
	K("k", "制造业"),
	L("l", "律师/会计师/咨询/培训"),
	M("m", "进出口贸易"),
	N("n", "IT产业"),
	O("o", "媒体/出版/广告/文艺"),
	P("p", "医疗"),
	Q("q", "其他");

	private String code;
	private String name;

	private static Map<String, BizIndustryType> codeMappingCache = new HashMap<String, BizIndustryType>();
	static {
		for (BizIndustryType type : BizIndustryType.values()) {
			codeMappingCache.put(type.getCode(), type);
		}
	}

	private BizIndustryType(String code, String name) {
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

	public static BizIndustryType fromCode(String code) {
		return codeMappingCache.get(code);
	}
}
