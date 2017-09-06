<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
    <title>404 页面</title>

</head>

<body class="gray-bg">


    <div class="middle-box text-center animated fadeInDown">
        <h1>404</h1>
        <h3 class="font-bold">页面未找到！</h3>

        <div class="error-desc">
            抱歉，页面好像去火星了~
             <br/>您可以返回主页看看
            <div class="autoback">还有<span style="color: #d60000" id="spTime">10</span>秒自动返回首页</div>
            <br/><a href="javascript:parent.location.href='${logout}'"  class="btn btn-primary m-t">主页</a>
        </div>
    </div>

    <!-- 全局js -->
    <script src="http://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js"></script>
    <script type="text/javascript">
        $(function () {
            var interval = setInterval(function () {
                var time = parseInt($("#spTime").text());
                time--;
                if (time <= 0) {
                    clearInterval(interval);
                    window.location.href = "${logout}";
                } else {
                    $("#spTime").text(time);
                }
            }, 1000);
        });
    </script>

</body>
</html>