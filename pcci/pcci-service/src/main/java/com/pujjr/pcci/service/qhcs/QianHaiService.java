package com.pujjr.pcci.service.qhcs;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.pcci.api.bean.request.QianHaiRequestData;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.pujjr.common.result.ResultInfo;
import com.pujjr.common.type.credit.QueryProductType;
import com.pujjr.pcci.common.qhcs.bean.HeaderBean;
import com.pujjr.pcci.common.qhcs.bean.SecurityInfo;
import com.pujjr.pcci.common.qhcs.utils.DataSecurityUtil;
import com.pujjr.pcci.common.qhcs.utils.HttpRequestUtil;
import com.pujjr.pcci.dal.dao.QianHaiResultDAO;
import com.pujjr.pcci.dal.entity.QianHaiResult;
import com.pujjr.pcci.service.ParameterizedBaseService;

/**
 * @author wen
 * @date 创建时间：2016年10月19日 上午10:42:27
 *
 */
@Service
public class QianHaiService extends ParameterizedBaseService<QianHaiService> {

	/** 环境配置 */
	@Autowired
	private QianHaiSetting settingBean;

	@Autowired
	QianHaiResultDAO qianHaiResultDAO;

	public final static String DEFAULT_DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";

	public final static String DEFAULT_SEQNO = "1";

	public final static String DEFAULT_SUCCESS_CODE = "E000000";

	public final static String DEFAULT_SUBPRODUCTINC = "0000000000001000";

	/**
	 * 发送前海查询请求
	 * 
	 * @param transNo
	 * @param requestData
	 * @param productType
	 * @return
	 */
	public ResultInfo<QianHaiResult> sandQianHaiRequest(String transNo, QianHaiRequestData requestData, QueryProductType productType) {
		ResultInfo<QianHaiResult> resultInfo = new ResultInfo<>();
		List<QianHaiRequestData> requestList = new ArrayList<>();
		requestData.setSeqNo(DEFAULT_SEQNO);
		requestData.setTransNo(transNo);
		requestData.setBatchNo(transNo);
		requestList.add(requestData);

		ResultInfo<List<QianHaiResult>> resultList = sandQianHaiRequest(transNo, requestList, productType);

		if (resultList.isSuccess() && resultList.getData() != null && StringUtils.equalsIgnoreCase(resultList.getResultCode(), DEFAULT_SUCCESS_CODE)) {
			QianHaiResult qianHaiResult = resultList.getData().get(0);
			// 不为一鉴通查询
			if (!productType.equals(QueryProductType.MSC8107)) {
				resultInfo.setResultCode(resultList.getResultCode());
				resultInfo.setMsg(resultList.getMsg());
			} else {
				String errorInfo = qianHaiResult.getErrorInfo();
				JSONObject errorJson = JSON.parseObject(errorInfo);
				resultInfo.setResultCode(errorJson.getString("erCode"));
				resultInfo.setMsg(resultList.getMsg());
			}
			resultInfo.success(qianHaiResult);
		} else {
			resultInfo.fail();
		}
		resultInfo.setResultCode(resultList.getResultCode());
		resultInfo.setMsg(resultList.getMsg());
		return resultInfo;
	}

	/**
	 * 发送前海查询请求
	 * 
	 * @param transNo
	 * @param requestList
	 * @param productType
	 * @return
	 */
	public ResultInfo<List<QianHaiResult>> sandQianHaiRequest(String transNo, List<QianHaiRequestData> requestList, QueryProductType productType) {

		ResultInfo<List<QianHaiResult>> resultInfo = new ResultInfo<>();
		try {
			// 数据库存记录请求,获得批次号/流水号,并写入请求
			for (int i = 0; i < requestList.size(); i++) {
				if (requestList.get(i) != null) {
					requestList.get(i).setTransNo(transNo);
					requestList.get(i).setBatchNo(transNo);
				}
			}
			// 获得环境变量
			QianHaiSetting setting = getFullSettingByMessageCode(productType);
			// 获得标头数据
			HeaderBean header = getHeader(transNo);
			// 创建busiData的JSON字符串
			Map<String, Object> busiData = new HashMap<>();
			busiData.put("batchNo", transNo);
			busiData.put("records", requestList);
			busiData.put("subProductInc", DEFAULT_SUBPRODUCTINC);

			String busiDataString = JSON.toJSONString(busiData);
			// 获得安全节点数据 加密基础数据
			String encBusiData = DataSecurityUtil.encrypt(busiDataString.getBytes(StandardCharsets.UTF_8.displayName()), setting.getCheckCode());
			String sigValue = DataSecurityUtil.signData(encBusiData);
			SecurityInfo securityInfo = getSecurityInfo(sigValue);
			// 获得请求完整字符串
			Map<String, Object> requestMap = new HashMap<String, Object>();
			requestMap.put("header", header);
			requestMap.put("busiData", encBusiData);
			requestMap.put("securityInfo", securityInfo);
			String message = JSON.toJSONString(requestMap);
			// 发送查询请求
			String res = HttpRequestUtil.sendJsonWithHttps(setting.getServiceURL(), message);
			// 验签
			JSONObject msgJSON = JSON.parseObject(res);
			DataSecurityUtil.verifyData(msgJSON.getString("busiData"), msgJSON.getJSONObject("securityInfo").getString("signatureValue"));
			// 转为明文
			String responseBusiDataStr = DataSecurityUtil.decrypt(msgJSON.getString("busiData"), setting.getCheckCode());
			System.out.println("响应BusiData明文：" + responseBusiDataStr);

			JSONObject responseBusiDataJSON = JSON.parseObject(responseBusiDataStr);
			JSONArray recordsJSON = responseBusiDataJSON.getJSONArray("records");
			// 填装完整数据,并保存返回结果
			List<QianHaiResult> resultDataList = new ArrayList<>();
			for (int i = 0; i < recordsJSON.size(); i++) {
				QianHaiResult resultData = recordsJSON.getObject(i, QianHaiResult.class);
				resultData.setTransNo(transNo);
				resultData.setBatchNo(transNo);
				resultData.setQueryProductType(productType);
				// qianHaiResultDAO.save(resultData);
				resultDataList.add(resultData);
			}
			resultInfo.setResultCode(msgJSON.getJSONObject("header").getString("rtCode"));
			resultInfo.success(resultDataList);
		} catch (Exception e) {
			logger.error("请求前海征信报文错误" + productType, e);
			resultInfo.fail("请求前海征信调用错误");
		}
		return resultInfo;
	}

	/**
	 * 根据配置生成服务器接口调用地址
	 * 
	 * @return
	 */
	private String buildServiceURL(QianHaiSetting fullSettingBean) {
		StringBuffer url = new StringBuffer(fullSettingBean.getServiceURL());
		url.append("/").append(fullSettingBean.getNetType());
		url.append("/").append(fullSettingBean.getTransName());
		url.append("/").append(fullSettingBean.getProductId());
		url.append("/").append(fullSettingBean.getApiVer());
		url.append("/").append(fullSettingBean.getMessageCode());
		return url.toString();
	}

	/**
	 * 根据查询接口类型的报文编号获取完整环境配置
	 * 
	 * @param queryProductType
	 * @return
	 */
	private QianHaiSetting getFullSettingByMessageCode(QueryProductType queryProductType) {
		QianHaiSetting fullSettingBean = new QianHaiSetting();
		// 复制属性
		BeanUtils.copyProperties(settingBean, fullSettingBean);
		// 设置各个交易变化的属性
		fullSettingBean.setTransName(queryProductType.getTransName());
		fullSettingBean.setProductId(queryProductType.getProductId());
		fullSettingBean.setMessageCode(queryProductType.getMessageCode());
		// 服务地址
		fullSettingBean.setServiceURL(buildServiceURL(fullSettingBean));
		return fullSettingBean;
	}

	/**
	 * 获得请求头
	 * 
	 * @param transNo
	 * @return
	 */
	private HeaderBean getHeader(String transNo) {
		String nowDate = DateFormatUtils.format(new Date(), DEFAULT_DATE_FORMAT);
		HeaderBean header = new HeaderBean();
		header.setOrgCode(settingBean.getOrgCode());
		header.setChnlId(settingBean.getChnlId());
		header.setTransNo(transNo);
		header.setTransDate(nowDate);
		header.setAuthCode(settingBean.getAuthCode());
		header.setAuthDate(nowDate);
		return header;
	}

	/**
	 * 获取安全信息节点
	 * 
	 * @param signatureValue
	 * @param setting
	 * @return
	 * @throws Exception
	 */
	private SecurityInfo getSecurityInfo(String signatureValue) throws Exception {
		SecurityInfo securityInfo = new SecurityInfo();
		securityInfo.setSignatureValue(signatureValue);
		securityInfo.setUserName(settingBean.getUserName());
		securityInfo.setUserPassword(DataSecurityUtil.digest(settingBean.getUserPassword().getBytes()));
		return securityInfo;
	}

}
