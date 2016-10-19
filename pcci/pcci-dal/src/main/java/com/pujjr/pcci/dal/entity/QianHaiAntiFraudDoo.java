package com.pujjr.pcci.dal.entity;

import java.io.Serializable;

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
public class QianHaiAntiFraudDoo implements Serializable {

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
	@Column(nullable = false)
	private Long transNo;

	/**
	 * 交易批次号
	 */
	@Column(nullable = false)
	private Long batchNo;

	/**
	 * 序列号
	 */
	@Column(nullable = false)
	private String seqNo;

	/**
	 * 错误代码
	 */
	@Column(nullable = false)
	private String erCode;

	/**
	 * 错误信息
	 */
	@Column(nullable = false)
	private String erMsg;

	/**
	 * 手机号码
	 */
	@Column
	private String mobileNo;
	/**
	 * IP地址
	 */
	@Column
	private String ip;

	/**
	 * 命中暴力破解
	 */
	@Column
	private String isMachdForce;
	/**
	 * 命中DNS服务器
	 */
	@Column
	private String isMachdDNS;
	/**
	 * 命中邮件服务器
	 */
	@Column
	private String isMachdMailServ;
	/**
	 * 命中
	 */
	@Column
	private String seoisMachdSEO;
	/**
	 * 命中组织出口
	 */
	@Column
	private String isMachdOrg;
	/**
	 * 命中爬虫
	 */
	@Column
	private String isMachdCrawler;
	/**
	 * 命中代理服务器
	 */
	@Column
	private String isMachdProxy;
	/**
	 * 命中第三方标注黑名单
	 */
	@Column
	private String isMachdBlacklist;
	/**
	 * 命中web服务器
	 */
	@Column
	private String isMachdWebServ;
	/**
	 * 命中vpn服务器
	 */
	@Column
	private String isMachdVPN;
	/**
	 * 风险评分
	 */
	@Column
	private String rskScore;
	/**
	 * 命中第三方标注黑名单
	 */
	@Column
	private String isMachdBlMakt;
	/**
	 * 命中骚扰电话
	 */
	@Column
	private String isMachCraCall;
	/**
	 * 命中欺诈号码
	 */
	@Column
	private String isMachFraud;
	/**
	 * 命中空号（非正常短信语音号码）
	 */
	@Column
	private String isMachEmpty;
	/**
	 * 命中收码平台号码
	 */
	@Column
	private String isMachYZmobile;
	/**
	 * 命中小号
	 */
	@Column
	private String isMachSmallNo;
	/**
	 * 命中社工库号码
	 */
	@Column
	private String isMachSZNo;
	/**
	 * ip风险时间
	 */
	@Column
	private String iUpdateDate;
	/**
	 * 手机号码风险时间
	 */
	@Column
	private String mUpdateDate;
	/**
	 * IP风险描述
	 */
	@Column
	private String iRskDesc;
	/**
	 * 手机号码风险描述
	 */
	@Column
	private String mRskDesc;

	public Long getRecordId() {
		return recordId;
	}

	public void setRecordId(Long recordId) {
		this.recordId = recordId;
	}

	public Long getTransNo() {
		return transNo;
	}

	public void setTransNo(Long transNo) {
		this.transNo = transNo;
	}

	public Long getBatchNo() {
		return batchNo;
	}

	public void setBatchNo(Long batchNo) {
		this.batchNo = batchNo;
	}

	public String getSeqNo() {
		return seqNo;
	}

	public void setSeqNo(String seqNo) {
		this.seqNo = seqNo;
	}

	public String getErCode() {
		return erCode;
	}

	public void setErCode(String erCode) {
		this.erCode = erCode;
	}

	public String getErMsg() {
		return erMsg;
	}

	public void setErMsg(String erMsg) {
		this.erMsg = erMsg;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getIsMachdForce() {
		return isMachdForce;
	}

	public void setIsMachdForce(String isMachdForce) {
		this.isMachdForce = isMachdForce;
	}

	public String getIsMachdDNS() {
		return isMachdDNS;
	}

	public void setIsMachdDNS(String isMachdDNS) {
		this.isMachdDNS = isMachdDNS;
	}

	public String getIsMachdMailServ() {
		return isMachdMailServ;
	}

	public void setIsMachdMailServ(String isMachdMailServ) {
		this.isMachdMailServ = isMachdMailServ;
	}

	public String getSeoisMachdSEO() {
		return seoisMachdSEO;
	}

	public void setSeoisMachdSEO(String seoisMachdSEO) {
		this.seoisMachdSEO = seoisMachdSEO;
	}

	public String getIsMachdOrg() {
		return isMachdOrg;
	}

	public void setIsMachdOrg(String isMachdOrg) {
		this.isMachdOrg = isMachdOrg;
	}

	public String getIsMachdCrawler() {
		return isMachdCrawler;
	}

	public void setIsMachdCrawler(String isMachdCrawler) {
		this.isMachdCrawler = isMachdCrawler;
	}

	public String getIsMachdProxy() {
		return isMachdProxy;
	}

	public void setIsMachdProxy(String isMachdProxy) {
		this.isMachdProxy = isMachdProxy;
	}

	public String getIsMachdBlacklist() {
		return isMachdBlacklist;
	}

	public void setIsMachdBlacklist(String isMachdBlacklist) {
		this.isMachdBlacklist = isMachdBlacklist;
	}

	public String getIsMachdWebServ() {
		return isMachdWebServ;
	}

	public void setIsMachdWebServ(String isMachdWebServ) {
		this.isMachdWebServ = isMachdWebServ;
	}

	public String getIsMachdVPN() {
		return isMachdVPN;
	}

	public void setIsMachdVPN(String isMachdVPN) {
		this.isMachdVPN = isMachdVPN;
	}

	public String getRskScore() {
		return rskScore;
	}

	public void setRskScore(String rskScore) {
		this.rskScore = rskScore;
	}

	public String getIsMachdBlMakt() {
		return isMachdBlMakt;
	}

	public void setIsMachdBlMakt(String isMachdBlMakt) {
		this.isMachdBlMakt = isMachdBlMakt;
	}

	public String getIsMachCraCall() {
		return isMachCraCall;
	}

	public void setIsMachCraCall(String isMachCraCall) {
		this.isMachCraCall = isMachCraCall;
	}

	public String getIsMachFraud() {
		return isMachFraud;
	}

	public void setIsMachFraud(String isMachFraud) {
		this.isMachFraud = isMachFraud;
	}

	public String getIsMachEmpty() {
		return isMachEmpty;
	}

	public void setIsMachEmpty(String isMachEmpty) {
		this.isMachEmpty = isMachEmpty;
	}

	public String getIsMachYZmobile() {
		return isMachYZmobile;
	}

	public void setIsMachYZmobile(String isMachYZmobile) {
		this.isMachYZmobile = isMachYZmobile;
	}

	public String getIsMachSmallNo() {
		return isMachSmallNo;
	}

	public void setIsMachSmallNo(String isMachSmallNo) {
		this.isMachSmallNo = isMachSmallNo;
	}

	public String getIsMachSZNo() {
		return isMachSZNo;
	}

	public void setIsMachSZNo(String isMachSZNo) {
		this.isMachSZNo = isMachSZNo;
	}

	public String getiUpdateDate() {
		return iUpdateDate;
	}

	public void setiUpdateDate(String iUpdateDate) {
		this.iUpdateDate = iUpdateDate;
	}

	public String getmUpdateDate() {
		return mUpdateDate;
	}

	public void setmUpdateDate(String mUpdateDate) {
		this.mUpdateDate = mUpdateDate;
	}

	public String getiRskDesc() {
		return iRskDesc;
	}

	public void setiRskDesc(String iRskDesc) {
		this.iRskDesc = iRskDesc;
	}

	public String getmRskDesc() {
		return mRskDesc;
	}

	public void setmRskDesc(String mRskDesc) {
		this.mRskDesc = mRskDesc;
	}

}
