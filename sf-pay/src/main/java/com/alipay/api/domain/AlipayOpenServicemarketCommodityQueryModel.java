package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

/**
 * 服务插件信息查询
 *
 * @author auto create
 * @since 1.0, 2016-12-22 23:46:49
 */
public class AlipayOpenServicemarketCommodityQueryModel extends AlipayObject {

	private static final long serialVersionUID = 6437841518717142594L;

	/**
	 * 服务插件ID
	 */
	@ApiField("commodity_id")
	private String commodityId;

	/**
	 * 服务创建者ID
	 */
	@ApiField("user_id")
	private String userId;

	public String getCommodityId() {
		return this.commodityId;
	}
	public void setCommodityId(String commodityId) {
		this.commodityId = commodityId;
	}

	public String getUserId() {
		return this.userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}

}
