package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

/**
 * 信用借还订单查询
 *
 * @author auto create
 * @since 1.0, 2016-11-24 16:42:21
 */
public class ZhimaMerchantOrderRentQueryModel extends AlipayObject {

	private static final long serialVersionUID = 4635536798785494541L;

	/**
	 * 外部订单号，需要唯一，由商户传入，芝麻内部会做幂等控制，格式为：yyyyMMddHHmmss+随机数
	 */
	@ApiField("out_order_no")
	private String outOrderNo;

	/**
	 * 信用借还的产品码:w1010100000000002858
	 */
	@ApiField("product_code")
	private String productCode;

	public String getOutOrderNo() {
		return this.outOrderNo;
	}
	public void setOutOrderNo(String outOrderNo) {
		this.outOrderNo = outOrderNo;
	}

	public String getProductCode() {
		return this.productCode;
	}
	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

}
