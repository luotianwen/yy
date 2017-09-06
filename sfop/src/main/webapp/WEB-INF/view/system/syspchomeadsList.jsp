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
					<form id="syspchomeads" method="post">
						<div class="ibox-content">
							<h2>管理</h2>
							<div class="input-group">
								<div class="col-md-4 m-b-xs">
									<select class="form-control m-b" name="module"  >
										<option value="0" >类型</option>
										<option value="1" >跑步</option>
										<option value="2" >骑行</option>
										<option value="3" >徒步</option>
										<option value="4" >男士</option>
										<option value="5" >女士</option>
										<option value="6" >儿童</option>
										<option value="7" >自驾</option>
									</select>
								</div>
								<div class="col-md-4 m-b-xs">
									<select class="form-control m-b" name="state"  >
										<option value="0" >状态</option>
										<option value="1" >启用</option>
										<option value="2" >禁用</option>
									</select>
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
														<th>广告id</th>
														<th>类型</th>
														<th>第1张图片地址</th>
														<th>第1张广告价格</th>
														<th>第2张图片地址</th>
														<th>第2张广告价格</th>
														<th>第3张图片地址</th>
														<th>第3张广告价格</th>
														<th>状态</th>
														<th>最后修改时间</th>
														<th>最后修改人</th>
														<th>备注</th>
														<th>操作</th>
													</tr>
												</thead>
												<tbody>
													<tr v-for="(syspchomeads,index) in syspchomeadss">
														<td>{{syspchomeads.id}}</td>
														<td>
															<span v-if="syspchomeads.module==0" >类型</span>
															<span v-if="syspchomeads.module==1" >跑步</span>
															<span v-if="syspchomeads.module==2" >骑行</span>
															<span v-if="syspchomeads.module==3" >徒步</span>
															<span v-if="syspchomeads.module==4" >男士</span>
															<span v-if="syspchomeads.module==5" >女士</span>
															<span v-if="syspchomeads.module==6" >儿童</span>
															<span v-if="syspchomeads.module==7" >自驾</span>
														</td>
														<td>
															<img height="50px" v-bind:src="syspchomeads.fimg1"/>
														</td>
														<td>{{syspchomeads.fprice1}}</td>
														<td>
															<img height="50px" v-bind:src="syspchomeads.fimg2"/>
														</td>
														<td>{{syspchomeads.fprice2}}</td>
														<td>
															<img height="50px" v-bind:src="syspchomeads.fimg3"/>
														</td>
														<td>{{syspchomeads.fprice3}}</td>
														<td>{{syspchomeads.state}}</td>
														<td>{{syspchomeads.lasttime}}</td>
														<td>{{syspchomeads.updatename}}</td>
														<td>{{syspchomeads.remark}}</td>
														<td>
															<button type="button" @click="edit(syspchomeads.id)" class="btn btn-outline btn-primary">
																<i class="fa fa-paste"></i> 编辑
															</button>
															<button type="button" @click="del(index)" class="btn btn-outline btn-danger">
																<i class="fa fa-trash"></i> 删除
															</button>
															<button type="button" @click="set(syspchomeads.id)" class="btn btn-outline btn-primary">
																<i class="fa fa-paste"></i> 设置商品
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
			data : {page:null,syspchomeadss:null},
			mounted : function(){
				spage(1,"syspchomeads/findAllSysPcHomeads.json",this,"page");
			},
			methods : {
				add : function(){
					layer.open({
						type : 2,
						title : "新增",
						shade : 0.2,
						area : [ "70%", "80%" ],
						content : "syspchomeads/goSysPcHomeadsEdit.html"
					});
				},
				edit : function(id){
					layer.open({
						type : 2,
						title : "编辑",
						shade : 0.2,
						area : [ "70%", "80%" ],
						content : "syspchomeads/goSysPcHomeadsEdit.html?id=" + id
					});
				},
				submit : function(){
					spage(1,"syspchomeads/findAllSysPcHomeads.json",this,"page",$('#syspchomeads').serialize());
				},
				set : function(id){
					var index=layer.open({
						type : 2,
						title : "设置商品",
						shade : 0.2,
						content : "syspchomeadware/goSysPcHomeadWareList.html?ad_id=" + id
					});
					layer.full(index);
				},
				del : function(index){
					var _this = this;
					var id = _this.syspchomeadss[index].id;
					
					layer.confirm("确认删除吗?", {
						shade : 0.3,
						btn : [ '确认', '取消' ],
						icon : 3
					}, function(layerIndex) {
						layer.close(layerIndex);
						$.post("syspchomeads/deleteSysPcHomeads.json",{id:id},function(data){
							if (data.RESPONSE_STATE == '200') {
								layer.msg('操作成功!', {icon : 1,time : 1 * 1000}, function() {
									_this.syspchomeadss.splice(index,1);
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