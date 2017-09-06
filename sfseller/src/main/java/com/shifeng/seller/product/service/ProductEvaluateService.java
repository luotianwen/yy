package com.shifeng.seller.product.service;

import java.util.List;
import com.shifeng.entity.product.ProductEvaluate;
import com.shifeng.plugin.page.Page;
import com.shifeng.seller.product.dto.ProductEvaluateDTO;

/** 
 * 商品评价(p_product_evaluate)接口
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2017-04-19 14:45:10 
 */  
public interface ProductEvaluateService {

	/**
	 * 查询所有
	 * @param page
	 * @return
	 * @throws Exception
	 */
	public List<ProductEvaluateDTO> findAllProductEvaluate(Page page) throws Exception;
	
}
