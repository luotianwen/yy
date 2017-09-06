package com.shifeng.seller.order.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.shifeng.dao.BaseDao;
import com.shifeng.entity.order.OrderInvoice;
import com.shifeng.plugin.page.Page;
import com.shifeng.seller.order.service.OrderInvoiceService;

/** 
 * 订单发票(o_orderInvoice)接口实现类
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2017-02-24 10:43:55 
 */  
@Service("orderInvoiceServiceImpl")
public class OrderInvoiceServiceImpl implements OrderInvoiceService{

	@Resource(name = "baseDaoImpl")
	private BaseDao dao;
	
	/**
	 * 查询所有
	 * @param page
	 * @return
	 * @throws Exception
	 */
	public List<OrderInvoice> findAllOrderInvoice(Page page) throws Exception{
		return (List<OrderInvoice>) dao.findForList("orderInvoiceMapper.findAllOrderInvoicePage", page);
	}
	
	/**
	 * 根据ID查询
	 */
	public OrderInvoice findOrderInvoiceById(String id) throws Exception{
		return (OrderInvoice) dao.findForObject("orderInvoiceMapper.findOrderInvoiceById", id);
	}
	
	/**
	 * 新增
	 * @param orderInvoice
	 * @throws Exception
	 */
	public void saveOrderInvoice(OrderInvoice orderInvoice) throws Exception{
		dao.save("orderInvoiceMapper.saveOrderInvoice", orderInvoice);
	}
	
	/**
	 * 修改
	 * @param orderInvoice
	 * @throws Exception
	 */
	public void updateOrderInvoice(OrderInvoice orderInvoice) throws Exception{
		dao.update("orderInvoiceMapper.updateOrderInvoice", orderInvoice);
	}
	
	/**
	 * 删除
	 * @param id
	 * @throws Exception
	 */
	public void deleteOrderInvoice(String id) throws Exception{
		dao.delete("orderInvoiceMapper.deleteOrderInvoice", id);
	}
	
}
