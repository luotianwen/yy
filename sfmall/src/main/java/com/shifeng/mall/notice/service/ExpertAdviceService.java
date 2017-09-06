package com.shifeng.mall.notice.service;

import com.shifeng.entity.system.ExpertAdvice;
import com.shifeng.plugin.page.Page;

import java.util.List;

/** 
 * 专家建议(s_expert_advice)接口
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2017-02-22 17:11:57 
 */  
public interface ExpertAdviceService {

	/**
	 * 查询所有
	 * @param page
	 * @return
	 * @throws Exception
	 */
	public List<ExpertAdvice> findAllExpertAdvice(Page page) throws Exception;
	
	/**
	 * 根据ID查询
	 */
	public ExpertAdvice findExpertAdviceById(String id) throws Exception;

}
