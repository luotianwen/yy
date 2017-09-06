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
					<form id="porderInfo" method="post">
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
														<th>父订单编号</th>
														<th>提交时间</th>
														<th>卖家编号</th>
														<th>用户编号</th>
														<th>买家姓名</th>
														<th>电话</th>
														<th>地址</th>
														<th>邮编</th>
														<th>积分</th>
														<th>发票抬头</th>
														<th>发票编号</th>
														<th>是否结算(1：是；2：否)</th>
														<th>结算时间</th>
														<th>用户确认收货时间</th>
														<th>订单状态</th>
														<th>订单类型</th>
														<th>备注</th>
														<th>最后修改时间</th>
														<th>默认支付方式</th>
														<th>卖家备注</th>
														<th>Ip</th>
														<th>支付码</th>
														<th>在线支付金额</th>
														<th>订单总金额.</th>
														<th>商家优惠金额</th>
														<th>订单货款金额（订单总金额-商家优惠金额）</th>
														<th>商品总金额</th>
														<th>用户应付金额</th>
														<th>商品的运费</th>
														<th>付款确认时间</th>
														<th>退款金额</th>
														<th>支付金额</th>
														<th>未支付金额</th>
														<th>操作</th>
													</tr>
												</thead>
												<tbody>
													<tr v-for="(porderInfo,index) in porderInfos">
														<td>{{porderInfo.perentId}}</td>
														<td>{{porderInfo.subTime}}</td>
														<td>{{porderInfo.sellerId}}</td>
														<td>{{porderInfo.userId}}</td>
														<td>{{porderInfo.receiveName}}</td>
														<td>{{porderInfo.phoneNumber}}</td>
														<td>{{porderInfo.address}}</td>
														<td>{{porderInfo.zipCode}}</td>
														<td>{{porderInfo.giftPoints}}</td>
														<td>{{porderInfo.invoiceType}}</td>
														<td>{{porderInfo.invoiceNumber}}</td>
														<td>{{porderInfo.isSettlement}}</td>
														<td>{{porderInfo.settlementTime}}</td>
														<td>{{porderInfo.userConfirmTime}}</td>
														<td>{{porderInfo.orderStatus}}</td>
														<td>{{porderInfo.orderType}}</td>
														<td>{{porderInfo.remark}}</td>
														<td>{{porderInfo.lastModifiedTime}}</td>
														<td>{{porderInfo.defaultPayment}}</td>
														<td>{{porderInfo.sellerRemark}}</td>
														<td>{{porderInfo.ip}}</td>
														<td>{{porderInfo.pay_serial_number}}</td>
														<td>{{porderInfo.onlinepayfee}}</td>
														<td>{{porderInfo.order_total_price}}</td>
														<td>{{porderInfo.seller_discount}}</td>
														<td>{{porderInfo.order_seller_price}}</td>
														<td>{{porderInfo.totalMoney}}</td>
														<td>{{porderInfo.order_payment}}</td>
														<td>{{porderInfo.freight_price}}</td>
														<td>{{porderInfo.payment_confirm_time}}</td>
														<td>{{porderInfo.refundMoney}}</td>
														<td>{{porderInfo.paidMoney}}</td>
														<td>{{porderInfo.unPaidMoney}}</td>
														<td>
															<button type="button" @click="edit(porderInfo.perentId)" class="btn btn-outline btn-primary">
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
			data : {page:null,porderInfos:null},
			mounted : function(){
				spage(1,"porderInfo/findAllPorderInfo.json",this,"page");
			},
			methods : {
				add : function(){
					layer.open({
						type : 2,
						title : "新增",
						shade : 0.2,
						area : [ "70%", "80%" ],
						content : "porderInfo/goPorderInfoEdit.html"
					});
				},
				edit : function(id){
					layer.open({
						type : 2,
						title : "编辑",
						shade : 0.2,
						area : [ "70%", "80%" ],
						content : "porderInfo/goPorderInfoEdit.html?id=" + id
					});
				},
				submit : function(){
					spage(1,"porderInfo/findAllPorderInfo.json",this,"page",$('#porderInfo').serialize());
				},
				del : function(index){
					var _this = this;
					var id = _this.porderInfos[index].id;
					
					layer.confirm("确认删除吗?", {
						shade : 0.3,
						btn : [ '确认', '取消' ],
						icon : 3
					}, function(layerIndex) {
						layer.close(layerIndex);
						$.post("porderInfo/deletePorderInfo.json",{id:id},function(data){
							if (data.RESPONSE_STATE == '200') {
								layer.msg('操作成功!', {icon : 1,time : 1 * 1000}, function() {
									_this.porderInfos.splice(index,1);
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