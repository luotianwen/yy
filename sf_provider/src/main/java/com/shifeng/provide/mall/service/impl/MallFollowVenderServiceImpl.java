package com.shifeng.provide.mall.service.impl;

import javax.annotation.Resource;

import org.apache.log4j.Logger;

import com.alibaba.dubbo.config.annotation.Service;
import com.shifeng.plugin.page.Page;
import com.shifeng.provide.mall.dao.MallFollowVenderDao;
import com.shifeng.provide.mall.service.MallFollowVenderService;
import com.shifeng.response.ReqResponse;

/** 
 * 关注的店铺(mall_followVender)接口实现类
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2017-03-31 16:37:01 
 */  
@Service(timeout=1200000)
public class MallFollowVenderServiceImpl implements MallFollowVenderService{

	protected Logger logger = Logger.getLogger(this.getClass());

	@Resource(name = "mallfollowVenderDao")
	private MallFollowVenderDao mallfollowVenderDao;
	



	/**
	 * 是否已关注店铺
	 * @param user_id
	 * @param shop_id 店铺shop_id
	 * @return
	 */
	public ReqResponse<Boolean> isFollowVender(String user_id,int shop_id) {
		ReqResponse<Boolean> req = new ReqResponse<Boolean>();
		try {
			mallfollowVenderDao.isFollowVender(user_id,shop_id,req);
			return req;
		} catch (Exception e) {
			logger.error("【是否已关注店铺】出错：", e);
			req.setCode(1);
			req.setMsg("【是否已关注店铺】异常");
			return req;
		}
	}
	
	/**
	 * 添加关注店铺
	 * @param user_id
	 * @param shop_id 店铺shop_id
	 * @return
	 */
	public ReqResponse<String> addFollowVender(String user_id,int shop_id) {
		ReqResponse<String> req = new ReqResponse<String>();
		try {
			mallfollowVenderDao.addFollowVender(user_id,shop_id,req);
			return req;
		} catch (Exception e) {
			logger.error("【添加关注店铺】出错：", e);
			req.setCode(1);
			req.setMsg("【添加关注店铺】异常");
			return req;
		}
	}
	

	/**
	 * 根据用户ID获取用户关注店铺列表
	 * @param user_id
	 * @param currentPage 当前页
	 * @return
	 */
	public ReqResponse<Page> getFollowVenderList(String user_id,int currentPage) {
		ReqResponse<Page> req = new ReqResponse<Page>();
		try {
			mallfollowVenderDao.getFollowVenderList(user_id,currentPage,req);
			return req;
		} catch (Exception e) {
			logger.error("【根据用户ID获取用户关注店铺列表】出错：", e);
			req.setCode(1);
			req.setMsg("【根据用户ID获取用户关注店铺列表】异常");
			return req;
		}
	}


	/**
	 * 根据用户ID删除用户关注的店铺
	 * @param user_id
	 * @param shopId  关注shopId，多个英文逗号隔开
	 * @return
	 */
	public ReqResponse<String> deleteFollowVender(String user_id,String shopId) {
		ReqResponse<String> req = new ReqResponse<String>();
		try {
			mallfollowVenderDao.deleteFollowVender(user_id,shopId,req);
			return req;
		} catch (Exception e) {
			logger.error("【根据用户ID删除用户关注的店铺】出错：", e);
			req.setCode(1);
			req.setMsg("【根据用户ID删除用户关注的店铺】异常");
			return req;
		}
	}
	
}
