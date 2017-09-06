package com.alipay.api.response;

import java.util.List;
import com.alipay.api.internal.mapping.ApiField;
import com.alipay.api.internal.mapping.ApiListField;
import com.alipay.api.domain.OrderLogisticsInfo;
import com.alipay.api.domain.ServiceOrderInfo;

import com.alipay.api.AlipayResponse;

/**
 * ALIPAY API: alipay.daowei.order.query response.
 * 
 * @author auto create
 * @since 1.0, 2017-01-16 11:29:56
 */
public class AlipayDaoweiOrderQueryResponse extends AlipayResponse {

	private static final long serialVersionUID = 6763584238391149889L;

	/** 
	 * 订单创建时间，用户点击预约下单操作的时间，格式为yyyy-MM-dd HH:mm:ss（到秒）下单时间因早于服务预约时间
	 */
	@ApiField("gmt_create")
	private String gmtCreate;

	/** 
	 * 订单修改时间，格式为yyyy-MM-dd HH:mm:ss(到秒，创建订单时，修改时间与创建时间相同)
	 */
	@ApiField("gmt_modified")
	private String gmtModified;

	/** 
	 * 订单最后支付时间，格式：yyyy-MM-dd HH:mm:ss（到秒）
	 */
	@ApiField("gmt_payment")
	private String gmtPayment;

	/** 
	 * 订单最后退款时间，格式：yyyy-MM-dd HH:mm:ss，订单产生退款时的最后操作时间
	 */
	@ApiField("gmt_refund")
	private String gmtRefund;

	/** 
	 * 物流信息，用户下订单填写的物流信息，包括服务地址的经纬度、联系人和手机号码以及扩展信息
	 */
	@ApiField("logistics_info")
	private OrderLogisticsInfo logisticsInfo;

	/** 
	 * 备注信息，消费者下单时填写的订单备注信息，长度不超过2000字符
	 */
	@ApiField("memo")
	private String memo;

	/** 
	 * 到位业务订单号，全局唯一，由32位数字组成，用户在到位下单时系统生成并消息同步给商家，商户只能查自己同步到的订单号
	 */
	@ApiField("order_no")
	private String orderNo;

	/** 
	 * 到位订单状态枚举值，用于描述订单的业务状态，入参时手动设置（枚举：WAIT_CONFIRM/WAIT_SERVICE/CONFIRMED_SERVICE/SERVICE_COMPLETE/ORDER_FINISHED/ORDER_CLOSE）
	 */
	@ApiField("order_status")
	private String orderStatus;

	/** 
	 * 订单已付款金额，不小于0的数，单位为元，单个订单金额小于10w。
	 */
	@ApiField("payment_amount")
	private String paymentAmount;

	/** 
	 * 订单实际金额，不小于0的数，单位为元，单个订单金额小于10w。
	 */
	@ApiField("real_amount")
	private String realAmount;

	/** 
	 * 订单已退款的金额，单位为元，若订单存在退款，则金额大于0，且小于等于实际支付的金额
	 */
	@ApiField("refund_amount")
	private String refundAmount;

	/** 
	 * 服务订单列表：包含订单所对应的服务，服务可能包含不止一个，每个服务对应自身的单价、总价、退款价格等
	 */
	@ApiListField("service_order_list")
	@ApiField("service_order_info")
	private List<ServiceOrderInfo> serviceOrderList;

	/** 
	 * 订单总的金额，不小于0的数，单位为元，单个订单金额小于10w
	 */
	@ApiField("total_amount")
	private String totalAmount;

	public void setGmtCreate(String gmtCreate) {
		this.gmtCreate = gmtCreate;
	}
	public String getGmtCreate( ) {
		return this.gmtCreate;
	}

	public void setGmtModified(String gmtModified) {
		this.gmtModified = gmtModified;
	}
	public String getGmtModified( ) {
		return this.gmtModified;
	}

	public void setGmtPayment(String gmtPayment) {
		this.gmtPayment = gmtPayment;
	}
	public String getGmtPayment( ) {
		return this.gmtPayment;
	}

	public void setGmtRefund(String gmtRefund) {
		this.gmtRefund = gmtRefund;
	}
	public String getGmtRefund( ) {
		return this.gmtRefund;
	}

	public void setLogisticsInfo(OrderLogisticsInfo logisticsInfo) {
		this.logisticsInfo = logisticsInfo;
	}
	public OrderLogisticsInfo getLogisticsInfo( ) {
		return this.logisticsInfo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}
	public String getMemo( ) {
		return this.memo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}
	public String getOrderNo( ) {
		return this.orderNo;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}
	public String getOrderStatus( ) {
		return this.orderStatus;
	}

	public void setPaymentAmount(String paymentAmount) {
		this.paymentAmount = paymentAmount;
	}
	public String getPaymentAmount( ) {
		return this.paymentAmount;
	}

	public void setRealAmount(String realAmount) {
		this.realAmount = realAmount;
	}
	public String getRealAmount( ) {
		return this.realAmount;
	}

	public void setRefundAmount(String refundAmount) {
		this.refundAmount = refundAmount;
	}
	public String getRefundAmount( ) {
		return this.refundAmount;
	}

	public void setServiceOrderList(List<ServiceOrderInfo> serviceOrderList) {
		this.serviceOrderList = serviceOrderList;
	}
	public List<ServiceOrderInfo> getServiceOrderList( ) {
		return this.serviceOrderList;
	}

	public void setTotalAmount(String totalAmount) {
		this.totalAmount = totalAmount;
	}
	public String getTotalAmount( ) {
		return this.totalAmount;
	}

}
