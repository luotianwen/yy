package com.shifeng.op.order.service;

import java.util.List;
import com.shifeng.entity.order.OrderInfoDiscount;
import com.shifeng.plugin.page.Page;

/** 
 * 订单折扣表(o_orderInfo_discount)接口
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2017-02-24 10:43:55 
 */  
public interface OrderInfoDiscountService {

	/**
	 * 查询所有
	 * @param page
	 * @return
	 * @throws Exception
	 */
	public List<OrderInfoDiscount> findAllOrderInfoDiscount(Page page) throws Exception;
	
	/**
	 * 根据ID查询
	 */
	public OrderInfoDiscount findOrderInfoDiscountById(String id) throws Exception;
	
	/**
	 * 修改
	 * @param orderInfodiscount
	 * @throws Exception
	 */
	public void updateOrderInfoDiscount(OrderInfoDiscount orderInfodiscount) throws Exception;
	
	/**
	 * 新增
	 * @param orderInfodiscount
	 * @throws Exception
	 */
	public void saveOrderInfoDiscount(OrderInfoDiscount orderInfodiscount) throws Exception;
    
    /**
	 * 删除
	 * @param id
	 * @throws Exception
	 */
	public void deleteOrderInfoDiscount(String id) throws Exception;
	
}
