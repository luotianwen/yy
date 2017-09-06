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
					<form id="shopinfopay" method="post">
						<div class="ibox-content">

							<div class="input-group">
								<div class="col-md-4">
									<input placeholder="公司名称" name="name" class="input form-control">
								</div>
								<div class="col-md-4">
									<input placeholder="店铺名称" name="shopname" class="input form-control">
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
														<th>公司名称</th>
														<th>店铺名称</th>
														<th>订单id</th>
														<%--<th>支付码</th>--%>
														<th>支付金额</th>
														<th>说明</th>
														<th>状态</th>
														<th>提交时间</th>
														<th>备注</th>
														<th>最后修改时间</th>
														<th>最后修改人</th>
														<th>操作</th>
													</tr>
												</thead>
												<tbody>
													<tr v-for="(shopinfopay,index) in shopinfopays">
														<td>{{shopinfopay.name}}</td>
														<td>{{shopinfopay.shopname}}</td>
														<td>{{shopinfopay.orderId}}</td>
														<%--<td>{{shopinfopay.pay_serial_number}}</td>--%>
														<td>{{shopinfopay.payAmount}}</td>
														<td>{{shopinfopay.note}}</td>
														<td>
															<span v-if="shopinfopay.status==0" style="color:red;">等待支付</span>
															<span v-if="shopinfopay.status==1">已支付</span>
														</td>
														<td>{{shopinfopay.subTime}}</td>
														<td :title="shopinfopay.remark">{{shopinfopay.remark}}</td>
														<td>{{shopinfopay.lasttime}}</td>
														<td>{{shopinfopay.updatename}}</td>
														<td>
															<button type="button" v-if="shopinfopay.status==0" @click="edit(shopinfopay.orderId)" class="btn btn-outline btn-primary">
																<i class="fa fa-paste"></i> 编辑
															</button>
														</td>
													</tr>
												</tbody>
											</table>
										</div>
									</div>

									<%--<div class="ibox-content">
										<p>
											<button type="button" id="add" @click="add" class="btn btn-sm btn-primary">
												<i class="fa fa-plus"></i> 添加
											</button>
										</p>
									</div>--%>

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
			data : {page:null,shopinfopays:null},
			mounted : function(){
				spage(1,"shopinfopay/findAllShopinfoPay.json",this,"page");
			},
			methods : {
				add : function(){
					layer.open({
						type : 2,
						title : "新增",
						shade : 0.2,
						area : [ "70%", "80%" ],
						content : "shopinfopay/goShopinfoPayEdit.html"
					});
				},
				edit : function(id){
					layer.open({
						type : 2,
						title : "编辑",
						shade : 0.2,
						area : [ "70%", "80%" ],
						content : "shopinfopay/goShopinfoPayEdit.html?id=" + id
					});
				},
				submit : function(){
					spage(1,"shopinfopay/findAllShopinfoPay.json",this,"page",$('#shopinfopay').serialize());
				},
				del : function(index){
					var _this = this;
					var id = _this.shopinfopays[index].id;
					
					layer.confirm("确认删除吗?", {
						shade : 0.3,
						btn : [ '确认', '取消' ],
						icon : 3
					}, function(layerIndex) {
						layer.close(layerIndex);
						$.post("shopinfopay/deleteShopinfoPay.json",{id:id},function(data){
							if (data.RESPONSE_STATE == '200') {
								layer.msg('操作成功!', {icon : 1,time : 1 * 1000}, function() {
									_this.shopinfopays.splice(index,1);
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