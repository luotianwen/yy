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
    

    <title>添加同义词</title>

    <link href="static/css/bootstrap.min.css" rel="stylesheet">
    <link href="static/css/font-awesome.min.css" rel="stylesheet">
    <link href="static/css/animate.min.css" rel="stylesheet">
    <link href="static/css/style.min.css" rel="stylesheet">
    <!-- iCheck -->
    <link href="static/css/plugins/iCheck/custom.css" rel="stylesheet">

</head>

<body class="gray-bg">
    <div class="wrapper wrapper-content animated fadeInRight">
		<div class="row">
			<div id="user-box" class="col-sm-12">
				<div class="ibox">
					<div class="ibox-content">
                        <form action="" id="synonymDic" method="post" class="form-horizontal">
                            <div class="form-group">
                                <label class="col-sm-2 control-label">同义词</label>
                                <div class="col-sm-10">
                                    <input type="text" class="form-control"  placeholder="同义词" id="synonym"  name="synonym" value="">
                                </div>
                            </div>
                            <div class="hr-line-dashed"></div>
                            <div class="form-group">
                                <label class="col-sm-2 control-label">转义词</label>
                                <div class="col-sm-10">
                                    <input type="text" class="form-control"  placeholder="转义词" id="escape"  name="escape" value="">
                                </div>
                            </div>
                            <div class="hr-line-dashed"></div>
                            <div class="form-group">
                                <label class="col-sm-2 control-label">词</label>
                                <div class="col-sm-10">
                                    <input type="text" class="form-control" disabled placeholder="词" id="word" value="">
                                </div>
                            </div>
                            <div class="hr-line-dashed"></div>
                            <div class="form-group">
                                <div class="col-sm-4 col-sm-offset-2">
                                    <a class="btn btn-primary" id="submit">添加</a>
                                    <a class="btn btn-white" id="cancel">取消</a>
                                </div>
                            </div>
                            <div class="form-group">
	                            <div class="alert alert-warning">
		                            <p class="text-warning">添加同义词说明，增加同义词请参照以下示例</p>
									<p class="text-danger">露营,扎营   （同义词）</p>
									<p class="text-danger">水上运动 => 潜水  （表示对似 ，水上运动进行是的转换，即纠错功能）</p>
									<p class="text-danger">露营,扎营 => 露营,扎营   （多对多）</p>
									<p class="text-danger">水上运动 => 潜水,游泳    （一对多）</p>
									<p class="text-danger">首都 => 北京             （一对一）</p>
									<p class="text-danger">使用英文逗号(,)</p>
		                        </div>
                            </div>
                        </form>
                    </div>
				</div>
			</div>
	 </div>
</div>
	<!-- 全局js -->
    <script src="static/js/jquery-2.1.1.min.js"></script>
    <script src="static/js/bootstrap.min.js"></script>
	<script src="static/js/plugins/layer/layer.js"></script>
    <!-- jQuery Validation plugin javascript-->
    <script src="static/js/plugins/validate/jquery.validate.min.js"></script>
    <script src="static/js/plugins/validate/messages_zh.min.js"></script>
    <!-- iCheck -->
    <script src="static/js/plugins/iCheck/icheck.min.js"></script>
    <script>
    var index = parent.layer.getFrameIndex(window.name); //获取窗口索引
		$(function() {
			 $(".i-checks").iCheck({
			    radioClass: "iradio_square-green",
			 });
	    });
					
					 $.validator.setDefaults({
					     highlight: function(a) {
					         $(a).closest(".form-group").removeClass("has-success").addClass("has-error");
					     },
					     success: function(a) {
					         a.closest(".form-group").removeClass("has-error").addClass("has-success");
					     },
					     errorElement: "span",
					     errorPlacement: function(a, b) {
					         if (b.is(":radio") || b.is(":checkbox")) {
					             a.appendTo(b.parent().parent().parent());
					         } else {
					             a.appendTo(b.parent());
					         }
					     },
					     errorClass: "help-block m-b-none",
					     validClass: "help-block m-b-none"
					 });
					 var err = "<i class='fa fa-times-circle'></i> ";
					 $().ready(function() {
					     
					     $("#synonymDic").validate({
					         rules: {
					             synonym: {
					                 required: true,
					                 minlength: 2,
					                 maxlength: 10,
					                 remote: {
					                	    url: "synonymDic/checkWord.html",     //后台处理程序
					                	    type: "post",               //数据发送方式
					                	    dataType: "json",           //接受数据格式    只能返回 "true" 或 "false"，不能有其他输出。
					                	    data: {                     //要传递的数据 
					                	    	synonym: function() {
					                	            return $("#synonym").val();
					                	        }
					                	    }
					                	}
					             },
					     		jp:{
					     			required: true
					     		},
					     		qp:{
					     			required: true
					     		},
					     		weight:{
					     			required: true
					     		},
					     		dic_type: {
					     			required: true
					     		}
					         },
					         messages: {
					        	 synonym: {
					                 required: err + "请输入词",
					                 minlength: err + "词必须两个字符以上",
					                 remote: err + "词已存在"
					             },
					             jp:{
					            	 required: err + "请输入简拼"
					             },
					             qp:{
					            	 required: err + "请输入全拼"
					             },
					             weight:{
					            	 required: err + "请输入权重"
					             },
						     	 dic_type: {
						     		required: err +"请选择词类型"
						     	 }
					         }
					     }); 
					 });				
					  
			 			//保存系统用户
			            $("#submit").on("click" , function(){
			            	 if($("#synonymDic").valid()){
			            		 var loadingIndex = 0;
			            		 $.ajax({
			            	            type:"POST",
			            	            url:"synonymDic/saveWord.html",
			            	            data:$("#synonymDic").serialize(),
			            	            datatype: "json",
			            	            //在请求之前调用的函数
			            	            beforeSend:function(){
			            	            	loadingIndex = layer.load(0, {shade: false}); //0代表加载的风格，支持0-2
			            	            },
			            	            //成功返回之后调用的函数             
			            	            success:function(data){
			            	            	layer.close(loadingIndex);
			            	            	if(data == true){
			            	            	    layer.msg("添加成功！", {icon: 1, time: 1000}, function(){
			            	            	    	//关闭后的操作
			            	            	    	parent.window.location.reload();
			            	            	    });
			            	            	}else{
			            	            		layer.alert("添加失败！", {icon: 0});
			            	            	}
				            	        },
			            	            error: function(){
			            	            	layer.close(loadingIndex);
			            	            	layer.alert("未知错误！", {icon: 0});
			            	            }         
			            	         });
			            	 }
			            }); 
			           
			 			//取消
			            $("#cancel").on("click" , function(){
			            	 parent.layer.close(index);
			            }); 
			 			
 
			            $('#synonym').bind('input propertychange', function() {
			            	synonym = $(this).val();
			            	escape = $("#escape").val();
			            	if(escape.length > 0){
			            		$("#word").val(synonym+" => "+escape);
			            	}else{
			            		$("#word").val(synonym);
			            	}
			            });			
			            $('#escape').bind('input propertychange', function() {
			            	escape = $(this).val();
			            	synonym = $("#synonym").val();
			            	if(escape.length > 0){
			            		$("#word").val(synonym+" => "+escape);
			            	}else{
			            		$("#word").val(synonym);
			            	}
			            });	
	</script>


</body>


</html>