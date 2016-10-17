package com.pujjr.pcci.service.qhcs;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.pujjr.pcci.common.qhcs.bean.BusiData;
import com.pujjr.pcci.common.qhcs.bean.HeaderBean;
import com.pujjr.pcci.common.qhcs.bean.QianHaiSetting;
import com.pujjr.pcci.common.qhcs.bean.Record;
import com.pujjr.pcci.common.qhcs.bean.SecurityInfo;
import com.pujjr.pcci.common.qhcs.type.IdentityType;
import com.pujjr.pcci.common.qhcs.type.QueryReasonType;
import com.pujjr.pcci.common.qhcs.utils.DataSecurityUtil;
import com.pujjr.pcci.common.qhcs.utils.HttpRequestUtil;

/**
 * @author wen
 * @date 创建时间：2016年10月10日 下午2:01:14
 *
 */
public class QianHaiRequestTest {
	private static final String CHECK_CODE = "SK803@!QLF-D25WEDA5E52DA";
	private static final String SERVICE_URL = "https://test-qhzx.pingan.com.cn:5443/do/";

	public static void main(String[] args) throws Exception {
		QianHaiRequestTest test = new QianHaiRequestTest();
		test.test();
	}

	@Test
	public void test() throws Exception {
		QianHaiSetting setting = getQianHaiSetting();// 获得环境变量
		HeaderBean header = getMHeader_DMZ(setting);// 获得标头数据
		String encBusiData = DataSecurityUtil.encrypt(getBusiData_MSC8004().getBytes(), CHECK_CODE);// 加密基础数据
		String sigValue = DataSecurityUtil.signData(encBusiData);
		SecurityInfo securityInfo = getSecurityInfo(sigValue, setting);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("header", header);
		map.put("busiData", encBusiData);
		map.put("securityInfo", securityInfo);
		String message = JSON.toJSONString(map);
		System.out.println("请求：" + message);

		String res = HttpRequestUtil.sendJsonWithHttps(setting.getServiceURL(), message);
		System.out.println("响应Message：" + res);

		JSONObject msgJSON = JSON.parseObject(res);

		DataSecurityUtil.verifyData(msgJSON.getString("busiData"), msgJSON.getJSONObject("securityInfo").getString("signatureValue"));
		System.out.println("响应BusiData明文：" + DataSecurityUtil.decrypt(msgJSON.getString("busiData"), CHECK_CODE));
	}

	public QianHaiSetting getQianHaiSetting() {
		QianHaiSetting setting = new QianHaiSetting();
		setting.setNetType("dmz");// 网络类型
		setting.setTransName("query");// 交易名称
		setting.setProductId("rskdoo");// 产品ID
		setting.setApiVer("v1");// API版本
		setting.setMessageCode("MSC8036");// 报文代码
		setting.setOrgCode("10000000");// 机构代码
		setting.setChnlId("qhcs-dcs");// 接入系统ID
		setting.setAuthCode("CRT001A2");// 授权码
		setting.setUserName("V_PA025_QHCS_DCS");// 用户名
		setting.setUserPassword("weblogic1");// 用户密码
		setting.setCheckCode(CHECK_CODE);// 用于数据加密密钥（测试和生产环境不一致）
		StringBuffer url = new StringBuffer(SERVICE_URL);
		url.append("/");
		url.append(setting.getNetType());
		url.append("/");
		url.append(setting.getTransName());
		url.append("/");
		url.append(setting.getProductId());
		url.append("/");
		url.append(setting.getApiVer());
		url.append("/");
		url.append(setting.getMessageCode());
		setting.setServiceURL(url.toString());// 具体交易完整请求URL详见接口文档说明
		return setting;
	}

	public static HeaderBean getMHeader_DMZ(QianHaiSetting setting) {
		HeaderBean header = new HeaderBean();
		header.setOrgCode(setting.getOrgCode());
		header.setChnlId(setting.getChnlId());
		header.setTransNo("Trands" + (new Date().getTime()));
		header.setTransDate("2015-02-02 14:12:14");
		header.setAuthCode(setting.getAuthCode());
		header.setAuthDate("2015-12-02 14:12:14");
		return header;
	}

	public static String getBusiData_MSC8004() {
		BusiData busiData = new BusiData();
		busiData.setBatchNo("33adfsf323233");
		List<Record> list = new ArrayList<Record>();
		Record record = new Record();
		record.setReasonCode(QueryReasonType.LOAN_APPROVAL);
		record.setIdNo("440102198301114447");
		record.setIdType(IdentityType.ID_CARD);
		record.setName("米么联调");
		record.setSeqNo("r231545334546");
		record.setEntityAuthCode("entityAuthCode" + (new Date().getTime()));
		record.setEntityAuthDate("2016-10-10");
		// record.set
		list.add(record);
		busiData.setRecords(list);
		return JSON.toJSONString(busiData);
	}

	public static SecurityInfo getSecurityInfo(String signatureValue, QianHaiSetting setting) throws Exception {
		SecurityInfo securityInfo = new SecurityInfo();
		securityInfo.setSignatureValue(signatureValue);
		securityInfo.setUserName(setting.getUserName());
		securityInfo.setUserPassword(DataSecurityUtil.digest(setting.getUserPassword().getBytes()));
		return securityInfo;
	}

}
