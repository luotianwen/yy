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
	
	<title>商城后台 - 管理</title>
	
	<link href="static/css/bootstrap.min.css" rel="stylesheet">
	<link href="static/css/font-awesome.min.css" rel="stylesheet">
	<!-- iCheck -->
	<link href="static/css/plugins/iCheck/custom.css" rel="stylesheet">
	<link href="static/css/animate.min.css" rel="stylesheet">
	<link href="static/css/style.min.css" rel="stylesheet">

</head>

<body class="gray-bg">
	<div class="wrapper wrapper-content  animated fadeInRight" id="vue">
		<div class="row">
			<div id="user-box" class="col-sm-12">
				<div class="ibox">
					<form id="orderDetailInfo" method="post">
						<div class="ibox-content">
							<h2>管理</h2>
							<div class="input-group">
								<div class="col-md-6">
									<input placeholder="名称" name="name" class="input form-control">
								</div>
								<div class="col-md-4">
									<button type="button" @click="submit" class="btn btn btn-primary">
										<i class="fa fa-search"></i> 搜索
									</button>
								</div>
							</div>
							
							<div class="hr-line-dashed"></div>
							<div class="tab-content">
								<div class="tab-pane active">
									<div class="full-height-scroll">
										<div class="table-responsive">
											<table class="table table-striped table-hover">
												<thead>
													<tr>
														<th>主键</th>
														<th>订单编号</th>
														<th>商品id</th>
														<th>Sku</th>
														<th>商品货号</th>
														<th>商品名称</th>
														<th>商品图片</th>
														<th>分类</th>
														<th>商品类型</th>
														<th>积分</th>
														<th>商品状态</th>
														<th>折扣</th>
														<th>市场价</th>
														<th>销售价格</th>
														<th>购买数量</th>
														<th>总金额</th>
														<th>颜色</th>
														<th>规格</th>
														<th>免运费(1：是；2：否)</th>
														<th>父订单号</th>
														<th>操作</th>
													</tr>
												</thead>
												<tbody>
													<tr v-for="(orderDetailInfo,index) in orderDetailInfos">
														<td>{{orderDetailInfo.id}}</td>
														<td>{{orderDetailInfo.orderId}}</td>
														<td>{{orderDetailInfo.pid}}</td>
														<td>{{orderDetailInfo.productId}}</td>
														<td>{{orderDetailInfo.productNumber}}</td>
														<td>{{orderDetailInfo.productName}}</td>
														<td>{{orderDetailInfo.productImage}}</td>
														<td>{{orderDetailInfo.category}}</td>
														<td>{{orderDetailInfo.productType}}</td>
														<td>{{orderDetailInfo.giftPoints}}</td>
														<td>{{orderDetailInfo.productStatus}}</td>
														<td>{{orderDetailInfo.discount}}</td>
														<td>{{orderDetailInfo.initialPrice}}</td>
														<td>{{orderDetailInfo.soldPrice}}</td>
														<td>{{orderDetailInfo.quantity}}</td>
														<td>{{orderDetailInfo.totalMoney}}</td>
														<td>{{orderDetailInfo.color}}</td>
														<td>{{orderDetailInfo.specification}}</td>
														<td>{{orderDetailInfo.freeShipment}}</td>
														<td>{{orderDetailInfo.perentId}}</td>
														<td>
															<button type="button" @click="edit(orderDetailInfo.id)" class="btn btn-outline btn-primary">
																<i class="fa fa-paste"></i> 编辑
															</button>
															<button type="button" @click="del(index)" class="btn btn-outline btn-danger">
																<i class="fa fa-trash"></i> 删除
															</button>
														</td>
													</tr>
												</tbody>
											</table>
										</div>
									</div>

									<div class="ibox-content">
										<p>
											<button type="button" id="add" @click="add" class="btn btn-sm btn-primary">
												<i class="fa fa-plus"></i> 添加
											</button>
										</p>
									</div>

									<div class="hr-line-dashed"></div>
									<div class="text-center" id="page"></div>
								</div>

							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>

	<!-- 全局js -->
	<script src="static/js/vue.js"></script>
	<script src="static/js/jquery-2.1.1.min.js"></script>
	<script src="static/js/bootstrap.min.js"></script>
	<script src="static/js/plugins/layer/layer.min.js"></script>
	<script src="static/js/plugins/layer/laypage/laypage.js"></script>
	<script src="static/js/plugins/slimscroll/jquery.slimscroll.min.js"></script>

	<!-- iCheck -->
	<script src="static/js/plugins/iCheck/icheck.min.js"></script>
	
	<script type="text/javascript">
		new Vue({
			el : "#vue",
			data : {page:null,orderDetailInfos:null},
			mounted : function(){
				spage(1,"orderDetailInfo/findAllOrderDetailInfo.json",this,"page");
			},
			methods : {
				add : function(){
					layer.open({
						type : 2,
						title : "新增",
						shade : 0.2,
						area : [ "70%", "80%" ],
						content : "orderDetailInfo/goOrderDetailInfoEdit.html"
					});
				},
				edit : function(id){
					layer.open({
						type : 2,
						title : "编辑",
						shade : 0.2,
						area : [ "70%", "80%" ],
						content : "orderDetailInfo/goOrderDetailInfoEdit.html?id=" + id
					});
				},
				submit : function(){
					spage(1,"orderDetailInfo/findAllOrderDetailInfo.json",this,"page",$('#orderDetailInfo').serialize());
				},
				del : function(index){
					var _this = this;
					var id = _this.orderDetailInfos[index].id;
					
					layer.confirm("确认删除吗?", {
						shade : 0.3,
						btn : [ '确认', '取消' ],
						icon : 3
					}, function(layerIndex) {
						layer.close(layerIndex);
						$.post("orderDetailInfo/deleteOrderDetailInfo.json",{id:id},function(data){
							if (data.RESPONSE_STATE == '200') {
								layer.msg('操作成功!', {icon : 1,time : 1 * 1000}, function() {
									_this.orderDetailInfos.splice(index,1);
								})
							}else{
								layer.closeAll('loading');
								layer.alert(data.ERROR_INFO, {
									icon : 0
								});
							}
						})
					})
				}
			}
		})
	
		$(function() {
			$(".full-height-scroll").slimScroll({
				height : "100%"
			});

			//设置本页layer皮肤
			layer.config({
				skin : 'layui-layer-molv',
			});
		});
	</script>


</body>


</html>