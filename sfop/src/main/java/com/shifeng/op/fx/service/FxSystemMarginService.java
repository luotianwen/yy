package com.shifeng.op.fx.service;

import java.util.List;
import com.shifeng.entity.fx.FxSystemMargin;
import com.shifeng.plugin.page.Page;

/** 
 * 系统分销利率设置(fx_system_margin)接口
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2017-03-07 11:21:34 
 */  
public interface FxSystemMarginService {

	/**
	 * 查询所有
	 * @param page
	 * @return
	 * @throws Exception
	 */
	public List<FxSystemMargin> findAllFxSystemMargin(Page page) throws Exception;
	
	/**
	 * 根据ID查询
	 */
	public FxSystemMargin findFxSystemMarginById(String id) throws Exception;
	
	/**
	 * 修改
	 * @param fxsystemmargin
	 * @throws Exception
	 */
	public void updateFxSystemMargin(FxSystemMargin fxsystemmargin) throws Exception;
	
	/**
	 * 新增
	 * @param fxsystemmargin
	 * @throws Exception
	 */
	public void saveFxSystemMargin(FxSystemMargin fxsystemmargin) throws Exception;
    
    /**
	 * 删除
	 * @param id
	 * @throws Exception
	 */
	public void deleteFxSystemMargin(String id) throws Exception;
	/**
	 *
	 * @param fxsystemmargin
	 * @throws Exception
	 */
	public int countFxSystemMargin(FxSystemMargin fxsystemmargin) throws Exception;
}
