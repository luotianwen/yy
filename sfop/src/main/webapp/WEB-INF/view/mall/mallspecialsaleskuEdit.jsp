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
						<form id="mallspecialsalesku" method="post" class="form-horizontal">
							<input type="hidden" id="id" name="id" value="${id}"/>
							<input type="hidden" name="pid" value="${pid}">

							<div class="hr-line-dashed"></div>
							   <div class="form-group">
									<label class="col-sm-2 control-label">sku</label>
									<div class="col-sm-10">
										<input type="text" class="form-control" placeholder="sku" id="sku" name="sku" v-bind:value="mallspecialsalesku!=null?mallspecialsalesku.sku:''">
									</div>
								</div>
							<div class="hr-line-dashed"></div>
							   <div class="form-group">
									<label class="col-sm-2 control-label">序号</label>
									<div class="col-sm-10">
										<input type="text" class="form-control" placeholder="序号" id="sort" name="sort" v-bind:value="mallspecialsalesku!=null?mallspecialsalesku.sort:''">
									</div>
								</div>

							<div class="hr-line-dashed"></div>
							   <div class="form-group">
									<label class="col-sm-2 control-label">活动价</label>
									<div class="col-sm-10">
										<input type="text" class="form-control" placeholder="活动价" id="activityprice" name="activityprice" v-bind:value="mallspecialsalesku!=null?mallspecialsalesku.activityprice:''">
									</div>
								</div>
							<div class="hr-line-dashed"></div>
							   <div class="form-group">
									<label class="col-sm-2 control-label">活动数量</label>
									<div class="col-sm-10">
										<input type="text" class="form-control" placeholder="活动数量" id="activitystocks" name="activitystocks" v-bind:value="mallspecialsalesku!=null?mallspecialsalesku.activitystocks:''">
									</div>
								</div>
							<div class="hr-line-dashed"></div>
							   <div class="form-group">
									<label class="col-sm-2 control-label">折扣</label>
									<div class="col-sm-10">
										<input type="text" class="form-control" placeholder="折扣" id="discount" name="discount" v-bind:value="mallspecialsalesku!=null?mallspecialsalesku.discount:''">
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
			data : {mallspecialsalesku:null},
			mounted : function(){
				var _this = this;
				$.post("mallspecialsalesku/findMallSpecialSaleSkuById.json?id="+$("#id").val(),function(data){
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
						var url = "mallspecialsalesku/saveMallSpecialSaleSku.json";

						if ($("#id").val().trim()!=null&&$("#id").val().trim()!=''&&$("#id").val().trim()!='0') {
							url = "mallspecialsalesku/updateMallSpecialSaleSku.json";
						}
						$.post(url, $('#mallspecialsalesku').serialize(), function(data) {
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
					if ($('#sku').val().trim() == '') {
						layer.tips('sku！', '#sku', {
							tips : [ 1, '#019F95' ],
							time : 1500
						});
						$('#sku').focus();
						return false;
					}
					if ($('#activityprice').val().trim() == '') {
						layer.tips('活动价！', '#activityprice', {
							tips : [ 1, '#019F95' ],
							time : 1500
						});
						$('#activityprice').focus();
						return false;
					}
					if ($('#activitystocks').val().trim() == '') {
						layer.tips('活动数量', '#activitystocks', {
							tips : [ 1, '#019F95' ],
							time : 1500
						});
						$('#activitystocks').focus();
						return false;
					}
					if ($('#discount').val().trim() == '') {
						layer.tips('折扣！', '#discount', {
							tips : [ 1, '#019F95' ],
							time : 1500
						});
						$('#discount').focus();
						return false;
					}
					return true;
				}
			}
		})
		
	</script>


</body>


</html>