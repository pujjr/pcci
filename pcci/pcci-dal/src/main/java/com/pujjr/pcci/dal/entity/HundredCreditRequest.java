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
public class HundredCreditRequest implements Serializable {

	private static final long serialVersionUID = 1L;

	public static final String API_TYPE_DAS = "das";

	public static final String API_TYPE_TER = "ter";

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
	 * 车牌号
	 */
	@Column
	private String carnum;

	/**
	 * 车架号
	 */
	@Column
	private String vinnum;

	/**
	 * 发动机号
	 */
	@Column
	private String enginenum;

	/**
	 * 
	 */
	@Column
	private String keyNo;

	/**
	 * 
	 */
	@Column
	private String downstreamCount;

	/**
	 * 
	 */
	@Column
	private String upstreamCount;

	/**
	 * 
	 */
	@Column
	private String searchKey;

	/**
	 * 公司机构代码
	 */
	@Column
	private String bizOrgcode;

	/**
	 * 
	 */
	@Column
	private String bizTaxnum;

	/**
	 * 
	 */
	@Column
	private String bizRegnum;

	/**
	 * 图片字符串 ImgUtil.GetImageStr("D:\\jyh\\zz.jpg")
	 */
	@Column
	private String idPhoto;

	/**
	 * 图片字符串 ImgUtil.GetImageStr("D:\\jyh\\zz.jpg")
	 */
	@Column
	private String dailyPhoto;

	/**
	 * 
	 */
	@Column(name = "das_index")
	private String index;

	/**
	 * @return ID
	 */
	public Long getRequestId() {
		return requestId;
	}

	/**
	 * @param ID
	 *            要设置的 requestId
	 */
	public void setRequestId(Long requestId) {
		this.requestId = requestId;
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
	 * @return 登陆唯一标识
	 */
	public String getTokenid() {
		return tokenid;
	}

	/**
	 * @param 登陆唯一标识
	 *            要设置的 tokenid
	 */
	public void setTokenid(String tokenid) {
		this.tokenid = tokenid;
	}

	/**
	 * @return api调用类型
	 */
	public String getApiType() {
		return apiType;
	}

	/**
	 * @param api调用类型
	 *            要设置的 apiType
	 */
	public void setApiType(String apiType) {
		this.apiType = apiType;
	}

	/**
	 * @return 身份证号
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param 身份证号
	 *            要设置的 id
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return 手机号
	 */
	public String getCell() {
		return cell;
	}

	/**
	 * @param 手机号
	 *            要设置的 cell
	 */
	public void setCell(String cell) {
		this.cell = cell;
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
	 * @return 电子邮件
	 */
	public String getMail() {
		return mail;
	}

	/**
	 * @param 电子邮件
	 *            要设置的 mail
	 */
	public void setMail(String mail) {
		this.mail = mail;
	}

	/**
	 * @return 设备请求唯一标识
	 */
	public String getAfSwiftNumber() {
		return afSwiftNumber;
	}

	/**
	 * @param 设备请求唯一标识
	 *            要设置的 afSwiftNumber
	 */
	public void setAfSwiftNumber(String afSwiftNumber) {
		this.afSwiftNumber = afSwiftNumber;
	}

	/**
	 * @return 事件类型，采用设备反欺诈模块必填字段。当下支持：antifraud_lend、antifraud_register、antifraud_login
	 */
	public String getEvent() {
		return event;
	}

	/**
	 * @param 事件类型，采用设备反欺诈模块必填字段。当下支持：antifraud_lend、antifraud_register、antifraud_login
	 *            要设置的 event
	 */
	public void setEvent(String event) {
		this.event = event;
	}

	/**
	 * @return 申请渠道类型{@linkApplyType}
	 */
	public String getApplyType() {
		return applyType;
	}

	/**
	 * @param 申请渠道类型{@linkApplyType}
	 * 			要设置的 applyType
	 */
	public void setApplyType(String applyType) {
		this.applyType = applyType;
	}

	/**
	 * @return 设备标示字段类型GID、IDFA、IMEI
	 */
	public String getDeviceType() {
		return deviceType;
	}

	/**
	 * @param 设备标示字段类型GID、IDFA、IMEI
	 *            要设置的 deviceType
	 */
	public void setDeviceType(String deviceType) {
		this.deviceType = deviceType;
	}

	/**
	 * @return 设备标示，泛指全平台所有设备标识
	 */
	public String getDeviceId() {
		return deviceId;
	}

	/**
	 * @param 设备标示，泛指全平台所有设备标识
	 *            要设置的 deviceId
	 */
	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}

	/**
	 * @return 子机构代码，协会下属会员名称(仅渠道客户)
	 */
	public String getSubOrgName() {
		return subOrgName;
	}

	/**
	 * @param 子机构代码，协会下属会员名称(仅渠道客户)
	 *            要设置的 subOrgName
	 */
	public void setSubOrgName(String subOrgName) {
		this.subOrgName = subOrgName;
	}

	/**
	 * @return 百融全局设备标识（需部署百融代码，brid）
	 */
	public String getGid() {
		return gid;
	}

	/**
	 * @param 百融全局设备标识（需部署百融代码，brid）
	 *            要设置的 gid
	 */
	public void setGid(String gid) {
		this.gid = gid;
	}

	/**
	 * @return 公司座机号，区号和分机号用“-”间隔
	 */
	public String getTelBiz() {
		return telBiz;
	}

	/**
	 * @param 公司座机号，区号和分机号用“-”间隔
	 *            要设置的 telBiz
	 */
	public void setTelBiz(String telBiz) {
		this.telBiz = telBiz;
	}

	/**
	 * @return 家庭座机号，区号和分机号用“-”间隔
	 */
	public String getTelHome() {
		return telHome;
	}

	/**
	 * @param 家庭座机号，区号和分机号用“-”间隔
	 *            要设置的 telHome
	 */
	public void setTelHome(String telHome) {
		this.telHome = telHome;
	}

	/**
	 * @return 家庭地址
	 */
	public String getHomeAddr() {
		return homeAddr;
	}

	/**
	 * @param 家庭地址
	 *            要设置的 homeAddr
	 */
	public void setHomeAddr(String homeAddr) {
		this.homeAddr = homeAddr;
	}

	/**
	 * @return 公司地址
	 */
	public String getBizAddr() {
		return bizAddr;
	}

	/**
	 * @param 公司地址
	 *            要设置的 bizAddr
	 */
	public void setBizAddr(String bizAddr) {
		this.bizAddr = bizAddr;
	}

	/**
	 * @return 户籍地址
	 */
	public String getPerAddr() {
		return perAddr;
	}

	/**
	 * @param 户籍地址
	 *            要设置的 perAddr
	 */
	public void setPerAddr(String perAddr) {
		this.perAddr = perAddr;
	}

	/**
	 * @return 申请地址(移动应用为GPS地址)
	 */
	public String getApplyAddr() {
		return applyAddr;
	}

	/**
	 * @param 申请地址(移动应用为GPS地址)
	 *            要设置的 applyAddr
	 */
	public void setApplyAddr(String applyAddr) {
		this.applyAddr = applyAddr;
	}

	/**
	 * @return 其他地址
	 */
	public String getOthAddr() {
		return othAddr;
	}

	/**
	 * @param 其他地址
	 *            要设置的 othAddr
	 */
	public void setOthAddr(String othAddr) {
		this.othAddr = othAddr;
	}

	/**
	 * @return 银行卡号(信用卡可不提供)
	 */
	public String getBankId() {
		return bankId;
	}

	/**
	 * @param 银行卡号(信用卡可不提供)
	 *            要设置的 bankId
	 */
	public void setBankId(String bankId) {
		this.bankId = bankId;
	}

	/**
	 * @return IMEI号(移动应用)
	 */
	public String getImei() {
		return imei;
	}

	/**
	 * @param IMEI号(移动应用)
	 *            要设置的 imei
	 */
	public void setImei(String imei) {
		this.imei = imei;
	}

	/**
	 * @return IMSI号(移动应用)
	 */
	public String getImsi() {
		return imsi;
	}

	/**
	 * @param IMSI号(移动应用)
	 *            要设置的 imsi
	 */
	public void setImsi(String imsi) {
		this.imsi = imsi;
	}

	/**
	 * @return 手机品牌(移动应用)
	 */
	public String getMobileType() {
		return mobileType;
	}

	/**
	 * @param 手机品牌(移动应用)
	 *            要设置的 mobileType
	 */
	public void setMobileType(String mobileType) {
		this.mobileType = mobileType;
	}

	/**
	 * @return 性别
	 */
	public String getSex() {
		return sex;
	}

	/**
	 * @param 性别
	 *            要设置的 sex
	 */
	public void setSex(String sex) {
		this.sex = sex;
	}

	/**
	 * @return 年龄
	 */
	public int getAge() {
		return age;
	}

	/**
	 * @param 年龄
	 *            要设置的 age
	 */
	public void setAge(int age) {
		this.age = age;
	}

	/**
	 * @return 学历
	 */
	public Educationallevel getEducationallevel() {
		return educationallevel;
	}

	/**
	 * @param 学历
	 *            要设置的 educationallevel
	 */
	public void setEducationallevel(Educationallevel educationallevel) {
		this.educationallevel = educationallevel;
	}

	/**
	 * @return 婚姻状况
	 */
	public Marriage getMarriage() {
		return marriage;
	}

	/**
	 * @param 婚姻状况
	 *            要设置的 marriage
	 */
	public void setMarriage(Marriage marriage) {
		this.marriage = marriage;
	}

	/**
	 * @return 年收入
	 */
	public double getIncome() {
		return income;
	}

	/**
	 * @param 年收入
	 *            要设置的 income
	 */
	public void setIncome(double income) {
		this.income = income;
	}

	/**
	 * @return 职位
	 */
	public Biz_positon getBizPositon() {
		return bizPositon;
	}

	/**
	 * @param 职位
	 *            要设置的 bizPositon
	 */
	public void setBizPositon(Biz_positon bizPositon) {
		this.bizPositon = bizPositon;
	}

	/**
	 * @return 公司名称
	 */
	public String getBizWorkfor() {
		return bizWorkfor;
	}

	/**
	 * @param 公司名称
	 *            要设置的 bizWorkfor
	 */
	public void setBizWorkfor(String bizWorkfor) {
		this.bizWorkfor = bizWorkfor;
	}

	/**
	 * @return 公司性质
	 */
	public Biz_type getBizType() {
		return bizType;
	}

	/**
	 * @param 公司性质
	 *            要设置的 bizType
	 */
	public void setBizType(Biz_type bizType) {
		this.bizType = bizType;
	}

	/**
	 * @return 单位所属行业
	 */
	public Biz_industry getBizIndustry() {
		return bizIndustry;
	}

	/**
	 * @param 单位所属行业
	 *            要设置的 bizIndustry
	 */
	public void setBizIndustry(Biz_industry bizIndustry) {
		this.bizIndustry = bizIndustry;
	}

	/**
	 * @return 住房性质
	 */
	public House_type getHouseType() {
		return houseType;
	}

	/**
	 * @param 住房性质
	 *            要设置的 houseType
	 */
	public void setHouseType(House_type houseType) {
		this.houseType = houseType;
	}

	/**
	 * @return iP
	 */
	public String getIP() {
		return IP;
	}

	/**
	 * @param iP
	 *            要设置的 iP
	 */
	public void setIP(String iP) {
		IP = iP;
	}

	/**
	 * @return 用户访问的gps经度
	 */
	public String getLongitude() {
		return longitude;
	}

	/**
	 * @param 用户访问的gps经度
	 *            要设置的 longitude
	 */
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	/**
	 * @return 用户访问的gps纬度
	 */
	public String getLatitude() {
		return latitude;
	}

	/**
	 * @param 用户访问的gps纬度
	 *            要设置的 latitude
	 */
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	/**
	 * @return mAC
	 */
	public String getMAC() {
		return MAC;
	}

	/**
	 * @param mAC
	 *            要设置的 mAC
	 */
	public void setMAC(String mAC) {
		MAC = mAC;
	}

	/**
	 * @return 客户的用户id
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * @param 客户的用户id
	 *            要设置的 userId
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}

	/**
	 * @return 客户平台的用户名
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @param 客户平台的用户名
	 *            要设置的 userName
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * @return 客户平台的用户昵称
	 */
	public String getUserNickname() {
		return userNickname;
	}

	/**
	 * @param 客户平台的用户昵称
	 *            要设置的 userNickname
	 */
	public void setUserNickname(String userNickname) {
		this.userNickname = userNickname;
	}

	/**
	 * @return 邮政编码
	 */
	public String getPostalcode() {
		return postalcode;
	}

	/**
	 * @param 邮政编码
	 *            要设置的 postalcode
	 */
	public void setPostalcode(String postalcode) {
		this.postalcode = postalcode;
	}

	/**
	 * @return 申请产品
	 */
	public String getApplyProduct() {
		return applyProduct;
	}

	/**
	 * @param 申请产品
	 *            要设置的 applyProduct
	 */
	public void setApplyProduct(String applyProduct) {
		this.applyProduct = applyProduct;
	}

	/**
	 * @return 申请额度
	 */
	public String getApplyMoney() {
		return applyMoney;
	}

	/**
	 * @param 申请额度
	 *            要设置的 applyMoney
	 */
	public void setApplyMoney(String applyMoney) {
		this.applyMoney = applyMoney;
	}

	/**
	 * @return 申请时间
	 */
	public String getApplyTime() {
		return applyTime;
	}

	/**
	 * @param 申请时间
	 *            要设置的 applyTime
	 */
	public void setApplyTime(String applyTime) {
		this.applyTime = applyTime;
	}

	/**
	 * @return 贷款原因(信用卡可不提供)
	 */
	public String getLoanReason() {
		return loanReason;
	}

	/**
	 * @param 贷款原因(信用卡可不提供)
	 *            要设置的 loanReason
	 */
	public void setLoanReason(String loanReason) {
		this.loanReason = loanReason;
	}

	/**
	 * @return 还款期数(信用卡可不提供)
	 */
	public int getRefundPeriods() {
		return refundPeriods;
	}

	/**
	 * @param 还款期数(信用卡可不提供)
	 *            要设置的 refundPeriods
	 */
	public void setRefundPeriods(int refundPeriods) {
		this.refundPeriods = refundPeriods;
	}

	/**
	 * @return 联系人姓名
	 */
	public String getLinkmanName() {
		return linkmanName;
	}

	/**
	 * @param 联系人姓名
	 *            要设置的 linkmanName
	 */
	public void setLinkmanName(String linkmanName) {
		this.linkmanName = linkmanName;
	}

	/**
	 * @return 联系人手机号
	 */
	public String getLinkmanCell() {
		return linkmanCell;
	}

	/**
	 * @param 联系人手机号
	 *            要设置的 linkmanCell
	 */
	public void setLinkmanCell(String linkmanCell) {
		this.linkmanCell = linkmanCell;
	}

	/**
	 * @return 联系人关系
	 */
	public String getLinkmanRela() {
		return linkmanRela;
	}

	/**
	 * @param 联系人关系
	 *            要设置的 linkmanRela
	 */
	public void setLinkmanRela(String linkmanRela) {
		this.linkmanRela = linkmanRela;
	}

	/**
	 * @return 客户APP登录次数
	 */
	public int getAppVisitNum() {
		return appVisitNum;
	}

	/**
	 * @param 客户APP登录次数
	 *            要设置的 appVisitNum
	 */
	public void setAppVisitNum(int appVisitNum) {
		this.appVisitNum = appVisitNum;
	}

	/**
	 * @return 学历、学籍证明附件数量
	 */
	public int getEduAttNum() {
		return eduAttNum;
	}

	/**
	 * @param 学历、学籍证明附件数量
	 *            要设置的 eduAttNum
	 */
	public void setEduAttNum(int eduAttNum) {
		this.eduAttNum = eduAttNum;
	}

	/**
	 * @return 银行卡流水附件数量
	 */
	public int getBankRunningAttNum() {
		return bankRunningAttNum;
	}

	/**
	 * @param 银行卡流水附件数量
	 *            要设置的 bankRunningAttNum
	 */
	public void setBankRunningAttNum(int bankRunningAttNum) {
		this.bankRunningAttNum = bankRunningAttNum;
	}

	/**
	 * @return 此次请求产品代号
	 */
	public String getMeal() {
		return meal;
	}

	/**
	 * @param 此次请求产品代号
	 *            要设置的 meal
	 */
	public void setMeal(String meal) {
		this.meal = meal;
	}

	/**
	 * @return 设备标识字段类型，采用设备反欺诈模块必填字段GID、IDFA、IMEI
	 */
	public String getDeviceType2() {
		return deviceType2;
	}

	/**
	 * @param 设备标识字段类型，采用设备反欺诈模块必填字段GID、IDFA、IMEI
	 *            要设置的 deviceType2
	 */
	public void setDeviceType2(String deviceType2) {
		this.deviceType2 = deviceType2;
	}

	/**
	 * @return 设备标示，泛指全平台所有设备标识，采用设备反欺诈模块必填字段
	 */
	public String getDeviceId2() {
		return deviceId2;
	}

	/**
	 * @param 设备标示，泛指全平台所有设备标识，采用设备反欺诈模块必填字段
	 *            要设置的 deviceId2
	 */
	public void setDeviceId2(String deviceId2) {
		this.deviceId2 = deviceId2;
	}

	/**
	 * @return 设备标识字段类型，采用设备反欺诈模块必填字段GID、IDFA、IMEI
	 */
	public String getDeviceType3() {
		return deviceType3;
	}

	/**
	 * @param 设备标识字段类型，采用设备反欺诈模块必填字段GID、IDFA、IMEI
	 *            要设置的 deviceType3
	 */
	public void setDeviceType3(String deviceType3) {
		this.deviceType3 = deviceType3;
	}

	/**
	 * @return 设备标示，泛指全平台所有设备标识，采用设备反欺诈模块必填字段
	 */
	public String getDeviceId3() {
		return deviceId3;
	}

	/**
	 * @param 设备标示，泛指全平台所有设备标识，采用设备反欺诈模块必填字段
	 *            要设置的 deviceId3
	 */
	public void setDeviceId3(String deviceId3) {
		this.deviceId3 = deviceId3;
	}

	/**
	 * @return 申请渠道
	 */
	public Apply_source getApplySource() {
		return applySource;
	}

	/**
	 * @param 申请渠道
	 *            要设置的 applySource
	 */
	public void setApplySource(Apply_source applySource) {
		this.applySource = applySource;
	}

	/**
	 * @return 车牌号
	 */
	public String getCarnum() {
		return carnum;
	}

	/**
	 * @param 车牌号
	 *            要设置的 carnum
	 */
	public void setCarnum(String carnum) {
		this.carnum = carnum;
	}

	/**
	 * @return 车架号
	 */
	public String getVinnum() {
		return vinnum;
	}

	/**
	 * @param 车架号
	 *            要设置的 vinnum
	 */
	public void setVinnum(String vinnum) {
		this.vinnum = vinnum;
	}

	/**
	 * @return 发动机号
	 */
	public String getEnginenum() {
		return enginenum;
	}

	/**
	 * @param 发动机号
	 *            要设置的 enginenum
	 */
	public void setEnginenum(String enginenum) {
		this.enginenum = enginenum;
	}

	/**
	 * @return
	 */
	public String getKeyNo() {
		return keyNo;
	}

	/**
	 * @param 要设置的
	 *            keyNo
	 */
	public void setKeyNo(String keyNo) {
		this.keyNo = keyNo;
	}

	/**
	 * @return
	 */
	public String getDownstreamCount() {
		return downstreamCount;
	}

	/**
	 * @param 要设置的
	 *            downstreamCount
	 */
	public void setDownstreamCount(String downstreamCount) {
		this.downstreamCount = downstreamCount;
	}

	/**
	 * @return
	 */
	public String getUpstreamCount() {
		return upstreamCount;
	}

	/**
	 * @param 要设置的
	 *            upstreamCount
	 */
	public void setUpstreamCount(String upstreamCount) {
		this.upstreamCount = upstreamCount;
	}

	/**
	 * @return
	 */
	public String getSearchKey() {
		return searchKey;
	}

	/**
	 * @param 要设置的
	 *            searchKey
	 */
	public void setSearchKey(String searchKey) {
		this.searchKey = searchKey;
	}

	/**
	 * @return 公司机构代码
	 */
	public String getBizOrgcode() {
		return bizOrgcode;
	}

	/**
	 * @param 公司机构代码
	 *            要设置的 bizOrgcode
	 */
	public void setBizOrgcode(String bizOrgcode) {
		this.bizOrgcode = bizOrgcode;
	}

	/**
	 * @return
	 */
	public String getBizTaxnum() {
		return bizTaxnum;
	}

	/**
	 * @param 要设置的
	 *            bizTaxnum
	 */
	public void setBizTaxnum(String bizTaxnum) {
		this.bizTaxnum = bizTaxnum;
	}

	/**
	 * @return
	 */
	public String getBizRegnum() {
		return bizRegnum;
	}

	/**
	 * @param 要设置的
	 *            bizRegnum
	 */
	public void setBizRegnum(String bizRegnum) {
		this.bizRegnum = bizRegnum;
	}

	/**
	 * @return 图片字符串ImgUtil.GetImageStr("D:\jyh\zz.jpg")
	 */
	public String getIdPhoto() {
		return idPhoto;
	}

	/**
	 * @param 图片字符串ImgUtil.GetImageStr("D:\jyh\zz.jpg")
	 *            要设置的 idPhoto
	 */
	public void setIdPhoto(String idPhoto) {
		this.idPhoto = idPhoto;
	}

	/**
	 * @return 图片字符串ImgUtil.GetImageStr("D:\jyh\zz.jpg")
	 */
	public String getDailyPhoto() {
		return dailyPhoto;
	}

	/**
	 * @param 图片字符串ImgUtil.GetImageStr("D:\jyh\zz.jpg")
	 *            要设置的 dailyPhoto
	 */
	public void setDailyPhoto(String dailyPhoto) {
		this.dailyPhoto = dailyPhoto;
	}

	/**
	 * @return
	 */
	public String getIndex() {
		return index;
	}

	/**
	 * @param 要设置的
	 *            index
	 */
	public void setIndex(String index) {
		this.index = index;
	}

}
