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
						<input type="hidden" id="id" name="id" value="${id}"/>
						<form id="paymentInfo" method="post" class="form-horizontal">
							   <div class="form-group">
									<label class="col-sm-2 control-label">支付码</label>
									<div class="col-sm-10">
										<input type="text" class="form-control" placeholder="支付码" id="pay_serial_number" name="pay_serial_number" v-bind:value="paymentInfo!=null?paymentInfo.pay_serial_number:''">
									</div>
								</div>
							<div class="hr-line-dashed"></div>
							   <div class="form-group">
									<label class="col-sm-2 control-label">支付方式</label>
									<div class="col-sm-10">
										<input type="text" class="form-control" placeholder="支付方式" id="paymentType" name="paymentType" v-bind:value="paymentInfo!=null?paymentInfo.paymentType:''">
									</div>
								</div>
							<div class="hr-line-dashed"></div>
							   <div class="form-group">
									<label class="col-sm-2 control-label">支付方式名称</label>
									<div class="col-sm-10">
										<input type="text" class="form-control" placeholder="支付方式名称" id="businessName" name="businessName" v-bind:value="paymentInfo!=null?paymentInfo.businessName:''">
									</div>
								</div>
							<div class="hr-line-dashed"></div>
							   <div class="form-group">
									<label class="col-sm-2 control-label">金额</label>
									<div class="col-sm-10">
										<input type="text" class="form-control" placeholder="金额" id="totalMoney" name="totalMoney" v-bind:value="paymentInfo!=null?paymentInfo.totalMoney:''">
									</div>
								</div>
							<div class="hr-line-dashed"></div>
							   <div class="form-group">
									<label class="col-sm-2 control-label">购买者编号</label>
									<div class="col-sm-10">
										<input type="text" class="form-control" placeholder="购买者编号" id="userId" name="userId" v-bind:value="paymentInfo!=null?paymentInfo.userId:''">
									</div>
								</div>
							<div class="hr-line-dashed"></div>
							   <div class="form-group">
									<label class="col-sm-2 control-label">支付流水号</label>
									<div class="col-sm-10">
										<input type="text" class="form-control" placeholder="支付流水号" id="tradeNo" name="tradeNo" v-bind:value="paymentInfo!=null?paymentInfo.tradeNo:''">
									</div>
								</div>
							<div class="hr-line-dashed"></div>
							   <div class="form-group">
									<label class="col-sm-2 control-label">支付时间</label>
									<div class="col-sm-10">
										<input type="text" class="form-control" placeholder="支付时间" id="notifyTime" name="notifyTime" v-bind:value="paymentInfo!=null?paymentInfo.notifyTime:''">
									</div>
								</div>
							<div class="hr-line-dashed"></div>
							   <div class="form-group">
									<label class="col-sm-2 control-label">提交时间</label>
									<div class="col-sm-10">
										<input type="text" class="form-control" placeholder="提交时间" id="subTime" name="subTime" v-bind:value="paymentInfo!=null?paymentInfo.subTime:''">
									</div>
								</div>
							<div class="hr-line-dashed"></div>
							   <div class="form-group">
									<label class="col-sm-2 control-label">支付状态</label>
									<div class="col-sm-10">
										<input type="text" class="form-control" placeholder="支付状态" id="tradeStatus" name="tradeStatus" v-bind:value="paymentInfo!=null?paymentInfo.tradeStatus:''">
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
			data : {paymentInfo:null},
			mounted : function(){
				var _this = this;
				$.post("paymentInfo/findPaymentInfoById.json?id="+$("#id").val(),function(data){
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
						var url = "paymentInfo/savePaymentInfo.json";

						if ($("#id").val().trim()!=null&&$("#id").val().trim()!=''&&$("#id").val().trim()!='0') {
							url = "paymentInfo/updatePaymentInfo.json";
						}
						$.post(url, $('#paymentInfo').serialize(), function(data) {
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