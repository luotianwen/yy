package com.shifeng.webapi.dto.homepage;

import java.io.Serializable;
import java.util.List;

import com.alibaba.fastjson.annotation.JSONField;
/** 
 * 首页广告(sys_homeads)实体类
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2017-03-04 15:22:51 
 */  
public class AdDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


 	//广告id
	//@JSONField(serialize=false)
  	 private Integer id;
 	//名称
  	 private String name;
 	//标题
  	 private String title;
 	//图片地址
  	 private String imgPath;
 	//链接
  	 private String link;
 	//类型
  	 private Integer type;
 	//序号
  	 private Integer sort;
 	//展示模板类型
  	 private Integer templet_type;
 	//是否楼层
  	 private Integer isfloor;
 	//广告商品列表
    //空值不输出
 	private List<AdWareDTO> wareList;

	 
    /**
    *广告id
	* @return
    */ 
	public Integer getId() {
		return id;
	}
    /**
    *广告id
	* @param id
    */ 
	public void setId(Integer id) {
		this.id = id;
	}
    /**
    *名称
	* @return
    */ 
	public String getName() {
		return name;
	}
    /**
    *名称
	* @param name
    */ 
	public void setName(String name) {
		this.name = name;
	}
    /**
    *标题
	* @return
    */ 
	public String getTitle() {
		return title;
	}
    /**
    *标题
	* @param title
    */ 
	public void setTitle(String title) {
		this.title = title;
	}
    /**
    *图片地址
	* @return
    */ 
	public String getImgPath() {
		return imgPath;
	}
    /**
    *图片地址
	* @param imgPath
    */ 
	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}
    /**
    *链接
	* @return
    */ 
	public String getLink() {
		return link;
	}
    /**
    *链接
	* @param link
    */ 
	public void setLink(String link) {
		this.link = link;
	}
    /**
    *类型
	* @return
    */ 
	public Integer getType() {
		return type;
	}
    /**
    *类型
	* @param type
    */ 
	public void setType(Integer type) {
		this.type = type;
	}
    /**
    *序号
	* @return
    */ 
	public Integer getSort() {
		return sort;
	}
    /**
    *序号
	* @param sort
    */ 
	public void setSort(Integer sort) {
		this.sort = sort;
	}
    /**
    *展示模板类型
	* @return
    */ 
	public Integer getTemplet_type() {
		return templet_type;
	}
    /**
    *展示模板类型
	* @param templet_type
    */ 
	public void setTemplet_type(Integer templet_type) {
		this.templet_type = templet_type;
	}
    /**
    *是否楼层
	* @return
    */ 
	public Integer getIsfloor() {
		return isfloor;
	}
	/**
    *是否楼层
	* @param isfloor
    */ 
	public void setIsfloor(Integer isfloor) {
		this.isfloor = isfloor;
	}
	/**
	 * 广告商品列表
	 * @return
	 */
    public List<AdWareDTO> getWareList() {
		return wareList;
	}
    /**
     * 广告商品列表
     * @param wareList
     */
	public void setWareList(List<AdWareDTO> wareList) {
		this.wareList = wareList;
	}
	
    
}
