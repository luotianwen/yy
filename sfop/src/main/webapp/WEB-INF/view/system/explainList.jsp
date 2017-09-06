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
					<form id="explain" method="post">
						<div class="ibox-content">
							<h2>管理</h2>
							<div class="input-group">
								<div class="col-md-3">
									<input type="text" placeholder="标题" id="t.title" name="title" class="input form-control">
								</div>
								<div class="col-md-3">
									<select class="form-control m-b" name="type"  >
										<option value="0" >所有类型</option>
										<option value="1" >购物指南</option>
										<option value="2" >如何支付</option>
										<option value="3" >常见问题</option>
										<option value="4" >售后服务</option>
										<option value="5" >商务合作</option>
										<option value="6" >合同范本</option>
										<option value="7" >关于我们</option>
									</select>
								</div>
								<div class="col-md-3">
									<input type="text" placeholder="发布开始日期" id="t.releaseDate" name="releaseDate" readonly
										   class="input form-control">
								</div>

								<div class="col-md-3">
									<input type="text" placeholder="发布结束日期" id="t.lasttime"  name="lasttime" readonly
										   class="input form-control">
								</div>

								<div class="col-md-3">
									<button type="button" @click="submit"  class="btn btn btn-primary">
										<i class="fa fa-search"></i> 搜索
									</button>
								</div>
							</div>
							<div class="hr-line-dashed"></div>
							<div class="tab-content" >
								<div class="tab-pane active">
									<div class="full-height-scroll">
										<div class="table-responsive">
											<table class="table table-striped table-hover">
												<thead>
													<tr>
														<th>id</th>
														<th>标题</th>
														<th>名称</th>
														<th>类型</th>
														<th>发布日期</th>
														<th>最后修改时间</th>
														<th>最后修改人</th>
														<th>操作</th>
													</tr>
												</thead>
												<tbody>
													<tr v-for="explain in explains">
														<td>{{explain.id}}</td>
														<td>{{explain.title}}</td>
														<td>{{explain.name}}</td>
														<td>

															<span v-if="explain.type==1">购物指南</span>
															<span v-if="explain.type==2">如何支付</span>
															<span v-if="explain.type==3">常见问题</span>
															<span v-if="explain.type==4">售后服务</span>
															<span v-if="explain.type==5">商务合作</span>
															<span v-if="explain.type==6">合同范本</span>
															<span v-if="explain.type==7">关于我们</span>

														</td>
														<td>{{explain.releaseDate}}</td>
														<td>{{explain.lasttime}}</td>
														<td>{{explain.updatename}}</td>
														<td>
															<button type="button" @click="edit(explain.id)" class="btn btn-outline btn-primary">
																<i class="fa fa-paste"></i> 编辑
															</button>
															<button type="button"  @click="del(explain.id)"  class="btn btn-danger btn-primary">
																<i class="fa fa-paste"></i>删除
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
	<script src="static/js/plugins/layer/laydate/laydate.js"></script>
	<script type="text/javascript">
		$(function(){
			var start = {
				elem : '#t.releaseDate',
				format : 'YYYY-MM-DD',
				istoday : true
			};
			var end = {
				elem : '#t.lasttime',
				format : 'YYYY-MM-DD',
				istoday : true
			};
			laydate(start);
			laydate(end);

		});
		new Vue({
			el : "#vue",
			data : {page:null,explains:null},
			mounted : function(){
				spage(1,"explain/findAllExplain.json",this,"page");
			},
			methods : {
				add : function(){
					layer.open({
						type : 2,
						title : "新增",
						shade : 0.2,
						area : [ "70%", "80%" ],
						content : "explain/goExplainEdit.html"
					});
				},submit : function(){
					spage(1,"explain/findAllExplain.json",this,"page",$('#explain').serialize());
				},
				edit : function(id){
					layer.open({
						type : 2,
						title : "编辑",
						shade : 0.2,
						area : [ "70%", "80%" ],
						content : "explain/goExplainEdit.html?id=" + id
					});
				},
				del:function (id) {
					layer.msg('你确定删除吗?', {
						time: 0
						,btn: ['确定', '取消']
						,yes: function(index){
							layer.close(index);
							$.post("explain/deleteExplain.html",{"id":id} , function(data) {

								if (data.RESPONSE_STATE == '200') {
									layer.msg( "删除成功", {
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