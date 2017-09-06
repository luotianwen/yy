package com.shifeng.seller.order.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.shifeng.dao.BaseDao;
import com.shifeng.entity.order.OrderInfo;
import com.shifeng.entity.order.OrderInfoLog;
import com.shifeng.plugin.page.Page;
import com.shifeng.seller.entity.users.Users;
import com.shifeng.seller.order.dto.OrderInfoDTO;
import com.shifeng.seller.order.service.OrderInfoService;

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
		return (List<OrderInfoDTO>) dao.findForList("orderInfoMapper.findAllOrderInfoPage", page);
	}
	
	/**
	 * 根据ID查询
	 */
	public OrderInfoDTO findOrderInfoById(String id) throws Exception{
		return (OrderInfoDTO) dao.findForObject("orderInfoMapper.findOrderInfoById", id);
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
	 * 修改备注
	 * @param orderInfo
	 * @throws Exception
	 */
	public void updateOrderInfoRemark(OrderInfo orderInfo) throws Exception{
		dao.update("orderInfoMapper.updateOrderInfoRemark", orderInfo);
	}
	
	/**
	 * 取消订单
	 * @param id
	 * @param user
	 * @throws Exception
	 */
	public void updateCancelOrder(String id,Users user) throws Exception{
		OrderInfo orderInfo = new OrderInfo();
		
		orderInfo.setOrderId(id);
		orderInfo.setSellerId(user.getShopid());
		orderInfo.setOrderStatus(4);
		dao.update("orderInfoMapper.updateOrderInfoState", orderInfo);
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
		map.put("shopId", user.getShopid()+"");
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
