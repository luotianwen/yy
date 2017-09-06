package com.shifeng.entity.system;

import java.io.Serializable;
import java.util.Date;
/** 
 * app类目广告(sys_app_categoryads)实体类
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2017-03-15 15:46:41 
 */  
public class SysAppCategoryads implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

 	//id
  	 private Integer id;
 	//名称
  	 private String name;
 	//图片地址
  	 private String imgPath;
 	//链接
  	 private String imgLink;
 	//是否活动
  	 private Integer isactivity;
 	//类型
  	 private Integer module;
 	//序号
  	 private Integer sort;
 	//标题
  	 private String title;
 	//价格
  	 private String price;
 	//状态
  	 private Integer state;
 	//最后修改时间
  	 private Date lasttime;
 	//最后修改人
  	 private String updatename;
 	//备注
  	 private String remark;



	 
    /**
    *id
	* @return
    */ 
	public Integer getId() {
		return id;
	}
    /**
    *id
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
	public String getImgLink() {
		return imgLink;
	}
    /**
    *链接
	* @param imgLink
    */ 
	public void setImgLink(String imgLink) {
		this.imgLink = imgLink;
	}
    /**
    *是否活动
	* @return
    */ 
	public Integer getIsactivity() {
		return isactivity;
	}
    /**
    *是否活动
	* @param isactivity
    */ 
	public void setIsactivity(Integer isactivity) {
		this.isactivity = isactivity;
	}
    /**
    *类型
	* @return
    */ 
	public Integer getModule() {
		return module;
	}
    /**
    *类型
	* @param module
    */ 
	public void setModule(Integer module) {
		this.module = module;
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
    *价格
	* @return
    */ 
	public String getPrice() {
		return price;
	}
    /**
    *价格
	* @param price
    */ 
	public void setPrice(String price) {
		this.price = price;
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
