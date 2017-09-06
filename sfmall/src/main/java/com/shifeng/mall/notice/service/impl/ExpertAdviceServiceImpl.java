package com.shifeng.mall.notice.service.impl;

import com.shifeng.dao.BaseDao;
import com.shifeng.entity.system.ExpertAdvice;
import com.shifeng.mall.notice.service.ExpertAdviceService;
import com.shifeng.plugin.page.Page;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/** 
 * 专家建议(s_expert_advice)接口实现类
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2017-02-22 17:11:57 
 */  
@Service("expertadviceServiceImpl")
public class ExpertAdviceServiceImpl implements ExpertAdviceService {

	@Resource(name = "baseDaoImpl")
	private BaseDao dao;
	
	/**
	 * 查询所有
	 * @param page
	 * @return
	 * @throws Exception
	 */
	public List<ExpertAdvice> findAllExpertAdvice(Page page) throws Exception{
		return (List<ExpertAdvice>) dao.findForList("expertadviceMapper.findAllExpertAdvicePage", page);
	}
	
	/**
	 * 根据ID查询
	 */
	public ExpertAdvice findExpertAdviceById(String id) throws Exception{
		return (ExpertAdvice) dao.findForObject("expertadviceMapper.findExpertAdviceById", id);
	}

	
}
