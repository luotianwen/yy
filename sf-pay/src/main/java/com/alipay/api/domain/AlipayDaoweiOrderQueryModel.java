package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

/**
 * 到位订单查询接口
 *
 * @author auto create
 * @since 1.0, 2017-01-16 11:29:56
 */
public class AlipayDaoweiOrderQueryModel extends AlipayObject {

	private static final long serialVersionUID = 7691869843757967375L;

	/**
	 * 到位业务订单号，全局唯一，由32位数字组成，用户在到位下单时系统生成并消息同步给商家，商户只能查自己同步到的订单号
	 */
	@ApiField("order_no")
	private String orderNo;

	public String getOrderNo() {
		return this.orderNo;
	}
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

}
