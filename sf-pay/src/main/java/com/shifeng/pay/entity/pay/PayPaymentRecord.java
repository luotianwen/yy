package com.shifeng.pay.entity.pay;

import java.io.Serializable;
import java.util.Date;

import com.shifeng.util.redis.RedisTool;
/** 
 * 支付信息对账表(pay_payment_record)实体类
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2017-03-09 17:44:49 
 */  
public class PayPaymentRecord implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

 	//支付流水号
  	 private String serial_number;
 	//支付交易订单号
  	 private String order_id;
 	//订单名称
  	 private String subject;
 	//支付交易号
  	 private String trade_no;
 	//交易金额
  	 private double total_fee;
 	//支付状态（0：成功；1：失败；2：全额退款；3：非全额退款）
  	 private String trade_status;
 	//交易付款时间
  	 private Date payment_time;
 	//交易退款时间
  	 private Date return_time;
 	//退款金额
  	 private double return_fee;
 	//订单类型
  	 private String order_type;
 	//支付类型
  	 private String payment_type;
 	//支付类型名称
  	 private String payment_type_name;
 	//最后修改时间
  	 private Date lasttime;
 	//最后修改人
  	 private String updatename;
 	//备注
  	 private String remark;



	 
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
    *支付交易订单号
	* @return
    */ 
	public String getOrder_id() {
		return order_id;
	}
    /**
    *支付交易订单号
	* @param type
    */ 
	public void setOrder_id(String order_id) {
		this.order_id = order_id;
	}
    /**
    *订单名称
	* @return
    */ 
	public String getSubject() {
		return subject;
	}
    /**
    *订单名称
	* @param type
    */ 
	public void setSubject(String subject) {
		this.subject = subject;
	}
    /**
    *支付交易号
	* @return
    */ 
	public String getTrade_no() {
		return trade_no;
	}
    /**
    *支付交易号
	* @param type
    */ 
	public void setTrade_no(String trade_no) {
		this.trade_no = trade_no;
	}
    /**
    *交易金额
	* @return
    */ 
	public double getTotal_fee() {
		return total_fee;
	}
    /**
    *交易金额
	* @param type
    */ 
	public void setTotal_fee(double total_fee) {
		this.total_fee = total_fee;
	}
    /**
    *支付状态（0：成功；1：失败；2：全额退款；3：非全额退款）
	* @return
    */ 
	public String getTrade_status() {
		return trade_status;
	}
    /**
    *支付状态（0：成功；1：失败；2：全额退款；3：非全额退款）
	* @param type
    */ 
	public void setTrade_status(String trade_status) {
		this.trade_status = trade_status;
	}
    /**
    *交易付款时间
	* @return
    */ 
	public Date getPayment_time() {
		return payment_time;
	}
    /**
    *交易付款时间
	* @param type
    */ 
	public void setPayment_time(Date payment_time) {
		this.payment_time = payment_time;
	}
    /**
    *交易退款时间
	* @return
    */ 
	public Date getReturn_time() {
		return return_time;
	}
    /**
    *交易退款时间
	* @param type
    */ 
	public void setReturn_time(Date return_time) {
		this.return_time = return_time;
	}
    /**
    *退款金额
	* @return
    */ 
	public double getReturn_fee() {
		return return_fee;
	}
    /**
    *退款金额
	* @param type
    */ 
	public void setReturn_fee(double return_fee) {
		this.return_fee = return_fee;
	}
    /**
    *订单类型
	* @return
    */ 
	public String getOrder_type() {
		return order_type;
	}
    /**
    *订单类型
	* @param type
    */ 
	public void setOrder_type(String order_type) {
		this.order_type = order_type;
	}
    /**
    *支付类型
	* @return
    */ 
	public String getPayment_type() {
		return payment_type;
	}
    /**
    *支付类型
	* @param type
    */ 
	public void setPayment_type(String payment_type) {
		this.payment_type = payment_type;
	}
    /**
    *支付类型名称
	* @return
    */ 
	public String getPayment_type_name() {
		return payment_type_name;
	}
    /**
    *支付类型名称
	* @param type
    */ 
	public void setPayment_type_name(String payment_type_name) {
		this.payment_type_name = payment_type_name;
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
    /**
    *备注
	* @return
    */ 
	public String getRemark() {
		return remark;
	}
    /**
    *备注
	* @param type
    */ 
	public void setRemark(String remark) {
		this.remark = remark;
	}
	@Override
	public String toString() {
		return "PayPaymentRecord [serial_number=" + serial_number + ", order_id=" + order_id + ", subject=" + subject
				+ ", trade_no=" + trade_no + ", total_fee=" + total_fee + ", trade_status=" + trade_status
				+ ", payment_time=" + payment_time + ", return_time=" + return_time + ", return_fee=" + return_fee
				+ ", order_type=" + order_type + ", payment_type=" + payment_type + ", payment_type_name="
				+ payment_type_name + ", lasttime=" + lasttime + ", updatename=" + updatename + ", remark=" + remark
				+ "]";
	}
	
	public PayPaymentRecord(Object paymentRecord) {
		 if(paymentRecord instanceof AlipayPaymentRecord){
			 AlipayPaymentRecord p = (AlipayPaymentRecord)paymentRecord;
			 serial_number = p.getSerial_number();
			 order_id = p.getOut_trade_no();
			 subject = p.getSubject();
			 trade_no = p.getTrade_no();
			 total_fee = p.getTotal_fee();
			 trade_status = "0";
			 payment_time = p.getGmt_payment();
			 order_type = p.getExtra_common_param();
			 payment_type = "alipay";
			 payment_type_name = "支付宝";
		 }else if(paymentRecord instanceof TenpayPaymentRecord){

			 TenpayPaymentRecord p = (TenpayPaymentRecord)paymentRecord;
			 serial_number = p.getSerial_number();
			 order_id = p.getOut_trade_no();
			 
			 //subject = p.getSubject();
			 trade_no = p.getTransaction_id();
			 total_fee = p.getTotal_fee().doubleValue()/100;
			 trade_status = "0";
			 payment_time = new Date();
			 order_type = p.getAttach();
			 payment_type = "tenpay";
			 payment_type_name = "财付通";
			 try {
				String key = order_type+order_id;
				 subject = RedisTool.get(key);
			} catch (Exception e) {
				e.printStackTrace();
			}
		 }else if(paymentRecord instanceof WeixinPaymentRecord){

			 WeixinPaymentRecord p = (WeixinPaymentRecord)paymentRecord;
			 serial_number = p.getSerial_number();
			 order_id = p.getOut_trade_no();
			 //subject = p.getSubject();
			 trade_no = p.getTransaction_id();
			 total_fee = p.getTotal_fee().doubleValue()/100;
			 trade_status = "0";
			 payment_time = new Date();
			 order_type = p.getAttach();
			 payment_type = "tenpay";
			 payment_type_name = "微信";
			 try {
				String key = order_type+order_id;
				 subject = RedisTool.get(key);
			} catch (Exception e) {
				e.printStackTrace();
			}
		 }
		 
		 
		 
	}
	
	
	
	
	
}
