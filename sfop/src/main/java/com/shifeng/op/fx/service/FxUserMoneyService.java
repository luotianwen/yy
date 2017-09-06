package com.shifeng.op.fx.service;

import java.util.List;
import com.shifeng.entity.fx.FxUserMoney;
import com.shifeng.plugin.page.Page;

/** 
 * 用户余额(fx_user_money)接口
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2017-03-07 11:21:34 
 */  
public interface FxUserMoneyService {

	/**
	 * 查询所有
	 * @param page
	 * @return
	 * @throws Exception
	 */
	public List<FxUserMoney> findAllFxUserMoney(Page page) throws Exception;
	
	/**
	 * 根据ID查询
	 */
	public FxUserMoney findFxUserMoneyById(String id) throws Exception;
	
	/**
	 * 修改
	 * @param fxusermoney
	 * @throws Exception
	 */
	public void updateFxUserMoney(FxUserMoney fxusermoney) throws Exception;
	
	/**
	 * 新增
	 * @param fxusermoney
	 * @throws Exception
	 */
	public void saveFxUserMoney(FxUserMoney fxusermoney) throws Exception;
    
    /**
	 * 删除
	 * @param id
	 * @throws Exception
	 */
	public void deleteFxUserMoney(String id) throws Exception;
	
}
