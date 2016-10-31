package org.pcci.api.bean.request;

import java.util.Date;

import com.pujjr.common.type.IdentityType;
import com.pujjr.common.type.credit.QueryReasonType;

/**
 * @author wen
 * @date 创建时间：2016年10月10日 上午10:43:35 征信查询请求
 */
public class CreditRequestData {

	/**
	 * 唯一流水号ID
	 */
	private String creditId;

	/**
	 * 查询请求用户/员工编号
	 */
	private String requestUserId;

	/**
	 * 查询请求时间
	 */
	private Date requestDate;

	/**
	 * 百融登陆唯一标识
	 */
	private String tokenid;

	/**
	 * 姓名
	 */
	private String name;

	/**
	 * 手机号
	 */
	private String mobileNo;

	/**
	 * 证件号
	 */
	private String idNo;

	/**
	 * 证件类型 {@link IdentityType}
	 */
	private String idType;

	/**
	 * 查询原因 {@link QueryReasonType}
	 */
	private String reasonCode;

	/**
	 * 信息主体授权码 若不涉及授权则填唯一的随机序列
	 */
	private String entityAuthCode;
	/**
	 * 信息主体授权时间 yyyy-MM-dd
	 */
	private String entityAuthDate;

	/**
	 * @return ID
	 */
	public String getCreditId() {
		return creditId;
	}

	/**
	 * @param ID
	 *            要设置的 creditId
	 */
	public void setCreditId(String creditId) {
		this.creditId = creditId;
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
	 * @return 百融登陆唯一标识
	 */
	public String getTokenid() {
		return tokenid;
	}

	/**
	 * @param 百融登陆唯一标识
	 *            要设置的 tokenid
	 */
	public void setTokenid(String tokenid) {
		this.tokenid = tokenid;
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

}
