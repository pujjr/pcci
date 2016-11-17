package com.pujjr.pcci.common.qhcs.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;

/**
 * @author wen
 * @date 创建时间：2016年11月17日 下午3:29:25
 *
 */
public class FilePathTest {
	public static String outPath() throws Exception {
		InputStream fileIn = FilePathTest.class.getClassLoader().getResourceAsStream("/credoo_ssl.crt");
		FileOutputStream fileOut = new FileOutputStream("d:/temp/credoo_ssl.crt");
		byte[] data = new byte[1024];
		int count = -1;
		while ((count = fileIn.read(data, 0, 1024)) != -1) {
			fileOut.write(data, 0, count);
		}

		File file = new File(FilePathTest.class.getClassLoader().getResource("/credoo_ssl.crt").toURI());
		System.out.println(FilePathTest.class.getResource("/credoo_ssl.crt").getFile());
		System.out.println(FilePathTest.class.getResource("/credoo_ssl.crt").getPath());
		System.out.println(FilePathTest.class.getClassLoader().getResourceAsStream("credoo_ssl.crt"));
		String path = file.getAbsolutePath();
		return path;
	}
}
