package com.shifeng.op.order.service;

import java.util.List;
import com.shifeng.entity.order.ExpressOrder;
import com.shifeng.plugin.page.Page;

/** 
 * 订单快递(o_express_order)接口
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2017-02-24 10:43:55 
 */  
public interface ExpressOrderService {

	/**
	 * 查询所有
	 * @param page
	 * @return
	 * @throws Exception
	 */
	public List<ExpressOrder> findAllExpressOrder(Page page) throws Exception;
	
	/**
	 * 根据ID查询
	 */
	public ExpressOrder findExpressOrderById(String id) throws Exception;
	
	/**
	 * 修改
	 * @param expressorder
	 * @throws Exception
	 */
	public void updateExpressOrder(ExpressOrder expressorder) throws Exception;
	
	/**
	 * 新增
	 * @param expressorder
	 * @throws Exception
	 */
	public void saveExpressOrder(ExpressOrder expressorder) throws Exception;
    
    /**
	 * 删除
	 * @param id
	 * @throws Exception
	 */
	public void deleteExpressOrder(String id) throws Exception;
	
}
