package com.pujjr.pcci.service.qhcs;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * @author wen
 * @date 创建时间：2016年10月10日 上午10:22:46
 *
 */
@Configuration
public class QianHaiSetting {

	/** 网络类型 */
	@Value("#{settings['qianhai.setting.netType']}")
	private String netType;

	/** API版本 */
	@Value("#{settings['qianhai.setting.apiVer']}")
	private String apiVer;

	/** 机构代码 */
	@Value("#{settings['qianhai.setting.orgCode']}")
	private String orgCode;

	/** 接入系统ID */
	@Value("#{settings['qianhai.setting.chnlId']}")
	private String chnlId;

	/** 授权码 */
	@Value("#{settings['qianhai.setting.authCode']}")
	private String authCode;

	/** 用户名 */
	@Value("#{settings['qianhai.setting.userName']}")
	private String userName;

	/** 用户密码 */
	@Value("#{settings['qianhai.setting.userPassword']}")
	private String userPassword;

	/** 效验码 */
	@Value("#{settings['qianhai.setting.checkCode']}")
	private String checkCode;

	/** 服务器地址 */
	@Value("#{settings['qianhai.setting.serviceURL']}")
	private String serviceURL;

	/** 私钥地址 */
	@Value("#{settings['qianhai.privateKey.path']}")
	private String privateKeyPath;

	/** 公钥地址 */
	@Value("#{settings['qianhai.publicKey.path']}")
	private String publicKeyPath;

	/** 私钥别名 */
	@Value("#{settings['qianhai.privateKey.storeAlias']}")
	private String storeAlias;

	/** 密钥密码 */
	@Value("#{settings['qianhai.privateKey.storePassword']}")
	private String storePassword;

	/**
	 * 交易名称
	 */
	private String transName;
	/**
	 * 产品ID
	 */
	private String productId;

	/**
	 * 报文代码 报送：MSC9004 查询：MSC8036
	 */
	private String messageCode;

	/**
	 * @return 网络类型
	 */
	public String getNetType() {
		return netType;
	}

	/**
	 * @param 网络类型
	 *            要设置的 netType
	 */
	public void setNetType(String netType) {
		this.netType = netType;
	}

	/**
	 * @return API版本
	 */
	public String getApiVer() {
		return apiVer;
	}

	/**
	 * @param API版本
	 *            要设置的 apiVer
	 */
	public void setApiVer(String apiVer) {
		this.apiVer = apiVer;
	}

	/**
	 * @return 机构代码
	 */
	public String getOrgCode() {
		return orgCode;
	}

	/**
	 * @param 机构代码
	 *            要设置的 orgCode
	 */
	public void setOrgCode(String orgCode) {
		this.orgCode = orgCode;
	}

	/**
	 * @return 接入系统ID
	 */
	public String getChnlId() {
		return chnlId;
	}

	/**
	 * @param 接入系统ID
	 *            要设置的 chnlId
	 */
	public void setChnlId(String chnlId) {
		this.chnlId = chnlId;
	}

	/**
	 * @return 授权码
	 */
	public String getAuthCode() {
		return authCode;
	}

	/**
	 * @param 授权码
	 *            要设置的 authCode
	 */
	public void setAuthCode(String authCode) {
		this.authCode = authCode;
	}

	/**
	 * @return 用户名
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @param 用户名
	 *            要设置的 userName
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * @return 用户密码
	 */
	public String getUserPassword() {
		return userPassword;
	}

	/**
	 * @param 用户密码
	 *            要设置的 userPassword
	 */
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	/**
	 * @return 效验码
	 */
	public String getCheckCode() {
		return checkCode;
	}

	/**
	 * @param 效验码
	 *            要设置的 checkCode
	 */
	public void setCheckCode(String checkCode) {
		this.checkCode = checkCode;
	}

	/**
	 * @return 服务器地址
	 */
	public String getServiceURL() {
		return serviceURL;
	}

	/**
	 * @param 服务器地址
	 *            要设置的 serviceURL
	 */
	public void setServiceURL(String serviceURL) {
		this.serviceURL = serviceURL;
	}

	/**
	 * @return 交易名称
	 */
	public String getTransName() {
		return transName;
	}

	/**
	 * @param 交易名称
	 *            要设置的 transName
	 */
	public void setTransName(String transName) {
		this.transName = transName;
	}

	/**
	 * @return 产品ID
	 */
	public String getProductId() {
		return productId;
	}

	/**
	 * @param 产品ID
	 *            要设置的 productId
	 */
	public void setProductId(String productId) {
		this.productId = productId;
	}

	/**
	 * @return 报文代码报送：MSC9004查询：MSC8036
	 */
	public String getMessageCode() {
		return messageCode;
	}

	/**
	 * @param 报文代码报送：MSC9004查询：MSC8036
	 *            要设置的 messageCode
	 */
	public void setMessageCode(String messageCode) {
		this.messageCode = messageCode;
	}

	/**
	 * @return 私钥地址
	 */
	public String getPrivateKeyPath() {
		return privateKeyPath;
	}

	/**
	 * @param 私钥地址
	 *            要设置的 privateKeyPath
	 */
	public void setPrivateKeyPath(String privateKeyPath) {
		this.privateKeyPath = privateKeyPath;
	}

	/**
	 * @return 公钥地址
	 */
	public String getPublicKeyPath() {
		return publicKeyPath;
	}

	/**
	 * @param 公钥地址
	 *            要设置的 publicKeyPath
	 */
	public void setPublicKeyPath(String publicKeyPath) {
		this.publicKeyPath = publicKeyPath;
	}

	/**
	 * @return 私钥别名
	 */
	public String getStoreAlias() {
		return storeAlias;
	}

	/**
	 * @param 私钥别名
	 *            要设置的 storeAlias
	 */
	public void setStoreAlias(String storeAlias) {
		this.storeAlias = storeAlias;
	}

	/**
	 * @return 密钥密码
	 */
	public String getStorePassword() {
		return storePassword;
	}

	/**
	 * @param 密钥密码
	 *            要设置的 storePassword
	 */
	public void setStorePassword(String storePassword) {
		this.storePassword = storePassword;
	}

}
