package com.pujjr.pcci.service.credit;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.springframework.stereotype.Service;

import com.pujjr.common.result.ResultInfo;
import com.pujjr.common.type.IdentityType;
import com.pujjr.common.type.credit.QueryReasonType;
import com.pujjr.common.utils.document.ExcelUtils;
import com.pujjr.pcci.dal.entity.CreditQueryResult;
import com.pujjr.pcci.dal.entity.CreditRequest;
import com.pujjr.pcci.service.ParameterizedBaseService;

/**
 * @author wen
 * @date 创建时间：2016年10月19日 上午10:42:27 序列化为pdf文件服务
 *
 */
@Service
public class ExcelService extends ParameterizedBaseService<ExcelService> {
	public final static String DEFAULT_ERROR_REMARK = "数据错误";

	/**
	 * 根据征信结果 生成excel表文件
	 * 
	 * @param creditQueryResultList
	 * @return
	 */
	public ResultInfo<byte[]> writeCreditExcelFile(List<CreditQueryResult> creditQueryResultList) {

		ResultInfo<byte[]> resultInfo = new ResultInfo<>();
		if (creditQueryResultList == null) {
			return resultInfo.fail("征信查询操作无结果");
		}
		String[] title = { "流水号", "查询时间", "姓名", "手机号", "证件号", "证件类型", "查询原因", "授权码", "授权时间", "风险级别", "对外投资", "犯罪记录", "备注" };
		String[][] excelData = new String[creditQueryResultList.size()][title.length];
		for (int i = 0; i < creditQueryResultList.size(); i++) {
			CreditQueryResult creditQueryResult = creditQueryResultList.get(i);
			if (creditQueryResult == null) {
				return resultInfo.fail("征信查询操作请求保存失败");
			}
			CreditRequest creditRequest = creditQueryResult.getCreditRequest();
			if (creditRequest == null) {
				return resultInfo.fail("征信查询操作请求保存失败");
			}
			String[] rowValue = new String[title.length];
			int index = 0;
			rowValue[index++] = creditRequest.getCreditId();
			rowValue[index++] = DateFormatUtils.format(creditRequest.getRequestDate(), "yyyy-MM-dd");
			rowValue[index++] = creditRequest.getName();
			rowValue[index++] = creditRequest.getMobileNo();
			rowValue[index++] = creditRequest.getIdNo();
			rowValue[index++] = IdentityType.contains(creditRequest.getIdType()) ? IdentityType.fromCode(creditRequest.getIdType()).getRemark() : DEFAULT_ERROR_REMARK;
			rowValue[index++] = QueryReasonType.contains(creditRequest.getReasonCode()) ? QueryReasonType.fromCode(creditRequest.getReasonCode()).getRemark() : DEFAULT_ERROR_REMARK;
			rowValue[index++] = creditRequest.getEntityAuthCode();
			rowValue[index++] = creditRequest.getEntityAuthDate();
			// 风险级别
			String riskLevelRemark = DEFAULT_ERROR_REMARK;
			if (CreditRequest.RISK_LEVEL_NONE == creditRequest.getRiskLevel()) {
				riskLevelRemark = "无数据";
			} else if (CreditRequest.RISK_LEVEL_LOW == creditRequest.getRiskLevel()) {
				riskLevelRemark = "低风险";
			} else if (CreditRequest.RISK_LEVEL_HIGH == creditRequest.getRiskLevel()) {
				riskLevelRemark = "高风险";
			}
			rowValue[index++] = riskLevelRemark;
			// 对外投资
			rowValue[index++] = CreditRequest.INVEST_YES == creditRequest.getInvestInfo() ? "有" : "无";
			// 犯罪记录
			rowValue[index++] = CreditRequest.CRIMINAL_YES == creditRequest.getCriminalRecord() ? "有" : "无";
			rowValue[index++] = StringUtils.defaultString(creditRequest.getErrMsg());
			excelData[i] = rowValue;
		}
		byte[] byteArray = ExcelUtils.writeExcelFile(title, excelData);
		return resultInfo.success(byteArray);
	}

}
