package com.shifeng.provide.mall.service.impl;

import javax.annotation.Resource;

import org.apache.log4j.Logger;

import com.alibaba.dubbo.config.annotation.Service;
import com.shifeng.dto.fx.FxTotalDTO;
import com.shifeng.dto.fx.FxUserMoneyDTO;
import com.shifeng.dto.fx.order.FxTotalOrderDTO;
import com.shifeng.plugin.page.Page;
import com.shifeng.provide.mall.dao.MallFxDao;
import com.shifeng.provide.mall.service.MallFxService;
import com.shifeng.response.ReqResponse;

/**
 * 商城分销
 * @author Win
 *
 */
@Service(timeout=1200000)
public class MallFxServiceImpl implements MallFxService{

    private Logger logger = Logger.getLogger(this.getClass());

	@Resource(name = "mallFxDao")
	private MallFxDao mallFxDao;
	
	/**
	 * 获取我的订单列表
	 * @param user_id 用户ID
	 * @param day	（0：全部订单；1：今日订单；2：昨天订单；3：本周订单；4：本月订单）
	 * @param recommended_userid 我的分销用户id
	 * @param currentPage 当前页
	 * @return
	 */
	public ReqResponse<Page> getMyFxOrderList(String user_id,String day,String recommended_userid,int currentPage) {
		ReqResponse<Page> req = new ReqResponse<Page>();
		try {
			mallFxDao.getMyFxOrderList(user_id,day,recommended_userid,currentPage,req);
			return req;
		} catch (Exception e) {
			logger.error("【获取我的订单列表】出错：", e);
			req.setCode(1);
			req.setMsg("【获取我的订单列表】异常");
			return req;
		}
	}
	
	
	/**
	 * 获取我的分销总计
	 * @param user_id
	 * @return
	 */
	public ReqResponse<FxTotalDTO> getFxTotal(String user_id) {
		ReqResponse<FxTotalDTO> req = new ReqResponse<FxTotalDTO>();
		try {
			mallFxDao.getFxTotal(user_id,req);
			return req;
		} catch (Exception e) {
			logger.error("【获取我的分销总计】出错：", e);
			req.setCode(1);
			req.setMsg("【获取我的分销总计】异常");
			return req;
		}
	}

	
	/**
	 * 获取我的分销佣金
	 * @param user_id
	 * @return
	 */
	public ReqResponse<FxUserMoneyDTO> getMyFxCommission(String user_id) {
		ReqResponse<FxUserMoneyDTO> req = new ReqResponse<FxUserMoneyDTO>();
		try {
			mallFxDao.getMyFxCommission(user_id,req);
			return req;
		} catch (Exception e) {
			logger.error("【获取我的分销佣金】出错：", e);
			req.setCode(1);
			req.setMsg("【获取我的分销佣金】异常");
			return req;
		}
	}
	
	
	/**
	 * 分销佣金提现
	 * @param user_id 用户id
	 * @param money 提现金额
	 * @param type 提现类型（1：世峰E卡；2：支付宝；3：微信）
	 * @return
	 */
	public ReqResponse<String> exchange(String user_id,double money,int type) {
		ReqResponse<String> req = new ReqResponse<String>();
		try {
			mallFxDao.updateEexchange(user_id,money,type,req);
			return req;
		} catch (Exception e) {
			logger.error("【分销佣金提现】出错：", e);
			req.setCode(1);
			req.setMsg("【分销佣金提现】异常");
			return req;
		}
	}
	
	/**
	 * 获取我的分销提现总计
	 * @param user_id
	 * @return
	 */
	public ReqResponse<FxTotalDTO> getFxExchangeTotal(String user_id) {
		ReqResponse<FxTotalDTO> req = new ReqResponse<FxTotalDTO>();
		try {
			mallFxDao.getFxTotal(user_id,req);
			return req;
		} catch (Exception e) {
			logger.error("【获取我的分销提现总计】出错：", e);
			req.setCode(1);
			req.setMsg("【获取我的分销提现总计】异常");
			return req;
		}
	}
	
	/**
	 * 获取我的分销提现列表
	 * @param user_id 用户ID
	 * @param type 1收入2支出
	 * @param currentPage 当前页
	 * @return
	 */
	public ReqResponse<Page> getMyFxExchangeList(String user_id,String type,int currentPage){
		ReqResponse<Page> req = new ReqResponse<Page>();
		try {
			mallFxDao.getMyFxExchangeList(user_id,type,currentPage,req);
			return req;
		} catch (Exception e) {
			logger.error("【获取我的分销提现列表】出错：", e);
			req.setCode(1);
			req.setMsg("【获取我的分销提现列表】异常");
			return req;
		}
	}
	

	
	/**
	 * 获取我的分销订单总计
	 * @param user_id
	 * @return
	 */
	public ReqResponse<FxTotalOrderDTO> getOrderTotal(String user_id) {
		ReqResponse<FxTotalOrderDTO> req = new ReqResponse<FxTotalOrderDTO>();
		try {
			mallFxDao.getOrderTotal(user_id,req);
			return req;
		} catch (Exception e) {
			logger.error("【获取我的分销订单总计】出错：", e);
			req.setCode(1);
			req.setMsg("【获取我的分销订单总计】异常");
			return req;
		}
	}
 
	

}
