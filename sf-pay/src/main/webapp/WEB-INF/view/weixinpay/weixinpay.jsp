<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>微信支付</title>
<script type="text/javascript" src="http://apps.bdimg.com/libs/jquery/1.8.0/jquery.js"></script>
<script type="text/javascript" src="js/jquery.qrcode.min.js"></script>
</head>
<body style="width: 200px;height: 200px;">
	<div id="qrcode"></div>
	<script type="text/javascript">
		//qrcode支持canvas和table两种方式进行图片渲染，默认使用canvas方式，效率最高
		window.onload = function() {
			if (window.applicationCache) {
				//浏览器支持html5   canvas
				$('#qrcode').qrcode({
					width : 200,
					height : 200,
					text : "${payRes.code_url}"
				});
			} else {
				//浏览器不支持html5   table
				$('#qrcode').qrcode({
					render : "table",
					width : 200,
					height : 200,
					text : "${payRes.code_url}"
				});
			}
		}

		var order_id = "${order_id}";
		var order_type = "${order_type}";
		var task = setInterval(getOrderPayResult, 1000);
		var count = 0;
		function getOrderPayResult() {
			if(count == 60){
				alert("支付超时,如果您已支付请到我的订单中查看");
				clearInterval(task);
			}
			$.ajax({
				type : "get",
				url : "order/payResult.json",
				data : {
					order_id : order_id,
					order_type : order_type
				},
				success : function(data) {
					if (data != null && data != "") {
						clearInterval(task);
						if(data.trade_status == 0){
							//alert("支付成功，支付金额："+data.total_fee);
							windows.parent.loaction.href = data.return_url;
						}else{
							alert("支付失败");
						}
						
					}
				},
				error : function() {

				}
			});
			
			count++;
		}
	</script>
</body>
</html>