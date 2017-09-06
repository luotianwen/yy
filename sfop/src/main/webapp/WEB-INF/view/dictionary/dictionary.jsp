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

    <title>字典管理</title>

    <link href="static/css/bootstrap.min.css" rel="stylesheet">
    <link href="static/css/font-awesome.min.css" rel="stylesheet">
    <!-- iCheck -->
    <link href="static/css/plugins/iCheck/custom.css" rel="stylesheet">
    <link href="static/css/animate.min.css" rel="stylesheet">
    <link href="static/css/style.min.css" rel="stylesheet">
    <script src="static/js/jquery-2.1.1.min.js"></script>
    <link href="static/css/page.css" rel="stylesheet">
	<link href="static/css/plugins/bootstrap-switch/bootstrap-switch.min.css" rel="stylesheet">
</head>

<body class="gray-bg">
    <div class="wrapper wrapper-content  animated fadeInRight">
        <div class="row">
            <div id="user-box" class="col-sm-12">
                <div class="ibox">
                <form method="post" id="dictionary">
                    <div class="ibox-content">
                        <h2>词典管理</h2>
                        <div class="input-group">
                        	<div class="col-md-4">
                               <input type="text" placeholder="词" name="word" value="${page.t.word }" class="input form-control">
                            </div> 
                           <div class="col-md-3">
                               <button type="submit" class="btn btn btn-primary"> <i class="fa fa-search"></i> 搜索</button>
                           </div> 
                            <div class="col-md-3">
                            	<button type="button" id="dic-add" class="btn btn btn-primary"> <i class="fa fa-plus-square"></i> 新增</button>
                            </div>
                        </div>
                       <div class="hr-line-dashed"></div> 
                            <div class="tab-content">
                                <div class="tab-pane active">
                                    <div class="full-height-scroll">
                                        <div class="table-responsive" id="dictionaryList">
                                            
                                        </div>
                                    </div>
                                    
                                    <div class="ibox-content">
	                                     <p>
					                       <!--  <button type="button" id="users-delete" class="btn btn-sm btn-danger">删除</button> -->
					                        <button type="button" id="dic-refresh" class="btn btn-w-m btn-warning"  data-toggle="tooltip" data-placement="right" title="同步词库到搜索引擎"> <i class="fa fa-spin fa-refresh"></i> 同步词库到搜索引擎</button>
					                        <button type="button" id="search-refresh" class="btn btn-w-m btn-warning"  data-toggle="tooltip" data-placement="right" title="刷新搜索引擎索引"> <i class="fa fa-spin fa-refresh"></i> 刷新搜索引擎索引</button>
										 </p>
			                            <div class="alert alert-warning">
											<p class="text-danger">搜索服务器会定时更新词库，如需立即生效，请点击刷新按钮！！！</p>
				                        </div>
                                    </div>
                                    
                       <div class="hr-line-dashed"></div>
                        <div class="text-center" id="page"></div>
                                </div>
                               
                            </div>
 						</div>
                   </form> 
                </div>
            </div>
        </div>
    </div>

    <!-- 全局js -->
    <script src="static/js/bootstrap.min.js"></script>
	<script src="static/js/plugins/layer/layer.js"></script>
	<script src="static/js/plugins/layer/laypage/laypage.js"></script>
    <script src="static/js/plugins/slimscroll/jquery.slimscroll.min.js"></script>
    <!-- iCheck -->
    <script src="static/js/plugins/iCheck/icheck.min.js"></script>
    <!-- bootstrap-switch -->
    <script src="static/js/plugins/bootstrap-switch/bootstrap-switch.js"></script>
    <script>
        $(function () {
        	$.post("dic/list.html",function(data){
        		$("#dictionaryList").html(data);
        	})
        	
            $(".full-height-scroll").slimScroll({
                height: "100%"
            });
            
            //设置本页layer皮肤
            layer.config({
            	skin:'layui-layer-molv',
            });
            
          	//ifCreated 事件在插件初始化之前绑定   全选
            $("input[id='checkAll']").on("ifChecked", function(event){ 
            	$("input[id='tgp_id']").iCheck("check");
          	}); 
          	//反选
            $("input[id='checkAll']").on("ifUnchecked", function(event){ 
            	$("input[id='tgp_id']").iCheck("uncheck");
          	}); 
            $(".i-checks").iCheck({
                checkboxClass: "icheckbox_square-green",
                radioClass: "iradio_square-green",
            });
            
 			//添加词
            $("button[id='dic-add']").on("click" , function(){
                 layer.open({
                    type: 2,
                    title: "添加词",
                    shade: 0.2,
                    area: ["60%", "70%"],
                    content: "dic/add.html"
                });
            });     
            
 			//修改词
            $("button[id='dic-edit']").on("click" , function(){
            	id = $(this).parent().attr("data-id");
                 layer.open({
                    type: 2,
                    title: "添加词",
                    shade: 0.2,
                    area: ["60%", "70%"],
                    content: "dic/edit/"+id+".html"
                });
            });          
            
			     
            $("input[id='switch']").bootstrapSwitch();
            $("input[id='switch']").on('switchChange.bootstrapSwitch', function(event, state) {
            	//$this = $(this);
            	layer.msg("该功能暂不可用！", {icon: 0});
            	//$this.bootstrapSwitch('state', state==false?true:false);
            });
           /*  bl = true;
            $("input[id='switch']").on('switchChange.bootstrapSwitch', function(event, state) {
         	   if(bl){
           	   	 $this = $(this);
	            	 $.ajax({
	     	            type:"POST",
	     	            url:"insurances/isEnable.html",
	     	            datatype: "json",
	     	            data:{id:$this.val()},
	     	            //成功返回之后调用的函数             
	     	            success:function(data){
	     	            	
	     	            	if(data.RESPONSE_STATE != "200"){
	     	            		bl = false;
	     	            		$this.bootstrapSwitch('state', state==false?true:false);
	     	            		layer.alert(data.ERROR_INFO, {icon: 0});
	     	            	}
	         	        },
	     	            error: function(){
	     	            	bl = false;
	     	            	$this.bootstrapSwitch('state', state==false?true:false);
	     	            	layer.msg("未知错误！", {icon: 0});
	     	            }         
	     	         });  
         	   }else{
         		   bl = true;
         	   }

         	});   */
 			
			
          //同步词库到搜索引擎
            $("button[id='dic-refresh']").on("click" , function(){
            	 var loadingIndex = 0;
        		 $.ajax({
        	            type:"POST",
        	            url:"dic/syncSearchDic.html",
        	            datatype: "json",
        	            //在请求之前调用的函数
        	            beforeSend:function(){
        	            	loadingIndex = layer.load(0, {shade: [0.3]}); //0代表加载的风格，支持0-2
        	            },
        	            //成功返回之后调用的函数             
        	            success:function(data){
        	            	
        	            	layer.close(loadingIndex);
        	            	if(data == true){
        	            	    layer.msg("同步成功！", {icon: 1});
        	            	}else{
        	            		layer.alert("同步失败！", {icon: 0});
        	            	}
            	        },
        	            error: function(){
        	            	layer.close(loadingIndex);
        	            	layer.alert("未知错误！", {icon: 0});
        	            }         
        	         });
            });	
         	
         	
        });
        
        
        //刷新搜索引擎索引
        $("button[id='search-refresh']").on("click" , function(){
        	 var loadingIndex = 0;
    		 $.ajax({
    	            type:"POST",
    	            url:"dic/syncSearchIndex.html",
    	            datatype: "json",
    	            //在请求之前调用的函数
    	            beforeSend:function(){
    	            	loadingIndex = layer.load(0, {shade: [0.3]}); //0代表加载的风格，支持0-2
    	            },
    	            //成功返回之后调用的函数             
    	            success:function(data){
    	            	
    	            	layer.close(loadingIndex);
    	            	if(data == true){
    	            	    layer.msg("同步成功！", {icon: 1});
    	            	}else{
    	            		layer.alert("同步失败！", {icon: 0});
    	            	}
        	        },
    	            error: function(){
    	            	layer.close(loadingIndex);
    	            	layer.alert("未知错误！", {icon: 0});
    	            }         
    	         });
        });	
			
		
       
       
        
    </script>


</body>


</html>