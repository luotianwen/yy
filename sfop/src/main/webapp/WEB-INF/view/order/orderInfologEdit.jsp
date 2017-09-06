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
						<form id="orderInfolog" method="post" class="form-horizontal">
							<input type="hidden" id="id" name="log_id" value="${id}"/>
							   <div class="form-group">
									<label class="col-sm-2 control-label">订单id</label>
									<div class="col-sm-10">
										<input type="text" class="form-control" placeholder="订单id" id="order_id" name="order_id" v-bind:value="orderInfolog!=null?orderInfolog.order_id:''">
									</div>
								</div>
							<div class="hr-line-dashed"></div>
							   <div class="form-group">
									<label class="col-sm-2 control-label">操作时间</label>
									<div class="col-sm-10">
										<input type="text" class="form-control" placeholder="操作时间" id="create_time" name="create_time" v-bind:value="orderInfolog!=null?orderInfolog.create_time:''">
									</div>
								</div>
							<div class="hr-line-dashed"></div>
							   <div class="form-group">
									<label class="col-sm-2 control-label">日志内容</label>
									<div class="col-sm-10">
										<input type="text" class="form-control" placeholder="日志内容" id="log_content" name="log_content" v-bind:value="orderInfolog!=null?orderInfolog.log_content:''">
									</div>
								</div>
							<div class="hr-line-dashed"></div>
							   <div class="form-group">
									<label class="col-sm-2 control-label">操作人id</label>
									<div class="col-sm-10">
										<input type="text" class="form-control" placeholder="操作人id" id="create_user_id" name="create_user_id" v-bind:value="orderInfolog!=null?orderInfolog.create_user_id:''">
									</div>
								</div>
							<div class="hr-line-dashed"></div>
							   <div class="form-group">
									<label class="col-sm-2 control-label">操作人</label>
									<div class="col-sm-10">
										<input type="text" class="form-control" placeholder="操作人" id="create_user_name" name="create_user_name" v-bind:value="orderInfolog!=null?orderInfolog.create_user_name:''">
									</div>
								</div>
							<div class="hr-line-dashed"></div>
							   <div class="form-group">
									<label class="col-sm-2 control-label">日志级别（1：普通用户可看；2：系统用户（包含普通用户））</label>
									<div class="col-sm-10">
										<input type="text" class="form-control" placeholder="日志级别（1：普通用户可看；2：系统用户（包含普通用户））" id="log_level" name="log_level" v-bind:value="orderInfolog!=null?orderInfolog.log_level:''">
									</div>
								</div>
							<div class="hr-line-dashed"></div>
							   <div class="form-group">
									<label class="col-sm-2 control-label">修改后状态</label>
									<div class="col-sm-10">
										<input type="text" class="form-control" placeholder="修改后状态" id="after_status" name="after_status" v-bind:value="orderInfolog!=null?orderInfolog.after_status:''">
									</div>
								</div>
							<div class="hr-line-dashed"></div>
							   <div class="form-group">
									<label class="col-sm-2 control-label">修改前状态</label>
									<div class="col-sm-10">
										<input type="text" class="form-control" placeholder="修改前状态" id="before_status" name="before_status" v-bind:value="orderInfolog!=null?orderInfolog.before_status:''">
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
			data : {orderInfolog:null},
			mounted : function(){
				var _this = this;
				$.post("orderInfolog/findOrderInfoLogById.json?id="+$("#id").val(),function(data){
					for(var key in data){
						Vue.set(_this.$data,key,data[key]);
					}
				})
			},
			methods : {
				submit : function(){
					if (this.check_in()) {
						layer.load(0, {
							shade : 0.3
						});
						var url = "orderInfolog/saveOrderInfoLog.json";

						if ($("#id").val().trim()!=null&&$("#id").val().trim()!=''&&$("#id").val().trim()!='0') {
							url = "orderInfolog/updateOrderInfoLog.json";
						}
						$.post(url, $('#orderInfolog').serialize(), function(data) {
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