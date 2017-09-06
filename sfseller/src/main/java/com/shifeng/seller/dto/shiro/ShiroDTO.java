package com.shifeng.seller.dto.shiro;

import java.io.Serializable;

/**
 * 项目名：compass-data 类描述：数据库权限封装对象 
 */
public class ShiroDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// 角色ID
	private String roleId;
	// 访问资源路径
	private String path;

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

}
