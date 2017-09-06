package com.shifeng.seller.order.service;

import java.util.List;
import com.shifeng.entity.order.PorderInfoDiscount;
import com.shifeng.plugin.page.Page;

/** 
 * 父订单折扣表(o_porderInfo_discount)接口
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2017-02-24 10:43:55 
 */  
public interface PorderInfoDiscountService {

	/**
	 * 查询所有
	 * @param page
	 * @return
	 * @throws Exception
	 */
	public List<PorderInfoDiscount> findAllPorderInfoDiscount(Page page) throws Exception;
	
	/**
	 * 根据ID查询
	 */
	public PorderInfoDiscount findPorderInfoDiscountById(String id) throws Exception;
	
	/**
	 * 修改
	 * @param porderInfodiscount
	 * @throws Exception
	 */
	public void updatePorderInfoDiscount(PorderInfoDiscount porderInfodiscount) throws Exception;
	
	/**
	 * 新增
	 * @param porderInfodiscount
	 * @throws Exception
	 */
	public void savePorderInfoDiscount(PorderInfoDiscount porderInfodiscount) throws Exception;
    
    /**
	 * 删除
	 * @param id
	 * @throws Exception
	 */
	public void deletePorderInfoDiscount(String id) throws Exception;
	
}
