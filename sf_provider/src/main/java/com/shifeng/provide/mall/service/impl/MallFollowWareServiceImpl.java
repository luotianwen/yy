package com.shifeng.provide.mall.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.shifeng.plugin.page.Page;
import com.shifeng.provide.mall.dao.MallFollowWareDao;
import com.shifeng.provide.mall.service.MallFollowWareService;
import com.shifeng.response.ReqResponse;
import org.apache.log4j.Logger;

import javax.annotation.Resource;

/** 
 * 关注的商品(mall_followWare)接口实现类
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2017-03-31 16:37:01 
 */  
@Service(timeout=1200000)
public class MallFollowWareServiceImpl implements MallFollowWareService{

	protected Logger logger = Logger.getLogger(this.getClass());

	@Resource(name = "mallfollowWareDao")
	private MallFollowWareDao mallfollowWareDao;
	



	/**
	 * 是否已关注商品
	 * @param user_id
	 * @param sku 商品sku
	 * @return
	 */
	public ReqResponse<Boolean> isFollowWare(String user_id,int sku) {
		ReqResponse<Boolean> req = new ReqResponse<Boolean>();
		try {
			mallfollowWareDao.isFollowWare(user_id,sku,req);
			return req;
		} catch (Exception e) {
			logger.error("【是否已关注商品】出错：", e);
			req.setCode(1);
			req.setMsg("【是否已关注商品】异常");
			return req;
		}
	}
	
	/**
	 * 添加关注商品
	 * @param user_id
	 * @param sku 商品sku
	 * @return
	 */
	public ReqResponse<String> addFollowWare(String user_id,int sku) {
		ReqResponse<String> req = new ReqResponse<String>();
		try {
			mallfollowWareDao.addFollowWare(user_id,sku,req);
			return req;
		} catch (Exception e) {
			logger.error("【添加关注商品】出错：", e);
			req.setCode(1);
			req.setMsg("【添加关注商品】异常");
			return req;
		}
	}

	@Override
	public ReqResponse<String> addFollowWare(String user_id, int[] sku) {
		ReqResponse<String> req = new ReqResponse<String>();
		try {
			mallfollowWareDao.addFollowWare(user_id,sku,req);
			return req;
		} catch (Exception e) {
			logger.error("【添加关注商品】出错：", e);
			req.setCode(1);
			req.setMsg("【添加关注商品】异常");
			return req;
		}
	}


	/**
	 * 根据用户ID获取用户关注商品列表
	 * @param user_id
	 * @param currentPage 当前页
	 * @return
	 */
	public ReqResponse<Page> getFollowWareList(String user_id,int currentPage) {
		ReqResponse<Page> req = new ReqResponse<Page>();
		try {
			mallfollowWareDao.getFollowWareList(user_id,currentPage,req);
			return req;
		} catch (Exception e) {
			logger.error("【根据用户ID获取用户关注商品列表】出错：", e);
			req.setCode(1);
			req.setMsg("【根据用户ID获取用户关注商品列表】异常");
			return req;
		}
	}


	/**
	 * 根据用户ID删除用户关注的商品
	 * @param user_id
	 * @param sku  关注sku，多个英文逗号隔开
	 * @return
	 */
	public ReqResponse<String> deleteFollowWare(String user_id,String sku) {
		ReqResponse<String> req = new ReqResponse<String>();
		try {
			mallfollowWareDao.deleteFollowWare(user_id,sku,req);
			return req;
		} catch (Exception e) {
			logger.error("【根据用户ID删除用户关注的商品】出错：", e);
			req.setCode(1);
			req.setMsg("【根据用户ID删除用户关注的商品】异常");
			return req;
		}
	}
	 
	
}
