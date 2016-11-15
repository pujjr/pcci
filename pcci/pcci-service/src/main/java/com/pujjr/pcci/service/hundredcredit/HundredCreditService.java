package com.pujjr.pcci.service.hundredcredit;

import java.util.Date;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.bfd.facade.MerchantServer;
import com.br.bean.DasBean;
import com.br.bean.MerchantBean;
import com.br.bean.TerBean;
import com.pujjr.common.pager.Paged;
import com.pujjr.common.pager.PagedResult;
import com.pujjr.common.result.ResultInfo;
import com.pujjr.common.type.credit.MealType;
import com.pujjr.pcci.dal.dao.HundredCreditRequestDAO;
import com.pujjr.pcci.dal.entity.HundredCreditRequest;
import com.pujjr.pcci.service.ParameterizedBaseService;

/**
 * @author wen
 * @date 创建时间：2016年10月17日 下午4:18:35
 *
 */
@Service
public class HundredCreditService extends ParameterizedBaseService<HundredCreditService> {

	@Autowired
	HundredCreditRequestDAO hundredCreditRequestDAO;

	@Value("#{settings['account.100credit.username']}")
	private String username;

	@Value("#{settings['account.100credit.password']}")
	private String password;

	/**
	 * 调用百融批量打包查询
	 * 
	 * @param hundredCreditRequest
	 * @return
	 */
	public ResultInfo<String> hundredCreditTerRequest(HundredCreditRequest hundredCreditRequest, MealType... mealTypes) {
		String MealStr = StringUtils.join(mealTypes, ",");
		ResultInfo<String> basicValidateResult = requestValidate(hundredCreditRequest);
		if (basicValidateResult.isSuccess()) {
			hundredCreditRequest.setMeal(MealStr);
			hundredCreditRequest.setApiType(HundredCreditRequest.API_TYPE_TER);
			return createRequest(hundredCreditRequest, new TerBean());
		}
		return basicValidateResult;
	}

	/**
	 * 调用百融单独查询
	 * 
	 * @param hundredCreditRequest
	 * @return
	 */
	public ResultInfo<String> hundredCreditDasRequest(HundredCreditRequest hundredCreditRequest, MealType mealType) {
		ResultInfo<String> basicValidateResult = requestValidate(hundredCreditRequest);
		if (basicValidateResult.isSuccess()) {
			hundredCreditRequest.setMeal(mealType.name());
			hundredCreditRequest.setApiType(HundredCreditRequest.API_TYPE_DAS);
			return createRequest(hundredCreditRequest, new DasBean());
		}
		return basicValidateResult;
	}

	/**
	 * 发送调用百融查询的请求,未验证数据参数是否合法，需配合其他方法调用
	 * 
	 * @param hundredCreditRequest
	 * @param merchantBean
	 * @return
	 */
	private ResultInfo<String> createRequest(HundredCreditRequest hundredCreditRequest, MerchantBean merchantBean) {
		ResultInfo<String> resultInfo = new ResultInfo<>();
		MerchantServer ms = new MerchantServer();

		try {
			// 填装基本数据
			hundredCreditRequest.setRequestDate(new Date());
			// 复制bean数据
			BeanUtils.copyProperties(hundredCreditRequest, merchantBean);
			// 调用百融借口
			String portrait_result = ms.getApiData(merchantBean);
			// 保存请求结果
			// hundredCreditRequestDAO.save(hundredCreditRequest);
			System.out.println("百融" + hundredCreditRequest.getMeal() + "查询结果:" + JSON.parse(portrait_result));
			resultInfo.success(portrait_result);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage());
			resultInfo.fail("调用 百融接口查询出现错误");
		}
		return resultInfo;
	}

	@Cacheable(value = "100CreditLogin")
	public String login() {
		try {
			MerchantServer ms = new MerchantServer();
			// 登录并获得tokenid
			String login_result = ms.login(username, password);
			JSONObject json = JSON.parseObject(login_result);
			return json.getString("tokenid");
		} catch (Exception e) {
			logger.error("百融登录失败");
		}
		return null;
	}

	/**
	 * 对要发起的百融请求的参数进行基本验证
	 * 
	 * @param hundredCreditRequest
	 * @return
	 */
	private ResultInfo<String> requestValidate(HundredCreditRequest hundredCreditRequest) {
		ResultInfo<String> resultInfo = new ResultInfo<>();
		try {
			Assert.notNull(hundredCreditRequest, "请求数据获取错误");
			Assert.isTrue(StringUtils.isNotBlank(hundredCreditRequest.getRequestUserId()), "请求用户编号不能为空");
			Assert.isTrue(StringUtils.isNotBlank(hundredCreditRequest.getId()), "请求用户身份证号不能为空");
			Assert.isTrue(StringUtils.isNotBlank(hundredCreditRequest.getCell()), "请求用户手机号不能为空");
			Assert.isTrue(StringUtils.isNotBlank(hundredCreditRequest.getName()), "请求用户姓名不能为空");
		} catch (Exception e) {
			resultInfo.fail(e);
		}
		return resultInfo.success();
	}

	/**
	 * 根据调用请求用户工号,被查询人的姓名/手机号/身份证 查询单独调用请求记录
	 * 
	 * @param paged
	 * @param requestUserId
	 * @param name
	 * @param cell
	 * @param id
	 * @return
	 */
	public PagedResult<HundredCreditRequest> searchRequest(Paged paged, String requestUserId, String name, String cell, String id) {
		return hundredCreditRequestDAO.searchRequestResultRecord(paged, requestUserId, name, cell, id);
	}

}
