<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<% 

//收款方
String spname = "财付通双接口测试";  

//商户号
String partner = "1217890901";

//密钥
String key = "9528f1166256f69ab7a8ede80a596318";

//交易完成后跳转的URL
String return_url = "http://localhost:7777/sf-pay/tenpay/payReturnUrl.jsp";

//接收财付通通知的URL
String notify_url = "http://localhost:7777/sf-pay/tenpay/payNotifyUrl.jsp";

%>
