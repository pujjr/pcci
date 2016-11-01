package org.pcci.api.bean.request;

import java.io.Serializable;

import com.pujjr.common.type.DrivingVehicleType;
import com.pujjr.common.type.IdentityType;
import com.pujjr.common.type.credit.QueryReasonType;

/**
 * @author wen
 * @date 创建时间：2016年10月10日 上午10:43:35 批次记录信息
 */
public class QianHaiRequestData implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 交易唯一标识
	 */
	private String transNo;

	/**
	 * 交易批次号
	 */
	private String batchNo;

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

	/**
	 * 业务发生时间 支持两种格式 yyyy-MM-dd HH:mm:ss yyyy-MM-dd
	 * 
	 */
	private String updatedDate;

	/**
	 * 任务提交交易流水号
	 */
	private String submitTransNo;

	/**
	 * 风险标记
	 */
	private String rskMark;

	/**
	 * 联系人
	 */
	private String refName;

	/**
	 * 联系人手机号
	 */
	private String refMobileNo;

	/**
	 * 查询原因
	 */
	private String reasonNo;

	/**
	 * 任务id
	 */
	private String queryId;

	/**
	 * 子产品信息
	 * 
	 * 2、从右到左每一位代表一种认证模式，如下： 第1位：实名验证 第2位：地址验证 第3位：工作单位验证 第4位：手机验证(请用第十位，为升级版) 第5位：关系人验证 第6位：车辆验证 第7位：房产验证 第8位：人脸识别 第9位：学历验证 第10位：手机验证II 3、每位值的含义说明：'1'表示验证，'0'表示不验证 4、长度必须为16位，左补0对齐 5、举例说明： 0000000000010101-表示本次交易进行实名认证、工作单位验证、关系人验证
	 */
	private String subProductInc;

	/**
	 * 相片
	 */
	private String photo64;

	/**
	 * 是否查询行驶证状态
	 */
	private String needeQryDrvStatus;

	/**
	 * 金额
	 */
	private String money;

	/**
	 * 手机号集
	 */
	private String moblieNos;

	/**
	 * 手机号
	 */
	private String mobileNo;

	/**
	 * ip
	 */
	private String ips;

	/**
	 * 报送严重等级
	 */
	private String gradeReport;

	/**
	 * 发动机号
	 */
	private String engineNo;
	/**
	 * 学历
	 */
	private String eductionBckgrd;

	/**
	 * 币种
	 */
	private String currency;
	/**
	 * 工作单位
	 */
	private String company;
	/**
	 * 车牌号
	 */
	private String carNo;
	/**
	 * 车架号
	 */
	private String carFrameNum;
	/**
	 * 卡号集
	 */
	private String cardNos;

	/**
	 * 行政区代码
	 */
	private String areaCode;

	/**
	 * 联系地址
	 */
	private String address;

	/**
	 * @return 驾驶证号
	 */
	public String getDriverNo() {
		return driverNo;
	}

	/**
	 * @param 驾驶证号
	 *            要设置的 driverNo
	 */
	public void setDriverNo(String driverNo) {
		this.driverNo = driverNo;
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
	 * @return 证件类型{@linkIdentityType}
	 */
	public String getIdType() {
		return idType;
	}

	/**
	 * @param 证件类型{@linkIdentityType}
	 * 			要设置的 idType
	 */
	public void setIdType(String idType) {
		this.idType = idType;
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
	 * @return 查询原因{@linkQueryReasonType}
	 */
	public String getReasonCode() {
		return reasonCode;
	}

	/**
	 * @param 查询原因{@linkQueryReasonType}
	 * 			要设置的 reasonCode
	 */
	public void setReasonCode(String reasonCode) {
		this.reasonCode = reasonCode;
	}

	/**
	 * @return 是否验证用户名默认验证CHECK_NO0：不验证CHECK_YES1：验证
	 */
	public String getIsNeedChkUn() {
		return isNeedChkUn;
	}

	/**
	 * @param 是否验证用户名默认验证CHECK_NO0：不验证CHECK_YES1：验证
	 *            要设置的 isNeedChkUn
	 */
	public void setIsNeedChkUn(String isNeedChkUn) {
		this.isNeedChkUn = isNeedChkUn;
	}

	/**
	 * @return 出生日期格式为yyyyMMdd
	 */
	public String getBirthday() {
		return birthday;
	}

	/**
	 * @param 出生日期格式为yyyyMMdd
	 *            要设置的 birthday
	 */
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	/**
	 * @return 出生日期格式为yyyy
	 */
	public String getBirthday4() {
		return birthday4;
	}

	/**
	 * @param 出生日期格式为yyyy
	 *            要设置的 birthday4
	 */
	public void setBirthday4(String birthday4) {
		this.birthday4 = birthday4;
	}

	/**
	 * @return 出生日期前6位格式为yyyyMM
	 */
	public String getBirthday6() {
		return birthday6;
	}

	/**
	 * @param 出生日期前6位格式为yyyyMM
	 *            要设置的 birthday6
	 */
	public void setBirthday6(String birthday6) {
		this.birthday6 = birthday6;
	}

	/**
	 * @return 档案编号
	 */
	public String getArchivesNo() {
		return archivesNo;
	}

	/**
	 * @param 档案编号
	 *            要设置的 archivesNo
	 */
	public void setArchivesNo(String archivesNo) {
		this.archivesNo = archivesNo;
	}

	/**
	 * @return 准驾车型{@linkDrivingVehicleType}
	 */
	public String getQuasiDrivingVehicle() {
		return quasiDrivingVehicle;
	}

	/**
	 * @param 准驾车型{@linkDrivingVehicleType}
	 * 			要设置的 quasiDrivingVehicle
	 */
	public void setQuasiDrivingVehicle(String quasiDrivingVehicle) {
		this.quasiDrivingVehicle = quasiDrivingVehicle;
	}

	/**
	 * @return 国籍（暂不支持）
	 */
	public String getNationality() {
		return nationality;
	}

	/**
	 * @param 国籍（暂不支持）
	 *            要设置的 nationality
	 */
	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	/**
	 * @return 初次领证时间yyyyMMdd
	 */
	public String getFirstLicensingDate() {
		return firstLicensingDate;
	}

	/**
	 * @param 初次领证时间yyyyMMdd
	 *            要设置的 firstLicensingDate
	 */
	public void setFirstLicensingDate(String firstLicensingDate) {
		this.firstLicensingDate = firstLicensingDate;
	}

	/**
	 * @return 初次领证时间前4位yyyy
	 */
	public String getFirstLicensingDate4() {
		return firstLicensingDate4;
	}

	/**
	 * @param 初次领证时间前4位yyyy
	 *            要设置的 firstLicensingDate4
	 */
	public void setFirstLicensingDate4(String firstLicensingDate4) {
		this.firstLicensingDate4 = firstLicensingDate4;
	}

	/**
	 * @return 初次领证时间前6位yyyyMM
	 */
	public String getFirstLicensingDate6() {
		return firstLicensingDate6;
	}

	/**
	 * @param 初次领证时间前6位yyyyMM
	 *            要设置的 firstLicensingDate6
	 */
	public void setFirstLicensingDate6(String firstLicensingDate6) {
		this.firstLicensingDate6 = firstLicensingDate6;
	}

	/**
	 * @return 有效期始
	 */
	public String getValidDateStart() {
		return validDateStart;
	}

	/**
	 * @param 有效期始
	 *            要设置的 validDateStart
	 */
	public void setValidDateStart(String validDateStart) {
		this.validDateStart = validDateStart;
	}

	/**
	 * @return 有效期始日日期前4位(年份)yyyy
	 */
	public String getValidDateStart4() {
		return validDateStart4;
	}

	/**
	 * @param 有效期始日日期前4位(年份)yyyy
	 *            要设置的 validDateStart4
	 */
	public void setValidDateStart4(String validDateStart4) {
		this.validDateStart4 = validDateStart4;
	}

	/**
	 * @return 有效期始日日期前6位(年月)yyyyMM
	 */
	public String getValidDateStart6() {
		return validDateStart6;
	}

	/**
	 * @param 有效期始日日期前6位(年月)yyyyMM
	 *            要设置的 validDateStart6
	 */
	public void setValidDateStart6(String validDateStart6) {
		this.validDateStart6 = validDateStart6;
	}

	/**
	 * @return 有效期止
	 */
	public String getValidDateEnd() {
		return validDateEnd;
	}

	/**
	 * @param 有效期止
	 *            要设置的 validDateEnd
	 */
	public void setValidDateEnd(String validDateEnd) {
		this.validDateEnd = validDateEnd;
	}

	/**
	 * @return 有效期止日日期前4位(年份)yyyy
	 */
	public String getValidDateEnd4() {
		return validDateEnd4;
	}

	/**
	 * @param 有效期止日日期前4位(年份)yyyy
	 *            要设置的 validDateEnd4
	 */
	public void setValidDateEnd4(String validDateEnd4) {
		this.validDateEnd4 = validDateEnd4;
	}

	/**
	 * @return 有效期止日日期前6位(年月)yyyyMM
	 */
	public String getValidDateEnd6() {
		return validDateEnd6;
	}

	/**
	 * @param 有效期止日日期前6位(年月)yyyyMM
	 *            要设置的 validDateEnd6
	 */
	public void setValidDateEnd6(String validDateEnd6) {
		this.validDateEnd6 = validDateEnd6;
	}

	/**
	 * @return 业务描述
	 */
	public String getBusiDesc() {
		return busiDesc;
	}

	/**
	 * @param 业务描述
	 *            要设置的 busiDesc
	 */
	public void setBusiDesc(String busiDesc) {
		this.busiDesc = busiDesc;
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
	 * @return 序列号子批次号，本批次内唯一
	 */
	public String getSeqNo() {
		return seqNo;
	}

	/**
	 * @param 序列号子批次号，本批次内唯一
	 *            要设置的 seqNo
	 */
	public void setSeqNo(String seqNo) {
		this.seqNo = seqNo;
	}

	/**
	 * @return 业务发生时间支持两种格式yyyy-MM-ddHH:mm:ssyyyy-MM-dd
	 */
	public String getUpdatedDate() {
		return updatedDate;
	}

	/**
	 * @param 业务发生时间支持两种格式yyyy-MM-ddHH:mm:ssyyyy-MM-dd
	 *            要设置的 updatedDate
	 */
	public void setUpdatedDate(String updatedDate) {
		this.updatedDate = updatedDate;
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
	 * @return 联系人
	 */
	public String getRefName() {
		return refName;
	}

	/**
	 * @param 联系人
	 *            要设置的 refName
	 */
	public void setRefName(String refName) {
		this.refName = refName;
	}

	/**
	 * @return 联系人手机号
	 */
	public String getRefMobileNo() {
		return refMobileNo;
	}

	/**
	 * @param 联系人手机号
	 *            要设置的 refMobileNo
	 */
	public void setRefMobileNo(String refMobileNo) {
		this.refMobileNo = refMobileNo;
	}

	/**
	 * @return 查询原因
	 */
	public String getReasonNo() {
		return reasonNo;
	}

	/**
	 * @param 查询原因
	 *            要设置的 reasonNo
	 */
	public void setReasonNo(String reasonNo) {
		this.reasonNo = reasonNo;
	}

	/**
	 * @return 任务id
	 */
	public String getQueryId() {
		return queryId;
	}

	/**
	 * @param 任务id
	 *            要设置的 queryId
	 */
	public void setQueryId(String queryId) {
		this.queryId = queryId;
	}

	/**
	 * @return 相片
	 */
	public String getPhoto64() {
		return photo64;
	}

	/**
	 * @param 相片
	 *            要设置的 photo64
	 */
	public void setPhoto64(String photo64) {
		this.photo64 = photo64;
	}

	/**
	 * @return 是否查询行驶证状态
	 */
	public String getNeedeQryDrvStatus() {
		return needeQryDrvStatus;
	}

	/**
	 * @param 是否查询行驶证状态
	 *            要设置的 needeQryDrvStatus
	 */
	public void setNeedeQryDrvStatus(String needeQryDrvStatus) {
		this.needeQryDrvStatus = needeQryDrvStatus;
	}

	/**
	 * @return 金额
	 */
	public String getMoney() {
		return money;
	}

	/**
	 * @param 金额
	 *            要设置的 money
	 */
	public void setMoney(String money) {
		this.money = money;
	}

	/**
	 * @return 手机号集
	 */
	public String getMoblieNos() {
		return moblieNos;
	}

	/**
	 * @param 手机号集
	 *            要设置的 moblieNos
	 */
	public void setMoblieNos(String moblieNos) {
		this.moblieNos = moblieNos;
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
	 * @return ip
	 */
	public String getIps() {
		return ips;
	}

	/**
	 * @param ip
	 *            要设置的 ips
	 */
	public void setIps(String ips) {
		this.ips = ips;
	}

	/**
	 * @return 报送严重等级
	 */
	public String getGradeReport() {
		return gradeReport;
	}

	/**
	 * @param 报送严重等级
	 *            要设置的 gradeReport
	 */
	public void setGradeReport(String gradeReport) {
		this.gradeReport = gradeReport;
	}

	/**
	 * @return 发动机号
	 */
	public String getEngineNo() {
		return engineNo;
	}

	/**
	 * @param 发动机号
	 *            要设置的 engineNo
	 */
	public void setEngineNo(String engineNo) {
		this.engineNo = engineNo;
	}

	/**
	 * @return 学历
	 */
	public String getEductionBckgrd() {
		return eductionBckgrd;
	}

	/**
	 * @param 学历
	 *            要设置的 eductionBckgrd
	 */
	public void setEductionBckgrd(String eductionBckgrd) {
		this.eductionBckgrd = eductionBckgrd;
	}

	/**
	 * @return 币种
	 */
	public String getCurrency() {
		return currency;
	}

	/**
	 * @param 币种
	 *            要设置的 currency
	 */
	public void setCurrency(String currency) {
		this.currency = currency;
	}

	/**
	 * @return 工作单位
	 */
	public String getCompany() {
		return company;
	}

	/**
	 * @param 工作单位
	 *            要设置的 company
	 */
	public void setCompany(String company) {
		this.company = company;
	}

	/**
	 * @return 车牌号
	 */
	public String getCarNo() {
		return carNo;
	}

	/**
	 * @param 车牌号
	 *            要设置的 carNo
	 */
	public void setCarNo(String carNo) {
		this.carNo = carNo;
	}

	/**
	 * @return 车架号
	 */
	public String getCarFrameNum() {
		return carFrameNum;
	}

	/**
	 * @param 车架号
	 *            要设置的 carFrameNum
	 */
	public void setCarFrameNum(String carFrameNum) {
		this.carFrameNum = carFrameNum;
	}

	/**
	 * @return 卡号集
	 */
	public String getCardNos() {
		return cardNos;
	}

	/**
	 * @param 卡号集
	 *            要设置的 cardNos
	 */
	public void setCardNos(String cardNos) {
		this.cardNos = cardNos;
	}

	/**
	 * @return 行政区代码
	 */
	public String getAreaCode() {
		return areaCode;
	}

	/**
	 * @param 行政区代码
	 *            要设置的 areaCode
	 */
	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}

	/**
	 * @return 联系地址
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param 联系地址
	 *            要设置的 address
	 */
	public void setAddress(String address) {
		this.address = address;
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
	 * @return 子产品信息2、从右到左每一位代表一种认证模式，如下：第1位：实名验证第2位：地址验证第3位：工作单位验证第4位：手机验证(请用第十位，为升级版)第5位：关系人验证第6位：车辆验证第7位：房产验证第8位：人脸识别第9位：学历验证第10位：手机验证II3、每位值的含义说明：'1'表示验证，'0'表示不验证4、长度必须为16位，左补0对齐5、举例说明：0000000000010101-表示本次交易进行实名认证、工作单位验证、关系人验证
	 */
	public String getSubProductInc() {
		return subProductInc;
	}

	/**
	 * @param 子产品信息2、从右到左每一位代表一种认证模式，如下：第1位：实名验证第2位：地址验证第3位：工作单位验证第4位：手机验证(请用第十位，为升级版)第5位：关系人验证第6位：车辆验证第7位：房产验证第8位：人脸识别第9位：学历验证第10位：手机验证II3、每位值的含义说明：'1'表示验证，'0'表示不验证4、长度必须为16位，左补0对齐5、举例说明：0000000000010101-表示本次交易进行实名认证、工作单位验证、关系人验证
	 *            要设置的 subProductInc
	 */
	public void setSubProductInc(String subProductInc) {
		this.subProductInc = subProductInc;
	}

}
