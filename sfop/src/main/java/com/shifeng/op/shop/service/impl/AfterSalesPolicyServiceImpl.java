package com.shifeng.op.shop.service.impl;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.shifeng.dao.BaseDao;
import com.shifeng.entity.shop.AfterSalesPolicy;
import com.shifeng.op.shop.service.AfterSalesPolicyService;
import com.shifeng.plugin.page.Page;

/** 
 * 售后政策(s_after_sales_policy)接口实现类
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2017-02-24 10:46:24 
 */  
@Service("aftersalespolicyServiceImpl")
public class AfterSalesPolicyServiceImpl implements AfterSalesPolicyService{

	@Resource(name = "baseDaoImpl")
	private BaseDao dao;
	
	/**
	 * 查询所有
	 * @param page
	 * @return
	 * @throws Exception
	 */
	public List<AfterSalesPolicy> findAllAfterSalesPolicy(Page page) throws Exception{
		return (List<AfterSalesPolicy>) dao.findForList("aftersalespolicyMapper.findAllAfterSalesPolicyPage", page);
	}
	
	/**
	 * 根据ID查询
	 */
	public AfterSalesPolicy findAfterSalesPolicyById(String id) throws Exception{
		return (AfterSalesPolicy) dao.findForObject("aftersalespolicyMapper.findAfterSalesPolicyById", id);
	}
	
	/**
	 * 新增
	 * @param aftersalespolicy
	 * @throws Exception
	 */
	public void saveAfterSalesPolicy(AfterSalesPolicy aftersalespolicy) throws Exception{
		dao.save("aftersalespolicyMapper.saveAfterSalesPolicy", aftersalespolicy);
	}
	
	/**
	 * 修改
	 * @param aftersalespolicy
	 * @throws Exception
	 */
	public void updateAfterSalesPolicy(AfterSalesPolicy aftersalespolicy) throws Exception{
		dao.update("aftersalespolicyMapper.updateAfterSalesPolicy", aftersalespolicy);
	}
	
	/**
	 * 删除
	 * @param id
	 * @throws Exception
	 */
	public void deleteAfterSalesPolicy(String id) throws Exception{
		dao.delete("aftersalespolicyMapper.deleteAfterSalesPolicy", id);
	}
	
}
