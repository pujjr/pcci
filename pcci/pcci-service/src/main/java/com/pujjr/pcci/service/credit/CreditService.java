package com.pujjr.pcci.service.credit;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.pcci.api.bean.request.CreditRequestData;
import org.pcci.api.bean.request.QianHaiRequestData;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.pujjr.common.result.ResultInfo;
import com.pujjr.common.type.IdentityType;
import com.pujjr.common.type.credit.MealType;
import com.pujjr.common.type.credit.QueryProductType;
import com.pujjr.common.type.credit.QueryReasonType;
import com.pujjr.pcci.dal.dao.CreditQueryResultDAO;
import com.pujjr.pcci.dal.entity.CreditCrimeInfo;
import com.pujjr.pcci.dal.entity.CreditExecution;
import com.pujjr.pcci.dal.entity.CreditPerInvest;
import com.pujjr.pcci.dal.entity.CreditQueryResult;
import com.pujjr.pcci.dal.entity.HundredCreditRequest;
import com.pujjr.pcci.dal.entity.QianHaiResult;
import com.pujjr.pcci.service.ParameterizedBaseService;
import com.pujjr.pcci.service.hundredcredit.HundredCreditService;
import com.pujjr.pcci.service.qhcs.QianHaiService;

/**
 * @author wen
 * @date 创建时间：2016年10月19日 上午10:42:27 征信查询服务
 *
 */
@Service
public class CreditService extends ParameterizedBaseService<CreditService> {

	/**
	 * 1个月前
	 */
	public final static Integer ONE_MONTH_AGO = -1;
	/**
	 * 3个月前
	 */
	public final static Integer THREE_MONTHS_AGO = -3;
	/**
	 * 6个月前
	 */
	public final static Integer SIX_MONTHS_AGO = -6;
	/**
	 * 12个月前
	 */
	public final static Integer TWELVE_MONTHS_AGO = -12;

	@Autowired
	HundredCreditService hundredCreditService;

	@Autowired
	QianHaiService qianHaiService;

	@Autowired
	PdfService pdfService;

	@Autowired
	CreditQueryResultDAO creditQueryResultDAO;

	// TODO motan测试方法
	public CreditCrimeInfo getCreditCrimeInfo() {
		CreditCrimeInfo creditCrimeInfo = new CreditCrimeInfo();
		creditCrimeInfo.setCaseSource("文震");
		creditCrimeInfo.setCaseTime(DateFormatUtils.format(new Date(), "yyyy-MM-dd"));
		creditCrimeInfo.setCaseType("9");
		return creditCrimeInfo;
	}

	// TODO motan测试方法
	public String getTokenid() {
		return hundredCreditService.login();
	}

	/**
	 * 征信查询请求参数验证
	 * 
	 * @param creditRequestData
	 * @return
	 */
	private ResultInfo<String> CreditRequestValidate(CreditRequestData creditRequestData) {
		ResultInfo<String> resultInfo = new ResultInfo<>();
		try {
			Assert.notNull(creditRequestData, "征信请求数据不能为空");
			Assert.isTrue(StringUtils.isNotBlank(creditRequestData.getCreditId()), "征信唯一流水号不能为空");
			Assert.isTrue(StringUtils.isNotBlank(creditRequestData.getRequestUserId()), "请求用户编号/工号不能为空");
			Assert.isTrue(StringUtils.isNotBlank(creditRequestData.getIdNo()), "被查询用户证件号不能为空");
			Assert.isTrue(StringUtils.isNotBlank(creditRequestData.getMobileNo()), "被查询用户手机号不能为空");
			Assert.isTrue(StringUtils.isNotBlank(creditRequestData.getName()), "被查询用户姓名不能为空");
			Assert.notNull(creditRequestData.getReasonCode(), "查询原因不能为空");
			Assert.notNull(creditRequestData.getIdType(), "被查询用户证件类型不能为空");
			Assert.isTrue(StringUtils.isNotBlank(creditRequestData.getEntityAuthCode()), "信息主体授权码不能为空");
			Assert.isTrue(StringUtils.isNotBlank(creditRequestData.getEntityAuthDate()), "信息主体授权码授权时间不能为空");
		} catch (IllegalArgumentException e) {
			resultInfo.fail(e);
		}
		return resultInfo.success();
	}

	/**
	 * 获得一个征信请求数据填装bean
	 * 
	 * @param creditId
	 * @param requestUserId
	 * @param idNo
	 * @param mobileNo
	 * @param name
	 * @param reasonType
	 * @param identityType
	 * @param entityAuthCode
	 * @param entityAuthDate
	 * @return
	 */
	private CreditRequestData getCreditRequestData(String creditId, String requestUserId, String idNo, String mobileNo, String name, QueryReasonType reasonType, IdentityType identityType, String entityAuthCode, String entityAuthDate) {
		CreditRequestData creditRequestData = new CreditRequestData();
		creditRequestData.setCreditId(StringUtils.leftPad(creditId, 10, "0"));
		creditRequestData.setRequestUserId(requestUserId);
		creditRequestData.setIdNo(idNo);
		creditRequestData.setMobileNo(mobileNo);
		creditRequestData.setName(name);
		creditRequestData.setReasonCode(reasonType.getCode());
		creditRequestData.setIdType(identityType.getCode());
		creditRequestData.setEntityAuthCode(entityAuthCode);
		creditRequestData.setEntityAuthDate(entityAuthDate);
		return creditRequestData;
	}

	/**
	 * 调用征信查询
	 * 
	 * @param creditRequestData
	 * @return
	 */
	public CreditQueryResult creditQuery(CreditRequestData creditRequestData) {
		long beginTime = System.currentTimeMillis();
		logger.debug("开始调用征信查询");
		// 临时数据
		String requestUserId = "admin";
		Long creditId = System.currentTimeMillis();
		creditRequestData.setEntityAuthCode("asd-123456789-asd456");
		creditRequestData.setEntityAuthDate("2016-10-10");
		creditRequestData = getCreditRequestData(creditId.toString(), requestUserId, "133026196510151857", "13775606958", "李圆梅", QueryReasonType.LOAN_MID_MANAGE, IdentityType.ID_CARD, "asd-123456789-asd456", "2016-10-10");
		// 开始调用
		CreditQueryResult creditQueryResult = new CreditQueryResult();
		try {
			// TODO 验证结果
			CreditRequestValidate(creditRequestData);

			String transNo = creditRequestData.getCreditId().toString();
			// 百融登录获取
			String tokenid = hundredCreditService.login();
			creditRequestData.setTokenid(tokenid);
			// 百融接口调用请求数据
			HundredCreditRequest hcRequestData = new HundredCreditRequest();
			hcRequestData.setTokenid(creditRequestData.getTokenid());// no
			hcRequestData.setRequestUserId(creditRequestData.getRequestUserId());
			hcRequestData.setId(creditRequestData.getIdNo());
			hcRequestData.setCell(creditRequestData.getMobileNo());
			hcRequestData.setName(creditRequestData.getName());

			// 前海接口调用请求数据
			QianHaiRequestData qhRequestData = new QianHaiRequestData();
			qhRequestData.setQueryId(transNo);
			qhRequestData.setSubmitTransNo(transNo);
			qhRequestData.setIdNo(creditRequestData.getIdNo());
			qhRequestData.setReasonCode(creditRequestData.getReasonCode());
			qhRequestData.setReasonNo(creditRequestData.getReasonCode());
			qhRequestData.setIdType(creditRequestData.getIdType());
			qhRequestData.setName(creditRequestData.getName());
			qhRequestData.setMobileNo(creditRequestData.getMobileNo());
			qhRequestData.setEntityAuthCode(creditRequestData.getEntityAuthCode());
			qhRequestData.setEntityAuthDate(creditRequestData.getEntityAuthDate());

			// 个人不良信息
			crimeinfoQuery(creditQueryResult, hcRequestData);
			// 被执行人
			executionQuery(creditQueryResult, hcRequestData);
			// 常贷客值装入
			loaneeQuery(creditQueryResult, qhRequestData, transNo);
			// 百融
			applyloanQuery(creditQueryResult, hcRequestData);
			// 反欺诈
			antifrauddooQuery(creditQueryResult, qhRequestData, transNo);
			// 风险度
			rskdooQuery(creditQueryResult, qhRequestData, transNo);
			// 一鉴通
			eChkPkgs(creditQueryResult, qhRequestData, transNo);
			// 驾驶证
			drvcert2cmpincQuery(creditQueryResult, qhRequestData, transNo);
			// 对外投资
			perinvestQuery(creditQueryResult, hcRequestData);

			creditQueryResult.setRequestUserId(creditRequestData.getRequestUserId());
			creditQueryResult.setRequestDate(new Date());
			creditQueryResult.setUserName(creditRequestData.getName());
			creditQueryResult.setUserIdNo(creditRequestData.getIdNo());

			creditQueryResultDAO.save(creditQueryResult);

			pdfService.creditQueryResultToPDF(creditQueryResult);
		} catch (Exception e) {
			logger.error("根据征信报告生成PDF文档出现错误", e);
			System.out.println(e.getMessage());
		}
		logger.debug("调用征信查询完成,耗时:" + ((System.currentTimeMillis() - beginTime) / 1000));
		return creditQueryResult;
	}

	/**
	 * 个人不良信息查询
	 * 
	 * @param creditQueryResult
	 * @param hcRequestData
	 */
	private void crimeinfoQuery(CreditQueryResult creditQueryResult, HundredCreditRequest hcRequestData) {
		try {
			ResultInfo<String> crimeInfoResult = hundredCreditService.hundredCreditDasRequest(hcRequestData, MealType.CrimeInfo);
			if (crimeInfoResult.isSuccess()) {
				JSONObject crimeInfoJSON = JSON.parseObject(crimeInfoResult.getData());
				if (StringUtils.equals(crimeInfoJSON.getString("code"), "600000")) {
					JSONArray priskChecks = crimeInfoJSON.getJSONObject("product").getJSONArray("priskChecks");
					List<CreditCrimeInfo> creditCrimeInfoList = new ArrayList<>();
					for (int i = 0; priskChecks != null && i < priskChecks.size(); i++) {
						JSONArray caseDetails = priskChecks.getJSONObject(i).getJSONArray("caseDetail");
						for (int j = 0; caseDetails != null && j < caseDetails.size(); j++) {
							CreditCrimeInfo creditCrimeInfo = new CreditCrimeInfo();
							JSONObject caseDetailJSON = caseDetails.getJSONObject(j);
							if (caseDetailJSON != null) {
								if (caseDetailJSON.getJSONObject("caseSource") != null) {
									creditCrimeInfo.setCaseSource(caseDetailJSON.getJSONObject("caseSource").getString("#text"));
								}
								if (caseDetailJSON.getJSONObject("caseTime") != null) {
									creditCrimeInfo.setCaseSource(caseDetailJSON.getJSONObject("caseTime").getString("#text"));
								}
								if (caseDetailJSON.getJSONObject("caseType") != null) {
									creditCrimeInfo.setCaseSource(caseDetailJSON.getJSONObject("caseType").getString("#text"));
								}
								creditCrimeInfoList.add(creditCrimeInfo);
							}
						}
					}
					creditQueryResult.setCreditCrimeInfoList(creditCrimeInfoList);
				}
			}
		} catch (Exception e) {
			logger.error("百融个人不良信息查询错误");
		}
	}

	/**
	 * 法院被执行人查询
	 * 
	 * @param creditQueryResult
	 * @param hcRequestData
	 */
	private void executionQuery(CreditQueryResult creditQueryResult, HundredCreditRequest hcRequestData) {
		try {
			ResultInfo<String> executionResult = hundredCreditService.hundredCreditTerRequest(hcRequestData, MealType.Execution);
			if (executionResult.isSuccess()) {
				JSONObject executionJSON = JSON.parseObject(executionResult.getData());
				if (StringUtils.equals(executionJSON.getString("code"), "00")) {
					List<CreditExecution> creditExecutionList = new ArrayList<>();
					String ex_bad = "ex_bad";
					String ex_execut = "ex_execut";
					for (int i = 1; i <= 10; i++) {
						if (StringUtils.contains(executionResult.getData(), ex_bad + i) && StringUtils.contains(executionResult.getData(), ex_execut + i)) {
							CreditExecution creditExecution = new CreditExecution();
							// 失信被执行记录
							creditExecution.setEx_bad_datatype(executionJSON.getString(ex_bad + i + "_datatype"));
							creditExecution.setEx_bad_court(executionJSON.getString(ex_bad + i + "_court"));
							creditExecution.setEx_bad_time(executionJSON.getString(ex_bad + i + "_time"));
							creditExecution.setEx_bad_casenum(executionJSON.getString(ex_bad + i + "_casenum"));
							creditExecution.setEx_bad_money(executionJSON.getString(ex_bad + i + "_money"));
							creditExecution.setEx_bad_base(executionJSON.getString(ex_bad + i + "_base"));
							creditExecution.setEx_bad_basecompany(executionJSON.getString(ex_bad + i + "_basecompany"));
							creditExecution.setEx_bad_performance(executionJSON.getString(ex_bad + i + "_performance"));
							creditExecution.setEx_bad_concretesituation(executionJSON.getString(ex_bad + i + "_concretesituation"));
							creditExecution.setEx_bad_breaktime(executionJSON.getString(ex_bad + i + "_breaktime"));
							// 被执行记录
							creditExecution.setEx_execut_datatype(executionJSON.getString(ex_execut + i + "_datatype"));
							creditExecution.setEx_execut_court(executionJSON.getString(ex_execut + i + "_court"));
							creditExecution.setEx_execut_time(executionJSON.getString(ex_execut + i + "_time"));
							creditExecution.setEx_execut_casenum(executionJSON.getString(ex_execut + i + "_casenum"));
							creditExecution.setEx_execut_money(executionJSON.getString(ex_execut + i + "_money"));
							creditExecution.setEx_execut_statute(executionJSON.getString(ex_execut + i + "_statute"));
							creditExecution.setEx_execut_basic(executionJSON.getString(ex_execut + i + "_basic"));
							creditExecution.setEx_execut_basiccourt(executionJSON.getString(ex_execut + i + "_basiccourt"));

							creditExecutionList.add(creditExecution);
						}
					}
					creditQueryResult.setCreditExecutionList(creditExecutionList);
				}
			}
		} catch (Exception e) {
			logger.error("百融法院被执行人查询错误");
		}
	}

	/**
	 * 常贷客
	 * 
	 * @param creditQueryResult
	 * @param qhRequestData
	 * @param transNo
	 */
	private void loaneeQuery(CreditQueryResult creditQueryResult, QianHaiRequestData qhRequestData, String transNo) {
		try {
			ResultInfo<QianHaiResult> qianHaiResult_8037 = qianHaiService.sandQianHaiRequest(transNo, qhRequestData, QueryProductType.MSC8037);
			if (qianHaiResult_8037.isSuccess()) {
				QianHaiResult qianHaiResults = qianHaiResult_8037.getData();
				if (StringUtils.isNotBlank(qianHaiResults.getBusiDate())) {
					Date busiDate = DateUtils.parseDate(qianHaiResults.getBusiDate(), "yyyy-MM-dd");
					Integer amount = Integer.parseInt(qianHaiResults.getAmount());
					Date nowDate = new Date();
					// 是否一月以内
					creditQueryResult.setQh_m1_id_loan_num(busiDate.before(DateUtils.addMonths(nowDate, ONE_MONTH_AGO)) ? amount : 0);
					// 是否三月以内
					creditQueryResult.setQh_m3_id_loan_num(busiDate.before(DateUtils.addMonths(nowDate, THREE_MONTHS_AGO)) ? amount : 0);
					// 是否六月以内
					creditQueryResult.setQh_m6_id_loan_num(busiDate.before(DateUtils.addMonths(nowDate, SIX_MONTHS_AGO)) ? amount : 0);
					// 是否十二月以内
					creditQueryResult.setQh_m12_id_loan_num(busiDate.before(DateUtils.addMonths(nowDate, TWELVE_MONTHS_AGO)) ? amount : 0);
				}
			}
		} catch (Exception e) {
			logger.error("前海常贷客查询错误");
		}

	}

	/**
	 * 百融多次贷款记录
	 * 
	 * @param creditQueryResult
	 * @param hcRequestData
	 */
	private void applyloanQuery(CreditQueryResult creditQueryResult, HundredCreditRequest hcRequestData) {
		try {
			ResultInfo<String> creditResult = hundredCreditService.hundredCreditTerRequest(hcRequestData, MealType.ApplyLoanStr, MealType.ApplyLoan);
			if (creditResult.isSuccess()) {
				CreditQueryResult creditJSON = JSON.parseObject(creditResult.getData(), CreditQueryResult.class);
				BeanUtils.copyProperties(creditJSON, creditQueryResult);
			}
		} catch (Exception e) {
			logger.error("百融多次贷款记录查询错误");
		}
	}

	/**
	 * 反欺诈
	 * 
	 * @param creditQueryResult
	 * @param qhRequestData
	 * @param transNo
	 */
	private void antifrauddooQuery(CreditQueryResult creditQueryResult, QianHaiRequestData qhRequestData, String transNo) {
		try {
			ResultInfo<QianHaiResult> qianHaiResult_8075 = qianHaiService.sandQianHaiRequest(transNo, qhRequestData, QueryProductType.MSC8075);
			if (qianHaiResult_8075.isSuccess()) {
				QianHaiResult qianHaiResults = qianHaiResult_8075.getData();
				creditQueryResult.setIsMachdBlMakt(qianHaiResults.getIsMachdBlMakt());
				creditQueryResult.setIsMachFraud(qianHaiResults.getIsMachFraud());
			}
		} catch (Exception e) {
			logger.error("前海反欺诈查询错误");
		}
	}

	/**
	 * 风险度
	 * 
	 * @param creditQueryResult
	 * @param qhRequestData
	 * @param transNo
	 */
	private void rskdooQuery(CreditQueryResult creditQueryResult, QianHaiRequestData qhRequestData, String transNo) {
		try {
			ResultInfo<QianHaiResult> qianHaiResult_8036 = qianHaiService.sandQianHaiRequest(transNo, qhRequestData, QueryProductType.MSC8036);
			if (qianHaiResult_8036.isSuccess()) {
				QianHaiResult qianHaiResults = qianHaiResult_8036.getData();
				creditQueryResult.setSourceId(qianHaiResults.getSourceId());
				creditQueryResult.setRskScore(qianHaiResults.getRskScore());
				creditQueryResult.setRskMark(qianHaiResults.getRskMark());
				creditQueryResult.setDataBuildTime(qianHaiResults.getDataBuildTime());
			}
		} catch (Exception e) {
			logger.error("前海风险度查询错误");
		}
	}

	/**
	 * 一鉴通
	 * 
	 * @param creditQueryResult
	 * @param qhRequestData
	 * @param transNo
	 */
	private void eChkPkgs(CreditQueryResult creditQueryResult, QianHaiRequestData qhRequestData, String transNo) {
		try {
			ResultInfo<QianHaiResult> qianHaiResult_8107 = qianHaiService.sandQianHaiRequest(transNo, qhRequestData, QueryProductType.MSC8107);
			if (qianHaiResult_8107.isSuccess()) {
				QianHaiResult qianHaiResults = qianHaiResult_8107.getData();
				creditQueryResult.setIsOwnerMobile(qianHaiResults.getIsOwnerMobile());
				creditQueryResult.setOwnerMobileStatus(qianHaiResults.getOwnerMobileStatus());
				creditQueryResult.setUseTimeScore(qianHaiResults.getUseTimeScore());
			}
		} catch (Exception e) {
			logger.error("前海一鉴通查询错误");
		}
	}

	/**
	 * 驾驶证状态
	 * 
	 * @param creditQueryResult
	 * @param qhRequestData
	 * @param transNo
	 */
	private void drvcert2cmpincQuery(CreditQueryResult creditQueryResult, QianHaiRequestData qhRequestData, String transNo) {
		try {
			ResultInfo<QianHaiResult> qianHaiResult_8079 = qianHaiService.sandQianHaiRequest(transNo, qhRequestData, QueryProductType.MSC8079);
			if (qianHaiResult_8079.isSuccess()) {
				QianHaiResult qianHaiResults = qianHaiResult_8079.getData();
				creditQueryResult.setIsOwnerMobile(qianHaiResults.getIsOwnerMobile());
				creditQueryResult.setOwnerMobileStatus(qianHaiResults.getOwnerMobileStatus());
				creditQueryResult.setUseTimeScore(qianHaiResults.getUseTimeScore());
			}
		} catch (Exception e) {
			logger.error("前海驾驶证状态查询错误");
		}
	}

	/**
	 * 对外投资
	 * 
	 * @param creditQueryResult
	 * @param hcRequestData
	 */
	private void perinvestQuery(CreditQueryResult creditQueryResult, HundredCreditRequest hcRequestData) {
		try {
			ResultInfo<String> perInvestResult = hundredCreditService.hundredCreditDasRequest(hcRequestData, MealType.PerInvest);
			if (perInvestResult.isSuccess()) {
				JSONObject creditJSON = JSON.parseObject(perInvestResult.getData());
				if (StringUtils.equals(creditJSON.getString("code"), "600000")) {
					// 企业法人信息
					JSONArray ryposfrs = creditJSON.getJSONObject("product").getJSONArray("RYPOSFR");
					List<CreditPerInvest> ryposfrPerInvestList = new ArrayList<>();
					for (int i = 0; ryposfrs != null && i < ryposfrs.size(); i++) {
						CreditPerInvest creditPerInvest = new CreditPerInvest();
						creditPerInvest.setPerinvestType(CreditPerInvest.PERINVEST_TYPE_RYPOSFR);
						JSONObject ryposfrJSON = ryposfrs.getJSONObject(i);
						if (ryposfrJSON != null) {
							creditPerInvest.setEntstatus(ryposfrJSON.getString("ENTSTATUS"));
							creditPerInvest.setRegcap(ryposfrJSON.getString("REGCAP"));
							creditPerInvest.setEntname(ryposfrJSON.getString("ENTNAME"));
							creditPerInvest.setEnttype(ryposfrJSON.getString("ENTTYPE"));
							ryposfrPerInvestList.add(creditPerInvest);
						}

					}
					// 企业股东信息
					JSONArray ryposshas = creditJSON.getJSONObject("product").getJSONArray("RYPOSSHA");
					List<CreditPerInvest> ryposshaPerInvestList = new ArrayList<>();
					for (int i = 0; ryposshas != null && i < ryposshas.size(); i++) {
						CreditPerInvest creditPerInvest = new CreditPerInvest();
						creditPerInvest.setPerinvestType(CreditPerInvest.PERINVEST_TYPE_RYPOSSHA);
						JSONObject ryposshaJSON = ryposshas.getJSONObject(i);
						if (ryposshaJSON != null) {
							creditPerInvest.setEntstatus(ryposshaJSON.getString("ENTSTATUS"));
							creditPerInvest.setRegcap(ryposshaJSON.getString("REGCAP"));
							creditPerInvest.setEntname(ryposshaJSON.getString("ENTNAME"));
							creditPerInvest.setEnttype(ryposshaJSON.getString("ENTTYPE"));
							ryposshaPerInvestList.add(creditPerInvest);
						}
					}

					creditQueryResult.setCreditPerInvestList(ryposshaPerInvestList);
				}
			}
		} catch (Exception e) {
			logger.error("百融对外投资查询错误");
		}
	}

}
