package com.shifeng.provide.distributor.service;

import java.util.List;

import com.shifeng.dto.fx.FxUserDTO;
import com.shifeng.plugin.page.Page;
import com.shifeng.response.ReqResponse;

/**
 * 分销用户接口服务
 * @author WinZhong
 *
 */
public interface DistributorService {
	
	
	/**
	 * 检测分销用户手机号是否存在
	 * @param phone  手机号
	 * @return
	 */
	ReqResponse<String> isPhoneExists(String phone);
	

	/**
	 * 激活分销用户账号，即设置账户密码
	 * @param phone  	手机号
	 * @param password  密码
	 * @return
	 */
	ReqResponse<String> activation(String phone,String password);

	
	/**
	 * 添加我的分销商
	 * @param user_id	用户id
	 * @param name	分销商名称
	 * @param phone	分销商手机号
	 * @param remark	分销商备注
	 * @return
	 */
	ReqResponse<String> addDistributor(String user_id,String name,String phone,String remark);

	
	/**
	 * 删除我的分销商
	 * @param user_id	用户id
	 * @param recommended_userid	被推荐用户id
	 * @return
	 */
	ReqResponse<String> deleteDistributor(String user_id,String recommended_userid);

	
	/**
	 * 修改我的分销商
	 * @param user_id	用户id
	 * @param recommended_userid	被推荐用户id
	 * @param name	分销商名称
	 * @param phone	分销商手机号
	 * @param remark	分销商备注
	 * @return
	 */
	ReqResponse<String> updateDistributor(String user_id,String recommended_userid,String name,String remark);

	
	/**
	 * 获取我的分销商列表
	 * @param page	用户id
	 * @param name	分销商名称
	 * @param phone	分销商手机号
	 * @param currentPage 当前页
	 * @return
	 */
	ReqResponse<Page> getDistributorList(String user_id,String name,String phone,int currentPage);

	
	/**
	 * 获取我的分销商详情
	 * @param user_id	用户id
	 * @param recommended_userid	被推荐用户id
	 * @return
	 */
	ReqResponse<FxUserDTO> getDistributorById(String user_id,String recommended_userid);
	

}
