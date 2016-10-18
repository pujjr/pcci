package com.pujjr.pcci.dal.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author wen
 * @date 创建时间：2016年10月17日 下午3:00:48 百融打包调用查询请求数据记录表
 *
 */
@Entity
public class HundredCreditResult implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * ID
	 */
	@Id
	@Column(length = 64, nullable = true)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long hcid;

	/**
	 * 查询请求用户/员工编号
	 */
	@Column(nullable = false)
	private String requestUserId;

	/**
	 * 查询请求时间
	 */
	@Column(nullable = false)
	private Date requestDate;

	/**
	 * api调用类型
	 */
	@Column(nullable = false)
	private String apiType;

	/**
	 * 此次请求产品代号
	 */
	@Column(nullable = false)
	private String meal;

	/**
	 * 此次请求产品代号
	 */
	@Column(nullable = false)
	private Long requestId;

	/**
	 * 结果返回时间
	 */
	@Column(nullable = false)
	private Date resultDate;

	/**
	 * 请求结果
	 */
	@Column(length = 2048)
	private String result;

	public Long getHcid() {
		return hcid;
	}

	public void setHcid(Long hcid) {
		this.hcid = hcid;
	}

	public String getRequestUserId() {
		return requestUserId;
	}

	public void setRequestUserId(String requestUserId) {
		this.requestUserId = requestUserId;
	}

	public Date getRequestDate() {
		return requestDate;
	}

	public void setRequestDate(Date requestDate) {
		this.requestDate = requestDate;
	}

	public String getApiType() {
		return apiType;
	}

	public void setApiType(String apiType) {
		this.apiType = apiType;
	}

	public String getMeal() {
		return meal;
	}

	public void setMeal(String meal) {
		this.meal = meal;
	}

	public Long getRequestId() {
		return requestId;
	}

	public void setRequestId(Long requestId) {
		this.requestId = requestId;
	}

	public Date getResultDate() {
		return resultDate;
	}

	public void setResultDate(Date resultDate) {
		this.resultDate = resultDate;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

}
