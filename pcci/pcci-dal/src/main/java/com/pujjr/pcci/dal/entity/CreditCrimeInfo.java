package com.pujjr.pcci.dal.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author wen
 * @date 创建时间：2016年10月10日 上午10:43:35 个人不良信息
 */
@Entity
public class CreditCrimeInfo implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * ID
	 */
	@Id
	@Column(length = 64, nullable = true)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	/**
	 * 案件来源
	 */
	@Column(length = 50)
	private String caseSource;
	/**
	 * 案件类别
	 */
	@Column(length = 50)
	private String caseType;
	/**
	 * 案件时间
	 */
	@Column(length = 50)
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

}
