<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<script type="text/javascript" src="http://apps.bdimg.com/libs/jquery/1.8.0/jquery.js"></script>
<script type="text/javascript" src="js/jquery.qrcode.min.js"></script>
<body>
<div id="qrcode"></div>
<script type="text/javascript">
//qrcode支持canvas和table两种方式进行图片渲染，默认使用canvas方式，效率最高
window.onload = function() {
    if (window.applicationCache) {
    	//浏览器支持html5   canvas
    	$('#qrcode').qrcode({
    		width: 200,
    		height: 200,
    		text: "weixin://wxpay/bizpayurl?pr=enZgi47"
    	});
    } else {
    	//浏览器不支持html5   table
    	$('#qrcode').qrcode({
    		render: "table", 
    		width: 200,
    		height: 200,
    		text: "weixin://wxpay/bizpayurl?pr=enZgi47"
    	});
    }
}
	
</script>
</body>
</html>