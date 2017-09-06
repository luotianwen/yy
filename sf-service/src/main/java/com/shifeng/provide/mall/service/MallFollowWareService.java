package com.shifeng.provide.mall.service;

import com.shifeng.plugin.page.Page;
import com.shifeng.response.ReqResponse;

/** 
 * 关注的商品(mall_followWare)接口
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2017-03-31 16:37:01 
 */  
public interface MallFollowWareService {

	/**
	 * 是否已关注商品
	 * @param user_id
	 * @param sku 商品sku
	 * @return
	 */
	ReqResponse<Boolean> isFollowWare(String user_id,int sku);

	/**
	 * 添加关注商品
	 * @param user_id
	 * @param sku 商品sku
	 * @return
	 */
	ReqResponse<String> addFollowWare(String user_id,int sku);
	/**
	 * 添加关注商品
	 * @param user_id
	 * @param sku 商品sku
	 * @return
	 */
	ReqResponse<String> addFollowWare(String user_id,int sku[]);


	/**
	 * 根据用户ID获取用户关注商品列表
	 * @param user_id
	 * @param currentPage 当前页
	 * @return
	 */
	ReqResponse<Page> getFollowWareList(String user_id,int currentPage);


	/**
	 * 根据用户ID删除用户关注的商品
	 * @param user_id
	 * @param sku 关注sku
	 * @return
	 */
	ReqResponse<String> deleteFollowWare(String user_id,String sku);

	
}
