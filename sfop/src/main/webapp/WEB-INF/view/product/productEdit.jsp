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
						<form id="product" method="post" class="form-horizontal">
							   <div class="form-group">
									<label class="col-sm-2 control-label">店铺编号</label>
									<div class="col-sm-10">
										<input type="text" class="form-control" placeholder="店铺编号" id="shopid" name="shopid" v-bind:value="product!=null?product.shopid:''">
									</div>
								</div>
							<div class="hr-line-dashed"></div>
							   <div class="form-group">
									<label class="col-sm-2 control-label">品牌编号</label>
									<div class="col-sm-10">
										<input type="text" class="form-control" placeholder="品牌编号" id="brandid" name="brandid" v-bind:value="product!=null?product.brandid:''">
									</div>
								</div>
							<div class="hr-line-dashed"></div>
							   <div class="form-group">
									<label class="col-sm-2 control-label">分类属性编号</label>
									<div class="col-sm-10">
										<input type="text" class="form-control" placeholder="分类属性编号" id="pcid" name="pcid" v-bind:value="product!=null?product.pcid:''">
									</div>
								</div>
							<div class="hr-line-dashed"></div>
							   <div class="form-group">
									<label class="col-sm-2 control-label">商品名称</label>
									<div class="col-sm-10">
										<input type="text" class="form-control" placeholder="商品名称" id="name" name="name" v-bind:value="product!=null?product.name:''">
									</div>
								</div>
							<div class="hr-line-dashed"></div>
							   <div class="form-group">
									<label class="col-sm-2 control-label">店内推荐(1正常 2冻结)</label>
									<div class="col-sm-10">
										<input type="text" class="form-control" placeholder="店内推荐(1正常 2冻结)" id="recommend" name="recommend" v-bind:value="product!=null?product.recommend:''">
									</div>
								</div>
							<div class="hr-line-dashed"></div>
							   <div class="form-group">
									<label class="col-sm-2 control-label">包装清单</label>
									<div class="col-sm-10">
										<input type="text" class="form-control" placeholder="包装清单" id="listing" name="listing" v-bind:value="product!=null?product.listing:''">
									</div>
								</div>
							<div class="hr-line-dashed"></div>
							   <div class="form-group">
									<label class="col-sm-2 control-label">提交时间</label>
									<div class="col-sm-10">
										<input type="text" class="form-control" placeholder="提交时间" id="submit_time" name="submit_time" v-bind:value="product!=null?product.submit_time:''">
									</div>
								</div>
							<div class="hr-line-dashed"></div>
							   <div class="form-group">
									<label class="col-sm-2 control-label">商品参数</label>
									<div class="col-sm-10">
										<input type="text" class="form-control" placeholder="商品参数" id="parameter" name="parameter" v-bind:value="product!=null?product.parameter:''">
									</div>
								</div>
							<div class="hr-line-dashed"></div>
							   <div class="form-group">
									<label class="col-sm-2 control-label">商品状态(1在售2下架3删除)</label>
									<div class="col-sm-10">
										<input type="text" class="form-control" placeholder="商品状态(1在售2下架3删除)" id="state" name="state" v-bind:value="product!=null?product.state:''">
									</div>
								</div>
							<div class="hr-line-dashed"></div>
							   <div class="form-group">
									<label class="col-sm-2 control-label">售后服务</label>
									<div class="col-sm-10">
										<input type="text" class="form-control" placeholder="售后服务" id="after_service" name="after_service" v-bind:value="product!=null?product.after_service:''">
									</div>
								</div>
							<div class="hr-line-dashed"></div>
							   <div class="form-group">
									<label class="col-sm-2 control-label">排序</label>
									<div class="col-sm-10">
										<input type="text" class="form-control" placeholder="排序" id="rank" name="rank" v-bind:value="product!=null?product.rank:''">
									</div>
								</div>
							<div class="hr-line-dashed"></div>
							   <div class="form-group">
									<label class="col-sm-2 control-label">运费模板</label>
									<div class="col-sm-10">
										<input type="text" class="form-control" placeholder="运费模板" id="freight_master" name="freight_master" v-bind:value="product!=null?product.freight_master:''">
									</div>
								</div>
							<div class="hr-line-dashed"></div>
							   <div class="form-group">
									<label class="col-sm-2 control-label">副标题</label>
									<div class="col-sm-10">
										<input type="text" class="form-control" placeholder="副标题" id="goods_subtitle" name="goods_subtitle" v-bind:value="product!=null?product.goods_subtitle:''">
									</div>
								</div>
							<div class="hr-line-dashed"></div>
							   <div class="form-group">
									<label class="col-sm-2 control-label">商品主图</label>
									<div class="col-sm-10">
										<input type="text" class="form-control" placeholder="商品主图" id="logo" name="logo" v-bind:value="product!=null?product.logo:''">
									</div>
								</div>
							<div class="hr-line-dashed"></div>
							   <div class="form-group">
									<label class="col-sm-2 control-label">商品长度</label>
									<div class="col-sm-10">
										<input type="text" class="form-control" placeholder="商品长度" id="length" name="length" v-bind:value="product!=null?product.length:''">
									</div>
								</div>
							<div class="hr-line-dashed"></div>
							   <div class="form-group">
									<label class="col-sm-2 control-label">商品宽度</label>
									<div class="col-sm-10">
										<input type="text" class="form-control" placeholder="商品宽度" id="width" name="width" v-bind:value="product!=null?product.width:''">
									</div>
								</div>
							<div class="hr-line-dashed"></div>
							   <div class="form-group">
									<label class="col-sm-2 control-label">商品高度</label>
									<div class="col-sm-10">
										<input type="text" class="form-control" placeholder="商品高度" id="highly" name="highly" v-bind:value="product!=null?product.highly:''">
									</div>
								</div>
							<div class="hr-line-dashed"></div>
							   <div class="form-group">
									<label class="col-sm-2 control-label">是否支持7天退换货</label>
									<div class="col-sm-10">
										<input type="text" class="form-control" placeholder="是否支持7天退换货" id="is_seven_return" name="is_seven_return" v-bind:value="product!=null?product.is_seven_return:''">
									</div>
								</div>
							<div class="hr-line-dashed"></div>
							   <div class="form-group">
									<label class="col-sm-2 control-label">更新时间</label>
									<div class="col-sm-10">
										<input type="text" class="form-control" placeholder="更新时间" id="update_time" name="update_time" v-bind:value="product!=null?product.update_time:''">
									</div>
								</div>
							<div class="hr-line-dashed"></div>
							   <div class="form-group">
									<label class="col-sm-2 control-label">上架时间</label>
									<div class="col-sm-10">
										<input type="text" class="form-control" placeholder="上架时间" id="upshelf_time" name="upshelf_time" v-bind:value="product!=null?product.upshelf_time:''">
									</div>
								</div>
							<div class="hr-line-dashed"></div>
							   <div class="form-group">
									<label class="col-sm-2 control-label">下架时间</label>
									<div class="col-sm-10">
										<input type="text" class="form-control" placeholder="下架时间" id="downshelf_time" name="downshelf_time" v-bind:value="product!=null?product.downshelf_time:''">
									</div>
								</div>
							<div class="hr-line-dashed"></div>
							   <div class="form-group">
									<label class="col-sm-2 control-label">关键字</label>
									<div class="col-sm-10">
										<input type="text" class="form-control" placeholder="关键字" id="keywords" name="keywords" v-bind:value="product!=null?product.keywords:''">
									</div>
								</div>
							<div class="hr-line-dashed"></div>
							   <div class="form-group">
									<label class="col-sm-2 control-label">电脑描述</label>
									<div class="col-sm-10">
										<input type="text" class="form-control" placeholder="电脑描述" id="description" name="description" v-bind:value="product!=null?product.description:''">
									</div>
								</div>
							<div class="hr-line-dashed"></div>
							   <div class="form-group">
									<label class="col-sm-2 control-label">手机版描述</label>
									<div class="col-sm-10">
										<input type="text" class="form-control" placeholder="手机版描述" id="phone_describe" name="phone_describe" v-bind:value="product!=null?product.phone_describe:''">
									</div>
								</div>
							<div class="hr-line-dashed"></div>
							   <div class="form-group">
									<label class="col-sm-2 control-label">最后修改时间</label>
									<div class="col-sm-10">
										<input type="text" class="form-control" placeholder="最后修改时间" id="lasttime" name="lasttime" v-bind:value="product!=null?product.lasttime:''">
									</div>
								</div>
							<div class="hr-line-dashed"></div>
							   <div class="form-group">
									<label class="col-sm-2 control-label">最后修改人</label>
									<div class="col-sm-10">
										<input type="text" class="form-control" placeholder="最后修改人" id="updatename" name="updatename" v-bind:value="product!=null?product.updatename:''">
									</div>
								</div>
							<div class="hr-line-dashed"></div>
							   <div class="form-group">
									<label class="col-sm-2 control-label">备注</label>
									<div class="col-sm-10">
										<input type="text" class="form-control" placeholder="备注" id="remark" name="remark" v-bind:value="product!=null?product.remark:''">
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
			data : {product:null},
			mounted : function(){
				var _this = this;
				$.post("product/findProductById.json?id="+$("#id").val(),function(data){
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
						var url = "product/saveProduct.json";

						if ($("#id").val().trim()!=null&&$("#id").val().trim()!=''&&$("#id").val().trim()!='0') {
							url = "product/updateProduct.json";
						}
						$.post(url, $('#product').serialize(), function(data) {
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