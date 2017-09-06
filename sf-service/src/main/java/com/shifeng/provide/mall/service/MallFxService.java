package com.shifeng.provide.mall.service;

import com.shifeng.dto.fx.FxTotalDTO;
import com.shifeng.dto.fx.FxUserMoneyDTO;
import com.shifeng.dto.fx.order.FxTotalOrderDTO;
import com.shifeng.plugin.page.Page;
import com.shifeng.response.ReqResponse;

/**
 * 商城分销
 * @author Win
 *
 */
public interface MallFxService {
	
	/**
	 * 获取我的订单列表
	 * @param user_id 用户ID
	 * @param day	（0：全部订单；1：今日订单；2：今日订单；3：本周订单；4：本月订单）
	 * @param recommended_userid 我的分销用户id
	 * @param currentPage 当前页
	 * @return
	 */
	ReqResponse<Page> getMyFxOrderList(String user_id,String day,String recommended_userid,int currentPage);

	/**
	 * 获取我的分销总计
	 * @param user_id
	 * @return
	 */
	ReqResponse<FxTotalDTO> getFxTotal(String user_id);
	
	
	/**
	 * 获取我的分销佣金
	 * @param user_id
	 * @return
	 */
	ReqResponse<FxUserMoneyDTO> getMyFxCommission(String user_id);
	
	/**
	 * 分销佣金提现
	 * @param user_id 用户id
	 * @param money 提现金额
	 * @param type 提现类型（1：世峰E卡；2：支付宝；3：微信）
	 * @return
	 */
	ReqResponse<String> exchange(String user_id,double money,int type);
	
	/**
	 * 获取我的分销提现总计
	 * @param user_id
	 * @return
	 */
	ReqResponse<FxTotalDTO> getFxExchangeTotal(String user_id);
	
	/**
	 * 获取我的分销提现列表
	 * @param user_id 用户ID
	 * @param type 1收入2支出
	 * @param currentPage 当前页
	 * @return
	 */
	ReqResponse<Page> getMyFxExchangeList(String user_id,String type,int currentPage);
	
	/**
	 * 获取我的分销订单总计
	 * @param user_id
	 * @return
	 */
	ReqResponse<FxTotalOrderDTO> getOrderTotal(String user_id);
	

}
