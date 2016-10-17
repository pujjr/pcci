package com.pujjr.pcci.dal.dao;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;
import com.pujjr.pcci.dal.entity.User;

/**
 * 创建时间：2015-2-6 下午3:31:07
 * 
 * @author wen
 * @version 1.0
 */
@ActiveProfiles("dev")
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:spring/pcci-web.xml", "classpath:config/spring-dal.xml", "classpath:spring-dal-hibernate.xml" })
public class TestUserDAO {

	private static final Logger LOGGER = Logger.getLogger(Test.class);

	// @Value("${server.database-user}")
	// private String databaseUser;

	@Resource
	private UserDAO userService;

	@Test
	public void save() {
		try {
			User user = new User();
			user.setUserName("wen");
			String id = userService.save(user);
			LOGGER.info(JSON.toJSONString(id));
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}

}