<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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


<title>户外门户 - 系统用户编辑</title>

<link href="static/css/bootstrap.min.css" rel="stylesheet">
<link href="static/css/font-awesome.min.css" rel="stylesheet">
<link href="static/css/animate.min.css" rel="stylesheet">

<link href="static/css/style.min.css" rel="stylesheet">
<!-- iCheck -->
<link href="static/css/plugins/iCheck/custom.css" rel="stylesheet">

</head>

<body class="gray-bg">
	<div class="wrapper wrapper-content animated fadeInRight">
		<div class="row">
			<div id="user-box" class="col-sm-12">
				<div class="ibox">
					<div class="ibox-content">
						<form action="" id="userForm" method="post" class="form-horizontal">
							<div id="vue">
								<input type="hidden" name="uId" id="uId" value="${userId}">
								<div class="form-group">
									<label class="col-sm-2 control-label">用户名</label>
	
									<div class="col-sm-10">
										<input v-if="user!=null" type="text" class="form-control" placeholder="用户名" id="uName" name="uName" v-bind:value="user!=null?user.uName:''">
										<input v-else type="text" class="form-control" placeholder="用户名" id="uName" name="uName">
									</div>
								</div>
								<div class="hr-line-dashed"></div>
								
	                            <div class="form-group">
	                                <label class="col-sm-2 control-label">性别</label>
	
	                                <div class="col-sm-10">
	                                	<label>
	                                    	<input type="radio" :checked="user==null||user.uSex==1" value="1" name="uSex" class="radio i-checks"> <i></i> 男
	                                    </label>
	                                           &nbsp;&nbsp;&nbsp;
	                                	<label>
	                                		<input type="radio" :checked="user!=null&&user.uSex==1" value="2" name="uSex" class="radio i-checks"> <i></i> 女
	                                	</label>
	                                </div>
	                            </div>
	                            <div class="hr-line-dashed"></div>
	                            <div class="form-group">
	                                <label class="col-sm-2 control-label">邮箱</label>
	
	                                <div class="col-sm-10">
	                                    <input type="text" class="form-control" placeholder="邮箱" name="uEmail" id="uEmail" :value="user!=null?user.uEmail:''">
	                                </div>
	                            </div>
	                            <div class="hr-line-dashed"></div>
	                            
	                            <div class="form-group">
	                                <label class="col-sm-2 control-label">手机</label>
	
	                                <div class="col-sm-10">
	                                    <input type="text" class="form-control" placeholder="手机" name="uPhone" id="uPhone" :value="user!=null?user.uPhone:''">
	                                </div>
	                            </div>
								<div class="hr-line-dashed"></div>
								
								<div v-if="user!=null">
									<div class="form-group">
										<label class="col-sm-2 control-label">密码</label>
	
										<div class="col-sm-10">
											<input type="password" class="form-control" placeholder="留空为不修改密码" name="newPassword">
										</div>
									</div>
									<div class="hr-line-dashed"></div>
	
									<div class="form-group">
										<label class="col-sm-2 control-label">注册时间</label>
	
										<div class="col-sm-10">
											<p class="form-control-static">{{user.uCreateTime }}</p>
										</div>
									</div>
									<div class="hr-line-dashed"></div>
								</div>
	
								<div v-else>
									<div class="form-group">
										<label class="col-sm-2 control-label">密码</label>
	
										<div class="col-sm-10">
											<input type="password" autocomplete="off" class="form-control" placeholder="输入密码" id="uPassword" name="uPassword">
										</div>
									</div>
									<div class="hr-line-dashed"></div>
	
									<div class="form-group">
										<label class="col-sm-2 control-label">密码确认</label>
	
										<div class="col-sm-10">
											<input type="password" class="form-control" placeholder="再次输入密码" name="checkPassword">
										</div>
									</div>
									<div class="hr-line-dashed"></div>
								</div>
							</div>

							<div class="form-group" id="arrays">
								<label class="col-sm-2 control-label">角色分组</label>

								<div class="col-sm-5">
									<select data-placeholder="选择分组..." class="form-control m-b" id="group" @change="group">
										<option value>选择分组...</option>
										<option v-for="array in arrays" v-bind:value="array!=null?array.AID:''" v-bind:selected="(user!=null&&user.aId==array.AID)||(user==null&&aId==array.AID)">{{array.ANAME}}</option>
									</select>
								</div>
								<div class="col-sm-5">
									<select data-placeholder="选择角色..." class="form-control m-b" id="role" name="rId">
										<option value>选择角色...</option>
										<option v-for="role in roles" v-bind:value="role!=null?role.RID:''" v-bind:selected="user!=null&&user.rId==role.RID">{{role.RNAME}}</option>
									</select>
								</div>
							</div>
							<div class="hr-line-dashed"></div>
							<div class="form-group" id="submit">
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
	<script src="static/js/plugins/validate/jquery.validate.min.js"></script>
	<script src="static/js/plugins/validate/messages_zh.min.js"></script>
	<!-- iCheck -->
	<script src="static/js/plugins/iCheck/icheck.min.js"></script>
	
	<script type="text/javascript">
		var arrays = new Vue({
			el : "#arrays",
			data : {user:null,arrays:null,roles:null,aId:''},
			methods : {
				group : function(){
					var _this = this;
					var aId = $("#group").val();
					if(vue.user!=null){
						Vue.set(vue.user,"aId",aId);
					}else{
						_this.aId = aId;
					}
					
					$.post("roles/getSysRole/" + aId + ".html", function(data) {
						_this.roles = data;
					});
				}
			}
		})
	
		var vue = new Vue({
			el : "#vue",
			data : {user:null},
			created : function(){
				var _this = this;
				$.post("user/findUserById.html?userId="+$("#uId").val(),function(data){
					Vue.set(_this.$data,"user",data.user);
					Vue.set(arrays.$data,"user",data.user);
					Vue.set(arrays.$data,"arrays",data.arrays);
					Vue.set(arrays.$data,"roles",data.roles);
				})
			}
		})
		
		new Vue({
			el : "#submit",
			methods : {
				submit : function(){
					if ($("#userForm").valid()) {
						var loadingIndex = 0;
						$.ajax({
							type : "POST",
							url : "user/addSysUser.html",
							data : $("#userForm").serialize(),
							datatype : "json",
							//在请求之前调用的函数
							beforeSend : function() {
								loadingIndex = layer.load(0, {
									shade : false
								}); //0代表加载的风格，支持0-2
							},
							//成功返回之后调用的函数             
							success : function(data) {

								layer.close(loadingIndex);
								if (data.RESPONSE_STATE == "200") {
									layer.msg("保存成功！", {
										icon : 1,
										time : 1000
									}, function() {
										//关闭后的操作
										parent.window.location.reload();//$("#sysUser").submit();
									});
								} else {
									layer.alert(data.ERROR_INFO, {
										icon : 0
									});
								}
							},
							error : function() {
								layer.close(loadingIndex);
								layer.alert("未知错误！", {
									icon : 0
								});
							}
						});
					}
				}
			}
		})
		
		var index = parent.layer.getFrameIndex(window.name); //获取窗口索引
		$(function() {
			$(".i-checks").iCheck({
				radioClass : "iradio_square-green",
			});
		});
		
		$.validator.setDefaults({
			highlight : function(a) {
				$(a).closest(".form-group").removeClass("has-success").addClass("has-error");
			},
			success : function(a) {
				a.closest(".form-group").removeClass("has-error").addClass("has-success");
			},
			errorElement : "span",
			errorPlacement : function(a, b) {
				if (b.is(":radio") || b.is(":checkbox")) {
					a.appendTo(b.parent().parent().parent());
				} else {
					a.appendTo(b.parent());
				}
			},
			errorClass : "help-block m-b-none",
			validClass : "help-block m-b-none"
		});
		var err = "<i class='fa fa-times-circle'></i> ";
		// 密码验证，以字母开头，长度在8-15之间，密码至少包含一个大写字母、一个小写字母。
		jQuery.validator.addMethod("passwordCheck",function(value, element) {
			return this.optional(element)|| /^(?=^.{8,15}$)((?=.*\d)|(?=.*\W+))(?![.\n])(?=.*[A-Z])(?=.*[a-z]).*$/.test(value);
		}, err + "密码至少包含一个大写字母、一个小写字母，长度至少8位");
		//手机号码验证   
		jQuery.validator.addMethod("mobileCheck",function(value, element) {
			var length = value.length;
			var mobile = /^(((13[0-9]{1})|(15[0-9]{1})|(18[0-9]{1})|(17[0-9]{1}))+\d{8})$/;
			return this.optional(element) || (length == 11 && mobile.test(value));
		}, err + "请填写正确的手机号码");
		$().ready(function() {
			$("#userForm").validate({
				rules : {
					uName : {
						required : true,
						minlength : 2,
						maxlength : 10
					},
					uEmail : {
						required : true,
						email : true
					},
					uPhone : {
						required : true,
						mobileCheck : true
					},
					uPassword : {
						required : true,
						passwordCheck : true
					},
					newPassword : {
						required : false,
						passwordCheck : true
					},
					checkPassword : {
						required : true,
						rangelength : [ 8, 15 ],
						equalTo : "#uPassword"
					},
					uSex : {
						required : true
					},
					rId : {
						required : true
					}
				},
				messages : {
					uName : {
						required : err + "请输入您的用户名",
						minlength : err + "用户名必须两个字符以上"
					},
					uEmail : {
						required : err + "请输入邮箱",
						email : "请输入正确格式的邮箱"
					},
					checkPassword : {
						required : err + "请输入确认密码",
						rangelength : err + "确认密码不能小于8个字符",
						equalTo : err + "两次输入密码不一致"
					},
					uSex : {
						required : err + "请选择性别"
					},
					uPhone : {
						required : err + "请输入手机号码"
					},
					uPassword : {
						required : err + "请输入密码"
					},
					rId : {
						required : err + "请选择角色"
					}
				}
			});
		});

	</script>


</body>


</html>