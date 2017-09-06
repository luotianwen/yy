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
					<form id="couponsDetail" method="post">
						<div class="ibox-content">
							<h2>管理</h2>
							<div class="input-group">
								<div class="col-md-6">
									<input placeholder="优惠券编号" name="couponsId" class="input form-control">
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
														<th>优惠券编号</th>
														<th>用户编号</th>
														<th>密钥</th>
														<th>面值</th>
														<th>使用面值</th>
														<th>优惠券有效期</th>
														<th>优惠券有效期结束</th>
														<th>状态</th>
													</tr>
												</thead>
												<tbody>
													<tr v-for="(couponsDetail,index) in couponsDetails">
														<td>{{couponsDetail.couponsId}}</td>
														<td>{{couponsDetail.user_id}}</td>
														<td>{{couponsDetail.passwords}}</td>
														<td>{{couponsDetail.money}}</td>
														<td>{{couponsDetail.useMoney}}</td>
														<td>{{couponsDetail.startDate}}</td>
														<td>{{couponsDetail.endDate}}</td>
														<td>
															<span v-if="couponsDetail.state==1">待绑定</span>
															<span v-else-if="couponsDetail.state==2">未使用（已绑定）</span>
															<span v-else-if="couponsDetail.state==3">已使用</span>
															<span v-else-if="couponsDetail.state==4">已作废</span>
															<span v-else>已过期</span>
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
	<script src="static/js/plugins/slimscroll/jquery.slimscroll.min.js"></script>

	<!-- iCheck -->
	<script src="static/js/plugins/iCheck/icheck.min.js"></script>
	
	<script type="text/javascript">
		new Vue({
			el : "#vue",
			data : {page:null,couponsDetails:null},
			mounted : function(){
				spage(1,"couponsDetail/findAllCouponsDetail.json",this,"page");
			},
			methods : {
				submit : function(){
					spage(1,"couponsDetail/findAllCouponsDetail.json",this,"page",$('#couponsDetail').serialize());
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