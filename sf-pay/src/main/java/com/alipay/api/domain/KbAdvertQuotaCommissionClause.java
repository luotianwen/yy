package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

/**
 * 固定金额
 *
 * @author auto create
 * @since 1.0, 2017-01-20 17:41:05
 */
public class KbAdvertQuotaCommissionClause extends AlipayObject {

	private static final long serialVersionUID = 4828513231655914248L;

	/**
	 * 固定金额
	 */
	@ApiField("quota_amount")
	private String quotaAmount;

	public String getQuotaAmount() {
		return this.quotaAmount;
	}
	public void setQuotaAmount(String quotaAmount) {
		this.quotaAmount = quotaAmount;
	}

}
