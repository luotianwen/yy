package com.alipay.api.response;

import java.util.List;
import com.alipay.api.internal.mapping.ApiField;
import com.alipay.api.internal.mapping.ApiListField;
import com.alipay.api.domain.ItemDiagnoseType;

import com.alipay.api.AlipayResponse;

/**
 * ALIPAY API: koubei.marketing.data.dishdiagnosetype.batchquery response.
 * 
 * @author auto create
 * @since 1.0, 2017-01-16 10:20:18
 */
public class KoubeiMarketingDataDishdiagnosetypeBatchqueryResponse extends AlipayResponse {

	private static final long serialVersionUID = 4685675778259381647L;

	/** 
	 * 菜品类型list
	 */
	@ApiListField("item_diagnose_type_list")
	@ApiField("item_diagnose_type")
	private List<ItemDiagnoseType> itemDiagnoseTypeList;

	public void setItemDiagnoseTypeList(List<ItemDiagnoseType> itemDiagnoseTypeList) {
		this.itemDiagnoseTypeList = itemDiagnoseTypeList;
	}
	public List<ItemDiagnoseType> getItemDiagnoseTypeList( ) {
		return this.itemDiagnoseTypeList;
	}

}
