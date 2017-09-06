<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<style type="text/css">
	.btn_01 {
	    background: #88cd9c;
	    padding: 0 10px;
	    height: 26px;
	    line-height: 26px;
	    color: #fff;
	    display: inline-block;
	    font-size: 14px;
	}
	.fr {
	    float: right;
	    display: inline;
	}
	
</style>

<div class=" row">
	<div class="box col-md-12">
		<div class="box-inner">
			<div class="box-header well">
				<h2>
					<i class="glyphicon glyphicon-th"></i> 审核退换货单
				</h2>
			</div>
			<form class="form-inline" id="form" style="margin: 20px 0;">
				<input type="hidden" name="id" value="${orderInfoservice.id }" />
				<div class="c_step">
					<!-- <a class="cursor btn_01 fr" id="cus_cancel">客户放弃</a> -->
					<span>
						单据状态：<strong>等待审核</strong>
					</span>
				</div>
				
				<table border="0" cellspacing="0" cellpadding="0">
	                <tbody>
	                    <tr>
	                        <td align="right">客户期望：</td>
	                        <td>
	                        	<c:if test="${orderInfoservice.type==1 }">
									换货单
								</c:if>
								<c:if test="${orderInfoservice.type==2 }">
									退货单
								</c:if>
								<c:if test="${orderInfoservice.type==3 }">
									维修单
								</c:if>
	                        </td>
	                    </tr>
	                    <tr>
	                        <td align="right">订单号：</td>
	                        <td>
	                            <a target="blank" href="订单详情">
	                                ${orderInfoservice.orderId }
	                            </a>
	                        </td>
	                    </tr>
	                    <tr>
	                        <td align="right">商品信息：</td>
	                        <td>
	                        	<span style="width: 320px" class="item">
	                            <a target="blank" href="商品详情">${orderInfoservice.productName }</a>
	                            <span>${orderInfoservice.color } ${orderInfoservice.spec }</span></span>
	                        </td>
	                    </tr>
	                    <tr>
	                        <td align="right">客户信息：</td>
	                        <td><span style="width: 320px" class="item">姓名：${orderInfoservice.receiveName }</span><span style="width: 120px;" class="item">电话：${orderInfoservice.phone }</span></td>
	
	                    </tr>
	                    <tr>
	                        <td align="right">问题描述：</td>
	                        <td>${orderInfoservice.cnote }</td>
	                    </tr>
	                    <tr>
	                        <td align="right">用户照片：</td>
	                        <td>
	                        	<c:forEach items="${orderInfoServiceImgs }" var="item">
	                        		<img style="width: 50px;height: 50px;" src="${item.path }">
	                        	</c:forEach>
							</td>
	                    </tr>
	                    <tr>
	                        <td align="right">审核原因：</td>
	                        <td>
	                        	${orderInfoservice.creason }
							</td>
	                    </tr>
	                    <tr>
	                        <td align="right">发货地址：</td>
	                        <td>
	                            <select id="address" name="address">
	                            	<c:forEach items="${shippingaddresss }" var="item">
	                            		<option <c:if test="${item.isdefault==1 }">selected</c:if> value="${item.id }">${item.provinceName }${item.cityName }${item.regionName }${item.address }</option>
	                            	</c:forEach>
	                            </select>
							</td>
	                    </tr>
	                    <tr>
	                        <td align="right">审核备注：</td>
	                        <td><input id="note" name="note" type="text" value=""></td>
	                    </tr>
	                    <tr>
	                        <td align="right"></td>
	                        <td>
	                            <a id="agree_btn" class="btn_01 mr10 cursor">同意</a>
	                            <a id="disagree_btn" class="btn_01 cursor">审核不通过</a>
	                        </td>
	                    </tr>
	                </tbody>
	            </table>

			</form>
		</div>
		
	</div>
</div>

<script type="text/javascript">
	$(function(){
		$("#agree_btn").on("click",function(){
			layer.confirm("是否同意用户退换货?",{icon:3},function(index){
				layer.load(0, {
					shade : 0.3
				});
				$.post("orderInfoservice/updateOrderInfoService.json?state=3",$("#form").serialize(),function(data){
					layer.closeAll('loading');
					if (data.RESPONSE_STATE == '200') {
						layer.msg('保存成功', {
							icon : 1,
							time : 1 * 1000
						}, function() {
							$.post("orderInfoservice/goOrderInfoServiceList.html",{id:$(this).attr("data_id")},function(data){
								$("#content").html(data);
							})
						});
					} else {
						layer.alert(data.ERROR_INFO, {
							icon : 0
						});
					}
				})
			});
		})
		
		$("#disagree_btn").on("click",function(){
			layer.confirm("是否不同意用户退换货?",{icon:3},function(index){
				layer.load(0, {
					shade : 0.3
				});
				$.post("orderInfoservice/updateOrderInfoService.json?state=2",$("#form").serialize(),function(data){
					layer.closeAll('loading');
					if (data.RESPONSE_STATE == '200') {
						layer.msg('保存成功', {
							icon : 1,
							time : 1 * 1000
						}, function() {
							$.post("orderInfoservice/goOrderInfoServiceList.html",{id:$(this).attr("data_id")},function(data){
								$("#content").html(data);
							})
						});
					} else {
						layer.alert(data.ERROR_INFO, {
							icon : 0
						});
					}
				})
			});
		})
		
	})
</script>