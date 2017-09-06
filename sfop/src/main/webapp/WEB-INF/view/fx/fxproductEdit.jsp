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
						<form id="fxproduct" method="post" class="form-horizontal">
							<input type="hidden" id="sku2" name="sku2" v-bind:value="fxproduct!=null?fxproduct.sku2:''"/>
							<div class="form-group">
								<label class="col-sm-2 control-label">sku</label>
								<div class="col-sm-10">
									<input type="text" class="form-control" readonly placeholder="sku" id="sku" name="sku"  value="${sku}">
								</div>
							</div>
							   <div class="form-group">
									<label class="col-sm-2 control-label">商品名称</label>
									<div class="col-sm-10">
										<input type="text" class="form-control" readonly placeholder="商品名称" id="name" name="name" v-bind:value="fxproduct!=null?fxproduct.name:''">
									</div>
								</div>
							<div class="form-group">
								<label class="col-sm-2 control-label">款号/货号</label>
								<div class="col-sm-10">
									<input type="text" class="form-control" readonly placeholder="款号/货号" id="snumber" name="snumber" v-bind:value="fxproduct!=null?fxproduct.snumber:''">
								</div>
							</div>
							   <div class="form-group">
									<label class="col-sm-2 control-label">进货价</label>
									<div class="col-sm-10">
										<input v-on:blur="costpriceCount()"  type="number" class="form-control" placeholder="进货价" id="costprice" name="costprice" v-bind:value="fxproduct!=null?fxproduct.costprice:''">
									</div>
								</div>
							
							   <div class="form-group">
									<label class="col-sm-2 control-label">世峰价</label>
									<div class="col-sm-10">
										<input type="text" class="form-control" readonly placeholder="世峰价" id="price" name="price" v-bind:value="fxproduct!=null?fxproduct.price:''">
									</div>
								</div>
							
							   <div class="form-group">
									<label class="col-sm-2 control-label">毛利</label>
									<div class="col-sm-10">
										<input type="text" class="form-control" readonly placeholder="毛利" id="margin" name="margin" v-bind:value="fxproduct!=null?fxproduct.margin:''">
									</div>
								</div>
							
							   <div class="form-group">
									<label class="col-sm-2 control-label">毛利率</label>
									<div class="col-sm-10">
										<input type="text" class="form-control" readonly placeholder="毛利率" id="marginrate" name="marginrate" v-bind:value="fxproduct!=null?fxproduct.marginrate:''">
									</div>
								</div>

							   <div class="form-group">
									<label class="col-sm-2 control-label">分销率</label>
									<div class="col-sm-10">
										<input type="number" v-on:blur="costpriceCount()" class="form-control" placeholder="分销率" id="distributionrate" name="distributionrate" v-bind:value="fxproduct!=null?fxproduct.distributionrate:''">
									</div>
								</div>

							   <div class="form-group">
									<label class="col-sm-2 control-label">佣金</label>
									<div class="col-sm-10">
										<input type="text" class="form-control" readonly placeholder="佣金" id="commission" name="commission" v-bind:value="fxproduct!=null?fxproduct.commission:''">
									</div>
								</div>

							   <div class="form-group">
									<label class="col-sm-2 control-label">净毛利率</label>
									<div class="col-sm-10">
										<input type="text" class="form-control" readonly placeholder="净毛利率" id="lastmarginrate" name="lastmarginrate" v-bind:value="fxproduct!=null?fxproduct.lastmarginrate:''">
									</div>
								</div>

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
			data : {fxproduct:null},
			mounted : function(){
				var _this = this;
				$.post("fxproduct/findFxProductById.json?id="+$("#sku").val(),function(data){
					for(var key in data){
						Vue.set(_this.$data,key,data[key]);
					}
				})
			},
			methods : {
				costpriceCount:function () {
					var costprice=$('#costprice').val().trim();
					var price=$('#price').val().trim();
					$('#margin').val((price-costprice).toFixed(2));
					var margin=$('#margin').val().trim();
					$('#marginrate').val((margin/price).toFixed(2));
					var marginrate=$('#marginrate').val().trim();

					var distributionrate=$('#distributionrate').val().trim();
					$('#commission').val((distributionrate*price).toFixed(2));
					var commission=$('#commission').val().trim();
					$('#lastmarginrate').val((marginrate-distributionrate).toFixed(2));
					var lastmarginrate=$('#lastmarginrate').val().trim();
					if (Number(distributionrate)>=Number(marginrate)) {
						layer.tips('分销率要小于毛利率', '#distributionrate', {
							tips : [ 1, '#019F95' ],
							time : 1500
						});
						$('#distributionrate').focus();
						return false;
					}
				},
				submit : function(){
					if (this.check_in()) {
						layer.load(0, {
							shade : 0.3
						});
						var url = "fxproduct/saveFxProduct.json";
						$.post(url, $('#fxproduct').serialize(), function(data) {
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
					var costprice=$('#costprice').val().trim();
					var distributionrate=$('#distributionrate').val().trim();
					var marginrate=$('#marginrate').val().trim();
					if (costprice == '') {
						layer.tips('进货价必填', '#costprice', {
							tips : [ 1, '#019F95' ],
							time : 1500
						});
						$('#costprice').focus();
						return false;
					}
					if (Number(distributionrate)>=Number(marginrate)) {
						layer.tips('分销率要小于毛利率', '#distributionrate', {
							tips : [ 1, '#019F95' ],
							time : 1500
						});
						$('#distributionrate').focus();
						return false;
					}
					return true;
				}
			}
		})
		
	</script>


</body>


</html>