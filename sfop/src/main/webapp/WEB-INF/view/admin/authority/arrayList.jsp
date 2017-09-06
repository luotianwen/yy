<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>


<head>
	<base href="<%=basePath%>">
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    

    <title>组织管理</title>

    <link href="static/css/bootstrap.min.css" rel="stylesheet">
    <link href="static/css/font-awesome.min.css" rel="stylesheet">

    <link href="static/css/animate.min.css" rel="stylesheet">
    <link href="static/css/style.min.css" rel="stylesheet">
    
    <script src="static/js/jquery-2.1.1.min.js"></script>
    
    <link href="static/css/page.css" rel="stylesheet">
	<style type="text/css">
		.curr{
			background-color: #A6DBD0;
		}
		.center {
		  text-align: center;
		}
	</style> 

</head>

<body class="gray-bg">
    <div class="wrapper wrapper-content  animated fadeInRight">
        <div class="row">
            <div id="user-box" class="col-sm-12">
                <div class="ibox">
                    <div class="ibox-content">
                       	<h2>系统分组</h2>
                       	<button class="btn btn-outline btn-primary " type="button" onclick="add_array()"><i class="fa fa-plus"></i>&nbsp;新增</button>&nbsp;&nbsp;
                       	<button class="btn btn-outline btn-info " type="button" onclick="update_array()"><i class="fa fa-edit"></i> 编辑</button>&nbsp;&nbsp;
						<button class="btn btn-outline btn-danger " type="button" onclick="delete_array()" ><i class="fa fa-trash"></i> 删除</button>
						<script type="text/javascript">
						function update_array(){
				       		layer.open({
								type : 2,
								area : [ '50%', '50%' ],
								title : '编辑分组',
								shade : 0.3,
								fix : true, 
								shift :0,
								maxmin : false,
								closeBtn: 1,
								skin : 'layui-layer-molv',
								content : 'arrays/goUpdateArrayView.do?aId='+'${aId }'
							});
						}
						function add_array(){
				       		layer.open({
								type : 2,
								area : [ '50%', '50%' ],
								title : '添加分组',
								shade : 0.3,
								fix : true, 
								shift :0,
								maxmin : false,
								closeBtn: 1,
								skin : 'layui-layer-molv',
								content : 'arrays/goArrayAdd.html'
							});
						}
						function delete_array(){
							var aName = $('#current_aname').val();
							if(typeof(aName) == 'undefined'){
								return;
							}
							layer.confirm('确认删除名为【'+aName+'】分组吗?删除该分组之后，处于该分组之下的角色都将进行删除!',{btn:['确认删除','取消'],icon:3},function(index){
								layer.load(0,{shade:0.3});
								$.post('arrays/deleteArray.html',{aId:'${aId }'},function(data){
									
									if(data.RESPONSE_STATE == '200'){
                               			layer.msg('操作成功!',{icon:1});
                               			setTimeout(function(){
                               				self.location.reload();
                               			},1000);
                               		}else{
                               			layer.closeAll('loading');
                               			layer.alert(data.ERROR_INFO,{icon:0});
                               		}
								});
							});
						}
						</script>
                       	<div class="hr-line-dashed"></div> 
                       	<c:forEach items="${arrays }" var="array" varStatus="vs">
                    		<c:if test="${aId == array.aId }"><input id="current_aname" value="${array.aName }" type="hidden" /></c:if>
                       		<button type="button" class="btn 
	                       		<c:choose>
	                       			<c:when test="${aId == array.aId }">btn-primary</c:when>
	                       			<c:otherwise>btn-default</c:otherwise>
	                       		</c:choose>
                       		" onclick="location.href='arrays/getArrayList.html?aId=${array.aId }'" ><i class="fa 
                       		<c:choose>
                       			<c:when test="${aId == array.aId }">fa-hand-o-right</c:when>
                       			<c:otherwise>fa-hand-o-up</c:otherwise>
                       		</c:choose>
                       		"></i>&nbsp;${array.aName }</button>&nbsp;&nbsp;
                       	</c:forEach>
                       <div class="hr-line-dashed"></div> 
                            <div class="tab-content">
                                <div class="tab-pane active">
                                    <div class="full-height-scroll">
                                        <div class="table-responsive">
                                            <table class="table table-striped table-hover">
	                                            <thead>
					                                <tr>
					                                    <th class="col-md-1">序号</th>
					                                    <th class="col-md-1">角色名称</th>
					                                    <th class="col-md-1">角色排序</th>
					                                    <th class="col-md-1">更新用户</th>
					                                    <th class="col-md-1">更新时间</th>
					                                    <th class="col-md-2 center">操作</th>
					                                </tr>
					                            </thead>
                                            
                                                <tbody>
                                                	<c:if test="${empty roles }">
                                                		<tr>
                                                			<td class="center" colspan="6">暂无角色!!!</td>
                                                		</tr>
                                                	</c:if>
                                                	<c:forEach items="${roles }" var="role" varStatus="vs" >
                                                	<tr>
                                                		<td>${vs.index+1 }</td>
                                                        <td class="client-avatar">
                                                        	<span>${role.rName }</span> 
                                                        </td>
                                                        <td>
                                                        	<span>${role.rOrder }</span>
                                                        </td>
                                                        <td>
                                                        	<span>${role.rUpUser }</span>
                                                        </td>
                                                        <td>
                                                        	<span>
                                                        	<fmt:formatDate value="${role.rUpTime }" pattern="yyyy-MM-dd HH:mm:ss" />
                                                        	</span>
                                                        </td>
                                                        <td class="center">
                                                        	<button class="btn btn-outline btn-primary " type="button" onclick="link_menus('${role.rId}')"  ><i class="fa fa-link"></i> 菜单</button>
									                        <button class="btn btn-outline btn-info  " type="button" onclick="edit_role('${role.rId}','${role.rName }','${role.rOrder }')"><i class="fa fa-edit"></i> 编辑</button>
									                        <button class="btn btn-outline btn-danger   " type="button" onclick="delete_role('${role.rId}')"><i class="fa fa-trash"></i> 删除</button>
                                                        </td>
                                                    </tr>
                                                	</c:forEach>
                                                </tbody>
                                            </table>
                                            <script type="text/javascript">
                                            function link_menus(rId){
									       		layer.open({
													type : 2,
													area : [ '25%', '70%' ],
													title : '关联菜单',
													shade : 0.3,
													fix : true, 
													shift :0,
													maxmin : false,
													closeBtn: 1,
													skin : 'layui-layer-molv',
													content : 'menus/goMenuTree.do?rId='+rId
												});
                                            	
                                            }
                                            function edit_role(rId,rName,rOrder){
									       		layer.open({
													type : 2,
													area : [ '50%', '50%' ],
													title : '添加角色',
													shade : 0.3,
													fix : true, 
													shift :0,
													maxmin : false,
													closeBtn: 1,
													skin : 'layui-layer-molv',
													content : 'roles/goRoleEdit.html?rId='+rId+'&rName='+rName+'&rOrder='+rOrder
												});
                                            }
                                            function delete_role(rId){
                                            	layer.confirm('确认删除该角色吗?',{btn:['确认删除','取消'],icon:3},function(index){
                                            		layer.load(0,{shade:0.3});
                                            		$.post('roles/deleteRoleByRId.html',{rId:rId},function(data){
														
														if(data.RESPONSE_STATE == '200'){
					                               			layer.msg('操作成功!',{icon:1});
					                               			setTimeout(function(){
					                               				self.location.reload();
					                               			},1000);
					                               		}else{
					                               			layer.closeAll('loading');
                               								layer.alert(data.ERROR_INFO,{icon:0});
					                               		}
                                            		})
                                            	});
                                            }
                                            </script>
                                        </div>
                                    </div>
                         		</div>
	                         </div>
	                       <div class="hr-line-dashed"></div>
	                       <button class="btn btn-outline btn-primary " type="button" onclick="add_role()" ><i class="fa fa-plus"></i> 添加角色</button>
	                       <script type="text/javascript">
							function add_role(){
					       		layer.open({
									type : 2,
									area : [ '50%', '50%' ],
									title : '添加角色',
									shade : 0.3,
									fix : true, 
									shift :0,
									maxmin : false,
									closeBtn: 1,
									skin : 'layui-layer-molv',
									content : 'roles/goRoleAdd.html?aId='+'${aId }'
								});
							}
	                       </script>
	                    </div>
	                </div>
	            </div>
	        </div>
	    </div>

    <!-- 全局js -->
    <script src="static/js/bootstrap.min.js"></script>
	<script src="static/js/plugins/layer/layer.min.js"></script>
    <script src="static/js/plugins/slimscroll/jquery.slimscroll.min.js"></script>

 

    <script>
        $(function () {
            $('.full-height-scroll').slimScroll({
                height: '100%'
            });
            
        });
    </script>


</body>


</html>