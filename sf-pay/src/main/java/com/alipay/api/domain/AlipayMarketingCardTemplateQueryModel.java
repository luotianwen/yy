package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

/**
 * 会员卡模板查询接口
 *
 * @author auto create
 * @since 1.0, 2016-10-18 15:46:31
 */
public class AlipayMarketingCardTemplateQueryModel extends AlipayObject {

	private static final long serialVersionUID = 4479739179993513985L;

	/**
	 * 支付宝卡模板ID（模板创建接口返回的支付宝端模板ID）
	 */
	@ApiField("template_id")
	private String templateId;

	public String getTemplateId() {
		return this.templateId;
	}
	public void setTemplateId(String templateId) {
		this.templateId = templateId;
	}

}
