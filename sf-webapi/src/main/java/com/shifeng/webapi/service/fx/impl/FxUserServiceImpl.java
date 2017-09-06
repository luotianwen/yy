package com.shifeng.webapi.service.fx.impl;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.shifeng.dto.fx.FxUserDTO;
import com.shifeng.plugin.page.Page;
import com.shifeng.provide.distributor.service.DistributorService;
import com.shifeng.response.ReqResponse;
import com.shifeng.webapi.service.fx.FxUserService;

/**
 * 我的分销用户Service
 * @author WinZhong
 *
 */
@Service("fxUserServiceImpl")
public class FxUserServiceImpl implements FxUserService{

	protected Logger logger = Logger.getLogger(this.getClass());
	
	@Resource(name = "distributorService")
	protected DistributorService distributorService;
	
	
	/**
	 * 检测分销用户手机号是否存在
	 * @param phone  手机号
	 * @return 存在 false  不存在 true
	 */
	public boolean isPhoneExists(String phone) {
		try {
			ReqResponse<String> result = distributorService.isPhoneExists(phone);
			if(result.getCode() == 0){
				return true;
			}
		} catch (Exception e) {
			logger.error("【检测分销用户手机号是否存在】出错：", e);
		}
		return false;
	}
	

	/**
	 * 激活分销用户账号，即设置账户密码
	 * @param phone  	手机号
	 * @param password  密码
	 * @return
	 */
	public boolean activation(String phone,String password) {
		try {
			ReqResponse<String> result = distributorService.activation(phone,password);
			if(result.getCode() == 0){
				return true;
			}
		} catch (Exception e) {
			logger.error("【激活分销用户账号，即设置账户密码】出错：", e);
		}
		return false;
	}

	
	/**
	 * 添加我的分销商
	 * @param user_id	用户id
	 * @param name	分销商名称
	 * @param phone	分销商手机号
	 * @param remark	分销商备注
	 * @return
	 */
	public boolean addDistributor(String user_id,String name,String phone,String remark) {
		try {
			ReqResponse<String> result = distributorService.addDistributor(user_id,name,phone,remark);
			if(result.getCode() == 0){
				return true;
			}
		} catch (Exception e) {
			logger.error("【添加我的分销商】出错：", e);
		}
		return false;
	}

	
	/**
	 * 删除我的分销商
	 * @param user_id	用户id
	 * @param recommended_userid	被推荐用户id
	 * @return
	 */
	public boolean deleteDistributor(String user_id,String recommended_userid) {
		try {
			ReqResponse<String> result = distributorService.deleteDistributor(user_id,recommended_userid);
			if(result.getCode() == 0){
				return true;
			}
		} catch (Exception e) {
			logger.error("【删除我的分销商】出错：", e);
		}
		return false;
	}

	
	/**
	 * 修改我的分销商
	 * @param user_id	用户id
	 * @param recommended_userid	被推荐用户id
	 * @param name	分销商名称
	 * @param phone	分销商手机号
	 * @param remark	分销商备注
	 * @return
	 */
	public boolean updateDistributor(String user_id,String recommended_userid,String name,String remark) {
		try {
			ReqResponse<String> result = distributorService.updateDistributor(user_id,recommended_userid,name,remark);
			if(result.getCode() == 0){
				return true;
			}
		} catch (Exception e) {
			logger.error("【修改我的分销商】出错：", e);
		}
		return false;
	}

	
	/**
	 * 获取我的分销商列表
	 * @param page	用户id
	 * @param name	分销商名称
	 * @param phone	分销商手机号
	 * @param currentPage 当前页
	 * @return
	 */
	public Page getDistributorList(String user_id,String name,String phone,int currentPage) {
		try {
			ReqResponse<Page> result = distributorService.getDistributorList(user_id,name,phone,currentPage);
			if(result.getCode() == 0){
				return result.getData();
			}
		} catch (Exception e) {
			logger.error("【获取我的分销商列表】出错：", e);
		}
		return null;
	}

	
	/**
	 * 获取我的分销商详情
	 * @param user_id	用户id
	 * @param recommended_userid	被推荐用户id
	 * @return
	 */
	public FxUserDTO getDistributorById(String user_id,String recommended_userid) {
		try {
			ReqResponse<FxUserDTO> result = distributorService.getDistributorById(user_id,recommended_userid);
			if(result.getCode() == 0){
				return result.getData();
			}
		} catch (Exception e) {
			logger.error("【获取我的分销商详情】出错：", e);
		}
		return null;
	}

}
