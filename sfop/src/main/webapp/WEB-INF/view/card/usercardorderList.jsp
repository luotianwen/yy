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
					<form id="usercardorder" method="post">
						<div class="ibox-content">
							<h2>管理</h2>
							<div class="input-group">
								<div class="col-md-3">
									<input type="text" placeholder="开始日期" id="sdate" name="sdate" readonly class="input form-control">
								</div>
	
								<div class="col-md-3">
									<input type="text" placeholder="结束日期" id="edate" name="edate" readonly class="input form-control">
								</div>
								
								<div class="col-md-3">
									<input type="number" placeholder="用户ID" id="userid" name="userid" class="input form-control">
								</div>
								<div class="col-md-3">
									<input type="number" placeholder="订单编号" id="orderid" name="orderid" class="input form-control">
								</div>
								<div class="col-md-3">
									<input type="number" placeholder="卡号" id="cardnumber" name="cardnumber" class="input form-control">
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
														<th>用户id</th>
														<th>订单id</th>
														<th>消费时间</th>
														<th>备注</th>
														<th>金额</th>
														<th>世峰卡号</th>
														<th>消费前金额</th>
														<th>消费后金额</th>
													</tr>
												</thead>
												<tbody>
													<tr v-for="(usercardorder,index) in usercardorders">
														<td>{{usercardorder.userid}}</td>
														<td>{{usercardorder.orderid}}</td>
														<td>{{usercardorder.ordertime}}</td>
														<td>{{usercardorder.note}}</td>
														<td>{{usercardorder.money}}</td>
														<td>{{usercardorder.cardnumber}}</td>
														<td>{{usercardorder.before_money}}</td>
														<td>{{usercardorder.after_money}}</td>
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
			data : {page:null,usercardorders:null},
			mounted : function(){
				spage(1,"usercardorder/findAllUserCardOrder.json",this,"page");
				this.dateinit();
			},
			methods : {
				dateinit : function(){
					var start = {
			   			elem : '#sdate',
			   			format : 'YYYY-MM-DD',
			   			istoday : false
			   		};
			   		var end = {
			   			elem : '#edate',
			   			format : 'YYYY-MM-DD',
			   			istoday : false
			   		};
			   		laydate(start);
			   		laydate(end);
				},
				submit : function(){
					spage(1,"usercardorder/findAllUserCardOrder.json",this,"page",$('#usercardorder').serialize());
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