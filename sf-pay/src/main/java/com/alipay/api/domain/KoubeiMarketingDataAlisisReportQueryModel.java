package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

/**
 * 报表详情查询接口
 *
 * @author auto create
 * @since 1.0, 2016-10-28 10:26:15
 */
public class KoubeiMarketingDataAlisisReportQueryModel extends AlipayObject {

	private static final long serialVersionUID = 5854861762764372298L;

	/**
	 * 报表唯一标识
	 */
	@ApiField("report_uk")
	private String reportUk;

	public String getReportUk() {
		return this.reportUk;
	}
	public void setReportUk(String reportUk) {
		this.reportUk = reportUk;
	}

}
