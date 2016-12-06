package com.pujjr.common.type;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wen
 * @date 创建时间 2016年10月31日 16:28:27
 *
 */
public enum DrivingLicenceStatusType {
	A("正常"),
	B("超分"),
	C("转出"),
	D("暂扣"),
	E("撤销"),
	F("吊销"),
	G("注销"),
	H("违法未处理"),
	I("事故未处理"),
	J("停止使用"),
	K("协查"),
	L("锁定"),
	M("逾期未换证"),
	N("延期换证"),
	P("延期体检"),
	R("逾期未体检"),
	S("逾期未审"),
	U("扣留"),
	Z("其他");

	private String remark;

	private static Map<String, DrivingLicenceStatusType> codeMappingCache = new HashMap<String, DrivingLicenceStatusType>();
	static {
		for (DrivingLicenceStatusType type : DrivingLicenceStatusType.values()) {
			codeMappingCache.put(type.name(), type);
		}
	}

	private DrivingLicenceStatusType(String remark) {
		this.remark = remark;
	}

	public String getRemark() {
		return remark;
	}

	public static boolean contains(String name) {
		return codeMappingCache.get(name) != null;
	}

	public static DrivingLicenceStatusType fromCode(String name) {
		return codeMappingCache.get(name);
	}

	public static void main(String[] args) {
		System.out.println(DrivingLicenceStatusType.contains(null));
		System.out.println(DrivingLicenceStatusType.fromCode("dd").getRemark());
	}

}
