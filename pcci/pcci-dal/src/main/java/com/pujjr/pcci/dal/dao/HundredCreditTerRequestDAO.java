package com.pujjr.pcci.dal.dao;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.pujjr.pcci.common.pager.Paged;
import com.pujjr.pcci.common.pager.PagedResult;
import com.pujjr.pcci.dal.entity.HundredCreditTerRequest;

/**
 * @author wen
 * @date 创建时间：2016年10月17日 下午4:16:13
 *
 */
@Repository
public class HundredCreditTerRequestDAO extends ParameterizedBaseDAO<HundredCreditTerRequest, Long> {
	/**
	 * 根据调用请求用户工号,被查询人的姓名/手机号/身份证 查询批量调用请求记录
	 * 
	 * @param paged
	 * @param requestUserId
	 * @param name
	 * @param cell
	 * @param id
	 * @return
	 */
	public PagedResult<HundredCreditTerRequest> searchRequestResultRecord(Paged paged, String requestUserId, String name, String cell, String id) {
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(HundredCreditTerRequest.class);
		detachedCriteria.addOrder(Order.desc("requestId"));
		if (StringUtils.isNotBlank(requestUserId)) {
			detachedCriteria.add(Restrictions.eq("requestUserId", requestUserId));
		}
		if (StringUtils.isNotBlank(name)) {
			detachedCriteria.add(Restrictions.eq("name", name));
		}
		if (StringUtils.isNotBlank(cell)) {
			detachedCriteria.add(Restrictions.eq("cell", cell));
		}
		if (StringUtils.isNotBlank(id)) {
			detachedCriteria.add(Restrictions.eq("id", id));
		}
		return findByPaged(paged, detachedCriteria);
	}
}
