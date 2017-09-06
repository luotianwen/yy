package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

/**
 * 订单确认接口
 *
 * @author auto create
 * @since 1.0, 2017-01-16 11:30:52
 */
public class AlipayDaoweiOrderConfirmModel extends AlipayObject {

	private static final long serialVersionUID = 2486526749473972571L;

	/**
	 * 备注信息，商家确认订单时添加的备注信息，长度不超过2000个字符
	 */
	@ApiField("memo")
	private String memo;

	/**
	 * 到位业务订单号，全局唯一，由32位数字组成，用户在到位下单时系统生成并消息同步给商家，商户只能查自己同步到的订单号
	 */
	@ApiField("order_no")
	private String orderNo;

	/**
	 * 第三方商家自己的订单号码，保证商家内部唯一，确认接单时需要设置外部订单号，长度不超过64个字符
	 */
	@ApiField("out_order_no")
	private String outOrderNo;

	public String getMemo() {
		return this.memo;
	}
	public void setMemo(String memo) {
		this.memo = memo;
	}

	public String getOrderNo() {
		return this.orderNo;
	}
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public String getOutOrderNo() {
		return this.outOrderNo;
	}
	public void setOutOrderNo(String outOrderNo) {
		this.outOrderNo = outOrderNo;
	}

}
