package com.shifeng.seller.order.service.impl;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.shifeng.dao.BaseDao;
import com.shifeng.entity.order.OrderInfoServiceImg;
import com.shifeng.seller.order.service.OrderInfoServiceImgService;
import com.shifeng.plugin.page.Page;

/** 
 * 订单售后图片(o_orderInfo_service_img)接口实现类
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2017-04-21 14:37:32 
 */  
@Service("orderInfoserviceimgServiceImpl")
public class OrderInfoServiceImgServiceImpl implements OrderInfoServiceImgService{

	@Resource(name = "baseDaoImpl")
	private BaseDao dao;
	
	/**
	 * 查询所有
	 * @param page
	 * @return
	 * @throws Exception
	 */
	public List<OrderInfoServiceImg> findOrderInfoServiceImgByOisId(String id) throws Exception{
		return (List<OrderInfoServiceImg>) dao.findForList("orderInfoserviceimgMapper.findOrderInfoServiceImgByOisId", id);
	}
	
}
