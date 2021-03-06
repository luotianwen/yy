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
	
	<title>编辑</title>
	
	<link href="static/css/bootstrap.min.css" rel="stylesheet">
	<link href="static/css/animate.min.css" rel="stylesheet">
	<link href="static/css/style.min.css" rel="stylesheet">
	<link href="static/css/layerdate/layerdate.css" rel="stylesheet">
	<!-- iCheck -->
	<link href="static/css/plugins/iCheck/custom.css" rel="stylesheet">

</head>

<body class="gray-bg">
	<div class="wrapper wrapper-content animated fadeInRight">
		<div class="row">
			<div id="user-box" class="col-sm-12">
				<div class="ibox">
					<div class="ibox-content" id="vue">
						<form id="explain" method="post" class="form-horizontal">
							<input type="hidden" id="id" name="id" value="${id}"/>
							
							   <div class="form-group">
									<label class="col-sm-2 control-label">标题</label>
									<div class="col-sm-10">
										<input type="text" class="form-control" placeholder="标题" id="title" name="title" :value="explain!=null?explain.title:''">
									</div>
								</div>

							   <div class="form-group">
									<label class="col-sm-2 control-label">名称</label>
									<div class="col-sm-10">
										<input type="text" class="form-control" placeholder="名称" id="name" name="name" :value="explain!=null?explain.name:''">
									</div>
								</div>

							   <div class="form-group">
									<label class="col-sm-2 control-label">内容</label>
									<div class="col-sm-10">
										<textarea   id="content" name="content"></textarea>
									</div>
								</div>
							<div class="hr-line-dashed"></div>
							   <div class="form-group">
									<label class="col-sm-2 control-label">类型</label>
									<div class="col-sm-10">
										<select class="form-control m-b" name="type"  >
											<option value="1" v-bind:selected="explain!=null&&explain.type==1">购物指南</option>
											<option value="2" v-bind:selected="explain!=null&&explain.type==2">如何支付</option>
											<option value="3" v-bind:selected="explain!=null&&explain.type==3">常见问题</option>
											<option value="4" v-bind:selected="explain!=null&&explain.type==4">售后服务</option>
											<option value="5" v-bind:selected="explain!=null&&explain.type==5">商务合作</option>
											<option value="6" v-bind:selected="explain!=null&&explain.type==6">合同范本</option>
											<option value="7" v-bind:selected="explain!=null&&explain.type==7">关于我们</option>
										</select>
									</div>
								</div>

							   <div class="form-group">
									<label class="col-sm-2 control-label">发布日期</label>
									<div class="col-sm-10">
										<input type="text" readonly class="form-control" placeholder="发布日期" id="releaseDate" name="releaseDate" :value="explain!=null?explain.releaseDate:''">
									</div>
								</div>

					      
							
					 
							
							<div class="form-group">
								<div class="col-sm-4 col-sm-offset-2">
									<a class="btn btn-primary" id="submit" @click="submit">保存内容</a>
									<a class="btn btn-white" id="cancel" onclick="parent.layer.close(parent.layer.getFrameIndex(window.name))">取消</a>
								</div>
							</div>
						</form>
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
	<!-- iCheck -->
	<script src="static/js/plugins/iCheck/icheck.min.js"></script>
	<script src="static/js/plugins/layer/laydate/laydate.js"></script>
	<script type="text/javascript" charset="utf-8" src="static/plugins/ueditor/ueditor.min.config.js"></script>
	<script type="text/javascript" charset="utf-8" src="static/plugins/ueditor/ueditor.all.min.js"> </script>
	<script type="text/javascript" charset="utf-8" src="static/plugins/ueditor/lang/zh-cn/zh-cn.js"></script>
	<script type="text/javascript">
		$(function(){
			var start = {
				elem : '#releaseDate',
				format : 'YYYY-MM-DD',
				istoday : true
			};

			laydate(start);


		});
		new Vue({
			el : "#vue",
			data : {explain:null},
			mounted : function(){
				var _this = this;
				$.post("explain/findExplainById.json?id="+$("#id").val(),function(data){
					for(var key in data){
						if(_this.key == undefined){
							Vue.set(_this.$data,key,data[key]);
						}else{
							_this.key = data[key];
						}
					}
					
					if(_this.explain!=undefined){
						$("#content").val(_this.explain.content);
					}
					ue= UE.getEditor('content');
				})
			},
			methods : {
				submit : function(){
					if (this.check_in()) {
						layer.load(0, {
							shade : 0.3
						});
						var url = "explain/saveExplain.json";

						if ($("#id").val().trim()!=null&&$("#id").val().trim()!=''&&$("#id").val().trim()!='0') {
							url = "explain/updateExplain.json";
						}
						$.post(url, $('#explain').serialize(), function(data) {
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
					}
				},
				check_in : function(){
					if ($('#id').val().trim() == '') {
						$("#id").val(0);
					}
					var html = ue.getContent();
					if (html.trim() == '') {
						layer.tips('内容！！！', '#content', {
							tips : [ 1, '#019F95' ],
							time : 1500
						});
						$('#content').focus();
						return false;
					}
					if ($('#name').val().trim() == '') {
						layer.tips('名称必填！', '#name', {
							tips : [ 1, '#019F95' ],
							time : 1500
						});
						$('#name').focus();
						return false;
					}
					if ($('#title').val().trim() == '') {
						layer.tips('标题必填！', '#title', {
							tips : [ 1, '#019F95' ],
							time : 1500
						});
						$('#title').focus();
						return false;
					}
					if ($('#releaseDate').val().trim() == '') {
						layer.tips('发布日期必填！', '#releaseDate', {
							tips : [ 1, '#019F95' ],
							time : 1500
						});
						$('#releaseDate').focus();
						return false;
					}
					return true;
				}
			}
		})
		
	</script>


</body>


</html>