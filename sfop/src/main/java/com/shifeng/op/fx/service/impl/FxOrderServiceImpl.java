package com.shifeng.op.fx.service.impl;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.shifeng.dao.BaseDao;
import com.shifeng.entity.fx.FxOrder;
import com.shifeng.op.fx.service.FxOrderService;
import com.shifeng.plugin.page.Page;

/** 
 * 分销订单(fx_order)接口实现类
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2017-03-08 11:48:01 
 */  
@Service("fxorderServiceImpl")
public class FxOrderServiceImpl implements FxOrderService{

	@Resource(name = "baseDaoImpl")
	private BaseDao dao;
	
	/**
	 * 查询所有
	 * @param page
	 * @return
	 * @throws Exception
	 */
	public List<FxOrder> findAllFxOrder(Page page) throws Exception{
		return (List<FxOrder>) dao.findForList("fxorderMapper.findAllFxOrderPage", page);
	}
	
	/**
	 * 根据ID查询
	 */
	public FxOrder findFxOrderById(String id) throws Exception{
		return (FxOrder) dao.findForObject("fxorderMapper.findFxOrderById", id);
	}
	
	/**
	 * 新增
	 * @param fxorder
	 * @throws Exception
	 */
	public void saveFxOrder(FxOrder fxorder) throws Exception{
		dao.save("fxorderMapper.saveFxOrder", fxorder);
	}
	
	/**
	 * 修改
	 * @param fxorder
	 * @throws Exception
	 */
	public void updateFxOrder(FxOrder fxorder) throws Exception{
		dao.update("fxorderMapper.updateFxOrder", fxorder);
	}
	
	/**
	 * 删除
	 * @param id
	 * @throws Exception
	 */
	public void deleteFxOrder(String id) throws Exception{
		dao.delete("fxorderMapper.deleteFxOrder", id);
	}
	
}
