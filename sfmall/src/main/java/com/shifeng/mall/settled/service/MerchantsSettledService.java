package com.shifeng.mall.settled.service;

import java.util.List;
import java.util.Map;

import com.shifeng.entity.shop.ShopinfoLog;
import com.shifeng.entity.shop.ShopinfoPay;
import com.shifeng.mall.entity.user.Users;
import com.shifeng.mall.settled.dto.ProgressDTO;
import com.shifeng.mall.settled.dto.ShopCategoryDTO;
import com.shifeng.mall.settled.dto.ShopDTO;


/**
 * 入驻基本信息填写(s_merchants_settled)接口
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2017-02-28 17:55:21 
 */  
public interface MerchantsSettledService {
	/**
	 * 根据用户id查询
	 */
	public ShopDTO findMerchantsSettledByUserId(String id) throws Exception;

	public ShopDTO findShopByUserId(String id)throws Exception;

	public void updateMerchantssettled(ShopDTO shopDTO, Users user) throws Exception;
	
	/**
	 * 新增店铺详情
	 * @param shopDTO
	 * @throws Exception
	 */
	public void check_in_2_save(ShopDTO shopDTO) throws Exception;
	
	/**
	 * 查询店铺类目
	 * @return
	 * @throws Exception
	 */
	public List<ShopCategoryDTO> findShopCategory(String userId) throws Exception;
	
	/**
	 * 查询店铺订单
	 * @param userId
	 * @return
	 * @throws Exception
	 */
	public List<ShopinfoPay> findShopinfoPay(String userId) throws Exception;
	
	/**
	 * 新增订单
	 * @param userId
	 * @throws Exception
	 */
	public void saveOrder(Users user,Map<String,Object> map) throws Exception;
	
	/**
	 * 修改入驻步骤
	 * @param user
	 * @throws Exception
	 */
	public void updateNext(String id,String next) throws Exception;
	
	/**
	 * 查询当前步骤
	 * @param userId
	 * @return
	 * @throws Exception
	 */
	public int findNext(String userId) throws Exception;
	
	/**
	 * 查询审核日志
	 * @param userId
	 * @return
	 * @throws Exception
	 */
	public List<ShopinfoLog> findShopInfoLog(String userId) throws Exception;
	
	/**
	 * 审核进度
	 * @param userId
	 * @return
	 * @throws Exception
	 */
	public ProgressDTO findProgress(String userId) throws Exception;
	
}
