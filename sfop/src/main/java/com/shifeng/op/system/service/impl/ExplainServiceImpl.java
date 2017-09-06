package com.shifeng.op.system.service.impl;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.shifeng.dao.BaseDao;
import com.shifeng.entity.system.Explain;
import com.shifeng.op.system.service.ExplainService;
import com.shifeng.plugin.page.Page;

/** 
 * 商城说明表(s_explain)接口实现类
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2017-02-22 17:11:57 
 */  
@Service("explainServiceImpl")
public class ExplainServiceImpl implements ExplainService{

	@Resource(name = "baseDaoImpl")
	private BaseDao dao;
	
	/**
	 * 查询所有
	 * @param page
	 * @return
	 * @throws Exception
	 */
	public List<Explain> findAllExplain(Page page) throws Exception{
		return (List<Explain>) dao.findForList("explainMapper.findAllExplainPage", page);
	}
	
	/**
	 * 根据ID查询
	 */
	public Explain findExplainById(String id) throws Exception{
		return (Explain) dao.findForObject("explainMapper.findExplainById", id);
	}
	
	/**
	 * 新增
	 * @param dto
	 * @throws Exception
	 */
	public void saveExplain(Explain explain) throws Exception{
		dao.save("explainMapper.saveExplain", explain);
	}

	@Override
	public void deleteExplain(Explain explain) throws Exception {
		dao.delete("explainMapper.deleteExplain", explain);
	}

	/**
	 * 修改
	 * @param explain
	 * @throws Exception
	 */
	public void updateExplain(Explain explain) throws Exception{
		dao.update("explainMapper.updateExplain", explain);
	}
	
	
}
