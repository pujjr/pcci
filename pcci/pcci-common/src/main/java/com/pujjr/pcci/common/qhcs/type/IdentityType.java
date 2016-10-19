package com.pujjr.pcci.common.qhcs.type;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wen
 * @date 创建时间：2016年10月10日 上午11:26:30
 *
 */
public enum IdentityType {

	/** 个人身份证 */
	ID_CARD("0", "个人身份证"),
	/** 户口簿 */
	RESIDENCE_BOOKLET("1", "户口簿"),
	/** 护照 */
	PASSPORT("2", "护照"),
	/** 军官证 */
	MILITARY_ID("3", "军官证"),
	/** 士兵证 */
	SOLDIERR_ID("4", "士兵证"),
	/** 港澳居民来往内地通行证 */
	HONGKONG_ID("5", "港澳居民来往内地通行证"),
	/** 台湾同胞来往内地通行证 */
	TAIWAN_ID("6", "台湾同胞来往内地通行证"),
	/** 临时身份证 */
	TEMPORARY_ID("7", "临时身份证"),
	/** 外国人居留证 */
	ALIENS_ID("8", "外国人居留证"),
	/** 警官证 */
	POLICE_ID("9", "警官证"),
	/** 其他证件 */
	OTHER_ID("x", "其他证件");

	private String code;
	private String remark;
	private static Map<String, IdentityType> codeMappingCache = new HashMap<String, IdentityType>();
	static {
		for (IdentityType type : IdentityType.values()) {
			codeMappingCache.put(type.getCode(), type);
		}
	}

	private IdentityType(String code, String remark) {
		this.code = code;
		this.remark = remark;
	}

	public String getCode() {
		return this.code;
	}

	public String getRemark() {
		return this.remark;
	}

	public static boolean contains(String code) {
		return codeMappingCache.get(code) != null;
	}

	public static IdentityType fromCode(String code) {
		return codeMappingCache.get(code);
	}

}
