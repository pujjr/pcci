package com.pujjr.common.type;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wen
 * @date 创建时间 2016年10月31日 16:28:27
 *
 */
public enum DrivingVehicleType {
	A1("大型客车"),
	A2("牵引车"),
	A3("城市公共汽车"),
	B("中型客车"),
	B1("中型客车"),
	B2("大型货车"),
	C("小型汽车"),
	C1("小型汽车"),
	C2("小型自动档汽"),
	C3("低载货汽"),
	C4("三轮汽车"),
	D("三轮摩托"),
	DG("三轮摩托"),
	E("二轮摩托"),
	EG("二轮摩托"),
	EZ("二轮摩托"),
	F("轻便摩托"),
	GC3("低载货汽"),
	GC4("三轮汽车"),
	M("轮式自行机械"),
	N("无轨电车"),
	P("有轨电车");

	private String remark;

	private static Map<String, DrivingVehicleType> codeMappingCache = new HashMap<String, DrivingVehicleType>();
	static {
		for (DrivingVehicleType type : DrivingVehicleType.values()) {
			codeMappingCache.put(type.name(), type);
		}
	}

	private DrivingVehicleType(String remark) {
		this.remark = remark;
	}

	public String getRemark() {
		return remark;
	}

	public static boolean contains(String name) {
		return codeMappingCache.get(name) != null;
	}

	public static DrivingVehicleType fromCode(String name) {
		return codeMappingCache.get(name);
	}

}
