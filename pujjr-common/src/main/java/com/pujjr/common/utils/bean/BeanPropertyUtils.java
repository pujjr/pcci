package com.pujjr.common.utils.bean;

import java.beans.PropertyDescriptor;

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

}
