package com.pujjr.common.type.credit;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wen
 * @date 创建时间�?2016�?10�?10�? 上午11:33:09
 *
 */
public enum QueryProductType {

	/** 风险度提示查�? */
	MSC8036("query", "rskdoo", "MSC8036"),
	/** 风险度提示报�? */
	MSC9004("submit", "rskdoo", "MSC9004"),
	/** 常贷客数�? */
	MSC8037("query", "loanee", "MSC8037"),
	/** 好信欺诈�? */
	MSC8075("verify", "antiFraudDoo", "MSC8075"),
	/** 驾驶证比对任务提�? */
	MSC8078("submit", "drvCert2Cmp", "MSC8078"),
	/** 驾驶证比对任务查�? */
	MSC8079("query", "drvCert2CmpInc", "MSC8079"),
	/** 驾驶证状态比对查�? */
	MSC8081("submit", "drvCertSta2Cmp", "MSC8081"),
	/** 好信�?鉴�?? */
	MSC8107("verify", "eChkPkgs", "MSC8107");

	/**
	 * 交易名称
	 */
	private String transName;
	/**
	 * 产品ID
	 */
	private String productId;
	/**
	 * 报文代码
	 */
	private String messageCode;

	private static Map<String, QueryProductType> codeMappingCache = new HashMap<String, QueryProductType>();
	static {
		for (QueryProductType type : QueryProductType.values()) {
			codeMappingCache.put(type.getMessageCode(), type);
		}
	}

	private QueryProductType(String transName, String productId, String messageCode) {
		this.transName = transName;
		this.productId = productId;
		this.messageCode = messageCode;
	}

	public String getTransName() {
		return transName;
	}

	public void setTransName(String transName) {
		this.transName = transName;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getMessageCode() {
		return messageCode;
	}

	public void setMessageCode(String messageCode) {
		this.messageCode = messageCode;
	}

	public static boolean contains(String messageCode) {
		return codeMappingCache.get(messageCode) != null;
	}

	public static QueryProductType fromCode(String messageCode) {
		return codeMappingCache.get(messageCode);
	}
}
