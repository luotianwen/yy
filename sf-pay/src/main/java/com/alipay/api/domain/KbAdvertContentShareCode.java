package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

/**
 * 口碑广告系统吱口令内容详情
 *
 * @author auto create
 * @since 1.0, 2017-01-16 16:13:33
 */
public class KbAdvertContentShareCode extends AlipayObject {

	private static final long serialVersionUID = 7632444897947977262L;

	/**
	 * 吱口令内容详情
	 */
	@ApiField("share_code_desc")
	private String shareCodeDesc;

	public String getShareCodeDesc() {
		return this.shareCodeDesc;
	}
	public void setShareCodeDesc(String shareCodeDesc) {
		this.shareCodeDesc = shareCodeDesc;
	}

}
