package com.shifeng.pay.dto;

import java.util.Objects;

import org.apache.commons.lang.StringUtils;

import com.shifeng.common.PaymentType;
import com.shifeng.util.MD5Util;

/**
 * 支付信息
 * @author WinZhong
 *
 */
public class PayDTO {
	
	//支付类型 
	private String payment_type = "";
	//支付方式
	private String payment_method;
	//支付码
	private String payment_code;
	//订单类型
	private String order_type;
	//唯一订单号
	private String order_id;
	//openid 用户标识 **即公众号支付此参数必传**
	private String openid;
	//返回地址
	private String return_url;
	//签名 签名规则MD5Util.hexSALT(payment_type+payment_method+payment_code+order_type+order_id);
	private String sign;
	
	/**
	 * 支付类型
	 * @return
	 */
	public String getPayment_type() {
		return payment_type;
	}
	/**
	 * 支付类型
	 * @param payment_type
	 */
	public void setPayment_type(String payment_type) {
		this.payment_type = payment_type;
	}
	/**
	 * 支付方式
	 * @return
	 */
	public String getPayment_method() {
		return payment_method;
	}
	/**
	 * 支付方式
	 * @param payment_method
	 */
	public void setPayment_method(String payment_method) {
		this.payment_method = payment_method;
	}
	/**
	 * 支付码
	 * @return
	 */
	public String getPayment_code() {
		return payment_code;
	}
	/**
	 * 支付码
	 * @param payment_code
	 */
	public void setPayment_code(String payment_code) {
		this.payment_code = payment_code;
	}
	/**
	 * 唯一订单号
	 * @return
	 */
	public String getOrder_id() {
		return order_id;
	}
	/**
	 * 唯一订单号
	 * @param order_id
	 */
	public void setOrder_id(String order_id) {
		this.order_id = order_id;
	}
	/**
	 * 签名 签名规则MD5Util.hexSALT(payment_type+payment_method+payment_code+order_id);
	 * @return
	 */
	public String getSign() {
		return sign;
	}
	/**
	 * 签名 签名规则MD5Util.hexSALT(payment_type+payment_method+payment_code+order_id);
	 */
	public void setSign(String sign) {
		this.sign = sign;
	}
 
	/**
	 * 订单类型
	 * @return
	 */
	public String getOrder_type() {
		return order_type;
	}
	/**
	 * 订单类型
	 * @param order_type
	 */
	public void setOrder_type(String order_type) {
		this.order_type = order_type;
	}
	/**
	 * openid 用户标识 **即公众号支付此参数必传**
	 * @return
	 */
	public String getOpenid() {
		return openid;
	}
	/**
	 * openid 用户标识 **即公众号支付此参数必传**
	 * @param openid
	 */
	public void setOpenid(String openid) {
		this.openid = openid;
	}
	 
 
	@Override
	public String toString() {
		return "PayDTO [payment_type=" + payment_type + ", payment_method=" + payment_method + ", payment_code="
				+ payment_code + ", order_type=" + order_type + ", order_id=" + order_id + ", openid=" + openid
				+ ", return_url=" + return_url + ", sign=" + sign + "]";
	}
	/**
	 * 检测参数是否都不为空
	 * @return
	 */
	public boolean isNotEmpty(){
		if(StringUtils.isNotBlank(payment_type) && StringUtils.isNotBlank(payment_method) /*&& StringUtils.isNotBlank(payment_code)*/
				&& StringUtils.isNotBlank(order_type) && StringUtils.isNotBlank(order_id) && StringUtils.isNotBlank(sign)){
			return true;
		}
		return false;
	}
	/**
	 * 检测参数是否都不为空
	 * @return
	 */
	public boolean isWapNotEmpty(){
		if(StringUtils.isNotBlank(payment_type) && StringUtils.isNotBlank(payment_method) /*&& StringUtils.isNotBlank(payment_code)*/
				&& StringUtils.isNotBlank(order_type) && StringUtils.isNotBlank(order_id) && StringUtils.isNotBlank(sign)){
			/*if(Objects.equals(payment_type, PaymentType.WEIXINPAY)){
				if(StringUtils.isBlank(openid)){
					return false;
				}
			}*/
			return true;
		}
		return false;
	}
	/**
	 * 检测参数是否都不为空
	 * @return
	 */
	public boolean isWxJSAPINotEmpty(){
		if(StringUtils.isNotBlank(payment_type) && StringUtils.isNotBlank(payment_method) && StringUtils.isNotBlank(openid)
				&& StringUtils.isNotBlank(order_type) && StringUtils.isNotBlank(order_id) && StringUtils.isNotBlank(sign)){
			/*if(Objects.equals(payment_type, PaymentType.WEIXINPAY)){
				if(StringUtils.isBlank(openid)){
					return false;
				}
			}*/
			return true;
		}
		return false;
	}
	
	/**
	 * 验证签名是否正确
	 * @return
	 */
	public boolean checkSign(){
		if(Objects.equals(sign, MD5Util.hexSALT(payment_type+payment_method+order_type/*+payment_code*/+order_id))){
			return true;
		}
		return false;
	}
	
	/**
	 * 返回地址
	 * @return
	 */
	public String getReturn_url() {
		return return_url;
	}
	/**
	 * 返回地址
	 * @param return_url
	 */
	public void setReturn_url(String return_url) {
		this.return_url = return_url;
	}
	/**
	 * 验证签名是否正确
	 * @return
	 */
	public boolean checkWapSign(){
		/*if(Objects.equals(payment_type, PaymentType.WEIXINPAY)){
			if(Objects.equals(sign, MD5Util.hexSALT(payment_type+payment_method+order_type+payment_code+order_id+openid))){
				return true;
			}else{
				return false;
			}
		}*/
		if(Objects.equals(sign, MD5Util.hexSALT(payment_type+payment_method+order_type/*+payment_code*/+order_id))){
			return true;
		}
		return false;
	}
	/**
	 * 验证签名是否正确
	 * @return
	 */
	public boolean checkWxJSAPISign(){
		 
			if(Objects.equals(sign, MD5Util.hexSALT(payment_type+payment_method+order_type+order_id+openid))){
				return true;
			}else{
				return false;
			}
		  
	}

}
