package com.shifeng.op.entity.menu;

import java.io.Serializable;
import java.util.Date;

/**
 * 系统菜单表(menus)实体类
 * 
 * @author 世峰户外商城
 */
public class Menus implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// id
	private String mId;
	// 菜单名称
	private String mName;
	// 菜单父ID
	private String mParentId;
	// 菜单排序
	private int mOrder;
	// 菜单图标
	private String mIcon;
	// 访问路径
	private String mPath;
	// 最后更新时间
	private Date mLastUpTime;
	// 操作人
	private String mLastUpUser;
	
	
	public Date getmLastUpTime() {
		return mLastUpTime;
	}

	public void setmLastUpTime(Date mLastUpTime) {
		this.mLastUpTime = mLastUpTime;
	}

	public String getmLastUpUser() {
		return mLastUpUser;
	}

	public void setmLastUpUser(String mLastUpUser) {
		this.mLastUpUser = mLastUpUser;
	}

	public String getmPath() {
		return mPath;
	}

	public void setmPath(String mPath) {
		this.mPath = mPath;
	}

	public String getmId() {
		return mId;
	}

	public void setmId(String mId) {
		this.mId = mId;
	}

	public String getmName() {
		return mName;
	}

	public void setmName(String mName) {
		this.mName = mName;
	}

	public String getmParentId() {
		return mParentId;
	}

	public void setmParentId(String mParentId) {
		this.mParentId = mParentId;
	}

	public int getmOrder() {
		return mOrder;
	}

	public void setmOrder(int mOrder) {
		this.mOrder = mOrder;
	}

	public String getmIcon() {
		return mIcon;
	}

	public void setmIcon(String mIcon) {
		this.mIcon = mIcon;
	}

}
