package com.shifeng.op.dto.category;

import java.io.Serializable;
import java.util.List;

public class CategoryDTO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	//分类ID
	private int id;
	//父分类ID
	private int pId;
	//分类名称
	private String name;
	//子分类
	private List<CategoryDTO> nodes;
	//是否选中
	private boolean checked;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getpId() {
		return pId;
	}
	public void setpId(int pId) {
		this.pId = pId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<CategoryDTO> getNodes() {
		if(nodes.size()==0){
			return null;
		}
		return nodes;
	}
	public void setNodes(List<CategoryDTO> nodes) {
		this.nodes = nodes;
	}
	public boolean isChecked() {
		return checked;
	}
	public void setChecked(boolean checked) {
		this.checked = checked;
	}
	
	
}
