package com.shifeng.provide.mall.service.impl;

import javax.annotation.Resource;

import org.apache.log4j.Logger;

import com.alibaba.dubbo.config.annotation.Service;
import com.shifeng.dto.mall.MallFeedbackDTO;
import com.shifeng.provide.mall.dao.MallFeedbackDao;
import com.shifeng.provide.mall.service.MallFeedbackService;
import com.shifeng.response.ReqResponse;

/**
 * 意见反馈Service 接口 实现
 * @author WinZhong
 *
 */
@Service(timeout=1200000)
public class MallFeedbackServiceImpl implements MallFeedbackService{

    private Logger logger = Logger.getLogger(this.getClass());

	@Resource(name = "mallFeedbackDao")
	private MallFeedbackDao mallFeedbackDao;

	
	
	/**
	 * 添加反馈
	 * @param mallFeedback
	 * @return
	 */
	public ReqResponse<String> addFeedback(MallFeedbackDTO mallFeedback) {
		ReqResponse<String> req = new ReqResponse<String>();
		try {
			mallFeedbackDao.addFeedback(mallFeedback,req);
			return req;
		} catch (Exception e) {
			logger.error("【添加反馈】出错：", e);
			req.setCode(1);
			req.setMsg("【添加反馈】异常");
			return req;
		}
	}
	
	
	
	
}
