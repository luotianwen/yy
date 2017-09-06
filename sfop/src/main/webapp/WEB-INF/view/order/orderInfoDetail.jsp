<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<!DOCTYPE html>
<html>

<head>
	<base href="<%=basePath%>">
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	
	<title>编辑</title>
	
	<link href="static/css/bootstrap.min.css" rel="stylesheet">
	<link href="static/css/animate.min.css" rel="stylesheet">
	<link href="static/css/style.min.css" rel="stylesheet">
	<link href="static/css/layerdate/layerdate.css" rel="stylesheet">
	<!-- iCheck -->
	<link href="static/css/plugins/iCheck/custom.css" rel="stylesheet">
	
	<link rel="stylesheet" type="text/css" href="static/css/orderdetail.css" />

</head>

<body class="gray-bg">
	<div class="boxw clearfix">
		<div class="order-state clearfix">
			<div class="state-lcol">
				<div class="state-top">订单号：${orderInfo.orderId}</div>
				<c:if test="${orderInfo.orderStatus==0 }">
					<h3 class="state-txt">等待付款</h3>
				</c:if>
				<c:if test="${orderInfo.orderStatus==1 }">
					<h3 class="state-txt ftx-02">付款成功</h3>
					<div class="state-txt-2">等待发货</div>
				</c:if>
				<c:if test="${orderInfo.orderStatus==2 }">
					<h3 class="state-txt ftx-02">付款成功</h3>
					<div class="state-txt-2">等待收货</div>
				</c:if>
				<c:if test="${orderInfo.orderStatus==3 }"><h3 class="state-txt ftx-02">交易成功</h3></c:if>
				<c:if test="${orderInfo.orderStatus==4 }"><h3 class="state-txt">订单已取消</h3></c:if>
				<c:if test="${orderInfo.orderStatus==5 }"><h3 class="state-txt">订单已关闭</h3></c:if>
				<c:if test="${orderInfo.orderStatus==6 }"><h3 class="state-txt">退款中</h3></c:if>
			</div>
			<div class="state-lline"></div>
			<div class="state-rcol">
				<div class="order-process">
					<i class="node-icon-<c:if test="${orderInfo.orderStatus==0 }">1</c:if><c:if test="${orderInfo.orderStatus==1 }">2</c:if><c:if test="${orderInfo.orderStatus==2 }">3</c:if><c:if test="${orderInfo.orderStatus==3 }"><c:if test="${orderInfo.estatus!=2 }">4</c:if><c:if test="${orderInfo.estatus==2 }">5</c:if></c:if>"></i>
					<div class="node01">
						<p class="txt1 <c:if test="${orderInfo.orderStatus==0 }">over</c:if>">提交订单</p>
					</div>
					<div class="node02">
						<p class="txt1 <c:if test="${orderInfo.orderStatus==1 }">over</c:if>">付款成功</p>
					</div>
					<div class="node02">
						<p class="txt1 <c:if test="${orderInfo.orderStatus==2 }">over</c:if>">商家发货</p>
					</div>
					<div class="node02">
						<p class="txt1 <c:if test="${orderInfo.orderStatus==3 && orderInfo.estatus!=2 }">over</c:if>">确认收货</p>
					</div>
					<div class="node03">
						<p class="txt1 <c:if test="${orderInfo.orderStatus==3 && orderInfo.estatus==2 }">over</c:if>">评价</p>
					</div>
				</div>
			</div>
		</div>
		<div class="order-info clearfix">
			<div class="info-lcol">
				<h3 class="mt">
					<i></i>订单信息
				</h3>
				<dl>
					<dt>收货地址：</dt>
					<dd>${orderInfo.address}</dd>
				</dl>
				<dl>
					<dt>收货人：</dt>
					<dd>${orderInfo.receiveName}</dd>
				</dl>
				<dl>
					<dt>联系方式：</dt>
					<dd>${orderInfo.phoneNumber}</dd>
				</dl>
				<dl>
					<dt>发票信息：</dt>
					<dd>普通发票（纸质） 个人 明细</dd>
				</dl>
				<dl>
					<dt>备注信息：</dt>
					<dd>${orderInfo.remark }</dd>
				</dl>
			</div>
			<div class="info-lline"></div>
			<div class="info-rcol">
				<c:if test="${fn.length(logs)>0 }">
					<h3 class="mt">
						<i></i>订单日志
					</h3>
					<ul>
						<c:forEach items="${logs }" var="log" varStatus="stat">
							<li <c:if test="${!stat.last }">class="last"</c:if>>
								<i></i>
								<fmt:formatDate value="${log.create_time}" pattern="yyyy-MM-dd HH:mm:ss" />
								${log.log_content}
							</li>
						</c:forEach>
					</ul>
				</c:if>
			</div>
		</div>
		<c:if test="${fn:length(expressTracess)>0}">
		<div class="track-list clearfix">
			<h3 class="track-tit">
				<i></i>物流信息
			</h3>
			<c:forEach items="${expressTracess }" var="item">
				<ul>
					<c:forEach items="${item }" var="expressTrace">
						<li class="afterdate">
							<span class="time">${expressTrace.time}</span>
							<span class="txt">${expressTrace.context}</span>
						</li>
					</c:forEach>
				</ul>
			</c:forEach>
		</div>
		</c:if>
		<div class="g-list clearfix">
			<table>
				<colgroup>
					<col class="info-col">
					<col class="price-col">
					<col class="number-col">
					<col class="amount-col">
					<col class="status-col">
				</colgroup>
				<thead>
					<tr>
						<th>订单详情</th>
						<th>单价</th>
						<th>数量</th>
						<th>总价</th>
						<th>状态</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${orderInfo.orderDetailInfos }" var="ware">
						<tr class="tr-bd">
							<td>
								<div class="g-info">
									<a href="/detail/${ware.sku}.html" target="_blank">
										<img src="${ware.productImage}" alt="${ware.productName}">
										${ware.productName}
									</a>
								</div>
							</td>
							<td>
								<div class="g-others">¥${ware.quantity}</div>
							</td>
							<td>
								<div class="g-others">x${ware.quantity}</div>
							</td>
							<td>
								<div class="g-others">¥${ware.totalMoney}</div>
							</td>
							<td>
								<div class="g-others">
									<c:if test="${orderInfo.sstatus==0 }">
										<c:if test="${orderInfo.orderStatus==0 }">
											等待付款
										</c:if>
										<c:if test="${orderInfo.orderStatus==1 }">
											等待发货
										</c:if>
										<c:if test="${orderInfo.orderStatus==2 }">
											等待收货
										</c:if>
										<c:if test="${orderInfo.orderStatus==3 }">
											交易完成
										</c:if>
										<c:if test="${orderInfo.orderStatus==4 || orderInfo.orderStatus==5 }">
											交易关闭
										</c:if>
										<c:if test="${orderInfo.orderStatus==6 }">
											等待退款
										</c:if>
									</c:if>
									<c:if test="${orderInfo.sstatus!=0 }">
										<c:if test="${orderInfo.sstatus==1 }">
											等待换货
										</c:if>
										<c:if test="${orderInfo.sstatus==2 }">
											等待退款
										</c:if>
										<c:if test="${orderInfo.sstatus==3 }">
											等待退款退货
										</c:if>
										<c:if test="${orderInfo.sstatus==4 }">
											等待维修
										</c:if>
									</c:if>
								</div>
							</td>
	
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>


	<!-- 全局js -->
	<script src="static/js/vue.js"></script>
	<script src="static/js/jquery-2.1.1.min.js"></script>
	<script src="static/js/bootstrap.min.js"></script>
	<script src="static/js/plugins/layer/layer.min.js"></script>
	<!-- iCheck -->
	<script src="static/js/plugins/iCheck/icheck.min.js"></script>
	
</body>
</html>