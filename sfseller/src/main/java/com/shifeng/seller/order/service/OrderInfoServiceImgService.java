package com.shifeng.seller.order.service;

import java.util.List;
import com.shifeng.entity.order.OrderInfoServiceImg;
import com.shifeng.plugin.page.Page;

/** 
 * 订单售后图片(o_orderInfo_service_img)接口
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2017-04-21 14:37:32 
 */  
public interface OrderInfoServiceImgService {

	/**
	 * 查询所有
	 * @param page
	 * @return
	 * @throws Exception
	 */
	public List<OrderInfoServiceImg> findOrderInfoServiceImgByOisId(String id) throws Exception;
	
	
}
