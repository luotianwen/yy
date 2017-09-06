package com.shifeng.webapi.service.user.impl;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.shifeng.dto.mall.usercenter.StatisticDTO;
import com.shifeng.entity.user.SysUser;
import com.shifeng.provide.sysuser.service.SysUserService;
import com.shifeng.provide.usercenter.service.MallUserCenterService;
import com.shifeng.response.ReqResponse;
import com.shifeng.webapi.service.user.UserCenterService;

/**
 * 用户中心
 * @author WinZhong
 *
 */
@Service("userCenterServiceImpl")
public class UserCenterServiceImpl implements UserCenterService {

	protected Logger logger = Logger.getLogger(this.getClass());
	
	@Resource(name = "sysUserService")
	protected SysUserService userService;
	
	@Resource(name = "mallUserCenterService")
	protected MallUserCenterService mallUserCenterService;
	

	


	/**
	 * 根据用户id修改用户头像
	 * @param user_id 用户id
	 * @param headimgurl 头像URL地址
	 * @return
	 */
	public boolean updateHeadImg(String user_id, String headimgurl) {
		try {
			ReqResponse<String> req = userService.updateHeadImg(user_id, headimgurl);
			if(req.getCode() == 0){
				return true;
			}
		} catch (Exception e) {
			logger.error("【根据用户id修改用户头像】出错：", e);
		}
		return false;
	}


	/**
	 * 根据用户id修改用户基本信息（该接口仅支持修改昵称、性别、生日登基本用户信息，不支持修改用户密码 、头像操作）
	 * @param sysUser  用户实体
	 * @return
	 */
	public boolean updateUserInfo(SysUser sysUser) {
		try {
			ReqResponse<String> req = userService.updateUserInfo(sysUser);
			if(req.getCode() == 0){
				return true;
			}
		} catch (Exception e) {
			logger.error("【根据用户id修改用户头像】出错：", e);
		}
		return false;
	}
	
	

	
	/**
	 * 获取用户中心数据统计
	 * @param user_id
	 * @return
	 */
	public StatisticDTO getStatistic(String user_id) {
		try {
			ReqResponse<StatisticDTO> req = mallUserCenterService.getStatistic(user_id);
			if(req.getCode() == 0){
				return req.getData();
			}
		} catch (Exception e) {
			logger.error("【获取用户中心数据统计】出错：", e);
		}
		return null;
	}
	

}
