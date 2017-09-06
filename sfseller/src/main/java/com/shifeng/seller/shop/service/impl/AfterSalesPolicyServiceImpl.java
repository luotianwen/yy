package com.shifeng.seller.shop.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.shifeng.dao.BaseDao;
import com.shifeng.entity.shop.AfterSalesPolicy;
import com.shifeng.plugin.page.Page;
import com.shifeng.seller.shop.service.AfterSalesPolicyService;

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
	 * 根据店铺ID查询所有
	 * @param shopId 店铺ID
	 * @return
	 * @throws Exception
	 */
	public List<AfterSalesPolicy> findAllAfterSalesPolicyByShopId(String shopId) throws Exception{
		return (List<AfterSalesPolicy>) dao.findForList("aftersalespolicyMapper.findAllAfterSalesPolicyByShopId", shopId);
	}
	
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
	 * 修改
	 * @param aftersalespolicy
	 * @throws Exception
	 */
	public void afterSalesPolicyEdit(AfterSalesPolicy aftersalespolicy) throws Exception{
		if(aftersalespolicy.getId()==null){
			dao.save("aftersalespolicyMapper.saveAfterSalesPolicy", aftersalespolicy);
		}else{
			dao.update("aftersalespolicyMapper.updateAfterSalesPolicy", aftersalespolicy);
		}
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
