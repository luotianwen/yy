<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class=" row">
	<div class="box col-md-12">
		<div class="box-inner">
			<div class="box-header well">
				<h2>
					<i class="glyphicon glyphicon-th"></i> 服务单据管理
				</h2>
			</div>
			<form class="form-inline" id="form" style="margin: 20px 0;">
				<div class="col-sm-2 m-b-xs">
					<input placeholder="请输入退换货单号" name="id" class="input form-control">
				</div>
				<div class="col-sm-2 m-b-xs">
					<input type="text" placeholder="审核时间" id="lasttime" name="lasttime" readonly class="input form-control">
				</div>
				<div class="col-sm-2 m-b-xs">
					<input placeholder="请输入订 单 号" name="orderId" class="input form-control">
				</div>
				<div class="col-sm-2 m-b-xs">
					<input placeholder="请输入收货人电话/手机" name="orderId" class="input form-control">
				</div>
				
				<button id="search" type="button" class="btn btn-success">查 询</button>
				<div class="box-content">
					<div class="panel-options">
						<input type="hidden" id="state" name="state" value="1"/>
						<ul class="nav nav-tabs" id="tab">
	                        <li data_type="1" class="active cursor"><a>待审核</a></li>
	                        <li data_type="3" class="cursor"><a>填发运</a></li>
	                        <li data_type="4" class="cursor"><a>待收货/处理</a></li>
	                        <li data_type="7" class="cursor"><a>完成</a></li>
	                        <li data_type="8" class="cursor"><a>未解决</a></li>
	                        <li data_type="6" class="cursor"><a>已退款</a></li>
	                        <li data_type="2" class="cursor"><a>审核未通过</a></li>
	                        <li data_type="-1" class="cursor"><a>全部</a></li>
						</ul>
	                </div>
	                
	                <table class="table table-striped">
						<thead>
							<tr>
								<th>服务单号</th>
								<th>客户姓名/联系电话</th>
								<th>商品名称</th>
								<th>申请时间</th>
								<th>订单号</th>
								<th>状态</th>
								<th>类型</th>
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
		
	</div>
</div>

<div id="express_content" style="display:none;">
	<table>
		<tr>
			<td>物流公司：</td>
			<td>
				<select style="width: 177px" id="expressId" name="expressId">
					<c:forEach items="${expressconfig }" var="item">
						<option value="${item.id }">${item.name }</option>
					</c:forEach>
				</select>
			</td>
		</tr>
		<tr>
			<td>运单号：</td>
			<td>
				<input id="number" name="number"/>
			</td>
		</tr>
	</table>
	
	<div style="text-align: center;">
		<button id="express" type="button" class="btn btn-success">保 存</button>
	</div>
</div>

<script type="text/javascript">
	$(function(){
		$("#search").on("click",function(){
			$.post("orderInfoservice/findAllOrderInfoService.html",$("#form").serialize(),function(data){
				$("#orderList").html(data);
			})
		})
		
		$("#search").trigger("click");
		
		$("ul#tab").on("click","li",function(){
			if(!$(this).hasClass("active")){
				$("ul#tab").find("li").removeClass("active");
				$(this).addClass("active");
				$("#state").val($(this).attr("data_type"));
				
				$("#search").trigger("click");
			}
		})
		
		$("#express").on("click",function(){
			var _this = $("#express_content");
			var id = _this.attr("data_id");
			var type = _this.attr("data_type");
			layer.load(0, {
				shade : 0.3
			});
			$.post("orderInfoservice/shipments",{expressId:$("#expressId").val(),number:$("#number").val(),id:id,type:type},function(data){
				layer.closeAll();
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
		})
	})
</script>