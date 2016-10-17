package com.pujjr.pcci.common.qhcs.bean;

/**
 * @author wen
 * @date 创建时间：2016年10月10日 上午11:17:45
 *
 */
public class QianHaiRequest {
	/**
	 * 请求标头
	 */
	private HeaderBean header;
	/**
	 * 批次数据
	 */
	private BusiData busiData;
	/**
	 * 安全信息
	 */
	private SecurityInfo securityInfo;

	public HeaderBean getHeader() {
		return header;
	}

	public void setHeader(HeaderBean header) {
		this.header = header;
	}

	public BusiData getBusiData() {
		return busiData;
	}

	public void setBusiData(BusiData busiData) {
		this.busiData = busiData;
	}

	public SecurityInfo getSecurityInfo() {
		return securityInfo;
	}

	public void setSecurityInfo(SecurityInfo securityInfo) {
		this.securityInfo = securityInfo;
	}

}
