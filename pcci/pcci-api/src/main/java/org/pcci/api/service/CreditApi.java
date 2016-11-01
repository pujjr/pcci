package org.pcci.api.service;

import org.pcci.api.bean.request.CreditRequestData;
import org.pcci.api.bean.vo.CreditCrimeInfoVO;
import org.pcci.api.bean.vo.CreditQueryResultVO;

import com.pujjr.common.result.ResultInfo;

/**
 * @author wen
 * @date 创建时间：2016年10月28日 下午2:45:53
 *
 */
public interface CreditApi {

	public CreditCrimeInfoVO getCreditCrimeInfo();

	public String getTokenid();

	public CreditQueryResultVO getCreditQueryResult();

	/**
	 * 征信查询
	 * 
	 * @param creditRequestData
	 * @return
	 */
	public ResultInfo<CreditQueryResultVO> creditQuery(CreditRequestData creditRequestData);

}
