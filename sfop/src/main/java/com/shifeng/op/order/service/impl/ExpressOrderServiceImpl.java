package com.shifeng.op.order.service.impl;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.shifeng.dao.BaseDao;
import com.shifeng.entity.order.ExpressOrder;
import com.shifeng.op.order.service.ExpressOrderService;
import com.shifeng.plugin.page.Page;

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
	public void saveExpressOrder(ExpressOrder expressorder) throws Exception{
		dao.save("expressorderMapper.saveExpressOrder", expressorder);
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
	
}
