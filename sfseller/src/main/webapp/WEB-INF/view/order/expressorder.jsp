<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class=" row">
	<div class="box col-md-12">
		<div class="box-inner">
			<div class="box-header well">
				<h2>
					<i class="glyphicon glyphicon-th"></i> 快递单列表
				</h2>
			</div>
			<form class="form-inline" id="form" style="margin: 20px 0;">
				<div class="form-group">
					<label>订单编号</label>
					<input type="text" class="form-control" id="orderId" name="orderId">
				</div>
				<button id="search" type="button" class="btn btn-success">查 询</button>
			</form>
			<div class="box-content">
				<table class="table table-bordered">
					<thead>
						<tr>
							<th>订单编号</th>
							<th>商品名称</th>
							<th>物流公司</th>
							<th>快递单号</th>
							<th>支付方式</th>
							<th>操作</th>
						</tr>
					</thead>
					<tbody id="expressorderList">
					</tbody>
				</table>
			</div>
		</div>

	</div>
</div>

<script type="text/javascript">
	$(function(){
		$("#search").on("click",function(){
			$.post("expressorder/findExpressOrderByOid.html",$("#form").serialize(),function(data){
				$("#expressorderList").html(data);
			})
		})
		
		$("body").on("click","tr a#update",function(){
			var orderId = $(this).attr("data_id");
			var expressNumber = $(this).closest("tr").find("#expressNumber").val();
			var expressId = $(this).closest("tr").find("#expressId").val();
			if(expressNumber!=""){
				layer.load(0, {
					shade : 0.3
				});
				$.post("expressorder/updateExpressOrder.html",{orderId:orderId,expressNumber:expressNumber,expressId:expressId},function(data){
					layer.closeAll('loading');
					if (data.RESPONSE_STATE=='200') {
						layer.msg('修改成功', {
							icon : 1,
							time : 1 * 1000
						});
					}else{
						layer.alert(data.ERROR_INFO, {
							icon : 0
						});
					}
				})
			}
		})
	})
</script>