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
    

    <title>菜单管理</title>

    <link href="static/css/bootstrap.min.css" rel="stylesheet">
    <link href="static/css/font-awesome.min.css" rel="stylesheet">
    <link href="static/css/animate.min.css" rel="stylesheet">
    <link href="static/css/style.min.css" rel="stylesheet">
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
						<h2>菜单管理</h2>
						<div class="hr-line-dashed"></div>
						<div class="tab-content" id="vue">
							<div class="tab-pane active">
								<div class="full-height-scroll">
									<div class="table-responsive">
										<table class="table table-striped table-hover">
											<thead>
												<tr>
													<th class="col-md-1">序号</th>
													<th class="col-md-1">菜单图标</th>
													<th class="col-md-1">菜单名称</th>
													<th class="col-md-2">资源路径</th>
													<th class="col-md-1">菜单排序</th>
													<th class="col-md-1">更新时间</th>
													<th class="col-md-1">更新用户</th>
													<th class="col-md-2 center">操作</th>
												</tr>
											</thead>

											<tbody>
												<tr v-show="!menu.isShow" v-for="(menu,index) in menus">
													<td><span v-if="menu.mParentId=='0'">{{index+1}}</span></td>
													<td class="client-avatar"><i :class="menu.mIcon"></i>
													</td>
													<td>
														<button type="button" class="btn btn-primary btn-sm" @click="edit_menu(menu.mId)">{{menu.mName}}</button>
													</td>
													<td>{{menu.mPath }}</td>
													<td>{{menu.mOrder }}</td>
													<td>{{menu.mLastUpTime }}</td>
													<td>{{menu.mLastUpUser }}</td>
													<td>
														<button v-if="menu.mParentId=='0'" class="btn btn-outline btn-primary" type="button" @click="show_menus(index)">
															<span v-if="menu.isClick"><i class="fa fa-minus"></i> 折叠</span>
															<span v-else><i class="fa fa-plus"></i> 展开</span>
														</button>
														<button class="btn btn-outline btn-info" type="button" @click="edit_menu(menu.mId)">
															<i class="fa fa-edit"></i> 编辑
														</button>
														<button class="btn btn-outline btn-danger" type="button" @click="delete_menu(index)">
															<i class="fa fa-trash"></i> 删除
														</button>
													</td>
												</tr>
											</tbody>
										</table>
									</div>
								</div>
								<div class="hr-line-dashed">
									<br>
									<button class="btn btn-outline btn-primary" type="button" @click="add_menu">
										<i class="fa fa-plus"></i> 添加菜单
									</button>
								</div>
								<div class="text-center" id="page"></div>
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
 
    <script>
	    new Vue({
			el : "#vue",
			data : {page:null,menus:null},
			mounted : function(){
				spage(1,"menus/menuList.json",this,"page");
			},
			methods : {
				add_menu : function(){
					layer.open({
						type : 2,
						area : [ '50%', '80%' ],
						title : '添加菜单',
						shade : 0.3,
						fix : true,
						shift : 0,
						maxmin : false,
						closeBtn : 1,
						skin : 'layui-layer-molv',
						content : 'menus/goMenuAddView.do'
					});
				},
				edit_menu : function(mId){
					layer.open({
						type : 2,
						area : [ '50%', '70%' ],
						title : '编辑菜单',
						shade : 0.3,
						fix : true,
						shift : 0,
						maxmin : false,
						closeBtn : 1,
						skin : 'layui-layer-molv',
						content : 'menus/goMenuEditView.do?mId=' + mId
					});
				},
				show_menus : function(index){
					var _this = this;
					if(_this.menus[index].isClick==undefined){
						$.post("menus/getMenuByParentId.html",{mParentId:_this.menus[index].mId},function(data){
							if(data.RESPONSE_STATE=="200"){
								var json = data;
								Vue.set(_this.menus[index],"isClick",true);
								var menus = data.menus;
								for(var i=0;i<menus.length;i++){
									_this.menus.splice(index+i+1, 0, menus[i]);
								}
							}else{
								layer.alert(data.ERROR_INFO, {
									icon : 0
								});
								return;
							}
						})
					}else if(this.menus[index].isClick){
						for(var i=index+1,len=this.menus.length;i<len;i++){
							if(this.menus[i].mParentId!="0"){
								if(this.menus[i].isShow==undefined){
									Vue.set(this.menus[i],"isShow",true);
								}else{
									this.menus[i].isShow = true;
								}
							}else{
								break;
							}
						}
						this.menus[index].isClick = false;
					}else{
						for(var i=index+1,len=this.menus.length;i<len;i++){
							if(this.menus[i].mParentId!="0"){
								this.menus[i].isShow = false;
							}else{
								break;
							}
						}
						this.menus[index].isClick = true;
					}
					
				},
				delete_menu : function(index){
					var _this = this;
					var mId = _this.menus[index].mId;
					var message = '确认删除该菜单吗？';
					var tp = "";
					if(_this.menus[index].mParentId=="0"){
						message = '删除该主菜单，对应的子菜单也一并删除，确认删除吗?';
						tp = "main";
					}
					
					layer.confirm(message, {
						shade : 0.3,
						btn : [ '确认', '取消' ],
						icon : 3
					}, function(layerIndex) {
						layer.close(layerIndex);
						$.post('menus/deleteMenu.html', {mId : mId,tp : tp}, function(data) {
							if (data.RESPONSE_STATE == '200') {
								layer.msg('操作成功!', {icon : 1,time : 1 * 1000}, function() {
									if(_this.menus[index].mParentId=="0"){
										_this.menus.splice(index,1);
										for(var i=index,len=_this.menus.length;i<len;i++){
											if(_this.menus[i].mParentId!="0"){
												_this.menus.splice(i,1);
												i--;
											}else{
												break;
											}
										}
									}else{
										_this.menus.splice(index,1);
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

        $(function () {
            $('.full-height-scroll').slimScroll({
                height: '100%'
            });
            
        });
    </script>


</body>


</html>