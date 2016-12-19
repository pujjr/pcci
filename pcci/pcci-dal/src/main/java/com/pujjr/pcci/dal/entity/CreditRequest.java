package com.pujjr.pcci.dal.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.pujjr.pcci.api.type.IdentityType;
import com.pujjr.pcci.api.type.QueryReasonType;

/**
 * @author wen
 * @date 创建时间：2016年10月10日 上午10:43:35 个人不良信息
 */
@Entity
@Table(uniqueConstraints = { @UniqueConstraint(columnNames = { "name", "mobile_no", "id_no" }) })
public class CreditRequest implements Serializable {

	private static final long serialVersionUID = 1L;

	/** 失败代码 成功 */
	public static final int ERROR_STATUS_SUCCESS = 1;

	/** 失败代码 成功 */
	public static final int ERROR_STATUS_FAIL = 0;

	/** 无数据 */
	public static final int RISK_LEVEL_NONE = 0;
	/** 低风险 */
	public static final int RISK_LEVEL_LOW = 1;
	/** 高风险 */
	public static final int RISK_LEVEL_HIGH = 2;
	/** 无数据 */
	public static final int INVEST_NO = 0;
	/** 有 */
	public static final int INVEST_YES = 1;
	/** 无数据 */
	public static final int CRIMINAL_NO = 0;
	/** 有(需其他渠道查询) */
	public static final int CRIMINAL_YES = 1;

	/**
	 * ID
	 */
	@Id
	@Column(length = 64, nullable = true)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	/**
	 * 唯一流水号ID
	 */
	@Column(length = 64, unique = true)
	private String creditId;

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

	/**
	 * 姓名
	 */
	@Column(nullable = false)
	private String name;

	/**
	 * 手机号
	 */
	@Column(nullable = false, length = 24)
	private String mobileNo;

	/**
	 * 证件号
	 */
	@Column(nullable = false, length = 24)
	private String idNo;

	/**
	 * 证件类型 {@link IdentityType}
	 */
	@Column(nullable = false, length = 8)
	private String idType;

	/**
	 * 查询原因 {@link QueryReasonType}
	 */
	@Column(nullable = false, length = 8)
	private String reasonCode;

	/**
	 * 信息主体授权码 若不涉及授权则填唯一的随机序列
	 */
	@Column(nullable = false, length = 32)
	private String entityAuthCode;
	/**
	 * 信息主体授权时间 yyyy-MM-dd
	 */
	@Column(nullable = false, length = 32)
	private String entityAuthDate;
	/**
	 * 风险级别
	 */
	@Column
	private Integer riskLevel;
	/**
	 * 对外投资信息
	 */
	@Column
	private Integer investInfo;
	/**
	 * 犯罪记录
	 */
	@Column
	private Integer criminalRecord;

	/**
	 * 云存储标识
	 */
	@Column
	private String ossKey;

	/**
	 * 错误状态
	 */
	@Column
	private Integer errStatus = 0;

	/**
	 * 征信查询结果
	 */
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "fk_record_id")
	private CreditQueryResult creditQueryResult;

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
	 * @return 唯一流水号ID
	 */
	public String getCreditId() {
		return creditId;
	}

	/**
	 * @param 唯一流水号ID
	 *            要设置的 creditId
	 */
	public void setCreditId(String creditId) {
		this.creditId = creditId;
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
	 * @return 姓名
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param 姓名
	 *            要设置的 name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return 手机号
	 */
	public String getMobileNo() {
		return mobileNo;
	}

	/**
	 * @param 手机号
	 *            要设置的 mobileNo
	 */
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	/**
	 * @return 证件号
	 */
	public String getIdNo() {
		return idNo;
	}

	/**
	 * @param 证件号
	 *            要设置的 idNo
	 */
	public void setIdNo(String idNo) {
		this.idNo = idNo;
	}

	/**
	 * @return 证件类型{@link IdentityType}
	 */
	public String getIdType() {
		return idType;
	}

	/**
	 * @param 证件类型{@link
	 * 			IdentityType} 要设置的 idType
	 */
	public void setIdType(String idType) {
		this.idType = idType;
	}

	/**
	 * @return 查询原因{@link QueryReasonType}
	 */
	public String getReasonCode() {
		return reasonCode;
	}

	/**
	 * @param 查询原因{@link
	 * 			QueryReasonType} 要设置的 reasonCode
	 */
	public void setReasonCode(String reasonCode) {
		this.reasonCode = reasonCode;
	}

	/**
	 * @return 信息主体授权码若不涉及授权则填唯一的随机序列
	 */
	public String getEntityAuthCode() {
		return entityAuthCode;
	}

	/**
	 * @param 信息主体授权码若不涉及授权则填唯一的随机序列
	 *            要设置的 entityAuthCode
	 */
	public void setEntityAuthCode(String entityAuthCode) {
		this.entityAuthCode = entityAuthCode;
	}

	/**
	 * @return 信息主体授权时间yyyy-MM-dd
	 */
	public String getEntityAuthDate() {
		return entityAuthDate;
	}

	/**
	 * @param 信息主体授权时间yyyy-MM-dd
	 *            要设置的 entityAuthDate
	 */
	public void setEntityAuthDate(String entityAuthDate) {
		this.entityAuthDate = entityAuthDate;
	}

	/**
	 * @return 风险级别
	 */
	public Integer getRiskLevel() {
		return riskLevel;
	}

	/**
	 * @param 风险级别
	 *            要设置的 riskLevel
	 */
	public void setRiskLevel(Integer riskLevel) {
		this.riskLevel = riskLevel;
	}

	/**
	 * @return 对外投资信息
	 */
	public Integer getInvestInfo() {
		return investInfo;
	}

	/**
	 * @param 对外投资信息
	 *            要设置的 investInfo
	 */
	public void setInvestInfo(Integer investInfo) {
		this.investInfo = investInfo;
	}

	/**
	 * @return 犯罪记录
	 */
	public Integer getCriminalRecord() {
		return criminalRecord;
	}

	/**
	 * @param 犯罪记录
	 *            要设置的 criminalRecord
	 */
	public void setCriminalRecord(Integer criminalRecord) {
		this.criminalRecord = criminalRecord;
	}

	/**
	 * @return 云存储标识
	 */
	public String getOssKey() {
		return ossKey;
	}

	/**
	 * @param 云存储标识
	 *            要设置的 ossKey
	 */
	public void setOssKey(String ossKey) {
		this.ossKey = ossKey;
	}

	/**
	 * @return 错误状态
	 */
	public Integer getErrStatus() {
		return errStatus;
	}

	/**
	 * @param 错误状态
	 *            要设置的 errStatus
	 */
	public void setErrStatus(Integer errStatus) {
		this.errStatus = errStatus;
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
