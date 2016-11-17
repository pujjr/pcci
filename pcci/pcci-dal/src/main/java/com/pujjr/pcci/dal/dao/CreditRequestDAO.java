package com.pujjr.pcci.dal.dao;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Disjunction;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.pujjr.common.pager.Paged;
import com.pujjr.common.pager.PagedResult;
import com.pujjr.pcci.dal.entity.CreditRequest;

/**
 * @author wen
 * @date 创建时间：2016年10月17日 下午4:16:13
 *
 */
@Repository
public class CreditRequestDAO extends ParameterizedBaseDAO<CreditRequest, Long> {
	/**
	 * 根据条件查询征信请求记录
	 * 
	 * @param paged
	 * @param beginCreditId
	 * @param endCreditId
	 * @param searchText
	 * @return
	 */
	public PagedResult<CreditRequest> searchCreditRequest(Paged paged, Long beginCreditId, Long endCreditId, String searchText) {
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(CreditRequest.class);
		detachedCriteria.addOrder(Order.desc("id"));
		if (beginCreditId != null) {
			detachedCriteria.add(Restrictions.ge("id", beginCreditId));
		}
		if (endCreditId != null) {
			detachedCriteria.add(Restrictions.le("id", endCreditId));
		}
		if (StringUtils.isNotBlank(searchText)) {
			Disjunction disjunction = Restrictions.disjunction();
			disjunction.add(Restrictions.like("mobileNo", searchText, MatchMode.ANYWHERE).ignoreCase());
			disjunction.add(Restrictions.like("name", searchText, MatchMode.ANYWHERE).ignoreCase());
			disjunction.add(Restrictions.like("idNo", searchText, MatchMode.ANYWHERE).ignoreCase());
			detachedCriteria.add(disjunction);
		}
		return findByPaged(paged, detachedCriteria);
	}
}
