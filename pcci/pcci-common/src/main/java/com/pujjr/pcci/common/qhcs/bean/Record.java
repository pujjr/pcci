package com.pujjr.pcci.common.qhcs.bean;

import com.pujjr.pcci.common.qhcs.type.DrivingVehicleType;
import com.pujjr.pcci.common.qhcs.type.IdentityType;
import com.pujjr.pcci.common.qhcs.type.QueryReasonType;

/**
 * @author wen
 * @date 创建时间：2016年10月10日 上午10:43:35 批次记录信息
 */
public class Record {
	/**
	 * isNeedChkUn 需要效验用户名 1
	 */
	public static final int CHECK_YES = 1;
	/**
	 * isNeedChkUn 不需要效验用户名 0
	 */
	public static final int CHECK_NO = 0;

	/**
	 * 驾驶证号
	 */
	private String driverNo;
	/**
	 * 姓名
	 */
	private String name;

	/**
	 * 证件类型 {@link IdentityType}
	 */
	private String idType;
	/**
	 * 证件号
	 */
	private String idNo;
	/**
	 * 查询原因 {@link QueryReasonType}
	 */
	private String reasonCode;
	/**
	 * 是否验证用户名 默认验证 CHECK_NO 0：不验证 CHECK_YES 1：验证
	 */
	private String isNeedChkUn;
	/**
	 * 出生日期 格式为yyyyMMdd
	 */
	private String birthday;
	/**
	 * 出生日期 格式为yyyy
	 */
	private String birthday4;
	/**
	 * 出生日期前6位 格式为yyyyMM
	 */
	private String birthday6;
	/**
	 * 档案编号
	 */
	private String archivesNo;
	/**
	 * 准驾车型 {@link DrivingVehicleType}
	 */
	private String quasiDrivingVehicle;
	/**
	 * 国籍（暂不支持）
	 */
	private String nationality;
	/**
	 * 初次领证时间 yyyyMMdd
	 */
	private String firstLicensingDate;
	/**
	 * 初次领证时间前4位 yyyy
	 */
	private String firstLicensingDate4;
	/**
	 * 初次领证时间前6位 yyyyMM
	 */
	private String firstLicensingDate6;
	/**
	 * 有效期始
	 */
	private String validDateStart;
	/**
	 * 有效期始日 日期前4位(年份) yyyy
	 */
	private String validDateStart4;
	/**
	 * 有效期始日 日期前6位(年月) yyyyMM
	 */
	private String validDateStart6;
	/**
	 * 有效期止
	 */
	private String validDateEnd;
	/**
	 * 有效期止日 日期前4位(年份) yyyy
	 */
	private String validDateEnd4;
	/**
	 * 有效期止日 日期前6位(年月)yyyyMM
	 */
	private String validDateEnd6;
	/**
	 * 业务描述
	 */
	private String busiDesc;
	/**
	 * 信息主体授权码 若不涉及授权则填唯一的随机序列
	 */
	private String entityAuthCode;
	/**
	 * 信息主体授权时间 yyyy-MM-dd
	 */
	private String entityAuthDate;
	/**
	 * 序列号 子批次号，本批次内唯一
	 */
	private String seqNo;

	public String getDriverNo() {
		return driverNo;
	}

	public void setDriverNo(String driverNo) {
		this.driverNo = driverNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIdType() {
		return idType;
	}

	public void setIdType(IdentityType idType) {
		this.idType = idType.getCode();
	}

	public String getIdNo() {
		return idNo;
	}

	public void setIdNo(String idNo) {
		this.idNo = idNo;
	}

	public String getReasonCode() {
		return reasonCode;
	}

	public void setReasonCode(QueryReasonType queryReasonType) {
		this.reasonCode = queryReasonType.getCode();
	}

	public String getIsNeedChkUn() {
		return isNeedChkUn;
	}

	public void setIsNeedChkUn(String isNeedChkUn) {
		this.isNeedChkUn = isNeedChkUn;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getBirthday4() {
		return birthday4;
	}

	public void setBirthday4(String birthday4) {
		this.birthday4 = birthday4;
	}

	public String getBirthday6() {
		return birthday6;
	}

	public void setBirthday6(String birthday6) {
		this.birthday6 = birthday6;
	}

	public String getArchivesNo() {
		return archivesNo;
	}

	public void setArchivesNo(String archivesNo) {
		this.archivesNo = archivesNo;
	}

	public String getQuasiDrivingVehicle() {
		return quasiDrivingVehicle;
	}

	public void setQuasiDrivingVehicle(DrivingVehicleType drivingVehicleType) {
		this.quasiDrivingVehicle = drivingVehicleType.getCode();
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public String getFirstLicensingDate() {
		return firstLicensingDate;
	}

	public void setFirstLicensingDate(String firstLicensingDate) {
		this.firstLicensingDate = firstLicensingDate;
	}

	public String getFirstLicensingDate4() {
		return firstLicensingDate4;
	}

	public void setFirstLicensingDate4(String firstLicensingDate4) {
		this.firstLicensingDate4 = firstLicensingDate4;
	}

	public String getFirstLicensingDate6() {
		return firstLicensingDate6;
	}

	public void setFirstLicensingDate6(String firstLicensingDate6) {
		this.firstLicensingDate6 = firstLicensingDate6;
	}

	public String getValidDateStart() {
		return validDateStart;
	}

	public void setValidDateStart(String validDateStart) {
		this.validDateStart = validDateStart;
	}

	public String getValidDateStart4() {
		return validDateStart4;
	}

	public void setValidDateStart4(String validDateStart4) {
		this.validDateStart4 = validDateStart4;
	}

	public String getValidDateStart6() {
		return validDateStart6;
	}

	public void setValidDateStart6(String validDateStart6) {
		this.validDateStart6 = validDateStart6;
	}

	public String getValidDateEnd() {
		return validDateEnd;
	}

	public void setValidDateEnd(String validDateEnd) {
		this.validDateEnd = validDateEnd;
	}

	public String getValidDateEnd4() {
		return validDateEnd4;
	}

	public void setValidDateEnd4(String validDateEnd4) {
		this.validDateEnd4 = validDateEnd4;
	}

	public String getValidDateEnd6() {
		return validDateEnd6;
	}

	public void setValidDateEnd6(String validDateEnd6) {
		this.validDateEnd6 = validDateEnd6;
	}

	public String getBusiDesc() {
		return busiDesc;
	}

	public void setBusiDesc(String busiDesc) {
		this.busiDesc = busiDesc;
	}

	public String getEntityAuthCode() {
		return entityAuthCode;
	}

	public void setEntityAuthCode(String entityAuthCode) {
		this.entityAuthCode = entityAuthCode;
	}

	public String getEntityAuthDate() {
		return entityAuthDate;
	}

	public void setEntityAuthDate(String entityAuthDate) {
		this.entityAuthDate = entityAuthDate;
	}

	public String getSeqNo() {
		return seqNo;
	}

	public void setSeqNo(String seqNo) {
		this.seqNo = seqNo;
	}

}
