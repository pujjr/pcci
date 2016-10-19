package com.pujjr.pcci.dal.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author wen
 * @date 创建时间：2016年10月17日 下午3:00:48 百融打包调用查询请求数据记录表
 *
 */
@Entity
public class QianHaiLoanee implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * ID
	 */
	@Id
	@Column(length = 64, nullable = true)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long recordId;

	/**
	 * 交易唯一标识
	 */
	@Column(nullable = false)
	private Long transNo;

	/**
	 * 交易批次号
	 */
	@Column(nullable = false)
	private Long batchNo;

	/**
	 * 证件号
	 */
	@Column(nullable = false)
	private String idNo;

	/**
	 * 证件类型
	 */
	@Column(nullable = false)
	private String idType;

	/**
	 * 主体名称
	 */
	@Column(nullable = false)
	private String name;

	/**
	 * 序列号
	 */
	@Column(nullable = false)
	private String seqNo;

	/**
	 * 查询原因
	 */
	@Column
	private String reasonCode;

	/**
	 * 机构所属行业
	 */
	@Column
	private String industry;

	/**
	 * 命中机构数目
	 */
	@Column
	private String amount;

	/**
	 * 业务发生时间
	 */
	@Column
	private String busiDate;

	/**
	 * 错误代码
	 */
	@Column(nullable = false)
	private String erCode;

	/**
	 * 错误信息
	 */
	@Column(nullable = false)
	private String erMsg;

}
