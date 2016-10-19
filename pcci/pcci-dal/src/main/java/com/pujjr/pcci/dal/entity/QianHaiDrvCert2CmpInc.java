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
public class QianHaiDrvCert2CmpInc implements Serializable {

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
	 * 证件号
	 */
	@Column(nullable = false)
	private String idNo;

	/**
	 * 序列号
	 */
	@Column(nullable = false)
	private String seqNo;

	/**
	 * 任务
	 */
	@Column
	private String IDqueryId;
	/**
	 * 任务提交交易流水号
	 */
	@Column
	private String submitTransNo;
	/**
	 * 整体比对结果
	 */
	@Column
	private String chkResult;
	/**
	 * 驾驶证号
	 */
	@Column
	private String chkDriverNo;
	/**
	 * 姓名
	 */
	@Column
	private String chkName;
	/**
	 * 出生日期
	 */
	@Column
	private String chkBirthday;
	/**
	 * 出生日期前4位
	 */
	@Column
	private String chkBirthday4;
	/**
	 * 出生日期前6位
	 */
	@Column
	private String chkBirthday6;
	/**
	 * 档案编号
	 */
	@Column
	private String chkArchivesNo;
	/**
	 * 准驾车型
	 */
	@Column
	private String chkQuasiDrivingVehicle;
	/**
	 * 国籍
	 */
	@Column
	private String chkNationality;
	/**
	 * 初次领证日期
	 */
	@Column
	private String chkFirstLicensingDate;
	/**
	 * 初次领证日期前4位(年份)
	 */
	@Column
	private String chkFirstLicensingDate4;
	/**
	 * 初次领证日期前6位(年)
	 */
	@Column
	private String chkFirstLicensingDate6;
	/**
	 * 有效期始
	 */
	@Column
	private String chkValidDateStart;
	/**
	 * 有效期始日期前4位(年份)
	 */
	@Column
	private String chkValidDateStart4;
	/**
	 * 有效期始日期前6位(年)
	 */
	@Column
	private String chkValidDateStart6;
	/**
	 * 有效期
	 */
	@Column
	private String chkValidDateEnd;
	/**
	 * 有效期止日期前4位(年份)
	 */
	@Column
	private String chkValidDateEnd4;
	/**
	 * 有效期止日期前6位(年)
	 */
	@Column
	private String chkValidDateEnd6;
	/**
	 * 驾驶证状态的查询结果
	 */
	@Column
	private String chkStatus;

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

	public String getIdNo() {
		return idNo;
	}

	public void setIdNo(String idNo) {
		this.idNo = idNo;
	}

	public String getSeqNo() {
		return seqNo;
	}

	public void setSeqNo(String seqNo) {
		this.seqNo = seqNo;
	}

	public String getIDqueryId() {
		return IDqueryId;
	}

	public void setIDqueryId(String iDqueryId) {
		IDqueryId = iDqueryId;
	}

	public String getSubmitTransNo() {
		return submitTransNo;
	}

	public void setSubmitTransNo(String submitTransNo) {
		this.submitTransNo = submitTransNo;
	}

	public String getChkResult() {
		return chkResult;
	}

	public void setChkResult(String chkResult) {
		this.chkResult = chkResult;
	}

	public String getChkDriverNo() {
		return chkDriverNo;
	}

	public void setChkDriverNo(String chkDriverNo) {
		this.chkDriverNo = chkDriverNo;
	}

	public String getChkName() {
		return chkName;
	}

	public void setChkName(String chkName) {
		this.chkName = chkName;
	}

	public String getChkBirthday() {
		return chkBirthday;
	}

	public void setChkBirthday(String chkBirthday) {
		this.chkBirthday = chkBirthday;
	}

	public String getChkBirthday4() {
		return chkBirthday4;
	}

	public void setChkBirthday4(String chkBirthday4) {
		this.chkBirthday4 = chkBirthday4;
	}

	public String getChkBirthday6() {
		return chkBirthday6;
	}

	public void setChkBirthday6(String chkBirthday6) {
		this.chkBirthday6 = chkBirthday6;
	}

	public String getChkArchivesNo() {
		return chkArchivesNo;
	}

	public void setChkArchivesNo(String chkArchivesNo) {
		this.chkArchivesNo = chkArchivesNo;
	}

	public String getChkQuasiDrivingVehicle() {
		return chkQuasiDrivingVehicle;
	}

	public void setChkQuasiDrivingVehicle(String chkQuasiDrivingVehicle) {
		this.chkQuasiDrivingVehicle = chkQuasiDrivingVehicle;
	}

	public String getChkNationality() {
		return chkNationality;
	}

	public void setChkNationality(String chkNationality) {
		this.chkNationality = chkNationality;
	}

	public String getChkFirstLicensingDate() {
		return chkFirstLicensingDate;
	}

	public void setChkFirstLicensingDate(String chkFirstLicensingDate) {
		this.chkFirstLicensingDate = chkFirstLicensingDate;
	}

	public String getChkFirstLicensingDate4() {
		return chkFirstLicensingDate4;
	}

	public void setChkFirstLicensingDate4(String chkFirstLicensingDate4) {
		this.chkFirstLicensingDate4 = chkFirstLicensingDate4;
	}

	public String getChkFirstLicensingDate6() {
		return chkFirstLicensingDate6;
	}

	public void setChkFirstLicensingDate6(String chkFirstLicensingDate6) {
		this.chkFirstLicensingDate6 = chkFirstLicensingDate6;
	}

	public String getChkValidDateStart() {
		return chkValidDateStart;
	}

	public void setChkValidDateStart(String chkValidDateStart) {
		this.chkValidDateStart = chkValidDateStart;
	}

	public String getChkValidDateStart4() {
		return chkValidDateStart4;
	}

	public void setChkValidDateStart4(String chkValidDateStart4) {
		this.chkValidDateStart4 = chkValidDateStart4;
	}

	public String getChkValidDateStart6() {
		return chkValidDateStart6;
	}

	public void setChkValidDateStart6(String chkValidDateStart6) {
		this.chkValidDateStart6 = chkValidDateStart6;
	}

	public String getChkValidDateEnd() {
		return chkValidDateEnd;
	}

	public void setChkValidDateEnd(String chkValidDateEnd) {
		this.chkValidDateEnd = chkValidDateEnd;
	}

	public String getChkValidDateEnd4() {
		return chkValidDateEnd4;
	}

	public void setChkValidDateEnd4(String chkValidDateEnd4) {
		this.chkValidDateEnd4 = chkValidDateEnd4;
	}

	public String getChkValidDateEnd6() {
		return chkValidDateEnd6;
	}

	public void setChkValidDateEnd6(String chkValidDateEnd6) {
		this.chkValidDateEnd6 = chkValidDateEnd6;
	}

	public String getChkStatus() {
		return chkStatus;
	}

	public void setChkStatus(String chkStatus) {
		this.chkStatus = chkStatus;
	}

}
