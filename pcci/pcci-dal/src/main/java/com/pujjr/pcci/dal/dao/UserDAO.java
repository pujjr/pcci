package com.pujjr.pcci.dal.dao;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.pujjr.pcci.common.pager.PagedResult;
import com.pujjr.pcci.dal.entity.User;

/**
 * @author wen
 * @date 创建时间：2016年10月14日 上午11:36:37
 *
 */
@Repository
public class UserDAO extends ParameterizedBaseDAO<UserDAO, Long> {

	public PagedResult<User> findAllUser() {
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(User.class);
		detachedCriteria.addOrder(Order.desc("id"));
		detachedCriteria.add(Restrictions.eq("userName", "wen"));
		return findAll(detachedCriteria);
	}
}
