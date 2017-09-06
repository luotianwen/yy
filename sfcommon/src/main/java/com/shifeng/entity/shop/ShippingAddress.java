package com.shifeng.entity.shop;

import java.io.Serializable;
import java.util.Date;
/** 
 * 店铺发货地址(s_shipping_address)实体类
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2017-04-06 17:08:50 
 */  
public class ShippingAddress implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

 	//id
  	 private Integer id;
 	//省份
  	 private Integer province;
 	//城市
  	 private Integer city;
 	//区
  	 private Integer region;
 	//省份名称
  	 private String provinceName;
 	//城市名称
  	 private String cityName;
 	//区名称
  	 private String regionName;
 	//详细地址
  	 private String address;
 	//邮编
  	 private String zipcode;
 	//联系电话
  	 private String phone;
 	//发货人姓名
  	 private String shipper;
 	//设为默认
  	 private Integer isdefault;
 	//店铺id
  	 private Integer shopid;



	 
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
    *省份
	* @return
    */ 
	public Integer getProvince() {
		return province;
	}
    /**
    *省份
	* @param province
    */ 
	public void setProvince(Integer province) {
		this.province = province;
	}
    /**
    *城市
	* @return
    */ 
	public Integer getCity() {
		return city;
	}
    /**
    *城市
	* @param city
    */ 
	public void setCity(Integer city) {
		this.city = city;
	}
    /**
    *区
	* @return
    */ 
	public Integer getRegion() {
		return region;
	}
    /**
    *区
	* @param region
    */ 
	public void setRegion(Integer region) {
		this.region = region;
	}
    /**
    *省份名称
	* @return
    */ 
	public String getProvinceName() {
		return provinceName;
	}
    /**
    *省份名称
	* @param provinceName
    */ 
	public void setProvinceName(String provinceName) {
		this.provinceName = provinceName;
	}
    /**
    *城市名称
	* @return
    */ 
	public String getCityName() {
		return cityName;
	}
    /**
    *城市名称
	* @param cityName
    */ 
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
    /**
    *区名称
	* @return
    */ 
	public String getRegionName() {
		return regionName;
	}
    /**
    *区名称
	* @param regionName
    */ 
	public void setRegionName(String regionName) {
		this.regionName = regionName;
	}
    /**
    *详细地址
	* @return
    */ 
	public String getAddress() {
		return address;
	}
    /**
    *详细地址
	* @param address
    */ 
	public void setAddress(String address) {
		this.address = address;
	}
    /**
    *邮编
	* @return
    */ 
	public String getZipcode() {
		return zipcode;
	}
    /**
    *邮编
	* @param zipcode
    */ 
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
    /**
    *联系电话
	* @return
    */ 
	public String getPhone() {
		return phone;
	}
    /**
    *联系电话
	* @param phone
    */ 
	public void setPhone(String phone) {
		this.phone = phone;
	}
    /**
    *发货人姓名
	* @return
    */ 
	public String getShipper() {
		return shipper;
	}
    /**
    *发货人姓名
	* @param shipper
    */ 
	public void setShipper(String shipper) {
		this.shipper = shipper;
	}
    /**
    *设为默认
	* @return
    */ 
	public Integer getIsdefault() {
		return isdefault;
	}
    /**
    *设为默认
	* @param isdefault
    */ 
	public void setIsdefault(Integer isdefault) {
		this.isdefault = isdefault;
	}
    /**
    *店铺id
	* @return
    */ 
	public Integer getShopid() {
		return shopid;
	}
    /**
    *店铺id
	* @param shopid
    */ 
	public void setShopid(Integer shopid) {
		this.shopid = shopid;
	}
	
}
