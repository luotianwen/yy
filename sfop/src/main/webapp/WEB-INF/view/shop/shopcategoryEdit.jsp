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
						<input type="hidden" id="id" name="s_merchants_id" value="${id}"/>
						<form id="shopcategory" method="post" class="form-horizontal">
							   <div class="form-group">
									<label class="col-sm-2 control-label">类目id</label>
									<div class="col-sm-10">
										<input type="text" class="form-control" placeholder="类目id" id="c_category_id" name="c_category_id" v-bind:value="shopcategory!=null?shopcategory.c_category_id:''">
									</div>
								</div>
							<div class="hr-line-dashed"></div>
							   <div class="form-group">
									<label class="col-sm-2 control-label">类目名称</label>
									<div class="col-sm-10">
										<input type="text" class="form-control" placeholder="类目名称" id="categoryName" name="categoryName" v-bind:value="shopcategory!=null?shopcategory.categoryName:''">
									</div>
								</div>
							<div class="hr-line-dashed"></div>
							   <div class="form-group">
									<label class="col-sm-2 control-label">类目保证金标准（元）</label>
									<div class="col-sm-10">
										<input type="text" class="form-control" placeholder="类目保证金标准（元）" id="deposit" name="deposit" v-bind:value="shopcategory!=null?shopcategory.deposit:''">
									</div>
								</div>
							<div class="hr-line-dashed"></div>
							   <div class="form-group">
									<label class="col-sm-2 control-label">平台使用费</label>
									<div class="col-sm-10">
										<input type="text" class="form-control" placeholder="平台使用费" id="platformfee" name="platformfee" v-bind:value="shopcategory!=null?shopcategory.platformfee:''">
									</div>
								</div>
							<div class="hr-line-dashed"></div>
							   <div class="form-group">
									<label class="col-sm-2 control-label">扣点</label>
									<div class="col-sm-10">
										<input type="text" class="form-control" placeholder="扣点" id="points" name="points" v-bind:value="shopcategory!=null?shopcategory.points:''">
									</div>
								</div>
							<div class="hr-line-dashed"></div>
							   <div class="form-group">
									<label class="col-sm-2 control-label">代销店铺扣点</label>
									<div class="col-sm-10">
										<input type="text" class="form-control" placeholder="代销店铺扣点" id="consignmentpoints" name="consignmentpoints" v-bind:value="shopcategory!=null?shopcategory.consignmentpoints:''">
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
			data : {shopcategory:null},
			mounted : function(){
				var _this = this;
				$.post("shopcategory/findShopCategoryById.json?id="+$("#id").val(),function(data){
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
						var url = "shopcategory/saveShopCategory.json";

						if ($("#id").val().trim()!=null&&$("#id").val().trim()!=''&&$("#id").val().trim()!='0') {
							url = "shopcategory/updateShopCategory.json";
						}
						$.post(url, $('#shopcategory').serialize(), function(data) {
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