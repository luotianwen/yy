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
	
	<title>商城后台 - 品牌管理</title>
	
	<link href="static/css/bootstrap.min.css" rel="stylesheet">
	<link href="static/css/font-awesome.min.css" rel="stylesheet">
	<!-- iCheck -->
	<link href="static/css/plugins/iCheck/custom.css" rel="stylesheet">
	<link href="static/css/animate.min.css" rel="stylesheet">
	<link href="static/css/style.min.css" rel="stylesheet">

</head>

<body class="gray-bg">
	<div class="wrapper wrapper-content  animated fadeInRight">
		<div class="row">
			<div id="user-box" class="col-sm-12">
				<div class="ibox">
					<form id="brandList" method="post">
						<div class="ibox-content" id="vue">
							<h2>品牌管理</h2>
							<div class="input-group">
								<div class="col-md-5">
									<input   placeholder="品牌名称" name="name" value="" class="input form-control">
								</div>
								<div class="col-md-4">
									<select class="input form-control" name="state">
										<option value="0">品牌状态</option>
										<option value="1">启用</option>
										<option value="2">禁用</option>
									</select>	
								</div>

								<div class="col-md-3">
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
														<th>编号</th>
														<th>品牌logo</th>
														<th>品牌名称</th>
														<th>排序</th>
														<th>品牌状态</th>
														<th>品牌类型</th>
														<th>商标注册人</th>
														<th>经营类型</th>
														<th>操作</th>
													</tr>
												</thead>
												<tbody>
													<tr v-for="brand in brands">
														<td>{{brand.id}}</td>
														<td> <img style="height: 50px;" v-bind:src="brand.logo" /></td>
														<td>{{brand.name}}</td>

														<td>{{brand.rand}}</td>

														<td>
															<span v-if="brand.state==1">启用</span>
															<span v-else>禁用</span>
														</td>
														<td><span v-if="brand.type==1">国际品牌</span>
															<span v-else>国内品牌</span>
															 </td>
														<td><span v-if="brand.trademarktype==1">企业</span>
															<span v-else>个人</span> </td>
														<td><span v-if="brand.businesstype==1">自有品牌</span>
															<span v-else>代理品牌</span> </td>
														<td>
															<button type="button" @click="edit(brand.id)" class="btn btn-outline btn-success">
																<i class="fa fa-paste">编辑</i>
															</button>
															<button type="button" @click="open(brand.id,brand.state)" class="btn btn-outline btn-danger">
																<i class="fa fa-warning" v-if="brand.state==1">禁用</i>
																<i class="fa fa-paste" v-else-if="brand.state==2">启用</i>
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
			data : {page:null,brands:null},
			mounted : function(){
				spage(1,"brand/findAllBrand.json",this,"page");
			},
			methods : {
				add : function(){
					layer.open({
						type : 2,
						title : "新增",
						shade : 0.2,
						area : [ "100%", "100%" ],
						content : "brand/goBrandEdit.html"
					});
				},
				open:function(id,state){
					var str="";
					if(state==1){
						state=2;
						str="禁用";
					}
					else{
						state=1;
						str="启用";
					}
					layer.msg('你确定'+str+'吗?', {
						time: 0
						,btn: ['确定', '取消']
						,yes: function(index){
							layer.close(index);
							$.post("brand/goBrandOpen.html",{"id":id,"state":state} , function(data) {

								if (data.RESPONSE_STATE == '200') {
									layer.msg(str+"成功", {
										icon : 1,
										time : 1 * 1000
									}, function() {
										 self.location.reload();
									});
								} else {
									layer.closeAll('loading');
									layer.alert(data.ERROR_INFO, {
										icon : 0
									});
								}
							});
						}
					});

				},
				edit : function(id){
					layer.open({
						type : 2,
						title : "编辑",
						shade : 0.2,
						area : [ "100%", "100%" ],
						content : "brand/goBrandEdit.html?id=" + id
					});
				},
				submit : function(){
					spage(1,"brand/findAllBrand.json",this,"page",$('#brandList').serialize());
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