package com.alipay.api.domain;

import java.util.List;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;
import com.alipay.api.internal.mapping.ApiListField;

/**
 * 券的说明条款
 *
 * @author auto create
 * @since 1.0, 2016-10-31 12:00:30
 */
public class ClauseTerm extends AlipayObject {

	private static final long serialVersionUID = 1681768949855928788L;

	/**
	 * 说明描述内容
	 */
	@ApiListField("descriptions")
	@ApiField("string")
	private List<String> descriptions;

	/**
	 * 说明title
	 */
	@ApiField("title")
	private String title;

	public List<String> getDescriptions() {
		return this.descriptions;
	}
	public void setDescriptions(List<String> descriptions) {
		this.descriptions = descriptions;
	}

	public String getTitle() {
		return this.title;
	}
	public void setTitle(String title) {
		this.title = title;
	}

}
