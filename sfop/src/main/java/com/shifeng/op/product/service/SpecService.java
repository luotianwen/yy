package com.shifeng.op.product.service;

import java.util.List;
import com.shifeng.entity.product.Spec;
import com.shifeng.plugin.page.Page;

/** 
 * 规格表(p_spec)接口
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2017-02-24 11:14:12 
 */  
public interface SpecService {

	/**
	 * 查询所有
	 * @param page
	 * @return
	 * @throws Exception
	 */
	public List<Spec> findAllSpec(Page page) throws Exception;
	
	/**
	 * 根据ID查询
	 */
	public Spec findSpecById(String id) throws Exception;
	
	/**
	 * 修改
	 * @param spec
	 * @throws Exception
	 */
	public void updateSpec(Spec spec) throws Exception;
	
	/**
	 * 新增
	 * @param spec
	 * @throws Exception
	 */
	public void saveSpec(Spec spec) throws Exception;
    
    /**
	 * 删除
	 * @param id
	 * @throws Exception
	 */
	public void deleteSpec(String id) throws Exception;
	
}
