package com.shifeng.provide.mall.service;

import com.shifeng.entity.mall.MallUsersSilver;
import com.shifeng.plugin.page.Page;
import com.shifeng.response.ReqResponse;

/** 
 * 我的银币(mall_users_silver)接口
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2017-03-22 18:38:25 
 */  
public interface MallUsersSilverService {

	/**
	 * 获取我的银币
	 * @param user_id 用户id
	 * @return
	 */
	ReqResponse<MallUsersSilver> getSilverCoin(String user_id);
	
	/**
	 * 银币兑换记录
	 * @param user_id 用户id
	 * @param currentPage 当前页
	 * @return
	 */
	ReqResponse<Page<String>> exchangeRecord(String user_id,int currentPage);
	
	/**
	 * 银币兑换记录
	 * @param user_id 用户id
	 * @param currentPage 当前页
	 * @param pageSize 每页条数
	 * @return
	 */
	ReqResponse<Page<String>> exchangeRecord(String user_id,int currentPage,int pageSize);
	
	/**
	 * 银币兑换
	 * @param user_id 用户id
	 * @return
	 */
	ReqResponse<String> exchange(String user_id);

	/**
	 * 银币兑换记录
	 * @param user_id 用户id
	 * @param type 1收入2兑换
	 * @param currentPage 当前页
	 * @return
	 */
	ReqResponse<Page> exchangeRecord(String user_id, String type, int currentPage);
	
}
