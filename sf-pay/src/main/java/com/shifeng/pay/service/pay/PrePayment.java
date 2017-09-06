package com.shifeng.pay.service.pay;

/**
 * 预支付Service
 * @author WinZhong
 *
 */
public interface PrePayment {

	/**
	 * 获取支付码,有效期五分钟，紧可使用一次
	 * @return
	 */
	String getPaymentCode();
	
}
