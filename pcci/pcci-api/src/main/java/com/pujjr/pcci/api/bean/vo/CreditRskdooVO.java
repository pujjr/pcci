package com.pujjr.pcci.api.bean.vo;

import java.io.Serializable;

/**
 * @author wen
 * @date 创建时间：2016年10月10日 上午10:43:35 风险度
 */
public class CreditRskdooVO implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * ID
	 */
	private Long id;

	/**
	 * 来源代码
	 */
	private String sourceId;
	/**
	 * 风险得分
	 */
	private String rskScore;

	/**
	 * 风险标记
	 */
	private String rskMark;
	/**
	 * 业务发生时间
	 */
	private String dataBuildTime;

	/**
	 * @return 对外投资企业法人及股东信息
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param 对外投资企业法人及股东信息
	 *            要设置的 id
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return 来源代码
	 */
	public String getSourceId() {
		return sourceId;
	}

	/**
	 * @param 来源代码
	 *            要设置的 sourceId
	 */
	public void setSourceId(String sourceId) {
		this.sourceId = sourceId;
	}

	/**
	 * @return 风险得分
	 */
	public String getRskScore() {
		return rskScore;
	}

	/**
	 * @param 风险得分
	 *            要设置的 rskScore
	 */
	public void setRskScore(String rskScore) {
		this.rskScore = rskScore;
	}

	/**
	 * @return 风险标记
	 */
	public String getRskMark() {
		return rskMark;
	}

	/**
	 * @param 风险标记
	 *            要设置的 rskMark
	 */
	public void setRskMark(String rskMark) {
		this.rskMark = rskMark;
	}

	/**
	 * @return 业务发生时间
	 */
	public String getDataBuildTime() {
		return dataBuildTime;
	}

	/**
	 * @param 业务发生时间
	 *            要设置的 dataBuildTime
	 */
	public void setDataBuildTime(String dataBuildTime) {
		this.dataBuildTime = dataBuildTime;
	}

}
