package com.shifeng.op.fx.service;

import java.util.List;
import com.shifeng.entity.fx.FxUser;
import com.shifeng.plugin.page.Page;

/** 
 * 分销用户(fx_user)接口
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2017-03-07 11:21:34 
 */  
public interface FxUserService {

	/**
	 * 查询所有
	 * @param page
	 * @return
	 * @throws Exception
	 */
	public List<FxUser> findAllFxUser(Page page) throws Exception;
	
	/**
	 * 根据ID查询
	 */
	public FxUser findFxUserById(String id) throws Exception;
	
	/**
	 * 修改
	 * @param fxuser
	 * @throws Exception
	 */
	public void updateFxUser(FxUser fxuser) throws Exception;
	
	/**
	 * 新增
	 * @param fxuser
	 * @throws Exception
	 */
	public void saveFxUser(FxUser fxuser) throws Exception;
    
    /**
	 * 删除
	 * @param id
	 * @throws Exception
	 */
	public void deleteFxUser(String id) throws Exception;
	
}
