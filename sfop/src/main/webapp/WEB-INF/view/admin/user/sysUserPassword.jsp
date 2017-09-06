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
    

    <title>密码修改</title>

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
                        <form action="" id="userPwd" method="post" class="form-horizontal">
                            <div class="form-group">
                                <label class="col-sm-2 control-label">旧密码</label>

                                <div class="col-sm-10">
                                    <input type="password" class="form-control" placeholder="输入旧密码"  name="uPassword">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-2 control-label">新密码</label>

                                <div class="col-sm-10">
                                    <input type="password" autocomplete="off" class="form-control" placeholder="输入新密码" id="newPassword" name="newPassword">
                                </div>
                            </div>
                            <div class="hr-line-dashed"></div>
                            <div class="form-group">
                                <label class="col-sm-2 control-label">新密码确认</label>

                                <div class="col-sm-10">
                                    <input type="password" class="form-control" placeholder="再次输入新密码"  name="checkPassword">
                                </div>
                            </div>
                           
                            <div class="hr-line-dashed"></div>
                            <div class="form-group">
                                <div class="col-sm-4 col-sm-offset-2">
                                    <a class="btn btn-primary" id="submit">修改密码</a>
                                </div>
                            </div>
                        </form>
                    </div>
				</div>
			</div>
	 </div>
</div>
	<!-- 全局js -->
    <script src="static/js/jquery-2.1.1.min.js"></script>
    <script src="static/js/bootstrap.min.js"></script>
	<script src="static/js/plugins/layer/layer.min.js"></script>
    <!-- jQuery Validation plugin javascript-->
    <script src="static/js/plugins/validate/jquery.validate.min.js"></script>
    <script src="static/js/plugins/validate/messages_zh.min.js"></script>
    <!-- iCheck -->
    <script src="static/js/plugins/iCheck/icheck.min.js"></script>
    <script>
					
					 $.validator.setDefaults({
					     highlight: function(a) {
					         $(a).closest(".form-group").removeClass("has-success").addClass("has-error");
					     },
					     success: function(a) {
					         a.closest(".form-group").removeClass("has-error").addClass("has-success");
					     },
					     errorElement: "span",
					     errorPlacement: function(a, b) {
					         if (b.is(":radio") || b.is(":checkbox")) {
					             a.appendTo(b.parent().parent().parent());
					         } else {
					             a.appendTo(b.parent());
					         }
					     },
					     errorClass: "help-block m-b-none",
					     validClass: "help-block m-b-none"
					 });
					 var err = "<i class='fa fa-times-circle'></i> ";
					 // 密码验证，以字母开头，长度在8-15之间，密码至少包含一个大写字母、一个小写字母。
					 jQuery.validator.addMethod("passwordCheck", function(value, element) {       
						 return this.optional(element) || /^(?=^.{8,15}$)((?=.*\d)|(?=.*\W+))(?![.\n])(?=.*[A-Z])(?=.*[a-z]).*$/.test(value);
					 }, err+"密码至少包含一个大写字母、一个小写字母，长度至少8位"); 
					 $().ready(function() {
					     
					     $("#userPwd").validate({
					         rules: {
					     		uPassword:{
					     			required: true,
					     			/* passwordCheck:true */
					     		},
					     		newPassword:{
					     			required: true,
					     			passwordCheck:true
					     		},
					     		checkPassword:{
					     			required: true,
					     			rangelength: [8, 15],
					     			equalTo: "#newPassword"
					     		} 
					         },
					         messages: {
					             checkPassword: {  
				                        required: err +"请输入确认密码",  
				                        rangelength: err +"确认密码不能小于8个字符",  
				                        equalTo: err +"两次输入密码不一致"  
				                  },
				                  newPassword:{
						     			required: err +"请输入密码"
						     	  } ,
						     	  uPassword:{
						     			required: err +"请输入密码"
						     	  } 
					         }
					     }); 
					 });				
					  
			 			//保存系统用户
			            $("#submit").on("click" , function(){
			            	 if($("#userPwd").valid()){
			            		 $.ajax({
			            	            type:"POST",
			            	            url:"user/updateSysUserPassword.html",
			            	            data:$("#userPwd").serialize(),
			            	            datatype: "json",
			            	            success:function(data){
			            	            	
			            	            	if(data.result == "true"){
			            	            	    layer.msg(data.msg, {icon: 1, time: 1000});
			            	            	}else{
			            	            		layer.alert(data.msg, {icon: 0});
			            	            	}
				            	        },
			            	            error: function(){
			            	            	layer.alert("未知错误！", {icon: 0});
			            	            }         
			            	         });
			            	 }
			            }); 
			          

	</script>


</body>


</html>