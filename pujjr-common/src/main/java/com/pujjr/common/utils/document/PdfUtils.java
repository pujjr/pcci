package com.pujjr.common.utils.document;

import java.io.IOException;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;

/**
 * @author wen
 * @date 创建时间：2016年11月1日 下午1:43:33
 *
 */
public class PdfUtils {

	private final static int DEFAULT_FONT_SIZE = 12;

	private final static int DEFAULT_ROW_SIZE = 10;

	private final static float DEFAULT_ROW_SPACE = 20f;

	/**
	 * pdf字体
	 */
	private Font font;

	/**
	 * pdf基本字体
	 */
	private BaseFont baseFont;

	/**
	 * 获得默认的pdf字体
	 * 
	 * @return
	 * @throws DocumentException
	 * @throws IOException
	 */
	public Font defaultFont() throws DocumentException, IOException {
		if (font == null) {
			font = new Font(defaultBaseFont(), DEFAULT_FONT_SIZE, Font.NORMAL);
		}
		return font;
	}

	/**
	 * 获得默认的基本pdf字体
	 * 
	 * @return
	 * @throws DocumentException
	 * @throws IOException
	 */
	public BaseFont defaultBaseFont() throws DocumentException, IOException {
		if (baseFont == null) {
			baseFont = BaseFont.createFont("STSong-Light", "UniGB-UCS2-H", BaseFont.NOT_EMBEDDED);
		}
		return baseFont;
	}

	/**
	 * 获得默认table
	 * 
	 * @return
	 */
	public PdfPTable defaultTable() {
		PdfPTable table = new PdfPTable(DEFAULT_ROW_SIZE);
		// 下间距
		table.setSpacingAfter(DEFAULT_ROW_SPACE);
		// 左对齐
		table.setHorizontalAlignment(Element.ALIGN_LEFT);
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
	public PdfPCell newCell(String text) throws DocumentException, IOException {
		PdfPCell cell = new PdfPCell(new Phrase(text, defaultFont()));
		return cell;
	}

	/**
	 * 添加一个新的cell到table
	 * 
	 * @param table
	 * @param text
	 * @return
	 * @throws IOException
	 * @throws DocumentException
	 */
	public PdfPTable addNewCell(PdfPTable table, String text) throws DocumentException, IOException {
		PdfPCell cell = new PdfPCell(new Phrase(text, defaultFont()));
		table.addCell(cell);
		return table;
	}

}
