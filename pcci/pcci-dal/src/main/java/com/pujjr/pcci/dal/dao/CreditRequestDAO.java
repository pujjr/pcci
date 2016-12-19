package com.pujjr.pcci.dal.dao;

import java.util.Date;
import java.util.List;

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
	public PagedResult<CreditRequest> searchCreditRequest(Paged paged, Long beginCreditId, Long endCreditId, String searchText, Date stateTime, Date endTime) {
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(CreditRequest.class);
		// detachedCriteria.addOrder(Order.desc("riskLevel"));
		detachedCriteria.addOrder(Order.desc("id"));
		// 流水号
		if (beginCreditId != null) {
			detachedCriteria.add(Restrictions.ge("id", beginCreditId));
		}
		if (endCreditId != null) {
			detachedCriteria.add(Restrictions.le("id", endCreditId));
		}
		// 时间格式
		if (stateTime != null) {
			detachedCriteria.add(Restrictions.ge("requestDate", stateTime));
		}
		if (endTime != null) {
			detachedCriteria.add(Restrictions.le("requestDate", endTime));
		}
		// 搜索关键字 三要素 姓名 手机号 证件号
		if (StringUtils.isNotBlank(searchText)) {
			Disjunction disjunction = Restrictions.disjunction();
			disjunction.add(Restrictions.like("mobileNo", searchText, MatchMode.ANYWHERE).ignoreCase());
			disjunction.add(Restrictions.like("name", searchText, MatchMode.ANYWHERE).ignoreCase());
			disjunction.add(Restrictions.like("idNo", searchText, MatchMode.ANYWHERE).ignoreCase());
			detachedCriteria.add(disjunction);
		}
		return findByPaged(paged, detachedCriteria);
	}

	/**
	 * 根据条件查询全部征信请求记录
	 * 
	 * @param paged
	 * @param beginCreditId
	 * @param endCreditId
	 * @param searchText
	 * @return
	 */
	public List<CreditRequest> searchCreditRequest(Long beginCreditId, Long endCreditId, String searchText, Date stateTime, Date endTime) {
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(CreditRequest.class);
		detachedCriteria.addOrder(Order.desc("id"));
		// 流水号
		if (beginCreditId != null) {
			detachedCriteria.add(Restrictions.ge("id", beginCreditId));
		}
		if (endCreditId != null) {
			detachedCriteria.add(Restrictions.le("id", endCreditId));
		}
		// 时间格式
		if (stateTime != null) {
			detachedCriteria.add(Restrictions.ge("requestDate", stateTime));
		}
		if (endTime != null) {
			detachedCriteria.add(Restrictions.le("requestDate", endTime));
		}
		// 搜索关键字 三要素 姓名 手机号 证件号
		if (StringUtils.isNotBlank(searchText)) {
			Disjunction disjunction = Restrictions.disjunction();
			disjunction.add(Restrictions.like("mobileNo", searchText, MatchMode.ANYWHERE).ignoreCase());
			disjunction.add(Restrictions.like("name", searchText, MatchMode.ANYWHERE).ignoreCase());
			disjunction.add(Restrictions.like("idNo", searchText, MatchMode.ANYWHERE).ignoreCase());
			detachedCriteria.add(disjunction);
		}
		return findAll(detachedCriteria);
	}

	/**
	 * 找到所有的错误征信
	 * 
	 * @return
	 */
	public List<CreditRequest> findErrorCreditRequest() {
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(CreditRequest.class);
		detachedCriteria.addOrder(Order.desc("id"));
		detachedCriteria.add(Restrictions.eq("errStatus", CreditRequest.ERROR_STATUS_FAIL));
		return findAll(detachedCriteria);
	}

	/**
	 * 根据三要素查询征信
	 * 
	 * @param name
	 * @param mobileNo
	 * @param idNo
	 * @return
	 */
	public CreditRequest findCreditByThreeElement(String name, String mobileNo, String idNo) {
		String hql = "from CreditRequest where name = ? and mobileNo = ? and idNo = ?";
		return findUnique(hql, name, mobileNo, idNo);
	}
}
