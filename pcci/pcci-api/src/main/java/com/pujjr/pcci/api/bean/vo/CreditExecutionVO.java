package com.pujjr.pcci.api.bean.vo;

import java.io.Serializable;

/**
 * @author wen
 * @date 创建时间：2016年10月10日 上午10:43:35 失信被执行记录
 */

public class CreditExecutionVO implements Serializable {

	private static final long serialVersionUID = 1L;

	public static final String EXECUTION_TYPE_BAD = "BAD";

	public static final String EXECUTION_TYPE_EXECUT = "EXECUT";
	/**
	 * ID
	 */
	private Long id;

	/**
	 * 被执行类型
	 */
	private String executionType;

	/* 失信被执行记录 */

	/**
	 * 数据类型
	 */

	private String ex_bad_datatype;
	/**
	 * 执行法院
	 */

	private String ex_bad_court;
	/**
	 * 立案时间
	 */

	private String ex_bad_time;
	/**
	 * 执行案号
	 */

	private String ex_bad_casenum;
	/**
	 * 执行标的
	 */

	private String ex_bad_money;
	/**
	 * 执行依据文号
	 */

	private String ex_bad_base;
	/**
	 * 做出执行依据单位
	 */

	private String ex_bad_basecompany;
	/**
	 * 被执行人的履行情况
	 */

	private String ex_bad_performance;
	/**
	 * 失信被执行人行为具体情形
	 */

	private String ex_bad_concretesituation;
	/**
	 * 认定失信时间
	 */

	private String ex_bad_breaktime;

	/* 被执行记录 */

	/**
	 * 数据类型
	 */

	private String ex_execut_datatype;
	/**
	 * 执行法院
	 */

	private String ex_execut_court;
	/**
	 * 立案时间
	 */

	private String ex_execut_time;
	/**
	 * 执行案号
	 */

	private String ex_execut_casenum;
	/**
	 * 执行标的
	 */

	private String ex_execut_money;
	/**
	 * 案件状态
	 */

	private String ex_execut_statute;
	/**
	 * 执行依据
	 */

	private String ex_execut_basic;
	/**
	 * 做出执行依据的机构
	 */

	private String ex_execut_basiccourt;

	/**
	 * @return ID
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param ID
	 *            要设置的 id
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return 被执行类型
	 */
	public String getExecutionType() {
		return executionType;
	}

	/**
	 * @param 被执行类型
	 *            要设置的 executionType
	 */
	public void setExecutionType(String executionType) {
		this.executionType = executionType;
	}

	/**
	 * @return 失信被执行记录
	 */
	public String getEx_bad_datatype() {
		return ex_bad_datatype;
	}

	/**
	 * @param 失信被执行记录
	 *            要设置的 ex_bad_datatype
	 */
	public void setEx_bad_datatype(String ex_bad_datatype) {
		this.ex_bad_datatype = ex_bad_datatype;
	}

	/**
	 * @return 执行法院
	 */
	public String getEx_bad_court() {
		return ex_bad_court;
	}

	/**
	 * @param 执行法院
	 *            要设置的 ex_bad_court
	 */
	public void setEx_bad_court(String ex_bad_court) {
		this.ex_bad_court = ex_bad_court;
	}

	/**
	 * @return 立案时间
	 */
	public String getEx_bad_time() {
		return ex_bad_time;
	}

	/**
	 * @param 立案时间
	 *            要设置的 ex_bad_time
	 */
	public void setEx_bad_time(String ex_bad_time) {
		this.ex_bad_time = ex_bad_time;
	}

	/**
	 * @return 执行案号
	 */
	public String getEx_bad_casenum() {
		return ex_bad_casenum;
	}

	/**
	 * @param 执行案号
	 *            要设置的 ex_bad_casenum
	 */
	public void setEx_bad_casenum(String ex_bad_casenum) {
		this.ex_bad_casenum = ex_bad_casenum;
	}

	/**
	 * @return 执行标的
	 */
	public String getEx_bad_money() {
		return ex_bad_money;
	}

	/**
	 * @param 执行标的
	 *            要设置的 ex_bad_money
	 */
	public void setEx_bad_money(String ex_bad_money) {
		this.ex_bad_money = ex_bad_money;
	}

	/**
	 * @return 执行依据文号
	 */
	public String getEx_bad_base() {
		return ex_bad_base;
	}

	/**
	 * @param 执行依据文号
	 *            要设置的 ex_bad_base
	 */
	public void setEx_bad_base(String ex_bad_base) {
		this.ex_bad_base = ex_bad_base;
	}

	/**
	 * @return 做出执行依据单位
	 */
	public String getEx_bad_basecompany() {
		return ex_bad_basecompany;
	}

	/**
	 * @param 做出执行依据单位
	 *            要设置的 ex_bad_basecompany
	 */
	public void setEx_bad_basecompany(String ex_bad_basecompany) {
		this.ex_bad_basecompany = ex_bad_basecompany;
	}

	/**
	 * @return 被执行人的履行情况
	 */
	public String getEx_bad_performance() {
		return ex_bad_performance;
	}

	/**
	 * @param 被执行人的履行情况
	 *            要设置的 ex_bad_performance
	 */
	public void setEx_bad_performance(String ex_bad_performance) {
		this.ex_bad_performance = ex_bad_performance;
	}

	/**
	 * @return 失信被执行人行为具体情形
	 */
	public String getEx_bad_concretesituation() {
		return ex_bad_concretesituation;
	}

	/**
	 * @param 失信被执行人行为具体情形
	 *            要设置的 ex_bad_concretesituation
	 */
	public void setEx_bad_concretesituation(String ex_bad_concretesituation) {
		this.ex_bad_concretesituation = ex_bad_concretesituation;
	}

	/**
	 * @return 认定失信时间
	 */
	public String getEx_bad_breaktime() {
		return ex_bad_breaktime;
	}

	/**
	 * @param 认定失信时间
	 *            要设置的 ex_bad_breaktime
	 */
	public void setEx_bad_breaktime(String ex_bad_breaktime) {
		this.ex_bad_breaktime = ex_bad_breaktime;
	}

	/**
	 * @return 被执行记录
	 */
	public String getEx_execut_datatype() {
		return ex_execut_datatype;
	}

	/**
	 * @param 被执行记录
	 *            要设置的 ex_execut_datatype
	 */
	public void setEx_execut_datatype(String ex_execut_datatype) {
		this.ex_execut_datatype = ex_execut_datatype;
	}

	/**
	 * @return 执行法院
	 */
	public String getEx_execut_court() {
		return ex_execut_court;
	}

	/**
	 * @param 执行法院
	 *            要设置的 ex_execut_court
	 */
	public void setEx_execut_court(String ex_execut_court) {
		this.ex_execut_court = ex_execut_court;
	}

	/**
	 * @return 立案时间
	 */
	public String getEx_execut_time() {
		return ex_execut_time;
	}

	/**
	 * @param 立案时间
	 *            要设置的 ex_execut_time
	 */
	public void setEx_execut_time(String ex_execut_time) {
		this.ex_execut_time = ex_execut_time;
	}

	/**
	 * @return 执行案号
	 */
	public String getEx_execut_casenum() {
		return ex_execut_casenum;
	}

	/**
	 * @param 执行案号
	 *            要设置的 ex_execut_casenum
	 */
	public void setEx_execut_casenum(String ex_execut_casenum) {
		this.ex_execut_casenum = ex_execut_casenum;
	}

	/**
	 * @return 执行标的
	 */
	public String getEx_execut_money() {
		return ex_execut_money;
	}

	/**
	 * @param 执行标的
	 *            要设置的 ex_execut_money
	 */
	public void setEx_execut_money(String ex_execut_money) {
		this.ex_execut_money = ex_execut_money;
	}

	/**
	 * @return 案件状态
	 */
	public String getEx_execut_statute() {
		return ex_execut_statute;
	}

	/**
	 * @param 案件状态
	 *            要设置的 ex_execut_statute
	 */
	public void setEx_execut_statute(String ex_execut_statute) {
		this.ex_execut_statute = ex_execut_statute;
	}

	/**
	 * @return 执行依据
	 */
	public String getEx_execut_basic() {
		return ex_execut_basic;
	}

	/**
	 * @param 执行依据
	 *            要设置的 ex_execut_basic
	 */
	public void setEx_execut_basic(String ex_execut_basic) {
		this.ex_execut_basic = ex_execut_basic;
	}

	/**
	 * @return 做出执行依据的机构
	 */
	public String getEx_execut_basiccourt() {
		return ex_execut_basiccourt;
	}

	/**
	 * @param 做出执行依据的机构
	 *            要设置的 ex_execut_basiccourt
	 */
	public void setEx_execut_basiccourt(String ex_execut_basiccourt) {
		this.ex_execut_basiccourt = ex_execut_basiccourt;
	}

}
