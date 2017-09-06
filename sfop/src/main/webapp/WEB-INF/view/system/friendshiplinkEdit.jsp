<%@ taglib prefix="v-validate" uri="http://www.springframework.org/tags/form" %>
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
						<form id="friendshiplink" method="post" class="form-horizontal">
							<input type="hidden" id="id" name="id" value="${id}"/>
							
							   <div class="form-group">
									<label class="col-sm-2 control-label">名称</label>
									<div class="col-sm-10">
										<input type="text"   class="form-control" placeholder="名称" id="name" name="name" :value="friendshiplink!=null?friendshiplink.name:''">
									</div>
								</div>

							   <div class="form-group">
									<label class="col-sm-2 control-label">发布状态</label>
									<div class="col-sm-10">
										<select class="form-control m-b" name="state"  >
											<option value="1" v-bind:selected="friendshiplink!=null&&friendshiplink.state==1">发布</option>
											<option value="2" v-bind:selected="friendshiplink!=null&&friendshiplink.state==2">下线</option>
										</select>
									</div>
								</div>
							<div class="hr-line-dashed"></div>
							   <div class="form-group">
									<label class="col-sm-2 control-label">备注</label>
									<div class="col-sm-10">
										<input type="text" class="form-control" placeholder="备注" id="note" name="note" :value="friendshiplink!=null?friendshiplink.note:''">
									</div>
								</div>

							   <div class="form-group">
									<label class="col-sm-2 control-label">链接</label>
									<div class="col-sm-10">
										<input type="text"    class="form-control" placeholder="链接" id="link" name="link" :value="friendshiplink!=null?friendshiplink.link:''">

									</div>
								</div>
							<div class="hr-line-dashed"></div>
							   <div class="form-group">
									<label class="col-sm-2 control-label">发布日期</label>
									<div class="col-sm-10">
										<input type="text" class="form-control"   readonly placeholder="发布日期" id="releaseDate" name="releaseDate" :value="friendshiplink!=null?friendshiplink.releaseDate:''">
									</div>
								</div>

							   <div class="form-group">
									<label class="col-sm-2 control-label">联系人</label>
									<div class="col-sm-10">
										<input type="text" class="form-control"    placeholder="联系人" id="contacts" name="contacts" :value="friendshiplink!=null?friendshiplink.contacts:''">

									</div>
								</div>
							<div class="hr-line-dashed"></div>
							   <div class="form-group">
									<label class="col-sm-2 control-label">联系人电话</label>
									<div class="col-sm-10">
										<input type="text"    class="form-control" placeholder="联系人电话" id="phone" name="phone" :value="friendshiplink!=null?friendshiplink.phone:''">

									</div>
								</div>

							   <div class="form-group">
									<label class="col-sm-2 control-label">联系人邮箱</label>
									<div class="col-sm-10">
										<input type="text"   class="form-control" placeholder="联系人邮箱" id="email" name="email" :value="friendshiplink!=null?friendshiplink.email:''">

									</div>
								</div>
							<div class="form-group">
								<div class="col-sm-4 col-sm-offset-2">
									<a class="btn btn-primary" id="submit"   @click="submit">保存内容</a>
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
			data : {friendshiplink:null},
			mounted : function(){
				var _this = this;
				$.post("friendshiplink/findFriendshipLinkById.json?id="+$("#id").val(),function(data){
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
				submit : function(){
						 if (this.check_in()) {
						layer.load(0, {
							shade : 0.3
						});
						var url = "friendshiplink/saveFriendshipLink.json";
						if ($("#id").val().trim()!=null&&$("#id").val().trim()!=''&&$("#id").val().trim()!='0') {
							url = "friendshiplink/updateFriendshipLink.json";
						}
						$.post(url, $('#friendshiplink').serialize(), function(data) {
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
					if ($('#name').val().trim() == '') {
						layer.tips('名称必填！', '#name', {
							tips : [ 1, '#019F95' ],
							time : 1500
						});
						$('#name').focus();
						return false;
					}
					var link=$('#link').val().trim();
					if (link == '') {
						layer.tips('链接必填！', '#link', {
							tips : [ 1, '#019F95' ],
							time : 1500
						});
						$('#link').focus();
						return false;
					}
					
					if(!/^(http|https):\/\/[\w\-_]+(\.[\w\-_]+)+([\w\-\.,@?^=%&amp;:/~\+#]*[\w\-\@?^=%&amp;/~\+#])?/.test(link)){
						layer.tips('请输入正确的链接！如：http://xxx.xxx', '#link', {
							tips : [ 1, '#019F95' ],
							time : 1500
						});
						$('#link').focus();
						return false;
					}
					if ($('#releaseDate').val().trim() == '') {
						layer.tips('发布日期必填！', '#releaseDate', {
							tips : [ 1, '#019F95' ],
							time : 1500
						});
						$('#releaseDate').focus();
						return false;
					}if ($('#contacts').val().trim() == '') {
						layer.tips('联系人必填！', '#contacts', {
							tips : [ 1, '#019F95' ],
							time : 1500
						});
						$('#contacts').focus();
						return false;
					}
					//  /^(([^<>()[\]\\.,;:\s@\"]+(\.[^<>()[\]\\.,;:\s@\"]+)*)|(\".+\"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/.test(val)
					
					var mobile = /^(13[0-9]{9})|(18[0-9]{9})|(14[0-9]{9})|(17[0-9]{9})|(15[0-9]{9})$/;
					var phone = /^0\d{2,3}-\d{5,10}$/;
					if (!(mobile.test($('#phone').val()) || phone.test($('#phone').val()))) {
						layer.tips('请输入正确的手机/座机号！', '#phone', {
							tips : [ 1, '#019F95' ],
							time : 1500
						});
						$('#phone').focus();
						return false;
					}
					return true;
				}
			}
		})

	</script>


</body>


</html>