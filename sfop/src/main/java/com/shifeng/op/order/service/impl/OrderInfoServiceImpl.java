package com.shifeng.op.order.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.shifeng.dao.BaseDao;
import com.shifeng.entity.order.OrderInfo;
import com.shifeng.entity.order.OrderInfoLog;
import com.shifeng.op.dto.order.OrderInfoDTO;
import com.shifeng.op.dto.order.OrderInfoDetailDTO;
import com.shifeng.op.entity.users.Users;
import com.shifeng.op.order.service.OrderInfoService;
import com.shifeng.plugin.page.Page;

/** 
 * 订单表(o_orderInfo)接口实现类
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2017-02-24 10:43:55 
 */  
@Service("orderInfoServiceImpl")
public class OrderInfoServiceImpl implements OrderInfoService{

	@Resource(name = "baseDaoImpl")
	private BaseDao dao;
	
	/**
	 * 查询所有
	 * @param page
	 * @return
	 * @throws Exception
	 */
	public List<OrderInfoDTO> findAllOrderInfo(Page page) throws Exception{
		return (List<OrderInfoDTO>) dao.findForList("orderInfoMapper.findAllOrderInfoByPidPage", page);
	}
	
	/**
	 * 根据ID查询
	 */
	public OrderInfoDetailDTO findOrderInfoById(String id) throws Exception{
		return (OrderInfoDetailDTO) dao.findForObject("orderInfoMapper.findOrderInfoById", id);
	}
	
	/**
	 * 新增
	 * @param orderInfo
	 * @throws Exception
	 */
	public void saveOrderInfo(OrderInfo orderInfo) throws Exception{
		dao.save("orderInfoMapper.saveOrderInfo", orderInfo);
	}
	
	/**
	 * 修改
	 * @param orderInfo
	 * @throws Exception
	 */
	public void updateOrderInfo(OrderInfo orderInfo) throws Exception{
		dao.update("orderInfoMapper.updateOrderInfo", orderInfo);
	}
	
	/**
	 * 删除
	 * @param id
	 * @throws Exception
	 */
	public void deleteOrderInfo(String id) throws Exception{
		dao.delete("orderInfoMapper.deleteOrderInfo", id);
	}
	
	/**
	 * 订单日志
	 */
	public List<OrderInfoLog> findOrderInfoLog(String id) throws Exception{
		return (List<OrderInfoLog>) dao.findForList("orderInfologMapper.findOrderInfoLogByOrderId", id);
	}
	
	/**
	 * 退款成功
	 */
	public void updateOrderRefund(Users user,String orderId) throws Exception{
		Map<String,String> map = new HashMap<String,String>();
		map.put("orderId", orderId);
		int row = (int)dao.update("orderInfoMapper.orderRefund", map);
		
		if(row>0){
			OrderInfoLog log = new OrderInfoLog();
			log.setAfter_status(5);
			log.setBefore_status(7);
			log.setCreate_user_id(user.getuId());
			log.setCreate_user_name(user.getuName());
			log.setLog_content("退款成功");
			log.setLog_level(1);
			log.setOrder_id(orderId);
			
			dao.save("orderInfologMapper.saveOrderInfoLog", log);
		}
	}
	
}
