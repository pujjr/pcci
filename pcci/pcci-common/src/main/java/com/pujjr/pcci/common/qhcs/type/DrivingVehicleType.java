package com.pujjr.pcci.common.qhcs.type;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wen
 * @date 创建时间：2016年10月10日 上午11:35:44
 *
 */
public enum DrivingVehicleType {
	A1("A1", "大型客车"),
	A2("A2", "牵引车"),
	A3("A3", "城市公共汽车"),
	B("B", "中型客车"),
	B1("B1", "中型客车"),
	B2("B2", "大型货车"),
	C("C", "小型汽车"),
	C1("C1", "小型汽车"),
	C2("C2", "小型自动档汽车"),
	C3("C3", "低速载货汽车"),
	C4("C4", "三轮汽车"),
	D("D", "三轮摩托车"),
	DG("DG", "三轮摩托车"),
	E("E", "二轮摩托车"),
	EG("EG", "二轮摩托车"),
	EZ("EZ", "二轮摩托车"),
	F("F", "轻便摩托车"),
	GC3("GC3", "低速载货汽车"),
	GC4("GC4", "三轮汽车"),
	M("M", "轮式自行机械车"),
	N("N", "无轨电车"),
	P("P", "有轨电车");

	private String code;
	private String name;
	private static Map<String, DrivingVehicleType> codeMappingCache = new HashMap<String, DrivingVehicleType>();
	static {
		for (DrivingVehicleType type : DrivingVehicleType.values()) {
			codeMappingCache.put(type.getCode(), type);
		}
	}

	private DrivingVehicleType(String code, String name) {
		this.code = code;
		this.name = name;
	}

	public String getCode() {
		return this.code;
	}

	public String getName() {
		return this.name;
	}

	public static boolean contains(String code) {
		return codeMappingCache.get(code) != null;
	}

	public static DrivingVehicleType fromCode(String code) {
		return codeMappingCache.get(code);
	}

}
