package com.pujjr.pcci.service.hundredcredit;

import java.util.Date;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.bfd.facade.MerchantServer;
import com.br.bean.DasBean;
import com.br.bean.TerBean;
import com.pujjr.pcci.common.hundredcredit.type.MealType;
import com.pujjr.pcci.common.result.ResultInfo;
import com.pujjr.pcci.dal.dao.HundredCreditDasRequestDAO;
import com.pujjr.pcci.dal.dao.HundredCreditResultDAO;
import com.pujjr.pcci.dal.dao.HundredCreditTerRequestDAO;
import com.pujjr.pcci.dal.entity.HundredCreditDasRequest;
import com.pujjr.pcci.dal.entity.HundredCreditResult;
import com.pujjr.pcci.dal.entity.HundredCreditTerRequest;
import com.pujjr.pcci.service.ParameterizedBaseService;

/**
 * @author wen
 * @date 创建时间：2016年10月17日 下午4:18:35
 *
 */
@Service
public class HundredCreditRequestService extends ParameterizedBaseService<HundredCreditRequestService> {

	public static final String API_TYPE_TER = "ter";

	public static final String API_TYPE_DAS = "das";

	@Autowired
	HundredCreditTerRequestDAO terRequestDAO;

	@Autowired
	HundredCreditDasRequestDAO dasRequestDAO;

	@Autowired
	HundredCreditResultDAO resultRecordDAO;

	@Value("#{settings['account.100credit.username']}")
	private String username;

	@Value("#{settings['account.100credit.password']}")
	private String password;

	/**
	 * 调用百融批量打包查询
	 * 
	 * @param terRequest
	 * @return
	 */
	public ResultInfo<String> terRequest(HundredCreditTerRequest terRequest, MealType... mealTypes) {
		String MealStr = StringUtils.join(mealTypes, ",");
		ResultInfo<String> basicValidateResult = TerValidate(terRequest, MealStr);
		if (basicValidateResult.isSuccess()) {
			terRequest.setMeal(MealStr);
			return createTerRequest(terRequest);
		}
		return basicValidateResult;
	}

	/**
	 * 调用百融个人不良信息查询
	 * 
	 * @param dasRequest
	 * @return
	 */
	public ResultInfo<String> crimeInfoRequest(HundredCreditDasRequest dasRequest) {
		ResultInfo<String> basicValidateResult = dasValidate(dasRequest);
		if (basicValidateResult.isSuccess()) {
			dasRequest.setMeal(MealType.CrimeInfo.name());
			return createDasRequest(dasRequest);
		}
		return basicValidateResult;
	}

	/**
	 * 调用百融个人对外投资查询
	 * 
	 * @param dasRequest
	 * @return
	 */
	public ResultInfo<String> perInvestRequest(HundredCreditDasRequest dasRequest) {
		ResultInfo<String> basicValidateResult = dasValidate(dasRequest);
		if (basicValidateResult.isSuccess()) {
			dasRequest.setMeal(MealType.PerInvest.name());
			return createDasRequest(dasRequest);
		}
		return basicValidateResult;
	}

	/**
	 * 调用百融批量打包查询的请求,未验证数据参数是否合法，需配合其他方法调用
	 * 
	 * @param HundredCreditDasRequest
	 *            请求的相关数据<br>
	 *            meal 产品编号，目前偶两种产品: <br>
	 *            CrimeInfo 个人不良信息查询 <br>
	 *            PerInvest 个人对外投资查询
	 * @return
	 */
	private ResultInfo<String> createTerRequest(HundredCreditTerRequest terRequest) {
		ResultInfo<String> resultInfo = new ResultInfo<>();
		MerchantServer ms = new MerchantServer();
		TerBean terBean = new TerBean();
		try {
			// 登录并获得tokenid
			String login_result = ms.login(username, password);
			JSONObject json = JSON.parseObject(login_result);
			String tokenid = json.getString("tokenid");
			// 填装基本数据
			terRequest.setTokenid(tokenid);
			terRequest.setApiType(API_TYPE_TER);
			terRequest.setRequestDate(new Date());
			// 复制bean数据
			BeanUtils.copyProperties(terRequest, terBean);
			// 保存请求操作记录
			terRequestDAO.save(terRequest);
			// 调用百融借口
			String portrait_result = ms.getApiData(terBean);
			// 保存请求结果
			HundredCreditResult resultRecord = new HundredCreditResult();
			BeanUtils.copyProperties(terRequest, resultRecord);
			resultRecord.setResultDate(new Date());
			resultRecord.setResult(portrait_result);
			resultRecordDAO.save(resultRecord);
			resultInfo.success(portrait_result);
		} catch (Exception e) {
			logger.error(e.getMessage());
			resultInfo.fail("调用 百融接口查询出现错误");
		}

		return resultInfo;
	}

	/**
	 * 发送单独调用百融查询的请求,未验证数据参数是否合法，需配合其他方法调用
	 * 
	 * @param HundredCreditDasRequest
	 *            请求的相关数据<br>
	 *            meal 产品编号，目前偶两种产品: <br>
	 *            CrimeInfo 个人不良信息查询 <br>
	 *            PerInvest 个人对外投资查询
	 * @return
	 */
	private ResultInfo<String> createDasRequest(HundredCreditDasRequest dasRequest) {
		ResultInfo<String> resultInfo = new ResultInfo<>();
		MerchantServer ms = new MerchantServer();
		DasBean dasBean = new DasBean();
		try {
			// 登录并获得tokenid
			String login_result = ms.login(username, password);
			JSONObject json = JSON.parseObject(login_result);
			String tokenid = json.getString("tokenid");
			// 填装基本数据
			dasRequest.setTokenid(tokenid);
			dasRequest.setApiType(API_TYPE_DAS);
			dasRequest.setRequestDate(new Date());
			// 复制bean数据
			BeanUtils.copyProperties(dasRequest, dasBean);
			// 保存请求操作记录
			dasRequestDAO.save(dasRequest);
			// 调用百融借口
			String portrait_result = ms.getApiData(dasBean);
			// 保存请求结果
			HundredCreditResult resultRecord = new HundredCreditResult();
			BeanUtils.copyProperties(dasRequest, resultRecord);
			resultRecord.setResultDate(new Date());
			resultRecord.setResult(portrait_result);
			resultRecordDAO.save(resultRecord);
			resultInfo.success(portrait_result);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage());
			resultInfo.fail("调用 百融接口查询出现错误");
		}
		return resultInfo;
	}

	/**
	 * 对要发起的百融批量打包调用查询请求的参数进行基本验证
	 * 
	 * @param terRequest
	 * @return
	 */
	private ResultInfo<String> TerValidate(HundredCreditTerRequest terRequest, String MealStr) {
		ResultInfo<String> resultInfo = new ResultInfo<>();
		try {
			Assert.notNull(terRequest, "请求数据获取错误");
			Assert.isTrue(StringUtils.isNotBlank(terRequest.getRequestUserId()), "请求用户编号不能为空");
			Assert.isTrue(StringUtils.isNotBlank(terRequest.getId()), "请求用户身份证号不能为空");
			Assert.isTrue(StringUtils.isNotBlank(terRequest.getCell()), "请求用户手机号不能为空");
			Assert.isTrue(StringUtils.isNotBlank(terRequest.getName()), "请求用户姓名不能为空");
			Assert.isTrue((StringUtils.isNotBlank(MealStr)), "请求产品不能为空");
		} catch (Exception e) {
			resultInfo.fail(e);
		}
		return resultInfo.success();
	}

	/**
	 * 对要发起的百融单独调用请求的参数进行基本验证
	 * 
	 * @param dasRequest
	 * @return
	 */
	private ResultInfo<String> dasValidate(HundredCreditDasRequest dasRequest) {
		ResultInfo<String> resultInfo = new ResultInfo<>();
		try {
			Assert.notNull(dasRequest, "请求数据获取错误");
			Assert.isTrue(StringUtils.isNotBlank(dasRequest.getRequestUserId()), "请求用户编号不能为空");
			Assert.isTrue(StringUtils.isNotBlank(dasRequest.getId()), "请求用户身份证号不能为空");
			Assert.isTrue(StringUtils.isNotBlank(dasRequest.getCell()), "请求用户手机号不能为空");
			Assert.isTrue(StringUtils.isNotBlank(dasRequest.getName()), "请求用户姓名不能为空");
		} catch (Exception e) {
			resultInfo.fail(e);
		}
		return resultInfo.success();
	}
}
