<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>世峰户外商城</title>
<script type="text/javascript" src="http://apps.bdimg.com/libs/jquery/1.8.0/jquery.js"></script>
<!-- <script src="http://res.wx.qq.com/connect/zh_CN/htmledition/js/wxLogin.js"></script> -->
</head>
<body>
 
<div id="login_container">

</div>
<!--   <script type="text/javascript">
 var obj = new WxLogin({
    id:"login_container", 
    appid: "wx9c31a0ba1c6a3321", 
    scope: "snsapi_login", 
    redirect_uri: "http%3a%2f%2fwww.seebong.com",
    state: "http%3a%2f%2fapi.winzhong.net",
    style: "black",
    href: ""
  });

</script>  -->


<c:if test="${not empty param.code}">
	<script type="text/javascript">
		var code = '${param.code}';
		var url = '${param.state}';
		if(url.indexOf("?") > 0){
			url = url+"&code="+code;
		}else{

			url = url+"?code="+code;
		}
		window.location.href= url;
	</script>
</c:if>

<c:if test="${empty param.code && not empty param.state}">
	<script type="text/javascript">
		var state = '${param.state}';
		window.location.href= state;
	</script>
</c:if>

</body>
</html>