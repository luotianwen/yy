package com.shifeng.op.system.service;

import java.util.List;
import com.shifeng.entity.system.ExpertAdvice;
import com.shifeng.plugin.page.Page;

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
	
	/**
	 * 修改
	 * @param expertadvice
	 * @throws Exception
	 */
	public void updateExpertAdvice(ExpertAdvice expertadvice) throws Exception;
	
	/**
	 * 新增
	 * @param dto
	 * @throws Exception
	 */
	public void saveExpertAdvice(ExpertAdvice expertadvice) throws Exception;

 	//删除
    void deleteExpertAdvice(ExpertAdvice expertadvice) throws Exception;
}
