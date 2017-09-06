package com.shifeng.provide.mall.service;

import com.shifeng.dto.mall.MallFeedbackDTO;
import com.shifeng.response.ReqResponse;

/**
 * 意见反馈Service 接口
 * @author WinZhong
 *
 */
public interface MallFeedbackService {
	
	
	/**
	 * 添加反馈
	 * @param mallFeedback
	 * @return
	 */
	ReqResponse<String> addFeedback(MallFeedbackDTO mallFeedback);
	
	
	

}
