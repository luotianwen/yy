package com.alipay.api.response;

import com.alipay.api.internal.mapping.ApiField;

import com.alipay.api.AlipayResponse;

/**
 * ALIPAY API: alipay.ebpp.bill.payurl.get response.
 * 
 * @author auto create
 * @since 1.0, 2016-10-31 11:11:08
 */
public class AlipayEbppBillPayurlGetResponse extends AlipayResponse {

	private static final long serialVersionUID = 4515338619752692296L;

	/** 
	 * 付款页面地址
	 */
	@ApiField("pay_url")
	private String payUrl;

	public void setPayUrl(String payUrl) {
		this.payUrl = payUrl;
	}
	public String getPayUrl( ) {
		return this.payUrl;
	}

}
