package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

/**
 * 订单状态推进接口
 *
 * @author auto create
 * @since 1.0, 2017-01-16 11:30:28
 */
public class AlipayDaoweiOrderTransferModel extends AlipayObject {

	private static final long serialVersionUID = 3161168153626535176L;

	/**
	 * 备注信息，第三方商家在推进订单状态的时候的填写的备注信息，用于告知到位或者服务的购买者的相关信息，不超过500字符
	 */
	@ApiField("memo")
	private String memo;

	/**
	 * 订单动作，需要推进的订单状态，枚举值，目前支持的订单状态是PROVIDER_CONFIRMED (服务者完成服务)。
	 */
	@ApiField("order_action")
	private String orderAction;

	/**
	 * 到位业务订单号，全局唯一，由32位数字组成，用户在到位下单时系统生成并消息同步给商家，商户只能查自己同步到的订单号
	 */
	@ApiField("order_no")
	private String orderNo;

	public String getMemo() {
		return this.memo;
	}
	public void setMemo(String memo) {
		this.memo = memo;
	}

	public String getOrderAction() {
		return this.orderAction;
	}
	public void setOrderAction(String orderAction) {
		this.orderAction = orderAction;
	}

	public String getOrderNo() {
		return this.orderNo;
	}
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

}
