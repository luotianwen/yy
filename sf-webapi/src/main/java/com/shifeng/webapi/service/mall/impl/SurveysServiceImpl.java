package com.shifeng.webapi.service.mall.impl;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.shifeng.dto.mall.MallFeedbackDTO;
import com.shifeng.provide.mall.service.MallFeedbackService;
import com.shifeng.response.ReqResponse;
import com.shifeng.webapi.service.mall.SurveysService;

/**
 * 用户反馈调查接口
 * @author WinZhong
 *
 */
@Service("surveysServiceImpl")
public class SurveysServiceImpl implements SurveysService{

	protected Logger logger = Logger.getLogger(this.getClass());
	
	@Resource(name = "mallFeedbackService")
	protected MallFeedbackService mallFeedbackService;
	


	/**
	 * 添加反馈意见
	 * @param mallFeedback
	 */
	public boolean addFeedback(MallFeedbackDTO mallFeedback) {
		try {
			ReqResponse<String> result = mallFeedbackService.addFeedback(mallFeedback);
			if(result.getCode() == 0){
				return true;
			}
		} catch (Exception e) {
			logger.error("【添加反馈意见】出错：", e);
		}
		return false;
	}
	

}
