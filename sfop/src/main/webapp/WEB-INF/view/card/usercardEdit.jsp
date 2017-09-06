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
						<form id="usercard" method="post" class="form-horizontal">
							<input type="hidden" id="id" name="userid" value="${id}"/>
							   <div class="form-group">
									<label class="col-sm-2 control-label">世峰卡号</label>
									<div class="col-sm-10">
										<input type="text" class="form-control" placeholder="世峰卡号" id="cardnumber" name="cardnumber" v-bind:value="usercard!=null?usercard.cardnumber:''">
									</div>
								</div>
							<div class="hr-line-dashed"></div>
							   <div class="form-group">
									<label class="col-sm-2 control-label">余额</label>
									<div class="col-sm-10">
										<input type="text" class="form-control" placeholder="余额" id="money" name="money" v-bind:value="usercard!=null?usercard.money:''">
									</div>
								</div>
							<div class="hr-line-dashed"></div>
							   <div class="form-group">
									<label class="col-sm-2 control-label">最后更新时间</label>
									<div class="col-sm-10">
										<input type="text" class="form-control" placeholder="最后更新时间" id="lasttime" name="lasttime" v-bind:value="usercard!=null?usercard.lasttime:''">
									</div>
								</div>
							<div class="hr-line-dashed"></div>
							   <div class="form-group">
									<label class="col-sm-2 control-label">开始时间</label>
									<div class="col-sm-10">
										<input type="text" class="form-control" placeholder="开始时间" id="sdate" name="sdate" v-bind:value="usercard!=null?usercard.sdate:''">
									</div>
								</div>
							<div class="hr-line-dashed"></div>
							   <div class="form-group">
									<label class="col-sm-2 control-label">结束时间</label>
									<div class="col-sm-10">
										<input type="text" class="form-control" placeholder="结束时间" id="edate" name="edate" v-bind:value="usercard!=null?usercard.edate:''">
									</div>
								</div>
							<div class="hr-line-dashed"></div>
							   <div class="form-group">
									<label class="col-sm-2 control-label">状态（1未绑定2未使用3部分使用4已用完5已作废6已过期）</label>
									<div class="col-sm-10">
										<input type="text" class="form-control" placeholder="状态（1未绑定2未使用3部分使用4已用完5已作废6已过期）" id="status" name="status" v-bind:value="usercard!=null?usercard.status:''">
									</div>
								</div>
							<div class="hr-line-dashed"></div>
							   <div class="form-group">
									<label class="col-sm-2 control-label">用户绑定e卡时间</label>
									<div class="col-sm-10">
										<input type="text" class="form-control" placeholder="用户绑定e卡时间" id="bindingtime" name="bindingtime" v-bind:value="usercard!=null?usercard.bindingtime:''">
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
			data : {usercard:null},
			mounted : function(){
				var _this = this;
				$.post("usercard/findUserCardById.json?id="+$("#id").val(),function(data){
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
						var url = "usercard/saveUserCard.json";

						if ($("#id").val().trim()!=null&&$("#id").val().trim()!=''&&$("#id").val().trim()!='0') {
							url = "usercard/updateUserCard.json";
						}
						$.post(url, $('#usercard').serialize(), function(data) {
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