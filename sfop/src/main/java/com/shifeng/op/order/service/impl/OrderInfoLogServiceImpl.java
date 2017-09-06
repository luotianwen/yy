package com.shifeng.op.order.service.impl;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.shifeng.dao.BaseDao;
import com.shifeng.entity.order.OrderInfoLog;
import com.shifeng.op.order.service.OrderInfoLogService;
import com.shifeng.plugin.page.Page;

/** 
 * 订单日志(o_orderInfo_log)接口实现类
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2017-05-04 11:22:32 
 */  
@Service("orderInfologServiceImpl")
public class OrderInfoLogServiceImpl implements OrderInfoLogService{

	@Resource(name = "baseDaoImpl")
	private BaseDao dao;
	
	/**
	 * 查询所有
	 * @param page
	 * @return
	 * @throws Exception
	 */
	public List<OrderInfoLog> findAllOrderInfoLog(Page page) throws Exception{
		return (List<OrderInfoLog>) dao.findForList("orderInfologMapper.findAllOrderInfoLogPage", page);
	}
	
	/**
	 * 根据ID查询
	 */
	public OrderInfoLog findOrderInfoLogById(String id) throws Exception{
		return (OrderInfoLog) dao.findForObject("orderInfologMapper.findOrderInfoLogById", id);
	}
	
	/**
	 * 新增
	 * @param orderInfolog
	 * @throws Exception
	 */
	public void saveOrderInfoLog(OrderInfoLog orderInfolog) throws Exception{
		dao.save("orderInfologMapper.saveOrderInfoLog", orderInfolog);
	}
	
	/**
	 * 修改
	 * @param orderInfolog
	 * @throws Exception
	 */
	public void updateOrderInfoLog(OrderInfoLog orderInfolog) throws Exception{
		dao.update("orderInfologMapper.updateOrderInfoLog", orderInfolog);
	}
	
	/**
	 * 删除
	 * @param id
	 * @throws Exception
	 */
	public void deleteOrderInfoLog(String id) throws Exception{
		dao.delete("orderInfologMapper.deleteOrderInfoLog", id);
	}
	
}
