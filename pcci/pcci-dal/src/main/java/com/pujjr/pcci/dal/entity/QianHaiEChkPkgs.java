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
public class QianHaiEChkPkgs implements Serializable {

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
	 * 证件号码
	 */
	@Column
	private String idNo;
	/**
	 * 证件类型
	 */
	@Column
	private String idType;
	/**
	 * 主体名称
	 */
	@Column
	private String name;
	/**
	 * 手机号码
	 */
	@Column
	private String mobileNo;

	/**
	 * 是否真实身份
	 */
	@Column
	private String isRealIdentity;
	/**
	 * 是否本人真实活动地址
	 */
	@Column
	private String isValidAddress;
	/**
	 * 地址类型
	 */
	@Column
	private String addressType;
	/**
	 * 是否真实工作单位
	 */
	@Column
	private String isRealCompany;
	/**
	 * 单位匹配度分值
	 */
	@Column
	private String companySimDeg;
	/**
	 * 单位最初出现时间
	 */
	@Column
	private String appear1ThDate;
	/**
	 * 单位最近一次出现时间
	 */
	@Column
	private String appearLastDate;
	/**
	 * 手机验证结果
	 */
	@Column
	private String isOwnerMobile;
	/**
	 * 手机状态
	 */
	@Column
	private String ownerMobileStatus;
	/**
	 * 使用时间分数
	 */
	@Column
	private String useTimeScore;
	/**
	 * 是否存在关系
	 */
	@Column
	private String isExistRel;
	/**
	 * 关系力度
	 */
	@Column
	private String relLevel;
	/**
	 * 车辆验证结果
	 */
	@Column
	private String carChkResult;
	/**
	 * 是否异步返回结果
	 */
	@Column
	private String isAsyned;
	/**
	 * 车型
	 */
	@Column
	private String carTypeInc;
	/**
	 * 厂牌
	 */
	@Column
	private String carFactoryInc;
	/**
	 * 新车购置价
	 */
	@Column
	private String carPrice;
	/**
	 * 行驶证状态查询Id号
	 */
	@Column
	private String drvStatusQryId;
	/**
	 * 房屋验证结果
	 */
	@Column
	private String houseChkResult;
	/**
	 * 房屋数据获取时间
	 */
	@Column
	private String houseDataDate;
	/**
	 * 相片比对结果
	 */
	@Column
	private String photoCmpResult;
	/**
	 * 相片相似度
	 */
	@Column
	private String photoSimDeg;
	/**
	 * 是否本人真实最高学历
	 */
	@Column
	private String isHighestEduBkg;
	/**
	 * 数据获取时间
	 */
	@Column
	private String dataDate;
	/**
	 * 毕业院校
	 */
	@Column
	private String graduateSchool;
	/**
	 * 毕业专业
	 */
	@Column
	private String graduateMajor;
	/**
	 * 毕业年份
	 */
	@Column
	private String graduateYear;
	/**
	 * 手机验证II结果
	 */
	@Column
	private String isOwnerMobileII;
	/**
	 * 手机状态II
	 */
	@Column
	private String ownerMobileStatusII;
	/**
	 * 使用时间分数II
	 */
	@Column
	private String useTimeScoreII;
	/**
	 * 错误信息
	 */
	@Column
	private String errorInfo;

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

	public String getIdNo() {
		return idNo;
	}

	public void setIdNo(String idNo) {
		this.idNo = idNo;
	}

	public String getIdType() {
		return idType;
	}

	public void setIdType(String idType) {
		this.idType = idType;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getIsRealIdentity() {
		return isRealIdentity;
	}

	public void setIsRealIdentity(String isRealIdentity) {
		this.isRealIdentity = isRealIdentity;
	}

	public String getIsValidAddress() {
		return isValidAddress;
	}

	public void setIsValidAddress(String isValidAddress) {
		this.isValidAddress = isValidAddress;
	}

	public String getAddressType() {
		return addressType;
	}

	public void setAddressType(String addressType) {
		this.addressType = addressType;
	}

	public String getIsRealCompany() {
		return isRealCompany;
	}

	public void setIsRealCompany(String isRealCompany) {
		this.isRealCompany = isRealCompany;
	}

	public String getCompanySimDeg() {
		return companySimDeg;
	}

	public void setCompanySimDeg(String companySimDeg) {
		this.companySimDeg = companySimDeg;
	}

	public String getAppear1ThDate() {
		return appear1ThDate;
	}

	public void setAppear1ThDate(String appear1ThDate) {
		this.appear1ThDate = appear1ThDate;
	}

	public String getAppearLastDate() {
		return appearLastDate;
	}

	public void setAppearLastDate(String appearLastDate) {
		this.appearLastDate = appearLastDate;
	}

	public String getIsOwnerMobile() {
		return isOwnerMobile;
	}

	public void setIsOwnerMobile(String isOwnerMobile) {
		this.isOwnerMobile = isOwnerMobile;
	}

	public String getOwnerMobileStatus() {
		return ownerMobileStatus;
	}

	public void setOwnerMobileStatus(String ownerMobileStatus) {
		this.ownerMobileStatus = ownerMobileStatus;
	}

	public String getUseTimeScore() {
		return useTimeScore;
	}

	public void setUseTimeScore(String useTimeScore) {
		this.useTimeScore = useTimeScore;
	}

	public String getIsExistRel() {
		return isExistRel;
	}

	public void setIsExistRel(String isExistRel) {
		this.isExistRel = isExistRel;
	}

	public String getRelLevel() {
		return relLevel;
	}

	public void setRelLevel(String relLevel) {
		this.relLevel = relLevel;
	}

	public String getCarChkResult() {
		return carChkResult;
	}

	public void setCarChkResult(String carChkResult) {
		this.carChkResult = carChkResult;
	}

	public String getIsAsyned() {
		return isAsyned;
	}

	public void setIsAsyned(String isAsyned) {
		this.isAsyned = isAsyned;
	}

	public String getCarTypeInc() {
		return carTypeInc;
	}

	public void setCarTypeInc(String carTypeInc) {
		this.carTypeInc = carTypeInc;
	}

	public String getCarFactoryInc() {
		return carFactoryInc;
	}

	public void setCarFactoryInc(String carFactoryInc) {
		this.carFactoryInc = carFactoryInc;
	}

	public String getCarPrice() {
		return carPrice;
	}

	public void setCarPrice(String carPrice) {
		this.carPrice = carPrice;
	}

	public String getDrvStatusQryId() {
		return drvStatusQryId;
	}

	public void setDrvStatusQryId(String drvStatusQryId) {
		this.drvStatusQryId = drvStatusQryId;
	}

	public String getHouseChkResult() {
		return houseChkResult;
	}

	public void setHouseChkResult(String houseChkResult) {
		this.houseChkResult = houseChkResult;
	}

	public String getHouseDataDate() {
		return houseDataDate;
	}

	public void setHouseDataDate(String houseDataDate) {
		this.houseDataDate = houseDataDate;
	}

	public String getPhotoCmpResult() {
		return photoCmpResult;
	}

	public void setPhotoCmpResult(String photoCmpResult) {
		this.photoCmpResult = photoCmpResult;
	}

	public String getPhotoSimDeg() {
		return photoSimDeg;
	}

	public void setPhotoSimDeg(String photoSimDeg) {
		this.photoSimDeg = photoSimDeg;
	}

	public String getIsHighestEduBkg() {
		return isHighestEduBkg;
	}

	public void setIsHighestEduBkg(String isHighestEduBkg) {
		this.isHighestEduBkg = isHighestEduBkg;
	}

	public String getDataDate() {
		return dataDate;
	}

	public void setDataDate(String dataDate) {
		this.dataDate = dataDate;
	}

	public String getGraduateSchool() {
		return graduateSchool;
	}

	public void setGraduateSchool(String graduateSchool) {
		this.graduateSchool = graduateSchool;
	}

	public String getGraduateMajor() {
		return graduateMajor;
	}

	public void setGraduateMajor(String graduateMajor) {
		this.graduateMajor = graduateMajor;
	}

	public String getGraduateYear() {
		return graduateYear;
	}

	public void setGraduateYear(String graduateYear) {
		this.graduateYear = graduateYear;
	}

	public String getIsOwnerMobileII() {
		return isOwnerMobileII;
	}

	public void setIsOwnerMobileII(String isOwnerMobileII) {
		this.isOwnerMobileII = isOwnerMobileII;
	}

	public String getOwnerMobileStatusII() {
		return ownerMobileStatusII;
	}

	public void setOwnerMobileStatusII(String ownerMobileStatusII) {
		this.ownerMobileStatusII = ownerMobileStatusII;
	}

	public String getUseTimeScoreII() {
		return useTimeScoreII;
	}

	public void setUseTimeScoreII(String useTimeScoreII) {
		this.useTimeScoreII = useTimeScoreII;
	}

	public String getErrorInfo() {
		return errorInfo;
	}

	public void setErrorInfo(String errorInfo) {
		this.errorInfo = errorInfo;
	}

}
