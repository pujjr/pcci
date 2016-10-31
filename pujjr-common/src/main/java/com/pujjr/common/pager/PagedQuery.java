package com.pujjr.common.pager;

/**
 * 分页查询,不直接使用Paged的原因是防止Paged其它属性被WEB注入 同时因为Paged存在重载函数(setPageSize) WEB注入时无法注入
 * 
 * @author baiqi.lp
 * 
 */
public class PagedQuery {

	// 默认第1页
	private int page = 1;

	// 每页大小，默认20项
	private int pageSize = 20;

	// 每页最大值
	private final int maxPageSize = 200;

	public Paged getPaged() {
		Paged paged = new Paged();
		paged.setPage(page);
		if (pageSize > maxPageSize) {
			pageSize = maxPageSize;
		}
		paged.setPageSize(pageSize);
		return paged;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getMaxPageSize() {
		return maxPageSize;
	}
}
