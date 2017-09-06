package com.shifeng.op.shop.service;

import java.util.List;
import com.shifeng.entity.shop.MerchantsSettled;
import com.shifeng.op.entity.users.Users;
import com.shifeng.plugin.page.Page;

/** 
 * 入驻基本信息填写(s_merchants_settled)接口
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2017-02-28 17:55:21 
 */  
public interface MerchantsSettledService {

	/**
	 * 查询所有
	 * @param page
	 * @return
	 * @throws Exception
	 */
	public List<MerchantsSettled> findAllMerchantsSettled(Page page) throws Exception;
	
	/**
	 * 根据ID查询
	 */
	public MerchantsSettled findMerchantsSettledById(String id) throws Exception;
	
	/**
	 * 修改
	 * @param merchantssettled
	 * @throws Exception
	 */
	public void updateMerchantsSettled(MerchantsSettled merchantssettled) throws Exception;
	
	/**
	 * 新增
	 * @param merchantssettled
	 * @throws Exception
	 */
	public void saveMerchantsSettled(MerchantsSettled merchantssettled) throws Exception;
    
    /**
	 * 删除
	 * @param id
	 * @throws Exception
	 */
	public void deleteMerchantsSettled(String id) throws Exception;

	public void passMerchantsSettled(int id, String note, Users user)throws Exception;

	public void backMerchantsSettled(int id, String note, Users user)throws Exception;
}
