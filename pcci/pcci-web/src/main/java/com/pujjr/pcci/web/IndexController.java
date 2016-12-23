package com.pujjr.pcci.web;

import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.pujjr.common.pager.Paged;
import com.pujjr.common.pager.PagedResult;
import com.pujjr.common.result.ResultInfo;
import com.pujjr.common.utils.document.ExcelUtils;
import com.pujjr.pcci.api.bean.request.CreditRequestData;
import com.pujjr.pcci.api.type.IdentityType;
import com.pujjr.pcci.api.type.QueryReasonType;
import com.pujjr.pcci.dal.entity.CreditRequest;
import com.pujjr.pcci.service.credit.CreditService;
import com.pujjr.pcci.service.credit.ExcelService;

/**
 * @author wen
 * @date 创建时间：2016年10月11日 上午11:11:04
 *
 */
@Controller
public class IndexController extends BaseController {

	@Autowired
	CreditService creditService;

	@Autowired
	ExcelService excelService;

	@RequestMapping("/index")
	public String index() {
		return "index";
	}

	@RequestMapping("/test")
	public String test() {
		return "test";
	}

	@RequestMapping("/credit")
	@ResponseBody
	public Object credit() {
		return creditService.creditQueryAPI(new CreditRequestData());

	}

	/**
	 * 获得征信下载模板
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(value = "/getUploadTemplate")
	public void getUploadTemplate(HttpServletRequest request, HttpServletResponse response) {
		ResultInfo<byte[]> excelResult = excelService.getUploadTemplate();
		try {
			if (excelResult.isSuccess()) {
				byte[] byteArray = excelResult.getData();
				response.setContentType("application/x-download");
				response.setCharacterEncoding("utf-8");
				String fileName = "征信查询上传模板." + ExcelUtils.XLSX;
				/**
				 * 1. IE浏览器，采用URLEncoder编码 2. Opera浏览器，采用filename*方式 3. Safari浏览器，采用ISO编码的中文输出 4. Chrome浏览器，采用Base64编码或ISO编码的中文输出 5. FireFox浏览器，采用Base64或filename*或ISO编码的中文输出
				 * 
				 */
				// IE使用URLEncoder
				String userAgent = request.getHeader("User-Agent").toLowerCase();
				if (userAgent.contains("windows")) {
					fileName = URLEncoder.encode(fileName, StandardCharsets.UTF_8.displayName());
					// 其它使用转iso
				} else {
					fileName = new String((fileName).getBytes(StandardCharsets.UTF_8.displayName()), "ISO8859-1");
				}
				response.addHeader("Content-Disposition", "attachment;filename=" + fileName);
				OutputStream os = response.getOutputStream();
				os.write(byteArray);
				os.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return;
	}

	@RequestMapping(value = "/creditQueryByExcel")
	@ResponseBody
	public ResultInfo<String> creditQueryByExcel(@RequestParam MultipartFile[] files) {
		ResultInfo<String> resultInfo = new ResultInfo<>();
		if (files != null && files.length > 0) {
			// 循环获取files数组中得文件
			for (int i = 0; i < files.length; i++) {
				MultipartFile multipartFile = files[i];
				try {
					List<CreditRequestData> creditRequestDataList = new ArrayList<>();
					// 获取征信批量查询的Excel文件
					// 1.取Excel文件中叫Sheet的工作表或者第一个工作表
					// 2.表的第一排为标题,不需要读取
					// 3.文件中的字段顺序如下:
					// [姓名,手机号,证件号,授权码,授权时间]
					// 4.由于该批量处理为临时使用,以上字段外的征信查询需要的查询条件如证件类型,查询原因之类的固定写死,简化操作
					List<String[]> excelData = ExcelUtils.loadExcelFile(multipartFile.getInputStream(), multipartFile.getOriginalFilename(), 1, 5);
					int index = 1;
					for (String[] excelStrArray : excelData) {
						CreditRequestData creditRequestData = new CreditRequestData();
						// 从Excel里获取的必填
						creditRequestData.setName(excelStrArray[0]);// 姓名
						creditRequestData.setMobileNo(excelStrArray[1]);// 手机号
						creditRequestData.setIdNo(excelStrArray[2]);// 证件号
						creditRequestData.setEntityAuthCode(excelStrArray[3]);// 授权码
						// 授权时间yyyy-MM-dd
						// 没从Excel里获取的 自动填写的值
						// creditRequestData.setCreditId(BaseUtils.newUUID());// 请求唯一标识流水
						creditRequestData.setIdType(IdentityType.ID_CARD.getCode());// 证件类型
						creditRequestData.setReasonCode(QueryReasonType.LOAN_APPROVAL.getCode());// 查询原因
						creditRequestData.setRequestUserId("admin");// 征信查询发起人
						String EntityAuthDate = StringUtils.isBlank(excelStrArray[4]) ? DateFormatUtils.format(new Date(), "yyyy-MM-dd") : excelStrArray[4].trim();// 授权时间yyyy-MM-dd
						creditRequestData.setEntityAuthDate(EntityAuthDate);
						ResultInfo<String> validateResult = creditService.creditRequestValidate(creditRequestData);
						if (validateResult.isSuccess()) {
							CreditRequest repetitionCreditRequest = creditService.findCreditByThreeElement(creditRequestData.getName(), creditRequestData.getMobileNo(), creditRequestData.getIdNo());
							if (repetitionCreditRequest == null) {
								creditRequestDataList.add(creditRequestData);
							} else {
								return resultInfo.fail(index + "行数据重复:");
							}
							index++;
						} else {
							return resultInfo.fail(index + "行数据出错:" + validateResult.getMsg());
						}

					}
					ResultInfo<String> validateRepeatResult = creditService.isRepeatRequest(creditRequestDataList);
					if (validateRepeatResult.isSuccess()) {
						resultInfo = creditService.concurrenceCreditQuery(creditRequestDataList);
					} else {
						return resultInfo.fail(validateRepeatResult.getMsg());
					}
				} catch (Exception e) {
					e.printStackTrace();
					resultInfo.fail(e);
				}
			}
		}
		return resultInfo;

	}

	@RequestMapping(value = "/deleteAllError")
	public void deleteAllError(HttpServletRequest request, HttpServletResponse response) {
		ResultInfo<byte[]> excelResult = creditService.deleteAllError();
		OutputStream os = null;
		try {
			if (excelResult.isSuccess()) {
				byte[] byteArray = excelResult.getData();
				response.setContentType("application/x-download");
				response.setCharacterEncoding("utf-8");
				String fileName = "被删除异常查询列表." + ExcelUtils.XLSX;
				/**
				 * 1. IE浏览器，采用URLEncoder编码 2. Opera浏览器，采用filename*方式 3. Safari浏览器，采用ISO编码的中文输出 4. Chrome浏览器，采用Base64编码或ISO编码的中文输出 5. FireFox浏览器，采用Base64或filename*或ISO编码的中文输出
				 * 
				 */
				// IE使用URLEncoder
				String userAgent = request.getHeader("User-Agent").toLowerCase();
				if (userAgent.contains("windows")) {
					fileName = URLEncoder.encode(fileName, StandardCharsets.UTF_8.displayName());
					// 其它使用转iso
				} else {
					fileName = new String((fileName).getBytes(StandardCharsets.UTF_8.displayName()), "ISO8859-1");
				}
				response.addHeader("Content-Disposition", "attachment;filename=" + fileName);
				os = response.getOutputStream();
				os.write(byteArray);
				os.close();
			}
		} catch (Exception e) {
			logger.error("下载文件异常:" + e.getMessage());
		} finally {
			if (os != null) {
				try {
					os.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return;
	}

	@RequestMapping(value = "/downloadCredit/{id}")
	public void downloadCredit(@PathVariable Long id, HttpServletRequest request, HttpServletResponse response) {
		OutputStream os = null;
		try {
			if (id != null && id != 0) {
				ResultInfo<byte[]> downloadResult = creditService.downloadCreditFile(id);
				if (downloadResult.isSuccess()) {
					byte[] byteArray = downloadResult.getData();
					response.setContentType("application/pdf");
					response.setCharacterEncoding("utf-8");
					String fileName = "征信查询文件" + StringUtils.leftPad(String.valueOf(id), 10, "0") + ".PDF";
					/**
					 * 1. IE浏览器，采用URLEncoder编码 2. Opera浏览器，采用filename*方式 3. Safari浏览器，采用ISO编码的中文输出 4. Chrome浏览器，采用Base64编码或ISO编码的中文输出 5. FireFox浏览器，采用Base64或filename*或ISO编码的中文输出
					 * 
					 */
					// IE使用URLEncoder
					String userAgent = request.getHeader("User-Agent").toLowerCase();
					if (userAgent.contains("windows")) {
						fileName = URLEncoder.encode(fileName, StandardCharsets.UTF_8.displayName());
						// 其它使用转iso
					} else {
						fileName = new String((fileName).getBytes(StandardCharsets.UTF_8.displayName()), "ISO8859-1");
					}
					response.addHeader("Content-Disposition", "attachment;filename=" + fileName);
					os = response.getOutputStream();
					os.write(byteArray);
					os.close();
				}
			}
		} catch (Exception e) {
			logger.error("下载文件异常:" + e.getMessage());
		} finally {
			if (os != null) {
				try {
					os.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return;
	}

	@RequestMapping(value = "/downloadCreditZip")
	public void downloadCreditZip(Long beginCreditId, Long endCreditId, String searchText, String stateTime, String endTime, HttpServletRequest request, HttpServletResponse response) {
		OutputStream os = null;
		try {
			if (beginCreditId != null || endCreditId != null || StringUtils.isNotBlank(searchText) || (StringUtils.isNotBlank(stateTime) && StringUtils.isNotBlank(endTime))) {
				ResultInfo<byte[]> downloadResult = creditService.downloadPdfZipPack(beginCreditId, endCreditId, searchText, stateTime, endTime);
				if (downloadResult.isSuccess()) {
					byte[] byteArray = downloadResult.getData();
					response.setContentType("application/pdf");
					response.setCharacterEncoding("utf-8");
					String fileName = "征信查询文件-" + DateFormatUtils.format(new Date(), "yyyyMMdd") + ".ZIP";
					/**
					 * 1. IE浏览器，采用URLEncoder编码 2. Opera浏览器，采用filename*方式 3. Safari浏览器，采用ISO编码的中文输出 4. Chrome浏览器，采用Base64编码或ISO编码的中文输出 5. FireFox浏览器，采用Base64或filename*或ISO编码的中文输出
					 * 
					 */
					// IE使用URLEncoder
					String userAgent = request.getHeader("User-Agent").toLowerCase();
					if (userAgent.contains("windows")) {
						fileName = URLEncoder.encode(fileName, StandardCharsets.UTF_8.displayName());
						// 其它使用转iso
					} else {
						fileName = new String((fileName).getBytes(StandardCharsets.UTF_8.displayName()), "ISO8859-1");
					}
					response.addHeader("Content-Disposition", "attachment;filename=" + fileName);
					os = response.getOutputStream();
					os.write(byteArray);
					os.close();
				}
			}
		} catch (Exception e) {
			logger.error("下载文件异常:" + e.getLocalizedMessage());
		} finally {
			if (os != null) {
				try {
					os.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return;
	}

	@RequestMapping(value = "/searchCredit")
	public String searchCreditRequest(Integer page, Long beginCreditId, Long endCreditId, String searchText, String stateTime, String endTime) {

		Paged paged = new Paged();
		paged.setPage(page);
		if (beginCreditId != null || endCreditId != null || StringUtils.isNotBlank(searchText) || (StringUtils.isNotBlank(stateTime) && StringUtils.isNotBlank(endTime))) {
			PagedResult<CreditRequest> pagedResult = creditService.searchCreditRequest(paged, beginCreditId, endCreditId, searchText, stateTime, endTime);
			paged = pagedResult.getPaged();
			setAttribute("creditRequestList", pagedResult.getResults());
			setAttribute("paged", paged);
			setAttribute("beginCreditId", beginCreditId);
			setAttribute("endCreditId", endCreditId);
			setAttribute("stateTime", stateTime);
			setAttribute("endTime", endTime);
			setAttribute("searchText", searchText);
			if (StringUtils.isNotBlank(stateTime) && StringUtils.isNotBlank(endTime)) {
				setAttribute("stateEndTime", stateTime + " - " + endTime);
			}
		}
		return "search";
	}

	@RequestMapping(value = "/refreshCredit/{id}")
	@ResponseBody
	public ResultInfo<Void> refreshCredit(@PathVariable Long id, String queryType) {
		ResultInfo<Void> resultInfo = new ResultInfo<>();
		try {
			if (id != null && id != 0) {
				resultInfo = creditService.creditQueryAgain(id, queryType);
			}
		} catch (Exception e) {
			resultInfo.fail(e);
		}
		return resultInfo;
	}

	/**
	 * 征信查询更新页面
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping("/infoPage/{id}")
	public String refreshPage(@PathVariable Long id) {
		if (id != null && id != 0) {
			ResultInfo<CreditRequest> resultInfo = creditService.findCredit(id);
			if (resultInfo.isSuccess()) {
				CreditRequest creditRequest = resultInfo.getData();
				setAttribute("creditRequest", creditRequest);
				setAttribute("queryTaskMap", creditRequest.getCreditQueryResult().getQueryTaskMap());
			}
		}
		return "info";
	}

	@RequestMapping(value = "/deleteCredit/{id}")
	@ResponseBody
	public ResultInfo<Void> deleteCredit(@PathVariable Long id) {
		ResultInfo<Void> resultInfo = new ResultInfo<>();
		try {
			if (id != null && id != 0) {
				resultInfo = creditService.deleteCredit(id);
			}
		} catch (Exception e) {
			resultInfo.fail(e);
		}
		return resultInfo;
	}

}
