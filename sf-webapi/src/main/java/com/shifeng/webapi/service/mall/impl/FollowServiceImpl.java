package com.shifeng.webapi.service.mall.impl;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.shifeng.entity.mall.MallFollowWare;
import com.shifeng.plugin.page.Page;
import com.shifeng.provide.mall.service.MallFollowVenderService;
import com.shifeng.provide.mall.service.MallFollowWareService;
import com.shifeng.response.ReqResponse;
import com.shifeng.webapi.service.mall.FollowService;

/**
 * 关注
 * @author WinZhong
 *
 */
@Service("followServiceImpl")
public class FollowServiceImpl implements FollowService{

	protected Logger logger = Logger.getLogger(this.getClass());
	
	@Resource(name = "mallFollowWareService")
	protected MallFollowWareService mallFollowWareService;
	
	@Resource(name = "mallFollowVenderService")
	protected MallFollowVenderService mallFollowVenderService;
	


	
	/**
	 * 是否已关注商品
	 * @param user_id
	 * @param sku 商品sku
	 * @return 已关注 true 未关注false
	 */
	public boolean isFollowWare(String user_id,int sku) {
		try {
			ReqResponse<Boolean> result = mallFollowWareService.isFollowWare(user_id,sku);
			if(result.getCode() == 0){
				if(true == result.getData()){
					return true;
				}
			}
		} catch (Exception e) {
			logger.error("【添加关注商品】出错：", e);
		}
		return false;
	}
	/**
	 * 添加关注商品
	 * @param user_id
	 * @param sku 商品sku
	 * @return
	 */
	public boolean addFollowWare(String user_id,int sku){
		try {
			ReqResponse<String> result = mallFollowWareService.addFollowWare(user_id,sku);
			if(result.getCode() == 0){
				return true;
			}
		} catch (Exception e) {
			logger.error("【添加关注商品】出错：", e);
		}
		return false;
	}
	

	/**
	 * 根据用户ID获取用户关注商品列表
	 * @param user_id
	 * @param currentPage 当前页
	 * @return
	 */
	public Page getFollowWareList(String user_id,int currentPage) {
		try {
			ReqResponse<Page> result = mallFollowWareService.getFollowWareList(user_id,currentPage);
			if(result.getCode() == 0){
				return result.getData();
			}
		} catch (Exception e) {
			logger.error("【根据用户ID获取用户关注商品列表】出错：", e);
		}
		return null;
	}


	/**
	 * 根据用户ID删除用户关注的商品
	 * @param user_id
	 * @param sku  关注sku，多个英文逗号隔开
	 * @return
	 */
	public boolean deleteFollowWare(String user_id,String sku) {
		try {
			ReqResponse<String> result = mallFollowWareService.deleteFollowWare(user_id,sku);
			if(result.getCode() == 0){
				return true;
			}
		} catch (Exception e) {
			logger.error("【根据用户ID删除用户关注的商品】出错：", e);
		}
		return false;
	}
	
	

	
	/**
	 * 是否已关注店铺
	 * @param user_id
	 * @param shop_id 店铺shop_id
	 * @return 已关注 true 未关注false
	 */
	public boolean isFollowVender(String user_id,int shop_id) {
		try {
			ReqResponse<Boolean> result = mallFollowVenderService.isFollowVender(user_id,shop_id);
			if(result.getCode() == 0){
				if(true == result.getData()){
					return true;
				}
			}
		} catch (Exception e) {
			logger.error("【添加关注商品】出错：", e);
		}
		return false;
	}
	
	/**
	 * 添加关注店铺
	 * @param user_id
	 * @param shop_id 店铺ID
	 * @return
	 */
	public boolean addFollowVender(String user_id,int shop_id) {
		try {
			ReqResponse<String> result = mallFollowVenderService.addFollowVender(user_id,shop_id);
			if(result.getCode() == 0){
				return true;
			}
		} catch (Exception e) {
			logger.error("【添加关注商品】出错：", e);
		}
		return false;
	}

	/**
	 * 根据用户ID获取关注店铺列表
	 * @param user_id
	 * @param currentPage 当前页
	 * @return
	 */
	public Page getFollowVenderList(String user_id, int currentPage) {
		try {
			ReqResponse<Page> result = mallFollowVenderService.getFollowVenderList(user_id,currentPage);
			if(result.getCode() == 0){
				return result.getData();
			}
		} catch (Exception e) {
			logger.error("【根据用户ID获取用户关注店铺列表】出错：", e);
		}
		return null;
	}


	/**
	 * 根据用户ID删除用户关注的店铺
	 * @param user_id
	 * @param shopId  关注shopId，多个英文逗号隔开
	 * @return
	 */
	public boolean deleteFollowVender(String user_id,String shopId) {
		try {
			ReqResponse<String> result = mallFollowVenderService.deleteFollowVender(user_id,shopId);
			if(result.getCode() == 0){
				return true;
			}
		} catch (Exception e) {
			logger.error("【根据用户ID删除用户关注的店铺】出错：", e);
		}
		return false;
	}

}
