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
	
	<title>编辑导航信息</title>
	
	<link href="static/css/bootstrap.min.css" rel="stylesheet">
	<link href="static/css/animate.min.css" rel="stylesheet">
	<link href="static/css/style.min.css" rel="stylesheet">
	<link href="static/css/layerdate/layerdate.css" rel="stylesheet">
	<!-- iCheck -->
	<link href="static/css/plugins/iCheck/custom.css" rel="stylesheet">

</head>

<body class="gray-bg">
	<div class="wrapper wrapper-content animated fadeInRight">
		<div class="row">
			<div id="user-box" class="col-sm-12">
				<div class="ibox">
					<div class="ibox-content" id="vue">
						<form id="navigation" method="post" class="form-horizontal">
							<input type="hidden" id="id" name="id" value="${id}"/>
							
							   <div class="form-group">
									<label class="col-sm-2 control-label">名称</label>
									<div class="col-sm-10">
										<input type="text" class="form-control" placeholder="名称" id="name" name="name" :value="navigation!=null?navigation.name:''">
									</div>
								</div>
							<div class="hr-line-dashed"></div>
							   <div class="form-group">
									<label class="col-sm-2 control-label">url链接路径</label>
									<div class="col-sm-10">
										<input type="text" class="form-control" placeholder="url链接路径" id="url" name="url" :value="navigation!=null?navigation.url:''">
									</div>
								</div>
							<div class="hr-line-dashed"></div>
							   
							   <div class="form-group">
									<label class="col-sm-2 control-label">排序</label>
									<div class="col-sm-10">
										<input type="text" class="form-control" placeholder="排序" id="sort" name="sort" :value="navigation!=null?navigation.sort:''">
									</div>
								</div>
							<div class="hr-line-dashed"></div>
							   <div class="form-group">
									<label class="col-sm-2 control-label">备注</label>
									<div class="col-sm-10">
										<input type="text" class="form-control" placeholder="备注" id="remark" name="remark" :value="navigation!=null?navigation.remark:''">
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
			data : {navigation:null},
			mounted : function(){
				var _this = this;
				$.post("navigation/findNavigationById.json?id="+$("#id").val(),function(data){
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
						var url = "navigation/saveNavigation.json";

						if ($("#id").val().trim()!=null && $("#id").val().trim()!='' && $("#id").val().trim()!='0') {
							url = "navigation/updateNavigation.json";
						}
						$.post(url, $('#navigation').serialize(), function(data) {
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
					if($("#id").val().trim()==''){
						$("#id").val(0);
					}
					if ($('#name').val().trim() == '') {
						layer.tips('名称不能为空！！！', '#name', {
							tips : [ 1, '#019F95' ],
							time : 1500
						});
						$('#name').focus();
						return false;
					}
					if ($('#url').val().trim() == '') {
						layer.tips('url链接路径不能为空！！！', '#url', {
							tips : [ 1, '#019F95' ],
							time : 1500
						});
						$('#url').focus();
						return false;
					}
					if ($('#sort').val().trim() == '') {
						$('#sort').val("0");
					}
					
					return true;
				}
			}
		})
		
	</script>


</body>


</html>