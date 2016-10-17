package com.pujjr.pcci.service.credit100;

import java.util.Date;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.bfd.facade.MerchantServer;
import com.br.bean.DasBean;

public class HttsPosterDasTest {

	public static void main(String[] args) throws Exception {
		MerchantServer ms = new MerchantServer();
		// 登陆
		String login_result = ms.login("pujin_test", "pujin_test");
		JSONObject json = JSON.parseObject(login_result);
		System.out.println(login_result);

		String tokenid = json.getString("tokenid");
		DasBean dasBean = new DasBean();
		dasBean.setApiType("das");

		// 设置属性值
		/*
		 * HashMap<String,String> map=new HashMap<String,String>();
		 * map.put("branch",""); map.put("fname","");
		 */
		dasBean.setTokenid(tokenid);
		dasBean.setId("320882198108282628");//
		dasBean.setCell("15216767645");
		// dasBean.setIndex("S0574,S0575");
		// dasBean.setBank_id("142701197907146614");
		dasBean.setName("孙汝琴");//
		// dasBean.setTokenid(tokenid);
		dasBean.setMeal("PerInvest");// 自选模块
		// 新加字段bchx
		// dasBean.setBiz_workfor("湖北和兴农资集团有限公司");
		// dasBean.setBiz_orgcode("746410416-8");
		// dasBean.setBiz_taxnum("123456789012345");
		// dasBean.setBiz_regnum("1531354513215");
		// dasBean.setKeyNo("3d9a2d02379f9ae6d16db49c3472f286");
		// dasBean.setUpstreamCount("1");
		// dasBean.setDownstreamCount("2");
		// dasBean.setSearchKey("雷军,小米科技有限责任公司");
		// dasBean.setId_photo("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");
		// //传输图片的字符串
		// dasBean.setDaily_photo("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");
		// //传输图片的字符串
		// dasBean.setId_photo(ImgUtil.GetImageStr("D:\\jyh\\zz.jpg"));
		// dasBean.setDaily_photo(ImgUtil.GetImageStr("D:\\jyh\\zz.jpg"));
		// dasBean.setCarnum("");//车牌号
		// dasBean.setVinnum("");//车架号
		// dasBean.setEnginenum("");//发动机号
		// merchantBean.setExtData(map);
		long begin = new Date().getTime();
		String portrait_result = ms.getApiData(dasBean);
		long end = new Date().getTime();

		System.out.println("time:" + (end - begin) + " ms");
		/*
		 * System.out.println("result:"+portrait_result); PortraitBean
		 * portrait=parsePortraitJSON(JSONObject.fromObject(portrait_result));
		 * portrait.save(); portrait.read("portrait.txt");
		 */
		System.out.println("result:" + portrait_result);
		System.out.println("------------------------------------------");

		/*
		 * testJson(portrait_result,0,0,"");
		 * System.out.println("------------------------------------------"); }
		 * private static PortraitBean parsePortraitJSON(JSONObject
		 * portrait_json){ PortraitBean portrait=new PortraitBean();
		 * portrait.setCode(portrait_json.getString("code"));
		 * portrait.setSwift_number(portrait_json.getString("swift_number"));
		 * portrait.setAuthentication(portrait_json.getJSONObject(
		 * "Authentication"));
		 * portrait.setInternet(portrait_json.getJSONObject("Internet"));
		 * portrait.setLocation(portrait_json.getJSONObject("Location"));
		 * portrait.setStability(portrait_json.getJSONObject("Stability"));
		 * portrait.setConsumption(portrait_json.getJSONObject("Consumption"));
		 * portrait.setApplyloan(portrait_json.getJSONObject("ApplyLoan"));
		 * portrait.setOnline(portrait_json.getJSONObject("Online"));
		 * portrait.setSpeciallist(portrait_json.getJSONObject("SpecialList"));
		 * portrait.setRuleresult(portrait_json.getJSONObject("RuleResult"));
		 * portrait.setScore(portrait_json.getJSONObject("Score"));
		 * portrait.setTitle(portrait_json.getJSONObject("Title"));
		 * portrait.setAssets(portrait_json.getJSONObject("Assets"));
		 * portrait.setMedia(portrait_json.getJSONObject("Media"));
		 * portrait.setBrand(portrait_json.getJSONObject("Brand"));
		 * portrait.setFlag(portrait_json.getJSONObject("Flag")); return
		 * portrait; }
		 * 
		 * 
		 * public static void testJson(String json,int array_param,int
		 * obj_param,String str_null){ try { JSONObject jsonObject =
		 * JSONObject.fromObject(json); Iterator it = jsonObject.keys(); String
		 * str_1 = ""; String str_objec_rep=""; if(array_param==0){//如果是第一个，那么为空
		 * str_1+=""; } else{ str_1+="      "; } if(obj_param==0){ str_1+=""; }
		 * else{ //如果不是第一个，那么都增加"     "输出 str_1+="      "; } str_null+=str_1;
		 * while (it.hasNext()) { Object str=it.next();
		 * if(jsonObject.get(str).toString().contains("[")){//如果是array
		 * JSONObject jsonArray = jsonObject.getJSONObject(str.toString());
		 * //JSONArray jsonArray = jsonObject.getJSONArray(str.toString());
		 * System.out.println(jsonArray+":"); } else{//如果不是array object String
		 * json_obj=jsonObject.get(str).toString(); //JSONObject json_obj =
		 * jsonObject.getJSONObject(str.toString()); if(json_obj.contains("{")){
		 * System.out.println(str_null+str+":");
		 * testJson(json_obj,0,1,str_null); } else{
		 * System.out.println(str_null+str+":"+jsonObject.get(str)); } } }
		 * 
		 * 
		 * 
		 * } catch (JSONException e) {
		 * 
		 * e.printStackTrace();
		 * 
		 * }
		 */
	}

}
