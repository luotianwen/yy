<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class=" row">
	<div class="box col-md-12">
		<div class="box-inner">
			<div class="box-header well">
				<h2>
					<i class="glyphicon glyphicon-th"></i> 订单查询与追踪
				</h2>
			</div>
			<form class="form-inline" id="form" style="margin: 20px 0;">
				<div class="col-sm-2 m-b-xs">
					<input placeholder="请输入订单编号" name="orderId" class="input form-control">
				</div>
				<div class="col-sm-2 m-b-xs">
					<input type="text" placeholder="下单时间" id="subTime" name="subTime" readonly class="input form-control">
				</div>
				<div class="col-sm-2 m-b-xs">
					<input placeholder="请输入快递单号" name="expressNumber" class="input form-control">
				</div>
				<button id="search" type="button" class="btn btn-success">查 询</button>
				<div class="box-content">
					<div class="panel-options">
						<input type="hidden" id="orderStatus" name="orderStatus" value="${state}"/>
						<ul class="nav nav-tabs" id="tab">
	                        <li data_type="-1" class="<c:if test="${state==-1 }">active</c:if> cursor"><a>全部订单</a></li>
	                        <li data_type="0" class="<c:if test="${state==0 }">active</c:if> cursor"><a>未付款</a></li>
	                        <li data_type="1" class="<c:if test="${state==1 }">active</c:if> cursor"><a>等待出库</a></li>
	                        <li data_type="2" class="<c:if test="${state==2 }">active</c:if> cursor"><a>已出库</a></li>
	                        <li data_type="3" class="<c:if test="${state==3 }">active</c:if> cursor"><a>买家已收</a></li>
	                        <li data_type="4" class="<c:if test="${state==4 }">active</c:if> cursor"><a>已取消</a></li>
						</ul>
	                </div>
	                
	                <table class="table table-striped">
						<thead>
							<tr>
								<th>商品信息</th>
								<th>金额</th>
								<th>优惠金额</th>
								<th>当前状态</th>
								<th>物流公司</th>
								<th>买家用户名</th>
								<th>备注</th>
								<th>操作</th>
							</tr>
						</thead>
						<tbody id="orderList">
							
						</tbody>
					</table>
	                
	                <div id="page"></div>
				</div>
			</form>
		</div>
		
		<div id="sellerRemark_content" style="display:none;">
			<span>备注内容：</span>
			<span>
				<textarea id="sellerRemark_text" maxlength="100" style="resize:none; width: 300px; height: 130px;"></textarea>
			</span>
			<div>
				<button id="savesellerRemark" type="button" class="btn btn-success">保 存</button>
			</div>
		</div>
		
	</div>
</div>

<script type="text/javascript">
	$(function(){
		$("#search").on("click",function(){
			$.post("orderInfo/findAllOrderInfo.html",$("#form").serialize(),function(data){
				$("#orderList").html(data);
			})
		})
		
		$("#search").trigger("click");
		
		$("ul#tab").on("click","li",function(){
			if(!$(this).hasClass("active")){
				$("ul#tab").find("li").removeClass("active");
				$(this).addClass("active");
				$("#orderStatus").val($(this).attr("data_type"));
				
				$("#search").trigger("click");
			}
		})
		
		//备注
		$("table").on("click","tr td a#sellerRemark",function(){
			layer.open({
				type: 1,
				title : '备注信息',
				skin: 'layui-layer-rim', //加上边框
				area: ['420px', '240px'], //宽高
				content: $("#sellerRemark_content")
			});
			
			$("#sellerRemark_text").val($(this).attr("title"));
			$("#sellerRemark_content").attr("data_id",$(this).attr("data_id"));
		})
		
		$("#savesellerRemark").on("click",function(){
			var orderId = $("#sellerRemark_content").attr("data_id");
			if(orderId!=""){
				var sellerRemark = $("#sellerRemark_text").val();
				layer.load(0, {
					shade : 0.3
				});
				$.post("orderInfo/updateOrderInfoRemark.json",{orderId:orderId,sellerRemark:sellerRemark},function(data){
					layer.closeAll('loading');
					if (data.RESPONSE_STATE=='200') {
						layer.msg('修改成功', {
							icon : 1,
							time : 1 * 1000
						},function(){
							layer.closeAll();
							o_submit();
						});
					}else{
						layer.alert(data.ERROR_INFO, {
							icon : 0
						});
					}
				})
			}
		})
		
		//取消订单
		$("table").on("click","tr td a#cancel",function(){
			var id = $("#cancel").attr("data_id");
			layer.confirm("是否确认取消订单?",{icon:3},function(index){
				$.post("orderInfo/cancelOrder.json",{id:id},function(data){
					if (data.RESPONSE_STATE == '200') {
						layer.msg('取消成功', {
							icon : 1,
							time : 1 * 1000
						}, function() {
							$.post("orderInfo/goOrderInfoList.html",{state:4},function(data){
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
		
		//出库
		$("table").on("click","tr td a#stock",function(){
			var orderId = $(this).attr("data_id");
			$.post("orderInfo/goShipments.html",{orderId:orderId},function(data){
				$("#content").html(data);
			})
		})
		
		//查看详情
		$("table").on("click","tr td a#check",function(){
			var orderId = $(this).attr("data_id");
			$.post("orderInfo/orderDetail.html",{orderId:orderId},function(data){
				$("#content").html(data);
			})
		})
		
		//已退款
		$("table").on("click","tr td a#refund",function(){
			var orderId = $(this).attr("data_id");
			$.post("orderInfo/orderRefund.html",{orderId:orderId},function(data){
				if (data.RESPONSE_STATE=='200') {
					layer.msg('修改成功', {
						icon : 1,
						time : 1 * 1000
					}, function() {
						$.post("orderInfo/goOrderInfoList.html",{state:4},function(data){
							$("#content").html(data);
						})
					});
				}else{
					layer.alert(data.ERROR_INFO, {
						icon : 0
					});
				}
			})
		})
		
	})
</script>