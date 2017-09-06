package com.shifeng.webapi.service.user.impl;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.shifeng.entity.mall.MallUsersSilver;
import com.shifeng.plugin.page.Page;
import com.shifeng.provide.mall.service.MallUsersSilverService;
import com.shifeng.response.ReqResponse;
import com.shifeng.webapi.service.user.MySilverService;

/**
 * 我的银币
 * @author WinZhong
 *
 */
@Service("mySilverServiceImpl")
public class MySilverServiceImpl implements MySilverService{

	protected Logger logger = Logger.getLogger(this.getClass());
	
	@Resource(name = "mallUsersSilverService")
	protected MallUsersSilverService mallUsersSilverService;

	/**
	 * 获取我的银币
	 * @param user_id 用户id
	 * @return
	 */
	public MallUsersSilver getSilverCoin(String user_id) {
		try {
			ReqResponse<MallUsersSilver> result = mallUsersSilverService.getSilverCoin(user_id);
			if(result.getCode() == 0){
				return result.getData();
			}
		} catch (Exception e) {
			logger.error("【获取我的银币】出错：", e);
		}
		MallUsersSilver mallUsersSilver = new MallUsersSilver();
		mallUsersSilver.setAllsilver(0);
		mallUsersSilver.setLastsilver(0);
		mallUsersSilver.setSilver(0);
		return mallUsersSilver;
	}
	
	/**
	 * 银币兑换记录
	 * @param user_id 用户id
	 * @param currentPage 当前页
	 * @return
	 */
	public Page exchangeRecord(String user_id,int currentPage) {
		try {
			ReqResponse<Page<String>>  result = mallUsersSilverService.exchangeRecord(user_id,currentPage);
			if(result.getCode() == 0){
				return result.getData();
			}
		} catch (Exception e) {
			logger.error("【银币兑换记录】出错：", e);
		}
		return null;
	}
	
	/**
	 * 银币兑换记录
	 * @param user_id 用户id
	 * @param currentPage 当前页
	 * @param pageSize 每页条数
	 * @return
	 */
	public Page exchangeRecord(String user_id,int currentPage,int pageSize) {
		try {
			ReqResponse<Page<String>>  result = mallUsersSilverService.exchangeRecord(user_id,currentPage,pageSize);
			if(result.getCode() == 0){
				return result.getData();
			}
		} catch (Exception e) {
			logger.error("【银币兑换记录】出错：", e);
		}
		return null;
	}

	
	/**
	 * 银币兑换记录
	 * @param user_id 用户id
	 * @param type 1收入2兑换
	 * @param currentPage 当前页
	 * @return
	 */
	public Page exchangeRecord(String user_id,String type,int currentPage){
		try {
			ReqResponse<Page>  result = mallUsersSilverService.exchangeRecord(user_id,type,currentPage);
			if(result.getCode() == 0){
				return result.getData();
			}
		} catch (Exception e) {
			logger.error("【银币兑换记录】出错：", e);
		}
		return null;
	}
	
	/**
	 * 银币兑换
	 * @param user_id 用户id
	 * @return
	 */
	public boolean exchange(String user_id,ReqResponse<String> req) {
		try {
			ReqResponse<String>  result = mallUsersSilverService.exchange(user_id);
			if(result.getCode() == 0){
				req.setData(result.getMsg());
				return true;
			}
		} catch (Exception e) {
			logger.error("【银币兑换】出错：", e);
		}
		return false;
	}

}
