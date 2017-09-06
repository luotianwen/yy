package com.shifeng.entity.shop;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
/** 
 * 商家品牌(s_shop_brand)实体类
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2017-03-22 13:43:08 
 */  
public class ShopBrand implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

 	//id
  	 private Integer id;
 	//入驻id
  	 private Integer s_merchants_id;
 	//品牌id
  	 private Integer b_brand_id;
 	//提交时间
  	 private Date submitime;
 	//审核状态(1：审核通过，2：审核失败，3：待审核)
  	 private Integer state;
 	//审核备注
  	 private String remark;
 	//品牌资质有效期
  	@DateTimeFormat(pattern="yyyy-MM-dd")
  	 private Date valid_period;
 	//品牌资质电子版
  	 private String qualification_img;
 	//品牌名称
  	 private String name;
 	//品牌logo
  	 private String logo;
 	//品牌描述
  	 private String descript;
 	//品牌首字母
  	 private String letter;
 	//品牌类型
  	 private Integer type;
 	//商标注册人
  	 private Integer trademarktype;
 	//经营类型
  	 private Integer businesstype;
 	//最后修改时间
  	 private Date lasttime;
 	//最后修改人
  	 private String updatename;



	 
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
    *入驻id
	* @return
    */ 
	public Integer getS_merchants_id() {
		return s_merchants_id;
	}
    /**
    *入驻id
	* @param s_merchants_id
    */ 
	public void setS_merchants_id(Integer s_merchants_id) {
		this.s_merchants_id = s_merchants_id;
	}
    /**
    *品牌id
	* @return
    */ 
	public Integer getB_brand_id() {
		return b_brand_id;
	}
    /**
    *品牌id
	* @param b_brand_id
    */ 
	public void setB_brand_id(Integer b_brand_id) {
		this.b_brand_id = b_brand_id;
	}
    /**
    *提交时间
	* @return
    */ 
	public Date getSubmitime() {
		return submitime;
	}
    /**
    *提交时间
	* @param submitime
    */ 
	public void setSubmitime(Date submitime) {
		this.submitime = submitime;
	}
    /**
    *审核状态(1：审核通过，2：审核失败，3：待审核)
	* @return
    */ 
	public Integer getState() {
		return state;
	}
    /**
    *审核状态(1：审核通过，2：审核失败，3：待审核)
	* @param state
    */ 
	public void setState(Integer state) {
		this.state = state;
	}
    /**
    *审核备注
	* @return
    */ 
	public String getRemark() {
		return remark;
	}
    /**
    *审核备注
	* @param remark
    */ 
	public void setRemark(String remark) {
		this.remark = remark;
	}
    /**
    *品牌资质有效期
	* @return
    */ 
	public Date getValid_period() {
		return valid_period;
	}
    /**
    *品牌资质有效期
	* @param valid_period
    */ 
	public void setValid_period(Date valid_period) {
		this.valid_period = valid_period;
	}
    /**
    *品牌资质电子版
	* @return
    */ 
	public String getQualification_img() {
		return qualification_img;
	}
    /**
    *品牌资质电子版
	* @param qualification_img
    */ 
	public void setQualification_img(String qualification_img) {
		this.qualification_img = qualification_img;
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
	public Integer getType() {
		return type;
	}
    /**
    *品牌类型
	* @param type
    */ 
	public void setType(Integer type) {
		this.type = type;
	}
    /**
    *商标注册人
	* @return
    */ 
	public Integer getTrademarktype() {
		return trademarktype;
	}
    /**
    *商标注册人
	* @param trademarktype
    */ 
	public void setTrademarktype(Integer trademarktype) {
		this.trademarktype = trademarktype;
	}
    /**
    *经营类型
	* @return
    */ 
	public Integer getBusinesstype() {
		return businesstype;
	}
    /**
    *经营类型
	* @param businesstype
    */ 
	public void setBusinesstype(Integer businesstype) {
		this.businesstype = businesstype;
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
	
}
