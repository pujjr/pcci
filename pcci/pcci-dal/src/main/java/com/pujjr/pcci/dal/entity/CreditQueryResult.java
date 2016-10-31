package com.pujjr.pcci.dal.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

/**
 * @author wen
 * @date 创建时间：2016年10月17日 下午3:00:48 征信查询结果记录表
 *
 */
@Entity
public class CreditQueryResult implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * ID
	 */
	@Id
	@Column(length = 64, nullable = true)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long recordId;

	@Column
	private Long creditId;

	/**
	 * 查询请求用户/员工编号
	 */
	@Column(nullable = false, length = 24)
	private String requestUserId;

	/**
	 * 查询请求时间
	 */
	@Column(nullable = false)
	private Date requestDate;

	/* 个人不良信息 */
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "credit_record_Id")
	private Set<CreditCrimeInfo> creditCrimeInfoSet;

	/* 失信被执行记录 */
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "credit_record_Id")
	private Set<CreditExecution> CreditExecutionSet;

	/* 对外投资 */
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "credit_record_Id")
	private Set<CreditPerInvest> CreditPerInvestSet;

	/* 信贷申请记录 */

	/**
	 * 1个月前海贷款申请次数
	 */
	@Column
	private Integer qh_m1_id_loan_num = 0;
	/**
	 * 3个月前海贷款申请次数
	 */
	@Column
	private Integer qh_m3_id_loan_num = 0;
	/**
	 * 6个月前海贷款申请次数
	 */
	@Column
	private Integer qh_m6_id_loan_num = 0;
	/**
	 * 12个月前海贷款申请次数
	 */
	@Column
	private Integer qh_m12_id_loan_num = 0;

	/**
	 * 1个月银行次数(身份证)
	 */
	@Column
	private Integer als_m1_id_bank_allnum = 0;
	/**
	 * 1个月非银行次数(身份证)
	 */
	@Column
	private Integer als_m1_id_nbank_allnum = 0;
	/**
	 * 1个月银行次数(手机号)
	 */
	@Column
	private Integer als_m1_cell_bank_allnum = 0;
	/**
	 * 1个月非银行次数(手机号)
	 */
	@Column
	private Integer als_m1_cell_nbank_allnum = 0;

	/**
	 * 3个月银行次数(身份证)
	 */
	@Column
	private Integer als_m3_id_bank_allnum = 0;
	/**
	 * 3个月非银行次数(身份证)
	 */
	@Column
	private Integer als_m3_id_nbank_allnum = 0;
	/**
	 * 3个月银行次数(手机号)
	 */
	@Column
	private Integer als_m3_cell_bank_allnum = 0;
	/**
	 * 3个月非银行次数(手机号)
	 */
	@Column
	private Integer als_m3_cell_nbank_allnum = 0;

	/**
	 * 6个月银行次数(身份证)
	 */
	@Column
	private Integer als_m6_id_bank_allnum = 0;
	/**
	 * 6个月非银行次数(身份证)
	 */
	@Column
	private Integer als_m6_id_nbank_allnum = 0;
	/**
	 * 6个月银行次数(手机号)
	 */
	@Column
	private Integer als_m6_cell_bank_allnum = 0;
	/**
	 * 6个月非银行次数(手机号)
	 */
	@Column
	private Integer als_m6_cell_nbank_allnum = 0;

	/**
	 * 12个月本银机构次数(身份证)
	 */
	@Column
	private Integer al_m12_id_bank_selfnum = 0;
	/**
	 * 12个月银行次数(身份证)
	 */
	@Column
	private Integer al_m12_id_bank_allnum = 0;
	/**
	 * 12个月本非银机构次数(身份证)
	 */
	@Column
	private Integer al_m12_id_notbank_selfnum = 0;
	/**
	 * 12个月非银行次数(身份证)
	 */
	@Column
	private Integer al_m12_id_notbank_allnum = 0;

	/**
	 * 12个月本银机构次数(手机号)
	 */
	@Column
	private Integer al_m12_cell_bank_selfnum = 0;
	/**
	 * 12个月银行次数(手机号)
	 */
	@Column
	private Integer al_m12_cell_bank_allnum = 0;
	/**
	 * 12个月本非银机构次数(手机号)
	 */
	@Column
	private Integer al_m12_cell_notbank_selfnum = 0;
	/**
	 * 12个月非银行次数(手机号)
	 */
	@Column
	private Integer al_m12_cell_notbank_allnum = 0;

	/* 前海反欺诈 */

	/**
	 * 命中第三方标注黑名单
	 */
	@Column(length = 8)
	private String isMachdBlMakt;
	/**
	 * 命中欺诈号码
	 */
	@Column(length = 8)
	private String isMachFraud;

	/* 前海风险度 */

	/**
	 * 来源代码
	 */
	@Column(length = 2)
	private String sourceId;
	/**
	 * 风险得分
	 */
	@Column(length = 8)
	private String rskScore;

	/**
	 * 风险标记
	 */
	@Column(length = 8)
	private String rskMark;
	/**
	 * 业务发生时间
	 */
	@Column(length = 24)
	private String dataBuildTime;

	/* 浅海一鉴通(手机号验证) */

	/**
	 * 手机验证结果
	 */
	@Column(length = 8)
	private String isOwnerMobile;
	/**
	 * 手机状态
	 */
	@Column(length = 8)
	private String ownerMobileStatus;
	/**
	 * 使用时间分数
	 */
	@Column(length = 8)
	private String useTimeScore;

	/* 前海驾驶证 */

	/**
	 * 驾驶证号
	 */
	@Column(length = 8)
	private String chkDriverNo;
	/**
	 * 姓名
	 */
	@Column(length = 8)
	private String chkName;
	/**
	 * 驾驶证状态的查询结果
	 */
	@Column(length = 64)
	private String chkStatus;

	/**
	 * @return ID
	 */
	public Long getRecordId() {
		return recordId;
	}

	/**
	 * @param ID
	 *            要设置的 recordId
	 */
	public void setRecordId(Long recordId) {
		this.recordId = recordId;
	}

	/**
	 * @return 查询请求用户员工编号
	 */
	public String getRequestUserId() {
		return requestUserId;
	}

	/**
	 * @param 查询请求用户员工编号
	 *            要设置的 requestUserId
	 */
	public void setRequestUserId(String requestUserId) {
		this.requestUserId = requestUserId;
	}

	/**
	 * @return 查询请求时间
	 */
	public Date getRequestDate() {
		return requestDate;
	}

	/**
	 * @param 查询请求时间
	 *            要设置的 requestDate
	 */
	public void setRequestDate(Date requestDate) {
		this.requestDate = requestDate;
	}

	/**
	 * @return 信贷申请记录
	 */
	public Integer getQh_m1_id_loan_num() {
		return qh_m1_id_loan_num;
	}

	/**
	 * @param 信贷申请记录
	 *            要设置的 qh_m1_id_loan_num
	 */
	public void setQh_m1_id_loan_num(Integer qh_m1_id_loan_num) {
		this.qh_m1_id_loan_num = qh_m1_id_loan_num;
	}

	/**
	 * @return 3个月前海贷款申请次数
	 */
	public Integer getQh_m3_id_loan_num() {
		return qh_m3_id_loan_num;
	}

	/**
	 * @param 3个月前海贷款申请次数
	 *            要设置的 qh_m3_id_loan_num
	 */
	public void setQh_m3_id_loan_num(Integer qh_m3_id_loan_num) {
		this.qh_m3_id_loan_num = qh_m3_id_loan_num;
	}

	/**
	 * @return 6个月前海贷款申请次数
	 */
	public Integer getQh_m6_id_loan_num() {
		return qh_m6_id_loan_num;
	}

	/**
	 * @param 6个月前海贷款申请次数
	 *            要设置的 qh_m6_id_loan_num
	 */
	public void setQh_m6_id_loan_num(Integer qh_m6_id_loan_num) {
		this.qh_m6_id_loan_num = qh_m6_id_loan_num;
	}

	/**
	 * @return 12个月前海贷款申请次数
	 */
	public Integer getQh_m12_id_loan_num() {
		return qh_m12_id_loan_num;
	}

	/**
	 * @param 12个月前海贷款申请次数
	 *            要设置的 qh_m12_id_loan_num
	 */
	public void setQh_m12_id_loan_num(Integer qh_m12_id_loan_num) {
		this.qh_m12_id_loan_num = qh_m12_id_loan_num;
	}

	/**
	 * @return 1个月银行次数(身份证)
	 */
	public Integer getAls_m1_id_bank_allnum() {
		return als_m1_id_bank_allnum;
	}

	/**
	 * @param 1个月银行次数(身份证)
	 *            要设置的 als_m1_id_bank_allnum
	 */
	public void setAls_m1_id_bank_allnum(Integer als_m1_id_bank_allnum) {
		this.als_m1_id_bank_allnum = als_m1_id_bank_allnum;
	}

	/**
	 * @return 1个月非银行次数(身份证)
	 */
	public Integer getAls_m1_id_nbank_allnum() {
		return als_m1_id_nbank_allnum;
	}

	/**
	 * @param 1个月非银行次数(身份证)
	 *            要设置的 als_m1_id_nbank_allnum
	 */
	public void setAls_m1_id_nbank_allnum(Integer als_m1_id_nbank_allnum) {
		this.als_m1_id_nbank_allnum = als_m1_id_nbank_allnum;
	}

	/**
	 * @return 1个月银行次数(手机号)
	 */
	public Integer getAls_m1_cell_bank_allnum() {
		return als_m1_cell_bank_allnum;
	}

	/**
	 * @param 1个月银行次数(手机号)
	 *            要设置的 als_m1_cell_bank_allnum
	 */
	public void setAls_m1_cell_bank_allnum(Integer als_m1_cell_bank_allnum) {
		this.als_m1_cell_bank_allnum = als_m1_cell_bank_allnum;
	}

	/**
	 * @return 1个月非银行次数(手机号)
	 */
	public Integer getAls_m1_cell_nbank_allnum() {
		return als_m1_cell_nbank_allnum;
	}

	/**
	 * @param 1个月非银行次数(手机号)
	 *            要设置的 als_m1_cell_nbank_allnum
	 */
	public void setAls_m1_cell_nbank_allnum(Integer als_m1_cell_nbank_allnum) {
		this.als_m1_cell_nbank_allnum = als_m1_cell_nbank_allnum;
	}

	/**
	 * @return 3个月银行次数(身份证)
	 */
	public Integer getAls_m3_id_bank_allnum() {
		return als_m3_id_bank_allnum;
	}

	/**
	 * @param 3个月银行次数(身份证)
	 *            要设置的 als_m3_id_bank_allnum
	 */
	public void setAls_m3_id_bank_allnum(Integer als_m3_id_bank_allnum) {
		this.als_m3_id_bank_allnum = als_m3_id_bank_allnum;
	}

	/**
	 * @return 3个月非银行次数(身份证)
	 */
	public Integer getAls_m3_id_nbank_allnum() {
		return als_m3_id_nbank_allnum;
	}

	/**
	 * @param 3个月非银行次数(身份证)
	 *            要设置的 als_m3_id_nbank_allnum
	 */
	public void setAls_m3_id_nbank_allnum(Integer als_m3_id_nbank_allnum) {
		this.als_m3_id_nbank_allnum = als_m3_id_nbank_allnum;
	}

	/**
	 * @return 3个月银行次数(手机号)
	 */
	public Integer getAls_m3_cell_bank_allnum() {
		return als_m3_cell_bank_allnum;
	}

	/**
	 * @param 3个月银行次数(手机号)
	 *            要设置的 als_m3_cell_bank_allnum
	 */
	public void setAls_m3_cell_bank_allnum(Integer als_m3_cell_bank_allnum) {
		this.als_m3_cell_bank_allnum = als_m3_cell_bank_allnum;
	}

	/**
	 * @return 3个月非银行次数(手机号)
	 */
	public Integer getAls_m3_cell_nbank_allnum() {
		return als_m3_cell_nbank_allnum;
	}

	/**
	 * @param 3个月非银行次数(手机号)
	 *            要设置的 als_m3_cell_nbank_allnum
	 */
	public void setAls_m3_cell_nbank_allnum(Integer als_m3_cell_nbank_allnum) {
		this.als_m3_cell_nbank_allnum = als_m3_cell_nbank_allnum;
	}

	/**
	 * @return 6个月银行次数(身份证)
	 */
	public Integer getAls_m6_id_bank_allnum() {
		return als_m6_id_bank_allnum;
	}

	/**
	 * @param 6个月银行次数(身份证)
	 *            要设置的 als_m6_id_bank_allnum
	 */
	public void setAls_m6_id_bank_allnum(Integer als_m6_id_bank_allnum) {
		this.als_m6_id_bank_allnum = als_m6_id_bank_allnum;
	}

	/**
	 * @return 6个月非银行次数(身份证)
	 */
	public Integer getAls_m6_id_nbank_allnum() {
		return als_m6_id_nbank_allnum;
	}

	/**
	 * @param 6个月非银行次数(身份证)
	 *            要设置的 als_m6_id_nbank_allnum
	 */
	public void setAls_m6_id_nbank_allnum(Integer als_m6_id_nbank_allnum) {
		this.als_m6_id_nbank_allnum = als_m6_id_nbank_allnum;
	}

	/**
	 * @return 6个月银行次数(手机号)
	 */
	public Integer getAls_m6_cell_bank_allnum() {
		return als_m6_cell_bank_allnum;
	}

	/**
	 * @param 6个月银行次数(手机号)
	 *            要设置的 als_m6_cell_bank_allnum
	 */
	public void setAls_m6_cell_bank_allnum(Integer als_m6_cell_bank_allnum) {
		this.als_m6_cell_bank_allnum = als_m6_cell_bank_allnum;
	}

	/**
	 * @return 6个月非银行次数(手机号)
	 */
	public Integer getAls_m6_cell_nbank_allnum() {
		return als_m6_cell_nbank_allnum;
	}

	/**
	 * @param 6个月非银行次数(手机号)
	 *            要设置的 als_m6_cell_nbank_allnum
	 */
	public void setAls_m6_cell_nbank_allnum(Integer als_m6_cell_nbank_allnum) {
		this.als_m6_cell_nbank_allnum = als_m6_cell_nbank_allnum;
	}

	/**
	 * @return 12个月本银机构次数(身份证)
	 */
	public Integer getAl_m12_id_bank_selfnum() {
		return al_m12_id_bank_selfnum;
	}

	/**
	 * @param 12个月本银机构次数(身份证)
	 *            要设置的 al_m12_id_bank_selfnum
	 */
	public void setAl_m12_id_bank_selfnum(Integer al_m12_id_bank_selfnum) {
		this.al_m12_id_bank_selfnum = al_m12_id_bank_selfnum;
	}

	/**
	 * @return 12个月银行次数(身份证)
	 */
	public Integer getAl_m12_id_bank_allnum() {
		return al_m12_id_bank_allnum;
	}

	/**
	 * @param 12个月银行次数(身份证)
	 *            要设置的 al_m12_id_bank_allnum
	 */
	public void setAl_m12_id_bank_allnum(Integer al_m12_id_bank_allnum) {
		this.al_m12_id_bank_allnum = al_m12_id_bank_allnum;
	}

	/**
	 * @return 12个月本非银机构次数(身份证)
	 */
	public Integer getAl_m12_id_notbank_selfnum() {
		return al_m12_id_notbank_selfnum;
	}

	/**
	 * @param 12个月本非银机构次数(身份证)
	 *            要设置的 al_m12_id_notbank_selfnum
	 */
	public void setAl_m12_id_notbank_selfnum(Integer al_m12_id_notbank_selfnum) {
		this.al_m12_id_notbank_selfnum = al_m12_id_notbank_selfnum;
	}

	/**
	 * @return 12个月非银行次数(身份证)
	 */
	public Integer getAl_m12_id_notbank_allnum() {
		return al_m12_id_notbank_allnum;
	}

	/**
	 * @param 12个月非银行次数(身份证)
	 *            要设置的 al_m12_id_notbank_allnum
	 */
	public void setAl_m12_id_notbank_allnum(Integer al_m12_id_notbank_allnum) {
		this.al_m12_id_notbank_allnum = al_m12_id_notbank_allnum;
	}

	/**
	 * @return 12个月本银机构次数(手机号)
	 */
	public Integer getAl_m12_cell_bank_selfnum() {
		return al_m12_cell_bank_selfnum;
	}

	/**
	 * @param 12个月本银机构次数(手机号)
	 *            要设置的 al_m12_cell_bank_selfnum
	 */
	public void setAl_m12_cell_bank_selfnum(Integer al_m12_cell_bank_selfnum) {
		this.al_m12_cell_bank_selfnum = al_m12_cell_bank_selfnum;
	}

	/**
	 * @return 12个月银行次数(手机号)
	 */
	public Integer getAl_m12_cell_bank_allnum() {
		return al_m12_cell_bank_allnum;
	}

	/**
	 * @param 12个月银行次数(手机号)
	 *            要设置的 al_m12_cell_bank_allnum
	 */
	public void setAl_m12_cell_bank_allnum(Integer al_m12_cell_bank_allnum) {
		this.al_m12_cell_bank_allnum = al_m12_cell_bank_allnum;
	}

	/**
	 * @return 12个月本非银机构次数(手机号)
	 */
	public Integer getAl_m12_cell_notbank_selfnum() {
		return al_m12_cell_notbank_selfnum;
	}

	/**
	 * @param 12个月本非银机构次数(手机号)
	 *            要设置的 al_m12_cell_notbank_selfnum
	 */
	public void setAl_m12_cell_notbank_selfnum(Integer al_m12_cell_notbank_selfnum) {
		this.al_m12_cell_notbank_selfnum = al_m12_cell_notbank_selfnum;
	}

	/**
	 * @return 12个月非银行次数(手机号)
	 */
	public Integer getAl_m12_cell_notbank_allnum() {
		return al_m12_cell_notbank_allnum;
	}

	/**
	 * @param 12个月非银行次数(手机号)
	 *            要设置的 al_m12_cell_notbank_allnum
	 */
	public void setAl_m12_cell_notbank_allnum(Integer al_m12_cell_notbank_allnum) {
		this.al_m12_cell_notbank_allnum = al_m12_cell_notbank_allnum;
	}

	/**
	 * @return 前海反欺诈
	 */
	public String getIsMachdBlMakt() {
		return isMachdBlMakt;
	}

	/**
	 * @param 前海反欺诈
	 *            要设置的 isMachdBlMakt
	 */
	public void setIsMachdBlMakt(String isMachdBlMakt) {
		this.isMachdBlMakt = isMachdBlMakt;
	}

	/**
	 * @return 命中欺诈号码
	 */
	public String getIsMachFraud() {
		return isMachFraud;
	}

	/**
	 * @param 命中欺诈号码
	 *            要设置的 isMachFraud
	 */
	public void setIsMachFraud(String isMachFraud) {
		this.isMachFraud = isMachFraud;
	}

	/**
	 * @return 前海风险度
	 */
	public String getSourceId() {
		return sourceId;
	}

	/**
	 * @param 前海风险度
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

	/**
	 * @return 浅海一鉴通(手机号验证)
	 */
	public String getIsOwnerMobile() {
		return isOwnerMobile;
	}

	/**
	 * @param 浅海一鉴通(手机号验证)
	 *            要设置的 isOwnerMobile
	 */
	public void setIsOwnerMobile(String isOwnerMobile) {
		this.isOwnerMobile = isOwnerMobile;
	}

	/**
	 * @return 手机状态
	 */
	public String getOwnerMobileStatus() {
		return ownerMobileStatus;
	}

	/**
	 * @param 手机状态
	 *            要设置的 ownerMobileStatus
	 */
	public void setOwnerMobileStatus(String ownerMobileStatus) {
		this.ownerMobileStatus = ownerMobileStatus;
	}

	/**
	 * @return 使用时间分数
	 */
	public String getUseTimeScore() {
		return useTimeScore;
	}

	/**
	 * @param 使用时间分数
	 *            要设置的 useTimeScore
	 */
	public void setUseTimeScore(String useTimeScore) {
		this.useTimeScore = useTimeScore;
	}

	/**
	 * @return 前海驾驶证
	 */
	public String getChkDriverNo() {
		return chkDriverNo;
	}

	/**
	 * @param 前海驾驶证
	 *            要设置的 chkDriverNo
	 */
	public void setChkDriverNo(String chkDriverNo) {
		this.chkDriverNo = chkDriverNo;
	}

	/**
	 * @return 姓名
	 */
	public String getChkName() {
		return chkName;
	}

	/**
	 * @param 姓名
	 *            要设置的 chkName
	 */
	public void setChkName(String chkName) {
		this.chkName = chkName;
	}

	/**
	 * @return 驾驶证状态的查询结果
	 */
	public String getChkStatus() {
		return chkStatus;
	}

	/**
	 * @param 驾驶证状态的查询结果
	 *            要设置的 chkStatus
	 */
	public void setChkStatus(String chkStatus) {
		this.chkStatus = chkStatus;
	}

	/**
	 * @return creditId
	 */
	public Long getCreditId() {
		return creditId;
	}

	/**
	 * @param creditId
	 *            要设置的 creditId
	 */
	public void setCreditId(Long creditId) {
		this.creditId = creditId;
	}

	/**
	 * @return creditCrimeInfoSet
	 */
	public Set<CreditCrimeInfo> getCreditCrimeInfoSet() {
		return creditCrimeInfoSet;
	}

	/**
	 * @param creditCrimeInfoSet
	 *            要设置的 creditCrimeInfoSet
	 */
	public void setCreditCrimeInfoSet(Set<CreditCrimeInfo> creditCrimeInfoSet) {
		this.creditCrimeInfoSet = creditCrimeInfoSet;
	}

	/**
	 * @return creditExecutionSet
	 */
	public Set<CreditExecution> getCreditExecutionSet() {
		return CreditExecutionSet;
	}

	/**
	 * @param creditExecutionSet
	 *            要设置的 creditExecutionSet
	 */
	public void setCreditExecutionSet(Set<CreditExecution> creditExecutionSet) {
		CreditExecutionSet = creditExecutionSet;
	}

	/**
	 * @return creditPerInvestSet
	 */
	public Set<CreditPerInvest> getCreditPerInvestSet() {
		return CreditPerInvestSet;
	}

	/**
	 * @param creditPerInvestSet
	 *            要设置的 creditPerInvestSet
	 */
	public void setCreditPerInvestSet(Set<CreditPerInvest> creditPerInvestSet) {
		CreditPerInvestSet = creditPerInvestSet;
	}

}
