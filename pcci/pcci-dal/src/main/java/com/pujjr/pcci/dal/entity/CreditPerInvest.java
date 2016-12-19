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

/**
 * @author wen
 * @date 创建时间：2016年10月10日 上午10:43:35 对外投资
 */
@Entity
public class CreditPerInvest implements Serializable {

	private static final long serialVersionUID = 1L;

	public static final String PERINVEST_TYPE_RYPOSFR = "RYPOSFR";

	public static final String PERINVEST_TYPE_RYPOSSHA = "RYPOSSHA";

	/* 对外投资 企业法人及股东信息 */
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
	 * 投资类型
	 */
	@Column(length = 24)
	private String perinvestType;

	/**
	 * 企业(机构)名称
	 */
	@Column(length = 100)
	private String entname;
	/**
	 * 企业(机构)类型
	 */
	@Column(length = 100)
	private String enttype;
	/**
	 * 注册资本(万元)
	 */
	@Column(length = 100)
	private String regcap;
	/**
	 * 企业状态
	 */
	@Column(length = 100)
	private String entstatus;

	/* 对外投资 企业股东信息 */

	/**
	 * 出资比例
	 */
	@Column(length = 100)
	private String fundedratio;

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
	 * @return 企业(机构)名称
	 */
	public String getEntname() {
		return entname;
	}

	/**
	 * @param 企业(机构)名称
	 *            要设置的 entname
	 */
	public void setEntname(String entname) {
		this.entname = entname;
	}

	/**
	 * @return 企业(机构)类型
	 */
	public String getEnttype() {
		return enttype;
	}

	/**
	 * @param 企业(机构)类型
	 *            要设置的 enttype
	 */
	public void setEnttype(String enttype) {
		this.enttype = enttype;
	}

	/**
	 * @return 注册资本(万元)
	 */
	public String getRegcap() {
		return regcap;
	}

	/**
	 * @param 注册资本(万元)
	 *            要设置的 regcap
	 */
	public void setRegcap(String regcap) {
		this.regcap = regcap;
	}

	/**
	 * @return 企业状态
	 */
	public String getEntstatus() {
		return entstatus;
	}

	/**
	 * @param 企业状态
	 *            要设置的 entstatus
	 */
	public void setEntstatus(String entstatus) {
		this.entstatus = entstatus;
	}

	/**
	 * @return 对外投资企业股东信息
	 */
	public String getFundedratio() {
		return fundedratio;
	}

	/**
	 * @param 对外投资企业股东信息
	 *            要设置的 fundedratio
	 */
	public void setFundedratio(String fundedratio) {
		this.fundedratio = fundedratio;
	}

	/**
	 * @return serialVersionUID
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	/**
	 * @return 企业(机构)名称
	 */
	public String getPerinvestType() {
		return perinvestType;
	}

	/**
	 * @param 企业(机构)名称
	 *            要设置的 perinvest_type
	 */
	public void setPerinvestType(String perinvestType) {
		this.perinvestType = perinvestType;
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
