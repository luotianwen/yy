package com.alipay.api.response;

import com.alipay.api.internal.mapping.ApiField;
import com.alipay.api.domain.CampDetail;

import com.alipay.api.AlipayResponse;

/**
 * ALIPAY API: koubei.marketing.campaign.activity.query response.
 * 
 * @author auto create
 * @since 1.0, 2016-12-27 16:58:19
 */
public class KoubeiMarketingCampaignActivityQueryResponse extends AlipayResponse {

	private static final long serialVersionUID = 1635477967661225237L;

	/** 
	 * 活动详情
	 */
	@ApiField("camp_detail")
	private CampDetail campDetail;

	public void setCampDetail(CampDetail campDetail) {
		this.campDetail = campDetail;
	}
	public CampDetail getCampDetail( ) {
		return this.campDetail;
	}

}
