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
    

    <title>户外门户 - 系统用户编辑</title>

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
                        <form action="" id="dictionary" method="post" class="form-horizontal">
                        	<input type="hidden" name="id" id="id" value="${dictionary.id }">
                            <div class="form-group">
                                <label class="col-sm-2 control-label">词</label>
                                <div class="col-sm-10">
                                    <input type="text" class="form-control"  placeholder="词" id="word"  name="word" value="${dictionary.word }">
                                </div>
                            </div>
                            <div class="hr-line-dashed"></div>
                            <div class="form-group">
                                <label class="col-sm-2 control-label">简拼</label>
                                <div class="col-sm-10">
                                    <input type="text" class="form-control"  placeholder="简拼" id="jp"  name="jp" value="${dictionary.jp }">
                                </div>
                            </div>
                            <div class="hr-line-dashed"></div>
                            <div class="form-group">
                                <label class="col-sm-2 control-label">全拼</label>
                                <div class="col-sm-10">
                                    <input type="text" class="form-control"  placeholder="全拼" id="qp"  name="qp" value="${dictionary.qp }">
                                </div>
                            </div>
                            <div class="hr-line-dashed"></div>
                            <div class="form-group">
                                <label class="col-sm-2 control-label">词类型</label>
                                <div class="col-sm-10">
                                        <label>
                                        
                                            <input type="radio" <c:if test="${dictionary.dic_type == 1 }">checked="checked"</c:if> value="1" name="dic_type" class="radio i-checks"> <i></i> 基本词</label>
                                            &nbsp;&nbsp;&nbsp;
                                        <label>
                                            <input type="radio"  <c:if test="${dictionary.dic_type == 2 }">checked="checked"</c:if> value="2" name="dic_type" class="radio i-checks"> <i></i> 停止词</label>
                                </div>
                            </div>
                            <div class="hr-line-dashed"></div>
                            <div class="form-group">
                                <label class="col-sm-2 control-label">权重</label>
                                <div class="col-sm-10">
                                    <input type="number" min="1" class="form-control" placeholder="权重" name="weight" id="weight" value="${dictionary.weight }">
                                </div>
                            </div>
                            <div class="hr-line-dashed"></div>
                            <div class="form-group">
                                <div class="col-sm-4 col-sm-offset-2">
                                    <a class="btn btn-primary" id="submit">更新</a>
                                    <a class="btn btn-white" id="cancel">取消</a>
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
					     
					     $("#dictionary").validate({
					         rules: {
					             word: {
					                 required: true,
					                 minlength: 2,
					                 maxlength: 10,
					                 remote: {
					                	    url: "dic/checkWord.html",     //后台处理程序
					                	    type: "post",               //数据发送方式
					                	    dataType: "json",           //接受数据格式    只能返回 "true" 或 "false"，不能有其他输出。
					                	    data: {                     //要传递的数据 
					                	    	word: function() {
					                	            return $("#word").val();
					                	        },                   
						             	    	id: function() {
						            	            return $("#id").val();
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
					        	 word: {
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
			            	 if($("#dictionary").valid()){
			            		 var loadingIndex = 0;
			            		 $.ajax({
			            	            type:"POST",
			            	            url:"dic/saveWord.html",
			            	            data:$("#dictionary").serialize(),
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
			 			

			            $('#word').bind('input propertychange', function() {
			                $.ajax({
	            	            type:"POST",
	            	            url:"dic/pinyin.html",
	            	            data:{word:$(this).val()},
	            	            datatype: "json",
	            	            success:function(data){
	            	            	 $("#jp").val(data.jp);
	            	            	 $("#qp").val(data.qp);
		            	        }      
	            	         });
			            });		
			 			
			 			
	</script>


</body>


</html>