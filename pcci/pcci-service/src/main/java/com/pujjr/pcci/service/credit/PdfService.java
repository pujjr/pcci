package com.pujjr.pcci.service.credit;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.compress.archivers.ArchiveOutputStream;
import org.apache.commons.compress.archivers.ArchiveStreamFactory;
import org.apache.commons.compress.archivers.zip.ZipArchiveEntry;
import org.apache.commons.compress.utils.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itextpdf.text.BaseColor;
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
import com.pujjr.common.exception.CheckFailException;
import com.pujjr.common.result.ResultInfo;
import com.pujjr.common.type.DrivingLicenceStatusType;
import com.pujjr.common.utils.BaseFileUtils;
import com.pujjr.common.utils.BaseIterableUtils;
import com.pujjr.common.utils.bean.BeanPropertyUtils;
import com.pujjr.pcci.dal.dao.CreditRequestDAO;
import com.pujjr.pcci.dal.entity.CreditCrimeInfo;
import com.pujjr.pcci.dal.entity.CreditExecution;
import com.pujjr.pcci.dal.entity.CreditPerInvest;
import com.pujjr.pcci.dal.entity.CreditQueryResult;
import com.pujjr.pcci.dal.entity.CreditRequest;
import com.pujjr.pcci.dal.entity.CreditRskdoo;
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

	@Autowired
	private CreditRequestDAO creditRequestDAO;

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
		return newTitleCell(table, text, BaseColor.BLACK);
	}

	/**
	 * 获得一个新标题的cell
	 * 
	 * @param text
	 * @return
	 * @throws IOException
	 * @throws DocumentException
	 */
	private PdfPCell newTitleCell(PdfPTable table, String text, BaseColor color) {
		PdfPCell cell = newCell(text, new Font(defaultBaseFont(), DEFAULT_FONT_SIZE, Font.BOLD, color));
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

	/**
	 * 下载PDF文件
	 * 
	 * @param id
	 * @return
	 */
	public ResultInfo<byte[]> downloadZip(List<CreditRequest> creditRequestList) {
		ResultInfo<byte[]> resultInfo = new ResultInfo<>();
		ByteArrayOutputStream targetZipStream = new ByteArrayOutputStream();
		try {
			ArchiveOutputStream out = new ArchiveStreamFactory().createArchiveOutputStream(ArchiveStreamFactory.ZIP, targetZipStream);
			for (CreditRequest creditRequest : creditRequestList) {
				byte[] byteArray = creditQueryResultToPDF(creditRequest.getCreditQueryResult());
				// 创建文件
				ZipArchiveEntry zipArchiveEntry = new ZipArchiveEntry(creditRequest.getId() + "_" + creditRequest.getName() + DEFAULT_SUFFIX);
				out.putArchiveEntry(zipArchiveEntry);
				ByteArrayInputStream bis = new ByteArrayInputStream(byteArray);
				IOUtils.copy(bis, out);
				out.closeArchiveEntry();
				bis.close();
			}
			out.finish();
			out.close();
			return resultInfo.success(targetZipStream.toByteArray());
		} catch (Exception e) {
			resultInfo.fail("下载PDF失败");
		}
		return resultInfo;
	}

	/**
	 * 下载PDF文件
	 * 
	 * @param id
	 * @return
	 */
	public ResultInfo<byte[]> downloadPDF(Long id) {
		ResultInfo<byte[]> resultInfo = new ResultInfo<>();
		ByteArrayOutputStream byteOutStream = new ByteArrayOutputStream();
		ByteArrayInputStream byteInStream = null;
		try {
			CreditRequest creditRequest = creditRequestDAO.get(id);
			if (StringUtils.isNotBlank(creditRequest.getOssKey())) {
				storeService.delete(creditRequest.getOssKey());
				creditRequest.setOssKey(null);
			}
			// 如果已经存在生成的PDF 则不再生成新的 而是使用原本的
			byte[] byteArray = creditQueryResultToPDF(creditRequest.getCreditQueryResult());
			// 存储文件到阿里云
			String ossKey = BaseFileUtils.buildOnlyFileName(DEFAULT_SUFFIX);
			byteInStream = new ByteArrayInputStream(byteArray);
			storeService.upload(ossKey, byteInStream);
			creditRequest.setOssKey(ossKey);
			return resultInfo.success(byteArray);
		} catch (Exception e) {
			resultInfo.fail("下载PDF失败:" + e.getMessage());
		} finally {
			if (byteOutStream != null) {
				try {
					byteOutStream.close();
				} catch (IOException e) {
					logger.error("根据征信查询结果生成PDF文件失败", e);
				}
			}
			if (byteInStream != null) {
				try {
					byteInStream.close();
				} catch (IOException e) {
					logger.error("根据征信查询结果生成PDF文件失败", e);
				}
			}
		}
		return resultInfo;
	}

	/**
	 * 
	 * @param creditRequest
	 * @return
	 */
	public ResultInfo<String> createPDF(CreditRequest creditRequest) {
		ResultInfo<String> resultInfo = new ResultInfo<>();
		ByteArrayOutputStream byteOutStream = new ByteArrayOutputStream();
		ByteArrayInputStream byteInStream = null;
		try {
			if (StringUtils.isNotBlank(creditRequest.getOssKey())) {
				storeService.delete(creditRequest.getOssKey());
				creditRequest.setOssKey(null);
			}
			// 如果已经存在生成的PDF 则不再生成新的 而是使用原本的
			byte[] byteArray = creditQueryResultToPDF(creditRequest.getCreditQueryResult());
			// 存储文件到阿里云
			String ossKey = BaseFileUtils.buildOnlyFileName(DEFAULT_SUFFIX);
			byteInStream = new ByteArrayInputStream(byteArray);
			storeService.upload(ossKey, byteInStream);
			creditRequest.setOssKey(ossKey);
			return resultInfo.success(creditRequest.getOssKey());
		} catch (Exception e) {
			resultInfo.fail("下载PDF失败:" + e.getMessage());
		} finally {
			if (byteOutStream != null) {
				try {
					byteOutStream.close();
				} catch (IOException e) {
					logger.error("根据征信查询结果生成PDF文件失败", e);
				}
			}
			if (byteInStream != null) {
				try {
					byteInStream.close();
				} catch (IOException e) {
					logger.error("根据征信查询结果生成PDF文件失败", e);
				}
			}
		}
		return resultInfo;
	}

	public byte[] creditQueryResultToPDF(CreditQueryResult creditQueryResult) throws CheckFailException {
		if (creditQueryResult == null) {
			throw new CheckFailException("查询征信错误,征信信息为空");
		}
		ByteArrayOutputStream bos = null;// 创建输出流
		Document document = new Document(PageSize.A4);
		try {
			bos = new ByteArrayOutputStream();
			PdfWriter.getInstance(document, bos);
			document.open();
			/* 开始填装数据 */

			// 标题
			titleTable(creditQueryResult, document);
			// 不良信息
			crimeinfoTable(creditQueryResult.getCreditCrimeInfoList(), document);
			// 法院被执行信息
			executionTable(creditQueryResult.getCreditExecutionList(), document);
			// 前海信贷申请记录
			loaneeTable(creditQueryResult, document);
			// 百融信贷申请记录
			applyloanTable(creditQueryResult, document);
			// 前海反欺诈
			antifrauddooTable(creditQueryResult, document);
			// 前海风险度
			rskdooTable(creditQueryResult.getCreditRskdooList(), document);
			// 前海一鉴通
			eChkPkgs(creditQueryResult, document);
			// 前海驾驶证
			drvcert2cmpincTable(creditQueryResult, document);
			// 对外投资
			perinvestTable(creditQueryResult.getCreditPerInvestList(), document);

			/* 填装数据结束 */
			document.close();
			return bos.toByteArray();
		} catch (DocumentException e) {
			logger.error("根据征信查询结果生成PDF文件失败", e);
			throw new CheckFailException("根据征信查询结果生成PDF文件失败:" + e.getMessage());
		} finally {
			if (bos != null) {
				try {
					bos.close();
				} catch (IOException e) {
					logger.error("根据征信查询结果生成PDF文件失败", e);
				}
			}
		}
	}

	private void titleTable(CreditQueryResult creditQueryResult, Document document) {

		PdfPTable table = defaultTable(4);
		try {
			CreditRequest creditRequest = creditQueryResult.getCreditRequest();
			table.addCell(newTitleCell(table, "征信报告"));
			if (creditRequest.getErrStatus() == CreditRequest.ERROR_STATUS_FAIL) {
				table.addCell(newTitleCell(table, "查询数据有异常,请检查!"));
			}
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
			cells.add(excNullValue(creditCrimeInfo.getCaseSource()));
			cells.add("案件类别");
			cells.add(excNullValue(creditCrimeInfo.getCaseType()));
			cells.add("案件时间");
			cells.add(excNullValue(creditCrimeInfo.getCaseTime()));
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
			badCells.add(excNullValue(creditExecution.getEx_bad_datatype()));
			badCells.add("执行法院");
			badCells.add(excNullValue(creditExecution.getEx_bad_court()));
			badCells.add("立案时间");
			badCells.add(excNullValue(creditExecution.getEx_bad_time()));
			badCells.add("执行案号");
			badCells.add(excNullValue(creditExecution.getEx_bad_casenum()));
			badCells.add("执行标的");
			badCells.add(excNullValue(creditExecution.getEx_bad_money()));
			badCells.add("依据文号");
			badCells.add(excNullValue(creditExecution.getEx_bad_base()));
			badCells.add("做出依据的单位");
			badCells.add(excNullValue(creditExecution.getEx_bad_basecompany()));
			badCells.add("履行情况");
			badCells.add(excNullValue(creditExecution.getEx_bad_performance()));
			badCells.add("具体情形");
			badCells.add(excNullValue(creditExecution.getEx_bad_concretesituation()));
			badCells.add("失信时间");
			badCells.add(excNullValue(creditExecution.getEx_bad_breaktime()));
			quickTabeByList(i == 0 ? "法院被执行信息——失信被执行记录" : "", DEFAULT_VERTICAL_COLUMN_NUMBER, badCells, document);
		}
		// 法院被执行信息 被执行记录
		for (int i = 0; creditExecutionList != null && i < creditExecutionList.size(); i++) {
			CreditExecution creditExecution = creditExecutionList.get(i);
			List<String> executCells = new ArrayList<>();
			executCells.add("数据类型");
			executCells.add(excNullValue(creditExecution.getEx_execut_datatype()));
			executCells.add("执行法院");
			executCells.add(excNullValue(creditExecution.getEx_execut_court()));
			executCells.add("立案时间");
			executCells.add(excNullValue(creditExecution.getEx_execut_time()));
			executCells.add("执行案号");
			executCells.add(excNullValue(creditExecution.getEx_execut_casenum()));
			executCells.add("执行标的");
			executCells.add(excNullValue(creditExecution.getEx_execut_money()));
			executCells.add("案件状态");
			executCells.add(excNullValue(creditExecution.getEx_execut_statute()));
			executCells.add("执行依据");
			executCells.add(excNullValue(creditExecution.getEx_execut_basic()));
			executCells.add("做出依据的机构");
			executCells.add(excNullValue(creditExecution.getEx_execut_basiccourt()));
			quickTabeByList(i == 0 ? "法院被执行信息——被执行记录" + i : "", DEFAULT_VERTICAL_COLUMN_NUMBER, executCells, document);
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
		Map<String, String> map = new HashMap<>();
		map.put("1", "命中");
		map.put("0", "未命中");
		List<String> cells = new ArrayList<>();
		cells.add("命中第三方标注黑名单");
		cells.add(getTargetValue(map, creditQueryResult.getIsMachdBlMakt()));
		cells.add("命中欺诈号码");
		cells.add(getTargetValue(map, creditQueryResult.getIsMachFraud()));
		quickTabeByList("前海反欺诈", DEFAULT_VERTICAL_COLUMN_NUMBER, cells, document);
	}

	// 风险度
	private void rskdooTable(List<CreditRskdoo> creditRskdooList, Document document) {
		if (BaseIterableUtils.isEmpty(creditRskdooList)) {
			creditRskdooList = new ArrayList<>();
			CreditRskdoo creditRskdoo = new CreditRskdoo();
			BeanPropertyUtils.autoSetDefaultValue(creditRskdoo);
			creditRskdooList.add(creditRskdoo);
		}
		for (int i = 0; creditRskdooList != null && i < creditRskdooList.size(); i++) {
			CreditRskdoo creditRskdoo = creditRskdooList.get(i);
			List<String> cells = new ArrayList<>();
			cells.add("来源代码");
			Map<String, String> sourceIdMap = new HashMap<>();
			sourceIdMap.put("A", "信贷逾期风险");
			sourceIdMap.put("B", "行政负面风险");
			sourceIdMap.put("C", "欺诈风险");
			cells.add(getTargetValue(sourceIdMap, creditRskdoo.getSourceId()));
			cells.add("风险的分");
			cells.add(excNullValue(creditRskdoo.getRskScore()));
			cells.add("风险标记");
			Map<String, String> rskMarkMap = new HashMap<>();
			rskMarkMap.put("B1", "失信被执行人");
			rskMarkMap.put("B2", "被执行人");
			rskMarkMap.put("B3", "交通严重违章");
			rskMarkMap.put("C1", "手机号存在欺诈风险");
			rskMarkMap.put("C2", "卡号存在欺诈风险");
			rskMarkMap.put("C3", "身份证号存在欺诈风险");
			rskMarkMap.put("C4", " IP存在欺诈风险");
			cells.add(getTargetValue(rskMarkMap, creditRskdoo.getRskMark()));
			cells.add("业务发生时间");
			cells.add(excNullValue(creditRskdoo.getDataBuildTime()));
			quickTabeByList(i == 0 ? "前海风险度" : "", DEFAULT_VERTICAL_COLUMN_NUMBER, cells, document);
		}
	}

	// 一鉴通
	private void eChkPkgs(CreditQueryResult creditQueryResult, Document document) {
		List<String> cells = new ArrayList<>();
		cells.add("手机验证结果");
		Map<String, String> isOwnerMobileMap = new HashMap<>();
		isOwnerMobileMap.put("0", "手机号、证件号、姓名均一致");
		isOwnerMobileMap.put("1", "手机号和证件号一致，姓名不一致");
		isOwnerMobileMap.put("2", "手机号和证件号一致，姓名不明确");
		isOwnerMobileMap.put("3", "手机号一致，证件号和姓名不一致");
		cells.add(getTargetValue(isOwnerMobileMap, creditQueryResult.getIsOwnerMobile()));
		cells.add("手机状态");
		Map<String, String> ownerMobileStatusMap = new HashMap<>();
		ownerMobileStatusMap.put("1", "正常");
		ownerMobileStatusMap.put("2", "停机");
		ownerMobileStatusMap.put("3", "不可用");
		ownerMobileStatusMap.put("4", "已销号");
		cells.add(getTargetValue(ownerMobileStatusMap, creditQueryResult.getOwnerMobileStatus()));
		cells.add("使用时间分数");
		Map<String, String> useTimeScoreMap = new HashMap<>();
		useTimeScoreMap.put("-1", "不可用");
		useTimeScoreMap.put("1", "(0-1]");
		useTimeScoreMap.put("2", "(1-2]");
		useTimeScoreMap.put("3", "(2-6]");
		useTimeScoreMap.put("4", "(6-12]");
		useTimeScoreMap.put("5", "(12-24]");
		useTimeScoreMap.put("6", "(24-36]");
		useTimeScoreMap.put("7", "(36,+]");
		useTimeScoreMap.put("30", "(0,6]");
		useTimeScoreMap.put("60", "(24,+]");
		cells.add(getTargetValue(useTimeScoreMap, creditQueryResult.getUseTimeScore()));
		quickTabeByList("前海一鉴通", DEFAULT_VERTICAL_COLUMN_NUMBER, cells, document);
	}

	// 驾驶证
	private void drvcert2cmpincTable(CreditQueryResult creditQueryResult, Document document) {
		Map<String, String> map = new HashMap<>();
		map.put("1", "匹配正确");
		map.put("0", "匹配不正确");
		List<String> cells = new ArrayList<>();
		cells.add("驾驶证号");
		cells.add(getTargetValue(map, creditQueryResult.getChkDriverNo()));
		cells.add("姓名");
		cells.add(getTargetValue(map, creditQueryResult.getChkName()));
		cells.add("驾驶证状态的查询结果");
		String chkStatus = DrivingLicenceStatusType.contains(creditQueryResult.getChkStatus()) ? DrivingLicenceStatusType.fromCode(creditQueryResult.getChkStatus()).getRemark() : "无数据";
		cells.add(chkStatus);
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

		DecimalFormat decimalFormat = new DecimalFormat("####,##0.#######");
		boolean isShowTableName = true;
		// 对外投资 企业法人信息
		for (int i = 0; creditPerInvestList != null && i < creditPerInvestList.size(); i++) {
			CreditPerInvest creditPerInvest = creditPerInvestList.get(i);
			if (CreditPerInvest.PERINVEST_TYPE_RYPOSFR.equals(creditPerInvest.getPerinvestType())) {
				List<String> legalPersonCells = new ArrayList<>();
				legalPersonCells.add("企业(机构)名称");
				legalPersonCells.add(excNullValue(creditPerInvest.getEntname()));
				legalPersonCells.add("企业(机构)类型");
				legalPersonCells.add(excNullValue(creditPerInvest.getEnttype()));
				legalPersonCells.add("注册资本(万元)");
				// 注册资本格式化
				String regcap = creditPerInvest.getRegcap();
				if (NumberUtils.isNumber(regcap)) {
					regcap = decimalFormat.format(Double.valueOf(regcap));
				}
				legalPersonCells.add(excNullValue(regcap));
				// 暂不使用该方法,标红文字
				quickTabeByList(isShowTableName ? "对外投资——企业股东信息" : "", DEFAULT_VERTICAL_COLUMN_NUMBER, legalPersonCells, document);
				isShowTableName = false;
			}
		}
		isShowTableName = true;
		for (int i = 0; creditPerInvestList != null && i < creditPerInvestList.size(); i++) {
			CreditPerInvest creditPerInvest = creditPerInvestList.get(i);
			if (CreditPerInvest.PERINVEST_TYPE_RYPOSSHA.equals(creditPerInvest.getPerinvestType())) {
				List<String> shareholderCells = new ArrayList<>();
				shareholderCells.add("企业(机构)名称");
				shareholderCells.add(excNullValue(creditPerInvest.getEntname()));
				shareholderCells.add("企业(机构)类型");
				shareholderCells.add(excNullValue(creditPerInvest.getEnttype()));
				shareholderCells.add("注册资本(万元)");
				// 注册资本格式化
				String regcap = creditPerInvest.getRegcap();
				if (NumberUtils.isNumber(regcap)) {
					regcap = decimalFormat.format(Double.valueOf(regcap));
				}
				shareholderCells.add(excNullValue(regcap));
				shareholderCells.add("企业状态");
				shareholderCells.add(excNullValue(creditPerInvest.getEntstatus()));
				// 暂不使用该方法,标红文字
				quickTabeByList(isShowTableName ? "对外投资——企业股东信息" : "", DEFAULT_VERTICAL_COLUMN_NUMBER, shareholderCells, document);
				isShowTableName = false;
			}
		}
	}

	/**
	 * 是否命中
	 * 
	 * @param value
	 * @return
	 */
	private String getTargetValue(Map<String, String> conditions, String value) {
		Iterator<String> keys = conditions.keySet().iterator();
		while (keys.hasNext()) {
			String key = keys.next();
			if (StringUtils.equals(key, value)) {
				return conditions.get(key);
			}
		}
		return excNullValue(null);
	}

	/**
	 * 排除掉空值
	 * 
	 * @param value
	 * @return
	 */
	private String excNullValue(String value) {
		return StringUtils.isBlank(value) ? "无数据" : value;
	}
}
