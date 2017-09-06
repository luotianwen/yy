<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:forEach items="${orderInfos }" var="item">
	<tr class="head">
		<td colspan="8">
			<span style="margin-right: 20px;">
				订单编号： ${item.orderId}&nbsp;
			</span>
			<span style="margin-right: 20px;">
				货款金额： ￥${item.order_total_price}
			</span>
			<span style="margin-right: 20px;">
				下单时间：<fmt:formatDate value="${item.subTime}" pattern="yyyy-MM-dd HH:mm:ss" />
			</span>
			<c:if test="${item.payment_confirm_time!=null && item.payment_confirm_time!='' }">
				<span style="margin-right: 20px;">
					付款时间：<fmt:formatDate value="${item.payment_confirm_time}" pattern="yyyy-MM-dd HH:mm:ss" />
				</span>
			</c:if>
			<c:if test="${item.userConfirmTime!=null && item.userConfirmTime!='' }">
				<span style="margin-right: 20px;">
					确认时间：<fmt:formatDate value="${item.userConfirmTime}" pattern="yyyy-MM-dd HH:mm:ss" />
				</span>
			</c:if>
		</td>
	</tr>
	<tr class="content">
		<td>
			<c:forEach items="${item.orderDetailInfos }" var="detail">
				<div style="overflow: hidden;">
					<div style="width: 50px; height: 50px; float: left;">
						<a href="http://www.seebong.com/detail/${detail.sku}.html" target="_blank">
							<img width="50" height="50" src="${detail.productImage }">
						</a>
					</div>
					<div style="margin-top: 7px;">
						<a title="${detail.productName }" href="http://www.seebong.com/detail/${detail.sku}.html" target="_blank">
							${detail.productName}
						</a>
					</div>
					<div>
						<span>商品数量:${detail.quantity}</span><span>货号:${detail.productNumber}</span>
					</div>
				</div>
			</c:forEach>
		</td>
		<td>
			<div>商品金额: ￥${item.order_total_price}</div>
			<c:if test="${item.freight_price>0 }">
				<div>运费金额:￥${item.freight_price }</div>
			</c:if>
			<div>总金额: ￥${item.order_total_price}</div>
		</td>
		<td>
			<c:if test="${item.orderInfodiscounts==null }">
				<span>无优惠信息</span>
			</c:if>
			<c:forEach items="${item.orderInfodiscounts }" var="itemp">
				<span>
					<c:if test="${itemp.type==1 }">
						<span>优惠券：</span>
					</c:if>
					<c:if test="${itemp.type==2 }">
						<span>世峰e卡：</span>
					</c:if>
					${itemp.discountMoney}元<br/>
				</span>
			</c:forEach>
		</td>
		<td>
			<c:if test="${item.orderStatus==0 }">等待付款</c:if>
			<c:if test="${item.orderStatus==1 }">等待发货</c:if>
			<c:if test="${item.orderStatus==2 }">等待收货</c:if>
			<c:if test="${item.orderStatus==3 }">交易成功</c:if>
			<c:if test="${item.orderStatus==4 }">取消订单</c:if>
			<c:if test="${item.orderStatus==5 }">交易中途关闭</c:if>
			<c:if test="${item.orderStatus==6 }">退货</c:if>
			<c:if test="${item.orderStatus==7 }">锁定</c:if>
			<c:if test="${item.orderStatus==11 }">系统生成退款单</c:if>
			<c:if test="${item.orderStatus==12 }">财务退款操作</c:if>
			<c:if test="${item.orderStatus==101 }">更新配送费用</c:if>
			<c:if test="${item.orderStatus==102 }">更新折扣</c:if>
		</td>
		<td>
			<c:if test="${item.expressName==null||item.expressName=='' }">
				<span>暂无信息</span>
			</c:if>
			<c:if test="${item.expresss!=null }">
				<c:forEach items="${item.expresss }" var="ep" varStatus="stat">
					<span>快递名:${ep.expressName}<br>快递编号:${ep.expressNumber}</span>
					<c:if test="${!stat.last }">
						<br><br>
					</c:if>
				</c:forEach>
			</c:if>
		</td>
		<td>${item.receiveName}</td>
		<td style="word-wrap: break-word; word-break: break-all;">
			${item.sellerRemark}
		</td>
		<td>
			<a class="cursor" data_id="${item.orderId }" id="check" title="查看详情">
				查看详情
			</a><br>
			<a class="cursor" id="sellerRemark" title="${item.sellerRemark }" data_id="${item.orderId }">
				<c:if test="${item.sellerRemark==null || item.sellerRemark=='' }">添加备注</c:if>
				<c:if test="${item.sellerRemark!=null && item.sellerRemark!='' }">修改备注</c:if>
			</a><br>
			<c:if test="${item.orderStatus==1 }">
				<a class="cursor" id="stock" data_id="${item.orderId }">出库</a><br>
				<a class="cursor" id="cancel" data_id="${item.orderId }">取消订单</a>
			</c:if>
			<c:if test="${item.orderStatus==7 }">
				<a class="cursor" id="refund" data_id="${item.orderId }">已退款</a><br>
			</c:if>
		</td>
	</tr>
</c:forEach>

<script type="text/javascript">
	$(function(){
		setPage("${page.currentPage}","orderInfo/findAllOrderInfo.html","${page.totalPage}","orderList",$("#form").serialize());
	})
	
	function o_submit(){
		spage("${page.currentPage}","orderInfo/findAllOrderInfo.html","orderList",$("#form").serialize());
	}
</script>