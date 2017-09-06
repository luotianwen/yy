<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<HTML>
<HEAD>
<base href="<%=basePath%>">
<TITLE>ZTREE</TITLE>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">


    <link rel="shortcut icon" href="favicon.ico"> 
    <link href="static/css/bootstrap.min.css" rel="stylesheet">
    <link href="static/css/animate.min.css" rel="stylesheet">
    <link href="static/css/style.min.css" rel="stylesheet">
    <link href="static/css/font-awesome.min.css" rel="stylesheet">

<link rel="stylesheet" href="static/js/zTree_v3/css/zTreeStyle/zTreeStyle.css"
	type="text/css">
</HEAD>

<BODY class="gray-bg">
	<div class="wrapper wrapper-content animated fadeInRight">
		<div class="row">
			<div class="col-sm-12">
				<div class="ibox float-e-margins">
					<div class="ibox-title">
						<h5>关联菜单</h5>
					</div>
					<div class="ibox-content">
							<div class="form-group">
								<div class="col-sm-12">
									<ul id="tree" class="ztree"></ul>
								</div>
							</div>
							<div class="hr-line-dashed"></div>
							<div class="form-group">
								<div class="col-sm-4 col-sm-offset-2">
									<button class="btn btn-primary" type="button" onclick="save_qx()">
										<i class="fa fa-save"></i>&nbsp;保存
									</button>
									<script type="text/javascript">
									function save_qx(){
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
											
											// 保存修改后的节点集合
											$.post('authorization/linkRoleMenus.html',{ids:ids,rId:'${rId }'},function(data){
                                    			if(data.RESPONSE_STATE == '200'){
                                    				layer.msg('保存成功',{icon:1});
                                    				setTimeout(function(){
                                    					parent.self.location.reload();
                                    				},1000);
                                    			}else{
                                    				layer.closeAll('loading');
                               						layer.alert(data.ERROR_INFO,{icon:0});
                                    			}
											});
										});
									}
									</script>
									<button class="btn btn-white" type="button"
										onclick="parent.layer.close(parent.layer.getFrameIndex(window.name));">
										<i class="fa fa-times"></i>&nbsp;取消
									</button>
								</div>
							</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<script src="static/js/jquery-2.1.1.min.js" ></script>
	<script src="static/js/plugins/layer/layer.min.js"></script>
	
<script type="text/javascript"
	src="static/js/zTree_v3/js/jquery.ztree.core-3.5.js"></script>
<script type="text/javascript"
	src="static/js/zTree_v3/js/jquery.ztree.excheck-3.5.js"></script>
<SCRIPT type="text/javascript">
	// zTree 的配置数据
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

	$(document).ready(function() {
		var zNodes = new Array();
		var node;
		var menus = eval('(${menus })');// 获取该角色对应的菜单集合
		for(var i=0;i<menus.length;i++){
			var menu = menus[i];
			node = {id:menu.id,pId:menu.pId,name:menu.name,checked:menu.checked};
			zNodes.splice(0,0,node);
		}
		// 初始化方法
		$.fn.zTree.init($("#tree"), setting, zNodes);
		
	});
</SCRIPT>
</BODY>
</HTML>