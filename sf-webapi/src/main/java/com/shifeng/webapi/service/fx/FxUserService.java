package com.shifeng.webapi.service.fx;

import com.shifeng.dto.fx.FxUserDTO;
import com.shifeng.plugin.page.Page;

/**
 * 我的分销用户Service
 * @author WinZhong
 *
 */
public interface FxUserService {
	
	
	/**
	 * 检测分销用户手机号是否存在
	 * @param phone  手机号
	 * @return 存在 false  不存在 true
	 */
	boolean isPhoneExists(String phone);
	

	/**
	 * 激活分销用户账号，即设置账户密码
	 * @param phone  	手机号
	 * @param password  密码
	 * @return
	 */
	boolean activation(String phone,String password);

	
	/**
	 * 添加我的分销商
	 * @param user_id	用户id
	 * @param name	分销商名称
	 * @param phone	分销商手机号
	 * @param remark	分销商备注
	 * @return
	 */
	boolean addDistributor(String user_id,String name,String phone,String remark);

	
	/**
	 * 删除我的分销商
	 * @param user_id	用户id
	 * @param recommended_userid	被推荐用户id
	 * @return
	 */
	boolean deleteDistributor(String user_id,String recommended_userid);

	
	/**
	 * 修改我的分销商
	 * @param user_id	用户id
	 * @param recommended_userid	被推荐用户id
	 * @param name	分销商名称
	 * @param phone	分销商手机号
	 * @param remark	分销商备注
	 * @return
	 */
	boolean updateDistributor(String user_id,String recommended_userid,String name,String remark);

	
	/**
	 * 获取我的分销商列表
	 * @param page	用户id
	 * @param name	分销商名称
	 * @param phone	分销商手机号
	 * @param currentPage 当前页
	 * @return
	 */
	Page getDistributorList(String user_id,String name,String phone,int currentPage);

	
	/**
	 * 获取我的分销商详情
	 * @param user_id	用户id
	 * @param recommended_userid	被推荐用户id
	 * @return
	 */
	FxUserDTO getDistributorById(String user_id,String recommended_userid);

}
