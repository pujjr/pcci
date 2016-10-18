package com.pujjr.pcci.web;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author wen
 * @date 创建时间：2016年10月11日 上午11:11:04
 *
 */
@Controller
public class IndexController extends BaseController {

	@Value("#{settings['pcci.xx']}")
	String xx;

	@Value("#{settings['pcci.xxx']}")
	String xxx;

	@RequestMapping("/index")
	public String index() {
		return "index";
	}

}
