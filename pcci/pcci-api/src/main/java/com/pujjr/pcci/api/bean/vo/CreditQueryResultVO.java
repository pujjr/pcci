package com.pujjr.pcci.api.bean.vo;

import java.io.Serializable;
import java.util.List;

/**
 * @author wen
 * @date 创建时间：2016年10月17日 下午3:00:48 征信查询结果记录表
 *
 */
public class CreditQueryResultVO implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * ID
	 */
	private Long recordId;

	private String creditId;

	/* 个人不良信息 */
	private List<CreditCrimeInfoVO> creditCrimeInfoList;

	/* 失信被执行记录 */
	private List<CreditExecutionVO> creditExecutionList;

	/* 对外投资 */
	private List<CreditPerInvestVO> creditPerInvestList;

	/* 请求记录 */
	private CreditRequestVO creditRequest;

	/* 信贷申请记录 */

	/**
	 * 1个月前海贷款申请次数
	 */
	private Integer qh_m1_id_loan_num = 0;
	/**
	 * 3个月前海贷款申请次数
	 */
	private Integer qh_m3_id_loan_num = 0;
	/**
	 * 6个月前海贷款申请次数
	 */

	private Integer qh_m6_id_loan_num = 0;
	/**
	 * 12个月前海贷款申请次数
	 */

	private Integer qh_m12_id_loan_num = 0;

	/**
	 * 1个月百融贷款申请次数(身份证)
	 */
	private Integer br_m1_id_loan_num = 0;
	/**
	 * 3个月百融贷款申请次数(身份证)
	 */
	private Integer br_m3_id_loan_num = 0;
	/**
	 * 6个月百融贷款申请次数(身份证)
	 */
	private Integer br_m6_id_loan_num = 0;
	/**
	 * 12个月百融贷款申请次数(身份证)
	 */
	private Integer br_m12_id_loan_num = 0;

	/**
	 * 1个月百融贷款申请次数(手机号)
	 */
	private Integer br_m1_cell_loan_num = 0;
	/**
	 * 3个月百融贷款申请次数(手机号)
	 */
	private Integer br_m3_cell_loan_num = 0;
	/**
	 * 6个月百融贷款申请次数(手机号)
	 */
	private Integer br_m6_cell_loan_num = 0;
	/**
	 * 12个月百融贷款申请次数(手机号)
	 */
	private Integer br_m12_cell_loan_num = 0;

	/* 前海反欺诈 */

	/**
	 * 命中第三方标注黑名单
	 */
	private String isMachdBlMakt;
	/**
	 * 命中欺诈号码
	 */
	private String isMachFraud;

	/* 前海风险度 */

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

	/* 浅海一鉴通(手机号验证) */

	/**
	 * 手机验证结果
	 */
	private String isOwnerMobile;
	/**
	 * 手机状态
	 */
	private String ownerMobileStatus;
	/**
	 * 使用时间分数
	 */
	private String useTimeScore;

	/* 前海驾驶证 */

	/**
	 * 驾驶证号
	 */
	private String chkDriverNo;
	/**
	 * 姓名
	 */
	private String chkName;
	/**
	 * 驾驶证状态的查询结果
	 */
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

	/**
	 * @return creditCrimeInfoList
	 */
	public List<CreditCrimeInfoVO> getCreditCrimeInfoList() {
		return creditCrimeInfoList;
	}

	/**
	 * @param creditCrimeInfoList
	 *            要设置的 creditCrimeInfoList
	 */
	public void setCreditCrimeInfoList(List<CreditCrimeInfoVO> creditCrimeInfoList) {
		this.creditCrimeInfoList = creditCrimeInfoList;
	}

	/**
	 * @return creditExecutionList
	 */
	public List<CreditExecutionVO> getCreditExecutionList() {
		return creditExecutionList;
	}

	/**
	 * @param creditExecutionList
	 *            要设置的 creditExecutionList
	 */
	public void setCreditExecutionList(List<CreditExecutionVO> creditExecutionList) {
		this.creditExecutionList = creditExecutionList;
	}

	/**
	 * @return creditPerInvestList
	 */
	public List<CreditPerInvestVO> getCreditPerInvestList() {
		return creditPerInvestList;
	}

	/**
	 * @param creditPerInvestList
	 *            要设置的 creditPerInvestList
	 */
	public void setCreditPerInvestList(List<CreditPerInvestVO> creditPerInvestList) {
		this.creditPerInvestList = creditPerInvestList;
	}

	/**
	 * @return creditRequest
	 */
	public CreditRequestVO getCreditRequest() {
		return creditRequest;
	}

	/**
	 * @param creditRequest
	 *            要设置的 creditRequest
	 */
	public void setCreditRequest(CreditRequestVO creditRequest) {
		this.creditRequest = creditRequest;
	}

}
