package com.shifeng.entity.freight;

import java.io.Serializable;
/** 
 * 运费明细(o_freight_detail)实体类
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2017-02-24 11:45:53 
 */  
public class FreightDetail implements Serializable {

	private static final long serialVersionUID = 1L;

 	//主键
  	 private Integer id;
 	//模板编号
  	 private Integer fid;
 	//城市编号集合
  	 private String city;
  	 private Double firstunit;
  	 private Double firstfee;
  	 private Double addunit;
  	 private Double addfee;
	private String cityName;

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getFid() {
		return fid;
	}

	public void setFid(Integer fid) {
		this.fid = fid;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Double getFirstunit() {
		return firstunit;
	}

	public void setFirstunit(Double firstunit) {
		this.firstunit = firstunit;
	}

	public Double getFirstfee() {
		return firstfee;
	}

	public void setFirstfee(Double firstfee) {
		this.firstfee = firstfee;
	}

	public Double getAddunit() {
		return addunit;
	}

	public void setAddunit(Double addunit) {
		this.addunit = addunit;
	}

	public Double getAddfee() {
		return addfee;
	}

	public void setAddfee(Double addfee) {
		this.addfee = addfee;
	}
}
