package com.shifeng.op.entity.authority;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 系统分组表(arrays)实体类
 * 
 * @author 世峰户外商城
 */
public class Arrays implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// id
	private String aId;
	// 组名称
	private String aName;
	// 分组排序
	private int aOrder;
	// 创建用户
	private String aCreateUser;
	// 更新用户
	private String aUpUser;
	// 更新时间
	private Date aUpTime;
	// 分组类别（1：系统分组、2：用户分组）
	private int aType;
	// 角色集合
	private List<Roles> roles;

	/*----------------------------------------------------*/
	public int getaType() {
		return aType;
	}

	public void setaType(int aType) {
		this.aType = aType;
	}

	public String getaCreateUser() {
		return aCreateUser;
	}

	public void setaCreateUser(String aCreateUser) {
		this.aCreateUser = aCreateUser;
	}

	public String getaId() {
		return aId;
	}

	public void setaId(String aId) {
		this.aId = aId;
	}

	public String getaName() {
		return aName;
	}

	public void setaName(String aName) {
		this.aName = aName;
	}


	public String getaUpUser() {
		return aUpUser;
	}

	public void setaUpUser(String aUpUser) {
		this.aUpUser = aUpUser;
	}

	public Date getaUpTime() {
		return aUpTime;
	}

	public void setaUpTime(Date aUpTime) {
		this.aUpTime = aUpTime;
	}

	public int getaOrder() {
		return aOrder;
	}

	public void setaOrder(int aOrder) {
		this.aOrder = aOrder;
	}

	public List<Roles> getRoles() {
		return roles;
	}

	public void setRoles(List<Roles> roles) {
		this.roles = roles;
	}

}
