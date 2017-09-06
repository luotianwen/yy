package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

/**
 * 投保订单出单撤销
 *
 * @author auto create
 * @since 1.0, 2016-12-29 17:49:31
 */
public class AlipayInsSceneApplicationCancelModel extends AlipayObject {

	private static final long serialVersionUID = 4878158238769499296L;

	/**
	 * 投保订单号
	 */
	@ApiField("application_no")
	private String applicationNo;

	public String getApplicationNo() {
		return this.applicationNo;
	}
	public void setApplicationNo(String applicationNo) {
		this.applicationNo = applicationNo;
	}

}
