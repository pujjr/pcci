package com.pujjr.pcci.dal.dao;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.CriteriaSpecification;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.hibernate.metadata.ClassMetadata;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import com.pujjr.common.pager.Paged;
import com.pujjr.common.pager.PagedResult;

/**
 * @author wen 基础DAO
 * @date 创建时间：2016年10月14日 上午11:19:11
 *
 */
@SuppressWarnings("unchecked")
@Transactional(rollbackFor = Exception.class)
public abstract class BaseDAO {

	@Resource
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public Session getSession() {
		// 事务必须是开启的(Required)，否则获取不到
		return sessionFactory.getCurrentSession();
	}

	public <T> T get(Class<T> entityClass, Serializable pk) {
		Assert.notNull(pk, "pk is required");
		return (T) getSession().get(entityClass, pk);
	}

	public <T> T load(Class<T> entityClass, Serializable pk) {
		Assert.notNull(pk, "pk is required");
		return (T) getSession().load(entityClass, pk);
	}

	public <T> List<T> getAll(Class<T> entityClass) {
		ClassMetadata classMetadata = getSessionFactory().getClassMetadata(entityClass);
		String hql = "from " + classMetadata.getEntityName();
		return getSession().createQuery(hql).list();
	}

	public <T> Long getTotalCount(Class<T> entityClass) {
		ClassMetadata classMetadata = getSessionFactory().getClassMetadata(entityClass);
		final String hql = "select count(*) from " + classMetadata.getEntityName();
		return (Long) getSession().createQuery(hql).uniqueResult();
	}

	public <T> T save(Object entity) {
		Assert.notNull(entity, "entity is required");
		return (T) getSession().save(entity);
	}

	public void saveOrUpdate(Object entity) {
		Assert.notNull(entity, "entity is required");
		getSession().saveOrUpdate(entity);
	}

	public void update(Object entity) {
		Assert.notNull(entity, "entity is required");
		getSession().update(entity);
	}

	public void delete(Object entity) {
		Assert.notNull(entity, "entity is required");
		getSession().delete(entity);
	}

	public <T> T findUnique(String hql, Object... params) {
		Query query = getSession().createQuery(hql);
		if (params != null) {
			for (int i = 0; i < params.length; i++) {
				query.setParameter(i, params[i]);
			}
		}
		List<T> list = query.list();
		if (list.isEmpty()) {
			return null;
		}
		if (list.size() > 1) {
			throw new RuntimeException("result not unique!");
		}
		return list.get(0);
	}

	public <T> PagedResult<T> findByPaged(Class<T> entityClass, Paged paged) {
		if (paged == null) {
			paged = new Paged();
		}
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(entityClass);
		return findByPaged(paged, detachedCriteria);
	}

	public <T> PagedResult<T> findAll(final DetachedCriteria detachedCriteria) {
		detachedCriteria.setResultTransformer(CriteriaSpecification.ROOT_ENTITY);
		Criteria criteria = detachedCriteria.getExecutableCriteria(getSession());
		criteria.setProjection(null);
		PagedResult<T> result = new PagedResult<T>();
		result.setResults(criteria.list());
		return result;
	}

	public <T> PagedResult<T> findByPaged(final Paged p, final DetachedCriteria detachedCriteria) {
		Paged paged = p;
		if (paged == null) {
			paged = new Paged();
		}

		Integer pageSize = paged.getPageSize();

		detachedCriteria.setResultTransformer(CriteriaSpecification.ROOT_ENTITY);
		Criteria criteria = detachedCriteria.getExecutableCriteria(getSession());

		Long totalCount = (Long) criteria.setProjection(Projections.rowCount()).uniqueResult();

		criteria.setProjection(null);
		criteria.setFirstResult(paged.getOffset());
		criteria.setMaxResults(pageSize);
		paged.setItems(totalCount.intValue());

		PagedResult<T> result = new PagedResult<T>();
		result.setPaged(paged);
		result.setResults(criteria.list());

		return result;
	}

	/**
	 * 不建议使用，因为容易导致因HQL字段顺序变动引发的SQL错误
	 * 
	 * @param hql
	 * @param params
	 * @param <T>
	 * @return
	 */
	@Deprecated
	public <T> List<T> findObjects(String hql, Object... params) {
		Query query = getSession().createQuery(hql);
		if (params != null) {
			for (int i = 0; i < params.length; i++) {
				query.setParameter(i, params[i]);
			}
		}
		List<T> list = query.list();
		return list;
	}

	public void flush() {
		this.getSession().flush();
	}
}