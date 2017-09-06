package com.shifeng.entity.product;

import java.io.Serializable;
import java.util.Date;
/** 
 * sku图片表(p_sku_images)实体类
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2017-03-29 11:30:04 
 */  
public class SkuImages implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

 	//主键
  	 private Integer id;
 	//商品编号
  	 private Integer pid;
 	//图片路径
  	 private String ipath;
 	//图片顺序
  	 private Integer sort;
 	//颜色
  	 private Integer colorid;
 	//最后修改时间
  	 private Date lasttime;
 	//最后修改人
  	 private String updatename;
 	//备注
  	 private String remark;
 	//是否主图
  	 private Integer ismain;



	 
    /**
    *主键
	* @return
    */ 
	public Integer getId() {
		return id;
	}
    /**
    *主键
	* @param id
    */ 
	public void setId(Integer id) {
		this.id = id;
	}
    /**
    *商品编号
	* @return
    */ 
	public Integer getPid() {
		return pid;
	}
    /**
    *商品编号
	* @param pid
    */ 
	public void setPid(Integer pid) {
		this.pid = pid;
	}
    /**
    *图片路径
	* @return
    */ 
	public String getIpath() {
		return ipath;
	}
    /**
    *图片路径
	* @param ipath
    */ 
	public void setIpath(String ipath) {
		this.ipath = ipath;
	}
    /**
    *图片顺序
	* @return
    */ 
	public Integer getSort() {
		return sort;
	}
    /**
    *图片顺序
	* @param sort
    */ 
	public void setSort(Integer sort) {
		this.sort = sort;
	}
    /**
    *颜色
	* @return
    */ 
	public Integer getColorid() {
		return colorid;
	}
    /**
    *颜色
	* @param colorid
    */ 
	public void setColorid(Integer colorid) {
		this.colorid = colorid;
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
    /**
    *是否主图
	* @return
    */ 
	public Integer getIsmain() {
		return ismain;
	}
    /**
    *是否主图
	* @param ismain
    */ 
	public void setIsmain(Integer ismain) {
		this.ismain = ismain;
	}
	
}
