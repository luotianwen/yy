package com.alipay.api.response;

import com.alipay.api.internal.mapping.ApiField;

import com.alipay.api.AlipayResponse;

/**
 * ALIPAY API: alipay.marketing.campaign.activity.offline.trigger response.
 * 
 * @author auto create
 * @since 1.0, 2016-05-23 14:35:31
 */
public class AlipayMarketingCampaignActivityOfflineTriggerResponse extends AlipayResponse {

	private static final long serialVersionUID = 1845541769675695351L;

	/** 
	 * 外部奖品ID
	 */
	@ApiField("out_prize_id")
	private String outPrizeId;

	public void setOutPrizeId(String outPrizeId) {
		this.outPrizeId = outPrizeId;
	}
	public String getOutPrizeId( ) {
		return this.outPrizeId;
	}

}
