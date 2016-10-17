package com.pujjr.pcci.common.qhcs.bean;

/**
 * @author wen
 * @date 创建时间：2016年10月10日 上午10:35:08 请求标头
 */
public class HeaderBean {

	/**
	 * 机构代码
	 */
	private String orgCode;

	/**
	 * 渠道、系统ID
	 */
	private String chnlId;

	/**
	 * 交易流水号 下游系统交易标识号，该流水号只能使用一次
	 */
	private String transNo;

	/**
	 * 交易时间 yyyy-MM-dd HH:mm:ss
	 */
	private String transDate;

	/**
	 * 授权代码 机构授权码
	 */
	private String authCode;

	/**
	 * 授权时间 yyyy-MM-dd
	 */
	private String authDate;

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

	public String getTransNo() {
		return transNo;
	}

	public void setTransNo(String transNo) {
		this.transNo = transNo;
	}

	public String getTransDate() {
		return transDate;
	}

	public void setTransDate(String transDate) {
		this.transDate = transDate;
	}

	public String getAuthCode() {
		return authCode;
	}

	public void setAuthCode(String authCode) {
		this.authCode = authCode;
	}

	public String getAuthDate() {
		return authDate;
	}

	public void setAuthDate(String authDate) {
		this.authDate = authDate;
	}

}
