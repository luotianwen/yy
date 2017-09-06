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
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    

    <title>发送短信通知</title>

    <link href="static/css/bootstrap.min.css" rel="stylesheet">
    <link href="static/css/animate.min.css" rel="stylesheet">
	<link href="static/css/style.min.css" rel="stylesheet">
    <link href="static/css/layerdate/layerdate.css" rel="stylesheet">
    <!-- iCheck -->
    <link href="static/css/plugins/iCheck/custom.css" rel="stylesheet">

</head>

<body class="gray-bg">
    <div class="wrapper wrapper-content animated fadeInRight" id="vue">
		<div class="row">
			<div id="user-box" class="col-sm-12">
				<div class="ibox">
					<div class="ibox-content">
                        <form action="" id="sms" method="post" class="form-horizontal">
                        	<div class="form-group">
                                <label class="col-sm-2 control-label">卡号</label>

                                <div class="col-sm-10">
                                    <input type="number" readonly="readonly" class="form-control" placeholder="卡号" id="number"  name="number" value="${id }">
                                </div>
                            </div>
                            <div class="hr-line-dashed"></div>
                        	
                            <div class="form-group">
                                <label class="col-sm-2 control-label">手机号</label>

                                <div class="col-sm-10">
                                    <input type="number" class="form-control" placeholder="手机号" id="phone"  name="phone" >
                                </div>
                            </div>
                            <div class="hr-line-dashed"></div>
                            
                            <div class="form-group">
                                <label class="col-sm-2 control-label">短信备注</label>

                                <div class="col-sm-10">
                                	<textarea id="sendremark" name="sendremark" maxlength="200" class="form-control" placeholder="短信备注"></textarea>
                                </div>
                            </div>
                            <div class="hr-line-dashed"></div>
                            
                            <div class="form-group">
                                <div class="col-sm-4 col-sm-offset-2">
                                    <a class="btn btn-primary" id="submit" @click="submit">保存内容</a>
                                    <a class="btn btn-white" id="cancel" onclick="parent.layer.close(parent.layer.getFrameIndex(window.name))">取消</a>
                                </div>
                            </div>
                        </form>
                    </div>
				</div>
			</div>
	 </div>
</div>
	<!-- 全局js -->
	<script src="static/js/vue.js"></script>
	<script src="static/js/jquery-2.1.1.min.js"></script>
	<script src="static/js/bootstrap.min.js"></script>
	<script src="static/js/plugins/layer/layer.min.js"></script>
	<!-- iCheck -->
	<script src="static/js/plugins/iCheck/icheck.min.js"></script>
    
    <script type="text/javascript">
    	new Vue({
    		el : "#vue",
			methods : {
				submit : function(){
					if(check_in()){
			            $.post("card/updateCardSMS",$('#sms').serialize(),function(data){
			                if(data.RESPONSE_STATE == '200'){
			                    layer.msg('发送短信成功',{icon:1,time:1*1000},function(){
			                        parent.self.location.reload();
			                    });
			                }else{
			                    layer.closeAll('loading');
			                    layer.alert(data.ERROR_INFO,{icon:0});
			                }
			            });
			        }
				}
			}
    	})
    	
	    function check_in(){
	    	if($('#number').val().trim() == ''){
        		layer.tips('卡号不能为空！！！', '#number', {
				    tips: [1, '#019F95'],
				    time: 1500
				});
				$('#number').focus();
				return false;
        	}
	    	if($('#phone').val().trim() == ''){
        		layer.tips('手机号不能为空！！！', '#phone', {
				    tips: [1, '#019F95'],
				    time: 1500
				});
				$('#phone').focus();
				return false;
        	}
	    	if($('#sendremark').val().trim() == ''){
        		layer.tips('短信备注不能为空！！！', '#sendremark', {
				    tips: [1, '#019F95'],
				    time: 1500
				});
				$('#sendremark').focus();
				return false;
        	}
	    	
	    	var re= /^(((13[0-9]{1})|(15[0-9]{1})|(18[0-9]{1})|(17[0-9]{1}))+\d{8})$/;
			if(!re.test($('#phone').val().trim())){
				layer.tips('手机号码格式不正确！！！', '#phone', {
				    tips: [1, '#019F95'],
				    time: 1500
				});
				$('#phone').focus();
				return false;
			}
	    	
	        return true;
	    }
	</script>


</body>


</html>