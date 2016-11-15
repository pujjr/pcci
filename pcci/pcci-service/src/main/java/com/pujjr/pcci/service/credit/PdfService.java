package com.pujjr.pcci.service.credit;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
import com.pujjr.common.result.ResultInfo;
import com.pujjr.common.utils.BaseFileUtils;
import com.pujjr.common.utils.BaseIterableUtils;
import com.pujjr.common.utils.bean.BeanPropertyUtils;
import com.pujjr.pcci.dal.entity.CreditCrimeInfo;
import com.pujjr.pcci.dal.entity.CreditExecution;
import com.pujjr.pcci.dal.entity.CreditPerInvest;
import com.pujjr.pcci.dal.entity.CreditQueryResult;
import com.pujjr.pcci.dal.entity.CreditRequest;
import com.pujjr.pcci.service.ParameterizedBaseService;
import com.pujjr.pcci.service.store.StoreService;

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
	private final static Integer DEFAULT_COLSPAN = 1;
	/**
	 * 默认字体大小
	 */
	private final static Integer DEFAULT_FONT_SIZE = 10;
	/**
	 * 默认列数
	 */
	private final static Integer DEFAULT_COLUMN_NUMBER = 10;

	/**
	 * 默认列数
	 */
	private final static Integer DEFAULT_VERTICAL_COLUMN_NUMBER = 2;

	/**
	 * 默认行间距
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
	 * 默认后缀
	 */
	private final static String DEFAULT_SUFFIX = ".PDF";

	/**
	 * pdf字体
	 */
	private Font font;

	/**
	 * pdf基本字体
	 */
	private BaseFont baseFont;

	@Autowired
	private StoreService storeService;

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

	/**
	 * 根据list集合快速生成表格
	 * 
	 * @param tableName
	 * @param numberOfColumns
	 * @param cells
	 * @param document
	 */
	private void quickTabeByList(String tableName, int numberOfColumns, List<String> cells, Document document) {

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
			} catch (Exception e) {
				logger.error("生成征信" + tableName + "表格错误", e);
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
	 */
	private void quickTabeByList(PdfPTable table, List<String> cells, Document document) {
		try {
			for (String cellValue : cells) {
				table.addCell(newCell(cellValue));
			}
			document.add(table);
		} catch (NullPointerException e) {
			nullTable(table, document);
		} catch (Exception e) {
			logger.error("生成征信表格错误", e);
			nullTable(table, document);
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

	public ResultInfo<String> creditQueryResultToPDF(CreditQueryResult credit) {
		ResultInfo<String> resultInfo = new ResultInfo<>();
		if (credit == null) {
			return resultInfo.fail("查询征信错误,征信信息为空");
		}

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

			// 存储文件到阿里云
			String ossKey = BaseFileUtils.buildOnlyFileName(DEFAULT_SUFFIX);
			ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
			storeService.upload(ossKey, bis);
			InputStream downStream = storeService.download(ossKey);
			BaseFileUtils.inputToOutput(downStream, new FileOutputStream("D://temp/" + ossKey));
			// 打开文件
			// BaseFileUtils.openFile("C:/Program Files (x86)/Adobe/Acrobat DC/Acrobat/Acrobat.exe", "D://temp/" + ossKey);
			return resultInfo.success(ossKey);
		} catch (DocumentException | IOException e) {
			logger.error("根据征信查询结果生成PDF文件失败", e);
			return resultInfo.fail(e.getMessage());
		} finally {
			if (bos != null) {
				try {
					bos.close();
				} catch (IOException e) {
					logger.error("根据征信查询结果生成PDF文件失败", e);
					resultInfo.fail(e.getMessage());
				}
			}

		}
	}

	private void titleTable(CreditQueryResult creditQueryResult, Document document) {

		PdfPTable table = defaultTable(4);
		table.addCell(newTitleCell(table, "征信报告"));
		try {
			CreditRequest creditRequest = creditQueryResult.getCreditRequest();
			table.addCell(newCell("姓名"));
			table.addCell(newCell(creditRequest.getName()));
			table.addCell(newCell("身份证号"));
			table.addCell(newCell(creditRequest.getIdNo()));
			document.add(table);
		} catch (DocumentException e) {
			logger.error("生成征信标题表格错误", e);
			nullTable(table, document);
		}
	}

	// 个人不良信息
	private void crimeinfoTable(List<CreditCrimeInfo> creditCrimeInfoList, Document document) {
		if (BaseIterableUtils.isEmpty(creditCrimeInfoList)) {
			creditCrimeInfoList = new ArrayList<>();
			CreditCrimeInfo creditCrimeInfo = new CreditCrimeInfo();
			BeanPropertyUtils.autoSetDefaultValue(creditCrimeInfo);
			creditCrimeInfoList.add(creditCrimeInfo);
		}
		for (int i = 0; creditCrimeInfoList != null && i < creditCrimeInfoList.size(); i++) {
			CreditCrimeInfo creditCrimeInfo = creditCrimeInfoList.get(i);
			List<String> cells = new ArrayList<>();
			cells.add("案件来源");
			cells.add(creditCrimeInfo.getCaseSource());
			cells.add("案件类别");
			cells.add(creditCrimeInfo.getCaseType());
			cells.add("案件时间");
			cells.add(creditCrimeInfo.getCaseTime());
			quickTabeByList(i == 0 ? "个人不良信息" : "", DEFAULT_VERTICAL_COLUMN_NUMBER, cells, document);
		}
	}

	// 被执行人
	private void executionTable(List<CreditExecution> creditExecutionList, Document document) {
		if (BaseIterableUtils.isEmpty(creditExecutionList)) {
			creditExecutionList = new ArrayList<>();
			CreditExecution creditExecution = new CreditExecution();
			BeanPropertyUtils.autoSetDefaultValue(creditExecution);
			creditExecutionList.add(creditExecution);
		}
		// 法院被执行信息 失信被执行记录"
		for (int i = 0; creditExecutionList != null && i < creditExecutionList.size(); i++) {
			CreditExecution creditExecution = creditExecutionList.get(i);
			List<String> badCells = new ArrayList<>();
			badCells.add("数据类型");
			badCells.add(creditExecution.getEx_bad_datatype());
			badCells.add("执行法院");
			badCells.add(creditExecution.getEx_bad_court());
			badCells.add("立案时间");
			badCells.add(creditExecution.getEx_bad_time());
			badCells.add("执行案号");
			badCells.add(creditExecution.getEx_bad_casenum());
			badCells.add("执行标的");
			badCells.add(creditExecution.getEx_bad_money());
			badCells.add("依据文号");
			badCells.add(creditExecution.getEx_bad_base());
			badCells.add("做出依据的单位");
			badCells.add(creditExecution.getEx_bad_basecompany());
			badCells.add("履行情况");
			badCells.add(creditExecution.getEx_bad_performance());
			badCells.add("具体情形");
			badCells.add(creditExecution.getEx_bad_concretesituation());
			badCells.add("失信时间");
			badCells.add(creditExecution.getEx_bad_breaktime());
			quickTabeByList(i == 0 ? "法院被执行信息——失信被执行记录" : "", DEFAULT_VERTICAL_COLUMN_NUMBER, badCells, document);
		}
		// 法院被执行信息 被执行记录
		for (int i = 0; creditExecutionList != null && i < creditExecutionList.size(); i++) {
			CreditExecution creditExecution = creditExecutionList.get(i);
			List<String> executCells = new ArrayList<>();
			executCells.add("数据类型");
			executCells.add(creditExecution.getEx_execut_datatype());
			executCells.add("执行法院");
			executCells.add(creditExecution.getEx_execut_court());
			executCells.add("立案时间");
			executCells.add(creditExecution.getEx_execut_time());
			executCells.add("执行案号");
			executCells.add(creditExecution.getEx_execut_casenum());
			executCells.add("执行标的");
			executCells.add(creditExecution.getEx_execut_money());
			executCells.add("案件状态");
			executCells.add(creditExecution.getEx_execut_statute());
			executCells.add("执行依据");
			executCells.add(creditExecution.getEx_execut_basic());
			executCells.add("做出依据的机构");
			executCells.add(creditExecution.getEx_execut_basiccourt());
			quickTabeByList(i == 0 ? "法院被执行信息——被执行记录" : "", DEFAULT_VERTICAL_COLUMN_NUMBER, executCells, document);
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
		} catch (NullPointerException e) {
			nullTable(table, document);
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

			String id_m1 = String.valueOf(creditQueryResult.getBr_m1_id_loan_num());
			String id_m3 = String.valueOf(creditQueryResult.getBr_m3_id_loan_num());
			String id_m6 = String.valueOf(creditQueryResult.getBr_m6_id_loan_num());
			String id_m12 = String.valueOf(creditQueryResult.getBr_m12_id_loan_num());

			String cell_m1 = String.valueOf(creditQueryResult.getBr_m1_cell_loan_num());
			String cell_m3 = String.valueOf(creditQueryResult.getBr_m3_cell_loan_num());
			String cell_m6 = String.valueOf(creditQueryResult.getBr_m6_cell_loan_num());
			String cell_m12 = String.valueOf(creditQueryResult.getBr_m12_cell_loan_num());

			newSomeCell(table, "身份证号", id_m1, id_m3, id_m6, id_m12);
			newSomeCell(table, "手机号", cell_m1, cell_m3, cell_m6, cell_m12);
			document.add(table);
		} catch (NullPointerException e) {
			nullTable(table, document);
		} catch (Exception e) {
			logger.error("生成征信百融信贷申请记录表格错误", e);
			nullTable(table, document);
		}
	}

	// 反欺诈
	private void antifrauddooTable(CreditQueryResult creditQueryResult, Document document) {
		List<String> cells = new ArrayList<>();
		cells.add("命中第三方标注黑名单");
		cells.add(creditQueryResult.getIsMachdBlMakt());
		cells.add("命中欺诈号码");
		cells.add(creditQueryResult.getIsMachFraud());
		quickTabeByList("前海反欺诈", DEFAULT_VERTICAL_COLUMN_NUMBER, cells, document);
	}

	// 风险度
	private void rskdooTable(CreditQueryResult creditQueryResult, Document document) {
		List<String> cells = new ArrayList<>();
		cells.add("来源代码");
		cells.add(creditQueryResult.getSourceId());
		cells.add("风险的分");
		cells.add(creditQueryResult.getRskScore());
		cells.add("风险标记");
		cells.add(creditQueryResult.getRskMark());
		cells.add("业务发生时间");
		cells.add(creditQueryResult.getDataBuildTime());
		quickTabeByList("前海风险度", DEFAULT_VERTICAL_COLUMN_NUMBER, cells, document);
	}

	// 一鉴通
	private void eChkPkgs(CreditQueryResult creditQueryResult, Document document) {
		List<String> cells = new ArrayList<>();
		cells.add("手机验证结果");
		cells.add(creditQueryResult.getIsOwnerMobile());
		cells.add("手机状态");
		cells.add(creditQueryResult.getOwnerMobileStatus());
		cells.add("使用时间分数");
		cells.add(creditQueryResult.getDataBuildTime());
		quickTabeByList("前海一鉴通", DEFAULT_VERTICAL_COLUMN_NUMBER, cells, document);
	}

	// 驾驶证
	private void drvcert2cmpincTable(CreditQueryResult creditQueryResult, Document document) {
		List<String> cells = new ArrayList<>();
		cells.add("驾驶证号");
		cells.add(creditQueryResult.getChkDriverNo());
		cells.add("姓名");
		cells.add(creditQueryResult.getChkName());
		cells.add("驾驶证状态的查询结果");
		cells.add(creditQueryResult.getChkStatus());
		quickTabeByList("前海驾驶证状态", DEFAULT_VERTICAL_COLUMN_NUMBER, cells, document);

	}

	// 对外投资
	private void perinvestTable(List<CreditPerInvest> creditPerInvestList, Document document) {
		if (BaseIterableUtils.isEmpty(creditPerInvestList)) {
			creditPerInvestList = new ArrayList<>();
			CreditPerInvest creditPerInvest = new CreditPerInvest();
			creditPerInvest.setPerinvestType(CreditPerInvest.PERINVEST_TYPE_RYPOSFR);
			BeanPropertyUtils.autoSetDefaultValue(creditPerInvest);
			creditPerInvestList.add(creditPerInvest);
			creditPerInvest = new CreditPerInvest();
			creditPerInvest.setPerinvestType(CreditPerInvest.PERINVEST_TYPE_RYPOSSHA);
			creditPerInvestList.add(creditPerInvest);
		}
		// 对外投资 企业法人信息
		for (int i = 0; creditPerInvestList != null && i < creditPerInvestList.size(); i++) {
			CreditPerInvest creditPerInvest = creditPerInvestList.get(i);
			if (CreditPerInvest.PERINVEST_TYPE_RYPOSFR.equals(creditPerInvest.getPerinvestType())) {
				List<String> legalPersonCells = new ArrayList<>();
				legalPersonCells.add("企业(机构)名称");
				legalPersonCells.add(creditPerInvest.getEntname());
				legalPersonCells.add("企业(机构)类型");
				legalPersonCells.add(creditPerInvest.getEnttype());
				legalPersonCells.add("注册资本(万元)");
				legalPersonCells.add(creditPerInvest.getEntstatus());
				quickTabeByList(i == 0 ? "对外投资——企业法人信息" : "", DEFAULT_VERTICAL_COLUMN_NUMBER, legalPersonCells, document);
			}
		}

		for (int i = 0; creditPerInvestList != null && i < creditPerInvestList.size(); i++) {
			CreditPerInvest creditPerInvest = creditPerInvestList.get(i);
			if (CreditPerInvest.PERINVEST_TYPE_RYPOSSHA.equals(creditPerInvest.getPerinvestType())) {
				List<String> shareholderCells = new ArrayList<>();
				shareholderCells.add("企业(机构)名称");
				shareholderCells.add(creditPerInvest.getEntname());
				shareholderCells.add("企业(机构)类型");
				shareholderCells.add(creditPerInvest.getEnttype());
				shareholderCells.add("注册资本(万元)");
				shareholderCells.add(creditPerInvest.getRegcap());
				shareholderCells.add("企业状态");
				shareholderCells.add(creditPerInvest.getEntstatus());
				quickTabeByList(i == 0 ? "对外投资——企业股东信息" : "", DEFAULT_VERTICAL_COLUMN_NUMBER, shareholderCells, document);
			}
		}
	}
}
