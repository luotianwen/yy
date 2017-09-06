<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
  <head>
    <title>跳转到财付通确认支付页面</title>
    <meta charset="utf-8">
  </head>
  <body>
  	正在跳转至支付页面…………
  	${payHtml }
  	<script type="text/javascript">
  	window.location.href="${payHtml }"; 
  	</script>
  </body>
</html>