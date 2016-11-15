package com.pujjr.pcci.service.store;

import java.io.InputStream;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.pujjr.common.store.AliyunStore;
import com.pujjr.pcci.service.ParameterizedBaseService;

/**
 * @author wen
 * @date 创建时间：2016年10月19日 上午10:42:27
 *
 */
@Service
public class StoreService extends ParameterizedBaseService<StoreService> {

	@Resource(name = "aliyunService")
	AliyunStore aliyunService;

	/**
	 * 上传文件到存储 服务
	 * 
	 * @param bucketName
	 *            分组
	 * @param ossKey
	 * @param inputStream
	 */
	public void upload(String bucketName, String ossKey, InputStream inputStream) {
		try {
			aliyunService.upload(bucketName, ossKey, inputStream);
		} catch (Exception e) {
			logger.error("上传文件到阿里云服务出错", e);
		}
	}

	/**
	 * 上传文件到存储 服务
	 * 
	 * @param bucketName
	 *            分组
	 * @param ossKey
	 * @param inputStream
	 */
	public void upload(String ossKey, InputStream inputStream) {
		try {
			aliyunService.upload(ossKey, inputStream);
		} catch (Exception e) {
			logger.error("上传文件到阿里云服务出错", e);
		}
	}

	/**
	 * 删除存储服务上的文件
	 * 
	 * @param ossKey
	 */
	public void delete(String ossKey) {
		try {
			aliyunService.delete(ossKey);
		} catch (Exception e) {
			logger.error("阿里云服务存储的文件失败", e);
		}
	}

	/**
	 * 下载存储服务上的文件
	 * 
	 * @param ossKey
	 * @return
	 */
	public InputStream download(String ossKey) {
		try {
			return aliyunService.download(ossKey);
		} catch (Exception e) {
			logger.error("从阿里云服务下载存储的文件出错:", e);
		}
		return null;
	}

}
