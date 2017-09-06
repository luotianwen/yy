package com.shifeng.dto.mall.order;

import java.io.Serializable;
import java.util.List;

/**
 * 订单结算信息
 * @author WinZhong
 *
 */
public class OrderSettlementDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	//收货地址ID
	private Integer addressId;
	//匿名购买(1:是；2否)
	private Integer anonymous;
	//优惠券ID
	private String couponId;
	//E卡ID
	private String eCardId;
	//支付类型
	private String paymentType;
	
	//店铺
	private List<OrderSettlementShopDTO> shops;

	public Integer getAddressId() {
		return addressId;
	}

	public void setAddressId(Integer addressId) {
		this.addressId = addressId;
	}

	public Integer getAnonymous() {
		return anonymous;
	}

	public void setAnonymous(Integer anonymous) {
		this.anonymous = anonymous;
	}

	public String getCouponId() {
		return couponId;
	}

	public void setCouponId(String couponId) {
		this.couponId = couponId;
	}

	public String geteCardId() {
		return eCardId;
	}

	public void seteCardId(String eCardId) {
		this.eCardId = eCardId;
	}

	public List<OrderSettlementShopDTO> getShops() {
		return shops;
	}

	public void setShops(List<OrderSettlementShopDTO> shops) {
		this.shops = shops;
	}

	public String getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}

	@Override
	public String toString() {
		return "OrderSettlementDTO [addressId=" + addressId + ", anonymous=" + anonymous + ", couponId=" + couponId
				+ ", eCardId=" + eCardId + ", paymentType=" + paymentType + ", shops=" + shops + "]";
	}
	
	

}
