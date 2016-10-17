package com.pujjr.pcci.common.qhcs.bean;

import java.util.List;

/**
 * @author wen
 * @date 创建时间：2016年10月10日 上午10:35:24 批次数据
 */
public class BusiData {
	/**
	 * 批次号 由数字+字母组成
	 */
	private String batchNo;
	/**
	 * 记录列表
	 */
	private List<Record> records;

	public String getBatchNo() {
		return batchNo;
	}

	public void setBatchNo(String batchNo) {
		this.batchNo = batchNo;
	}

	public List<Record> getRecords() {
		return records;
	}

	public void setRecords(List<Record> records) {
		this.records = records;
	}

}
