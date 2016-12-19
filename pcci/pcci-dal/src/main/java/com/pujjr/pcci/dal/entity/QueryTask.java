package com.pujjr.pcci.dal.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.pujjr.pcci.api.type.CreditQueryType;

/**
 * @author wen
 * @date 创建时间：2016-12-15 09:29:24 任务情况
 */
@Entity
public class QueryTask implements Serializable {

	private static final long serialVersionUID = 1L;

	/** 默认失败代码 */
	public static final String DEFAULT_ERROR_CODE = "ERROR";

	/** 初始化(非构造) */
	public void init(CreditQueryType creditQueryType, CreditQueryResult creditQueryResult) {
		this.queryType = creditQueryType.name();
		this.queryTypeName = creditQueryType.getRemark();
		this.creditQueryResult = creditQueryResult;
	}

	/** 务查询结果 成功 */
	public static final int QUERY_STATUS_SUCCESS = 1;
	/** 任务查询结果 失败 */
	public static final int QUERY_STATUS_FAIL = 0;

	public QueryTask success() {
		this.queryStatus = QUERY_STATUS_SUCCESS;
		return this;
	}

	public QueryTask fail() {
		this.queryStatus = QUERY_STATUS_FAIL;
		return this;
	}

	public QueryTask fail(String errMsg) {
		this.queryStatus = QUERY_STATUS_FAIL;
		this.errMsg = errMsg;
		this.errCode = DEFAULT_ERROR_CODE;
		return this;
	}

	public QueryTask fail(String errMsg, String errCode) {
		this.queryStatus = QUERY_STATUS_FAIL;
		this.errMsg = errMsg;
		this.errCode = errCode;
		return this;
	}

	/**
	 * ID
	 */
	@Id
	@Column(length = 64, nullable = true)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	/**
	 * 征信查询结果
	 */
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "fk_record_id")
	private CreditQueryResult creditQueryResult;

	/**
	 * 查询类型 {@link CreditQueryType}
	 */
	@Column(length = 24)
	private String queryType;

	/**
	 * 类型名称{@link CreditQueryType}
	 */
	@Column(length = 64)
	private String queryTypeName;

	/**
	 * 任务结果
	 */
	@Column
	private Integer queryStatus = 0;

	/**
	 * 任务错误码
	 */
	@Column(length = 64)
	private String errCode;

	/**
	 * 任务错误信息
	 */
	@Column(length = 64)
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

	/**
	 * @return 征信查询结果
	 */
	public CreditQueryResult getCreditQueryResult() {
		return creditQueryResult;
	}

	/**
	 * @param 征信查询结果
	 *            要设置的 creditQueryResult
	 */
	public void setCreditQueryResult(CreditQueryResult creditQueryResult) {
		this.creditQueryResult = creditQueryResult;
	}

}
