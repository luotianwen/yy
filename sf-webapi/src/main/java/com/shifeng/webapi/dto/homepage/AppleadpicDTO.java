package com.shifeng.webapi.dto.homepage;

import java.io.Serializable;
import java.util.Date;
/** 
 * app引导页(sys_appleadpic)实体类
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2017-03-04 15:22:50 
 */  
public class AppleadpicDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

 	//id
  	 private Integer id;
 	//图片路径
  	 private String imgUrl;
 	//序号
  	 private Integer sort;
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
    *图片路径
	* @return
    */ 
	public String getImgUrl() {
		return imgUrl;
	}
    /**
    *图片路径
	* @param imgUrl
    */ 
	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
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
