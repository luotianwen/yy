package com.shifeng.op.mall.service;

import java.util.List;
import com.shifeng.entity.mall.MallSpecialSaleSku;
import com.shifeng.plugin.page.Page;

/** 
 * 特卖商品(mall_special_sale_sku)接口
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2017-05-22 16:46:48 
 */  
public interface MallSpecialSaleSkuService {

	/**
	 * 查询所有
	 * @param page
	 * @return
	 * @throws Exception
	 */
	public List<MallSpecialSaleSku> findAllMallSpecialSaleSku(Page page) throws Exception;
	
	/**
	 * 根据ID查询
	 */
	public MallSpecialSaleSku findMallSpecialSaleSkuById(String id) throws Exception;
	
	/**
	 * 修改
	 * @param mallspecialsalesku
	 * @throws Exception
	 */
	public void updateMallSpecialSaleSku(MallSpecialSaleSku mallspecialsalesku) throws Exception;
	
	/**
	 * 新增
	 * @param mallspecialsalesku
	 * @throws Exception
	 */
	public void saveMallSpecialSaleSku(MallSpecialSaleSku mallspecialsalesku) throws Exception;
    
    /**
	 * 删除
	 * @param id
	 * @throws Exception
	 */
	public void deleteMallSpecialSaleSku(String id) throws Exception;
	
}
