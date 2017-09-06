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

	<title>商城后台 - 导航管理</title>

	<link href="static/css/bootstrap.min.css" rel="stylesheet">
	<link href="static/css/font-awesome.min.css" rel="stylesheet">
	<!-- iCheck -->
	<link href="static/css/plugins/iCheck/custom.css" rel="stylesheet">
	<link href="static/css/animate.min.css" rel="stylesheet">
	<link href="static/css/style.min.css" rel="stylesheet">

</head>

<body class="gray-bg">
<div class="wrapper wrapper-content  animated fadeInRight" id="vue">
	<div style="padding-left: 45%;cursor: pointer;">
		<a class="btn btn-sm btn-primary" @click="editNavigation()">新增导航</a>
	</div>
	<div style="width: 50%; padding: 15px; height: 700px; float: left;" class="table-responsive panel panel-default">
		<table class="table table-striped table-hover">
			<thead>
			<tr>
				<th style="width:3%">序号</th>
				<th class="col-md-1">名称</th>
				<th class="col-md-1">url链接路径</th>
				<th style="width:3%">排序</th>
				<th class="col-md-1">更新时间</th>
				<th class="col-md-1">更新用户</th>
				<th class="col-md-2 center">操作</th>
			</tr>
			</thead>

			<tbody>
			<tr v-for="(navigation,index) in navigations" @click="clickNavigation(index)">
				<td>{{index+1 }}</td>
				<td>{{navigation.name }}</td>
				<td>{{navigation.url }}</td>
				<td>{{navigation.sort }}</td>
				<td>{{navigation.lasttime }}</td>
				<td>{{navigation.updatename }}</td>
				<td>
					<button v-if="navigation.parentid!='0'" class="btn btn-outline btn-info" type="button" @click="addCategory(navigation.id)">
						<i class="fa fa-save"></i> 分类
					</button>
					<button class="btn btn-outline btn-info" type="button" @click="editNavigation(navigation.id)">
						<i class="fa fa-edit"></i> 编辑
					</button>
					<button class="btn btn-outline btn-danger" type="button" @click="deleteNavigation(index)">
						<i class="fa fa-trash"></i> 删除
					</button>
				</td>
			</tr>
			</tbody>
		</table>
	</div>

	<span style="font-weight: bold; margin-left: 40px;">
			当前查询导航：<span v-show="false">{{id}}</span><span>{{name}}</span>
			<input type="hidden" id="id" name="id" :value="id"/>
		</span>
	<div style="width: 48%; padding: 15px; height: 680px; margin-left: 52%;" class="table-responsive panel panel-default">
		<table class="table table-condensed">
			<thead>
			<tr>
				<th>分类名称</th>
				<th>url</th>
				<th>排序</th>
				<th>操作</th>
			</tr>
			</thead>
			<tbody>
			<tr v-show="!item.isShow" v-for="(item,index) in navigationcategorys">
				<td>
					<button v-if="item.parentid=='0'" type="button" @click="showCategory(index)">
						<i v-if="item.isClick" class="fa fa-minus"></i>
						<i v-else class="fa fa-plus"></i>
					</button>
					<span v-else style="margin-left: 40px;"></span>
					<button type="button" v-bind:class="item.parentid=='0'?'btn btn-primary btn-sm':'btn btn-default btn-sm'">{{item.cName}}</button>
				</td>
				<td>{{item.url}}</td>
				<td>{{item.sort}}</td>
				<td>
					<button class="btn btn-outline btn-info" type="button" @click="editCategory(item.id)">
						<i class="fa fa-edit"></i> 编辑
					</button>
					<button class="btn btn-outline btn-danger" type="button" @click="deleteCategory(index)">
						<i class="fa fa-trash"></i> 删除
					</button>
				</td>
			</tr>

			</tbody>
		</table>
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
		data : {navigations:null,navigationcategorys:null,id:'',name:''},
		mounted : function(){
			var _this = this;
			$.post("navigation/findAllNavigation.json",function(data){
				for(var key in data){
					if(_this.key == undefined){
						Vue.set(_this.$data,key,data[key]);
					}else{
						_this.key = data[key];
					}
				}
			})
		},
		methods : {
			clickNavigation : function(index){
				var _this = this;
				var bool = true;
				if(_this.navigationcategorys!=undefined){
					if(_this.id == _this.navigations[index].id){
						bool = false;
					}
				}
				if(bool){
					$.post("navigationcategory/findAllNavigationCategoryByNid.json",{id:_this.navigations[index].id},function(data){
						_this.navigationcategorys = data;
						_this.id = _this.navigations[index].id;
						_this.name = _this.navigations[index].name;
					})
				}
			},
			editNavigation : function(id){
				var url = "navigation/goNavigationEdit.html";
				if(id!=null){
					url += "?id="+id;
				}
				layer.open({
					type : 2,
					title : "编辑",
					shade : 0.2,
					area : [ "70%", "80%" ],
					content : url
				});
			},
			deleteNavigation : function(index){
				var _this = this;
				var id = _this.navigations[index].id;
				var message = '删除该导航，对应的分类也一并删除，确认删除吗?';

				layer.confirm(message, {
					shade : 0.3,
					btn : [ '确认', '取消' ],
					icon : 3
				}, function(layerIndex) {
					layer.close(layerIndex);
					$.post('navigation/deleteNavigation.html', {id : id}, function(data) {
						if (data.RESPONSE_STATE == '200') {
							layer.msg('操作成功!', {icon : 1,time : 1 * 1000}, function() {
								_this.navigations.splice(index,1);
							});
						} else {
							layer.closeAll('loading');
							layer.alert(data.ERROR_INFO, {
								icon : 0
							});
						}
					});
				});
			},
			addCategory : function(id){
				layer.open({
					type : 2,
					area : [ '35%', '90%' ],
					title : '关联分类',
					shade : 0.3,
					fix : true,
					shift :0,
					maxmin : false,
					closeBtn: 1,
					skin : 'layui-layer-molv',
					content : 'category/goCategoryTree.html?id='+id
				});
			},
			showCategory : function(index){
				var _this = this;
				if(_this.navigationcategorys[index].isClick==undefined){
					$.post("navigationcategory/findAllNavigationCategoryByPid.json",{id:_this.navigationcategorys[index].cid,nid:_this.id},function(data){
						Vue.set(_this.navigationcategorys[index],"isClick",true);
						var navigationcategorys = data;
						for(var i=0;i<navigationcategorys.length;i++){
							_this.navigationcategorys.splice(index+i+1, 0, navigationcategorys[i]);
						}
					})
				}else if(_this.navigationcategorys[index].isClick){
					for(var i=index+1,len=_this.navigationcategorys.length;i<len;i++){
						if(_this.navigationcategorys[i].parentid!="0"){
							if(_this.navigationcategorys[i].isShow==undefined){
								Vue.set(_this.navigationcategorys[i],"isShow",true);
							}else{
								_this.navigationcategorys[i].isShow = true;
							}
						}else{
							break;
						}
					}
					_this.navigationcategorys[index].isClick = false;
				}else{
					for(var i=index+1,len=_this.navigationcategorys.length;i<len;i++){
						if(_this.navigationcategorys[i].parentid!="0"){
							_this.navigationcategorys[i].isShow = false;
						}else{
							break;
						}
					}
					_this.navigationcategorys[index].isClick = true;
				}

			},
			editCategory : function(id){
				layer.open({
					type : 2,
					title : "编辑",
					shade : 0.2,
					area : [ "70%", "80%" ],
					content : "navigationcategory/goNavigationCategoryEdit.html?id="+id
				});
			},
			deleteCategory : function(index){
				var _this = this;
				var id = _this.navigationcategorys[index].id;
				var message = '确认删除该分类吗？';
				var tp = "";
				if(_this.navigationcategorys[index].parentid=="0"){
					message = '删除该分类，对应的子分类也一并删除，确认删除吗?';
					tp = "main";
				}

				layer.confirm(message, {
					shade : 0.3,
					btn : [ '确认', '取消' ],
					icon : 3
				}, function(layerIndex) {
					layer.close(layerIndex);
					$.post('navigationcategory/deleteNavigationcategory.html', {id : id,tp : tp}, function(data) {
						if (data.RESPONSE_STATE == '200') {
							layer.msg('操作成功!', {icon : 1,time : 1 * 1000}, function() {
								if(_this.navigationcategorys[index].parentid=="0"){
									_this.navigationcategorys.splice(index,1);
									for(var i=index,len=_this.navigationcategorys.length;i<len;i++){
										if(_this.navigationcategorys[i].parentid!="0"){
											_this.navigationcategorys.splice(i,1);
											i--;
										}else{
											break;
										}
									}
								}else{
									_this.navigationcategorys.splice(index,1);
								}
							});
						} else {
							layer.closeAll('loading');
							layer.alert(data.ERROR_INFO, {
								icon : 0
							});
						}
					});
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