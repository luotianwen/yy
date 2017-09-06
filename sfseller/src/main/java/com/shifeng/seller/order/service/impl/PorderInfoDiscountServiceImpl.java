package com.shifeng.seller.order.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.shifeng.dao.BaseDao;
import com.shifeng.entity.order.PorderInfoDiscount;
import com.shifeng.plugin.page.Page;
import com.shifeng.seller.order.service.PorderInfoDiscountService;

/** 
 * 父订单折扣表(o_porderInfo_discount)接口实现类
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2017-02-24 10:43:55 
 */  
@Service("porderInfodiscountServiceImpl")
public class PorderInfoDiscountServiceImpl implements PorderInfoDiscountService{

	@Resource(name = "baseDaoImpl")
	private BaseDao dao;
	
	/**
	 * 查询所有
	 * @param page
	 * @return
	 * @throws Exception
	 */
	public List<PorderInfoDiscount> findAllPorderInfoDiscount(Page page) throws Exception{
		return (List<PorderInfoDiscount>) dao.findForList("porderInfodiscountMapper.findAllPorderInfoDiscountPage", page);
	}
	
	/**
	 * 根据ID查询
	 */
	public PorderInfoDiscount findPorderInfoDiscountById(String id) throws Exception{
		return (PorderInfoDiscount) dao.findForObject("porderInfodiscountMapper.findPorderInfoDiscountById", id);
	}
	
	/**
	 * 新增
	 * @param porderInfodiscount
	 * @throws Exception
	 */
	public void savePorderInfoDiscount(PorderInfoDiscount porderInfodiscount) throws Exception{
		dao.save("porderInfodiscountMapper.savePorderInfoDiscount", porderInfodiscount);
	}
	
	/**
	 * 修改
	 * @param porderInfodiscount
	 * @throws Exception
	 */
	public void updatePorderInfoDiscount(PorderInfoDiscount porderInfodiscount) throws Exception{
		dao.update("porderInfodiscountMapper.updatePorderInfoDiscount", porderInfodiscount);
	}
	
	/**
	 * 删除
	 * @param id
	 * @throws Exception
	 */
	public void deletePorderInfoDiscount(String id) throws Exception{
		dao.delete("porderInfodiscountMapper.deletePorderInfoDiscount", id);
	}
	
}
