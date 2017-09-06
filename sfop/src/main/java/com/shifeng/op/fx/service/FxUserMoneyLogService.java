package com.shifeng.op.fx.service;

import java.util.List;
import com.shifeng.entity.fx.FxUserMoneyLog;
import com.shifeng.plugin.page.Page;

/** 
 * 用户余额日志(fx_user_money_log)接口
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2017-03-07 11:21:34 
 */  
public interface FxUserMoneyLogService {

	/**
	 * 查询所有
	 * @param page
	 * @return
	 * @throws Exception
	 */
	public List<FxUserMoneyLog> findAllFxUserMoneyLog(Page page) throws Exception;
	
	/**
	 * 根据ID查询
	 */
	public FxUserMoneyLog findFxUserMoneyLogById(String id) throws Exception;
	
	/**
	 * 修改
	 * @param fxusermoneylog
	 * @throws Exception
	 */
	public void updateFxUserMoneyLog(FxUserMoneyLog fxusermoneylog) throws Exception;
	
	/**
	 * 新增
	 * @param fxusermoneylog
	 * @throws Exception
	 */
	public void saveFxUserMoneyLog(FxUserMoneyLog fxusermoneylog) throws Exception;
    
    /**
	 * 删除
	 * @param id
	 * @throws Exception
	 */
	public void deleteFxUserMoneyLog(String id) throws Exception;
	
}
