package com.pujjr.pcci.common.qhcs.bean;

/**
 * @author wen
 * @date 创建时间：2016年10月10日 上午10:35:24 安全信息
 */
public class SecurityInfo {
	/**
	 * 签名 外部系统专线\内网系统访问为空
	 */
	private String signatureValue;
	/**
	 * 虚拟用户名
	 */
	private String userName;
	/**
	 * 密码
	 */
	private String userPassword;

	public String getSignatureValue() {
		return signatureValue;
	}

	public void setSignatureValue(String signatureValue) {
		this.signatureValue = signatureValue;
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

}
