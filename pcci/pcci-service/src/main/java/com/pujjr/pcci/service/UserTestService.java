package com.pujjr.pcci.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSON;
import com.pujjr.pcci.common.pager.PagedResult;
import com.pujjr.pcci.dal.dao.UserDAO;
import com.pujjr.pcci.dal.entity.User;

/**
 * @author wen
 * @date 创建时间：2016年10月14日 下午1:43:21
 *
 */
@Service
@Transactional
public class UserTestService {

	@Autowired
	UserDAO userDAO;

	public void createNewUser() {
		User user = new User();
		user.setUserName("孙长老");
		Long id = userDAO.save(user);
		System.out.println(JSON.toJSONString(id));
	}

	public PagedResult<User> findAllUser() {
		return userDAO.findAllUser();
	}

}
