package com.pujjr.common.utils;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.ListUtils;

/**
 * @author wen
 * @date 创建时间：2016年11月7日 下午2:37:45
 *
 */
public class BaseIterableUtils {

	/**
	 * 检查list集合是否为空
	 * 
	 * @param list
	 * @return
	 */
	public static <T> boolean isEmpty(List<T> list) {
		return (list == null || list.isEmpty());
	}

	/**
	 * 检查list集合是否不为空
	 * 
	 * @param list
	 * @return
	 */
	public static <T> boolean isNotEmpty(List<T> list) {
		return (list != null && !list.isEmpty());
	}

	@SafeVarargs
	@SuppressWarnings("unchecked")
	public static <T> List<T> union(List<T> list1, List<T> list2, List<T>... listArray) {
		List<T> returnList = new ArrayList<T>();
		try {
			list1 = isEmpty(list1) ? new ArrayList<T>() : list1;
			list2 = isEmpty(list2) ? new ArrayList<T>() : list2;

			returnList = ListUtils.union(list1, list2);
			for (List<T> list : listArray) {
				list = isEmpty(list) ? new ArrayList<T>() : list;
				returnList = ListUtils.union(returnList, list);
			}
		} catch (ClassCastException e) {
			e.printStackTrace();
		}
		return returnList;
	}

}
