package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

/**
 * 优惠活动白名单查询
 *
 * @author auto create
 * @since 1.0, 2016-11-10 14:14:01
 */
public class AlipayMarketingCampaignDiscountWhitelistQueryModel extends AlipayObject {

	private static final long serialVersionUID = 1325171137665385381L;

	/**
	 * 活动od
	 */
	@ApiField("camp_id")
	private String campId;

	public String getCampId() {
		return this.campId;
	}
	public void setCampId(String campId) {
		this.campId = campId;
	}

}
