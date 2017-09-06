package com.shifeng.op.dto.brand;

import java.util.Date;

public class BrandDTO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

 	//编号
  	 private String id;
 	//品牌名称
  	 private String name;
 	//品牌logo
  	 private String logo;
 	//品牌描述
  	 private String descript;
 	//推荐状态
  	 private int recommended;
 	//排序
  	 private String rand;
 	//上传时间
  	 private Date uploaddate;
 	//品牌状态
  	 private int state;
 	//最后修改时间
  	 private Date lasttime;
 	//最后修改人
  	 private String updatename;



	 
    /**
    *编号
	* @return
    */ 
	public String getId() {
		return id;
	}
    /**
    *编号
	* @param type
    */ 
	public void setId(String id) {
		this.id = id;
	}
    /**
    *品牌名称
	* @return
    */ 
	public String getName() {
		return name;
	}
    /**
    *品牌名称
	* @param type
    */ 
	public void setName(String name) {
		this.name = name;
	}
    /**
    *品牌logo
	* @return
    */ 
	public String getLogo() {
		return logo;
	}
    /**
    *品牌logo
	* @param type
    */ 
	public void setLogo(String logo) {
		this.logo = logo;
	}
    /**
    *品牌描述
	* @return
    */ 
	public String getDescript() {
		return descript;
	}
    /**
    *品牌描述
	* @param type
    */ 
	public void setDescript(String descript) {
		this.descript = descript;
	}
    /**
    *推荐状态
	* @return
    */ 
	public int getRecommended() {
		return recommended;
	}
    /**
    *推荐状态
	* @param type
    */ 
	public void setRecommended(int recommended) {
		this.recommended = recommended;
	}
    /**
    *排序
	* @return
    */ 
	public String getRand() {
		return rand;
	}
    /**
    *排序
	* @param type
    */ 
	public void setRand(String rand) {
		this.rand = rand;
	}
    /**
    *上传时间
	* @return
    */ 
	public Date getUploaddate() {
		return uploaddate;
	}
    /**
    *上传时间
	* @param type
    */ 
	public void setUploaddate(Date uploaddate) {
		this.uploaddate = uploaddate;
	}
    /**
    *品牌状态
	* @return
    */ 
	public int getState() {
		return state;
	}
    /**
    *品牌状态
	* @param type
    */ 
	public void setState(int state) {
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
	* @param type
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
	* @param type
    */ 
	public void setUpdatename(String updatename) {
		this.updatename = updatename;
	}
	
}
