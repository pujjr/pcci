package com.pujjr.common.store;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;

import com.aliyun.oss.OSSClient;
import com.aliyun.oss.model.OSSObject;
import com.pujjr.common.utils.BaseFileUtils;

/**
 * @author wen
 * @date 创建时间：2016年11月4日 上午10:07:22
 *
 */
public class AliyunStore {

	private AliyunStoreSetting storeSetting;

	public AliyunStore() {
	}

	public AliyunStore(AliyunStoreSetting setting) {
		this.storeSetting = setting;
	}

	public static void main(String[] args) {
		AliyunStoreSetting setting = new AliyunStoreSetting();
		String endpoint = "oss-cn-hzfinance.aliyuncs.com";
		String accessKeyId = "A9aOBT2jgwLlIkPc";
		String accessKeySecret = "AsO82796GQoeayzQxurziFwckw7JL9";
		String bucketName = "pcms-test";
		setting.setEndpoint(endpoint);
		setting.setAccessKeyId(accessKeyId);
		setting.setAccessKeySecret(accessKeySecret);
		setting.setBucketName(bucketName);
		AliyunStore aliyunStore = new AliyunStore(setting);
		try {
			aliyunStore.upload("test-1", new FileInputStream("D://temp/test.txt"));
			InputStream downStream = aliyunStore.download("test-1");
			aliyunStore.delete("test-1");
			BaseFileUtils.inputToOutput(downStream, new FileOutputStream("D://temp/test2.txt"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void upload(String ossKey, InputStream inputStream) throws Exception {
		String bucketName = storeSetting.getBucketName();
		upload(bucketName, ossKey, inputStream);
	}

	/**
	 * 上传文件到存储 服务
	 * 
	 * @param bucketName
	 *            分组
	 * @param ossKey
	 * @param inputStream
	 */
	public void upload(String bucketName, String ossKey, InputStream inputStream) throws Exception {
		OSSClient ossClient = new OSSClient(storeSetting.getEndpoint(), storeSetting.getAccessKeyId(), storeSetting.getAccessKeySecret());
		try {
			// 如果Bucket不存在就创建新的Bucket。详细请参看“SDK手册 > Java-SDK > 管理Bucket”。
			// 链接地址是：https://help.aliyun.com/document_detail/oss/sdk/java-sdk/manage_bucket.html?spm=5176.docoss/sdk/java-sdk/init
			if (!ossClient.doesBucketExist(bucketName)) {
				ossClient.createBucket(bucketName);
			}
			ossClient.putObject(bucketName, ossKey, inputStream);
		} finally {
			ossClient.shutdown();
		}
	}

	/**
	 * 删除存储服务上的文件
	 * 
	 * @param ossKey
	 */
	public void delete(String ossKey) throws Exception {
		OSSClient ossClient = new OSSClient(storeSetting.getEndpoint(), storeSetting.getAccessKeyId(), storeSetting.getAccessKeySecret());
		try {
			ossClient.deleteObject(storeSetting.getBucketName(), ossKey);
		} finally {
			ossClient.shutdown();
		}
	}

	/**
	 * 下载存储服务上的文件
	 * 
	 * @param ossKey
	 * @return
	 */
	public InputStream download(String ossKey) throws Exception {
		OSSClient ossClient = new OSSClient(storeSetting.getEndpoint(), storeSetting.getAccessKeyId(), storeSetting.getAccessKeySecret());
		OSSObject ossObject = ossClient.getObject(storeSetting.getBucketName(), ossKey);
		return ossObject.getObjectContent();
	}

	/**
	 * @return storeSetting
	 */
	public AliyunStoreSetting getStoreSetting() {
		return storeSetting;
	}

	/**
	 * @param storeSetting
	 *            要设置的 storeSetting
	 */
	public void setStoreSetting(AliyunStoreSetting storeSetting) {
		this.storeSetting = storeSetting;
	}

}
