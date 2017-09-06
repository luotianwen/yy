<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE html>
<html>

<head>
	<base href="<%=basePath%>">
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	
	<title>编辑世峰e卡</title>
	
	<link href="static/css/bootstrap.min.css" rel="stylesheet">
	<link href="static/css/animate.min.css" rel="stylesheet">
	<link href="static/css/style.min.css" rel="stylesheet">
	<link href="static/css/layerdate/layerdate.css" rel="stylesheet">
	<!-- iCheck -->
	<link href="static/css/plugins/iCheck/custom.css" rel="stylesheet">

</head>

<body class="gray-bg">
	<div class="wrapper wrapper-content animated fadeInRight">
		<div class="row">
			<div id="user-box" class="col-sm-12">
				<div class="ibox">
					<div class="ibox-content" id="vue">
						<form id="card" method="post" class="form-horizontal">
 							<div v-if="number!=null&&number!=''">
 								<div class="form-group">
									<label class="col-sm-2 control-label">卡号</label>
	
									<div class="col-sm-10">
										<input type="text" readonly="readonly" class="form-control" placeholder="卡号" id="number" name="number" value="{{card.number }}">
									</div>
								</div>
								<div class="hr-line-dashed"></div>
	
								<div class="form-group">
									<label class="col-sm-2 control-label">消息类型</label>
	
									<div class="col-sm-10">
										<select class="form-control" name="status">
											<option v-if="card.status==1" value="1" selected>未绑定</option>
											<option v-if="card.status==2" value="2" selected>未使用</option>
											<option v-if="card.status==3" value="3" selected>部分使用</option>
											<option v-if="card.status==4" value="4" selected>已用完</option>
											<option value="5">已作废</option>
											<option v-if="card.status==6" value="6" selected>已过期</option>
										</select>
									</div>
								</div>
								<div class="hr-line-dashed"></div>
 							</div>
							
							<div v-else>
								<div class="form-group">
	                                <label class="col-sm-2 control-label">开始时间</label>
	
	                                <div class="col-sm-10">
	                                    <input type="text" readonly="readonly" class="form-control"  placeholder="开始时间" id="sdate"  name="sdate" >
	                                </div>
	                            </div>
	                            <div class="hr-line-dashed"></div>
	                            
	                            <div class="form-group">
	                                <label class="col-sm-2 control-label">结束时间</label>
	
	                                <div class="col-sm-10">
	                                    <input type="text" readonly="readonly" class="form-control"  placeholder="结束时间" id="edate"  name="edate" >
	                                </div>
	                            </div>
	                            <div class="hr-line-dashed"></div>
	                            
	                            <div class="form-group">
	                                <label class="col-sm-2 control-label">金额</label>
	
	                                <div class="col-sm-10">
	                                    <input type="text" class="form-control" maxlength="4" onkeyup="this.value=this.value.replace(/\D/g,'');if(this.value>5000){this.value=5000}" onafterpaste="this.value=this.value.replace(/\D/g,'');if(this.value>5000){this.value=5000}" placeholder="金额" id="money"  name="money" >
	                                </div>
	                            </div>
	                            <div class="hr-line-dashed"></div>
	                            
	                            <div class="form-group">
	                                <label class="col-sm-2 control-label">生成数量</label>
	
	                                <div class="col-sm-10">
	                                    <input type="text" class="form-control" maxlength="2" onkeyup="this.value=this.value.replace(/\D/g,'');if(this.value>10){this.value=10}" onafterpaste="this.value=this.value.replace(/\D/g,'');if(this.value>10){this.value=10}" placeholder="生成数量" id="count"  name="count" >
	                                </div>
	                            </div>
	                            <div class="hr-line-dashed"></div>
	                            
	                            <div class="form-group">
	                                <label class="col-sm-2 control-label">备注</label>
	
	                                <div class="col-sm-10">
	                                	<textarea id="remark" name="remark" maxlength="200" class="form-control" placeholder="备注"></textarea>
	                                </div>
	                            </div>
	                            <div class="hr-line-dashed"></div>
							</div>
							

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
	<script src="static/js/plugins/layer/laydate/laydate.js"></script>
	<!-- iCheck -->
	<script src="static/js/plugins/iCheck/icheck.min.js"></script>
	
	<script type="text/javascript">
		new Vue({
			el : "#vue",
			data : {card:null},
			mounted : function(){
				var _this = this;
				$.post("card/findCardById.json?id="+$("#id").val(),function(data){
					for(var key in data){
						if(_this.key == undefined){
							Vue.set(_this.$data,key,data[key]);
						}else{
							_this.key = data[key];
						}
					}
					_this.dateinit();
				})
			},
			methods : {
				dateinit : function(){
					var start = {
			   			elem : '#sdate',
			   			format : 'YYYY-MM-DD',
			   			istoday : false,
						min: laydate.now(),
						choose: function(datas){
							end.min = datas; //开始日选好后，重置结束日的最小日期
						}
			   		};
			   		var end = {
			   			elem : '#edate',
			   			format : 'YYYY-MM-DD',
			   			istoday : false,
						min: laydate.now(+1),
						choose: function(datas){
							start.max = datas; //开始日选好后，重置结束日的最小日期
						}
			   		};
			   		laydate(start);
			   		laydate(end);
				},
				submit : function(){
					if (this.check_in()) {
						layer.load(0, {
							shade : 0.3
						});
						var url = "card/saveCard.json";

						if ($("#number").length>0) {
							url = "card/updateCard.json";
						}
						$.post(url, $('#card').serialize(), function(data) {
							if (data.RESPONSE_STATE == '200') {
								layer.msg('保存成功', {
									icon : 1,
									time : 1 * 1000
								}, function() {
									parent.self.location.reload();
								});
							} else {
								layer.closeAll('loading');
								layer.alert(data.ERROR_INFO, {
									icon : 0
								});
							}
						});
					}
				},
				check_in : function(){
					if($('#sdate').val().trim() == ''){
		        		layer.tips('开始时间不能为空！！！', '#sdate', {
						    tips: [1, '#019F95'],
						    time: 1500
						});
						$('#sdate').focus();
						return false;
		        	}
			    	if($('#edate').val().trim() == ''){
		        		layer.tips('结束时间不能为空！！！', '#edate', {
						    tips: [1, '#019F95'],
						    time: 1500
						});
						$('#edate').focus();
						return false;
		        	}
			    	if($('#money').val().trim() == ''){
		        		layer.tips('金额不能为空！！！', '#money', {
						    tips: [1, '#019F95'],
						    time: 1500
						});
						$('#money').focus();
						return false;
		        	}
			    	if(Number($('#money').val())<=0){
		        		layer.tips('金额必须大于0！！！', '#money', {
						    tips: [1, '#019F95'],
						    time: 1500
						});
						$('#money').focus();
						return false;
		        	}
			    	if(Number($('#money').val())>5000){
		        		layer.tips('金额最大数额为5000！！！', '#money', {
						    tips: [1, '#019F95'],
						    time: 1500
						});
						$('#money').focus();
						return false;
		        	}
			    	if($('#count').val().trim() == ''){
		        		layer.tips('生成数量不能为空！！！', '#count', {
						    tips: [1, '#019F95'],
						    time: 1500
						});
						$('#count').focus();
						return false;
		        	}
			    	if(Number($('#count').val())>10){
		        		layer.tips('最多只能生成10张e卡！！！', '#count', {
						    tips: [1, '#019F95'],
						    time: 1500
						});
						$('#count').focus();
						return false;
		        	}
			    	if($('#remark').val().trim() == ''){
		        		layer.tips('备注不能为空！！！', '#remark', {
						    tips: [1, '#019F95'],
						    time: 1500
						});
						$('#remark').focus();
						return false;
		        	}
					return true;
				}
			}
		})
		
	</script>


</body>


</html>