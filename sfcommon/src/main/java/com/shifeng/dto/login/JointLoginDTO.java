package com.shifeng.dto.login;

import java.io.Serializable;

import com.shifeng.entity.user.JointLogin;
import com.shifeng.entity.user.SysUser;

public class JointLoginDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	//用户信息
	private SysUser user;
	//联合登陆信息
	private JointLogin JointLogin;
	public SysUser getUser() {
		return user;
	}
	public void setUser(SysUser user) {
		this.user = user;
	}
	public JointLogin getJointLogin() {
		return JointLogin;
	}
	public void setJointLogin(JointLogin jointLogin) {
		JointLogin = jointLogin;
	}
	@Override
	public String toString() {
		return "JointLoginDTO [user=" + user + ", JointLogin=" + JointLogin + "]";
	}
	
	

}
