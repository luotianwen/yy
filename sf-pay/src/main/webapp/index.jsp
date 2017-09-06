<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head><meta http-equiv="content-type" content="text/html;charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1" /><title>
	支付样例
</title>
    <style type="text/css">
        ul {
            margin-left:10px;
            margin-right:10px;
            margin-top:10px;
            padding: 0;
        }
        li {
            width: 45%;
            float: left;
            margin: 0px;
            margin-left:1%;
            padding: 0px;
            height: 100px;
            display: inline;
            line-height: 100px;
            color: #fff;
            font-size: x-large;
            word-break:break-all;
            word-wrap : break-word;
            margin-bottom: 5px;
            background-color: #00CD00;
        }
        a {
            -webkit-tap-highlight-color: rgba(0,0,0,0);
        	text-decoration:none;
            color:#fff;
        }
        a:link{
            -webkit-tap-highlight-color: rgba(0,0,0,0);
        	text-decoration:none;
            color:#fff;
        }
        a:visited{
            -webkit-tap-highlight-color: rgba(0,0,0,0);
        	text-decoration:none;
            color:#fff;
        }
        a:hover{
            -webkit-tap-highlight-color: rgba(0,0,0,0);
        	text-decoration:none;
            color:#fff;
        }
        a:active{
            -webkit-tap-highlight-color: rgba(0,0,0,0);
        	text-decoration:none;
            color:#fff;
        }
    </style>
</head>
<body>

	<div align="center">
		<h1>支付宝</h1>
        <ul>
            <li style="background-color:#FFCDDB"><a href="alipayDemo.jsp"  target="_blank">即时到账(PC)</a></li>
            <li style="background-color:#F64B7A"><a href="alipayWapDemo.jsp"  target="_blank">即时到账(WAP)</a></li>
        </ul>
	</div>
	<br /><br /><br /><br /><br /><br />
	
	<div align="center">
	<h1>微信</h1>
        <ul>
            <li style="background-color:#FF7F24"><a href="http://paysdk.weixin.qq.com/example/jsapi.php"  target="_blank">JSAPI支付</a></li>
            <li style="background-color:#698B22"><a href="http://paysdk.weixin.qq.com/example/micropay.php"  target="_blank">刷卡支付</a></li>
            <li style="background-color:#8B6914"><a href="http://paysdk.weixin.qq.com/example/native.php"  target="_blank">扫码支付</a></li>
            <li style="background-color:#CDCD00"><a href="http://paysdk.weixin.qq.com/example/orderquery.php"  target="_blank">订单查询</a></li>
            <li style="background-color:#CD3278"><a href="http://paysdk.weixin.qq.com/example/refund.php"  target="_blank">订单退款</a></li>
            <li style="background-color:#848484"><a href="http://paysdk.weixin.qq.com/example/refundquery.php"  target="_blank">退款查询</a></li>
            <li style="background-color:#8EE5EE"><a href="http://paysdk.weixin.qq.com/example/download.php"  target="_blank">下载订单</a></li>
            
            
        </ul>
	</div> 
</body>
</html>
