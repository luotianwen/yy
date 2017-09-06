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
					<form id="mallfeedback" method="post">
						<div class="ibox-content">
							<h2>管理</h2>
							<div class="input-group">
								<div class="col-md-3 m-b-xs">
									<input placeholder="内容" name="feedback_content" class="input form-control">
								</div>
								<div class="col-md-2 m-b-xs">
									<select class="form-control m-b" name="source"   >
										<option value=""  >来源</option>
										<option value="1"  >APP</option>
										<option value="2"  >pc </option>
										<option value="3"  >M端 </option>
										<option value="4"  >微信 </option>
									</select>
								</div>

								<div class="col-md-3 m-b-xs">
									<select class="form-control m-b" name="feedback_type"   >
										<option value=""  >类型</option>
										<option value="1"  >功能BUG</option>
										<option value="2"  >体验问题</option>
										<option value="3"  >功能建议</option>
										<option value="4"  >举报投诉</option>
										<option value="5"  >其他  </option>
									</select>
								</div>
								<div class="col-md-2 m-b-xs">
									<select class="form-control m-b" name="operate_type"   >
										<option value=""  > 状态</option>
										<option value="1"  >待处理</option>
										<option value="2"  >完毕</option>

									</select>
								</div>
								<div class="col-md-2">
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
														<th>ID</th>
														<th>反馈问题类型</th>
														<th>内容</th>
														<th>反馈用户ID</th>
														<th>反馈时间</th>
														<th>反馈来源</th>
														<th>处理人</th>
														<th>处理时间</th>
														<th>处理意见</th>
														<th>处理状态</th>
														<%--<th>操作</th>--%>
													</tr>
												</thead>
												<tbody>
													<tr v-for="(mallfeedback,index) in mallfeedbacks">
														<td>{{mallfeedback.feedback_id}}</td>
														<td><span v-if="mallfeedback.feedback_type==1">     功能BUG </span>
															<span v-else-if="mallfeedback.feedback_type==2">体验问题</span>
															<span v-else-if="mallfeedback.feedback_type==3">功能建议</span>
															<span v-else-if="mallfeedback.feedback_type==4">举报投诉</span>
															<span v-else-if="mallfeedback.feedback_type==5">其他     </span>
															 </td>
														<td>{{mallfeedback.feedback_content}}</td>
														<td>{{mallfeedback.user_id}}</td>
														<td>{{mallfeedback.feedback_time}}</td>
														<td><span v-if="mallfeedback.source==1">     APP  </span>
															<span v-else-if="mallfeedback.source==2">pc   </span>
															<span v-else-if="mallfeedback.source==3">M端  </span>
															<span v-else-if="mallfeedback.source==4">微信 </span>
														</td>
														<td>{{mallfeedback.operator_name}}</td>
														<td>{{mallfeedback.operate_time}}</td>
														<td>{{mallfeedback.opinion}}</td>
														<td>
															<span v-if="mallfeedback.operate_type==1">待处理</span>
															<span v-else-if="mallfeedback.operate_type==2">处理完毕</span>
														</td>
														<td>
															<button v-if="mallfeedback.operate_type==1" type="button" @click="edit(mallfeedback.feedback_id)" class="btn btn-outline btn-primary">
																<i class="fa fa-paste"></i> 处理
															</button>
															<button   type="button" @click="add(mallfeedback.feedback_id)" class="btn btn-outline btn-info ">
																<i class="fa fa-spoon"></i> 附件信息
															</button>
															<%--<button type="button" @click="del(index)" class="btn btn-outline btn-danger">
																<i class="fa fa-trash"></i> 删除
															</button>
														</td>--%>
													</tr>
												</tbody>
											</table>
										</div>
									</div>

									<%--<div class="ibox-content">
										<p>
											<button type="button" id="add" @click="add" class="btn btn-sm btn-primary">
												<i class="fa fa-plus"></i> 添加
											</button>
										</p>
									</div>--%>

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
			data : {page:null,mallfeedbacks:null},
			mounted : function(){
				spage(1,"mallfeedback/findAllMallFeedback.json",this,"page");
			},
			methods : {
				add : function(id){
					layer.open({
						type : 2,
						title : "新增",
						shade : 0.2,
						area : [ "70%", "80%" ],
						content : "mallfeedbackimg/goMallFeedbackImgList.html?feedback_id="+id
					});
				},
				edit : function(id){
					layer.open({
						type : 2,
						title : "编辑",
						shade : 0.2,
						area : [ "70%", "80%" ],
						content : "mallfeedback/goMallFeedbackEdit.html?id=" + id
					});
				},
				submit : function(){
					spage(1,"mallfeedback/findAllMallFeedback.json",this,"page",$('#mallfeedback').serialize());
				},
				del : function(index){
					var _this = this;
					var id = _this.mallfeedbacks[index].id;
					
					layer.confirm("确认删除吗?", {
						shade : 0.3,
						btn : [ '确认', '取消' ],
						icon : 3
					}, function(layerIndex) {
						layer.close(layerIndex);
						$.post("mallfeedback/deleteMallFeedback.json",{id:id},function(data){
							if (data.RESPONSE_STATE == '200') {
								layer.msg('操作成功!', {icon : 1,time : 1 * 1000}, function() {
									_this.mallfeedbacks.splice(index,1);
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