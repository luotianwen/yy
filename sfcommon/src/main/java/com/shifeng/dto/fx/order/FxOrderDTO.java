package com.shifeng.dto.fx.order;

import java.io.Serializable;
import java.util.Date;

/**
 * 分销订单DTO
 * @author Win
 *
 */
public class FxOrderDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

 	//订单ID
  	 private String orderid;
 	//分销结算状态 1：待结算（下单，支付）；2：已结算（确认收货）；3：订单失效（即用户取消订单，退货）
  	 private Integer state;
 	//佣金
  	 private Double commission;
 	//被被推荐用户名称
  	 private String recommended_userid;
 	//被推荐用户名称
  	 private String recommended_userName;
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
    *分销结算状态 1：待结算（下单，支付）；2：已结算（确认收货）；3：订单失效（即用户取消订单，退货）
	* @return
    */ 
	public Integer getState() {
		return state;
	}
    /**
    *分销结算状态 1：待结算（下单，支付）；2：已结算（确认收货）；3：订单失效（即用户取消订单，退货）
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
    *被推荐用户名称
	* @return
    */ 
	public String getRecommended_userName() {
		return recommended_userName;
	}
	/**
    *被推荐用户名称
	* @param recommended_userName
    */ 
	public void setRecommended_userName(String recommended_userName) {
		this.recommended_userName = recommended_userName;
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

    @Override
	public String toString() {
		return "FxOrderDTO [orderid=" + orderid + ", state=" + state + ", commission=" + commission
				+ ", recommended_userid=" + recommended_userid + ", recommended_userName=" + recommended_userName
				+ ", type=" + type + ", order_time=" + order_time + ", order_amount=" + order_amount + "]";
	}
	
}
