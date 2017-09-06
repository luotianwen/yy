package com.shifeng.seller.product.service;

import java.util.List;

import com.shifeng.entity.product.ProductConsultation;
import com.shifeng.plugin.page.Page;
import com.shifeng.seller.product.dto.ProductConsultationDTO;

/** 
 * 商品咨询(p_product_consultation)接口
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2017-04-19 14:45:10 
 */  
public interface ProductConsultationService {

	/**
	 * 查询所有
	 * @param page
	 * @return
	 * @throws Exception
	 */
	public List<ProductConsultationDTO> findAllProductConsultation(Page page) throws Exception;
	
	/**
	 * 修改
	 * @param productconsultation
	 * @throws Exception
	 */
	public void updateProductConsultation(ProductConsultation productconsultation) throws Exception;
	
}
