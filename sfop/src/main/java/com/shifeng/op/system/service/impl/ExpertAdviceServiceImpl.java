package com.shifeng.op.system.service.impl;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.shifeng.dao.BaseDao;
import com.shifeng.entity.system.ExpertAdvice;
import com.shifeng.op.system.service.ExpertAdviceService;
import com.shifeng.plugin.page.Page;

/** 
 * 专家建议(s_expert_advice)接口实现类
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2017-02-22 17:11:57 
 */  
@Service("expertadviceServiceImpl")
public class ExpertAdviceServiceImpl implements ExpertAdviceService{

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
	
	/**
	 * 新增
	 * @param dto
	 * @throws Exception
	 */
	public void saveExpertAdvice(ExpertAdvice expertadvice) throws Exception{
		dao.save("expertadviceMapper.saveExpertAdvice", expertadvice);
	}

	@Override
	public void deleteExpertAdvice(ExpertAdvice expertadvice) throws Exception {
		dao.delete("expertadviceMapper.deleteExpertAdvice", expertadvice);
	}

	/**
	 * 修改
	 * @param expertadvice
	 * @throws Exception
	 */
	public void updateExpertAdvice(ExpertAdvice expertadvice) throws Exception{
		dao.update("expertadviceMapper.updateExpertAdvice", expertadvice);
	}
	
	
}
