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
	<div class="wrapper wrapper-content animated fadeInRight" id="vue">
		<div class="row">
			<div id="user-box" class="col-sm-12">
				<div class="ibox">
					<div class="ibox-content">
						<form id="mallfeedback" method="post" class="form-horizontal">
							<input type="hidden" id="id" name="feedback_id" value="${id}"/>
							   <div class="form-group">
									<label class="col-sm-2 control-label">反馈问题类型</label>
									<div class="col-sm-10">
										<select class="form-control m-b" name="feedback_type" disabled >
											<option value="1" v-bind:selected="mallfeedback!=null&&mallfeedback.feedback_type==1">功能BUG</option>
											<option value="2" v-bind:selected="mallfeedback!=null&&mallfeedback.feedback_type==2">体验问题</option>
											<option value="3" v-bind:selected="mallfeedback!=null&&mallfeedback.feedback_type==2">功能建议</option>
											<option value="4" v-bind:selected="mallfeedback!=null&&mallfeedback.feedback_type==2">举报投诉</option>
											<option value="5" v-bind:selected="mallfeedback!=null&&mallfeedback.feedback_type==2">其他  </option>
										</select>
									</div>
								</div>
							<div class="hr-line-dashed"></div>
							   <div class="form-group">
									<label class="col-sm-2 control-label">内容</label>
									<div class="col-sm-10">
										<input type="text" readonly class="form-control" placeholder="内容" id="feedback_content" name="feedback_content" v-bind:value="mallfeedback!=null?mallfeedback.feedback_content:''">
									</div>
								</div>

							<div class="hr-line-dashed"></div>
							   <div class="form-group">
									<label class="col-sm-2 control-label">反馈时间</label>
									<div class="col-sm-10">
										<input type="text" readonly class="form-control" placeholder="反馈时间" id="feedback_time2" name="feedback_time2" v-bind:value="mallfeedback!=null?mallfeedback.feedback_time:''">
									</div>
								</div>
							<div class="hr-line-dashed"></div>
							   <div class="form-group">
									<label class="col-sm-2 control-label">反馈来源</label>
									<div class="col-sm-10">
										<select class="form-control m-b" name="source" disabled >
											<option value="1" v-bind:selected="mallfeedback!=null&&mallfeedback.source==1">APP</option>
											<option value="2" v-bind:selected="mallfeedback!=null&&mallfeedback.source==2">pc </option>
											<option value="3" v-bind:selected="mallfeedback!=null&&mallfeedback.source==2">M端 </option>
											<option value="4" v-bind:selected="mallfeedback!=null&&mallfeedback.source==2">微信 </option>
										</select>
									</div>
								</div>

							<div class="hr-line-dashed"></div>
							   <div class="form-group">
									<label class="col-sm-2 control-label">处理意见</label>
									<div class="col-sm-10">
										<input type="text" class="form-control" placeholder="处理意见" id="opinion" name="opinion" v-bind:value="mallfeedback!=null?mallfeedback.opinion:''">
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
	
	<script type="text/javascript">
		new Vue({
			el : "#vue",
			data : {mallfeedback:null},
			mounted : function(){
				var _this = this;
				$.post("mallfeedback/findMallFeedbackById.json?id="+$("#id").val(),function(data){
					for(var key in data){
						Vue.set(_this.$data,key,data[key]);
					}
				})
			},
			methods : {
				submit : function(){
					if (this.check_in()) {
						layer.load(0, {
							shade : 0.3
						});
						var url = "mallfeedback/saveMallFeedback.json";

						if ($("#id").val().trim()!=null&&$("#id").val().trim()!=''&&$("#id").val().trim()!='0') {
							url = "mallfeedback/updateMallFeedback.json";
						}
						$.post(url, $('#mallfeedback').serialize(), function(data) {
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
					if ($('#opinion').val().trim() == '') {
						layer.tips('处理意见！', '#opinion', {
							tips : [ 1, '#019F95' ],
							time : 1500
						});
						$('#opinion').focus();
						return false;
					}
					
					return true;
				}
			}
		})
		
	</script>


</body>


</html>