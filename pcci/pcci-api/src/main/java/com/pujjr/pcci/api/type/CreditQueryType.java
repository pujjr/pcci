package com.pujjr.pcci.api.type;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wen
 * @date 创建时间2016年11月7日 09:57:08
 */
public enum CreditQueryType {
	/** 全部 */
	all("全部"),
	/** 个人不良 */
	crimeinfo("百融个人不良信息"),
	/** 法院被执行人 */
	execution("百融法院被执行人"),
	/** 个人对外投资查询 */
	perinvest("百融个人对外投资"),
	/** 多次贷款记录 */
	applyloan("百融多次贷款记录"),
	/** 常贷客 */
	loanee("前海常贷客"),
	/** 反欺诈 */
	antifrauddoo("前海反欺诈"),
	/** 风险度 */
	rskdoo("前海风险度"),
	/** 一鉴通 */
	eChkPkgs("前海一鉴通"),
	/** 驾驶证状态 */
	drvcert2cmpinc("前海驾驶证匹配");

	private String remark;

	private static Map<String, CreditQueryType> codeMappingCache = new HashMap<String, CreditQueryType>();
	static {
		for (CreditQueryType type : CreditQueryType.values()) {
			codeMappingCache.put(type.name(), type);
		}
	}

	private CreditQueryType(String remark) {
		this.remark = remark;
	}

	public String getRemark() {
		return this.remark;
	}

	public static boolean contains(String name) {
		return codeMappingCache.get(name) != null;
	}

	public static CreditQueryType fromCode(String name) {
		return codeMappingCache.get(name);
	}

}
