package com.pujjr.pcci.dal.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.bfd.facade.Apply_source;
import com.bfd.facade.Biz_industry;
import com.bfd.facade.Biz_positon;
import com.bfd.facade.Biz_type;
import com.bfd.facade.Educationallevel;
import com.bfd.facade.House_type;
import com.bfd.facade.Marriage;

/**
 * @author wen
 * @date 创建时间：2016年10月17日 下午3:00:48 百融打包调用查询请求数据记录表
 *
 */
@Entity
public class HundredCreditTerRequest implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * ID
	 */
	@Id
	@Column(length = 64, nullable = true)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long requestId;

	/**
	 * 查询请求用户/员工编号
	 */
	@Column(nullable = false)
	private String requestUserId;

	/**
	 * 查询请求时间
	 */
	@Column(nullable = false)
	private Date requestDate;

	/**
	 * 登陆唯一标识
	 */
	@Column(nullable = false)
	private String tokenid;

	/**
	 * api调用类型
	 */
	@Column(nullable = false)
	private String apiType;

	/**
	 * 身份证号
	 */
	@Column(nullable = false)
	private String id;

	/**
	 * 手机号
	 */
	@Column(nullable = false)
	private String cell;

	/**
	 * 姓名
	 */
	@Column(nullable = false)
	private String name;

	/**
	 * 电子邮件
	 */
	@Column
	private String mail;

	/**
	 * 设备请求唯一标识
	 */
	@Column
	private String afSwiftNumber;

	/**
	 * 事件类型，采用设备反欺诈模块必填字段。当下支持：antifraud_lend、antifraud_register、antifraud_login
	 */
	@Column
	private String event;

	/**
	 * 申请渠道类型 {@link ApplyType}
	 */
	@Column
	private String applyType;

	/**
	 * 设备标示字段类型 GID、IDFA、IMEI
	 */
	@Column
	private String deviceType;

	/**
	 * 设备标示，泛指全平台所有设备标识
	 */
	@Column
	private String deviceId;

	/**
	 * 子机构代码，协会下属会员名称(仅渠道客户)
	 */
	@Column
	private String subOrgName;

	/**
	 * 百融全局设备标识（需部署百融代码，brid）
	 */
	@Column
	private String gid;

	/**
	 * 公司座机号，区号和分机号用“-”间隔
	 */
	@Column
	private String telBiz;

	/**
	 * 家庭座机号，区号和分机号用“-”间隔
	 */
	@Column
	private String telHome;

	/**
	 * 家庭地址
	 */
	@Column
	private String homeAddr;

	/**
	 * 公司地址
	 */
	@Column
	private String bizAddr;

	/**
	 * 户籍地址
	 */
	@Column
	private String perAddr;

	/**
	 * 申请地址(移动应用为GPS地址)
	 */
	@Column
	private String applyAddr;

	/**
	 * 其他地址
	 */
	@Column
	private String othAddr;

	/**
	 * 银行卡号(信用卡可不提供)
	 */
	@Column
	private String bankId;

	/**
	 * IMEI号(移动应用)
	 */
	@Column
	private String imei;

	/**
	 * IMSI号(移动应用)
	 */
	@Column
	private String imsi;

	/**
	 * 手机品牌(移动应用)
	 */
	@Column
	private String mobileType;

	/**
	 * 性别
	 */
	@Column
	private String sex;

	/**
	 * 年龄
	 */
	@Column
	private int age;

	/**
	 * 学历
	 */
	@Column
	private Educationallevel educationallevel;

	/**
	 * 婚姻状况
	 */
	@Column
	private Marriage marriage;

	/**
	 * 年收入
	 */
	@Column
	private double income;

	/**
	 * 职位
	 */
	@Column
	private Biz_positon bizPositon;

	/**
	 * 公司名称
	 */
	@Column
	private String bizWorkfor;

	/**
	 * 公司性质
	 */
	@Column
	private Biz_type bizType;

	/**
	 * 单位所属行业
	 */
	@Column
	private Biz_industry bizIndustry;

	/**
	 * 住房性质
	 */
	@Column
	private House_type houseType;

	/**
	 * 用户访问ip
	 */
	@Column
	private String IP;

	/**
	 * 用户访问的gps经度
	 */
	@Column
	private String longitude;

	/**
	 * 用户访问的gps纬度
	 */
	@Column
	private String latitude;

	/**
	 * MAC地址
	 */
	@Column
	private String MAC;

	/**
	 * 客户的用户id
	 */
	@Column
	private String userId;

	/**
	 * 客户平台的用户名
	 */
	@Column
	private String userName;

	/**
	 * 客户平台的用户昵称
	 */
	@Column
	private String userNickname;

	/**
	 * 邮政编码
	 */
	@Column
	private String postalcode;

	/**
	 * 申请产品
	 */
	@Column
	private String applyProduct;

	/**
	 * 申请额度
	 */
	@Column
	private String applyMoney;

	/**
	 * 申请时间
	 */
	@Column
	private String applyTime;

	/**
	 * 贷款原因(信用卡可不提供)
	 */
	@Column
	private String loanReason;

	/**
	 * 还款期数(信用卡可不提供)
	 */
	@Column
	private int refundPeriods;

	/**
	 * 联系人姓名
	 */
	@Column
	private String linkmanName;

	/**
	 * 联系人手机号
	 */
	@Column
	private String linkmanCell;

	/**
	 * 联系人关系
	 */
	@Column
	private String linkmanRela;

	/**
	 * 客户APP登录次数
	 */
	@Column
	private int appVisitNum;

	/**
	 * 学历、学籍证明附件数量
	 */
	@Column
	private int eduAttNum;

	/**
	 * 银行卡流水附件数量
	 */
	@Column
	private int bankRunningAttNum;

	/**
	 * 此次请求产品代号
	 */
	@Column
	private String meal;

	/**
	 * 设备标识字段类型，采用设备反欺诈模块必填字段 GID、IDFA、IMEI
	 */
	@Column
	private String deviceType2;

	/**
	 * 设备标示，泛指全平台所有设备标识，采用设备反欺诈模块必填字段
	 */
	@Column
	private String deviceId2;

	/**
	 * 设备标识字段类型，采用设备反欺诈模块必填字段 GID、IDFA、IMEI
	 */
	@Column
	private String deviceType3;

	/**
	 * 设备标示，泛指全平台所有设备标识，采用设备反欺诈模块必填字段
	 */
	@Column
	private String deviceId3;

	/**
	 * 申请渠道
	 */
	@Column
	private Apply_source applySource;

	/**
	 * 请求结果
	 */
	@Column(length = 2048)
	private String result;

	public Long getRequestId() {
		return requestId;
	}

	public void setRequestId(Long requestId) {
		this.requestId = requestId;
	}

	public String getRequestUserId() {
		return requestUserId;
	}

	public void setRequestUserId(String requestUserId) {
		this.requestUserId = requestUserId;
	}

	public Date getRequestDate() {
		return requestDate;
	}

	public void setRequestDate(Date requestDate) {
		this.requestDate = requestDate;
	}

	public String getTokenid() {
		return tokenid;
	}

	public void setTokenid(String tokenid) {
		this.tokenid = tokenid;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCell() {
		return cell;
	}

	public void setCell(String cell) {
		this.cell = cell;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getAfSwiftNumber() {
		return afSwiftNumber;
	}

	public void setAfSwiftNumber(String afSwiftNumber) {
		this.afSwiftNumber = afSwiftNumber;
	}

	public String getEvent() {
		return event;
	}

	public void setEvent(String event) {
		this.event = event;
	}

	public String getApiType() {
		return apiType;
	}

	public void setApiType(String apiType) {
		this.apiType = apiType;
	}

	public String getApplyType() {
		return applyType;
	}

	public void setApplyType(String applyType) {
		this.applyType = applyType;
	}

	public String getDeviceType() {
		return deviceType;
	}

	public void setDeviceType(String deviceType) {
		this.deviceType = deviceType;
	}

	public String getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}

	public String getSubOrgName() {
		return subOrgName;
	}

	public void setSubOrgName(String subOrgName) {
		this.subOrgName = subOrgName;
	}

	public String getGid() {
		return gid;
	}

	public void setGid(String gid) {
		this.gid = gid;
	}

	public String getTelBiz() {
		return telBiz;
	}

	public void setTelBiz(String telBiz) {
		this.telBiz = telBiz;
	}

	public String getTelHome() {
		return telHome;
	}

	public void setTelHome(String telHome) {
		this.telHome = telHome;
	}

	public String getHomeAddr() {
		return homeAddr;
	}

	public void setHomeAddr(String homeAddr) {
		this.homeAddr = homeAddr;
	}

	public String getBizAddr() {
		return bizAddr;
	}

	public void setBizAddr(String bizAddr) {
		this.bizAddr = bizAddr;
	}

	public String getPerAddr() {
		return perAddr;
	}

	public void setPerAddr(String perAddr) {
		this.perAddr = perAddr;
	}

	public String getApplyAddr() {
		return applyAddr;
	}

	public void setApplyAddr(String applyAddr) {
		this.applyAddr = applyAddr;
	}

	public String getOthAddr() {
		return othAddr;
	}

	public void setOthAddr(String othAddr) {
		this.othAddr = othAddr;
	}

	public String getBankId() {
		return bankId;
	}

	public void setBankId(String bankId) {
		this.bankId = bankId;
	}

	public String getImei() {
		return imei;
	}

	public void setImei(String imei) {
		this.imei = imei;
	}

	public String getImsi() {
		return imsi;
	}

	public void setImsi(String imsi) {
		this.imsi = imsi;
	}

	public String getMobileType() {
		return mobileType;
	}

	public void setMobileType(String mobileType) {
		this.mobileType = mobileType;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Educationallevel getEducationallevel() {
		return educationallevel;
	}

	public void setEducationallevel(Educationallevel educationallevel) {
		this.educationallevel = educationallevel;
	}

	public Marriage getMarriage() {
		return marriage;
	}

	public void setMarriage(Marriage marriage) {
		this.marriage = marriage;
	}

	public double getIncome() {
		return income;
	}

	public void setIncome(double income) {
		this.income = income;
	}

	public Biz_positon getBizPositon() {
		return bizPositon;
	}

	public void setBizPositon(Biz_positon bizPositon) {
		this.bizPositon = bizPositon;
	}

	public String getBizWorkfor() {
		return bizWorkfor;
	}

	public void setBizWorkfor(String bizWorkfor) {
		this.bizWorkfor = bizWorkfor;
	}

	public Biz_type getBizType() {
		return bizType;
	}

	public void setBizType(Biz_type bizType) {
		this.bizType = bizType;
	}

	public Biz_industry getBizIndustry() {
		return bizIndustry;
	}

	public void setBizIndustry(Biz_industry bizIndustry) {
		this.bizIndustry = bizIndustry;
	}

	public House_type getHouseType() {
		return houseType;
	}

	public void setHouseType(House_type houseType) {
		this.houseType = houseType;
	}

	public String getIP() {
		return IP;
	}

	public void setIP(String iP) {
		IP = iP;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getMAC() {
		return MAC;
	}

	public void setMAC(String mAC) {
		MAC = mAC;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserNickname() {
		return userNickname;
	}

	public void setUserNickname(String userNickname) {
		this.userNickname = userNickname;
	}

	public String getPostalcode() {
		return postalcode;
	}

	public void setPostalcode(String postalcode) {
		this.postalcode = postalcode;
	}

	public String getApplyProduct() {
		return applyProduct;
	}

	public void setApplyProduct(String applyProduct) {
		this.applyProduct = applyProduct;
	}

	public String getApplyMoney() {
		return applyMoney;
	}

	public void setApplyMoney(String applyMoney) {
		this.applyMoney = applyMoney;
	}

	public String getApplyTime() {
		return applyTime;
	}

	public void setApplyTime(String applyTime) {
		this.applyTime = applyTime;
	}

	public String getLoanReason() {
		return loanReason;
	}

	public void setLoanReason(String loanReason) {
		this.loanReason = loanReason;
	}

	public int getRefundPeriods() {
		return refundPeriods;
	}

	public void setRefundPeriods(int refundPeriods) {
		this.refundPeriods = refundPeriods;
	}

	public String getLinkmanName() {
		return linkmanName;
	}

	public void setLinkmanName(String linkmanName) {
		this.linkmanName = linkmanName;
	}

	public String getLinkmanCell() {
		return linkmanCell;
	}

	public void setLinkmanCell(String linkmanCell) {
		this.linkmanCell = linkmanCell;
	}

	public String getLinkmanRela() {
		return linkmanRela;
	}

	public void setLinkmanRela(String linkmanRela) {
		this.linkmanRela = linkmanRela;
	}

	public int getAppVisitNum() {
		return appVisitNum;
	}

	public void setAppVisitNum(int appVisitNum) {
		this.appVisitNum = appVisitNum;
	}

	public int getEduAttNum() {
		return eduAttNum;
	}

	public void setEduAttNum(int eduAttNum) {
		this.eduAttNum = eduAttNum;
	}

	public int getBankRunningAttNum() {
		return bankRunningAttNum;
	}

	public void setBankRunningAttNum(int bankRunningAttNum) {
		this.bankRunningAttNum = bankRunningAttNum;
	}

	public String getMeal() {
		return meal;
	}

	public void setMeal(String meal) {
		this.meal = meal;
	}

	public String getDeviceType2() {
		return deviceType2;
	}

	public void setDeviceType2(String deviceType2) {
		this.deviceType2 = deviceType2;
	}

	public String getDeviceId2() {
		return deviceId2;
	}

	public void setDeviceId2(String deviceId2) {
		this.deviceId2 = deviceId2;
	}

	public String getDeviceType3() {
		return deviceType3;
	}

	public void setDeviceType3(String deviceType3) {
		this.deviceType3 = deviceType3;
	}

	public String getDeviceId3() {
		return deviceId3;
	}

	public void setDeviceId3(String deviceId3) {
		this.deviceId3 = deviceId3;
	}

	public Apply_source getApplySource() {
		return applySource;
	}

	public void setApplySource(Apply_source applySource) {
		this.applySource = applySource;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

}
