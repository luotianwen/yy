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
						<form id="sysadvset" method="post" class="form-horizontal">
							<input type="hidden" id="id" name="id" value="${id}"/>
							   <div class="form-group">
									<label class="col-sm-2 control-label">行</label>
									<div class="col-sm-10">
										<input type="text" class="form-control" placeholder="行" id="row" name="row" v-bind:value="sysadvset!=null?sysadvset.row:''">
									</div>
								</div>
							<div class="hr-line-dashed"></div>
							   <div class="form-group">
									<label class="col-sm-2 control-label">列</label>
									<div class="col-sm-10">
										<input type="text" class="form-control" placeholder="列" id="column" name="column" v-bind:value="sysadvset!=null?sysadvset.column:''">
									</div>
								</div>
							<div class="hr-line-dashed"></div>
							   <div class="form-group">
									<label class="col-sm-2 control-label">周</label>
									<div class="col-sm-10">
										<input type="text" class="form-control" placeholder="周" id="period" name="period" v-bind:value="sysadvset!=null?sysadvset.period:''">
									</div>
								</div>
							<div class="hr-line-dashed"></div>
							   <div class="form-group">
									<label class="col-sm-2 control-label">费用</label>
									<div class="col-sm-10">
										<input type="text" class="form-control" placeholder="费用" id="cost" name="cost" v-bind:value="sysadvset!=null?sysadvset.cost:''">
									</div>
								</div>
							<div class="hr-line-dashed"></div>
							   <div class="form-group">
									<label class="col-sm-2 control-label">创建时间</label>
									<div class="col-sm-10">
										<input type="text" class="form-control" placeholder="创建时间" id="cdate" name="cdate" v-bind:value="sysadvset!=null?sysadvset.cdate:''">
									</div>
								</div>
							<div class="hr-line-dashed"></div>
							   <div class="form-group">
									<label class="col-sm-2 control-label">最后修改人</label>
									<div class="col-sm-10">
										<input type="text" class="form-control" placeholder="最后修改人" id="updatename" name="updatename" v-bind:value="sysadvset!=null?sysadvset.updatename:''">
									</div>
								</div>
							<div class="hr-line-dashed"></div>
							   <div class="form-group">
									<label class="col-sm-2 control-label">最后修改时间</label>
									<div class="col-sm-10">
										<input type="text" class="form-control" placeholder="最后修改时间" id="lasttime" name="lasttime" v-bind:value="sysadvset!=null?sysadvset.lasttime:''">
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
			data : {sysadvset:null},
			mounted : function(){
				var _this = this;
				$.post("sysadvset/findSysAdvSetById.json?id="+$("#id").val(),function(data){
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
						var url = "sysadvset/saveSysAdvSet.json";

						if ($("#id").val().trim()!=null&&$("#id").val().trim()!=''&&$("#id").val().trim()!='0') {
							url = "sysadvset/updateSysAdvSet.json";
						}
						$.post(url, $('#sysadvset').serialize(), function(data) {
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