package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

/**
 * 服务的物流信息
 *
 * @author auto create
 * @since 1.0, 2017-01-16 11:29:56
 */
public class OrderLogisticsInfo extends AlipayObject {

	private static final long serialVersionUID = 3167933589312545314L;

	/**
	 * 消费者下单线下服务时，填写的服务地址
	 */
	@ApiField("address")
	private String address;

	/**
	 * 联系人
	 */
	@ApiField("contact_name")
	private String contactName;

	/**
	 * 订单的物流扩展信息，包括服务开始时间、服务结束时间
	 */
	@ApiField("ext_info")
	private OrderLogisticsExtInfo extInfo;

	/**
	 * 消费者地址维度（高德坐标系）
	 */
	@ApiField("latitude")
	private String latitude;

	/**
	 * 消费者地址经度（高德坐标系）
	 */
	@ApiField("longitude")
	private String longitude;

	/**
	 * 联系电话
	 */
	@ApiField("mobile")
	private String mobile;

	public String getAddress() {
		return this.address;
	}
	public void setAddress(String address) {
		this.address = address;
	}

	public String getContactName() {
		return this.contactName;
	}
	public void setContactName(String contactName) {
		this.contactName = contactName;
	}

	public OrderLogisticsExtInfo getExtInfo() {
		return this.extInfo;
	}
	public void setExtInfo(OrderLogisticsExtInfo extInfo) {
		this.extInfo = extInfo;
	}

	public String getLatitude() {
		return this.latitude;
	}
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return this.longitude;
	}
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public String getMobile() {
		return this.mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

}
