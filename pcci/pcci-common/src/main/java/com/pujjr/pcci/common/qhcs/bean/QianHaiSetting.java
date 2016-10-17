package com.pujjr.pcci.common.qhcs.bean;

/**
 * @author wen
 * @date 创建时间：2016年10月10日 上午10:22:46
 *
 */
public class QianHaiSetting {
	/**
	 * 网络类型
	 */
	private String netType;
	/**
	 * 交易名称
	 */
	private String transName;
	/**
	 * 产品ID
	 */
	private String productId;
	/**
	 * API版本
	 */
	private String apiVer;
	/**
	 * 报文代码 报送：MSC9004 查询：MSC8036
	 */
	private String messageCode;
	/**
	 * 机构代码
	 */
	private String orgCode;
	/**
	 * 接入系统ID
	 */
	private String chnlId;
	/**
	 * 授权码
	 */
	private String authCode;
	/**
	 * 用户名
	 */
	private String userName;
	/**
	 * 用户密码
	 */
	private String userPassword;
	/**
	 * 校验码
	 */
	private String checkCode;
	/**
	 * 服务器地址
	 */
	private String serviceURL;

	public String getNetType() {
		return netType;
	}

	public void setNetType(String netType) {
		this.netType = netType;
	}

	public String getTransName() {
		return transName;
	}

	public void setTransName(String transName) {
		this.transName = transName;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getApiVer() {
		return apiVer;
	}

	public void setApiVer(String apiVer) {
		this.apiVer = apiVer;
	}

	public String getMessageCode() {
		return messageCode;
	}

	public void setMessageCode(String messageCode) {
		this.messageCode = messageCode;
	}

	public String getOrgCode() {
		return orgCode;
	}

	public void setOrgCode(String orgCode) {
		this.orgCode = orgCode;
	}

	public String getChnlId() {
		return chnlId;
	}

	public void setChnlId(String chnlId) {
		this.chnlId = chnlId;
	}

	public String getAuthCode() {
		return authCode;
	}

	public void setAuthCode(String authCode) {
		this.authCode = authCode;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getCheckCode() {
		return checkCode;
	}

	public void setCheckCode(String checkCode) {
		this.checkCode = checkCode;
	}

	public String getServiceURL() {
		return serviceURL;
	}

	public void setServiceURL(String serviceURL) {
		this.serviceURL = serviceURL;
	}

}
