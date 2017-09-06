package com.shifeng.op.product.service;

import java.util.List;
import com.shifeng.entity.product.ProRules;
import com.shifeng.op.dto.coupons.ProductDTO;
import com.shifeng.plugin.page.Page;

/** 
 * SKU表(p_pro_rules)接口
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2017-02-24 11:14:12 
 */  
public interface ProRulesService {

	/**
	 * 查询所有
	 * @param page
	 * @return
	 * @throws Exception
	 */
	public List<ProRules> findAllProRules(Page page) throws Exception;
	
	/**
	 * 根据ID查询
	 */
	public ProRules findProRulesById(String id) throws Exception;
	
	/**
	 * 修改
	 * @param prorules
	 * @throws Exception
	 */
	public void updateProRules(ProRules prorules) throws Exception;
	
	/**
	 * 新增
	 * @param prorules
	 * @throws Exception
	 */
	public void saveProRules(ProRules prorules) throws Exception;
    
    /**
	 * 删除
	 * @param id
	 * @throws Exception
	 */
	public void deleteProRules(String id) throws Exception;
	
	/**
	 * 优惠券使用范围(指定参加/不参加商品)
	 * @param page
	 * @param dto
	 * @return
	 * @throws Exception
	 */
	public List<ProductDTO> findProductForCoupons(Page page) throws Exception;
	
}
