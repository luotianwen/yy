<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html>

<head>
	<base href="<%=basePath%>">
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">

	<title>导航分类</title>

	<link href="static/css/bootstrap.min.css" rel="stylesheet">
	<link href="static/css/animate.min.css" rel="stylesheet">
	<link href="static/css/style.min.css" rel="stylesheet">
	<link href="static/css/layerdate/layerdate.css" rel="stylesheet">
	<link rel="stylesheet" href="static/js/zTree_v3/css/zTreeStyle/zTreeStyle.css" type="text/css">
	<style>
		.buttonFixed{
			position: fixed;
			top: 30px;
			right: 20px;
			z-index: 1000000;
		}
	</style>
</head>

<body class="gray-bg">
<div id="vue">
<div class="form-group buttonFixed"  >
	<div class="col-sm-4 col-sm-offset-2">
		<button class="btn btn-primary" type="button" @click="submit">
			<i class="fa fa-save"></i>&nbsp;保存
		</button>
		<button class="btn btn-white" type="button" onclick="parent.layer.close(parent.layer.getFrameIndex(window.name));">
			<i class="fa fa-times"></i>&nbsp;取消
		</button>
	</div>
</div>
<div class="wrapper wrapper-content animated fadeInRight contentTop">

	<div class="row">
		<div id="user-box" class="col-sm-12">
			<div class="ibox">
				<div class="col-sm-12">
					<input type="hidden" id="id" value="${id }" />

					<div class="ibox float-e-margins">

						<div class="ibox-content">
							<div class="form-group">
								<div class="col-sm-12">
									<ul id="tree" class="ztree"></ul>
								</div>
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
<script type="text/javascript" src="static/js/zTree_v3/js/jquery.ztree.core-3.5.js"></script>
<script type="text/javascript" src="static/js/zTree_v3/js/jquery.ztree.excheck-3.5.js"></script>

<script type="text/javascript">
	new Vue({
		el : "#vue",
		data : {},
		mounted : function() {
			var _this = this;
			$.post("category/findAllCategoryForNavigation.json",{id:$("#id").val()}, function(data) {
				var setting = {
					check : {
						enable : true
					},
					data : {
						simpleData : {
							enable : true
						}
					}
				};

				var zNodes = new Array();
				if(data.category!=null){
					for(var i=0,len=data.category.length;i<len;i++){
						var category = data.category[i];
						zNodes.splice(0,0,category);
						if(category.nodes!=null){
							for(var j=0,jlen=category.nodes.length;j<jlen;j++){
								zNodes.splice(0,0,category.nodes[j]);
							}
						}
					}
					// 初始化方法
					$.fn.zTree.init($("#tree"), setting, zNodes);
				}
			})
		},
		methods : {
			submit : function() {
				layer.confirm('确认保存吗？',{btn:['确认','取消'],icon:3},function(index){
					layer.load(0,{shade:0.3});
					// 获取当前被勾选的节点集合
					var treeObj = $.fn.zTree.getZTreeObj("tree");
					var nodes = treeObj.getCheckedNodes();
					var tmpNode;
					var ids = "";
					for(var i=0; i<nodes.length; i++){
						tmpNode = nodes[i];
						if(i!=nodes.length-1){
							ids += tmpNode.id+",";
						}else{
							ids += tmpNode.id;
						}
					}
					if(ids!=""){
						$.post("navigationcategory/saveNavigationCategory.json", {id:$("#id").val(),ids:ids}, function(data) {
							if (data.RESPONSE_STATE == '200') {
								layer.msg('保存成功', {
									icon : 1,
									time : 1 * 1000
								}, function() {
									parent.self.location.reload();
								});
							} else {
								layer.closeAll('loading');
								layer.alert(data.ERROR_INFO, {
									icon : 0
								});
							}
						});
					}else{
						layer.closeAll('loading');
						layer.alert("请选择分类！", {
							icon : 0
						});
					}

				});
			}
		}
	})
</script>


</body>


</html>