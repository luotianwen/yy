<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()+ path + "/";
%>
<!DOCTYPE html>
<html>

<head>
<base href="<%=basePath%>">
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<title>商城后台 - 属性管理</title>

<link href="static/css/bootstrap.min.css" rel="stylesheet">
<link href="static/css/font-awesome.min.css" rel="stylesheet">
<!-- iCheck -->
<link href="static/css/plugins/iCheck/custom.css" rel="stylesheet">
<link href="static/css/animate.min.css" rel="stylesheet">
<link href="static/css/style.min.css" rel="stylesheet">

<style type="text/css">
	.this {
		background-color: #428bca;
		color: #fff;
		font-weight: bold;
	}
</style>

</head>

<body class="gray-bg">
<div id="vue">
	<form id="property" method="post">
		<div class="col-sm-1 m-b-xs" style="width: 180px; padding-top: 5px; padding-left: 20px">
			<input type="text" name="name" placeholder="请输入属性名称" class="input-sm form-control">
		</div>
	</form>
	<div class="col-sm-2 m-b-xs" style="padding-top: 5px; padding-left: 5px;">
		<div class="input-group">
			<span class="input-group-btn">
				 &ensp;<a @click="submit" class="btn btn-sm btn-primary" style="cursor: pointer">查询</a>
			</span>
			<span class="input-group-btn">
				 &ensp;<a @click="editProperty()" class="btn btn-sm btn-primary" style="cursor: pointer">新增属性</a>
			</span>
		</div>
	</div>
	
	<div style="padding-left: 76%; padding-top: 5px; cursor: pointer;" @click="addPropertyValue()">
		<a class="btn btn-sm btn-primary">新增属性值</a>
	</div>
	<div class="wrapper wrapper-content  animated fadeInRight">
		<div style="width: 50%; padding: 5px; height: 700px; float: left;" class="table-responsive panel panel-default">

			<table class="table table-condensed">
				<thead>
					<tr>
						<th>属性名称</th>
						<th>属性排序</th>
						<th>是否多选</th>
						<th>备注</th>
						<th>操作</th>
					</tr>
				</thead>
				<tbody>
					<tr v-for="(property,index) in propertys" v-bind:class="property.isClick?'categorytr this':'categorytr'" @click="selected(index)">
						<td>{{property.name}}</td>
						<td>{{property.sort}}</td>
						<td>{{property.ismultiple==1?'是':'否'}}</td>
						<td>{{property.remark}}</td>
						<td>
							<button type="button" @click="editProperty(property.id)" class="btn btn-outline btn-primary">
								<i class="fa fa-paste"></i> 编辑
							</button>
							<button type="button" @click="deleteProperty(index)" class="btn btn-outline btn-danger">
								<i class="fa fa-trash"></i> 删除
							</button>
						</td>
					</tr>
				</tbody>
			</table>
		</div>

		<span style="font-weight: bold; margin-left: 40px;">
			当前查询属性：<span>{{name}}</span>
			<input type="hidden" id="id" name="id" :value="id" />
		</span>
		<div style="width: 30%; padding: 5px; height: 90%; margin-left: 52%;" class="table-responsive panel panel-default">
			<table class="table table-condensed">
				<thead>
					<tr>
						<th>属性值</th>
						<th>排序</th>
						<th>操作</th>
					</tr>
				</thead>
				<tbody>
					<tr v-for="(item,index) in propertyValues">
						<td>{{item.content}}</td>
						<td>{{item.sort}}</td>
						<td>
						<td>
							<button type="button" @click="editPropertyValue(item.id)" class="btn btn-outline btn-primary">
								<i class="fa fa-paste"></i> 编辑
							</button>
							<button type="button" @click="deletePropertyValue(index)" class="btn btn-outline btn-danger">
								<i class="fa fa-trash"></i> 删除
							</button>
						</td>
						</td>
					</tr>
				</tbody>
			</table>
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
			data : {propertys:null,propertyValues:null,name:'',id:''},
			mounted : function() {
				var _this = this;
				$.post("property/findAllProperty.json", function(data) {
					for(var key in data){
						if(_this.key == undefined){
							Vue.set(_this.$data,key,data[key]);
						}else{
							_this.key = data[key];
						}
					}
					_this.selected(0);
				})
			},
			methods : {
				submit : function(){
					var _this = this;
					$.post("property/findAllProperty.json",$('#property').serialize(),function(data){
						for(var key in data){
							if(_this.key == undefined){
								Vue.set(_this.$data,key,data[key]);
							}else{
								_this.key = data[key];
							}
						}
						_this.selected(0);
					})
				},
				editProperty : function(id) {
					var url = "property/goPropertyEdit.html";
					if (id != null) {
						url += "?id=" + id;
					}
					layer.open({
						type : 2,
						title : "编辑",
						shade : 0.2,
						area : [ "40%", "78%" ],
						content : url
					});
				},
				addPropertyValue : function() {
					var id = $("#id").val();
					layer.open({
						type : 2,
						title : "编辑",
						shade : 0.2,
						area : [ "40%", "53%" ],
						content : "propertyvalue/goPropertyvalueAdd.html?id=" + id
					});
				},
				editPropertyValue : function(id) {
					layer.open({
						type : 2,
						title : "编辑",
						shade : 0.2,
						area : [ "40%", "53%" ],
						content : "propertyvalue/goPropertyvalueEdit.html?id=" + id
					});
				},
				selected : function(index) {
					var _this = this;
					var property = _this.propertys[index];
					if (property.isClick != true) {
						for (var i = 0, len = _this.propertys.length; i < len; i++) {
							if (_this.propertys[i].isClick != undefined) {
								_this.propertys[i].isClick = false;
							}
						}

						if (property.isClick == undefined) {
							Vue.set(property, "isClick", true);
						} else {
							property.isClick = true;
						}

						$.post("propertyvalue/findAllPropertyvalue.json",{id : property.id},function(data) {
							_this.propertyValues = data;
							_this.name = property.name;
							_this.id = property.id;
						})
					}
				},
				deleteProperty : function(index){
					var _this = this;
					var id = _this.propertys[index].id;
					layer.confirm("删除该属性，对应的属性值也一并删除，确认删除吗?", {
						shade : 0.3,
						btn : [ '确认', '取消' ],
						icon : 3
					}, function(layerIndex) {
						layer.close(layerIndex);
						$.post('property/deleteProperty.html', {id : id}, function(data) {
							if (data.RESPONSE_STATE == '200') {
								layer.msg('操作成功!', {icon : 1,time : 1 * 1000}, function() {
									_this.propertys.splice(index,1);
									_this.selected(0);
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
				deletePropertyValue : function(index){
					var _this = this;
					var id = _this.propertyValues[index].id;
					layer.confirm("确认删除该属性值吗？", {
						shade : 0.3,
						btn : [ '确认', '取消' ],
						icon : 3
					}, function(layerIndex) {
						layer.close(layerIndex);
						$.post('propertyvalue/deletePropertyvalue.html', {id : id}, function(data) {
							if (data.RESPONSE_STATE == '200') {
								layer.msg('操作成功!', {icon : 1,time : 1 * 1000}, function() {
									_this.propertyValues.splice(index,1);
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

