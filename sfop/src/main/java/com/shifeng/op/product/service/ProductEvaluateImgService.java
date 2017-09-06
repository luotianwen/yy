package com.shifeng.op.product.service;

import java.util.List;
import com.shifeng.entity.product.ProductEvaluateImg;
import com.shifeng.plugin.page.Page;

/** 
 * 商品评价图片(p_product_evaluate_img)接口
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2017-04-17 10:41:53 
 */  
public interface ProductEvaluateImgService {

	/**
	 * 查询所有
	 * @param page
	 * @return
	 * @throws Exception
	 */
	public List<ProductEvaluateImg> findAllProductEvaluateImg(Page page) throws Exception;
	
	/**
	 * 根据ID查询
	 */
	public ProductEvaluateImg findProductEvaluateImgById(String id) throws Exception;
	
	/**
	 * 修改
	 * @param productevaluateimg
	 * @throws Exception
	 */
	public void updateProductEvaluateImg(ProductEvaluateImg productevaluateimg) throws Exception;
	
	/**
	 * 新增
	 * @param productevaluateimg
	 * @throws Exception
	 */
	public void saveProductEvaluateImg(ProductEvaluateImg productevaluateimg) throws Exception;
    
    /**
	 * 删除
	 * @param id
	 * @throws Exception
	 */
	public void deleteProductEvaluateImg(String id) throws Exception;
	
}
