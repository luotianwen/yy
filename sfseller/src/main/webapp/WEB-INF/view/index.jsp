<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>世峰户外商城-商家后台</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="世峰户外商城">
	
	<jsp:include page="basecss.jsp"></jsp:include>

    <!-- The HTML5 shim, for IE6-8 support of HTML5 elements -->
    <!--[if lt IE 9]>
    <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->

    <!-- The fav icon -->
    <link rel="shortcut icon" href="static/img/favicon.ico">

</head>

<body>
<!-- topbar starts -->
<div class="navbar navbar-default" role="navigation">

    <div class="navbar-inner">
        <button type="button" class="navbar-toggle pull-left animated flip">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
        </button>
        <a class="navbar-brand" href="index.html"> <img alt="商家后台管理" src="static/img/s-img/logo.png" class="hidden-xs" /></a>

        <!-- user dropdown starts -->
        <div class="btn-group pull-right">
            <button class="btn btn-default dropdown-toggle" data-toggle="dropdown">
                <i class="glyphicon glyphicon-user"></i><span class="hidden-sm hidden-xs"> ${sessionScope.SELLER_SESSION_USER.uName}</span>
                <span class="caret"></span>
            </button>
            <ul class="dropdown-menu">
               <%-- <li>
                    <a href="static/#">Profile</a>
                </li>
                <li class="divider"></li>--%>
                <li>
                    <a href="/login/logout">Logout</a>
                </li>
            </ul>
        </div>
        <!-- user dropdown ends -->

        <!-- theme selector starts -->
        <div class="btn-group pull-right theme-container animated tada">
            <button class="btn btn-primary noty" data-noty-options="{&quot;text&quot;:&quot;This is an error notification&quot;,&quot;layout&quot;:&quot;topRight&quot;,&quot;type&quot;:&quot;error&quot;}">
                <i class="glyphicon glyphicon-bell icon-white"></i> 消息
            </button>

        </div>

    </div>
</div>
<!-- topbar ends -->
<div class="ch-container">
    <div class="row">

        <!-- left menu starts -->
        <jsp:include page="left.jsp"></jsp:include>
        <!-- left menu ends -->

        <noscript>
            <div class="alert alert-block col-md-12">
                <h4 class="alert-heading">Warning!</h4>

                <p>You need to have <a href="static/http://en.wikipedia.org/wiki/JavaScript" target="_blank">JavaScript</a>
                    enabled to use this site.</p>
            </div>
        </noscript>

        <div id="content" class="col-lg-10 col-sm-10">
        </div>
    </div>
    <!-- Ad ends -->
	<jsp:include page="footer.jsp"></jsp:include>
</div>
<jsp:include page="basejs.jsp"></jsp:include>
<script>
	$(function () {
		$.post("indexContent",function(data){
			$("#content").html(data);
		});
	})
</script>
</body>

</html>
