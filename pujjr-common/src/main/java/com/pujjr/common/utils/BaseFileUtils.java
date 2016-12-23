package com.pujjr.common.utils;

import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.commons.lang3.StringUtils;

/**
 * @author wen
 * @date 创建时间：2016年10月19日 上午9:36:09
 *
 */
public class BaseFileUtils {
	/**
	 * 缓冲大小 4MB
	 */
	private static final int BUFFER_SIZE = 4096;

	/**
	 * 将File文件转化为byte[]
	 * 
	 * @param file
	 * @return
	 * @throws IOException
	 */
	public static byte[] fileToByte(File file) throws IOException {
		byte[] buffer = null;
		FileInputStream fis = new FileInputStream(file);
		ByteArrayOutputStream bos = new ByteArrayOutputStream(1000);
		byte[] b = new byte[1000];
		int n;
		while ((n = fis.read(b)) != -1) {
			bos.write(b, 0, n);
		}
		fis.close();
		bos.close();
		buffer = bos.toByteArray();
		return buffer;
	}

	/**
	 * 将File文件转化为ByteArrayOutputStream
	 * 
	 * @param file
	 * @return
	 * @throws IOException
	 */
	public static ByteArrayOutputStream fileToByteArrayOutputStream(File file) throws IOException {
		FileInputStream fis = new FileInputStream(file);
		ByteArrayOutputStream bos = new ByteArrayOutputStream(1000);
		byte[] b = new byte[1000];
		int n;
		while ((n = fis.read(b)) != -1) {
			bos.write(b, 0, n);
		}
		fis.close();
		return bos;
	}

	/**
	 * 讲byte[]转化为文件
	 * 
	 * @param filePath
	 * @param data
	 * @return
	 */
	public static File byteToFile(String filePath, byte[] data) throws IOException {
		File file = new File(filePath);
		BufferedOutputStream stream = null;
		FileOutputStream fstream = null;
		try {
			fstream = new FileOutputStream(file);
			stream = new BufferedOutputStream(fstream);
			stream.write(data);
		} finally {
			try {
				if (stream != null) {
					stream.close();
				}
				if (null != fstream) {
					fstream.close();
				}
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		return file;
	}

	/**
	 * 将inputStream转化为outStream
	 * 
	 * @param inputStream
	 * @param outStream
	 * @return
	 * @throws IOException
	 */
	public static OutputStream inputToOutput(InputStream inputStream, OutputStream outStream) throws IOException {
		byte[] data = new byte[BUFFER_SIZE];
		int count = -1;
		while ((count = inputStream.read(data, 0, BUFFER_SIZE)) != -1) {
			outStream.write(data, 0, count);
		}
		inputStream.close();
		return outStream;
	}

	/**
	 * 得到一个唯一标记文件名
	 * 
	 * @param suffix
	 * @return
	 */
	public static String buildOnlyFileName(String suffix) {
		if (StringUtils.isBlank(suffix)) {
			return BaseUtils.get32UUID();
		} else {
			suffix = suffix.trim().toUpperCase();
			if (!StringUtils.contains(suffix, ".")) {
				suffix = "." + suffix;
			}
		}
		return BaseUtils.get32UUID() + suffix;
	}

	/**
	 * 获取文件后缀名
	 * 
	 * @param fileName
	 * @return
	 */
	public static String getFileSuffix(String fileName) {
		if (StringUtils.isNotBlank(fileName)) {
			int indexSuffix = fileName.lastIndexOf(".");
			if (indexSuffix != -1) {
				return fileName.substring(indexSuffix + 1);
			}
		}
		return fileName;
	}

	/**
	 * 根据指定的工具 打开一个文件
	 * 
	 * @param toolPath
	 * @param targetFilePath
	 * @throws IOException
	 */
	public static void openFile(String toolPath, String targetFilePath) throws IOException {
		Runtime.getRuntime().exec("\"" + toolPath + "\" " + "\"" + targetFilePath + "\"" + " -n");
	}

	public static void main(String[] args) {
		try {
			BaseFileUtils.openFile("C:/Program Files (x86)/Adobe/Acrobat DC/Acrobat/Acrobat.exe", "d://fileOut.pdf");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
