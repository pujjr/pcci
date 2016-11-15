package com.pujjr.common.store;

/**
 * @author wen
 * @date 创建时间：2016年11月4日 下午1:41:03
 *
 */
public class AliyunStoreSetting {

	private String endpoint;

	private String accessKeyId;

	private String accessKeySecret;

	private String bucketName;

	/**
	 * @return endpoint
	 */
	public String getEndpoint() {
		return endpoint;
	}

	/**
	 * @param endpoint
	 *            要设置的 endpoint
	 */
	public void setEndpoint(String endpoint) {
		this.endpoint = endpoint;
	}

	/**
	 * @return accessKeyId
	 */
	public String getAccessKeyId() {
		return accessKeyId;
	}

	/**
	 * @param accessKeyId
	 *            要设置的 accessKeyId
	 */
	public void setAccessKeyId(String accessKeyId) {
		this.accessKeyId = accessKeyId;
	}

	/**
	 * @return accessKeySecret
	 */
	public String getAccessKeySecret() {
		return accessKeySecret;
	}

	/**
	 * @param accessKeySecret
	 *            要设置的 accessKeySecret
	 */
	public void setAccessKeySecret(String accessKeySecret) {
		this.accessKeySecret = accessKeySecret;
	}

	/**
	 * @return bucketName
	 */
	public String getBucketName() {
		return bucketName;
	}

	/**
	 * @param bucketName
	 *            要设置的 bucketName
	 */
	public void setBucketName(String bucketName) {
		this.bucketName = bucketName;
	}

}
