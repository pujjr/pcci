package com.pujjr.pcci.service.credit;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Service;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.pujjr.common.utils.BaseFileUtils;
import com.pujjr.pcci.dal.entity.CreditCrimeInfo;
import com.pujjr.pcci.dal.entity.CreditExecution;
import com.pujjr.pcci.dal.entity.CreditPerInvest;
import com.pujjr.pcci.dal.entity.CreditQueryResult;
import com.pujjr.pcci.service.ParameterizedBaseService;

/**
 * @author wen
 * @date 创建时间：2016年10月19日 上午10:42:27 序列化为pdf文件服务
 *
 */
@Service
public class PdfService extends ParameterizedBaseService<PdfService> {

	/**
	 * 默认单元格所占合并列数
	 */
	private final static int DEFAULT_COLSPAN = 1;
	/**
	 * 默认字体大小
	 */
	private final static int DEFAULT_FONT_SIZE = 10;
	/**
	 * 默认列数
	 */
	private final static int DEFAULT_ROW_SIZE = 10;
	/**
	 * 默认列间距
	 */
	private final static float DEFAULT_ROW_SPACE = 20f;
	/**
	 * 默认单元格高度
	 */
	private final static float DEFAULT_CELL_HEIGHT = 30f;
	/**
	 * 默认表格宽度(百分比)
	 */
	private final static int DEFAULT_TABLE_WIDTH_PERCENTAGE = 100;

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
	private Font defaultFont() {
		if (font == null) {
			font = new Font(defaultBaseFont(), DEFAULT_FONT_SIZE, Font.NORMAL);
		}
		return font;
	}

	private Font getFont(float size, int style) {
		return new Font(defaultBaseFont(), size, style);
	}

	/**
	 * 获得默认的基本pdf字体
	 * 
	 * @return
	 * @throws DocumentException
	 * @throws IOException
	 */
	private BaseFont defaultBaseFont() {
		if (baseFont == null) {
			try {
				baseFont = BaseFont.createFont("STSong-Light", "UniGB-UCS2-H", BaseFont.NOT_EMBEDDED);
			} catch (Exception e) {
				logger.error("生成PDF基本字体错误");
			}
		}
		return baseFont;
	}

	/**
	 * 获得默认table
	 * 
	 * @param rowSize
	 * @return
	 */
	private PdfPTable defaultTable(int rowSize) {
		PdfPTable table = new PdfPTable(rowSize < 1 ? DEFAULT_ROW_SIZE : rowSize);
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
	private PdfPCell newCell(String text) {
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
	private PdfPCell newCell(String text, Font font) {
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
	private PdfPCell newCell(String text, int colspan) {
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
	private void newSomeCell(PdfPTable table, String... texts) {
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
	private void newSomeCell(PdfPTable table, int colspan, String... texts) {
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
	private PdfPCell newTitleCell(PdfPTable table, String text) {
		PdfPCell cell = newCell(text, getFont(DEFAULT_FONT_SIZE, Font.BOLD));
		cell.setColspan(table.getNumberOfColumns());
		cell.setBorder(Rectangle.NO_BORDER);
		return cell;
	}

	private void addNullCell(PdfPTable table, int cellNumber, int colspan) {
		PdfPCell cell;
		int nullCellNumber = table.getNumberOfColumns() - (cellNumber * colspan);
		for (int i = 0; i < nullCellNumber; i++) {
			cell = new PdfPCell(new Phrase(""));
			cell.setBorder(Rectangle.NO_BORDER);
			table.addCell(cell);
		}
	}

	public void creditQueryResultToPDF(CreditQueryResult credit) throws DocumentException, IOException {
		String randomFilePath = "d:/temp/" + System.currentTimeMillis() + ".pdf";
		ByteArrayOutputStream bos = null;// 创建输出流
		Document document = new Document(PageSize.A4);
		try {
			bos = new ByteArrayOutputStream();
			PdfWriter.getInstance(document, bos);
			document.open();
			/* 开始填装数据 */

			// 标题
			titleTable(credit, document);
			// 不良信息
			crimeinfoTable(credit.getCreditCrimeInfoList(), document);
			// 法院被执行信息
			executionTable(credit.getCreditExecutionList(), document);
			// 前海信贷申请记录
			loaneeTable(credit, document);
			// 百融信贷申请记录
			applyloanTable(credit, document);
			// 前海反欺诈
			antifrauddooTable(credit, document);
			// 前海风险度
			rskdooTable(credit, document);
			// 前海一鉴通
			eChkPkgs(credit, document);
			// 前海驾驶证
			drvcert2cmpincTable(credit, document);
			// 对外投资
			perinvestTable(credit.getCreditPerInvestList(), document);

			/* 填装数据结束 */
			document.close();
			BaseFileUtils.byteToFile(randomFilePath, bos.toByteArray());
		} finally {
			if (bos != null) {
				bos.close();
			}
			// TODO 打开文件
			BaseFileUtils.openFile("C:/Program Files (x86)/Adobe/Acrobat DC/Acrobat/Acrobat.exe", randomFilePath);
		}
	}

	private void nullTable(PdfPTable table, Document document) {
		try {
			for (int i = 0; i < table.getNumberOfColumns(); i++) {
				table.addCell(newCell(""));
			}
			document.add(table);
		} catch (DocumentException e) {
			logger.error("生成征信标题表格错误", e);
		}
	}

	private void titleTable(CreditQueryResult creditQueryResult, Document document) {

		PdfPTable table = defaultTable(4);
		table.addCell(newTitleCell(table, "征信报告"));
		try {
			table.addCell(newCell("姓名"));
			table.addCell(newCell(creditQueryResult.getUserName()));
			table.addCell(newCell("身份证号"));
			table.addCell(newCell(creditQueryResult.getUserIdNo()));
			document.add(table);
		} catch (DocumentException e) {
			logger.error("生成征信标题表格错误", e);
			nullTable(table, document);
		}
	}

	// 个人不良信息
	private void crimeinfoTable(List<CreditCrimeInfo> creditCrimeInfoList, Document document) {
		PdfPTable table = defaultTable(3);
		table.addCell(newTitleCell(table, "个人不良信息"));
		newSomeCell(table, "案件来源", "案件类别", "案件时间");
		try {
			for (CreditCrimeInfo creditCrimeInfo : creditCrimeInfoList) {
				newSomeCell(table, creditCrimeInfo.getCaseSource(), creditCrimeInfo.getCaseType(), creditCrimeInfo.getCaseTime());
			}
			document.add(table);
		} catch (Exception e) {
			logger.error("生成征信个人不良信息表格错误", e);
			nullTable(table, document);
		}
	}

	// 被执行人
	private void executionTable(List<CreditExecution> creditExecutionList, Document document) {
		// 法院被执行信息 失信被执行记录"
		PdfPTable badTable = defaultTable(10);
		badTable.addCell(newTitleCell(badTable, "法院被执行信息——失信被执行记录"));
		newSomeCell(badTable, "数据类型", "执行法院", "立案时间", "执行案号", "执行标的", "依据文号", "做出依据的单位", "履行情况", "具体情形", "失信时间");
		try {
			for (CreditExecution creditExecution : creditExecutionList) {
				newSomeCell(badTable, creditExecution.getEx_bad_datatype(), creditExecution.getEx_bad_court(), creditExecution.getEx_bad_time(), creditExecution.getEx_bad_casenum(), creditExecution.getEx_bad_money(), creditExecution.getEx_bad_base(), creditExecution.getEx_bad_basecompany(), creditExecution.getEx_bad_performance(), creditExecution.getEx_bad_concretesituation(), creditExecution.getEx_bad_breaktime());
			}
			document.add(badTable);
		} catch (Exception e) {
			logger.error("生成征信被执行人表格错误", e);
			nullTable(badTable, document);
		}
		// 法院被执行信息 被执行记录
		PdfPTable executTable = defaultTable(8);
		executTable.addCell(newTitleCell(executTable, "法院被执行信息——被执行记录"));
		newSomeCell(executTable, "数据类型", "执行法院", "立案时间", "执行案号", "执行标的", "案件状态", "执行依据", "做出依据的机构");
		try {
			for (CreditExecution creditExecution : creditExecutionList) {
				newSomeCell(executTable, creditExecution.getEx_execut_datatype(), creditExecution.getEx_execut_court(), creditExecution.getEx_execut_time(), creditExecution.getEx_execut_casenum(), creditExecution.getEx_execut_money(), creditExecution.getEx_execut_statute(), creditExecution.getEx_execut_basic(), creditExecution.getEx_execut_basiccourt());
			}
			document.add(executTable);
		} catch (Exception e) {
			logger.error("生成征信被执行人表格错误", e);
			nullTable(executTable, document);
		}

	}

	// 常贷客
	private void loaneeTable(CreditQueryResult creditQueryResult, Document document) {
		PdfPTable table = defaultTable(5);
		table.addCell(newTitleCell(table, "前海信贷申请记录"));
		newSomeCell(table, "", "近1个月", "近3个月", "近6个月", "近12个月");
		try {
			newSomeCell(table, "身份证号", creditQueryResult.getQh_m1_id_loan_num().toString(), creditQueryResult.getQh_m3_id_loan_num().toString(), creditQueryResult.getQh_m6_id_loan_num().toString(), creditQueryResult.getQh_m12_id_loan_num().toString());
			document.add(table);
		} catch (Exception e) {
			logger.error("生成征信前海信贷申请记录表格错误", e);
			nullTable(table, document);
		}
	}

	// 百融多次贷款申请
	private void applyloanTable(CreditQueryResult creditQueryResult, Document document) {
		PdfPTable table = defaultTable(5);
		table.addCell(newTitleCell(table, "百融信贷申请记录"));
		newSomeCell(table, "", "近1个月", "近3个月", "近6个月", "近12个月");
		try {

			String id_m1 = String.valueOf((creditQueryResult.getAls_m1_id_bank_allnum() + creditQueryResult.getAls_m1_id_nbank_allnum()));
			String id_m3 = String.valueOf((creditQueryResult.getAls_m3_id_bank_allnum() + creditQueryResult.getAls_m3_id_nbank_allnum()));
			String id_m6 = String.valueOf((creditQueryResult.getAls_m6_id_bank_allnum() + creditQueryResult.getAls_m6_id_nbank_allnum()));
			String id_m12 = String.valueOf((creditQueryResult.getAl_m12_id_bank_allnum() + creditQueryResult.getAl_m12_id_bank_selfnum() + creditQueryResult.getAl_m12_id_notbank_allnum() + creditQueryResult.getAl_m12_id_notbank_selfnum()));

			String cell_m1 = String.valueOf((creditQueryResult.getAls_m1_cell_bank_allnum() + creditQueryResult.getAls_m1_cell_nbank_allnum()));
			String cell_m3 = String.valueOf((creditQueryResult.getAls_m3_cell_bank_allnum() + creditQueryResult.getAls_m3_cell_nbank_allnum()));
			String cell_m6 = String.valueOf((creditQueryResult.getAls_m6_cell_bank_allnum() + creditQueryResult.getAls_m6_cell_nbank_allnum()));
			String cell_m12 = String.valueOf((creditQueryResult.getAl_m12_cell_bank_allnum() + creditQueryResult.getAl_m12_cell_bank_selfnum() + creditQueryResult.getAl_m12_cell_notbank_allnum() + creditQueryResult.getAl_m12_cell_notbank_selfnum()));

			newSomeCell(table, "身份证号", id_m1, id_m3, id_m6, id_m12);
			newSomeCell(table, "手机号", cell_m1, cell_m3, cell_m6, cell_m12);
			document.add(table);
		} catch (Exception e) {
			logger.error("生成征信百融信贷申请记录表格错误", e);
			nullTable(table, document);
		}
	}

	// 反欺诈
	private void antifrauddooTable(CreditQueryResult creditQueryResult, Document document) {
		PdfPTable table = defaultTable(2);
		table.addCell(newTitleCell(table, "前海反欺诈"));
		try {
			table.addCell(newCell("命中第三方标注黑名单"));
			table.addCell(newCell(creditQueryResult.getIsMachdBlMakt()));
			table.addCell(newCell("命中欺诈号码"));
			table.addCell(newCell(creditQueryResult.getIsMachFraud()));
			document.add(table);
		} catch (Exception e) {
			logger.error("生成征信前海反欺诈表格错误", e);
			nullTable(table, document);
		}
	}

	// 风险度
	private void rskdooTable(CreditQueryResult creditQueryResult, Document document) {
		PdfPTable table = defaultTable(2);
		table.addCell(newTitleCell(table, "前海风险度"));
		try {
			table.addCell(newCell("来源代码"));
			table.addCell(newCell(creditQueryResult.getSourceId()));
			table.addCell(newCell("风险的分"));
			table.addCell(newCell(creditQueryResult.getRskScore()));
			table.addCell(newCell("风险标记"));
			table.addCell(newCell(creditQueryResult.getRskMark()));
			table.addCell(newCell("业务发生时间"));
			table.addCell(newCell(creditQueryResult.getDataBuildTime()));
			document.add(table);
		} catch (Exception e) {
			logger.error("生成征信前海风险度表格错误", e);
			nullTable(table, document);
		}
	}

	// 一鉴通
	private void eChkPkgs(CreditQueryResult creditQueryResult, Document document) {
		PdfPTable table = defaultTable(2);
		table.addCell(newTitleCell(table, "前海一鉴通"));
		try {
			table.addCell(newCell("手机验证结果"));
			table.addCell(newCell(creditQueryResult.getIsOwnerMobile()));
			table.addCell(newCell("手机状态"));
			table.addCell(newCell(creditQueryResult.getOwnerMobileStatus()));
			table.addCell(newCell("使用时间分数"));
			table.addCell(newCell(creditQueryResult.getUseTimeScore()));
			document.add(table);
		} catch (Exception e) {
			logger.error("生成征信前海一鉴通表格错误", e);
			nullTable(table, document);
		}
	}

	// 驾驶证
	private void drvcert2cmpincTable(CreditQueryResult creditQueryResult, Document document) {
		PdfPTable table = defaultTable(2);
		table.addCell(newTitleCell(table, "前海驾驶证状态"));
		try {
			table.addCell(newCell("驾驶证号"));
			table.addCell(newCell(creditQueryResult.getChkDriverNo()));
			table.addCell(newCell("姓名"));
			table.addCell(newCell(creditQueryResult.getChkName()));
			table.addCell(newCell("驾驶证状态的查询结果"));
			table.addCell(newCell(creditQueryResult.getChkStatus()));
			document.add(table);
		} catch (Exception e) {
			logger.error("生成征信前海驾驶证状态表格错误", e);
			nullTable(table, document);
		}
	}

	// 对外投资
	private void perinvestTable(List<CreditPerInvest> creditPerInvestList, Document document) {
		// 对外投资 企业法人信息
		PdfPTable legalPersonTable = defaultTable(3);
		legalPersonTable.addCell(newTitleCell(legalPersonTable, "对外投资——企业法人信息"));
		newSomeCell(legalPersonTable, "企业(机构)名称", "企业(机构)类型", "注册资本(万元)");
		try {
			for (CreditPerInvest creditPerInvest : creditPerInvestList) {
				if (CreditPerInvest.PERINVEST_TYPE_RYPOSFR.equals(creditPerInvest.getPerinvestType())) {
					newSomeCell(legalPersonTable, creditPerInvest.getEntname(), creditPerInvest.getEnttype(), creditPerInvest.getEntstatus());
				}
			}
			document.add(legalPersonTable);
		} catch (Exception e) {
			logger.error("生成征信百融对外投资表格错误", e);
			nullTable(legalPersonTable, document);
		}

		// 对外投资 企业股东信息"
		PdfPTable shareholderTable = defaultTable(4);
		shareholderTable.addCell(newTitleCell(shareholderTable, "对外投资——企业股东信息"));
		newSomeCell(shareholderTable, "企业(机构)名称", "企业(机构)类型", "注册资本(万元)", "企业状态");
		try {
			for (CreditPerInvest creditPerInvest : creditPerInvestList) {
				if (CreditPerInvest.PERINVEST_TYPE_RYPOSSHA.equals(creditPerInvest.getPerinvestType())) {
					newSomeCell(shareholderTable, creditPerInvest.getEntname(), creditPerInvest.getEnttype(), creditPerInvest.getRegcap(), creditPerInvest.getEntstatus());
				}
			}
			document.add(shareholderTable);
		} catch (Exception e) {
			logger.error("生成征信百融对外投资表格错误", e);
			nullTable(shareholderTable, document);
		}
	}
}
