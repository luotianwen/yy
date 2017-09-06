package com.shifeng.seller.order.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.shifeng.dao.BaseDao;
import com.shifeng.entity.order.OrderInfoService;
import com.shifeng.seller.order.service.OrderInfoServiceService;
import com.shifeng.util.Const;
import com.shifeng.plugin.page.Page;

/** 
 * 订单售后(o_orderInfo_service)接口实现类
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2017-04-12 19:08:54 
 */  
@Service("orderInfoserviceServiceImpl")
public class OrderInfoServiceServiceImpl implements OrderInfoServiceService{

	@Resource(name = "baseDaoImpl")
	private BaseDao dao;
	
	/**
	 * 查询所有
	 * @param page
	 * @return
	 * @throws Exception
	 */
	public List<OrderInfoService> findAllOrderInfoService(Page page) throws Exception{
		return (List<OrderInfoService>) dao.findForList("orderInfoserviceMapper.findAllOrderInfoServicePage", page);
	}
	
	/**
	 * 根据ID查询
	 */
	public OrderInfoService findOrderInfoServiceById(String id) throws Exception{
		return (OrderInfoService) dao.findForObject("orderInfoserviceMapper.findOrderInfoServiceById", id);
	}
	
	/**
	 * 新增
	 * @param orderInfoservice
	 * @throws Exception
	 */
	public void saveOrderInfoService(OrderInfoService orderInfoservice) throws Exception{
		dao.save("orderInfoserviceMapper.saveOrderInfoService", orderInfoservice);
	}
	
	/**
	 * 修改
	 * @param orderInfoservice
	 * @throws Exception
	 */
	public void updateOrderInfoService(OrderInfoService orderInfoservice) throws Exception{
		dao.update("orderInfoserviceMapper.updateOrderInfoService", orderInfoservice);
		
		orderInfoservice = findOrderInfoServiceById(orderInfoservice.getId()+"");
		
		if(orderInfoservice.getState()==3){
			Map<String,String> map = new HashMap<String,String>();
			map.put("orderId", orderInfoservice.getOrderId());
			map.put("sku", orderInfoservice.getSku());
			
			String soldPrice = (String) dao.findForObject("orderDetailInfoMapper.findOrderDetailInfoByOrderSku", map);
			
			map.put("refundMoney", soldPrice+"");
			dao.update("orderInfoMapper.updateOrderInfoRefundMoney", map);
		}
	}
	
	/**
	 * 删除
	 * @param id
	 * @throws Exception
	 */
	public void deleteOrderInfoService(String id) throws Exception{
		dao.delete("orderInfoserviceMapper.deleteOrderInfoService", id);
	}
	
	/**
	 * 修改发货信息
	 */
	public void updateShipments(Map<String,String> map) throws Exception{
		if("1".equals(map.get("type"))||"2".equals(map.get("type"))){
			dao.update("orderInfoserviceMapper.updateShipments", map);
		}else{
			map.clear();
			map.put(Const.RESPONSE_STATE, Const.RESPONSE_ERROR);
			map.put(Const.ERROR_INFO, "修改异常，请稍后重试!!!");
		}
		
		map.clear();
		map.put(Const.RESPONSE_STATE, Const.RESPONSE_SUCCESS);
	}
	
	
}
