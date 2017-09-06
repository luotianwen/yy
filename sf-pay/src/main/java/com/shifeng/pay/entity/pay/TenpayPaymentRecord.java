package com.shifeng.pay.entity.pay;

import java.io.Serializable;
import java.util.Date;
/** 
 * 财付通支付流水信息(tenpay_payment_record)实体类
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2017-03-08 13:42:17 
 */  
public class TenpayPaymentRecord implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

 	//支付流水号
  	 private String serial_number;
 	//交易模式
  	 private Integer trade_mode;
 	//交易状态
  	 private Integer trade_state;
 	//支付结果信息
  	 private String pay_info;
 	//商户号
  	 private String partner;
 	//付款银行
  	 private String bank_type;
 	//银行订单号
  	 private String bank_billno;
 	//支付金额，单位为分
  	 private Integer total_fee;
 	//币种
  	 private Integer fee_type;
 	//通知ID
  	 private String notify_id;
 	//财付通订单号
  	 private String transaction_id;
 	//商户订单号
  	 private String out_trade_no;
 	//商家数据包
  	 private String attach;
 	//支付完成时间
  	 private String time_end;
 	//物流费用
  	 private Integer transport_fee;
 	//物品费用
  	 private Integer product_fee;
 	//折扣价格
  	 private Integer discount;
 	//买家别名
  	 private String buyer_alias;



	 
    /**
    *支付流水号
	* @return
    */ 
	public String getSerial_number() {
		return serial_number;
	}
    /**
    *支付流水号
	* @param type
    */ 
	public void setSerial_number(String serial_number) {
		this.serial_number = serial_number;
	}
    /**
    *交易模式
	* @return
    */ 
	public Integer getTrade_mode() {
		return trade_mode;
	}
    /**
    *交易模式
	* @param type
    */ 
	public void setTrade_mode(Integer trade_mode) {
		this.trade_mode = trade_mode;
	}
    /**
    *交易状态
	* @return
    */ 
	public Integer getTrade_state() {
		return trade_state;
	}
    /**
    *交易状态
	* @param type
    */ 
	public void setTrade_state(Integer trade_state) {
		this.trade_state = trade_state;
	}
    /**
    *支付结果信息
	* @return
    */ 
	public String getPay_info() {
		return pay_info;
	}
    /**
    *支付结果信息
	* @param type
    */ 
	public void setPay_info(String pay_info) {
		this.pay_info = pay_info;
	}
    /**
    *商户号
	* @return
    */ 
	public String getPartner() {
		return partner;
	}
    /**
    *商户号
	* @param type
    */ 
	public void setPartner(String partner) {
		this.partner = partner;
	}
    /**
    *付款银行
	* @return
    */ 
	public String getBank_type() {
		return bank_type;
	}
    /**
    *付款银行
	* @param type
    */ 
	public void setBank_type(String bank_type) {
		this.bank_type = bank_type;
	}
    /**
    *银行订单号
	* @return
    */ 
	public String getBank_billno() {
		return bank_billno;
	}
    /**
    *银行订单号
	* @param type
    */ 
	public void setBank_billno(String bank_billno) {
		this.bank_billno = bank_billno;
	}
    /**
    *支付金额，单位为分
	* @return
    */ 
	public Integer getTotal_fee() {
		return total_fee;
	}
    /**
    *支付金额，单位为分
	* @param type
    */ 
	public void setTotal_fee(Integer total_fee) {
		this.total_fee = total_fee;
	}
    /**
    *币种
	* @return
    */ 
	public Integer getFee_type() {
		return fee_type;
	}
    /**
    *币种
	* @param type
    */ 
	public void setFee_type(Integer fee_type) {
		this.fee_type = fee_type;
	}
    /**
    *通知ID
	* @return
    */ 
	public String getNotify_id() {
		return notify_id;
	}
    /**
    *通知ID
	* @param type
    */ 
	public void setNotify_id(String notify_id) {
		this.notify_id = notify_id;
	}
    /**
    *财付通订单号
	* @return
    */ 
	public String getTransaction_id() {
		return transaction_id;
	}
    /**
    *财付通订单号
	* @param type
    */ 
	public void setTransaction_id(String transaction_id) {
		this.transaction_id = transaction_id;
	}
    /**
    *商户订单号
	* @return
    */ 
	public String getOut_trade_no() {
		return out_trade_no;
	}
    /**
    *商户订单号
	* @param type
    */ 
	public void setOut_trade_no(String out_trade_no) {
		this.out_trade_no = out_trade_no;
	}
    /**
    *商家数据包
	* @return
    */ 
	public String getAttach() {
		return attach;
	}
    /**
    *商家数据包
	* @param type
    */ 
	public void setAttach(String attach) {
		this.attach = attach;
	}
    /**
    *支付完成时间
	* @return
    */ 
	public String getTime_end() {
		return time_end;
	}
    /**
    *支付完成时间
	* @param type
    */ 
	public void setTime_end(String time_end) {
		this.time_end = time_end;
	}
    /**
    *物流费用
	* @return
    */ 
	public Integer getTransport_fee() {
		return transport_fee;
	}
    /**
    *物流费用
	* @param type
    */ 
	public void setTransport_fee(Integer transport_fee) {
		this.transport_fee = transport_fee;
	}
    /**
    *物品费用
	* @return
    */ 
	public Integer getProduct_fee() {
		return product_fee;
	}
    /**
    *物品费用
	* @param type
    */ 
	public void setProduct_fee(Integer product_fee) {
		this.product_fee = product_fee;
	}
    /**
    *折扣价格
	* @return
    */ 
	public Integer getDiscount() {
		return discount;
	}
    /**
    *折扣价格
	* @param type
    */ 
	public void setDiscount(Integer discount) {
		this.discount = discount;
	}
    /**
    *买家别名
	* @return
    */ 
	public String getBuyer_alias() {
		return buyer_alias;
	}
    /**
    *买家别名
	* @param type
    */ 
	public void setBuyer_alias(String buyer_alias) {
		this.buyer_alias = buyer_alias;
	}
	@Override
	public String toString() {
		return "TenpayPaymentRecord [serial_number=" + serial_number + ", trade_mode=" + trade_mode + ", trade_state="
				+ trade_state + ", pay_info=" + pay_info + ", partner=" + partner + ", bank_type=" + bank_type
				+ ", bank_billno=" + bank_billno + ", total_fee=" + total_fee + ", fee_type=" + fee_type
				+ ", notify_id=" + notify_id + ", transaction_id=" + transaction_id + ", out_trade_no=" + out_trade_no
				+ ", attach=" + attach + ", time_end=" + time_end + ", transport_fee=" + transport_fee
				+ ", product_fee=" + product_fee + ", discount=" + discount + ", buyer_alias=" + buyer_alias + "]";
	}
	
	
	
}
