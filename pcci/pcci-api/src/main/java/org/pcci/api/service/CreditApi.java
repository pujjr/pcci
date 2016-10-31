package org.pcci.api.service;

import org.pcci.api.bean.vo.CreditCrimeInfoVO;
import org.pcci.api.bean.vo.CreditQueryResultVO;

/**
 * @author wen
 * @date 创建时间：2016年10月28日 下午2:45:53
 *
 */
public interface CreditApi {

	public CreditCrimeInfoVO getCreditCrimeInfo();

	public String getTokenid();

	public CreditQueryResultVO getCreditQueryResult();

}
