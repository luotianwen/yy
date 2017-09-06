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
					<form id="fxproduct" method="post" action="fxproduct/goExport" target="_blank" >
						<div class="ibox-content">
							<div class="input-group">
								<div class="col-md-4 m-b-xs">
									<input type="number" placeholder="sku" name="sku" class="input form-control">
								</div>
								<div class="col-md-4 m-b-xs">
									<input placeholder="商品名称" name="name" class="input form-control">
								</div>
								<div class="col-md-4 m-b-xs">
									<input placeholder="商品货号" name="snumber" class="input form-control">
								</div>
								<div class="col-md-4">
									<select class="form-control m-b" name="shopid" placeholder="店铺" >
										<option value="" >--店铺--</option>
										<c:forEach items="${shopinfos}" var="shopinfo">
											<option value="${shopinfo.s_merchants_id}" >${shopinfo.name}</option>
										</c:forEach>
									</select>
								</div>
								<div class="col-md-2">
									<button type="button" @click="submit" class="btn btn btn-primary">
										<i class="fa fa-search"></i> 搜索
									</button>
								</div>
								<div class="col-md-2">
									<button type="button" @click="import2" class="btn btn btn-warning">
										<i class="fa fa-upload"></i> 导入进价单
									</button>
								</div>
								<div class="col-md-2">
									<button type="submit"   class="btn btn btn-primary">
										<i class="fa fa-file-excel-o"></i> 导出数据
									</button>
								</div>
							</div>
							

							<div class="tab-content">
								<div class="tab-pane active">
									<div class="full-height-scroll">
										<div class="table-responsive">
											<table class="table table-striped table-hover">
												<thead>
													<tr>
														<th>sku</th>
														<th>商品名称</th>
														<th>款号/货号</th>
														<th>进货价</th>
														<th>世峰价</th>
														<th>毛利</th>
														<th>毛利率</th>
														<th>分销率</th>
														<th>佣金</th>
														<th>净毛利率</th>
														<th>最后修改时间</th>
														<th>最后修改人</th>
														<th>操作</th>
													</tr>
												</thead>
												<tbody>
													<tr v-for="(fxproduct,index) in fxproducts">
														<td>{{fxproduct.sku}}</td>
														<td>{{fxproduct.name}}</td>
														<td>{{fxproduct.snumber}}</td>
														<td>{{fxproduct.costprice}}</td>
														<td>{{fxproduct.price}}</td>
														<td>{{fxproduct.margin}}</td>
														<td>{{fxproduct.marginrate}}</td>
														<td>{{fxproduct.distributionrate}}</td>
														<td>{{fxproduct.commission}}</td>
														<td>{{fxproduct.lastmarginrate}}</td>
														<td>{{fxproduct.lasttime}}</td>
														<td>{{fxproduct.updatename}}</td>
														<td>
															<button type="button" @click="edit(fxproduct.sku)" class="btn btn-outline btn-primary">
																<i class="fa fa-paste"></i> 编辑
															</button>
														</td>
													</tr>
												</tbody>
											</table>
										</div>
									</div>


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
			data : {page:null,fxproducts:null},
			mounted : function(){
				spage(1,"fxproduct/findAllFxProduct.json",this,"page");
			},
			methods : {
				import2:function () {
					layer.open({
						type : 2,
						title : "编辑",
						shade : 0.2,
						area : [ "80%", "90%" ],
						content : "fxproduct/goImport.html"
					});
				},
				export2:function () {
					$.post("fxproduct/goExport?page="+this.page.currentPage ,$('#fxproduct').serialize(),function(data){
 					});
				},
				edit : function(id){
					layer.open({
						type : 2,
						title : "编辑",
						shade : 0.2,
						area : [ "80%", "90%" ],
						content : "fxproduct/goFxProductEdit.html?id="+id
					});
				},
				submit : function(){
					spage(1,"fxproduct/findAllFxProduct.json",this,"page",$('#fxproduct').serialize());
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