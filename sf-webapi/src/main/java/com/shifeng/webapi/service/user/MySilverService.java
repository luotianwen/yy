package com.shifeng.webapi.service.user;

import com.shifeng.entity.mall.MallUsersSilver;
import com.shifeng.plugin.page.Page;
import com.shifeng.response.ReqResponse;

/**
 * 我的银币
 * @author WinZhong
 *
 */
public interface MySilverService {

	/**
	 * 获取我的银币
	 * @param user_id 用户id
	 * @return
	 */
	MallUsersSilver getSilverCoin(String user_id);
	
	/**
	 * 银币兑换记录
	 * @param user_id 用户id
	 * @param currentPage 当前页
	 * @return
	 */
	Page exchangeRecord(String user_id,int currentPage);
	
	/**
	 * 银币兑换记录
	 * @param user_id 用户id
	 * @param type 1收入2兑换
	 * @param currentPage 当前页
	 * @return
	 */
	Page exchangeRecord(String user_id,String type,int currentPage);
	
	/**
	 * 银币兑换记录
	 * @param user_id 用户id
	 * @param currentPage 当前页
	 * @param pageSize 每页条数
	 * @return
	 */
	Page exchangeRecord(String user_id,int currentPage,int pageSize);
	
	/**
	 * 银币兑换
	 * @param user_id 用户id
	 * @return
	 */
	boolean exchange(String user_id,ReqResponse<String> req);

}
