package com.alipay.api.domain;

import java.util.List;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;
import com.alipay.api.internal.mapping.ApiListField;

/**
 * 外部商户同步电子发票至支付宝
 *
 * @author auto create
 * @since 1.0, 2016-12-20 15:31:31
 */
public class AlipayEbppInvoiceSycnModel extends AlipayObject {

	private static final long serialVersionUID = 7822645594488925277L;

	/**
	 * 同步发票信息模型
	 */
	@ApiListField("invoice_info")
	@ApiField("invoice_model_content")
	private List<InvoiceModelContent> invoiceInfo;

	/**
	 * 商户的品牌名称简称,该字段对应isv提供的商户配置表中的商户品牌简称，
m_short_name+sub_m_short_name具有唯一约束
如：肯德基：KFC
	 */
	@ApiField("m_short_name")
	private String mShortName;

	/**
	 * 支付宝为商户分配的商户门店简称，该字段对应isv提供的商户配置中的商户门店检查
如：肯德基-杭州西湖区文一西路店：KFC-HZ-19003
	 */
	@ApiField("sub_m_short_name")
	private String subMShortName;

	public List<InvoiceModelContent> getInvoiceInfo() {
		return this.invoiceInfo;
	}
	public void setInvoiceInfo(List<InvoiceModelContent> invoiceInfo) {
		this.invoiceInfo = invoiceInfo;
	}

	public String getmShortName() {
		return this.mShortName;
	}
	public void setmShortName(String mShortName) {
		this.mShortName = mShortName;
	}

	public String getSubMShortName() {
		return this.subMShortName;
	}
	public void setSubMShortName(String subMShortName) {
		this.subMShortName = subMShortName;
	}

}
