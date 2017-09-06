package com.shifeng.seller.product.service;

import java.util.List;
import com.shifeng.entity.product.ProductConsultationReplay;
import com.shifeng.plugin.page.Page;

/** 
 * 商品咨询回复(p_product_consultation_replay)接口
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2017-04-19 14:45:10 
 */  
public interface ProductConsultationReplayService {

	/**
	 * 新增
	 * @param productconsultationreplay
	 * @throws Exception
	 */
	public void saveProductConsultationReplay(ProductConsultationReplay productconsultationreplay) throws Exception;
    
}
