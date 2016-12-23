package com.pujjr.pcci.api.bean.vo;

import java.io.Serializable;

import com.pujjr.pcci.api.type.CreditQueryType;

/**
 * @author wen
 * @date 创建时间：2016-12-15 09:29:24 任务情况
 */
public class QueryTaskVO implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * ID
	 */
	private Long id;

	/**
	 * 查询类型 {@link CreditQueryType}
	 */
	private String queryType;

	/**
	 * 类型名称{@link CreditQueryType}
	 */
	private String queryTypeName;

	/**
	 * 任务结果
	 */
	private Integer queryStatus = 0;

	/**
	 * 任务错误码
	 */
	private String errCode;

	/**
	 * 任务错误信息
	 */
	private String errMsg;

	/**
	 * @return ID
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param ID
	 *            要设置的 id
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return 被执行类型{@link CreditQueryType}
	 */
	public String getQueryType() {
		return queryType;
	}

	/**
	 * @param 被执行类型{@link
	 * 			CreditQueryType} 要设置的 queryType
	 */
	public void setQueryType(String queryType) {
		this.queryType = queryType;
	}

	/**
	 * @return 类型名称{@link CreditQueryType}
	 */
	public String getQueryTypeName() {
		return queryTypeName;
	}

	/**
	 * @param 类型名称{@link
	 * 			CreditQueryType} 要设置的 queryTypeName
	 */
	public void setQueryTypeName(String queryTypeName) {
		this.queryTypeName = queryTypeName;
	}

	/**
	 * @return 任务结果
	 */
	public Integer getQueryStatus() {
		return queryStatus;
	}

	/**
	 * @param 任务结果
	 *            要设置的 queryStatus
	 */
	public void setQueryStatus(Integer queryStatus) {
		this.queryStatus = queryStatus;
	}

	/**
	 * @return 任务错误码
	 */
	public String getErrCode() {
		return errCode;
	}

	/**
	 * @param 任务错误码
	 *            要设置的 errCode
	 */
	public void setErrCode(String errCode) {
		this.errCode = errCode;
	}

	/**
	 * @return 任务错误信息
	 */
	public String getErrMsg() {
		return errMsg;
	}

	/**
	 * @param 任务错误信息
	 *            要设置的 errMsg
	 */
	public void setErrMsg(String errMsg) {
		this.errMsg = errMsg;
	}

}
