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
	<link href="static/css/layerdate/layerdate.css" rel="stylesheet">

</head>

<body class="gray-bg">
	<div class="wrapper wrapper-content  animated fadeInRight" id="vue">
		<div class="row">
			<div id="user-box" class="col-sm-12">
				<div class="ibox">
					<form id="friendshiplink" method="post">
						<div class="ibox-content">
							<h2>管理</h2>
							<div class="input-group">
								<div class="col-md-3">
									<input type="text" placeholder="名称" id="t.name" name="name" class="input form-control">
								</div>
								<div class="col-md-3">
									<select class="form-control m-b" name="state"  >
										<option value="0" >所有</option>
										<option value="1" >发布</option>
										<option value="2" >下线</option>
									</select>
								</div>
								<div class="col-md-3">
									<input type="text" placeholder="发布开始日期" id="t.releaseDate" name="releaseDate" readonly
										   class="input form-control">
								</div>

								<div class="col-md-3">
									<input type="text" placeholder="发布结束日期" id="t.lasttime"  name="lasttime" readonly
										   class="input form-control">
								</div>
								<div class="col-md-3">
									<input type="text" placeholder="链接" id="link"  name="link"
										   class="input form-control">
								</div>
								<div class="col-md-3">
									<input type="text" placeholder="联系人" id="contacts"  name="contacts"
										   class="input form-control">
								</div>
								<div class="col-md-3">
									<button type="button" @click="submit"  class="btn btn btn-primary">
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
														<th>名称</th>
														<th>链接</th>
														<th>发布日期</th>
														<th>联系人</th>
														<th>联系人电话</th>
														<th>联系人邮箱</th>
														<th>发布状态</th>
														<th>备注</th>
														<th>最后修改时间</th>
														<th>最后修改人</th>
														<th>操作</th>
													</tr>
												</thead>
												<tbody>
													<tr v-for="(friendshiplink,index) in friendshiplinks">
														<td>{{friendshiplink.id}}</td>
														<td>{{friendshiplink.name}}</td>

														<td>{{friendshiplink.link}}</td>
														<td>{{friendshiplink.releaseDate}}</td>

														<td>{{friendshiplink.contacts}}</td>
														<td>{{friendshiplink.phone}}</td>
														<td>{{friendshiplink.email}}</td>
														<td>
															<span v-if="friendshiplink.state==1">发布</span>
															<span v-else>下线</span>
														</td>
														<td>{{friendshiplink.note}}</td>
														<td>{{friendshiplink.lasttime}}</td>
														<td>{{friendshiplink.updatename}}</td>
														<td>
															<button type="button" @click="edit(friendshiplink.id)" class="btn btn-outline btn-primary">
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
	<script src="static/js/plugins/layer/laydate/laydate.js"></script>
	<!-- iCheck -->
	<script src="static/js/plugins/iCheck/icheck.min.js"></script>
	
	<script type="text/javascript">
		$(function(){
			var start = {
				elem : '#t.releaseDate',
				format : 'YYYY-MM-DD',
				istoday : true
			};
			var end = {
				elem : '#t.lasttime',
				format : 'YYYY-MM-DD',
				istoday : true
			};
			laydate(start);
			laydate(end);

		});
		new Vue({
			el : "#vue",
			data : {page:null,friendshiplinks:null},
			mounted : function(){
				spage(1,"friendshiplink/findAllFriendshipLink.json",this,"page");
			},
			methods : {
				add : function(){
					layer.open({
						type : 2,
						title : "新增",
						shade : 0.2,
						area : [ "70%", "90%" ],
						content : "friendshiplink/goFriendshipLinkEdit.html"
					});
				},
				edit : function(id){
					layer.open({
						type : 2,
						title : "编辑",
						shade : 0.2,
						area : [ "70%", "90%" ],
						content : "friendshiplink/goFriendshipLinkEdit.html?id=" + id
					});
				},
				submit : function(){
					spage(1,"friendshiplink/findAllFriendshipLink.json",this,"page",$('#friendshiplink').serialize());
				},
				del : function(index){
					var _this = this;
					var id = _this.friendshiplinks[index].id;
					layer.msg('你确定删除吗?', {
						time: 0
						,btn: ['确定', '取消']
						,yes: function(index1){
							layer.close(index1);
					$.post("friendshiplink/deleteFriendshipLink.json",{id:id},function(data){
						if (data.RESPONSE_STATE == '200') {
							layer.msg('操作成功!', {icon : 1,time : 1 * 1000}, function() {
								self.location.reload();
							})
						}else{
							layer.closeAll('loading');
							layer.alert(data.ERROR_INFO, {
								icon : 0
							});
						}
					})
						}})
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