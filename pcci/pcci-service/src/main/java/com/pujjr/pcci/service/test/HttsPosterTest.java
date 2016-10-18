package com.pujjr.pcci.service.test;

import java.util.Date;
import java.util.Iterator;

import com.bfd.facade.Apply_source;
import com.bfd.facade.Biz_industry;
import com.bfd.facade.Biz_positon;
import com.bfd.facade.Biz_type;
import com.bfd.facade.Educationallevel;
import com.bfd.facade.House_type;
import com.bfd.facade.Marriage;
import com.bfd.facade.MerchantServer;
import com.bfd.facade.PortraitBean;
import com.br.bean.TerBean;

import net.sf.json.JSONArray;
import net.sf.json.JSONException;
import net.sf.json.JSONObject;

public class HttsPosterTest {

	public static void main(String[] args) throws Exception {
		MerchantServer ms = new MerchantServer();
		// 登陆
		String login_result = ms.login("pujin_test", "pujin_test");
		JSONObject json = JSONObject.fromObject(login_result);
		System.out.println(login_result);
		String tokenid = json.getString("tokenid");// pujin_test_5sofyrzmlpa61jekxs4o5qb4i
		TerBean terBean = new TerBean();
		terBean.setApiType("ter");

		// 设置属性值
		/*
		 * HashMap<String,String> map=new HashMap<String,String>();
		 * map.put("branch",""); map.put("fname","");
		 */
		terBean.setTokenid(tokenid);
		terBean.setGid("");
		terBean.setMail("402182229@qq.com");
		terBean.setId("133026196510151857");
		terBean.setCell("13775606958");
		terBean.setName("李圆梅");
		terBean.setMeal("SpecialList_c,ApplyLoan"); // 自己选用套餐，多个模块用,分割
		terBean.setApp_visit_num(121);
		terBean.setHome_addr("北京市石景山区");
		terBean.setTel_biz("0833-2601698");
		terBean.setTel_home("0757-81431665");
		// terBean.setHome_addr("广东省佛山市南海区罗村街道北湖一路4号时代倾城54栋604房");
		terBean.setBiz_addr("广东省深圳市福田区天安数码城天祥大厦CD栋");
		terBean.setPer_addr("");
		terBean.setApply_addr("");
		terBean.setOth_addr("");
		terBean.setImei("1231241241521541111");
		terBean.setImsi("1234tysd");
		terBean.setMobile_type("iPhone6");
		terBean.setSex("男");
		terBean.setEducationallevel(Educationallevel.college_diploma);
		terBean.setIncome(1111110);
		terBean.setBiz_positon(Biz_positon.Middle_managers);
		terBean.setBiz_type(Biz_type.Government_affiliated_institutions);
		terBean.setBiz_workfor("万度科技有限公司");
		terBean.setHouse_type(House_type.With_the_housing_loan);
		terBean.setPostalcode("100000");
		terBean.setApply_source(Apply_source.Counter_application);
		terBean.setApply_product("信用卡");
		terBean.setApply_money("10000");
		terBean.setApply_time("2014年11月3日 16:47:11");
		terBean.setLoan_reason("花钱");
		terBean.setBank_id("6217000010010884107");
		terBean.setRefund_periods(12);
		terBean.setLinkman_cell("13336169272");
		terBean.setLinkman_name("张三");
		terBean.setLinkman_rela("配偶");
		terBean.setApp_visit_num(30);
		terBean.setEdu_att_num(10);
		terBean.setBank_running_att_num(98);
		terBean.setMarriage(Marriage.Married);
		terBean.setBiz_industry(Biz_industry.Energy_and_communication_service);
		terBean.setBank_running_att_num(12);

		terBean.setEdu_att_num(2);
		// terBean.setAf_swift_number("4a88dfca3d9fac3a_dd342b295f7e008b_15373f80d31");
		// terBean.setEvent("antifraud_login");
		terBean.setAf_swift_number("4a88dfca3d9fac3a_dd342b295f7e008b_15506501392");
		terBean.setEvent("antifraud_lend");

		// merchantBean.setExtData(map);
		long begin = new Date().getTime();
		String portrait_result = ms.getApiData(terBean);// JSON 尝试解析
		long end = new Date().getTime();

		System.out.println("time:" + (end - begin) + " ms");
		/*
		 * System.out.println("result:"+portrait_result); PortraitBean
		 * portrait=parsePortraitJSON(JSONObject.fromObject(portrait_result));
		 * portrait.save(); portrait.read("portrait.txt");
		 */
		System.out.println("result:" + portrait_result);
		System.out.println("------------------------------------------");

		testJson(portrait_result, 0, 0, "");
		System.out.println("------------------------------------------");
	}

	@SuppressWarnings("unused")
	private static PortraitBean parsePortraitJSON(JSONObject portrait_json) {
		PortraitBean portrait = new PortraitBean();
		portrait.setCode(portrait_json.getString("code"));
		portrait.setSwift_number(portrait_json.getString("swift_number"));
		portrait.setAuthentication(portrait_json.getJSONObject("Authentication"));
		portrait.setInternet(portrait_json.getJSONObject("Internet"));
		portrait.setLocation(portrait_json.getJSONObject("Location"));
		portrait.setStability(portrait_json.getJSONObject("Stability"));
		portrait.setConsumption(portrait_json.getJSONObject("Consumption"));
		portrait.setApplyloan(portrait_json.getJSONObject("ApplyLoan"));
		portrait.setOnline(portrait_json.getJSONObject("Online"));
		portrait.setSpeciallist(portrait_json.getJSONObject("SpecialList"));
		portrait.setRuleresult(portrait_json.getJSONObject("RuleResult"));
		portrait.setScore(portrait_json.getJSONObject("Score"));
		portrait.setTitle(portrait_json.getJSONObject("Title"));
		portrait.setAssets(portrait_json.getJSONObject("Assets"));
		portrait.setMedia(portrait_json.getJSONObject("Media"));
		portrait.setBrand(portrait_json.getJSONObject("Brand"));
		portrait.setFlag(portrait_json.getJSONObject("Flag"));
		return portrait;
	}

	public static void testJson(String json, int array_param, int obj_param, String str_null) {
		try {
			JSONObject jsonObject = JSONObject.fromObject(json);
			Iterator<?> it = jsonObject.keys();
			String str_1 = "";
			if (array_param == 0) {// 如果是第一个，那么为空
				str_1 += "";
			} else {
				str_1 += "      ";
			}
			if (obj_param == 0) {
				str_1 += "";
			} else { // 如果不是第一个，那么都增加" "输出
				str_1 += "      ";
			}
			str_null += str_1;
			while (it.hasNext()) {
				Object str = it.next();
				if (jsonObject.get(str).toString().contains("[")) {// 如果是array
					JSONArray jsonArray = jsonObject.getJSONArray(str.toString());
					System.out.println(str + ":");
					for (int i = 0; i < jsonArray.size(); i++) {
						String str_array = jsonArray.getString(i);
						testJson(str_array, 1, 0, str_null);
					}
				} else {// 如果不是array object
					String json_obj = jsonObject.get(str).toString();
					if (json_obj.contains("{")) {
						System.out.println(str_null + str + ":");
						testJson(json_obj, 0, 1, str_null);
					} else {
						System.out.println(str_null + str + ":" + jsonObject.get(str));
					}
				}
			}

		} catch (JSONException e) {

			e.printStackTrace();

		}

	}

}
