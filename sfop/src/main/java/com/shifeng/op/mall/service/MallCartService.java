package com.shifeng.op.mall.service;

import java.util.List;
import com.shifeng.entity.mall.MallCart;
import com.shifeng.plugin.page.Page;

/** 
 * 购物车(mall_cart)接口
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2017-03-24 14:08:29 
 */  
public interface MallCartService {

	/**
	 * 查询所有
	 * @param page
	 * @return
	 * @throws Exception
	 */
	public List<MallCart> findAllMallCart(Page page) throws Exception;
	
	/**
	 * 根据ID查询
	 */
	public MallCart findMallCartById(String id) throws Exception;
	
	/**
	 * 修改
	 * @param mallcart
	 * @throws Exception
	 */
	public void updateMallCart(MallCart mallcart) throws Exception;
	
	/**
	 * 新增
	 * @param mallcart
	 * @throws Exception
	 */
	public void saveMallCart(MallCart mallcart) throws Exception;
    
    /**
	 * 删除
	 * @param id
	 * @throws Exception
	 */
	public void deleteMallCart(String id) throws Exception;
	
}
