package com.pujjr.common.utils.document;

import java.io.IOException;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;

/**
 * @author wen
 * @date 创建时间：2016年11月1日 下午1:43:33
 *
 */
public class PdfUtils {

	/**
	 * 默认单元格所占合并列数
	 */
	public final static Integer DEFAULT_COLSPAN = 1;
	/**
	 * 默认字体大小
	 */
	public final static Integer DEFAULT_FONT_SIZE = 10;
	/**
	 * 默认列数
	 */
	public final static Integer DEFAULT_COLUMN_NUMBER = 10;

	/**
	 * 默认列数
	 */
	public final static Integer DEFAULT_VERTICAL_COLUMN_NUMBER = 2;

	/**
	 * 默认行间距
	 */
	public final static float DEFAULT_ROW_SPACE = 20f;
	/**
	 * 默认单元格高度
	 */
	public final static float DEFAULT_CELL_HEIGHT = 30f;
	/**
	 * 默认表格宽度(百分比)
	 */
	public final static int DEFAULT_TABLE_WIDTH_PERCENTAGE = 100;

	/**
	 * 默认后缀
	 */
	public final static String DEFAULT_SUFFIX = ".PDF";

	/**
	 * pdf字体
	 */
	public static Font font;

	/**
	 * pdf基本字体
	 */
	public static BaseFont baseFont;

	/**
	 * 获得默认的pdf字体
	 * 
	 * @return
	 * @throws DocumentException
	 * @throws IOException
	 */
	public static Font defaultFont() throws DocumentException, IOException {
		if (font == null) {
			font = new Font(defaultBaseFont(), DEFAULT_FONT_SIZE, Font.NORMAL);
		}
		return font;
	}

	public static Font getFont(float size, int style) throws DocumentException, IOException {
		return new Font(defaultBaseFont(), size, style);
	}

	/**
	 * 获得默认的基本pdf字体
	 * 
	 * @return
	 * @throws DocumentException
	 * @throws IOException
	 */
	public static BaseFont defaultBaseFont() throws DocumentException, IOException {
		if (baseFont == null) {
			baseFont = BaseFont.createFont("STSong-Light", "UniGB-UCS2-H", BaseFont.NOT_EMBEDDED);
		}
		return baseFont;
	}

	/**
	 * 获得默认table
	 * 
	 * @param rowSize
	 * @return
	 */
	public static PdfPTable defaultTable(int rowSize) {
		PdfPTable table = new PdfPTable(rowSize < 1 ? DEFAULT_COLUMN_NUMBER : rowSize);
		// 下间距
		table.setSpacingAfter(DEFAULT_ROW_SPACE);
		// 左对齐
		table.setHorizontalAlignment(Element.ALIGN_LEFT);
		// 表格宽度 百分比
		table.setWidthPercentage(DEFAULT_TABLE_WIDTH_PERCENTAGE);
		return table;
	}

	/**
	 * 获得一个新的cell
	 * 
	 * @param text
	 * @return
	 * @throws IOException
	 * @throws DocumentException
	 */
	public static PdfPCell newCell(String text) throws DocumentException, IOException {
		return newCell(text, DEFAULT_COLSPAN);
	}

	/**
	 * 获得一个新的cell
	 * 
	 * @param text
	 * @param colspan
	 * @return
	 * @throws DocumentException
	 * @throws IOException
	 */
	public static PdfPCell newCell(String text, Font font) {
		PdfPCell cell = new PdfPCell(new Phrase(text, font));
		cell.setFixedHeight(DEFAULT_CELL_HEIGHT);
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		return cell;
	}

	/**
	 * 获得一个新的cell
	 * 
	 * @param text
	 * @param colspan
	 * @return
	 * @throws DocumentException
	 * @throws IOException
	 */
	public static PdfPCell newCell(String text, int colspan) throws DocumentException, IOException {
		PdfPCell cell = new PdfPCell(new Phrase(text, defaultFont()));
		cell.setColspan(colspan < 1 ? DEFAULT_COLSPAN : colspan);
		cell.setFixedHeight(DEFAULT_CELL_HEIGHT);
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		return cell;
	}

	/**
	 * 创建标题
	 * 
	 * @param table
	 * @param texts
	 * @throws DocumentException
	 * @throws IOException
	 */
	public static void newSomeCell(PdfPTable table, String... texts) throws DocumentException, IOException {
		newSomeCell(table, DEFAULT_COLSPAN, texts);
	}

	/**
	 * 创建标题
	 * 
	 * @param table
	 * @param texts
	 * @throws DocumentException
	 * @throws IOException
	 */
	public static void newSomeCell(PdfPTable table, int colspan, String... texts) throws DocumentException, IOException {
		if (texts.length * colspan <= table.getNumberOfColumns()) {
			for (String text : texts) {
				table.addCell(newCell(text, colspan));
			}
			addNullCell(table, texts.length, colspan);
		}
	}

	/**
	 * 获得一个新的cell
	 * 
	 * @param text
	 * @return
	 * @throws IOException
	 * @throws DocumentException
	 */
	public static PdfPCell newTitleCell(PdfPTable table, String text) throws DocumentException, IOException {
		PdfPCell cell = newCell(text, getFont(DEFAULT_FONT_SIZE, Font.BOLD));
		cell.setColspan(table.getNumberOfColumns());
		cell.setBorder(Rectangle.NO_BORDER);
		return cell;
	}

	public static void addNullCell(PdfPTable table, int cellNumber, int colspan) {
		PdfPCell cell;
		int nullCellNumber = table.getNumberOfColumns() - (cellNumber * colspan);
		for (int i = 0; i < nullCellNumber; i++) {
			cell = new PdfPCell(new Phrase(""));
			cell.setBorder(Rectangle.NO_BORDER);
			table.addCell(cell);
		}
	}

	/**
	 * 根据list集合快速生成表格
	 * 
	 * @param tableName
	 * @param numberOfColumns
	 * @param cells
	 * @param document
	 * @throws DocumentException
	 * @throws IOException
	 */
	public static void quickTabeByList(String tableName, int numberOfColumns, List<String> cells, Document document) throws DocumentException, IOException {

		if (numberOfColumns > 0 && cells != null) {
			PdfPTable table = defaultTable(numberOfColumns);
			try {
				table.addCell(newTitleCell(table, tableName));
				for (String cellValue : cells) {
					table.addCell(newCell(cellValue));
				}
				document.add(table);
			} catch (NullPointerException e) {
				nullTable(table, document);
			}
		}

	}

	/**
	 * 根据list集合快速生成表格
	 * 
	 * @param tableName
	 * @param table
	 * @param cells
	 * @param document
	 * @throws DocumentException
	 * @throws IOException
	 */
	public static void quickTabeByList(PdfPTable table, List<String> cells, Document document) throws DocumentException, IOException {
		try {
			for (String cellValue : cells) {
				table.addCell(newCell(cellValue));
			}
			document.add(table);
		} catch (NullPointerException e) {
			nullTable(table, document);
		}

	}

	public static void nullTable(PdfPTable table, Document document) throws DocumentException, IOException {
		for (int i = 0; i < table.getNumberOfColumns(); i++) {
			table.addCell(newCell(""));
		}
		document.add(table);

	}

	/**
	 * 排除掉空值
	 * 
	 * @param value
	 * @return
	 */
	public static String excNullValue(String value) {
		return StringUtils.isBlank(value) ? "无数据" : value;
	}
}
