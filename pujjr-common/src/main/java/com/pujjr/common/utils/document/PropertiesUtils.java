package com.pujjr.common.utils.document;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author wen
 * @date 创建时间：2016年11月1日 下午2:05:49
 *
 */
public class PropertiesUtils {

	public static Properties loadProperties(String filePath) throws IOException {
		File file = new File(filePath);
		InputStream stream = new FileInputStream(file);
		return loadProperties(stream);
	}

	public static Properties loadProperties(InputStream stream) throws IOException {
		Properties pps = new Properties();
		pps.load(stream);
		return pps;
	}

}
