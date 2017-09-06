package com.shifeng.op.dto.category;

import java.io.Serializable;

public class PropertcategoryDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// 主键
	private int id;
	// 属性id
	private int pid;
	// 分类id
	private int cid;
	// 属性名
	private String name;
	//是否多选
	private int ismultiple;
	// 排序
	private int sort;
	
	/**
	 * 主键
	 * 
	 * @return
	 */
	public int getId() {
		return id;
	}

	/**
	 * 主键
	 * 
	 * @param type
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * 属性id
	 * 
	 * @return
	 */
	public int getPid() {
		return pid;
	}

	/**
	 * 属性id
	 * 
	 * @param type
	 */
	public void setPid(int pid) {
		this.pid = pid;
	}

	/**
	 * 分类id
	 * 
	 * @return
	 */
	public int getCid() {
		return cid;
	}

	/**
	 * 分类id
	 * 
	 * @param type
	 */
	public void setCid(int cid) {
		this.cid = cid;
	}

	public int getSort() {
		return sort;
	}

	public void setSort(int sort) {
		this.sort = sort;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getIsmultiple() {
		return ismultiple;
	}

	public void setIsmultiple(int ismultiple) {
		this.ismultiple = ismultiple;
	}

}
