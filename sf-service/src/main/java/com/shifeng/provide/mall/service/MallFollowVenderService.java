package com.shifeng.provide.mall.service;

import com.shifeng.plugin.page.Page;
import com.shifeng.response.ReqResponse;

/** 
 * 关注的店铺(mall_followVender)接口
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2017-03-31 16:37:01 
 */  
public interface MallFollowVenderService {


	/**
	 * 是否已关注店铺
	 * @param user_id
	 * @param shop_id 店铺shop_id
	 * @return
	 */
	ReqResponse<Boolean> isFollowVender(String user_id,int shop_id);


	/**
	 * 添加关注店铺
	 * @param user_id
	 * @param shop_id 店铺shop_id
	 * @return
	 */
	ReqResponse<String> addFollowVender(String user_id,int shop_id);
	

	/**
	 * 根据用户ID获取用户关注店铺列表
	 * @param user_id
	 * @param currentPage 当前页
	 * @return
	 */
	ReqResponse<Page> getFollowVenderList(String user_id,int currentPage);


	/**
	 * 根据用户ID删除用户关注的店铺
	 * @param user_id
	 * @param shopId  关注shopId，多个英文逗号隔开
	 * @return
	 */
	ReqResponse<String> deleteFollowVender(String user_id,String shopId);
 

	
}
