package com.shifeng.seller.order.service.impl;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.shifeng.dao.BaseDao;
import com.shifeng.entity.order.OrderInfoServiceLog;
import com.shifeng.seller.order.service.OrderInfoServiceLogService;
import com.shifeng.plugin.page.Page;

/** 
 * 订单售后日志(o_orderInfo_service_log)接口实现类
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2017-04-12 19:08:55 
 */  
@Service("orderInfoservicelogServiceImpl")
public class OrderInfoServiceLogServiceImpl implements OrderInfoServiceLogService{

	@Resource(name = "baseDaoImpl")
	private BaseDao dao;
	
	/**
	 * 查询所有
	 * @param page
	 * @return
	 * @throws Exception
	 */
	public List<OrderInfoServiceLog> findOrderInfoServiceLogByOosId(String id) throws Exception{
		return (List<OrderInfoServiceLog>) dao.findForList("orderInfoservicelogMapper.findOrderInfoServiceLogByOosId", id);
	}
	
}
