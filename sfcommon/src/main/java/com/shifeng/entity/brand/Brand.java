package com.shifeng.entity.brand;

import java.io.Serializable;
import java.util.Date;
/** 
 * 品牌表(b_brand)实体类
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2017-02-21 15:01:34 
 */  
public class Brand implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

 	//编号
  	 private int id;
 	//品牌名称
  	 private String name;
 	//品牌logo
  	 private String logo;
 	//品牌描述
  	 private String descript;
 	//推荐状态
  	 private int recommended;
 	//排序
  	 private int rand;
 	//上传时间
  	 private Date uploaddate;
 	//品牌状态
  	 private int state;
 	//最后修改时间
  	 private Date lasttime;
 	//最后修改人
  	 private String updatename;
 	//备注
  	 private String remark;
 	//品牌首字母
  	 private String letter;
 	//品牌类型
  	 private int type;
 	//商标注册人
  	 private int trademarktype;
 	//经营类型
  	 private int businesstype;



	 
    /**
    *编号
	* @return
    */ 
	public int getId() {
		return id;
	}
    /**
    *编号
	* @param id
    */ 
	public void setId(int id) {
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
	* @param name
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
	* @param logo
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
	* @param descript
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
	* @param recommended
    */ 
	public void setRecommended(int recommended) {
		this.recommended = recommended;
	}
    /**
    *排序
	* @return
    */ 
	public int getRand() {
		return rand;
	}
    /**
    *排序
	* @param rand
    */ 
	public void setRand(int rand) {
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
	* @param uploaddate
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
	* @param state
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
    *品牌首字母
	* @return
    */ 
	public String getLetter() {
		return letter;
	}
    /**
    *品牌首字母
	* @param letter
    */ 
	public void setLetter(String letter) {
		this.letter = letter;
	}
    /**
    *品牌类型
	* @return
    */ 
	public int getType() {
		return type;
	}
    /**
    *品牌类型
	* @param type
    */ 
	public void setType(int type) {
		this.type = type;
	}
    /**
    *商标注册人
	* @return
    */ 
	public int getTrademarktype() {
		return trademarktype;
	}
    /**
    *商标注册人
	* @param trademarktype
    */ 
	public void setTrademarktype(int trademarktype) {
		this.trademarktype = trademarktype;
	}
    /**
    *经营类型
	* @return
    */ 
	public int getBusinesstype() {
		return businesstype;
	}
    /**
    *经营类型
	* @param businesstype
    */ 
	public void setBusinesstype(int businesstype) {
		this.businesstype = businesstype;
	}
	
}
