package com.pujjr.pcci.dal.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author wen
 * @date 创建时间：2016年10月17日 下午3:00:48 百融单独调用查询请求数据记录表
 *
 */
@Entity
public class HundredCreditDasRequest implements Serializable {

	private static final long serialVersionUID = 1L;

	public static final String API_TYPE = "das";

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
	 * 银行卡号
	 */
	@Column
	private String bankId;

	/**
	 * 公司名称
	 */
	@Column
	private String bizWorkfor;

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
	 * 要查询的产品
	 */
	@Column
	private String meal;

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

	public String getApiType() {
		return apiType;
	}

	public void setApiType(String apiType) {
		this.apiType = apiType;
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

	public String getCarnum() {
		return carnum;
	}

	public void setCarnum(String carnum) {
		this.carnum = carnum;
	}

	public String getVinnum() {
		return vinnum;
	}

	public void setVinnum(String vinnum) {
		this.vinnum = vinnum;
	}

	public String getEnginenum() {
		return enginenum;
	}

	public void setEnginenum(String enginenum) {
		this.enginenum = enginenum;
	}

	public String getKeyNo() {
		return keyNo;
	}

	public void setKeyNo(String keyNo) {
		this.keyNo = keyNo;
	}

	public String getDownstreamCount() {
		return downstreamCount;
	}

	public void setDownstreamCount(String downstreamCount) {
		this.downstreamCount = downstreamCount;
	}

	public String getUpstreamCount() {
		return upstreamCount;
	}

	public void setUpstreamCount(String upstreamCount) {
		this.upstreamCount = upstreamCount;
	}

	public String getSearchKey() {
		return searchKey;
	}

	public void setSearchKey(String searchKey) {
		this.searchKey = searchKey;
	}

	public String getBankId() {
		return bankId;
	}

	public void setBankId(String bankId) {
		this.bankId = bankId;
	}

	public String getBizWorkfor() {
		return bizWorkfor;
	}

	public void setBizWorkfor(String bizWorkfor) {
		this.bizWorkfor = bizWorkfor;
	}

	public String getBizOrgcode() {
		return bizOrgcode;
	}

	public void setBizOrgcode(String bizOrgcode) {
		this.bizOrgcode = bizOrgcode;
	}

	public String getBizTaxnum() {
		return bizTaxnum;
	}

	public void setBizTaxnum(String bizTaxnum) {
		this.bizTaxnum = bizTaxnum;
	}

	public String getBizRegnum() {
		return bizRegnum;
	}

	public void setBizRegnum(String bizRegnum) {
		this.bizRegnum = bizRegnum;
	}

	public String getIdPhoto() {
		return idPhoto;
	}

	public void setIdPhoto(String idPhoto) {
		this.idPhoto = idPhoto;
	}

	public String getDailyPhoto() {
		return dailyPhoto;
	}

	public void setDailyPhoto(String dailyPhoto) {
		this.dailyPhoto = dailyPhoto;
	}

	public String getIndex() {
		return index;
	}

	public void setIndex(String index) {
		this.index = index;
	}

	public String getMeal() {
		return meal;
	}

	public void setMeal(String meal) {
		this.meal = meal;
	}

}
