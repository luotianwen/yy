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
	
	<title>商城后台 - 分类管理</title>
	
	<link href="static/css/bootstrap.min.css" rel="stylesheet">
	<link href="static/css/font-awesome.min.css" rel="stylesheet">
	<!-- iCheck -->
	<link href="static/css/plugins/iCheck/custom.css" rel="stylesheet">
	<link href="static/css/animate.min.css" rel="stylesheet">
	<link href="static/css/style.min.css" rel="stylesheet">

</head>

<body class="gray-bg">
	<div class="wrapper wrapper-content  animated fadeInRight" id="vue">
		<div style="padding-left: 55%;">
			<a class="btn btn-sm btn-primary" @click="addCategory" style="cursor: pointer;">新增分类</a>
		</div>
		<div style="width: 65%; padding: 15px; height: 600px; float: left;" class="table-responsive panel panel-default">
			<table class="table table-striped table-hover">
				<thead>
					<tr>
						<th class="col-md-1">名称</th>
						<th class="col-md-1">更新时间</th>
						<th class="col-md-1">更新用户</th>
						<th class="col-md-2 center">操作</th>
					</tr>
				</thead>
		
				<tbody>
					<tr v-show="!category.isShow" v-for="(category,index) in category" @click="clickCategory(index)">
						<td>
							<button v-if="category.parentid=='0'" type="button" @click="showCategory(index)">
								<i v-if="category.isClick" class="fa fa-minus"></i>
								<i v-else class="fa fa-plus"></i>
							</button>
							<span v-else style="margin-left: 40px;"></span>
							<button type="button" v-bind:class="category.parentid=='0'?'btn btn-primary btn-sm':'btn btn-default btn-sm'">{{category.descript}}</button>
						</td>
						<td>{{category.lasttime }}</td>
						<td>{{category.updatename }}</td>
						<td>
							<button class="btn btn-outline btn-info" type="button" @click="addProperty(category.id,category.parentid)">
								<i class="fa fa-save"></i> 新增属性
							</button>
							<button class="btn btn-outline btn-info" type="button" @click="editCategory(category.id)">
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
	
		<span style="font-weight: bold; margin-left: 40px;">
			当前查询分类：<span>{{name}}</span>
			<input type="hidden" id="id" name="id" v-bind:value="id!=null?id:''"/>
		</span>
		<div style="width: 30%; padding: 15px; height: 580px; margin-left: 67%;" class="table-responsive panel panel-default">
			<table class="table table-condensed">
				<thead>
					<tr>
						<th>属性名称</th>
						<th>是否多选</th>
						<th>操作</th>
					</tr>
				</thead>
				<tbody>
					<tr v-for="(item,index) in propertycategorys">
						<td>{{item.name}}</td>
						<td>{{item.ismultiple==1?'是':'否'}}</td>
						<td>
							<button v-if="item.cid==id" type="button" @click="deleteProperty(index)" class="btn btn-outline btn-primary">
								<i class="fa fa-paste"></i> 删除
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
	<script src="static/js/plugins/slimscroll/jquery.slimscroll.min.js"></script>

	<!-- iCheck -->
	<script src="static/js/plugins/iCheck/icheck.min.js"></script>
	
	<script type="text/javascript">
		new Vue({
			el : "#vue",
			data : {category:null,propertycategorys:null,id:'',name:''},
			mounted : function(){
				var _this = this;
				$.post("category/findAllParentCategory.json",function(data){
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
				addCategory : function(){
					layer.open({
						type : 2,
						title : "新增分类",
						shade : 0.2,
						area : [ "40%", "50%" ],
						content : "category/goCategoryEdit.html"
					});
				},
				editCategory : function(id){
					layer.open({
						type : 2,
						title : "编辑分类",
						shade : 0.2,
						area : [ "40%", "50%" ],
						content : "category/goCategoryEdit.html?id="+id
					});
				},
				addProperty : function(id,parentid){
					layer.open({
						type : 2,
						title : "新增属性",
						shade : 0.2,
						area : [ "70%", "80%" ],
						content : "propertycategory/goPropertycategoryList.html?id="+id+"&&parentid="+parentid
					});
				},
				clickCategory : function(index){
					var _this = this;
					$.post("propertycategory/findAllPropertycategoryByPid.json",{id:_this.category[index].id,parentid:_this.category[index].parentid},function(data){
						_this.propertycategorys = data;
						_this.name = _this.category[index].descript;
						_this.id = _this.category[index].id;
					})
				},
				showCategory : function(index){
					var _this = this;
					if(_this.category[index].isClick==undefined){
						$.post("category/findCategoryByPid.json",{id:_this.category[index].id},function(data){
							if(data.RESPONSE_STATE=="200"){
								var json = data;
								Vue.set(_this.category[index],"isClick",true);
								var category = data.category;
								for(var i=0;i<category.length;i++){
									_this.category.splice(index+i+1, 0, category[i]);
								}
							}else{
								layer.alert(data.ERROR_INFO, {
									icon : 0
								});
								return;
							}
						})
					}else if(this.category[index].isClick){
						for(var i=index+1,len=this.category.length;i<len;i++){
							if(this.category[i].parentid!="0"){
								if(this.category[i].isShow==undefined){
									Vue.set(this.category[i],"isShow",true);
								}else{
									this.category[i].isShow = true;
								}
							}else{
								break;
							}
						}
						this.category[index].isClick = false;
					}else{
						for(var i=index+1,len=this.category.length;i<len;i++){
							if(this.category[i].parentid!="0"){
								this.category[i].isShow = false;
							}else{
								break;
							}
						}
						this.category[index].isClick = true;
					}
					
				},
				deleteCategory : function(index){
					var _this = this;
					var id = _this.category[index].id;
					var message = '确认删除该分类吗？';
					if(_this.category[index].parentid=="0"){
						message = '删除该分类，对应的子分类也一并删除，确认删除吗?';
					}
					
					layer.confirm(message, {
						shade : 0.3,
						btn : [ '确认', '取消' ],
						icon : 3
					}, function(layerIndex) {
						layer.close(layerIndex);
						$.post('category/deleteCategory.html', {id : id}, function(data) {
							if (data.RESPONSE_STATE == '200') {
								layer.msg('操作成功!', {icon : 1,time : 1 * 1000}, function() {
									if(_this.category[index].parentid=="0"){
										_this.category.splice(index,1);
										for(var i=index,len=_this.category.length;i<len;i++){
											if(_this.category[i].parentid!="0"){
												_this.category.splice(i,1);
												i--;
											}else{
												break;
											}
										}
									}else{
										_this.category.splice(index,1);
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
				},
				deleteProperty : function(index){
					var _this = this;
					var id = _this.propertycategorys[index].id;
					
					layer.confirm("确认删除该属性吗？", {
						shade : 0.3,
						btn : [ '确认', '取消' ],
						icon : 3
					}, function(layerIndex) {
						layer.close(layerIndex);
						$.post('propertycategory/deletePropertycategory.html', {id : id}, function(data) {
							if (data.RESPONSE_STATE == '200') {
								layer.msg('操作成功!', {icon : 1,time : 1 * 1000}, function() {
									_this.propertycategorys.splice(index,1);
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