package com.shifeng.op.product.service;

import java.util.List;
import com.shifeng.entity.product.ProductEvaluateReplay;
import com.shifeng.plugin.page.Page;

/** 
 * 商品评价回复(p_product_evaluate_replay)接口
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2017-04-17 10:41:53 
 */  
public interface ProductEvaluateReplayService {

	/**
	 * 查询所有
	 * @param page
	 * @return
	 * @throws Exception
	 */
	public List<ProductEvaluateReplay> findAllProductEvaluateReplay(Page page) throws Exception;
	
	/**
	 * 根据ID查询
	 */
	public ProductEvaluateReplay findProductEvaluateReplayById(String id) throws Exception;
	
	/**
	 * 修改
	 * @param productevaluatereplay
	 * @throws Exception
	 */
	public void updateProductEvaluateReplay(ProductEvaluateReplay productevaluatereplay) throws Exception;
	
	/**
	 * 新增
	 * @param productevaluatereplay
	 * @throws Exception
	 */
	public void saveProductEvaluateReplay(ProductEvaluateReplay productevaluatereplay) throws Exception;
    
    /**
	 * 删除
	 * @param id
	 * @throws Exception
	 */
	public void deleteProductEvaluateReplay(String id) throws Exception;
	
}
