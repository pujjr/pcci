package com.pujjr.pcci.dal.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MapKey;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.OrderBy;

import com.pujjr.pcci.api.type.CreditQueryType;

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
	private Long id;

	@Column(length = 64, unique = true)
	private String creditId;

	/* 个人不良信息 */
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "creditQueryResult")
	private List<CreditCrimeInfo> creditCrimeInfoList = new ArrayList<>();

	/* 失信被执行记录 */
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "creditQueryResult")
	private List<CreditExecution> creditExecutionList = new ArrayList<>();

	/* 对外投资 */
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "creditQueryResult")
	private List<CreditPerInvest> creditPerInvestList = new ArrayList<>();

	/* 风险度 */
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "creditQueryResult")
	private List<CreditRskdoo> creditRskdooList = new ArrayList<>();

	/* 查询任务状态 */
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "creditQueryResult")
	@MapKey(name = "queryType")
	@OrderBy("queryTypeName asc")
	private Map<String, QueryTask> queryTaskMap = new LinkedHashMap<>();

	/* 查询请求信息 */
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "creditQueryResult")
	private CreditRequest creditRequest = new CreditRequest();

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
	 * 1个月百融贷款申请次数(身份证)
	 */
	@Column
	private Integer br_m1_id_loan_num = 0;
	/**
	 * 3个月百融贷款申请次数(身份证)
	 */
	@Column
	private Integer br_m3_id_loan_num = 0;
	/**
	 * 6个月百融贷款申请次数(身份证)
	 */
	@Column
	private Integer br_m6_id_loan_num = 0;
	/**
	 * 12个月百融贷款申请次数(身份证)
	 */
	@Column
	private Integer br_m12_id_loan_num = 0;

	/**
	 * 1个月百融贷款申请次数(手机号)
	 */
	@Column
	private Integer br_m1_cell_loan_num = 0;
	/**
	 * 3个月百融贷款申请次数(手机号)
	 */
	@Column
	private Integer br_m3_cell_loan_num = 0;
	/**
	 * 6个月百融贷款申请次数(手机号)
	 */
	@Column
	private Integer br_m6_cell_loan_num = 0;
	/**
	 * 12个月百融贷款申请次数(手机号)
	 */
	@Column
	private Integer br_m12_cell_loan_num = 0;

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
	 * 驾驶证号查询号
	 */
	@Column(length = 24)
	private String queryId;

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
	public Long getId() {
		return id;
	}

	/**
	 * @param ID
	 *            要设置的 recordId
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return creditCrimeInfoList
	 */
	public List<CreditCrimeInfo> getCreditCrimeInfoList() {
		return creditCrimeInfoList;
	}

	/**
	 * @param creditCrimeInfoList
	 *            要设置的 creditCrimeInfoList
	 */
	public void setCreditCrimeInfoList(List<CreditCrimeInfo> creditCrimeInfoList) {
		this.creditCrimeInfoList = creditCrimeInfoList;
	}

	/**
	 * @return creditExecutionList
	 */
	public List<CreditExecution> getCreditExecutionList() {
		return creditExecutionList;
	}

	/**
	 * @param creditExecutionList
	 *            要设置的 creditExecutionList
	 */
	public void setCreditExecutionList(List<CreditExecution> creditExecutionList) {
		this.creditExecutionList = creditExecutionList;
	}

	/**
	 * @return creditPerInvestList
	 */
	public List<CreditPerInvest> getCreditPerInvestList() {
		return creditPerInvestList;
	}

	/**
	 * @param creditPerInvestList
	 *            要设置的 creditPerInvestList
	 */
	public void setCreditPerInvestList(List<CreditPerInvest> creditPerInvestList) {
		this.creditPerInvestList = creditPerInvestList;
	}

	/**
	 * @return creditRskdooList
	 */
	public List<CreditRskdoo> getCreditRskdooList() {
		return creditRskdooList;
	}

	/**
	 * @param creditRskdooList
	 *            要设置的 creditRskdooList
	 */
	public void setCreditRskdooList(List<CreditRskdoo> creditRskdooList) {
		this.creditRskdooList = creditRskdooList;
	}

	/**
	 * @return queryTaskMap
	 */
	public Map<String, QueryTask> getQueryTaskMap() {
		return queryTaskMap;
	}

	/**
	 * @param queryTaskMap
	 *            要设置的 queryTaskMap
	 */
	public void setQueryTaskMap(Map<String, QueryTask> queryTaskMap) {
		this.queryTaskMap = queryTaskMap;
	}

	/**
	 * @return creditRequest
	 */
	public CreditRequest getCreditRequest() {
		return creditRequest;
	}

	/**
	 * @param creditRequest
	 *            要设置的 creditRequest
	 */
	public void setCreditRequest(CreditRequest creditRequest) {
		this.creditRequest = creditRequest;
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
	 * @return 1个月百融贷款申请次数(身份证)
	 */
	public Integer getBr_m1_id_loan_num() {
		return br_m1_id_loan_num;
	}

	/**
	 * @param 1个月百融贷款申请次数(身份证)
	 *            要设置的 br_m1_id_loan_num
	 */
	public void setBr_m1_id_loan_num(Integer br_m1_id_loan_num) {
		this.br_m1_id_loan_num = br_m1_id_loan_num;
	}

	/**
	 * @return 3个月百融贷款申请次数(身份证)
	 */
	public Integer getBr_m3_id_loan_num() {
		return br_m3_id_loan_num;
	}

	/**
	 * @param 3个月百融贷款申请次数(身份证)
	 *            要设置的 br_m3_id_loan_num
	 */
	public void setBr_m3_id_loan_num(Integer br_m3_id_loan_num) {
		this.br_m3_id_loan_num = br_m3_id_loan_num;
	}

	/**
	 * @return 6个月百融贷款申请次数(身份证)
	 */
	public Integer getBr_m6_id_loan_num() {
		return br_m6_id_loan_num;
	}

	/**
	 * @param 6个月百融贷款申请次数(身份证)
	 *            要设置的 br_m6_id_loan_num
	 */
	public void setBr_m6_id_loan_num(Integer br_m6_id_loan_num) {
		this.br_m6_id_loan_num = br_m6_id_loan_num;
	}

	/**
	 * @return 12个月百融贷款申请次数(身份证)
	 */
	public Integer getBr_m12_id_loan_num() {
		return br_m12_id_loan_num;
	}

	/**
	 * @param 12个月百融贷款申请次数(身份证)
	 *            要设置的 br_m12_id_loan_num
	 */
	public void setBr_m12_id_loan_num(Integer br_m12_id_loan_num) {
		this.br_m12_id_loan_num = br_m12_id_loan_num;
	}

	/**
	 * @return 1个月百融贷款申请次数(手机号)
	 */
	public Integer getBr_m1_cell_loan_num() {
		return br_m1_cell_loan_num;
	}

	/**
	 * @param 1个月百融贷款申请次数(手机号)
	 *            要设置的 br_m1_cell_loan_num
	 */
	public void setBr_m1_cell_loan_num(Integer br_m1_cell_loan_num) {
		this.br_m1_cell_loan_num = br_m1_cell_loan_num;
	}

	/**
	 * @return 3个月百融贷款申请次数(手机号)
	 */
	public Integer getBr_m3_cell_loan_num() {
		return br_m3_cell_loan_num;
	}

	/**
	 * @param 3个月百融贷款申请次数(手机号)
	 *            要设置的 br_m3_cell_loan_num
	 */
	public void setBr_m3_cell_loan_num(Integer br_m3_cell_loan_num) {
		this.br_m3_cell_loan_num = br_m3_cell_loan_num;
	}

	/**
	 * @return 6个月百融贷款申请次数(手机号)
	 */
	public Integer getBr_m6_cell_loan_num() {
		return br_m6_cell_loan_num;
	}

	/**
	 * @param 6个月百融贷款申请次数(手机号)
	 *            要设置的 br_m6_cell_loan_num
	 */
	public void setBr_m6_cell_loan_num(Integer br_m6_cell_loan_num) {
		this.br_m6_cell_loan_num = br_m6_cell_loan_num;
	}

	/**
	 * @return 12个月百融贷款申请次数(手机号)
	 */
	public Integer getBr_m12_cell_loan_num() {
		return br_m12_cell_loan_num;
	}

	/**
	 * @param 12个月百融贷款申请次数(手机号)
	 *            要设置的 br_m12_cell_loan_num
	 */
	public void setBr_m12_cell_loan_num(Integer br_m12_cell_loan_num) {
		this.br_m12_cell_loan_num = br_m12_cell_loan_num;
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
	public String getQueryId() {
		return queryId;
	}

	/**
	 * @param 前海驾驶证
	 *            要设置的 queryId
	 */
	public void setQueryId(String queryId) {
		this.queryId = queryId;
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
	public String getCreditId() {
		return creditId;
	}

	/**
	 * @param creditId
	 *            要设置的 creditId
	 */
	public void setCreditId(String creditId) {
		this.creditId = creditId;
	}

	public QueryTask getQueryTask(CreditQueryType key) {
		if (queryTaskMap.get(key.name()) != null) {
			return queryTaskMap.get(key.name());
		}
		QueryTask queryTask = new QueryTask();
		queryTask.init(key, this);
		queryTaskMap.put(key.name(), queryTask);
		return queryTask;
	}
}
