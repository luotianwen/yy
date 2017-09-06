package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

/**
 * 商圈主页地址创建修改接口
 *
 * @author auto create
 * @since 1.0, 2017-01-12 10:54:54
 */
public class KoubeiShopMallPageModifyModel extends AlipayObject {

	private static final long serialVersionUID = 3612251356222386763L;

	/**
	 * 商圈id
	 */
	@ApiField("mall_id")
	private String mallId;

	/**
	 * 商圈访问地址
	 */
	@ApiField("mall_url")
	private String mallUrl;

	/**
	 * 外部业务唯一id（用于幂等控制）
	 */
	@ApiField("out_biz_id")
	private String outBizId;

	public String getMallId() {
		return this.mallId;
	}
	public void setMallId(String mallId) {
		this.mallId = mallId;
	}

	public String getMallUrl() {
		return this.mallUrl;
	}
	public void setMallUrl(String mallUrl) {
		this.mallUrl = mallUrl;
	}

	public String getOutBizId() {
		return this.outBizId;
	}
	public void setOutBizId(String outBizId) {
		this.outBizId = outBizId;
	}

}
