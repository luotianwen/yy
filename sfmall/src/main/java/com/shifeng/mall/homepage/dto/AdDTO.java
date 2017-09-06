package com.shifeng.mall.homepage.dto;

import java.io.Serializable;
import java.util.List;

/**
 * 首页广告(sys_homeads)实体类
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2017-03-04 15:22:51 
 */  
public class AdDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	//广告id
	private Integer id;
	//类型
	private Integer module;
	//第1张图片地址
	private String fimg1;
	//第1张链接
	private String flink1;
	//第1张广告价格
	private Double fprice1;
	//第2张图片地址
	private String fimg2;
	//第2张链接
	private String flink2;
	//第2张广告价格
	private Double fprice2;
	//第3张图片地址
	private String fimg3;
	//第3张链接
	private String flink3;
	//第3张广告价格
	private Double fprice3;
	//状态
	private Integer state;
	private String remark;
	private String remark2;

 	//广告商品列表
    //空值不输出
 	private List<AdWareDTO> wareList;

 	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	public String getRemark2() {
		return remark2;
	}

	public void setRemark2(String remark2) {
		this.remark2 = remark2;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getModule() {
		return module;
	}

	public void setModule(Integer module) {
		this.module = module;
	}

	public String getFimg1() {
		return fimg1;
	}

	public void setFimg1(String fimg1) {
		this.fimg1 = fimg1;
	}

	public String getFlink1() {
		return flink1;
	}

	public void setFlink1(String flink1) {
		this.flink1 = flink1;
	}

	public Double getFprice1() {
		return fprice1;
	}

	public void setFprice1(Double fprice1) {
		this.fprice1 = fprice1;
	}

	public String getFimg2() {
		return fimg2;
	}

	public void setFimg2(String fimg2) {
		this.fimg2 = fimg2;
	}

	public String getFlink2() {
		return flink2;
	}

	public void setFlink2(String flink2) {
		this.flink2 = flink2;
	}

	public Double getFprice2() {
		return fprice2;
	}

	public void setFprice2(Double fprice2) {
		this.fprice2 = fprice2;
	}

	public String getFimg3() {
		return fimg3;
	}

	public void setFimg3(String fimg3) {
		this.fimg3 = fimg3;
	}

	public String getFlink3() {
		return flink3;
	}

	public void setFlink3(String flink3) {
		this.flink3 = flink3;
	}

	public Double getFprice3() {
		return fprice3;
	}

	public void setFprice3(Double fprice3) {
		this.fprice3 = fprice3;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public List<AdWareDTO> getWareList() {
		return wareList;
	}

	public void setWareList(List<AdWareDTO> wareList) {
		this.wareList = wareList;
	}
}
