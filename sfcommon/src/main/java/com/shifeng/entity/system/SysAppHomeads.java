package com.shifeng.entity.system;

import java.io.Serializable;
import java.util.Date;
/** 
 * app首页广告(sys_app_homeads)实体类
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2017-03-16 18:49:59 
 */  
public class SysAppHomeads implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

 	//广告id
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
 	//状态
  	 private Integer state;
 	//最后修改时间
  	 private Date lasttime;
 	//最后修改人
  	 private String updatename;
 	//备注
  	 private String remark;



	 
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
    *状态
	* @return
    */ 
	public Integer getState() {
		return state;
	}
    /**
    *状态
	* @param state
    */ 
	public void setState(Integer state) {
		this.state = state;
	}
    /**
    *最后修改时间
	* @return
    */ 
	public Date getLasttime() {
		return lasttime;
	}
    /**
    *最后修改时间
	* @param lasttime
    */ 
	public void setLasttime(Date lasttime) {
		this.lasttime = lasttime;
	}
    /**
    *最后修改人
	* @return
    */ 
	public String getUpdatename() {
		return updatename;
	}
    /**
    *最后修改人
	* @param updatename
    */ 
	public void setUpdatename(String updatename) {
		this.updatename = updatename;
	}
    /**
    *备注
	* @return
    */ 
	public String getRemark() {
		return remark;
	}
    /**
    *备注
	* @param remark
    */ 
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
}
