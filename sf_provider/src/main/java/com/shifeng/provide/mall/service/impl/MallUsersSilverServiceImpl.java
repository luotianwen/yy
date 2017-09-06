package com.shifeng.provide.mall.service.impl;

import javax.annotation.Resource;

import org.apache.log4j.Logger;

import com.alibaba.dubbo.config.annotation.Service;
import com.shifeng.entity.mall.MallUsersSilver;
import com.shifeng.plugin.page.Page;
import com.shifeng.provide.mall.dao.MallUsersSilverDao;
import com.shifeng.provide.mall.service.MallUsersSilverService;
import com.shifeng.response.ReqResponse;

/** 
 * 我的银币(mall_users_silver)接口实现类
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2017-03-22 18:38:25 
 */  
@Service(timeout=1200000)
public class MallUsersSilverServiceImpl implements MallUsersSilverService{

    private Logger logger = Logger.getLogger(this.getClass());

	@Resource(name = "mallUsersSilverDao")
	private MallUsersSilverDao mallUsersSilverDao;
	


	/**
	 * 获取我的银币
	 * @param user_id 用户id
	 * @return
	 */
	public ReqResponse<MallUsersSilver> getSilverCoin(String user_id) {
		ReqResponse<MallUsersSilver> req = new ReqResponse<MallUsersSilver>();
		try {
			mallUsersSilverDao.getSilverCoin(user_id,req);
			return req;
		} catch (Exception e) {
			logger.error("【获取我的银币】出错：", e);
			req.setCode(1);
			req.setMsg("【获取我的银币】异常");
			return req;
		}
	}
	
	/**
	 * 银币兑换记录
	 * @param user_id 用户id
	 * @param currentPage 当前页
	 * @return
	 */
	public ReqResponse<Page<String>> exchangeRecord(String user_id,int currentPage) {
		ReqResponse<Page<String>> req = new ReqResponse<Page<String>>();
		try {
			mallUsersSilverDao.exchangeRecord(user_id,currentPage,null,req);
			return req;
		} catch (Exception e) {
			logger.error("【银币兑换记录】出错：", e);
			req.setCode(1);
			req.setMsg("【银币兑换记录】异常");
			return req;
		}
	}
	
	/**
	 * 银币兑换记录
	 * @param user_id 用户id
	 * @param currentPage 当前页
	 * @param pageSize 每页条数
	 * @return
	 */
	public ReqResponse<Page<String>> exchangeRecord(String user_id,int currentPage,int pageSize) {
		ReqResponse<Page<String>> req = new ReqResponse<Page<String>>();
		try {
			mallUsersSilverDao.exchangeRecord(user_id,currentPage,pageSize,req);
			return req;
		} catch (Exception e) {
			logger.error("【银币兑换记录】出错：", e);
			req.setCode(1);
			req.setMsg("【银币兑换记录】异常");
			return req;
		}
	}
	


	/**
	 * 银币兑换记录
	 * @param user_id 用户id
	 * @param type 1收入2兑换
	 * @param currentPage 当前页
	 * @return
	 */
	public ReqResponse<Page> exchangeRecord(String user_id, String type, int currentPage){
		ReqResponse<Page> req = new ReqResponse<Page>();
		try {
			mallUsersSilverDao.exchangeRecord(user_id,type,currentPage,null,req);
			return req;
		} catch (Exception e) {
			logger.error("【银币兑换记录】出错：", e);
			req.setCode(1);
			req.setMsg("【银币兑换记录】异常");
			return req;
		}
	}
	
	
	
	/**
	 * 银币兑换
	 * @param user_id 用户id
	 * @return
	 */
	public ReqResponse<String> exchange(String user_id) {
		ReqResponse<String> req = new ReqResponse<String>();
		try {
			mallUsersSilverDao.updateExchange(user_id,req);
			return req;
		} catch (Exception e) {
			logger.error("【银币兑换】出错：", e);
			req.setCode(1);
			req.setMsg("【银币兑换】异常");
			return req;
		}
	}
	 
	
}
