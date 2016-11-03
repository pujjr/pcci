package com.pujjr.common.utils;

import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author wen
 * @date 创建时间：2016年10月19日 上午9:36:09
 *
 */
public class BaseFileUtils {

	/**
	 * 将File文件转化为byte[]
	 * 
	 * @param file
	 * @return
	 */
	public static byte[] fileToByte(File file) {
		byte[] buffer = null;
		try {
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
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return buffer;
	}

	/**
	 * 讲byte[]转化为文件
	 * 
	 * @param filePath
	 * @param data
	 * @return
	 */
	public static File byteToFile(String filePath, byte[] data) {
		File file = new File(filePath);
		BufferedOutputStream stream = null;
		FileOutputStream fstream = null;
		try {
			fstream = new FileOutputStream(file);
			stream = new BufferedOutputStream(fstream);
			stream.write(data);
		} catch (Exception e) {
			e.printStackTrace();
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

	public static void openFile(String toolPath, String targetFilePath) throws IOException {
		Runtime.getRuntime().exec("\"" + toolPath + "\" " + "\"" + targetFilePath + "\"" + " -n");
	}

	public static void main(String[] args) {
		try {
			BaseFileUtils.openFile("C:/Program Files (x86)/Adobe/Acrobat DC/Acrobat/Acrobat.exe", "d://fileOut.pdf");
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
}
