package org.pcci.api.bean.vo;

import java.io.Serializable;

/**
 * @author wen
 * @date 创建时间：2016年10月10日 上午10:43:35 个人不良信息
 */
public class CreditCrimeInfoVO implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 案件来源
	 */
	private String caseSource;
	/**
	 * 案件类别
	 */
	private String caseType;
	/**
	 * 案件时间
	 */
	private String caseTime;

	/**
	 * @return 案件来源
	 */
	public String getCaseSource() {
		return caseSource;
	}

	/**
	 * @param 案件来源
	 *            要设置的 caseSource
	 */
	public void setCaseSource(String caseSource) {
		this.caseSource = caseSource;
	}

	/**
	 * @return 案件类别
	 */
	public String getCaseType() {
		return caseType;
	}

	/**
	 * @param 案件类别
	 *            要设置的 caseType
	 */
	public void setCaseType(String caseType) {
		this.caseType = caseType;
	}

	/**
	 * @return 案件时间
	 */
	public String getCaseTime() {
		return caseTime;
	}

	/**
	 * @param 案件时间
	 *            要设置的 caseTime
	 */
	public void setCaseTime(String caseTime) {
		this.caseTime = caseTime;
	}

}
