package com.shifeng.op.mall.service;

import java.util.List;
import com.shifeng.entity.mall.MallSpecialSale;
import com.shifeng.plugin.page.Page;

/** 
 * 特卖(mall_special_sale)接口
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2017-05-22 16:46:47 
 */  
public interface MallSpecialSaleService {

	/**
	 * 查询所有
	 * @param page
	 * @return
	 * @throws Exception
	 */
	public List<MallSpecialSale> findAllMallSpecialSale(Page page) throws Exception;
	
	/**
	 * 根据ID查询
	 */
	public MallSpecialSale findMallSpecialSaleById(String id) throws Exception;
	
	/**
	 * 修改
	 * @param mallspecialsale
	 * @throws Exception
	 */
	public void updateMallSpecialSale(MallSpecialSale mallspecialsale) throws Exception;
	
	/**
	 * 新增
	 * @param mallspecialsale
	 * @throws Exception
	 */
	public void saveMallSpecialSale(MallSpecialSale mallspecialsale) throws Exception;
    
    /**
	 * 删除
	 * @param id
	 * @throws Exception
	 */
	public void deleteMallSpecialSale(String id) throws Exception;
	
}
