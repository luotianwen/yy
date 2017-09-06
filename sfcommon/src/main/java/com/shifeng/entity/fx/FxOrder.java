package com.shifeng.entity.fx;

import java.io.Serializable;
import java.util.Date;
/** 
 * 分销订单(fx_order)实体类
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2017-04-27 10:38:10 
 */  
public class FxOrder implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

 	//订单ID
  	 private String orderid;
 	//分销结算状态
  	 private Integer state;
 	//佣金
  	 private Double commission;
 	//推荐用户id
  	 private String recommend_userid;
 	//被推荐用户id
  	 private String recommended_userid;
 	//状态
  	 private Integer type;
 	//下单时间
  	 private Date order_time;
 	//订单金额（支付金额）
  	 private Double order_amount;



	 
    /**
    *订单ID
	* @return
    */ 
	public String getOrderid() {
		return orderid;
	}
    /**
    *订单ID
	* @param orderid
    */ 
	public void setOrderid(String orderid) {
		this.orderid = orderid;
	}
    /**
    *分销结算状态
	* @return
    */ 
	public Integer getState() {
		return state;
	}
    /**
    *分销结算状态
	* @param state
    */ 
	public void setState(Integer state) {
		this.state = state;
	}
    /**
    *佣金
	* @return
    */ 
	public Double getCommission() {
		return commission;
	}
    /**
    *佣金
	* @param commission
    */ 
	public void setCommission(Double commission) {
		this.commission = commission;
	}
    /**
    *推荐用户id
	* @return
    */ 
	public String getRecommend_userid() {
		return recommend_userid;
	}
    /**
    *推荐用户id
	* @param recommend_userid
    */ 
	public void setRecommend_userid(String recommend_userid) {
		this.recommend_userid = recommend_userid;
	}
    /**
    *被推荐用户id
	* @return
    */ 
	public String getRecommended_userid() {
		return recommended_userid;
	}
    /**
    *被推荐用户id
	* @param recommended_userid
    */ 
	public void setRecommended_userid(String recommended_userid) {
		this.recommended_userid = recommended_userid;
	}
    /**
    *状态
	* @return
    */ 
	public Integer getType() {
		return type;
	}
    /**
    *状态
	* @param type
    */ 
	public void setType(Integer type) {
		this.type = type;
	}
    /**
    *下单时间
	* @return
    */ 
	public Date getOrder_time() {
		return order_time;
	}
    /**
    *下单时间
	* @param order_time
    */ 
	public void setOrder_time(Date order_time) {
		this.order_time = order_time;
	}
    /**
    *订单金额（支付金额）
	* @return
    */ 
	public Double getOrder_amount() {
		return order_amount;
	}
    /**
    *订单金额（支付金额）
	* @param order_amount
    */ 
	public void setOrder_amount(Double order_amount) {
		this.order_amount = order_amount;
	}
	
}
