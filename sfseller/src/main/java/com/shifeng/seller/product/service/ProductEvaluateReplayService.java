package com.shifeng.seller.product.service;

import java.util.List;
import com.shifeng.entity.product.ProductEvaluateReplay;
import com.shifeng.plugin.page.Page;

/** 
 * 商品评价回复(p_product_evaluate_replay)接口
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2017-04-19 14:45:10 
 */  
public interface ProductEvaluateReplayService {

	/**
	 * 新增
	 * @param productevaluatereplay
	 * @throws Exception
	 */
	public void saveProductEvaluateReplay(ProductEvaluateReplay productevaluatereplay) throws Exception;
    
}
