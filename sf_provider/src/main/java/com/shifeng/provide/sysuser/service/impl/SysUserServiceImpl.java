package com.shifeng.provide.sysuser.service.impl;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.shifeng.entity.user.SysUser;
import com.shifeng.provide.sysuser.dao.SysUserDao;
import com.shifeng.provide.sysuser.service.SysUserService;
import com.shifeng.response.ReqResponse; 

/** 
 * 用户表(SysUser)接口实现类
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2017-02-07 17:13:02 
 */
@Service("SysUserServiceImpl")
public class SysUserServiceImpl implements SysUserService{

	@Resource(name = "sysUserDao")
	private SysUserDao sysUserDao;

	protected Logger logger = Logger.getLogger(this.getClass());
	

	/**
	 * 根据用户id修改用户状态
	 * @param userId  用户id
	 * @param state  状态(1正常 2冻结)
	 * @param operatorName  修改人名称
	 * @return
	 */
	public ReqResponse<String> updateUserState(int userId,int state,String operatorName) {
		ReqResponse<String> req = new ReqResponse<String>();
		try {
			 sysUserDao.updateUserState(userId, state, operatorName,req);
			 return req;
		} catch (Exception e) {
			logger.error("【根据用户id修改用户状态】出错：", e);
			req.setCode(1);
			req.setMsg("修改用户状态异常");
			return req;
		}
		
	}
	

	
	/**
	 * 根据用户账号（账户名/手机号/邮箱）验证密码
	 * @param account  账号
	 * @param password  密码
	 * @return
	 */
	public ReqResponse<SysUser> checkPassword(String account,String password) {
		ReqResponse<SysUser> req = new ReqResponse<SysUser>();
		try {
			sysUserDao.checkPassword(account,password,req);
			return req;
		} catch (Exception e) {
			logger.error("【根据用户账号（账户名/手机号/邮箱）验证密码】出错：", e);
			req.setCode(1);
			req.setMsg("密码验证异常");
			return req;
		}
		
	}

	
	/**
	 * 检测账号（账户名/手机号/邮箱）是否存在
	 * @param account  账号
	 * @return
	 */
	public ReqResponse<String> checkAccountExists(String account) {
		ReqResponse<String> req = new ReqResponse<String>();
		try {
			sysUserDao.checkAccountExists(account, req);
			return req;
		} catch (Exception e) {
			logger.error("【检测账号（账户名/手机号/邮箱）是否存在】出错：", e);
			req.setCode(1);
			req.setMsg("检测账号异常");
			return req;
		}
	}

	
	/**
	 * 根据用户账号（账户名/手机号/邮箱）修改密码
	 * @param account  账号
	 * @param password  密码
	 * @param newPassword  新密码
	 * @param operatorName  修改人名称
	 * @return
	 */
	public ReqResponse<String> updatePassword(String account,String password,String newPassword,String operatorName) {
		ReqResponse<String> req = new ReqResponse<String>();
		try {
			sysUserDao.updatePassword(account, password, newPassword, operatorName, req);
			return req;
		} catch (Exception e) {
			logger.error("【根据用户账号（账户名/手机号/邮箱）修改密码】出错：", e);
			req.setCode(1);
			req.setMsg("密码修改异常");
			return req;
		}
	}
	
	/**
	 * 添加用户
	 * @param sysUser  用户实体
	 * @return
	 */
	public ReqResponse<Integer> addUser(SysUser sysUser) {
		ReqResponse<Integer> req = new ReqResponse<Integer>();
		try {
			sysUserDao.addUser(sysUser, req);
			return req;
		} catch (Exception e) {
			logger.error("【添加用户】出错：", e);
			req.setCode(1);
			req.setMsg("添加用户异常");
			return req;
		}
	}

	/**
	 * 根据用户账号（账户名）修改密码
	 * @param account  账号
	 * @param password  密码
	 * @param operatorName  修改人名称
	 * @return
	 */
	public ReqResponse<String> updatePasswordByAccount(String account, String password, String operatorName) {
		ReqResponse<String> req = new ReqResponse<String>();
		try {
			sysUserDao.updatePasswordByAccount(account, password,  operatorName, req);
			return req;
		} catch (Exception e) {
			logger.error("【根据用户账号（账户名）修改密码】出错：", e);
			req.setCode(1);
			req.setMsg("密码修改异常");
			return req;
		}
	}


	/**
	 * 根据用户手机号修改密码
	 * @param phone  手机号
	 * @param password  密码
	 * @return
	 */
	public ReqResponse<String> updatePasswordByPhone(String phone, String password) {
		ReqResponse<String> req = new ReqResponse<String>();
		try {
			sysUserDao.updatePasswordByPhone(phone, password,req);
			return req;
		} catch (Exception e) {
			logger.error("【根据用户账号（账户名）修改密码】出错：", e);
			req.setCode(1);
			req.setMsg("密码修改异常");
			return req;
		}
	}


	/**
	 * 根据用户id修改用户头像
	 * @param user_id 用户id
	 * @param headimgurl 头像URL地址
	 * @return
	 */
	public ReqResponse<String> updateHeadImg(String user_id, String headimgurl) {
		ReqResponse<String> req = new ReqResponse<String>();
		try {
			sysUserDao.updateHeadImg(user_id, headimgurl, req);
			return req;
		} catch (Exception e) {
			logger.error("【根据用户id修改用户基本信息】出错：", e);
			req.setCode(1);
			req.setMsg("修改头像异常");
			return req;
		}
	}



	/**
	 * 根据用户id修改用户基本信息（该接口仅支持修改昵称、性别、生日登基本用户信息，不支持修改用户密码 、头像操作）
	 * @param sysUser  用户实体
	 * @return
	 */
	public ReqResponse<String> updateUserInfo(SysUser sysUser) {
		ReqResponse<String> req = new ReqResponse<String>();
		try {
			sysUserDao.updateUserInfo(sysUser, req);
			return req;
		} catch (Exception e) {
			logger.error("【根据用户id修改用户基本信息】出错：", e);
			req.setCode(1);
			req.setMsg("基本信息修改异常");
			return req;
		}
	}
	


	/**
	 * 用户绑定手机号
	 * @param user_id  用户ID
	 * @param phone  手机号
	 * @return true 修改成功  false 修改失败
	 */
	public ReqResponse<String> bindPhone(String user_id, String phone) {
		ReqResponse<String> req = new ReqResponse<String>();
		try {
			sysUserDao.updateBindPhone(user_id,phone, req);
			return req;
		} catch (Exception e) {
			logger.error("【用户绑定手机号】出错：", e);
			req.setCode(1);
			req.setMsg("用户绑定手机号异常");
			return req;
		}
	}

	/**
	 * 用户更换手机号
	 * @param phone  手机号
	 * @param newPhone  新手机号
	 * @return
	 */
	public ReqResponse<String> updatePhone(String phone, String newPhone){
		ReqResponse<String> req = new ReqResponse<String>();
		try {
			sysUserDao.updatePhone(phone, newPhone,req);
			return req;
		} catch (Exception e) {
			logger.error("【用户更换手机号】出错：", e);
			req.setCode(1);
			req.setMsg("用户更换手机号异常");
			return req;
		}
	}
	
}
