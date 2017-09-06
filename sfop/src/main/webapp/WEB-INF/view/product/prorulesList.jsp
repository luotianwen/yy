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
					<form id="prorules" method="post">
						<div class="ibox-content">
							<h2>管理</h2>
							<div class="input-group">
								<div class="col-md-3 m-b-xs">
									<input placeholder="名称" name="name" class="input form-control">
								</div>
								<div class="col-md-3">
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
														<th>id</th>
														<th>sku</th>
														<th>商品编号</th>
														<th>库存</th>
														<th>重量</th>
														<th>进货价</th>
														<th>市场价</th>
														<th>世峰价</th>
														<th>商品货号</th>
														<th>图片编号</th>
														<th>最后修改时间</th>
														<th>最后修改人</th>
														<th>备注</th>
														<th>颜色</th>
														<th>规格</th>
														<th>开始时间</th>
														<th>结束时间</th>
														<th>活动类型</th>
														<th>活动价</th>
														<th>活动数量</th>
														<th>操作</th>
													</tr>
												</thead>
												<tbody>
													<tr v-for="(prorules,index) in proruless">
														<td>{{prorules.id}}</td>
														<td>{{prorules.sku}}</td>
														<td>{{prorules.pid}}</td>
														<td>{{prorules.stocks}}</td>
														<td>{{prorules.weight}}</td>
														<td>{{prorules.costprice}}</td>
														<td>{{prorules.marketprice}}</td>
														<td>{{prorules.price}}</td>
														<td>{{prorules.number}}</td>
														<td>{{prorules.imageid}}</td>
														<td>{{prorules.lasttime}}</td>
														<td>{{prorules.updatename}}</td>
														<td>{{prorules.remark}}</td>
														<td>{{prorules.colorid}}</td>
														<td>{{prorules.specid}}</td>
														<td>{{prorules.starttime}}</td>
														<td>{{prorules.endtime}}</td>
														<td>{{prorules.activitytype}}</td>
														<td>{{prorules.activityprice}}</td>
														<td>{{prorules.activitystocks}}</td>
														<td>
															<button type="button" @click="edit(prorules.id)" class="btn btn-outline btn-primary">
																<i class="fa fa-paste"></i> 编辑
															</button>
															<button type="button" @click="del(index)" class="btn btn-outline btn-danger">
																<i class="fa fa-trash"></i> 删除
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
			data : {page:null,proruless:null},
			mounted : function(){
				spage(1,"prorules/findAllProRules.json",this,"page");
			},
			methods : {
				add : function(){
					layer.open({
						type : 2,
						title : "新增",
						shade : 0.2,
						area : [ "70%", "80%" ],
						content : "prorules/goProRulesEdit.html"
					});
				},
				edit : function(id){
					layer.open({
						type : 2,
						title : "编辑",
						shade : 0.2,
						area : [ "70%", "80%" ],
						content : "prorules/goProRulesEdit.html?id=" + id
					});
				},
				submit : function(){
					spage(1,"prorules/findAllProRules.json",this,"page",$('#prorules').serialize());
				},
				del : function(index){
					var _this = this;
					var id = _this.proruless[index].id;
					
					layer.confirm("确认删除吗?", {
						shade : 0.3,
						btn : [ '确认', '取消' ],
						icon : 3
					}, function(layerIndex) {
						layer.close(layerIndex);
						$.post("prorules/deleteProRules.json",{id:id},function(data){
							if (data.RESPONSE_STATE == '200') {
								layer.msg('操作成功!', {icon : 1,time : 1 * 1000}, function() {
									_this.proruless.splice(index,1);
								})
							}else{
								layer.closeAll('loading');
								layer.alert(data.ERROR_INFO, {
									icon : 0
								});
							}
						})
					})
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