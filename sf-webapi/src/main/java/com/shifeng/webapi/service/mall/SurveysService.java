package com.shifeng.webapi.service.mall;

import com.shifeng.dto.mall.MallFeedbackDTO;

/**
 * 用户反馈调查接口
 * @author WinZhong
 *
 */
public interface SurveysService {

	/**
	 * 添加反馈意见
	 * @param mallFeedback
	 */
	boolean addFeedback(MallFeedbackDTO mallFeedback);
	
	

}
