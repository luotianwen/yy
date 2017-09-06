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
					<form id="usercard" method="post">
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
									<input type="number" placeholder="用户编号" id="userid" name="userid" class="input form-control">
								</div>
								
								<div class="col-md-3">
									<input type="number" placeholder="卡号" id="cardnumber" name="cardnumber" class="input form-control">
								</div>
								
								<div class="col-md-3">
									<select class="form-control m-b" name="status" id="status">
										<option value="0">请选择e卡状态</option>
										<option value="1">未绑定</option>
	                               		<option value="2">未使用</option>
	                               		<option value="3">部分使用</option>
	                               		<option value="4">已用完</option>
	                               		<option value="5">已作废</option>
	                               		<option value="6">已过期</option>
									</select>
	
								</div>
								
								<div class="col-md-3">
									<button type="button" @click="submit" class="btn btn-success"> <i class="fa fa-search"></i> 搜索</button>
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
														<th>用户编号</th>
														<th>世峰卡号</th>
														<th>余额</th>
														<th>最后更新时间</th>
														<th>开始时间</th>
														<th>结束时间</th>
														<th>状态</th>
														<th>用户绑定e卡时间</th>
													</tr>
												</thead>
												<tbody>
													<tr v-for="(usercard,index) in usercards">
														<td>{{usercard.userid}}</td>
														<td>{{usercard.cardnumber}}</td>
														<td>{{usercard.money}}</td>
														<td>{{usercard.lasttime}}</td>
														<td>{{usercard.sdate}}</td>
														<td>{{usercard.edate}}</td>
														<td>{{usercard.status==1?"未绑定":usercard.status==2?"未使用":usercard.status==3?"部分使用":usercard.status==4?"已用完":usercard.status==5?"已作废":usercard.status==6?"已过期":''}}</td>
														<td>{{usercard.bindingtime}}</td>
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
			data : {page:null,usercards:null},
			mounted : function(){
				spage(1,"usercard/findAllUserCard.json",this,"page");
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
					spage(1,"usercard/findAllUserCard.json",this,"page",$('#usercard').serialize());
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