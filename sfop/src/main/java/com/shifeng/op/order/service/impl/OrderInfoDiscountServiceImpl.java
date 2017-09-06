package com.shifeng.op.order.service.impl;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.shifeng.dao.BaseDao;
import com.shifeng.entity.order.OrderInfoDiscount;
import com.shifeng.op.order.service.OrderInfoDiscountService;
import com.shifeng.plugin.page.Page;

/** 
 * 订单折扣表(o_orderInfo_discount)接口实现类
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2017-02-24 10:43:55 
 */  
@Service("orderInfodiscountServiceImpl")
public class OrderInfoDiscountServiceImpl implements OrderInfoDiscountService{

	@Resource(name = "baseDaoImpl")
	private BaseDao dao;
	
	/**
	 * 查询所有
	 * @param page
	 * @return
	 * @throws Exception
	 */
	public List<OrderInfoDiscount> findAllOrderInfoDiscount(Page page) throws Exception{
		return (List<OrderInfoDiscount>) dao.findForList("orderInfodiscountMapper.findAllOrderInfoDiscountPage", page);
	}
	
	/**
	 * 根据ID查询
	 */
	public OrderInfoDiscount findOrderInfoDiscountById(String id) throws Exception{
		return (OrderInfoDiscount) dao.findForObject("orderInfodiscountMapper.findOrderInfoDiscountById", id);
	}
	
	/**
	 * 新增
	 * @param orderInfodiscount
	 * @throws Exception
	 */
	public void saveOrderInfoDiscount(OrderInfoDiscount orderInfodiscount) throws Exception{
		dao.save("orderInfodiscountMapper.saveOrderInfoDiscount", orderInfodiscount);
	}
	
	/**
	 * 修改
	 * @param orderInfodiscount
	 * @throws Exception
	 */
	public void updateOrderInfoDiscount(OrderInfoDiscount orderInfodiscount) throws Exception{
		dao.update("orderInfodiscountMapper.updateOrderInfoDiscount", orderInfodiscount);
	}
	
	/**
	 * 删除
	 * @param id
	 * @throws Exception
	 */
	public void deleteOrderInfoDiscount(String id) throws Exception{
		dao.delete("orderInfodiscountMapper.deleteOrderInfoDiscount", id);
	}
	
}
