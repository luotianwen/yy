package com.shifeng.op.fx.service;

import java.util.List;
import com.shifeng.entity.fx.FxOrder;
import com.shifeng.plugin.page.Page;

/** 
 * 分销订单(fx_order)接口
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2017-03-08 11:48:01 
 */  
public interface FxOrderService {

	/**
	 * 查询所有
	 * @param page
	 * @return
	 * @throws Exception
	 */
	public List<FxOrder> findAllFxOrder(Page page) throws Exception;
	
	/**
	 * 根据ID查询
	 */
	public FxOrder findFxOrderById(String id) throws Exception;
	
	/**
	 * 修改
	 * @param fxorder
	 * @throws Exception
	 */
	public void updateFxOrder(FxOrder fxorder) throws Exception;
	
	/**
	 * 新增
	 * @param fxorder
	 * @throws Exception
	 */
	public void saveFxOrder(FxOrder fxorder) throws Exception;
    
    /**
	 * 删除
	 * @param id
	 * @throws Exception
	 */
	public void deleteFxOrder(String id) throws Exception;
	
}
