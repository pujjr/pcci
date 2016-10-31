package com.pujjr.common.type.credit;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wen
 * @date 创建时间�?2016�?10�?13�? 15:07:11 申请渠道类型
 */
public enum MealType {
	/** 借款反欺诈规则�?�特殊名�? */
	RuleSpecialList,
	/** 借款反欺诈规则�?�多次申�? */
	RuleApplyLoan,
	/** 借款反欺诈规则�?�法院执行人 */
	RuleExecution,
	/** 特殊名单核查 */
	SpecialList_c,
	/** 多次申请核查 */
	ApplyLoan,
	/** 多次申请核查v2 */
	ApplyLoanStr,
	/** 法院被执行人 */
	Execution,
	/** 个人不良信息查询 */
	CrimeInfo,
	/** 个人对外投资查询 */
	PerInvest;

	private static Map<MealType, MealType> codeMappingCache = new HashMap<MealType, MealType>();
	static {
		for (MealType type : MealType.values()) {
			codeMappingCache.put(type, type);
		}
	}

	public static boolean contains(String name) {
		return codeMappingCache.get(name) != null;
	}

	public static MealType fromCode(String name) {
		return codeMappingCache.get(name);
	}

}
