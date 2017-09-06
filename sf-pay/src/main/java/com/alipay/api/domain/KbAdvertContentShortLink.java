package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

/**
 * 口碑广告系统短链内容详情
 *
 * @author auto create
 * @since 1.0, 2017-01-16 16:13:33
 */
public class KbAdvertContentShortLink extends AlipayObject {

	private static final long serialVersionUID = 2717918586975456797L;

	/**
	 * 链接地址
	 */
	@ApiField("url")
	private String url;

	public String getUrl() {
		return this.url;
	}
	public void setUrl(String url) {
		this.url = url;
	}

}
