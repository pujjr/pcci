package com.pujjr.pcci.api.service;

import com.pujjr.common.result.ResultInfo;
import com.pujjr.pcci.api.bean.request.CreditRequestData;
import com.pujjr.pcci.api.bean.vo.CreditQueryResultVO;

/**
 * @author wen
 * @date 创建时间：2016年10月28日 下午2:45:53
 *
 */
public interface CreditApi {

	/**
	 * 征信查询
	 * 
	 * @param creditRequestData
	 * @return
	 */
	public ResultInfo<CreditQueryResultVO> creditQuery(CreditRequestData creditRequestData);

	/**
	 * 征信查询,把结果转化为PDF并存到存储服务(阿里云)上
	 * 
	 * @param creditRequestData
	 * @return
	 */
	public ResultInfo<String> creditQueryAndStore(CreditRequestData creditRequestData);

}
