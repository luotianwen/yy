package com.shifeng.webapi.service.fx.impl;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.shifeng.dto.fx.FxTotalDTO;
import com.shifeng.dto.fx.FxUserMoneyDTO;
import com.shifeng.dto.fx.order.FxTotalOrderDTO;
import com.shifeng.plugin.page.Page;
import com.shifeng.provide.mall.service.MallFxService;
import com.shifeng.response.ReqResponse;
import com.shifeng.webapi.service.fx.FxService;

/**
 * 商城分销
 * @author Win
 *
 */
@Service("fxServiceImpl")
public class FxServiceImpl implements FxService{

	protected Logger logger = Logger.getLogger(this.getClass());
	
	@Resource(name = "mallFxService")
	protected MallFxService mallFxService;
	
	/**
	 * 获取我的订单列表
	 * @param user_id 用户ID
	 * @param day	（0：全部订单；1：今日订单；2：昨天订单；3：本周订单；4：本月订单）
	 * @param recommended_userid 我的分销用户id
	 * @param currentPage 当前页
	 * @return
	 */
	public Page getMyFxOrderList(String user_id,String day,String recommended_userid,int currentPage){
		try {
			ReqResponse<Page> result = mallFxService.getMyFxOrderList(user_id,day,recommended_userid,currentPage);
			if(result.getCode() == 0){
				return result.getData();
			}
		} catch (Exception e) {
			logger.error("【获取我的订单列表】出错：", e);
		}
		return null;
	}
	
	/**
	 * 获取我的分销总计
	 * @param user_id
	 * @return
	 */
	public FxTotalDTO getFxTotal(String user_id) {
		try {
			ReqResponse<FxTotalDTO> result = mallFxService.getFxTotal(user_id);
			if(result.getCode() == 0){
				return result.getData();
			}
		} catch (Exception e) {
			logger.error("【获取我的分销总计】出错：", e);
		}
		return null;
	}


	/**
	 * 获取我的分销佣金
	 * @param user_id
	 * @return
	 */
	public FxUserMoneyDTO getMyFxCommission(String user_id) {
		try {
			ReqResponse<FxUserMoneyDTO> result = mallFxService.getMyFxCommission(user_id);
			if(result.getCode() == 0){
				return result.getData();
			}
		} catch (Exception e) {
			logger.error("【获取我的分销佣金】出错：", e);
		}
		return null;
	}
 
	/**
	 * 分销佣金提现
	 * @param user_id 用户id
	 * @param money 提现金额
	 * @param type 提现类型（1：世峰E卡；2：支付宝；3：微信）
	 * @return
	 */
	public boolean exchange(String user_id,double money,int type,ReqResponse<String> req) {
		try {
			ReqResponse<String> result = mallFxService.exchange(user_id,money,type);
			if(result.getCode() == 0){
				req.setData(result.getMsg());
				return true;
			}
		} catch (Exception e) {
			logger.error("【分销佣金提现】出错：", e);
		}
		return false;
	}
	
	/**
	 * 获取我的分销提现总计
	 * @param user_id
	 * @return
	 */
	public FxTotalDTO getFxExchangeTotal(String user_id) {
		return null;
	}
	
	/**
	 * 获取我的分销提现列表
	 * @param user_id 用户ID
	 * @param type 1收入2支出
	 * @param currentPage 当前页
	 * @return
	 */
	public Page getMyFxExchangeList(String user_id,String type,int currentPage) {
		try {
			ReqResponse<Page> result = mallFxService.getMyFxExchangeList(user_id,type,currentPage);
			if(result.getCode() == 0){
				return result.getData();
			}
		} catch (Exception e) {
			logger.error("【获取我的分销提现列表】出错：", e);
		}
		return null;
	}
	
	/**
	 * 获取我的分销订单总计
	 * @param user_id
	 * @return
	 */
	public FxTotalOrderDTO getOrderTotal(String user_id) {
		try {
			ReqResponse<FxTotalOrderDTO> result = mallFxService.getOrderTotal(user_id);
			if(result.getCode() == 0){
				return result.getData();
			}
		} catch (Exception e) {
			logger.error("【获取我的分销订单总计】出错：", e);
		}
		return null;
	}
	

}
