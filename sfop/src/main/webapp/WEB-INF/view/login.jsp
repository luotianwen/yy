<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>

<head>
    <base href="<%=basePath%>">

    <title> 管理系统  </title>
    
	<meta name="renderer" content="webkit|ie-comp|ie-stand">
	<meta http-equiv="X-UA-Compatible" content="IE=edge;chrome=1">
    <link href="static/css/bootstrap.min.css" rel="stylesheet">
    <link href="static/css/font-awesome.min.css" rel="stylesheet">
    <link href="static/css/animate.min.css" rel="stylesheet">
    <link href="static/css/login.min.css" rel="stylesheet">
    <script>if(window.top !== window.self){ window.top.location = window.location;}</script>
	<style type="text/css">
	.layui-layer-title{
		background-color: #F8F4ED !important;
	}
	.layui-layer-content{
		color:black !important; 
	}
	</style>
</head>

<body class="signin">
    <div class="signinpanel">
        <div class="row">
            <div class="col-sm-7">
                  没有权限 请联系管理员
                <a href="login/logout.html">重新登录</a>
            </div>

        </div>
        <div class="signup-footer">
            <div class="pull-left">
                &copy; 2011 All Rights Reserved. 世峰户外商城
            </div>
        </div>
    </div>
</body>




                    
</html>