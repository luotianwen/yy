package com.shifeng.op.product.service;

import java.util.List;
import com.shifeng.entity.product.ProductConsultationReplay;
import com.shifeng.plugin.page.Page;

/** 
 * 商品咨询回复(p_product_consultation_replay)接口
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2017-04-17 10:41:53 
 */  
public interface ProductConsultationReplayService {

	/**
	 * 查询所有
	 * @param page
	 * @return
	 * @throws Exception
	 */
	public List<ProductConsultationReplay> findAllProductConsultationReplay(Page page) throws Exception;
	
	/**
	 * 根据ID查询
	 */
	public ProductConsultationReplay findProductConsultationReplayById(String id) throws Exception;
	
	/**
	 * 修改
	 * @param productconsultationreplay
	 * @throws Exception
	 */
	public void updateProductConsultationReplay(ProductConsultationReplay productconsultationreplay) throws Exception;
	
	/**
	 * 新增
	 * @param productconsultationreplay
	 * @throws Exception
	 */
	public void saveProductConsultationReplay(ProductConsultationReplay productconsultationreplay) throws Exception;
    
    /**
	 * 删除
	 * @param id
	 * @throws Exception
	 */
	public void deleteProductConsultationReplay(String id) throws Exception;
	
}
