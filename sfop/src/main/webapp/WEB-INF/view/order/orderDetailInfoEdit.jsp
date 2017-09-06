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
						<form id="orderDetailInfo" method="post" class="form-horizontal">
							   <div class="form-group">
									<label class="col-sm-2 control-label">订单编号</label>
									<div class="col-sm-10">
										<input type="text" class="form-control" placeholder="订单编号" id="orderId" name="orderId" v-bind:value="orderDetailInfo!=null?orderDetailInfo.orderId:''">
									</div>
								</div>
							<div class="hr-line-dashed"></div>
							   <div class="form-group">
									<label class="col-sm-2 control-label">商品id</label>
									<div class="col-sm-10">
										<input type="text" class="form-control" placeholder="商品id" id="pid" name="pid" v-bind:value="orderDetailInfo!=null?orderDetailInfo.pid:''">
									</div>
								</div>
							<div class="hr-line-dashed"></div>
							   <div class="form-group">
									<label class="col-sm-2 control-label">Sku</label>
									<div class="col-sm-10">
										<input type="text" class="form-control" placeholder="Sku" id="productId" name="productId" v-bind:value="orderDetailInfo!=null?orderDetailInfo.productId:''">
									</div>
								</div>
							<div class="hr-line-dashed"></div>
							   <div class="form-group">
									<label class="col-sm-2 control-label">商品货号</label>
									<div class="col-sm-10">
										<input type="text" class="form-control" placeholder="商品货号" id="productNumber" name="productNumber" v-bind:value="orderDetailInfo!=null?orderDetailInfo.productNumber:''">
									</div>
								</div>
							<div class="hr-line-dashed"></div>
							   <div class="form-group">
									<label class="col-sm-2 control-label">商品名称</label>
									<div class="col-sm-10">
										<input type="text" class="form-control" placeholder="商品名称" id="productName" name="productName" v-bind:value="orderDetailInfo!=null?orderDetailInfo.productName:''">
									</div>
								</div>
							<div class="hr-line-dashed"></div>
							   <div class="form-group">
									<label class="col-sm-2 control-label">商品图片</label>
									<div class="col-sm-10">
										<input type="text" class="form-control" placeholder="商品图片" id="productImage" name="productImage" v-bind:value="orderDetailInfo!=null?orderDetailInfo.productImage:''">
									</div>
								</div>
							<div class="hr-line-dashed"></div>
							   <div class="form-group">
									<label class="col-sm-2 control-label">分类</label>
									<div class="col-sm-10">
										<input type="text" class="form-control" placeholder="分类" id="category" name="category" v-bind:value="orderDetailInfo!=null?orderDetailInfo.category:''">
									</div>
								</div>
							<div class="hr-line-dashed"></div>
							   <div class="form-group">
									<label class="col-sm-2 control-label">商品类型</label>
									<div class="col-sm-10">
										<input type="text" class="form-control" placeholder="商品类型" id="productType" name="productType" v-bind:value="orderDetailInfo!=null?orderDetailInfo.productType:''">
									</div>
								</div>
							<div class="hr-line-dashed"></div>
							   <div class="form-group">
									<label class="col-sm-2 control-label">积分</label>
									<div class="col-sm-10">
										<input type="text" class="form-control" placeholder="积分" id="giftPoints" name="giftPoints" v-bind:value="orderDetailInfo!=null?orderDetailInfo.giftPoints:''">
									</div>
								</div>
							<div class="hr-line-dashed"></div>
							   <div class="form-group">
									<label class="col-sm-2 control-label">商品状态</label>
									<div class="col-sm-10">
										<input type="text" class="form-control" placeholder="商品状态" id="productStatus" name="productStatus" v-bind:value="orderDetailInfo!=null?orderDetailInfo.productStatus:''">
									</div>
								</div>
							<div class="hr-line-dashed"></div>
							   <div class="form-group">
									<label class="col-sm-2 control-label">折扣</label>
									<div class="col-sm-10">
										<input type="text" class="form-control" placeholder="折扣" id="discount" name="discount" v-bind:value="orderDetailInfo!=null?orderDetailInfo.discount:''">
									</div>
								</div>
							<div class="hr-line-dashed"></div>
							   <div class="form-group">
									<label class="col-sm-2 control-label">市场价</label>
									<div class="col-sm-10">
										<input type="text" class="form-control" placeholder="市场价" id="initialPrice" name="initialPrice" v-bind:value="orderDetailInfo!=null?orderDetailInfo.initialPrice:''">
									</div>
								</div>
							<div class="hr-line-dashed"></div>
							   <div class="form-group">
									<label class="col-sm-2 control-label">销售价格</label>
									<div class="col-sm-10">
										<input type="text" class="form-control" placeholder="销售价格" id="soldPrice" name="soldPrice" v-bind:value="orderDetailInfo!=null?orderDetailInfo.soldPrice:''">
									</div>
								</div>
							<div class="hr-line-dashed"></div>
							   <div class="form-group">
									<label class="col-sm-2 control-label">购买数量</label>
									<div class="col-sm-10">
										<input type="text" class="form-control" placeholder="购买数量" id="quantity" name="quantity" v-bind:value="orderDetailInfo!=null?orderDetailInfo.quantity:''">
									</div>
								</div>
							<div class="hr-line-dashed"></div>
							   <div class="form-group">
									<label class="col-sm-2 control-label">总金额</label>
									<div class="col-sm-10">
										<input type="text" class="form-control" placeholder="总金额" id="totalMoney" name="totalMoney" v-bind:value="orderDetailInfo!=null?orderDetailInfo.totalMoney:''">
									</div>
								</div>
							<div class="hr-line-dashed"></div>
							   <div class="form-group">
									<label class="col-sm-2 control-label">颜色</label>
									<div class="col-sm-10">
										<input type="text" class="form-control" placeholder="颜色" id="color" name="color" v-bind:value="orderDetailInfo!=null?orderDetailInfo.color:''">
									</div>
								</div>
							<div class="hr-line-dashed"></div>
							   <div class="form-group">
									<label class="col-sm-2 control-label">规格</label>
									<div class="col-sm-10">
										<input type="text" class="form-control" placeholder="规格" id="specification" name="specification" v-bind:value="orderDetailInfo!=null?orderDetailInfo.specification:''">
									</div>
								</div>
							<div class="hr-line-dashed"></div>
							   <div class="form-group">
									<label class="col-sm-2 control-label">免运费(1：是；2：否)</label>
									<div class="col-sm-10">
										<input type="text" class="form-control" placeholder="免运费(1：是；2：否)" id="freeShipment" name="freeShipment" v-bind:value="orderDetailInfo!=null?orderDetailInfo.freeShipment:''">
									</div>
								</div>
							<div class="hr-line-dashed"></div>
							   <div class="form-group">
									<label class="col-sm-2 control-label">父订单号</label>
									<div class="col-sm-10">
										<input type="text" class="form-control" placeholder="父订单号" id="perentId" name="perentId" v-bind:value="orderDetailInfo!=null?orderDetailInfo.perentId:''">
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
			data : {orderDetailInfo:null},
			mounted : function(){
				var _this = this;
				$.post("orderDetailInfo/findOrderDetailInfoById.json?id="+$("#id").val(),function(data){
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
						var url = "orderDetailInfo/saveOrderDetailInfo.json";

						if ($("#id").val().trim()!=null&&$("#id").val().trim()!=''&&$("#id").val().trim()!='0') {
							url = "orderDetailInfo/updateOrderDetailInfo.json";
						}
						$.post(url, $('#orderDetailInfo').serialize(), function(data) {
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