package com.shifeng.webapi.service.mall;

import com.shifeng.plugin.page.Page;

/**
 * 关注
 * @author WinZhong
 *
 */
public interface FollowService {
	
	/**
	 * 是否已关注商品
	 * @param user_id
	 * @param sku 商品sku
	 * @return 已关注 true 未关注false
	 */
	boolean isFollowWare(String user_id,int sku);
	/**
	 * 添加关注商品
	 * @param user_id
	 * @param sku 商品sku
	 * @return
	 */
	boolean addFollowWare(String user_id,int sku);
	

	/**
	 * 根据用户ID获取用户关注商品列表
	 * @param user_id
	 * @param currentPage 当前页
	 * @return
	 */
	Page getFollowWareList(String user_id,int currentPage);


	/**
	 * 根据用户ID删除用户关注的商品
	 * @param user_id
	 * @param sku  关注sku，多个英文逗号隔开
	 * @return
	 */
	boolean deleteFollowWare(String user_id,String sku);
	
	/**
	 * 是否已关注店铺
	 * @param user_id
	 * @param shop_id 店铺shop_id
	 * @return 已关注 true 未关注false
	 */
	boolean isFollowVender(String user_id,int shop_id);
	
	/**
	 * 添加关注店铺
	 * @param user_id
	 * @param shop_id 店铺ID
	 * @return
	 */
	boolean addFollowVender(String user_id,int shop_id);

	/**
	 * 根据用户ID获取关注店铺列表
	 * @param user_id
	 * @param currentPage 当前页
	 * @return
	 */
	Page getFollowVenderList(String user_id, int currentPage);


	/**
	 * 根据用户ID删除用户关注的店铺
	 * @param user_id
	 * @param shopId  关注shopId，多个英文逗号隔开
	 * @return
	 */
	boolean deleteFollowVender(String user_id,String shopId);

}
