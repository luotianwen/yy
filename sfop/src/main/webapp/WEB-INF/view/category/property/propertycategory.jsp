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
	
	<title>商城后台 - 管理分类属性</title>
	
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
					<div class="ibox-content">
						<h2>管理分类属性</h2>
						<div class="input-group">
							<div class="col-md-4">
								<input type="text" placeholder="名称" id="name" name="name" class="input form-control">
							</div>
							<div class="col-md-4">
								<button type="button" @click="submit"  class="btn btn btn-primary">
									<i class="fa fa-search"></i> 搜索
								</button>
							</div>
						</div>
						
						<div class="hr-line-dashed"></div>
							<div class="tab-content">
								<input id="cid" type="hidden" value="${cid }"/>
								<input id="parentid" type="hidden" value="${parentid }"/>
								<div class="tab-pane active">
									<div class="full-height-scroll">
										<div class="table-responsive">
											<table class="table table-striped table-hover">
												<thead>
													<tr>
														<th>属性名称</th>
														<th>属性排序</th>
														<th>是否多选</th>
														<th>操作</th>
													</tr>
												</thead>
												<tbody>
													<tr v-for="(property,index) in propertys">
														<td>{{property.name}}</td>
														<td>{{property.sort}}</td>
														<td>{{property.ismultiple==1?"是":"否"}}</td>
														<td>
															<a v-if="!property.isSave" class="connect btn btn-sm btn-primary" style="cursor: pointer;" @click="addProperty(index)">+</a>
															<span v-else style="color:green;cursor: pointer;">已添加</span>
														</td>
													</tr>
												</tbody>
											</table>
										</div>
									</div>
								</div>
	
							</div>
					</div>
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
			data : {propertys:null},
			mounted : function(){
				this.submit();
			},
			methods : {
				submit : function(){
					var _this = this;
					$.post("property/findProperty.json",{id:$("#cid").val(),parentid:$("#parentid").val(),name:$("#name").val()},function(data){
						_this.propertys = data.propertys;
						var propertycategory = data.propertycategory;
						for(var i=0,len=_this.propertys.length;i<len;i++){
							for(var j=0,lenj=propertycategory.length;j<lenj;j++){
								if(_this.propertys[i].id==propertycategory[j].pid){
									Vue.set(_this.propertys[i],"isSave",true);
								}
							}
						}
					})
				},
				addProperty : function(index){
					var _this = this;
					var property = _this.propertys[index];
					$.post("propertycategory/savePropertycategory.json",{pid:property.id,cid:$("#cid").val()},function(){
						if(property.isSave==undefined){
							Vue.set(property,"isSave",true);
						}else{
							property.isSave = true;
						}
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