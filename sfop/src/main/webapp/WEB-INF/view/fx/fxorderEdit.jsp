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
						<form id="fxorder" method="post" class="form-horizontal">
							<input type="hidden" id="id" name="orderid" value="${id}"/>
							   <div class="form-group">
									<label class="col-sm-2 control-label">分销结算状态</label>
									<div class="col-sm-10">
										<input type="text" class="form-control" placeholder="分销结算状态" id="state" name="state" v-bind:value="fxorder!=null?fxorder.state:''">
									</div>
								</div>
							<div class="hr-line-dashed"></div>
							   <div class="form-group">
									<label class="col-sm-2 control-label">佣金</label>
									<div class="col-sm-10">
										<input type="text" class="form-control" placeholder="佣金" id="commission" name="commission" v-bind:value="fxorder!=null?fxorder.commission:''">
									</div>
								</div>
							<div class="hr-line-dashed"></div>
							   <div class="form-group">
									<label class="col-sm-2 control-label">推荐用户id</label>
									<div class="col-sm-10">
										<input type="text" class="form-control" placeholder="推荐用户id" id="recommend_userid" name="recommend_userid" v-bind:value="fxorder!=null?fxorder.recommend_userid:''">
									</div>
								</div>
							<div class="hr-line-dashed"></div>
							   <div class="form-group">
									<label class="col-sm-2 control-label">被推荐用户id</label>
									<div class="col-sm-10">
										<input type="text" class="form-control" placeholder="被推荐用户id" id="recommended_userid" name="recommended_userid" v-bind:value="fxorder!=null?fxorder.recommended_userid:''">
									</div>
								</div>
							<div class="hr-line-dashed"></div>
							   <div class="form-group">
									<label class="col-sm-2 control-label">状态</label>
									<div class="col-sm-10">
										<input type="text" class="form-control" placeholder="状态" id="type" name="type" v-bind:value="fxorder!=null?fxorder.type:''">
									</div>
								</div>
							<div class="hr-line-dashed"></div>
							   <div class="form-group">
									<label class="col-sm-2 control-label">下单时间</label>
									<div class="col-sm-10">
										<input type="text" class="form-control" placeholder="下单时间" id="order_time" name="order_time" v-bind:value="fxorder!=null?fxorder.order_time:''">
									</div>
								</div>
							<div class="hr-line-dashed"></div>
							   <div class="form-group">
									<label class="col-sm-2 control-label">订单金额（支付金额）</label>
									<div class="col-sm-10">
										<input type="text" class="form-control" placeholder="订单金额（支付金额）" id="order_amount" name="order_amount" v-bind:value="fxorder!=null?fxorder.order_amount:''">
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
			data : {fxorder:null},
			mounted : function(){
				var _this = this;
				$.post("fxorder/findFxOrderById.json?id="+$("#id").val(),function(data){
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
						var url = "fxorder/saveFxOrder.json";

						if ($("#id").val().trim()!=null&&$("#id").val().trim()!=''&&$("#id").val().trim()!='0') {
							url = "fxorder/updateFxOrder.json";
						}
						$.post(url, $('#fxorder').serialize(), function(data) {
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