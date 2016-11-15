package com.pujjr.pcci.dal.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.pujjr.common.type.credit.QueryProductType;

/**
 * @author wen
 * @date 创建时间：2016年10月17日 下午3:00:48 前海调用查询请求数据记录表
 *
 */
@Entity
public class QianHaiResult implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * ID
	 */
	@Id
	@Column(length = 64, nullable = true)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long recordId;

	/**
	 * 交易唯一标识
	 */
	@Column(nullable = false, length = 24)
	private String transNo;

	/**
	 * 交易批次号
	 */
	@Column(nullable = false, length = 24)
	private String batchNo;

	/**
	 * 查询产品类型
	 */
	@Enumerated(EnumType.STRING)
	@Column(nullable = false, length = 64)
	private QueryProductType queryProductType;

	/**
	 * 序列号
	 */
	@Column(nullable = false, length = 24)
	private String seqNo;

	/**
	 * 错误代码
	 */
	@Column(nullable = false, length = 8)
	private String erCode;

	/**
	 * 错误信息
	 */
	@Column(nullable = false)
	private String erMsg;

	/**
	 * 手机号码
	 */
	@Column(length = 24)
	private String mobileNo;
	/**
	 * IP地址
	 */
	@Column(length = 24)
	private String ip;

	/**
	 * 命中暴力破解
	 */
	@Column(length = 8)
	private String isMachdForce;
	/**
	 * 命中DNS服务器
	 */
	@Column(length = 8)
	private String isMachdDNS;
	/**
	 * 命中邮件服务器
	 */
	@Column(length = 8)
	private String isMachdMailServ;
	/**
	 * 命中seo
	 */
	@Column(length = 8)
	private String seoisMachdSEO;
	/**
	 * 命中组织出口
	 */
	@Column(length = 8)
	private String isMachdOrg;
	/**
	 * 命中爬虫
	 */
	@Column(length = 8)
	private String isMachdCrawler;
	/**
	 * 命中代理服务器
	 */
	@Column(length = 8)
	private String isMachdProxy;
	/**
	 * 命中第三方标注黑名单
	 */
	@Column(length = 8)
	private String isMachdBlacklist;
	/**
	 * 命中web服务器
	 */
	@Column(length = 8)
	private String isMachdWebServ;
	/**
	 * 命中vpn服务器
	 */
	@Column(length = 8)
	private String isMachdVPN;

	/**
	 * 命中第三方标注黑名单
	 */
	@Column(length = 8)
	private String isMachdBlMakt;
	/**
	 * 命中骚扰电话
	 */
	@Column(length = 8)
	private String isMachCraCall;
	/**
	 * 命中欺诈号码
	 */
	@Column(length = 8)
	private String isMachFraud;
	/**
	 * 命中空号（非正常短信语音号码）
	 */
	@Column(length = 8)
	private String isMachEmpty;
	/**
	 * 命中收码平台号码
	 */
	@Column(length = 8)
	private String isMachYZmobile;
	/**
	 * 命中小号
	 */
	@Column(length = 8)
	private String isMachSmallNo;
	/**
	 * 命中社工库号码
	 */
	@Column(length = 8)
	private String isMachSZNo;
	/**
	 * ip风险时间
	 */
	@Column(length = 24)
	private String iUpdateDate;
	/**
	 * 手机号码风险时间
	 */
	@Column(length = 24)
	private String mUpdateDate;
	/**
	 * IP风险描述
	 */
	@Column(length = 1024)
	private String iRskDesc;
	/**
	 * 手机号码风险描述
	 */
	@Column(length = 1024)
	private String mRskDesc;

	/**
	 * 任务
	 */
	@Column(length = 64)
	private String queryId;
	/**
	 * 任务提交交易流水号
	 */
	@Column(length = 24)
	private String submitTransNo;
	/**
	 * 整体比对结果
	 */
	@Column(length = 8)
	private String chkResult;
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
	 * 出生日期
	 */
	@Column(length = 8)
	private String chkBirthday;
	/**
	 * 出生日期前4位
	 */
	@Column(length = 8)
	private String chkBirthday4;
	/**
	 * 出生日期前6位
	 */
	@Column(length = 8)
	private String chkBirthday6;
	/**
	 * 档案编号
	 */
	@Column(length = 8)
	private String chkArchivesNo;
	/**
	 * 准驾车型
	 */
	@Column(length = 8)
	private String chkQuasiDrivingVehicle;
	/**
	 * 国籍
	 */
	@Column(length = 8)
	private String chkNationality;
	/**
	 * 初次领证日期
	 */
	@Column(length = 8)
	private String chkFirstLicensingDate;
	/**
	 * 初次领证日期前4位(年份)
	 */
	@Column(length = 8)
	private String chkFirstLicensingDate4;
	/**
	 * 初次领证日期前6位(年)
	 */
	@Column(length = 8)
	private String chkFirstLicensingDate6;
	/**
	 * 有效期始
	 */
	@Column(length = 8)
	private String chkValidDateStart;
	/**
	 * 有效期始日期前4位(年份)
	 */
	@Column(length = 8)
	private String chkValidDateStart4;
	/**
	 * 有效期始日期前6位(年)
	 */
	@Column(length = 8)
	private String chkValidDateStart6;
	/**
	 * 有效期
	 */
	@Column(length = 8)
	private String chkValidDateEnd;
	/**
	 * 有效期止日期前4位(年份)
	 */
	@Column(length = 8)
	private String chkValidDateEnd4;
	/**
	 * 有效期止日期前6位(年)
	 */
	@Column(length = 8)
	private String chkValidDateEnd6;
	/**
	 * 驾驶证状态的查询结果
	 */
	@Column(length = 8)
	private String chkStatus;

	/**
	 * 是否真实身份
	 */
	@Column(length = 8)
	private String isRealIdentity;
	/**
	 * 是否本人真实活动地址
	 */
	@Column(length = 8)
	private String isValidAddress;
	/**
	 * 地址类型
	 */
	@Column(length = 256)
	private String addressType;
	/**
	 * 是否真实工作单位
	 */
	@Column(length = 8)
	private String isRealCompany;
	/**
	 * 单位匹配度分值
	 */
	@Column(length = 8)
	private String companySimDeg;
	/**
	 * 单位最初出现时间
	 */
	@Column(length = 24)
	private String appear1ThDate;
	/**
	 * 单位最近一次出现时间
	 */
	@Column(length = 24)
	private String appearLastDate;
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
	/**
	 * 是否存在关系
	 */
	@Column(length = 8)
	private String isExistRel;
	/**
	 * 关系力度
	 */
	@Column(length = 8)
	private String relLevel;
	/**
	 * 车辆验证结果
	 */
	@Column(length = 1)
	private String carChkResult;
	/**
	 * 是否异步返回结果
	 */
	@Column(length = 1)
	private String isAsyned;
	/**
	 * 车型
	 */
	@Column(length = 64)
	private String carTypeInc;
	/**
	 * 厂牌
	 */
	@Column(length = 128)
	private String carFactoryInc;
	/**
	 * 新车购置价
	 */
	@Column(length = 24)
	private String carPrice;
	/**
	 * 行驶证状态查询Id号
	 */
	@Column(length = 64)
	private String drvStatusQryId;
	/**
	 * 房屋验证结果
	 */
	@Column(length = 1)
	private String houseChkResult;
	/**
	 * 房屋数据获取时间
	 */
	@Column(length = 24)
	private String houseDataDate;
	/**
	 * 相片比对结果
	 */
	@Column
	private String photoCmpResult;
	/**
	 * 相片相似度
	 */
	@Column(length = 64)
	private String photoSimDeg;
	/**
	 * 是否本人真实最高学历
	 */
	@Column(length = 1)
	private String isHighestEduBkg;
	/**
	 * 数据获取时间
	 */
	@Column(length = 8)
	private String dataDate;
	/**
	 * 毕业院校
	 */
	@Column(length = 64)
	private String graduateSchool;
	/**
	 * 毕业专业
	 */
	@Column(length = 64)
	private String graduateMajor;
	/**
	 * 毕业年份
	 */
	@Column(length = 8)
	private String graduateYear;
	/**
	 * 手机验证II结果
	 */
	@Column(length = 8)
	private String isOwnerMobileII;
	/**
	 * 手机状态II
	 */
	@Column(length = 8)
	private String ownerMobileStatusII;
	/**
	 * 使用时间分数II
	 */
	@Column(length = 8)
	private String useTimeScoreII;
	/**
	 * 错误信息
	 */
	@Column(length = 255)
	private String errorInfo;

	/**
	 * 查询原因
	 */
	@Column(length = 2)
	private String reasonCode;

	/**
	 * 机构所属行业
	 */
	@Column(length = 8)
	private String industry;

	/**
	 * 命中机构数目
	 */
	@Column(length = 16)
	private String amount;

	/**
	 * 业务发生时间
	 */
	@Column(length = 255)
	private String busiDate;

	/**
	 * 证件号
	 */
	@Column(nullable = false, length = 64)
	private String idNo;

	/**
	 * 证件类型
	 */
	@Column(nullable = false, length = 2)
	private String idType;

	/**
	 * 主体名称
	 */
	@Column(nullable = false, length = 128)
	private String name;

	/**
	 * 来源代码
	 */
	@Column(length = 2)
	private String sourceId;

	/**
	 * 风险的分
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

	/**
	 * 数据状态
	 */
	@Column(length = 2)
	private String dataStatus;

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
	 * @return 交易唯一标识
	 */
	public String getTransNo() {
		return transNo;
	}

	/**
	 * @param 交易唯一标识
	 *            要设置的 transNo
	 */
	public void setTransNo(String transNo) {
		this.transNo = transNo;
	}

	/**
	 * @return 交易批次号
	 */
	public String getBatchNo() {
		return batchNo;
	}

	/**
	 * @param 交易批次号
	 *            要设置的 batchNo
	 */
	public void setBatchNo(String batchNo) {
		this.batchNo = batchNo;
	}

	/**
	 * @return 查询产品类型
	 */
	public QueryProductType getQueryProductType() {
		return queryProductType;
	}

	/**
	 * @param 查询产品类型
	 *            要设置的 queryProductType
	 */
	public void setQueryProductType(QueryProductType queryProductType) {
		this.queryProductType = queryProductType;
	}

	/**
	 * @return 序列号
	 */
	public String getSeqNo() {
		return seqNo;
	}

	/**
	 * @param 序列号
	 *            要设置的 seqNo
	 */
	public void setSeqNo(String seqNo) {
		this.seqNo = seqNo;
	}

	/**
	 * @return 错误代码
	 */
	public String getErCode() {
		return erCode;
	}

	/**
	 * @param 错误代码
	 *            要设置的 erCode
	 */
	public void setErCode(String erCode) {
		this.erCode = erCode;
	}

	/**
	 * @return 错误信息
	 */
	public String getErMsg() {
		return erMsg;
	}

	/**
	 * @param 错误信息
	 *            要设置的 erMsg
	 */
	public void setErMsg(String erMsg) {
		this.erMsg = erMsg;
	}

	/**
	 * @return 手机号码
	 */
	public String getMobileNo() {
		return mobileNo;
	}

	/**
	 * @param 手机号码
	 *            要设置的 mobileNo
	 */
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	/**
	 * @return IP地址
	 */
	public String getIp() {
		return ip;
	}

	/**
	 * @param IP地址
	 *            要设置的 ip
	 */
	public void setIp(String ip) {
		this.ip = ip;
	}

	/**
	 * @return 命中暴力破解
	 */
	public String getIsMachdForce() {
		return isMachdForce;
	}

	/**
	 * @param 命中暴力破解
	 *            要设置的 isMachdForce
	 */
	public void setIsMachdForce(String isMachdForce) {
		this.isMachdForce = isMachdForce;
	}

	/**
	 * @return 命中DNS服务器
	 */
	public String getIsMachdDNS() {
		return isMachdDNS;
	}

	/**
	 * @param 命中DNS服务器
	 *            要设置的 isMachdDNS
	 */
	public void setIsMachdDNS(String isMachdDNS) {
		this.isMachdDNS = isMachdDNS;
	}

	/**
	 * @return 命中邮件服务器
	 */
	public String getIsMachdMailServ() {
		return isMachdMailServ;
	}

	/**
	 * @param 命中邮件服务器
	 *            要设置的 isMachdMailServ
	 */
	public void setIsMachdMailServ(String isMachdMailServ) {
		this.isMachdMailServ = isMachdMailServ;
	}

	/**
	 * @return 命中
	 */
	public String getSeoisMachdSEO() {
		return seoisMachdSEO;
	}

	/**
	 * @param 命中
	 *            要设置的 seoisMachdSEO
	 */
	public void setSeoisMachdSEO(String seoisMachdSEO) {
		this.seoisMachdSEO = seoisMachdSEO;
	}

	/**
	 * @return 命中组织出口
	 */
	public String getIsMachdOrg() {
		return isMachdOrg;
	}

	/**
	 * @param 命中组织出口
	 *            要设置的 isMachdOrg
	 */
	public void setIsMachdOrg(String isMachdOrg) {
		this.isMachdOrg = isMachdOrg;
	}

	/**
	 * @return 命中爬虫
	 */
	public String getIsMachdCrawler() {
		return isMachdCrawler;
	}

	/**
	 * @param 命中爬虫
	 *            要设置的 isMachdCrawler
	 */
	public void setIsMachdCrawler(String isMachdCrawler) {
		this.isMachdCrawler = isMachdCrawler;
	}

	/**
	 * @return 命中代理服务器
	 */
	public String getIsMachdProxy() {
		return isMachdProxy;
	}

	/**
	 * @param 命中代理服务器
	 *            要设置的 isMachdProxy
	 */
	public void setIsMachdProxy(String isMachdProxy) {
		this.isMachdProxy = isMachdProxy;
	}

	/**
	 * @return 命中第三方标注黑名单
	 */
	public String getIsMachdBlacklist() {
		return isMachdBlacklist;
	}

	/**
	 * @param 命中第三方标注黑名单
	 *            要设置的 isMachdBlacklist
	 */
	public void setIsMachdBlacklist(String isMachdBlacklist) {
		this.isMachdBlacklist = isMachdBlacklist;
	}

	/**
	 * @return 命中web服务器
	 */
	public String getIsMachdWebServ() {
		return isMachdWebServ;
	}

	/**
	 * @param 命中web服务器
	 *            要设置的 isMachdWebServ
	 */
	public void setIsMachdWebServ(String isMachdWebServ) {
		this.isMachdWebServ = isMachdWebServ;
	}

	/**
	 * @return 命中vpn服务器
	 */
	public String getIsMachdVPN() {
		return isMachdVPN;
	}

	/**
	 * @param 命中vpn服务器
	 *            要设置的 isMachdVPN
	 */
	public void setIsMachdVPN(String isMachdVPN) {
		this.isMachdVPN = isMachdVPN;
	}

	/**
	 * @return 命中第三方标注黑名单
	 */
	public String getIsMachdBlMakt() {
		return isMachdBlMakt;
	}

	/**
	 * @param 命中第三方标注黑名单
	 *            要设置的 isMachdBlMakt
	 */
	public void setIsMachdBlMakt(String isMachdBlMakt) {
		this.isMachdBlMakt = isMachdBlMakt;
	}

	/**
	 * @return 命中骚扰电话
	 */
	public String getIsMachCraCall() {
		return isMachCraCall;
	}

	/**
	 * @param 命中骚扰电话
	 *            要设置的 isMachCraCall
	 */
	public void setIsMachCraCall(String isMachCraCall) {
		this.isMachCraCall = isMachCraCall;
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
	 * @return 命中空号（非正常短信语音号码）
	 */
	public String getIsMachEmpty() {
		return isMachEmpty;
	}

	/**
	 * @param 命中空号（非正常短信语音号码）
	 *            要设置的 isMachEmpty
	 */
	public void setIsMachEmpty(String isMachEmpty) {
		this.isMachEmpty = isMachEmpty;
	}

	/**
	 * @return 命中收码平台号码
	 */
	public String getIsMachYZmobile() {
		return isMachYZmobile;
	}

	/**
	 * @param 命中收码平台号码
	 *            要设置的 isMachYZmobile
	 */
	public void setIsMachYZmobile(String isMachYZmobile) {
		this.isMachYZmobile = isMachYZmobile;
	}

	/**
	 * @return 命中小号
	 */
	public String getIsMachSmallNo() {
		return isMachSmallNo;
	}

	/**
	 * @param 命中小号
	 *            要设置的 isMachSmallNo
	 */
	public void setIsMachSmallNo(String isMachSmallNo) {
		this.isMachSmallNo = isMachSmallNo;
	}

	/**
	 * @return 命中社工库号码
	 */
	public String getIsMachSZNo() {
		return isMachSZNo;
	}

	/**
	 * @param 命中社工库号码
	 *            要设置的 isMachSZNo
	 */
	public void setIsMachSZNo(String isMachSZNo) {
		this.isMachSZNo = isMachSZNo;
	}

	/**
	 * @return ip风险时间
	 */
	public String getiUpdateDate() {
		return iUpdateDate;
	}

	/**
	 * @param ip风险时间
	 *            要设置的 iUpdateDate
	 */
	public void setiUpdateDate(String iUpdateDate) {
		this.iUpdateDate = iUpdateDate;
	}

	/**
	 * @return 手机号码风险时间
	 */
	public String getmUpdateDate() {
		return mUpdateDate;
	}

	/**
	 * @param 手机号码风险时间
	 *            要设置的 mUpdateDate
	 */
	public void setmUpdateDate(String mUpdateDate) {
		this.mUpdateDate = mUpdateDate;
	}

	/**
	 * @return IP风险描述
	 */
	public String getiRskDesc() {
		return iRskDesc;
	}

	/**
	 * @param IP风险描述
	 *            要设置的 iRskDesc
	 */
	public void setiRskDesc(String iRskDesc) {
		this.iRskDesc = iRskDesc;
	}

	/**
	 * @return 手机号码风险描述
	 */
	public String getmRskDesc() {
		return mRskDesc;
	}

	/**
	 * @param 手机号码风险描述
	 *            要设置的 mRskDesc
	 */
	public void setmRskDesc(String mRskDesc) {
		this.mRskDesc = mRskDesc;
	}

	/**
	 * @return 任务
	 */
	public String getQueryId() {
		return queryId;
	}

	/**
	 * @param 任务
	 *            要设置的 queryId
	 */
	public void setQueryId(String queryId) {
		this.queryId = queryId;
	}

	/**
	 * @return 任务提交交易流水号
	 */
	public String getSubmitTransNo() {
		return submitTransNo;
	}

	/**
	 * @param 任务提交交易流水号
	 *            要设置的 submitTransNo
	 */
	public void setSubmitTransNo(String submitTransNo) {
		this.submitTransNo = submitTransNo;
	}

	/**
	 * @return 整体比对结果
	 */
	public String getChkResult() {
		return chkResult;
	}

	/**
	 * @param 整体比对结果
	 *            要设置的 chkResult
	 */
	public void setChkResult(String chkResult) {
		this.chkResult = chkResult;
	}

	/**
	 * @return 驾驶证号
	 */
	public String getChkDriverNo() {
		return chkDriverNo;
	}

	/**
	 * @param 驾驶证号
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
	 * @return 出生日期
	 */
	public String getChkBirthday() {
		return chkBirthday;
	}

	/**
	 * @param 出生日期
	 *            要设置的 chkBirthday
	 */
	public void setChkBirthday(String chkBirthday) {
		this.chkBirthday = chkBirthday;
	}

	/**
	 * @return 出生日期前4位
	 */
	public String getChkBirthday4() {
		return chkBirthday4;
	}

	/**
	 * @param 出生日期前4位
	 *            要设置的 chkBirthday4
	 */
	public void setChkBirthday4(String chkBirthday4) {
		this.chkBirthday4 = chkBirthday4;
	}

	/**
	 * @return 出生日期前6位
	 */
	public String getChkBirthday6() {
		return chkBirthday6;
	}

	/**
	 * @param 出生日期前6位
	 *            要设置的 chkBirthday6
	 */
	public void setChkBirthday6(String chkBirthday6) {
		this.chkBirthday6 = chkBirthday6;
	}

	/**
	 * @return 档案编号
	 */
	public String getChkArchivesNo() {
		return chkArchivesNo;
	}

	/**
	 * @param 档案编号
	 *            要设置的 chkArchivesNo
	 */
	public void setChkArchivesNo(String chkArchivesNo) {
		this.chkArchivesNo = chkArchivesNo;
	}

	/**
	 * @return 准驾车型
	 */
	public String getChkQuasiDrivingVehicle() {
		return chkQuasiDrivingVehicle;
	}

	/**
	 * @param 准驾车型
	 *            要设置的 chkQuasiDrivingVehicle
	 */
	public void setChkQuasiDrivingVehicle(String chkQuasiDrivingVehicle) {
		this.chkQuasiDrivingVehicle = chkQuasiDrivingVehicle;
	}

	/**
	 * @return 国籍
	 */
	public String getChkNationality() {
		return chkNationality;
	}

	/**
	 * @param 国籍
	 *            要设置的 chkNationality
	 */
	public void setChkNationality(String chkNationality) {
		this.chkNationality = chkNationality;
	}

	/**
	 * @return 初次领证日期
	 */
	public String getChkFirstLicensingDate() {
		return chkFirstLicensingDate;
	}

	/**
	 * @param 初次领证日期
	 *            要设置的 chkFirstLicensingDate
	 */
	public void setChkFirstLicensingDate(String chkFirstLicensingDate) {
		this.chkFirstLicensingDate = chkFirstLicensingDate;
	}

	/**
	 * @return 初次领证日期前4位(年份)
	 */
	public String getChkFirstLicensingDate4() {
		return chkFirstLicensingDate4;
	}

	/**
	 * @param 初次领证日期前4位(年份)
	 *            要设置的 chkFirstLicensingDate4
	 */
	public void setChkFirstLicensingDate4(String chkFirstLicensingDate4) {
		this.chkFirstLicensingDate4 = chkFirstLicensingDate4;
	}

	/**
	 * @return 初次领证日期前6位(年)
	 */
	public String getChkFirstLicensingDate6() {
		return chkFirstLicensingDate6;
	}

	/**
	 * @param 初次领证日期前6位(年)
	 *            要设置的 chkFirstLicensingDate6
	 */
	public void setChkFirstLicensingDate6(String chkFirstLicensingDate6) {
		this.chkFirstLicensingDate6 = chkFirstLicensingDate6;
	}

	/**
	 * @return 有效期始
	 */
	public String getChkValidDateStart() {
		return chkValidDateStart;
	}

	/**
	 * @param 有效期始
	 *            要设置的 chkValidDateStart
	 */
	public void setChkValidDateStart(String chkValidDateStart) {
		this.chkValidDateStart = chkValidDateStart;
	}

	/**
	 * @return 有效期始日期前4位(年份)
	 */
	public String getChkValidDateStart4() {
		return chkValidDateStart4;
	}

	/**
	 * @param 有效期始日期前4位(年份)
	 *            要设置的 chkValidDateStart4
	 */
	public void setChkValidDateStart4(String chkValidDateStart4) {
		this.chkValidDateStart4 = chkValidDateStart4;
	}

	/**
	 * @return 有效期始日期前6位(年)
	 */
	public String getChkValidDateStart6() {
		return chkValidDateStart6;
	}

	/**
	 * @param 有效期始日期前6位(年)
	 *            要设置的 chkValidDateStart6
	 */
	public void setChkValidDateStart6(String chkValidDateStart6) {
		this.chkValidDateStart6 = chkValidDateStart6;
	}

	/**
	 * @return 有效期
	 */
	public String getChkValidDateEnd() {
		return chkValidDateEnd;
	}

	/**
	 * @param 有效期
	 *            要设置的 chkValidDateEnd
	 */
	public void setChkValidDateEnd(String chkValidDateEnd) {
		this.chkValidDateEnd = chkValidDateEnd;
	}

	/**
	 * @return 有效期止日期前4位(年份)
	 */
	public String getChkValidDateEnd4() {
		return chkValidDateEnd4;
	}

	/**
	 * @param 有效期止日期前4位(年份)
	 *            要设置的 chkValidDateEnd4
	 */
	public void setChkValidDateEnd4(String chkValidDateEnd4) {
		this.chkValidDateEnd4 = chkValidDateEnd4;
	}

	/**
	 * @return 有效期止日期前6位(年)
	 */
	public String getChkValidDateEnd6() {
		return chkValidDateEnd6;
	}

	/**
	 * @param 有效期止日期前6位(年)
	 *            要设置的 chkValidDateEnd6
	 */
	public void setChkValidDateEnd6(String chkValidDateEnd6) {
		this.chkValidDateEnd6 = chkValidDateEnd6;
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
	 * @return 是否真实身份
	 */
	public String getIsRealIdentity() {
		return isRealIdentity;
	}

	/**
	 * @param 是否真实身份
	 *            要设置的 isRealIdentity
	 */
	public void setIsRealIdentity(String isRealIdentity) {
		this.isRealIdentity = isRealIdentity;
	}

	/**
	 * @return 是否本人真实活动地址
	 */
	public String getIsValidAddress() {
		return isValidAddress;
	}

	/**
	 * @param 是否本人真实活动地址
	 *            要设置的 isValidAddress
	 */
	public void setIsValidAddress(String isValidAddress) {
		this.isValidAddress = isValidAddress;
	}

	/**
	 * @return 地址类型
	 */
	public String getAddressType() {
		return addressType;
	}

	/**
	 * @param 地址类型
	 *            要设置的 addressType
	 */
	public void setAddressType(String addressType) {
		this.addressType = addressType;
	}

	/**
	 * @return 是否真实工作单位
	 */
	public String getIsRealCompany() {
		return isRealCompany;
	}

	/**
	 * @param 是否真实工作单位
	 *            要设置的 isRealCompany
	 */
	public void setIsRealCompany(String isRealCompany) {
		this.isRealCompany = isRealCompany;
	}

	/**
	 * @return 单位匹配度分值
	 */
	public String getCompanySimDeg() {
		return companySimDeg;
	}

	/**
	 * @param 单位匹配度分值
	 *            要设置的 companySimDeg
	 */
	public void setCompanySimDeg(String companySimDeg) {
		this.companySimDeg = companySimDeg;
	}

	/**
	 * @return 单位最初出现时间
	 */
	public String getAppear1ThDate() {
		return appear1ThDate;
	}

	/**
	 * @param 单位最初出现时间
	 *            要设置的 appear1ThDate
	 */
	public void setAppear1ThDate(String appear1ThDate) {
		this.appear1ThDate = appear1ThDate;
	}

	/**
	 * @return 单位最近一次出现时间
	 */
	public String getAppearLastDate() {
		return appearLastDate;
	}

	/**
	 * @param 单位最近一次出现时间
	 *            要设置的 appearLastDate
	 */
	public void setAppearLastDate(String appearLastDate) {
		this.appearLastDate = appearLastDate;
	}

	/**
	 * @return 手机验证结果
	 */
	public String getIsOwnerMobile() {
		return isOwnerMobile;
	}

	/**
	 * @param 手机验证结果
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
	 * @return 是否存在关系
	 */
	public String getIsExistRel() {
		return isExistRel;
	}

	/**
	 * @param 是否存在关系
	 *            要设置的 isExistRel
	 */
	public void setIsExistRel(String isExistRel) {
		this.isExistRel = isExistRel;
	}

	/**
	 * @return 关系力度
	 */
	public String getRelLevel() {
		return relLevel;
	}

	/**
	 * @param 关系力度
	 *            要设置的 relLevel
	 */
	public void setRelLevel(String relLevel) {
		this.relLevel = relLevel;
	}

	/**
	 * @return 车辆验证结果
	 */
	public String getCarChkResult() {
		return carChkResult;
	}

	/**
	 * @param 车辆验证结果
	 *            要设置的 carChkResult
	 */
	public void setCarChkResult(String carChkResult) {
		this.carChkResult = carChkResult;
	}

	/**
	 * @return 是否异步返回结果
	 */
	public String getIsAsyned() {
		return isAsyned;
	}

	/**
	 * @param 是否异步返回结果
	 *            要设置的 isAsyned
	 */
	public void setIsAsyned(String isAsyned) {
		this.isAsyned = isAsyned;
	}

	/**
	 * @return 车型
	 */
	public String getCarTypeInc() {
		return carTypeInc;
	}

	/**
	 * @param 车型
	 *            要设置的 carTypeInc
	 */
	public void setCarTypeInc(String carTypeInc) {
		this.carTypeInc = carTypeInc;
	}

	/**
	 * @return 厂牌
	 */
	public String getCarFactoryInc() {
		return carFactoryInc;
	}

	/**
	 * @param 厂牌
	 *            要设置的 carFactoryInc
	 */
	public void setCarFactoryInc(String carFactoryInc) {
		this.carFactoryInc = carFactoryInc;
	}

	/**
	 * @return 新车购置价
	 */
	public String getCarPrice() {
		return carPrice;
	}

	/**
	 * @param 新车购置价
	 *            要设置的 carPrice
	 */
	public void setCarPrice(String carPrice) {
		this.carPrice = carPrice;
	}

	/**
	 * @return 行驶证状态查询Id号
	 */
	public String getDrvStatusQryId() {
		return drvStatusQryId;
	}

	/**
	 * @param 行驶证状态查询Id号
	 *            要设置的 drvStatusQryId
	 */
	public void setDrvStatusQryId(String drvStatusQryId) {
		this.drvStatusQryId = drvStatusQryId;
	}

	/**
	 * @return 房屋验证结果
	 */
	public String getHouseChkResult() {
		return houseChkResult;
	}

	/**
	 * @param 房屋验证结果
	 *            要设置的 houseChkResult
	 */
	public void setHouseChkResult(String houseChkResult) {
		this.houseChkResult = houseChkResult;
	}

	/**
	 * @return 房屋数据获取时间
	 */
	public String getHouseDataDate() {
		return houseDataDate;
	}

	/**
	 * @param 房屋数据获取时间
	 *            要设置的 houseDataDate
	 */
	public void setHouseDataDate(String houseDataDate) {
		this.houseDataDate = houseDataDate;
	}

	/**
	 * @return 相片比对结果
	 */
	public String getPhotoCmpResult() {
		return photoCmpResult;
	}

	/**
	 * @param 相片比对结果
	 *            要设置的 photoCmpResult
	 */
	public void setPhotoCmpResult(String photoCmpResult) {
		this.photoCmpResult = photoCmpResult;
	}

	/**
	 * @return 相片相似度
	 */
	public String getPhotoSimDeg() {
		return photoSimDeg;
	}

	/**
	 * @param 相片相似度
	 *            要设置的 photoSimDeg
	 */
	public void setPhotoSimDeg(String photoSimDeg) {
		this.photoSimDeg = photoSimDeg;
	}

	/**
	 * @return 是否本人真实最高学历
	 */
	public String getIsHighestEduBkg() {
		return isHighestEduBkg;
	}

	/**
	 * @param 是否本人真实最高学历
	 *            要设置的 isHighestEduBkg
	 */
	public void setIsHighestEduBkg(String isHighestEduBkg) {
		this.isHighestEduBkg = isHighestEduBkg;
	}

	/**
	 * @return 数据获取时间
	 */
	public String getDataDate() {
		return dataDate;
	}

	/**
	 * @param 数据获取时间
	 *            要设置的 dataDate
	 */
	public void setDataDate(String dataDate) {
		this.dataDate = dataDate;
	}

	/**
	 * @return 毕业院校
	 */
	public String getGraduateSchool() {
		return graduateSchool;
	}

	/**
	 * @param 毕业院校
	 *            要设置的 graduateSchool
	 */
	public void setGraduateSchool(String graduateSchool) {
		this.graduateSchool = graduateSchool;
	}

	/**
	 * @return 毕业专业
	 */
	public String getGraduateMajor() {
		return graduateMajor;
	}

	/**
	 * @param 毕业专业
	 *            要设置的 graduateMajor
	 */
	public void setGraduateMajor(String graduateMajor) {
		this.graduateMajor = graduateMajor;
	}

	/**
	 * @return 毕业年份
	 */
	public String getGraduateYear() {
		return graduateYear;
	}

	/**
	 * @param 毕业年份
	 *            要设置的 graduateYear
	 */
	public void setGraduateYear(String graduateYear) {
		this.graduateYear = graduateYear;
	}

	/**
	 * @return 手机验证II结果
	 */
	public String getIsOwnerMobileII() {
		return isOwnerMobileII;
	}

	/**
	 * @param 手机验证II结果
	 *            要设置的 isOwnerMobileII
	 */
	public void setIsOwnerMobileII(String isOwnerMobileII) {
		this.isOwnerMobileII = isOwnerMobileII;
	}

	/**
	 * @return 手机状态II
	 */
	public String getOwnerMobileStatusII() {
		return ownerMobileStatusII;
	}

	/**
	 * @param 手机状态II
	 *            要设置的 ownerMobileStatusII
	 */
	public void setOwnerMobileStatusII(String ownerMobileStatusII) {
		this.ownerMobileStatusII = ownerMobileStatusII;
	}

	/**
	 * @return 使用时间分数II
	 */
	public String getUseTimeScoreII() {
		return useTimeScoreII;
	}

	/**
	 * @param 使用时间分数II
	 *            要设置的 useTimeScoreII
	 */
	public void setUseTimeScoreII(String useTimeScoreII) {
		this.useTimeScoreII = useTimeScoreII;
	}

	/**
	 * @return 错误信息
	 */
	public String getErrorInfo() {
		return errorInfo;
	}

	/**
	 * @param 错误信息
	 *            要设置的 errorInfo
	 */
	public void setErrorInfo(String errorInfo) {
		this.errorInfo = errorInfo;
	}

	/**
	 * @return 查询原因
	 */
	public String getReasonCode() {
		return reasonCode;
	}

	/**
	 * @param 查询原因
	 *            要设置的 reasonCode
	 */
	public void setReasonCode(String reasonCode) {
		this.reasonCode = reasonCode;
	}

	/**
	 * @return 机构所属行业
	 */
	public String getIndustry() {
		return industry;
	}

	/**
	 * @param 机构所属行业
	 *            要设置的 industry
	 */
	public void setIndustry(String industry) {
		this.industry = industry;
	}

	/**
	 * @return 命中机构数目
	 */
	public String getAmount() {
		return amount;
	}

	/**
	 * @param 命中机构数目
	 *            要设置的 amount
	 */
	public void setAmount(String amount) {
		this.amount = amount;
	}

	/**
	 * @return 业务发生时间
	 */
	public String getBusiDate() {
		return busiDate;
	}

	/**
	 * @param 业务发生时间
	 *            要设置的 busiDate
	 */
	public void setBusiDate(String busiDate) {
		this.busiDate = busiDate;
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
	 * @return 证件类型
	 */
	public String getIdType() {
		return idType;
	}

	/**
	 * @param 证件类型
	 *            要设置的 idType
	 */
	public void setIdType(String idType) {
		this.idType = idType;
	}

	/**
	 * @return 主体名称
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param 主体名称
	 *            要设置的 name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return 来源代码
	 */
	public String getSourceId() {
		return sourceId;
	}

	/**
	 * @param 来源代码
	 *            要设置的 sourceId
	 */
	public void setSourceId(String sourceId) {
		this.sourceId = sourceId;
	}

	/**
	 * @return 风险的分
	 */
	public String getRskScore() {
		return rskScore;
	}

	/**
	 * @param 风险的分
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
	 * @return 数据状态
	 */
	public String getDataStatus() {
		return dataStatus;
	}

	/**
	 * @param 数据状态
	 *            要设置的 dataStatus
	 */
	public void setDataStatus(String dataStatus) {
		this.dataStatus = dataStatus;
	}

}
