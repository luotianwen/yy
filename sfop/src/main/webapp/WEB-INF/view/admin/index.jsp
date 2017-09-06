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
    <title>世峰户外商城-商城后台管理</title>

	<meta name="renderer" content="webkit|ie-comp|ie-stand">
    <!--[if lt IE 8]>
    <script>
        alert('已不支持IE6-8，请使用谷歌、火狐等浏览器\n或360、QQ等国产浏览器的极速模式浏览本页面！');
    </script>
    <![endif]-->

    <link href="static/css/bootstrap.min.css" rel="stylesheet">
    <link href="static/css/font-awesome.min.css" rel="stylesheet">
    <link href="static/css/animate.min.css" rel="stylesheet">
    <link href="static/css/style.min.css" rel="stylesheet">
    
    <style type="text/css">
		.notice {
			padding-left: -100px;
			padding-top: 12px;
			margin-bottom: 12px;
			border: 1px solid transparent;
			border-radius: 4px;
			margin-left: -50px;
		}
		
		.notice strong {
			font-size: 22px;
			color: red;
		}
		
		.notice ul li {
			width: auto;
			float: left;
			margin-right: 60px;
			line-height: 30px;
		}
		
		.notice ul li a {
			color: #0066ff;
			font-size: 14px;
			font-weight: bold;
		}
	</style>
    
</head>

<body class="fixed-sidebar full-height-layout gray-bg">


  
    <div style="display: none;" class="middle-box text-center lockscreen animated fadeInDown">
        <div>

            <h3>${users.uName }</h3>
            <p>您需要再次输入密码</p>
            <form class="m-t" role="form" action="">
                <div class="form-group">
                    <input type="password" class="form-control" placeholder="******" required="">
                </div>
                <button type="submit" class="btn btn-primary block full-width">登录到玩嘛后台管理系统</button>
            </form>
        </div>
    </div>


    <div id="wrapper" >


	<!--左侧导航开始-->
	  <jsp:include page="menu.jsp"></jsp:include>
	<!--左侧导航结束-->



        <!--右侧部分开始-->
        <div id="page-wrapper" class="gray-bg dashbard-1">
            <div class="row border-bottom">
            	<nav class="navbar navbar-static-top" role="navigation" style="margin-bottom: 0">
                    <div class="navbar-header" style="width: 80%">
                    	<a class="navbar-minimalize minimalize-styl-2 btn btn-primary " href="javaScript:void(0)"><i class="fa fa-bars"></i> </a>
                    </div>
                </nav>
            </div>
            <div class="row content-tabs">
                <button class="roll-nav roll-left J_tabLeft"><i class="fa fa-backward"></i>
                </button>
                <nav class="page-tabs J_menuTabs">
                    <div class="page-tabs-content">
                        <a href="javascript:;" class="active J_menuTab" data-id="operate/getPeratePage.html">首页</a>
                    </div>
                </nav>
                <button class="roll-nav roll-right J_tabRight"><i class="fa fa-forward"></i>
                </button>
                <div class="btn-group roll-nav roll-right">
                    <button class="dropdown J_tabClose" data-toggle="dropdown">关闭操作<span class="caret"></span>

                    </button>
                    <ul role="menu" class="dropdown-menu dropdown-menu-right">
                        <li class="J_tabShowActive"><a>定位当前选项卡</a>
                        </li>
                        <li class="divider"></li>
                        <li class="J_tabCloseAll"><a>关闭全部选项卡</a>
                        </li>
                        <li class="J_tabCloseOther"><a>关闭其他选项卡</a>
                        </li>
                    </ul>
                </div>
                <a href="login/logout.html" class="roll-nav roll-right J_tabExit"><i class="fa fa fa-sign-out"></i> 退出</a>
            </div>
            <div class="row J_mainContent" id="content-main">
               <iframe class="J_iframe" name="iframe0" width="100%" height="100%"  frameborder="0"   seamless></iframe>
            </div>
            <div class="footer">
                <div class="pull-right">&copy; 2017 北京慧斓美国际商贸有限公司
                </div>
            </div>
        </div>
        <!--右侧部分结束-->
    </div>
    
    <!-- 全局js -->
    <script src="static/js/jquery-2.1.1.min.js"></script>
    <script src="static/js/jquery.cookie.js"></script>
    <script src="static/js/bootstrap.min.js"></script>
    <script src="static/js/plugins/metisMenu/jquery.metisMenu.js"></script>
    <script src="static/js/plugins/slimscroll/jquery.slimscroll.min.js"></script>
    <script src="static/js/plugins/layer/layer.min.js"></script>

    <!-- 自定义js -->
    <script src="static/js/hplus.min.js"></script> 
    <script type="text/javascript" src="static/js/contabs.min.js"></script>

<SCRIPT language=javascript>
    if(self.location != top.location)
    {
        top.location="/login/check";
    }
/*
var expiresDate= new Date();
expiresDate.setTime(expiresDate.getTime() + (25 * 60 * 1000));
$.cookie("online_status", "online", {
  path : '/',//cookie的作用域
  expires : expiresDate
 });
$.cookie("online_status");
setInterval(function(){  
	//alert(document.visibilityState);
},5000);  
//各种浏览器兼容
var hidden, state, visibilityChange; 
if (typeof document.hidden !== "undefined") {
hidden = "hidden";
visibilityChange = "visibilitychange";
state = "visibilityState";
} else if (typeof document.mozHidden !== "undefined") {
hidden = "mozHidden";
visibilityChange = "mozvisibilitychange";
state = "mozVisibilityState";
} else if (typeof document.msHidden !== "undefined") {
hidden = "msHidden";
visibilityChange = "msvisibilitychange";
state = "msVisibilityState";
} else if (typeof document.webkitHidden !== "undefined") {
hidden = "webkitHidden";
visibilityChange = "webkitvisibilitychange";
state = "webkitVisibilityState";
} // 添加监听器，在title里显示状态变化
document.addEventListener(visibilityChange, function() {
document.title = document[state];
}, false); // 初始化
document.title = document[state]; */
</script>
</body>


</html>