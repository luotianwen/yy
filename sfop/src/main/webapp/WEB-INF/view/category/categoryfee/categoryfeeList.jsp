<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
	
	<title>商城后台 - 分类费用管理</title>
	
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
					<form id="categoryfee" method="post">
						<div class="ibox-content">
							<h2>分类费用管理</h2>
							<div class="input-group">

								<select class="form-control m-b" name="name" placeholder="分类" >
									<option value="" >--分类--</option>
									<c:forEach items="${categorys}" var="category">
										<option value="${category.id}" > ${category.name} </option>
											<c:forEach items="${category.nodes}" var="node">
												<option value="${node.id}" >  --${category.name}/${node.name}</option>
											</c:forEach>
									</c:forEach>
								</select>
								<div class="col-md-4">
									<button type="button" @click="submit"  class="btn btn btn-primary">
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
														<th>分类id</th>
														<th>分类名称</th>
														<th>代销店铺扣点</th>
														<th>类目保证金标准（元）</th>
														<th>平台使用费</th>
														<th>扣点</th>
														<th>最后更新时间</th>
														<th>最后更新人</th>
														<th>操作</th>
													</tr>
												</thead>
												<tbody>
													<tr v-for="categoryfee in categoryfees">
														<td>{{categoryfee.id}}</td>
														<td>{{categoryfee.name}}</td>
														<td>{{categoryfee.consignmentpoints}}</td>
														<td>{{categoryfee.deposit}}</td>
														<td>{{categoryfee.platformfee}}</td>
														<td>{{categoryfee.points}}</td>
														<td>{{categoryfee.lasttime}}</td>
														<td>{{categoryfee.updatename}}</td>
														<td>
															<button type="button" @click="edit(categoryfee.id)" class="btn btn-outline btn-primary">
																<i class="fa fa-paste"></i> 编辑
															</button>
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
			data : {page:null,categoryfees:null},
			mounted : function(){
				spage(1,"categoryfee/findAllCategoryFee.json",this,"page");
			},
			methods : {
				edit : function(id){
					layer.open({
						type : 2,
						title : "编辑",
						shade : 0.2,
						area : [ "70%", "80%" ],
						content : "categoryfee/goCategoryFeeEdit.html?id=" + id
					});
				},
				submit : function(){
					spage(1,"categoryfee/findAllCategoryFee.json",this,"page",$('#categoryfee').serialize());
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