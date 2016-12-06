package com.pujjr.common.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

/**
 * @author wen
 * @date 创建时间：2016年10月19日 上午9:25:41
 *
 */
public class BaseUtils {
	public static void main(String[] args) {
		Set<String> set = new HashSet<>();
		for (int i = 1; i <= 100000000; i++) {
			if (i % 100000 == 0) {
				System.out.println("到第" + (i / 100000) + "十万条");
			}
			set.add(get16UUID());
			if (set.size() != i) {
				System.out.println("重复啦:" + i);
			}
		}
	}

	public static String get32UUID() {
		return UUID.randomUUID().toString().toLowerCase().replaceAll("-", "");
	}

	public static String get16UUID() {
		String uuid = UUID.randomUUID().toString();
		byte[] outputByteArray;
		StringBuffer buf = new StringBuffer("");
		try {
			MessageDigest messageDigest = MessageDigest.getInstance("MD5");
			byte[] inputByteArray = uuid.getBytes();
			messageDigest.update(inputByteArray);
			outputByteArray = messageDigest.digest();
			for (int offset = 0; offset < outputByteArray.length; offset++) {
				int i = outputByteArray[offset];
				if (i < 0)
					i += 256;
				if (i < 16)
					buf.append("0");
				buf.append(Integer.toHexString(i));
			}
			return buf.toString().substring(8, 24);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return get32UUID().substring(0, 16);
	}

}
