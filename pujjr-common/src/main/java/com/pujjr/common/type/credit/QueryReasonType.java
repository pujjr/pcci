package com.pujjr.common.type.credit;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wen
 * @date 创建时间�?2016�?10�?10�? 上午11:33:09
 *
 */
public enum QueryReasonType {
	/** 贷款审批 01 */
	LOAN_APPROVAL("01", "贷款审批"),
	/** 贷中管理 02 */
	LOAN_MID_MANAGE("02", "贷中管理"),
	/** 贷后管理 03 */
	LOAN_LATER_MANAGE("03", "贷后管理"),
	/** 本人查询 04 */
	SELF_QUERY("04", "本人查询"),
	/** 异议查询 05 */
	OBJECTION_QUERY("05", "异议查询"),
	/** 其他 99 */
	OTHER("99", "其他");

	private String code;
	private String name;

	private static Map<String, QueryReasonType> codeMappingCache = new HashMap<String, QueryReasonType>();
	static {
		for (QueryReasonType type : QueryReasonType.values()) {
			codeMappingCache.put(type.getCode(), type);
		}
	}

	private QueryReasonType(String code, String name) {
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

	public static QueryReasonType fromCode(String code) {
		return codeMappingCache.get(code);
	}
}
