package com.alipay.api.domain;

import java.util.List;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;
import com.alipay.api.internal.mapping.ApiListField;

/**
 * 数据项的调查结果
 *
 * @author auto create
 * @since 1.0, 2016-12-01 12:02:21
 */
public class InvestigCategoryResult extends AlipayObject {

	private static final long serialVersionUID = 7177995235788761588L;

	/**
	 * 数据项Category
	 */
	@ApiField("category")
	private String category;

	/**
	 * 数据项对应的所有采集结果
	 */
	@ApiListField("category_result")
	@ApiField("investig_category_data")
	private List<InvestigCategoryData> categoryResult;

	public String getCategory() {
		return this.category;
	}
	public void setCategory(String category) {
		this.category = category;
	}

	public List<InvestigCategoryData> getCategoryResult() {
		return this.categoryResult;
	}
	public void setCategoryResult(List<InvestigCategoryData> categoryResult) {
		this.categoryResult = categoryResult;
	}

}
