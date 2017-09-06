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
						<form id="fxsystemmargin" method="post" class="form-horizontal">
							<input type="hidden" id="id" name="id" value="${id}"/>
							   <div class="form-group">
									<label class="col-sm-2 control-label">开始毛利率</label>
									<div class="col-sm-10">
										<input type="number" class="form-control" placeholder="开始毛利率" id="smarginrate" name="smarginrate" v-bind:value="fxsystemmargin!=null?fxsystemmargin.smarginrate:''">
									</div>
								</div>
							<div class="hr-line-dashed"></div>
							   <div class="form-group">
									<label class="col-sm-2 control-label">结束毛利率</label>
									<div class="col-sm-10">
										<input type="number" class="form-control"  placeholder="结束毛利率" id="emarginrate" name="emarginrate" v-bind:value="fxsystemmargin!=null?fxsystemmargin.emarginrate:''">
									</div>
								</div>
							<div class="hr-line-dashed"></div>
							   <div class="form-group">
									<label class="col-sm-2 control-label">佣金比率</label>
									<div class="col-sm-10">
										<input type="number" class="form-control" placeholder="佣金比率" id="commissionrate" name="commissionrate" v-bind:value="fxsystemmargin!=null?fxsystemmargin.commissionrate:''">
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
			data : {fxsystemmargin:null},
			mounted : function(){
				var _this = this;
				$.post("fxsystemmargin/findFxSystemMarginById.json?id="+$("#id").val(),function(data){
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
						var url = "fxsystemmargin/saveFxSystemMargin.json";

						if ($("#id").val().trim()!=null&&$("#id").val().trim()!=''&&$("#id").val().trim()!='0') {
							url = "fxsystemmargin/updateFxSystemMargin.json";
						}
						$.post(url, $('#fxsystemmargin').serialize(), function(data) {
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
					var smarginrate=$('#smarginrate').val().trim();
					var emarginrate=$('#emarginrate').val().trim();
					var commissionrate=$('#commissionrate').val().trim();

					if (smarginrate == '') {
						layer.tips('开始毛利率', '#smarginrate', {
							tips : [ 1, '#019F95' ],
							time : 1500
						});
						$('#smarginrate').focus();
						return false;
					}
					if (emarginrate == '') {
						layer.tips('结束毛利率', '#emarginrate', {
							tips : [ 1, '#019F95' ],
							time : 1500
						});
						$('#emarginrate').focus();
						return false;
					}
					if (Number(smarginrate) >=Number(emarginrate)) {
						layer.tips('结束毛利率要比开始毛利率大', '#emarginrate', {
							tips : [ 1, '#019F95' ],
							time : 1500
						});
						$('#emarginrate').focus();
						return false;
					}
					if (commissionrate  == '') {
						layer.tips('佣金比率不能为空', '#commissionrate', {
							tips : [ 1, '#019F95' ],
							time : 1500
						});
						$('#commissionrate').focus();
						return false;
					}
					if (Number(commissionrate)>=Number(emarginrate)) {
						layer.tips('结束毛利率要比佣金比率大', '#commissionrate', {
							tips : [ 1, '#019F95' ],
							time : 1500
						});
						$('#commissionrate').focus();
						return false;
					}
					return true;
				}
			}
		})
		
	</script>


</body>


</html>