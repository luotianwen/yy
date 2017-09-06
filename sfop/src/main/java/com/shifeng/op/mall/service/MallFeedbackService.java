package com.shifeng.op.mall.service;

import java.util.List;
import com.shifeng.entity.mall.MallFeedback;
import com.shifeng.plugin.page.Page;

/** 
 * 意见反馈(mall_feedback)接口
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2017-03-30 09:53:39 
 */  
public interface MallFeedbackService {

	/**
	 * 查询所有
	 * @param page
	 * @return
	 * @throws Exception
	 */
	public List<MallFeedback> findAllMallFeedback(Page page) throws Exception;
	
	/**
	 * 根据ID查询
	 */
	public MallFeedback findMallFeedbackById(String id) throws Exception;
	
	/**
	 * 修改
	 * @param mallfeedback
	 * @throws Exception
	 */
	public void updateMallFeedback(MallFeedback mallfeedback) throws Exception;
	
	/**
	 * 新增
	 * @param mallfeedback
	 * @throws Exception
	 */
	public void saveMallFeedback(MallFeedback mallfeedback) throws Exception;
    
    /**
	 * 删除
	 * @param id
	 * @throws Exception
	 */
	public void deleteMallFeedback(String id) throws Exception;
	
}
