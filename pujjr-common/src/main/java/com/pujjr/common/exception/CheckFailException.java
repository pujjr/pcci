package com.pujjr.common.exception;

/**
 * @author wen
 * @date 创建时间：2016年11月8日 上午10:36:38
 *
 */
public class CheckFailException extends Exception {

	String code;

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CheckFailException() {
		super();
	}

	public CheckFailException(String message) {
		super(message);
	}

	public CheckFailException(String message, Throwable cause) {
		super(message, cause);
	}

	public CheckFailException(String code, String message) {
		super(message);
		this.code = code;
	}

	public CheckFailException(String code, String message, Throwable cause) {
		super(message, cause);
		this.code = code;
	}

	/**
	 * @param code
	 *            要设置的 code
	 */
	public void setCode(String code) {
		this.code = code;
	}

}
