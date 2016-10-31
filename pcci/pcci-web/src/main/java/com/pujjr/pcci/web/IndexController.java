package com.pujjr.pcci.web;

import org.pcci.api.bean.request.CreditRequestData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pujjr.pcci.service.credit.CreditService;

/**
 * @author wen
 * @date 创建时间：2016年10月11日 上午11:11:04
 *
 */
@Controller
public class IndexController extends BaseController {

	@Autowired
	CreditService creditService;

	@RequestMapping("/index")
	public String index() {
		return "index";
	}

	@RequestMapping("/credit")
	@ResponseBody
	public Object credit() {
		return creditService.creditQuery(new CreditRequestData());

	}

}
