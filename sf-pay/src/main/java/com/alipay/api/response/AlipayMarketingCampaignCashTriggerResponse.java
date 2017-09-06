package com.alipay.api.response;

import com.alipay.api.internal.mapping.ApiField;

import com.alipay.api.AlipayResponse;

/**
 * ALIPAY API: alipay.marketing.campaign.cash.trigger response.
 * 
 * @author auto create
 * @since 1.0, 2017-01-13 13:21:21
 */
public class AlipayMarketingCampaignCashTriggerResponse extends AlipayResponse {

	private static final long serialVersionUID = 2392281918395838455L;

	/** 
	 * 红包名称,创建活动时设置，用于账单列表和详情、红包列表和详情的展示
	 */
	@ApiField("coupon_name")
	private String couponName;

	/** 
	 * 用户领取失败的错误信息描述
	 */
	@ApiField("error_msg")
	private String errorMsg;

	/** 
	 * 商户头像logo的图片url地址，用于账单和红包列表、详情的展示
	 */
	@ApiField("merchant_logo")
	private String merchantLogo;

	/** 
	 * 发送红包商户签约pid，发奖成功时非空
	 */
	@ApiField("partner_id")
	private String partnerId;

	/** 
	 * 现金红包金额，发奖成功时非空，千分位格式，保留两位小数
	 */
	@ApiField("prize_amount")
	private String prizeAmount;

	/** 
	 * 活动文案,用于账单的备注展示、红包详情页的文案展示
	 */
	@ApiField("prize_msg")
	private String prizeMsg;

	/** 
	 * 用户是否重复领取，如果重复领取，返回的是之前的中奖结果，如果是首次领取，则走发奖流程
	 */
	@ApiField("repeat_trigger_flag")
	private String repeatTriggerFlag;

	/** 
	 * 是否中奖结果状态，如果为true时返回的结果中的其他字段非空，否则返回的其他字段为空
	 */
	@ApiField("trigger_result")
	private String triggerResult;

	public void setCouponName(String couponName) {
		this.couponName = couponName;
	}
	public String getCouponName( ) {
		return this.couponName;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}
	public String getErrorMsg( ) {
		return this.errorMsg;
	}

	public void setMerchantLogo(String merchantLogo) {
		this.merchantLogo = merchantLogo;
	}
	public String getMerchantLogo( ) {
		return this.merchantLogo;
	}

	public void setPartnerId(String partnerId) {
		this.partnerId = partnerId;
	}
	public String getPartnerId( ) {
		return this.partnerId;
	}

	public void setPrizeAmount(String prizeAmount) {
		this.prizeAmount = prizeAmount;
	}
	public String getPrizeAmount( ) {
		return this.prizeAmount;
	}

	public void setPrizeMsg(String prizeMsg) {
		this.prizeMsg = prizeMsg;
	}
	public String getPrizeMsg( ) {
		return this.prizeMsg;
	}

	public void setRepeatTriggerFlag(String repeatTriggerFlag) {
		this.repeatTriggerFlag = repeatTriggerFlag;
	}
	public String getRepeatTriggerFlag( ) {
		return this.repeatTriggerFlag;
	}

	public void setTriggerResult(String triggerResult) {
		this.triggerResult = triggerResult;
	}
	public String getTriggerResult( ) {
		return this.triggerResult;
	}

}
