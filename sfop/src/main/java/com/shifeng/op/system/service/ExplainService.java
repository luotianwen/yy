package com.shifeng.op.system.service;

import java.util.List;
import com.shifeng.entity.system.Explain;
import com.shifeng.plugin.page.Page;

/** 
 * 商城说明表(s_explain)接口
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2017-02-22 17:11:57 
 */  
public interface ExplainService {

	/**
	 * 查询所有
	 * @param page
	 * @return
	 * @throws Exception
	 */
	public List<Explain> findAllExplain(Page page) throws Exception;
	
	/**
	 * 根据ID查询
	 */
	public Explain findExplainById(String id) throws Exception;
	
	/**
	 * 修改
	 * @param explain
	 * @throws Exception
	 */
	public void updateExplain(Explain explain) throws Exception;
	
	/**
	 * 新增
	 * @param dto
	 * @throws Exception
	 */
	public void saveExplain(Explain explain) throws Exception;


    void deleteExplain(Explain explain)throws Exception;
}
