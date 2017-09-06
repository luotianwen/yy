package com.shifeng.seller.order.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.shifeng.dao.BaseDao;
import com.shifeng.entity.order.ExpressOrder;
import com.shifeng.entity.order.OrderInfo;
import com.shifeng.plugin.page.Page;
import com.shifeng.seller.entity.users.Users;
import com.shifeng.seller.order.service.ExpressOrderService;

/** 
 * 订单快递(o_express_order)接口实现类
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2017-02-24 10:43:55 
 */  
@Service("expressorderServiceImpl")
public class ExpressOrderServiceImpl implements ExpressOrderService{

	@Resource(name = "baseDaoImpl")
	private BaseDao dao;
	
	/**
	 * 查询所有
	 * @param page
	 * @return
	 * @throws Exception
	 */
	public List<ExpressOrder> findAllExpressOrder(Page page) throws Exception{
		return (List<ExpressOrder>) dao.findForList("expressorderMapper.findAllExpressOrderPage", page);
	}
	
	/**
	 * 根据ID查询
	 */
	public ExpressOrder findExpressOrderById(String id) throws Exception{
		return (ExpressOrder) dao.findForObject("expressorderMapper.findExpressOrderById", id);
	}
	
	/**
	 * 新增
	 * @param expressorder
	 * @throws Exception
	 */
	public void saveExpressOrder(ExpressOrder expressorder,Users user) throws Exception{
		expressorder.setUpdatename(user.getuName());
		dao.save("expressorderMapper.saveExpressOrder", expressorder);
		
		//订单出库修改状态
		OrderInfo orderInfo = new OrderInfo();
		orderInfo.setSellerId(user.getShopid());
		orderInfo.setOrderId(expressorder.getOrderId());
		orderInfo.setOrderStatus(2);
		dao.update("orderInfoMapper.updateOrderInfoState", orderInfo);
	}
	
	/**
	 * 修改
	 * @param expressorder
	 * @throws Exception
	 */
	public void updateExpressOrder(ExpressOrder expressorder) throws Exception{
		dao.update("expressorderMapper.updateExpressOrder", expressorder);
	}
	
	/**
	 * 删除
	 * @param id
	 * @throws Exception
	 */
	public void deleteExpressOrder(String id) throws Exception{
		dao.delete("expressorderMapper.deleteExpressOrder", id);
	}
	
	/**
	 * 根据订单ID查询
	 */
	public ExpressOrder findExpressOrderByOid(String orderId) throws Exception{
		return (ExpressOrder) dao.findForObject("expressorderMapper.findExpressOrderByOid", orderId);
	}
	
}
