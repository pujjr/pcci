package com.pujjr.common.utils.bean;

import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.beanutils.PropertyUtils;

/**
 * @author wen
 * @date 创建时间：2016年11月7日 下午3:53:45
 *
 */
public class BeanPropertyUtils {
	public final static String STRING = "java.lang.String";
	public final static String INTEGER = "java.lang.Integer";
	public final static String LONG = "java.lang.Long";

	public final static String DEFAULT_STRING_VALUE = "";
	public final static Integer DEFAULT_INTEGER_VALUE = 0;
	public final static Long DEFAULT_LONG_VALUE = 0l;

	/**
	 * 填入默认值
	 * 
	 * @param bean
	 * @param propertyType
	 * @param defaultValue
	 */
	public static void setDefaultValue(Object bean, String propertyType, String defaultValue) {
		PropertyDescriptor[] PropertyDescriptorArray = PropertyUtils.getPropertyDescriptors(bean);
		for (PropertyDescriptor propertyDescriptor : PropertyDescriptorArray) {
			if (propertyType.equals(propertyDescriptor.getPropertyType().getName())) {
				try {
					PropertyUtils.setProperty(bean, propertyDescriptor.getName(), defaultValue);
				} catch (Exception e) {
					continue;
				}
			}
		}
	}

	/**
	 * 自动为常见类型填入默认值
	 * 
	 * @param bean
	 */
	public static void autoSetDefaultValue(Object bean) {
		PropertyDescriptor[] PropertyDescriptorArray = PropertyUtils.getPropertyDescriptors(bean);
		for (PropertyDescriptor propertyDescriptor : PropertyDescriptorArray) {
			try {
				if (PropertyUtils.getProperty(bean, propertyDescriptor.getName()) == null) {
					if (STRING.equals(propertyDescriptor.getPropertyType().getName())) {
						PropertyUtils.setProperty(bean, propertyDescriptor.getName(), DEFAULT_STRING_VALUE);
					}
					if (INTEGER.equals(propertyDescriptor.getPropertyType().getName())) {
						PropertyUtils.setProperty(bean, propertyDescriptor.getName(), DEFAULT_INTEGER_VALUE);
					}
					if (LONG.equals(propertyDescriptor.getPropertyType().getName())) {
						PropertyUtils.setProperty(bean, propertyDescriptor.getName(), DEFAULT_LONG_VALUE);
					}
				}
			} catch (Exception e) {
				continue;
			}
		}
	}

	/**
	 * bean 转化为 HashMap
	 * 
	 * @param obj
	 * @return
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 * @throws InvocationTargetException
	 */
	public static Map<String, Object> beanToMap(Object obj) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Map<String, Object> map = new HashMap<String, Object>();
		PropertyDescriptor[] propertyDescriptors = PropertyUtils.getPropertyDescriptors(obj);
		for (PropertyDescriptor property : propertyDescriptors) {
			String key = property.getName();
			// 过滤class属性
			if (!key.equals("class")) {
				// 得到property对应的getter方法
				Method getter = property.getReadMethod();
				Object value = getter.invoke(obj);
				map.put(key, value);
			}
		}
		return map;
	}

}
