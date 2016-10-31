package com.pujjr.common.pager;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 带分页的结果集
 * 
 * @author baiqi.lp
 *
 * @param <T>
 */
public class PagedResult<T> implements Serializable {

	/***/
	private static final long serialVersionUID = -6042792769793841375L;

	private Paged paged;
	private List<T> results;

	public PagedResult() {

	}

	public PagedResult(Paged paged, List<T> results) {
		this.paged = paged;
		this.results = results;
	}

	public static <T> PagedResult<T> createEmptyResult() {
		PagedResult<T> result = new PagedResult<T>();
		result.setResults(new ArrayList<T>(0));
		Paged paged = new Paged();
		paged.setItems(0);
		paged.setPage(1);
		paged.setPageSize(1);
		result.setPaged(paged);
		return result;
	}

	public Paged getPaged() {
		return paged;
	}

	public void setPaged(Paged paged) {
		this.paged = paged;
	}

	public List<T> getResults() {
		return results;
	}

	public void setResults(List<T> results) {
		this.results = results;
	}

	public int getSize() {
		if (results == null) {
			return 0;
		}
		return results.size();
	}
}
