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
 * @date 创建时间：2016年10月17日 下午3:00:48 前海借口调用记录
 *
 */
@Entity
public class QianhaiRequest implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * ID
	 */
	@Id
	@Column(length = 64, nullable = true)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long transNo;

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
	 * 交易时间
	 */
	@Column(nullable = false)
	private Date transDate;

	/**
	 * 交易批次号
	 */
	@Column(nullable = false)
	private Long batchNo;

	public Long getTransNo() {
		return transNo;
	}

	public void setTransNo(Long transNo) {
		this.transNo = transNo;
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

	public Date getTransDate() {
		return transDate;
	}

	public void setTransDate(Date transDate) {
		this.transDate = transDate;
	}

	public Long getBatchNo() {
		return batchNo;
	}

	public void setBatchNo(Long batchNo) {
		this.batchNo = batchNo;
	}

}
