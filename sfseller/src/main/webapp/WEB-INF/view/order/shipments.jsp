<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<style type="text/css">
	.h_h3{
		padding-bottom:10px;
		border-bottom:1px dotted #88cd9c;
		margin:10px 0;
	}
	
</style>

<div class=" row">
	<div class="box col-md-12">
		<div class="box-inner">
			<div class="box-header well">
				<h2>
					<i class="glyphicon glyphicon-th"></i> 出库
				</h2>
			</div>
			
			<div class="order_form">
				<h3 class="h_h3">选择物流服务</h3>
				
				<form id="form">
					<input type="hidden" name="orderId" value="${orderInfo.orderId }"/>
					<table style="width: 50%;">
						<tbody>
							<tr>
								<td align="right">物流公司：</td>
								<td>
									<select style="width: 177px" id="expressId" name="expressId">
										<c:forEach items="${expressconfig }" var="item">
											<option value="${item.id }">${item.name }</option>
										</c:forEach>
									</select>
								</td>
							</tr>
							<tr>
								<td align="right">收货地址：</td>
								<td>${orderInfo.address } ${orderInfo.phoneNumber }</td>
							</tr>
							<tr>
								<td align="right">运单号：</td>
								<td><input id="expressNumber" maxlength="30" name="expressNumber" type="text"/></td>
							</tr>
						</tbody>
					</table>
				</form>
				
				<h3 class="h_h3">订单基本信息</h3>
				<table width="100%" border="0" cellspacing="0" cellpadding="0" style="width: 100%;">
					<tbody>
						<tr>
							<td align="right">收货人姓名：</td>
							<td>${orderInfo.receiveName }</td>
							<td align="right">订单类型：</td>
							<td>${orderInfo.orderType }</td>
						</tr>
						<tr>
							<td align="right">收货地址：</td>
							<td>${orderInfo.address }</td>
							<td align="right">手机号码：</td>
							<td>${orderInfo.phoneNumber }</td>
						</tr>
						<tr>
							<td align="right">订单编号：</td>
							<td>${orderInfo.perentId }</td>
							<td align="right">配送方式：</td>
							<td>普通快递(配送方式是什么？待定)</td>
						</tr>
						<tr>
							<td align="right">支付方式：</td>
							<td>${orderInfo.defaultPayment }(支付方式待定)</td>
							<td align="right">邮编：</td>
							<td>${orderInfo.zipCode }</td>
						</tr>
						<tr>
							<td align="right">下单时间：</td>
							<td><fmt:formatDate value="${orderInfo.subTime }" pattern="yyyy-MM-dd HH:mm:ss" /></td>
							<td align="right">支付时间：</td>
							<td><fmt:formatDate value="${orderInfo.payment_confirm_time }" pattern="yyyy-MM-dd HH:mm:ss" /></td>
						</tr>
						<tr>
							<td align="right">送货时间：</td>
							<td>任何时候均配送</td>
							<td align="right">订单备注：</td>
							<td>${orderInfo.remark }</td>
						</tr>
						<tr>
							<td align="right">发票类型：</td>
							<td>发票以后再开</td>
							<td align="right">发票抬头：</td>
							<td>${orderInfo.invoiceType }</td>
						</tr>
						<tr>
							<td align="right">发票内容：</td>
							<td>未知</td>
							<td align="right">发票金额：</td>
							<td>￥450</td>
						</tr>
						<tr>
							<td align="right">运费金额：</td>
							<td>￥${orderInfo.freight_price }</td>
							<td align="right">订单总金额：</td>
							<td>￥${orderInfo.totalMoney }</td>
						</tr>
						<tr>
							<td align="right">满减金额：</td>
							<td>￥0.00</td>
							<td align="right">优惠券：</td>
							<td>￥0.00</td>
						</tr>
					</tbody>
				</table>
				<h3 class="h_h3">商品信息</h3>
				<table class="table_list_02" style="width: 100%;">
					<thead>
						<tr>
							<th>商品图片</th>
							<th>商品编号</th>
							<th>商品名称</th>
							<th>金额</th>
							<th>赠送积分</th>
							<th>商品数量</th>
							<th>小计</th>
						</tr>
					</thead>
					<tbody>
						<c:set var="sum" value="0"></c:set>
						<c:forEach items="${orderInfo.orderDetailInfos }" var="detail">
							<tr>
								<td>
									<a href="商品详情">
										<img width="50" height="50" src="${detail.productImage }">
									</a>
								</td>
								<td>${detail.pid }</td>
								<td>
									${detail.productName } &nbsp;&nbsp;&nbsp;
									<span style="color: red">规格：${detail.specification } 颜色：${detail.color }</span>
								</td>
								<td>
									￥${detail.soldPrice }
									<c:set var="sum" value="${sum+detail.soldPrice}"></c:set>
								</td>
								<td>${detail.giftPoints }</td>
								<td>${detail.quantity }</td>
								<td>￥${detail.totalMoney }</td>
							</tr>
						</c:forEach>
			
						<tr>
							<td class="bd_bottom" colspan="7">商品总金额：<span class="txt f16"><strong>￥${sum }</strong>元</span>
							</td>
						</tr>
					</tbody>
				</table>
				<h3 class="h_h3">拣货单信息</h3>
				<p class="mb10">
					订单号：<span style="color: #f00;font-size: 16px;"><strong>17032001366</strong></span>
				</p>
				<p>说明：拣货单以商品为单位，计算出该批订单中每种商品的总数量以及与订单的对应关系，以便您在仓库高效拣货。</p>
				<table class="table_list_02" style="width: 100%;">
					<thead>
						<tr>
							<th>货号</th>
							<th>商品名称</th>
							<th>商品数量</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${orderInfo.orderDetailInfos }" var="detail">
							<tr>
								<td>
									${detail.productNumber }
								</td>
								<td>
									${detail.productName }
								</td>
								<td>${detail.quantity }</td>
							</tr>
						</c:forEach>
			
					</tbody>
				</table>
			</div>
			
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10 margin-top30">
					<button id="stock" type="button" class="btn btn-success">出 库</button>
					<button id="return" type="button" class="btn btn-success">返 回</button>
				</div>
			</div>
			
		</div>
	</div>
</div>

<script>
	$(function(){
		var tab = $("#tab").html();
		
		$("#stock").on("click",function(){
			if(check_in()){
				layer.load(0, {
					shade : 0.3
				});
				$.post("expressorder/saveExpressOrder.json",$('#form').serialize(),function(data){
					layer.closeAll('loading');
					if (data.RESPONSE_STATE == '200') {
						layer.msg('出库成功', {
							icon : 1,
							time : 1 * 1000
						}, function() {
							$.post("orderInfo/goOrderInfoList.html",{state:2},function(data){
								$("#content").html(data);
							})
						});
					} else {
						layer.alert(data.ERROR_INFO, {
							icon : 0
						});
					}
				})
			}
			
		})
		
		$("#return").on("click",function(){
			$.post("orderInfo/goOrderInfoList.html",function(data){
				$("#content").html(data);
			})
		})
	})
	
	function check_in(){
		if ($('#expressNumber').val().trim() == '') {
			layer.tips('运单号不能为空！', '#expressNumber', {
				tips : [ 1, '#019F95' ],
				time : 1500
			});
			$('#expressNumber').focus();
			return false;
		}
		return true;
	}
</script>

