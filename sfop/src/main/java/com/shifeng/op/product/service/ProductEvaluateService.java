package com.shifeng.op.product.service;

import java.util.List;
import com.shifeng.entity.product.ProductEvaluate;
import com.shifeng.op.dto.product.ProductEvaluateDTO;
import com.shifeng.plugin.page.Page;

/** 
 * 商品评价(p_product_evaluate)接口
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2017-04-17 10:41:52 
 */  
public interface ProductEvaluateService {

	/**
	 * 查询所有
	 * @param page
	 * @return
	 * @throws Exception
	 */
	public List<ProductEvaluateDTO> findAllProductEvaluate(Page page) throws Exception;
	
	/**
	 * 修改
	 * @param productevaluate
	 * @throws Exception
	 */
	public void updateProductEvaluate(ProductEvaluate productevaluate) throws Exception;
	
}
