<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
					<form id="malluserssilverlog" method="post">
						<input type="hidden" name="uid" value="${uid}">
						<div class="ibox-content">
							<%--<h2>管理</h2>
							<div class="input-group">
								<div class="col-md-3 m-b-xs">
									<input placeholder="名称" name="name" class="input form-control">
								</div>
								<div class="col-md-3">
									<button type="button" @click="submit" class="btn btn btn-primary">
										<i class="fa fa-search"></i> 搜索
									</button>
								</div>
							</div>--%>
							
							<div class="hr-line-dashed"></div>
							<div class="tab-content">
								<div class="tab-pane active">
									<div class="full-height-scroll">
										<div class="table-responsive">
											<table class="table table-striped table-hover">
												<thead>
													<tr>
														<th>银币</th>
														<th>余额</th>
														<th>类型</th>
														<th>最后更新时间</th>
													</tr>
												</thead>
												<tbody>
													<tr v-for="(malluserssilverlog,index) in malluserssilverlogs">
														<td>{{malluserssilverlog.silver}}</td>

														<td>{{malluserssilverlog.lastsilver}}</td>
														<td>
															<span v-if="malluserssilverlog.type==1" style="color: red">收入</span>
															<span v-else-if="malluserssilverlog.type==2" >兑换</span>
														</td>
														<td>{{malluserssilverlog.lasttime}}</td>

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
			data : {page:null,malluserssilverlogs:null},
			mounted : function(){
				this.submit();
			},
			methods : {
				submit : function(){
					spage(1,"malluserssilverlog/findAllMallUsersSilverLog.json",this,"page",$('#malluserssilverlog').serialize());
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