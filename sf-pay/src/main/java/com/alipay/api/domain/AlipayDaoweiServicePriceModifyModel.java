package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

/**
 * 更新服务价格接口
 *
 * @author auto create
 * @since 1.0, 2017-01-16 11:30:05
 */
public class AlipayDaoweiServicePriceModifyModel extends AlipayObject {

	private static final long serialVersionUID = 5851735976473529389L;

	/**
	 * 外部服务id,商家自己维护的唯一标识,用于确定商家的某个服务.仅支持数字,字母和下划线
	 */
	@ApiField("out_service_id")
	private String outServiceId;

	/**
	 * 价格维度类型，可选值:string；json。string表示unit_price的类型是一维价格，如果是json表示多维价格
	 */
	@ApiField("price_dim_type")
	private String priceDimType;

	/**
	 * 单价，单位为元，根据price_dim_type的值决定如果是一维价格直接使用字符串，比如："30.5"，如果是多维，比如同一个属性不同地区价格不同的情况，比如
{
  "-1": "30", //表示默认价
 "110100": "60"
}
"110100"为北京城市码，参考高德标准，该配置表示北京地区价格60元，其他地区价格30元
	 */
	@ApiField("unit_price")
	private String unitPrice;

	public String getOutServiceId() {
		return this.outServiceId;
	}
	public void setOutServiceId(String outServiceId) {
		this.outServiceId = outServiceId;
	}

	public String getPriceDimType() {
		return this.priceDimType;
	}
	public void setPriceDimType(String priceDimType) {
		this.priceDimType = priceDimType;
	}

	public String getUnitPrice() {
		return this.unitPrice;
	}
	public void setUnitPrice(String unitPrice) {
		this.unitPrice = unitPrice;
	}

}
