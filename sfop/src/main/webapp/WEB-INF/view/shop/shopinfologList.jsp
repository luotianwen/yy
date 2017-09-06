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
					<form id="shopinfolog" method="post">
						<div class="ibox-content">
                           <input type="hidden" name="s_merchants_id" value="${s_merchants_id}">
							<input type="hidden" name="type" value="${type}">

							
							<div class="hr-line-dashed"></div>
							<div class="tab-content">
								<div class="tab-pane active">
									<div class="full-height-scroll">
										<div class="table-responsive">
											<table class="table table-striped table-hover">
												<thead>
													<tr>
														<th>审核阶段</th>
														<th>审核状态</th>
														<th>说明</th>
														<th>最后修改时间</th>
														<th>最后修改人</th>
														<th>备注</th>
													</tr>
												</thead>
												<tbody>
													<tr v-for="(shopinfolog,index) in shopinfologs">

														<td><span v-if="shopinfolog.type==1">初审</span>
															<span v-else>复审</span>
														</td>
														<td>
															<span v-if="shopinfolog.state==1">通过</span>
															<span v-else>驳回</span>
															 </td>
														<td>{{shopinfolog.note}}</td>
														<td>{{shopinfolog.lasttime}}</td>
														<td>{{shopinfolog.updatename}}</td>
														<td>{{shopinfolog.remark}}</td>

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
			data : {page:null,shopinfologs:null},
			mounted : function(){
				spage(1,"shopinfolog/findAllShopinfoLog.json",this,"page",$('#shopinfolog').serialize());
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