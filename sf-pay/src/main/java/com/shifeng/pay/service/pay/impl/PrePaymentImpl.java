package com.shifeng.pay.service.pay.impl;

import com.shifeng.pay.service.pay.PrePayment;
import com.shifeng.util.UuidUtil;

/**
 * 预支付Service
 * @author WinZhong
 *
 */
public class PrePaymentImpl implements PrePayment{

	/**
	 * 获取支付码,有效期五分钟，紧可使用一次
	 * @return
	 */
	public String getPaymentCode() {
		return UuidUtil.get32UUID();
	}
	
}
