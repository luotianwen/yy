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
	<link href="static/css/layerdate/layerdate.css" rel="stylesheet">

</head>

<body class="gray-bg">
	<div class="wrapper wrapper-content  animated fadeInRight" id="vue">
		<div class="row">
			<div id="user-box" class="col-sm-12">
				<div class="ibox">
					<form id="orderInfo" method="post">
						<div class="ibox-content">
							<h2>管理</h2>
							<div class="row">
								<div class="col-sm-2 m-b-xs">
									<input placeholder="请输入订单编号" name="orderId" class="input form-control">
								</div>
								<div class="col-sm-2 m-b-xs">
									<input type="text" placeholder="下单时间" id="subTime" name="subTime" readonly class="input form-control">
								</div>
								<div class="col-sm-2 m-b-xs">
									<input placeholder="请输入快递单号" name="expressNumber" class="input form-control">
								</div>
								
								<div class="col-md-4">
									<button type="button" @click="submit" class="btn btn btn-primary">
										<i class="fa fa-search"></i> 搜索
									</button>
								</div>
							</div>
							
							<div class="hr-line-dashed"></div>
							
							<div class="panel-options">
								<input type="hidden" id="orderStatus" name="orderStatus" value="1"/>
		                        <ul class="nav nav-tabs">
		                            <li :class="orderStatus=='-1'?'active':''" @click="changeStatus(-1)"><a>全部订单</a></li>
		                            <li :class="orderStatus=='0'?'active':''" @click="changeStatus(0)"><a>未付款</a></li>
		                            <li :class="orderStatus=='1'?'active':''" @click="changeStatus(1)"><a>等待出库</a></li>
		                            <li :class="orderStatus=='2'?'active':''" @click="changeStatus(2)"><a>已出库</a></li>
		                            <li :class="orderStatus=='3'?'active':''" @click="changeStatus(3)"><a>买家已收</a></li>
		                            <li :class="orderStatus=='4'?'active':''" @click="changeStatus(4)"><a>已取消</a></li>
		                        </ul>
		                    </div>
							
							<div class="tab-content">
								<div class="tab-pane active">
									<div class="full-height-scroll">
										<div class="table-responsive">
											<table class="table table-striped">
												<thead>
													<tr>
														<th>商品信息</th>
														<th>金额</th>
														<th>优惠金额</th>
														<th>当前状态</th>
														<th>物流公司</th>
														<th>买家用户名</th>
														<th>备注</th>
														<th>操作</th>
													</tr>
												</thead>
												<tbody v-for="(orderInfo,index) in orderInfos">
													<tr class="head">
														<td colspan="8">
															<span style="margin-right: 20px;">
																订单编号： {{orderInfo.perentId}}&nbsp;
															</span>
															<span style="margin-right: 20px;">货款金额： ￥{{orderInfo.totalMoney}}</span>
															<span style="margin-right: 20px;">下单时间：{{orderInfo.subTime}}</span>
															<span style="margin-right: 20px;" v-if="orderInfo.payment_confirm_time!=null&&orderInfo.payment_confirm_time!=''">付款时间：{{orderInfo.payment_confirm_time}}</span>
															<span style="margin-right: 20px;" v-if="orderInfo.userConfirmTime!=null&&orderInfo.userConfirmTime!=''">确认时间：{{orderInfo.userConfirmTime}}</span>
														</td>
													</tr>
													<tr class="content">
														<td>
															<div style="overflow: hidden;" v-for="detail in orderInfo.orderDetailInfos">
																<div style="width: 50px; height: 50px; float: left;">
																	<a :href="'http://www.seebong.com/detail/'+detail.sku+'.html'" target="_blank">
																		<img width="50" height="50" :src="detail.productImage">
																	</a>
																</div>
																<div style="margin-top: 7px;">
																	<a :title="detail.productName" :href="'http://www.seebong.com/detail/'+detail.sku+'.html'" target="_blank">
																		{{detail.productName}}
																	</a>
																</div>
																<div>
																	<span>商品数量:{{detail.quantity}}</span><span>货号:{{detail.productNumber}}</span>
																</div>
															</div>
														</td>
														<td>
															<div>商品金额: ￥{{orderInfo.order_seller_price}}</div>
															<div v-if="orderInfo.freight_price>0">运费金额:￥{{orderInfo.freight_price }}</div>
															<div>总金额: ￥{{orderInfo.order_payment}}</div>
														</td>
														<td>
															<span v-if="orderInfo.porderInfodiscounts==null">无优惠信息</span>
															<span v-else v-for="porderInfodiscount in orderInfo.porderInfodiscounts">
																<span v-if="porderInfodiscount.type==1">优惠券：</span>
																<span v-else-if="porderInfodiscount.type==2">世峰e卡：</span>
																{{porderInfodiscount.discountMoney}}元<br/>
															</span>
														</td>
														<td>
															<span v-if="orderInfo.orderStatus==0">等待付款</span>
															<span v-else-if="orderInfo.orderStatus==1">等待发货</span>
															<span v-else-if="orderInfo.orderStatus==2">等待收货</span>
															<span v-else-if="orderInfo.orderStatus==3">交易成功</span>
															<span v-else-if="orderInfo.orderStatus==4">取消订单</span>
															<span v-else-if="orderInfo.orderStatus==5">交易关闭</span>
															<span v-else-if="orderInfo.orderStatus==6">退货中</span>
															<span v-else-if="orderInfo.orderStatus==7">退款中</span>
														</td>
														<td>
															<span v-if="orderInfo.expressName==null">暂无信息</span>
															<span v-else>快递名:{{orderInfo.expressName}}<br>快递编号:{{orderInfo.expressNumber}}</span>
														</td>
														<td>{{orderInfo.receiveName}}</td>
														<td style="word-wrap: break-word; word-break: break-all;">
															{{orderInfo.remark}}
														</td>
														<td>
															<a target="_blank" :href="'http://www.seebong.com/shop/'+orderInfo.sellerId+'.html'" title="进入店铺">
																<i class="fa fa-exchange"></i>
															</a>
															<a @click="detail(orderInfo.orderId)" title="查看详情">
																<i class="fa fa-eye"></i>
															</a>
															<a v-if="orderInfo.orderStatus==7" @click="refund(orderInfo.orderId)">
																<i class="fa fa-edit"></i>已退款
															</a>
														</td>
													</tr>
												</tbody>
											</table>
										</div>
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
	<script src="static/js/plugins/layer/laydate/laydate.js"></script>
	<script src="static/js/plugins/slimscroll/jquery.slimscroll.min.js"></script>

	<!-- iCheck -->
	<script src="static/js/plugins/iCheck/icheck.min.js"></script>
	
	<script type="text/javascript">
		new Vue({
			el : "#vue",
			data : {page:null,orderInfos:null,orderStatus:1},
			mounted : function(){
				spage(1,"orderInfo/findAllOrderInfo.json",this,"page",$('#orderInfo').serialize());
				this.dateinit();
			},
			methods : {
				dateinit : function(){
					var subTime = {
			   			elem : '#subTime',
			   			format : 'YYYY-MM-DD',
			   			istoday : false
			   		};
			   		laydate(subTime);
				},
				detail : function(id){
					layer.open({
						type : 2,
						title : "详情",
						shade : 0.2,
						area : [ "100%", "100%" ],
						content : "orderInfo/goOrderInfoEdit.html?id=" + id
					});
				},
				refund : function(){
					var _this = this;
					layer.confirm("确认已退款吗?", {
						shade : 0.3,
						btn : [ '确认', '取消' ],
						icon : 3
					}, function(layerIndex) {
						layer.close(layerIndex);
						$.post("orderInfo/orderRefund.json",{id:id},function(data){
							if (data.RESPONSE_STATE == '200') {
								layer.msg('操作成功!', {icon : 1,time : 1 * 1000}, function() {
									_this.submit();
								})
							}else{
								layer.closeAll('loading');
								layer.alert(data.ERROR_INFO, {
									icon : 0
								});
							}
						})
					})
				},
				submit : function(){
					spage(1,"orderInfo/findAllOrderInfo.json",this,"page",$('#orderInfo').serialize());
				},
				del : function(index){
					var _this = this;
					var id = _this.orderInfos[index].id;
					
					layer.confirm("确认删除吗?", {
						shade : 0.3,
						btn : [ '确认', '取消' ],
						icon : 3
					}, function(layerIndex) {
						layer.close(layerIndex);
						$.post("orderInfo/deleteOrderInfo.json",{id:id},function(data){
							if (data.RESPONSE_STATE == '200') {
								layer.msg('操作成功!', {icon : 1,time : 1 * 1000}, function() {
									_this.orderInfos.splice(index,1);
								})
							}else{
								layer.closeAll('loading');
								layer.alert(data.ERROR_INFO, {
									icon : 0
								});
							}
						})
					})
				},
				changeStatus : function(status){
					if(this.orderStatus != status){
						this.orderStatus = status;
						$("#orderStatus").val(status);
						this.submit();
					}
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