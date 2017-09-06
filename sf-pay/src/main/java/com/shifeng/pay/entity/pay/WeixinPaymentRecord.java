package com.shifeng.pay.entity.pay;

import java.io.Serializable;
import java.util.Date;
/** 
 * 微信支付流水信息(weixin_payment_record)实体类
 * @author Win Zhong 
 * @version Revision: 1.00 
 *  Date: 2017-03-08 13:42:17 
 */  
public class WeixinPaymentRecord implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

 	//支付流水号
  	 private String serial_number;
 	//公众账号ID
  	 private String appid;
 	//商户号
  	 private String mch_id;
 	//设备号
  	 private String device_info;
 	//随机字符串
  	 private String nonce_str;
 	//签名
  	 private String sign;
 	//签名类型
  	 private String sign_type;
 	//业务结果
  	 private String result_code;
 	//错误代码
  	 private String err_code;
 	//错误代码描述
  	 private String err_code_des;
 	//用户标识
  	 private String openid;
 	//是否关注公众账号
  	 private String is_subscribe;
 	//交易类型
  	 private String trade_type;
 	//付款银行
  	 private String bank_type;
 	//订单金额，单位为分
  	 private Integer total_fee;
 	//应结订单金额，单位为分
  	 private Integer settlement_total_fee;
 	//货币种类
  	 private String fee_type;
 	//现金支付金额，单位为分
  	 private Integer cash_fee;
 	//现金支付货币类型
  	 private String cash_fee_type;
 	//总代金券金额
  	 private Integer coupon_fee;
 	//代金券使用数量
  	 private Integer coupon_count;
 	//微信支付订单号
  	 private String transaction_id;
 	//商户订单号
  	 private String out_trade_no;
 	//商家数据包
  	 private String attach;
 	//支付完成时间
  	 private String time_end;



	 
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
    *公众账号ID
	* @return
    */ 
	public String getAppid() {
		return appid;
	}
    /**
    *公众账号ID
	* @param type
    */ 
	public void setAppid(String appid) {
		this.appid = appid;
	}
    /**
    *商户号
	* @return
    */ 
	public String getMch_id() {
		return mch_id;
	}
    /**
    *商户号
	* @param type
    */ 
	public void setMch_id(String mch_id) {
		this.mch_id = mch_id;
	}
    /**
    *设备号
	* @return
    */ 
	public String getDevice_info() {
		return device_info;
	}
    /**
    *设备号
	* @param type
    */ 
	public void setDevice_info(String device_info) {
		this.device_info = device_info;
	}
    /**
    *随机字符串
	* @return
    */ 
	public String getNonce_str() {
		return nonce_str;
	}
    /**
    *随机字符串
	* @param type
    */ 
	public void setNonce_str(String nonce_str) {
		this.nonce_str = nonce_str;
	}
    /**
    *签名
	* @return
    */ 
	public String getSign() {
		return sign;
	}
    /**
    *签名
	* @param type
    */ 
	public void setSign(String sign) {
		this.sign = sign;
	}
    /**
    *签名类型
	* @return
    */ 
	public String getSign_type() {
		return sign_type;
	}
    /**
    *签名类型
	* @param type
    */ 
	public void setSign_type(String sign_type) {
		this.sign_type = sign_type;
	}
    /**
    *业务结果
	* @return
    */ 
	public String getResult_code() {
		return result_code;
	}
    /**
    *业务结果
	* @param type
    */ 
	public void setResult_code(String result_code) {
		this.result_code = result_code;
	}
    /**
    *错误代码
	* @return
    */ 
	public String getErr_code() {
		return err_code;
	}
    /**
    *错误代码
	* @param type
    */ 
	public void setErr_code(String err_code) {
		this.err_code = err_code;
	}
    /**
    *错误代码描述
	* @return
    */ 
	public String getErr_code_des() {
		return err_code_des;
	}
    /**
    *错误代码描述
	* @param type
    */ 
	public void setErr_code_des(String err_code_des) {
		this.err_code_des = err_code_des;
	}
    /**
    *用户标识
	* @return
    */ 
	public String getOpenid() {
		return openid;
	}
    /**
    *用户标识
	* @param type
    */ 
	public void setOpenid(String openid) {
		this.openid = openid;
	}
    /**
    *是否关注公众账号
	* @return
    */ 
	public String getIs_subscribe() {
		return is_subscribe;
	}
    /**
    *是否关注公众账号
	* @param type
    */ 
	public void setIs_subscribe(String is_subscribe) {
		this.is_subscribe = is_subscribe;
	}
    /**
    *交易类型
	* @return
    */ 
	public String getTrade_type() {
		return trade_type;
	}
    /**
    *交易类型
	* @param type
    */ 
	public void setTrade_type(String trade_type) {
		this.trade_type = trade_type;
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
    *订单金额，单位为分
	* @return
    */ 
	public Integer getTotal_fee() {
		return total_fee;
	}
    /**
    *订单金额，单位为分
	* @param type
    */ 
	public void setTotal_fee(Integer total_fee) {
		this.total_fee = total_fee;
	}
    /**
    *应结订单金额，单位为分
	* @return
    */ 
	public Integer getSettlement_total_fee() {
		return settlement_total_fee;
	}
    /**
    *应结订单金额，单位为分
	* @param type
    */ 
	public void setSettlement_total_fee(Integer settlement_total_fee) {
		this.settlement_total_fee = settlement_total_fee;
	}
    /**
    *货币种类
	* @return
    */ 
	public String getFee_type() {
		return fee_type;
	}
    /**
    *货币种类
	* @param type
    */ 
	public void setFee_type(String fee_type) {
		this.fee_type = fee_type;
	}
    /**
    *现金支付金额，单位为分
	* @return
    */ 
	public Integer getCash_fee() {
		return cash_fee;
	}
    /**
    *现金支付金额，单位为分
	* @param type
    */ 
	public void setCash_fee(Integer cash_fee) {
		this.cash_fee = cash_fee;
	}
    /**
    *现金支付货币类型
	* @return
    */ 
	public String getCash_fee_type() {
		return cash_fee_type;
	}
    /**
    *现金支付货币类型
	* @param type
    */ 
	public void setCash_fee_type(String cash_fee_type) {
		this.cash_fee_type = cash_fee_type;
	}
    /**
    *总代金券金额
	* @return
    */ 
	public Integer getCoupon_fee() {
		return coupon_fee;
	}
    /**
    *总代金券金额
	* @param type
    */ 
	public void setCoupon_fee(Integer coupon_fee) {
		this.coupon_fee = coupon_fee;
	}
    /**
    *代金券使用数量
	* @return
    */ 
	public Integer getCoupon_count() {
		return coupon_count;
	}
    /**
    *代金券使用数量
	* @param type
    */ 
	public void setCoupon_count(Integer coupon_count) {
		this.coupon_count = coupon_count;
	}
    /**
    *微信支付订单号
	* @return
    */ 
	public String getTransaction_id() {
		return transaction_id;
	}
    /**
    *微信支付订单号
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
	@Override
	public String toString() {
		return "WeixinPaymentRecord [serial_number=" + serial_number + ", appid=" + appid + ", mch_id=" + mch_id
				+ ", device_info=" + device_info + ", nonce_str=" + nonce_str + ", sign=" + sign + ", sign_type="
				+ sign_type + ", result_code=" + result_code + ", err_code=" + err_code + ", err_code_des="
				+ err_code_des + ", openid=" + openid + ", is_subscribe=" + is_subscribe + ", trade_type=" + trade_type
				+ ", bank_type=" + bank_type + ", total_fee=" + total_fee + ", settlement_total_fee="
				+ settlement_total_fee + ", fee_type=" + fee_type + ", cash_fee=" + cash_fee + ", cash_fee_type="
				+ cash_fee_type + ", coupon_fee=" + coupon_fee + ", coupon_count=" + coupon_count + ", transaction_id="
				+ transaction_id + ", out_trade_no=" + out_trade_no + ", attach=" + attach + ", time_end=" + time_end
				+ "]";
	}
	
}
