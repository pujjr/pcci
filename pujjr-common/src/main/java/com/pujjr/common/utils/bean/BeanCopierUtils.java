package com.pujjr.common.utils.bean;

import java.util.HashMap;
import java.util.Map;

import net.sf.cglib.beans.BeanCopier;

/**
 * bean复制工具 同样的bean重复使用
 */
public class BeanCopierUtils {

	private static Map<String, BeanCopier> beanCopierMap = new HashMap<String, BeanCopier>();

	public static void copy(Object source, Object target) {
		String beanKey = generateKey(source.getClass(), target.getClass());
		BeanCopier copier = null;
		if (!beanCopierMap.containsKey(beanKey)) {
			copier = BeanCopier.create(source.getClass(), target.getClass(), false);
			beanCopierMap.put(beanKey, copier);
		} else {
			copier = beanCopierMap.get(beanKey);
		}
		copier.copy(source, target, null);
	}

	private static String generateKey(Class<?> class1, Class<?> class2) {
		return class1.toString() + " to " + class2.toString();
	}
}
