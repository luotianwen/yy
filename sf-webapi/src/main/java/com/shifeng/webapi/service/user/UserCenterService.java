package com.shifeng.webapi.service.user;

import com.shifeng.dto.mall.usercenter.StatisticDTO;
import com.shifeng.entity.user.SysUser;
import com.shifeng.response.ReqResponse;

/**
 * 用户中心
 * @author WinZhong
 *
 */
public interface UserCenterService {
	


	/**
	 * 根据用户id修改用户头像
	 * @param user_id 用户id
	 * @param headimgurl 头像URL地址
	 * @return
	 */
	boolean updateHeadImg(String user_id, String headimgurl);


	/**
	 * 根据用户id修改用户基本信息（该接口仅支持修改昵称、性别、生日登基本用户信息，不支持修改用户密码 、头像操作）
	 * @param sysUser  用户实体
	 * @return
	 */
	boolean updateUserInfo(SysUser sysUser);
	

	
	/**
	 * 获取用户中心数据统计
	 * @param user_id
	 * @return
	 */
	StatisticDTO getStatistic(String user_id);
	

}
