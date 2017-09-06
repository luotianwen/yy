package com.shifeng.op.product.service.impl;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.shifeng.dao.BaseDao;
import com.shifeng.entity.product.Spec;
import com.shifeng.op.product.service.SpecService;
import com.shifeng.plugin.page.Page;

/** 
 * 规格表(p_spec)接口实现类
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2017-02-24 11:14:12 
 */  
@Service("specServiceImpl")
public class SpecServiceImpl implements SpecService{

	@Resource(name = "baseDaoImpl")
	private BaseDao dao;
	
	/**
	 * 查询所有
	 * @param page
	 * @return
	 * @throws Exception
	 */
	public List<Spec> findAllSpec(Page page) throws Exception{
		return (List<Spec>) dao.findForList("specMapper.findAllSpecPage", page);
	}
	
	/**
	 * 根据ID查询
	 */
	public Spec findSpecById(String id) throws Exception{
		return (Spec) dao.findForObject("specMapper.findSpecById", id);
	}
	
	/**
	 * 新增
	 * @param spec
	 * @throws Exception
	 */
	public void saveSpec(Spec spec) throws Exception{
		dao.save("specMapper.saveSpec", spec);
	}
	
	/**
	 * 修改
	 * @param spec
	 * @throws Exception
	 */
	public void updateSpec(Spec spec) throws Exception{
		dao.update("specMapper.updateSpec", spec);
	}
	
	/**
	 * 删除
	 * @param id
	 * @throws Exception
	 */
	public void deleteSpec(String id) throws Exception{
		dao.delete("specMapper.deleteSpec", id);
	}
	
}
