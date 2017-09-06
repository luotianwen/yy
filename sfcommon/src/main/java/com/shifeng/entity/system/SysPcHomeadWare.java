package com.shifeng.entity.system;

import java.io.Serializable;
import java.util.Date;
/** 
 * pc首页广告商品(sys_pc_homead_ware)实体类
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2017-04-12 18:27:40 
 */  
public class SysPcHomeadWare implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

 	//广告明细id
  	 private Integer id;
 	//广告ID
  	 private Integer ad_id;
 	//链接
  	 private String imgLink;
 	//顶部图标
  	 private String top_pic;
 	//序号
  	 private Integer sort;
 	//sku
  	 private String sku;
 	//状态
  	 private Integer state;
 	//最后修改时间
  	 private Date lasttime;
 	//最后修改人
  	 private String updatename;
 	//备注
  	 private String remark;

  	//名称
  	 private String name;
  	//世峰价
 	 private Double price;
 	//活动价
  	 private Double activityprice;
  	//图片地址
  	 private String imgPath;
  	 
  	 
    /**
    *广告明细id
	* @return
    */ 
	public Integer getId() {
		return id;
	}
    /**
    *广告明细id
	* @param id
    */ 
	public void setId(Integer id) {
		this.id = id;
	}
    /**
    *广告ID
	* @return
    */ 
	public Integer getAd_id() {
		return ad_id;
	}
    /**
    *广告ID
	* @param ad_id
    */ 
	public void setAd_id(Integer ad_id) {
		this.ad_id = ad_id;
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
    *顶部图标
	* @return
    */ 
	public String getTop_pic() {
		return top_pic;
	}
    /**
    *顶部图标
	* @param top_pic
    */ 
	public void setTop_pic(String top_pic) {
		this.top_pic = top_pic;
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
    *sku
	* @return
    */ 
	public String getSku() {
		return sku;
	}
    /**
    *sku
	* @param sku
    */ 
	public void setSku(String sku) {
		this.sku = sku;
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Double getActivityprice() {
		return activityprice;
	}
	public void setActivityprice(Double activityprice) {
		this.activityprice = activityprice;
	}
	public String getImgPath() {
		return imgPath;
	}
	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}
	
}
