package com.pujjr.common.utils.document;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.alibaba.fastjson.JSON;
import com.pujjr.common.exception.CheckFailException;
import com.pujjr.common.utils.BaseFileUtils;

/**
 * @author wen
 * @date 创建时间：2016年11月1日 下午1:44:12
 *
 */
public class ExcelUtils {

	public final static String XLS = "xls";

	public final static String XLSX = "xlsx";

	private static Workbook newWorkBook(String fileName, InputStream inputStream) throws CheckFailException {
		if (StringUtils.isBlank(fileName)) {
			throw new CheckFailException("Excel文件名无效");
		}
		String fileSuffix = BaseFileUtils.getFileSuffix(fileName);
		try {
			if (fileSuffix.equalsIgnoreCase(XLS)) {
				return new HSSFWorkbook(inputStream);
			} else if (fileSuffix.equalsIgnoreCase(XLSX)) {
				return new XSSFWorkbook(inputStream);
			}
		} catch (IOException e) {
			throw new CheckFailException("Excel文件读取错误");
		}
		throw new CheckFailException("Excel文件文档格式不正确");
	}

	/**
	 * Excel读取
	 * 
	 * @param file
	 * @param startNum
	 * @param colNum
	 * @return
	 * @throws Exception
	 */
	public static List<String[]> loadExcelFile(File file, int startNum, int colNum) throws Exception {
		if (file == null) {
			throw new CheckFailException("Excel读取失败");
		}
		// 指定要读取的文件，本例使用上面生成的helloworld.xls
		FileInputStream fileInputStream = new FileInputStream(file);
		return loadExcelFile(fileInputStream, file.getName(), startNum, colNum);
	}

	/**
	 * Excel读取
	 * 
	 * @param inputStream
	 * @param fileName
	 * @param startNum
	 * @param colNum
	 * @return
	 * @throws Exception
	 */
	public static List<String[]> loadExcelFile(InputStream inputStream, String fileName, int startNum, int colNum) throws Exception {
		if (inputStream == null) {
			throw new CheckFailException("Excel读取失败");
		}
		// 创建一个WorkBook，从指定的文件流中创建，即上面指定了的文件流
		Workbook wb = null;
		Sheet st = null;
		Row row = null;
		Cell cell = null;
		// 验证文件后缀
		wb = newWorkBook(fileName, inputStream);

		// 注意，如果不能确定具体的名称，可以用getSheetAt(int)方法取得Sheet
		st = wb.getSheet("Sheet1");
		if (st == null) {
			st = wb.getSheetAt(0);
		}
		if (st.getPhysicalNumberOfRows() == 0) {
			closeStream(inputStream);
			throw new CheckFailException("所选工作表为空表");
		}

		// 建立x列坐标记录与y行坐标记录
		int x = 0;
		int y = startNum;

		// 建立集合存放数据
		// List list = new ArrayList<Ren_temp>();
		// String[][] data = new String[(st.getPhysicalNumberOfRows()) - 1][colNum];
		List<String[]> dataList = new ArrayList<>();
		// 初始化行与列对象
		row = null;
		cell = null;

		// 循环获取所有行
		for (; y < st.getPhysicalNumberOfRows(); y++) {
			// 获得单条行
			row = st.getRow(y);

			if (row != null) {
				String[] rowDataArray = new String[colNum];
				// 循环获取单条行所有列
				for (; x < colNum; x++) {
					cell = row.getCell((short) x);
					String cellValue = "";

					if (cell != null) {
						cell.setCellType(Cell.CELL_TYPE_STRING);
						cellValue = cell.getRichStringCellValue().getString();
						cellValue = cellValue.trim();
					}
					rowDataArray[x] = cellValue;
				}
				x = 0;
				dataList.add(rowDataArray);
			} else {
				closeStream(inputStream);
				throw new CheckFailException("第" + y + "行为空数据行,可能存在空格,请删除掉该行再重新尝试");
			}

		}
		// 把cell中的内容按字符串方式读取出来，并显示在控制台上
		// 注意，getRichStringCellValue()方法是3.0.1新追加的，
		// 老版本中的getStringCellValue()方法被deprecated了
		// System.out.println(cell.getRichStringCellValue());
		// 关闭流
		closeStream(inputStream);
		return dataList;
	}

	public static XSSFCellStyle getDefaultStyle(XSSFWorkbook wb) {
		// 设置样式
		XSSFCellStyle style = wb.createCellStyle();
		// 自动换行
		style.setWrapText(true);
		style.setBorderBottom((short) 1);
		style.setBorderTop((short) 1);
		style.setBorderLeft((short) 1);
		style.setBorderRight((short) 1);

		style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);// 垂直  
		style.setAlignment(HSSFCellStyle.ALIGN_CENTER);// 水平  

		XSSFFont font = wb.createFont();
		font.setFontHeightInPoints((short) 10);
		font.setFontName("仿宋");
		style.setFont(font);
		return style;
	}

	public static byte[] writeExcelFile(String[] title, String[][] excelData) {
		ByteArrayOutputStream bStream = new ByteArrayOutputStream();
		byte[] dataArrayByte = null;
		try {
			if (title != null && excelData != null) {
				XSSFWorkbook wb = new XSSFWorkbook();
				int sheetIndex = 1;
				XSSFSheet sheet = wb.createSheet("Sheet" + (sheetIndex));

				sheet.setDefaultRowHeightInPoints(25);
				// 设置样式
				XSSFCellStyle style = getDefaultStyle(wb);

				int rowIndex = 0;
				// title标题
				XSSFRow titleRow = sheet.createRow(rowIndex);
				for (int i = 0; i < title.length; i++) {
					XSSFCell cell = titleRow.createCell(i);
					cell.setCellStyle(style);
					cell.setCellValue(title[i]);
				}
				rowIndex++;
				// 数据内容
				for (String[] data : excelData) {
					if (rowIndex >= 65536) {

						sheet = wb.createSheet("Sheet" + (sheetIndex + 1));
						rowIndex = 0;
						sheetIndex++;
					}

					XSSFRow newRow = sheet.createRow(rowIndex);
					for (int i = 0; i < data.length; i++) {
						// 获取单元格内容
						XSSFCell cell = newRow.createCell(i);
						cell.setCellStyle(style);
						cell.setCellValue(data[i]);
					}
					rowIndex++;
				}
				autoAdjustWidthColumn(wb, title.length);
				// 输出文件
				wb.write(bStream);
				dataArrayByte = bStream.toByteArray();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (bStream != null) {
				try {
					bStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return dataArrayByte;
	}

	/**
	 * 自动调节行宽
	 * 
	 * @param sheet
	 * @param n
	 */
	private static void autoAdjustWidthColumn(XSSFWorkbook wb, int n) {

		for (int i = 0; i < wb.getNumberOfSheets(); i++) {
			XSSFSheet sheet = wb.getSheetAt(i);
			for (int j = 0; j < n; j++) {
				sheet.autoSizeColumn(j); // 调整第一列宽度
			}
		}
	}
	//

	public static void main(String[] args) {
		try {
			System.out.println(JSON.toJSONString(ExcelUtils.loadExcelFile(new File("d:/temp/征信查询测试.xlsx"), 1, 5)));
			// String[] title = new String[] { "一", "二", "三", "四", "五", "六", "七", "八", "九" };
			// String[][] test = new String[][] { { "5", "51", "52", "53", "54", "啊神单反", "暗色调", "57", "58" }, { "5", "51", "52", "53", "54", "啊神单反", "暗色调", "57", "58" }, { "8", "81", "82", "83", "", "85", "86", "87", "88" }, { "9", "91", "92", "93", null, "95", "96", "97", "98" } };
			// BaseFileUtils.byteToFile("d:/temp/ee.xls", ExcelUtils.outXls(title, test));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private static void closeStream(InputStream inputStream) throws IOException {
		if (inputStream != null) {
			inputStream.close();
		}
	}
}
