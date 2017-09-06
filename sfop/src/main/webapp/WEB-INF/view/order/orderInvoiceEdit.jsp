<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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

</head>

<body class="gray-bg">
	<div class="wrapper wrapper-content animated fadeInRight" id="vue">
		<div class="row">
			<div id="user-box" class="col-sm-12">
				<div class="ibox">
					<div class="ibox-content">
						<input type="hidden" id="id" name="orderId" value="${id}"/>
						<form id="orderInvoice" method="post" class="form-horizontal">
							   <div class="form-group">
									<label class="col-sm-2 control-label">发票编号</label>
									<div class="col-sm-10">
										<input type="text" class="form-control" placeholder="发票编号" id="invoiceId" name="invoiceId" v-bind:value="orderInvoice!=null?orderInvoice.invoiceId:''">
									</div>
								</div>
							<div class="hr-line-dashed"></div>
							   <div class="form-group">
									<label class="col-sm-2 control-label">名称</label>
									<div class="col-sm-10">
										<input type="text" class="form-control" placeholder="名称" id="customerName" name="customerName" v-bind:value="orderInvoice!=null?orderInvoice.customerName:''">
									</div>
								</div>
							<div class="hr-line-dashed"></div>
							   <div class="form-group">
									<label class="col-sm-2 control-label">发票抬头</label>
									<div class="col-sm-10">
										<input type="text" class="form-control" placeholder="发票抬头" id="paymentsUnit" name="paymentsUnit" v-bind:value="orderInvoice!=null?orderInvoice.paymentsUnit:''">
									</div>
								</div>
							<div class="hr-line-dashed"></div>
							   <div class="form-group">
									<label class="col-sm-2 control-label">发票内容</label>
									<div class="col-sm-10">
										<input type="text" class="form-control" placeholder="发票内容" id="content" name="content" v-bind:value="orderInvoice!=null?orderInvoice.content:''">
									</div>
								</div>
							<div class="hr-line-dashed"></div>
							   <div class="form-group">
									<label class="col-sm-2 control-label">发票类型</label>
									<div class="col-sm-10">
										<input type="text" class="form-control" placeholder="发票类型" id="type" name="type" v-bind:value="orderInvoice!=null?orderInvoice.type:''">
									</div>
								</div>
							<div class="hr-line-dashed"></div>
							   <div class="form-group">
									<label class="col-sm-2 control-label">发票金额</label>
									<div class="col-sm-10">
										<input type="text" class="form-control" placeholder="发票金额" id="totalMoneyLower" name="totalMoneyLower" v-bind:value="orderInvoice!=null?orderInvoice.totalMoneyLower:''">
									</div>
								</div>
							<div class="hr-line-dashed"></div>
							   <div class="form-group">
									<label class="col-sm-2 control-label">开票人</label>
									<div class="col-sm-10">
										<input type="text" class="form-control" placeholder="开票人" id="drawer" name="drawer" v-bind:value="orderInvoice!=null?orderInvoice.drawer:''">
									</div>
								</div>
							<div class="hr-line-dashed"></div>
							   <div class="form-group">
									<label class="col-sm-2 control-label">时间</label>
									<div class="col-sm-10">
										<input type="text" class="form-control" placeholder="时间" id="subTime" name="subTime" v-bind:value="orderInvoice!=null?orderInvoice.subTime:''">
									</div>
								</div>
							<div class="hr-line-dashed"></div>
							   <div class="form-group">
									<label class="col-sm-2 control-label">备注</label>
									<div class="col-sm-10">
										<input type="text" class="form-control" placeholder="备注" id="remark" name="remark" v-bind:value="orderInvoice!=null?orderInvoice.remark:''">
									</div>
								</div>
							<div class="hr-line-dashed"></div>
							   <div class="form-group">
									<label class="col-sm-2 control-label">用户编号</label>
									<div class="col-sm-10">
										<input type="text" class="form-control" placeholder="用户编号" id="userId" name="userId" v-bind:value="orderInvoice!=null?orderInvoice.userId:''">
									</div>
								</div>
							<div class="hr-line-dashed"></div>
							   <div class="form-group">
									<label class="col-sm-2 control-label">邮寄地址</label>
									<div class="col-sm-10">
										<input type="text" class="form-control" placeholder="邮寄地址" id="postAddress" name="postAddress" v-bind:value="orderInvoice!=null?orderInvoice.postAddress:''">
									</div>
								</div>
							<div class="hr-line-dashed"></div>
							   <div class="form-group">
									<label class="col-sm-2 control-label">收件人姓名</label>
									<div class="col-sm-10">
										<input type="text" class="form-control" placeholder="收件人姓名" id="postName" name="postName" v-bind:value="orderInvoice!=null?orderInvoice.postName:''">
									</div>
								</div>
							<div class="hr-line-dashed"></div>
							   <div class="form-group">
									<label class="col-sm-2 control-label">收件人电话</label>
									<div class="col-sm-10">
										<input type="text" class="form-control" placeholder="收件人电话" id="postPhone" name="postPhone" v-bind:value="orderInvoice!=null?orderInvoice.postPhone:''">
									</div>
								</div>
							<div class="hr-line-dashed"></div>
							   <div class="form-group">
									<label class="col-sm-2 control-label">最后修改时间</label>
									<div class="col-sm-10">
										<input type="text" class="form-control" placeholder="最后修改时间" id="lasttime" name="lasttime" v-bind:value="orderInvoice!=null?orderInvoice.lasttime:''">
									</div>
								</div>
							<div class="hr-line-dashed"></div>
							   <div class="form-group">
									<label class="col-sm-2 control-label">最后修改人</label>
									<div class="col-sm-10">
										<input type="text" class="form-control" placeholder="最后修改人" id="updatename" name="updatename" v-bind:value="orderInvoice!=null?orderInvoice.updatename:''">
									</div>
								</div>
							<div class="hr-line-dashed"></div>
					      
							
					 
							
							<div class="form-group">
								<div class="col-sm-4 col-sm-offset-2">
									<a class="btn btn-primary" id="submit" @click="submit">保存内容</a>
									<a class="btn btn-white" id="cancel" onclick="parent.layer.close(parent.layer.getFrameIndex(window.name))">取消</a>
								</div>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- 全局js -->
	<script src="static/js/vue.js"></script>
	<script src="static/js/jquery-2.1.1.min.js"></script>
	<script src="static/js/bootstrap.min.js"></script>
	<script src="static/js/plugins/layer/layer.min.js"></script>
	<!-- iCheck -->
	<script src="static/js/plugins/iCheck/icheck.min.js"></script>
	
	<script type="text/javascript">
		new Vue({
			el : "#vue",
			data : {orderInvoice:null},
			mounted : function(){
				var _this = this;
				$.post("orderInvoice/findOrderInvoiceById.json?id="+$("#id").val(),function(data){
					for(var key in data){
						if(_this.key == undefined){
							Vue.set(_this.$data,key,data[key]);
						}else{
							_this.key = data[key];
						}
					}
				})
			},
			methods : {
				submit : function(){
					if (this.check_in()) {
						layer.load(0, {
							shade : 0.3
						});
						var url = "orderInvoice/saveOrderInvoice.json";

						if ($("#id").val().trim()!=null&&$("#id").val().trim()!=''&&$("#id").val().trim()!='0') {
							url = "orderInvoice/updateOrderInvoice.json";
						}
						$.post(url, $('#orderInvoice').serialize(), function(data) {
							if (data.RESPONSE_STATE == '200') {
								layer.msg('保存成功', {
									icon : 1,
									time : 1 * 1000
								}, function() {
									parent.self.location.reload();
								});
							} else {
								layer.closeAll('loading');
								layer.alert(data.ERROR_INFO, {
									icon : 0
								});
							}
						});
					}
				},
				check_in : function(){
					if ($('#id').val().trim() == '') {
						$("#id").val(0);
					}
					if ($('#name').val().trim() == '') {
						layer.tips('名称！！！', '#name', {
							tips : [ 1, '#019F95' ],
							time : 1500
						});
						$('#name').focus();
						return false;
					}
					
					return true;
				}
			}
		})
		
	</script>


</body>


</html>