package com.pujjr.pcci.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.pujjr.pcci.common.pager.PagedResult;
import com.pujjr.pcci.dal.entity.User;
import com.pujjr.pcci.service.UserTestService;

/**
 * @author wen
 * @date 创建时间：2016年10月11日 上午11:11:04
 *
 */
@Controller
public class DemoController extends BaseController {

	@Autowired(required = false)
	UserTestService userTestService;

	@Value("#{settings['pcci.xx']}")
	String xx;

	@Value("#{settings['pcci.xxx']}")
	String xxx;

	@RequestMapping("/index")
	public String index() {
		return "index";
	}

	@RequestMapping("/out")
	@ResponseBody
	public void index2() {
		System.out.println("-------进入out------");
		userTestService.createNewUser();
		setAttribute("name", "哈哈哈");
		System.out.println("name:" + getAttribute("name"));
		System.out.println("-------结束------");
	}

	@RequestMapping("/find")
	@ResponseBody
	public void index3() {
		System.out.println("-------进入find------");
		PagedResult<User> pagedResult = userTestService.findAllUser();
		System.out.println("xx:" + xx);
		System.out.println("xxx:" + xxx);
		System.out.println(JSON.toJSONString(pagedResult));
		System.out.println("-------结束------");
	}

}
