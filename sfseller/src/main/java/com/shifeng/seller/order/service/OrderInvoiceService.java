package com.shifeng.seller.order.service;

import java.util.List;
import com.shifeng.entity.order.OrderInvoice;
import com.shifeng.plugin.page.Page;

/** 
 * 订单发票(o_orderInvoice)接口
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2017-02-24 10:43:55 
 */  
public interface OrderInvoiceService {

	/**
	 * 查询所有
	 * @param page
	 * @return
	 * @throws Exception
	 */
	public List<OrderInvoice> findAllOrderInvoice(Page page) throws Exception;
	
	/**
	 * 根据ID查询
	 */
	public OrderInvoice findOrderInvoiceById(String id) throws Exception;
	
	/**
	 * 修改
	 * @param orderInvoice
	 * @throws Exception
	 */
	public void updateOrderInvoice(OrderInvoice orderInvoice) throws Exception;
	
	/**
	 * 新增
	 * @param orderInvoice
	 * @throws Exception
	 */
	public void saveOrderInvoice(OrderInvoice orderInvoice) throws Exception;
    
    /**
	 * 删除
	 * @param id
	 * @throws Exception
	 */
	public void deleteOrderInvoice(String id) throws Exception;
	
}
