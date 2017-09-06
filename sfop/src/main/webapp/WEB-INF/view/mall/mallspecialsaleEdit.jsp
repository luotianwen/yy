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
	
	<title>编辑</title>
	
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
						<form id="mallspecialsale" method="post" class="form-horizontal">
							<input type="hidden" id="id" name="id" value="${id}"/>
							<div class="form-group">
								<label class="col-sm-2 control-label">名称</label>
								<div class="col-sm-10">
									<input type="text" class="form-control" placeholder="名称" id="name" name="name" v-bind:value="mallspecialsale!=null?mallspecialsale.name:''">
								</div>
							</div>
							   <div class="form-group">
									<label class="col-sm-2 control-label">开始时间</label>
									<div class="col-sm-10">
										<input type="text" class="form-control"  readonly="readonly" placeholder="开始时间" id="starttime" name="starttime" v-bind:value="mallspecialsale!=null?mallspecialsale.starttime:''">
									</div>
								</div>
							<div class="hr-line-dashed"></div>
							   <div class="form-group">
									<label class="col-sm-2 control-label">结束时间</label>
									<div class="col-sm-10">
										<input type="text" class="form-control" readonly="readonly"  placeholder="结束时间" id="endtime" name="endtime" v-bind:value="mallspecialsale!=null?mallspecialsale.endtime:''">
									</div>
								</div>

							<div class="hr-line-dashed"></div>
							   <div class="form-group">
									<label class="col-sm-2 control-label">说明</label>
									<div class="col-sm-10">
										<input type="text" class="form-control" placeholder="说明" id="note" name="note" v-bind:value="mallspecialsale!=null?mallspecialsale.note:''">
									</div>
								</div>
							<div class="hr-line-dashed"></div>
							   <div class="form-group">
									<label class="col-sm-2 control-label">状态</label>
								   <div class="col-sm-10">
									   <select class="form-control m-b" name="state"  >
										   <option value="1" v-bind:selected="mallspecialsale!=null&&mallspecialsale.state==1">发布</option>
										   <option value="2" v-bind:selected="mallspecialsale!=null&&mallspecialsale.state==2">下线</option>
									   </select>
								   </div>

								</div>


							<div class="hr-line-dashed"></div>
							   <div class="form-group">
									<label class="col-sm-2 control-label">备注</label>
									<div class="col-sm-10">
										<input type="text" class="form-control" placeholder="备注" id="remark" name="remark" v-bind:value="mallspecialsale!=null?mallspecialsale.remark:''">
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
	<script src="static/js/plugins/layer/laydate/laydate.js"></script>
	<script type="text/javascript">
		new Vue({
			el : "#vue",
			data : {mallspecialsale:null},
			mounted : function(){
				var _this = this;
				$.post("mallspecialsale/findMallSpecialSaleById.json?id="+$("#id").val(),function(data){
					for(var key in data){
						Vue.set(_this.$data,key,data[key]);
					}
				})
				_this.dateinit();
			},
			methods : {
				dateinit : function(){
					var start = {
						elem : '#starttime',
						format : 'YYYY-MM-DD',
						istoday : false,
						min: laydate.now(),
						choose: function(datas){
							end.min = datas; //开始日选好后，重置结束日的最小日期
						}
					};
					var end = {
						elem : '#endtime',
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
						var url = "mallspecialsale/saveMallSpecialSale.json";

						if ($("#id").val().trim()!=null&&$("#id").val().trim()!=''&&$("#id").val().trim()!='0') {
							url = "mallspecialsale/updateMallSpecialSale.json";
						}
						$.post(url, $('#mallspecialsale').serialize(), function(data) {
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
					if ($('#id').val().trim() == '') {
						$("#id").val(0);
					}
					if ($('#name').val().trim() == '') {
						layer.tips('名称！！！', '#name', {
							tips : [ 1, '#019F95' ],
							time : 1500
						});
						$('#name').focus();
						return false;
					}
					if ($('#starttime').val().trim() == '') {
						layer.tips('开始时间', '#starttime', {
							tips : [ 1, '#019F95' ],
							time : 1500
						});
						$('#starttime').focus();
						return false;
					}
					if ($('#endtime').val().trim() == '') {
						layer.tips('结束时间', '#endtime', {
							tips : [ 1, '#019F95' ],
							time : 1500
						});
						$('#endtime').focus();
						return false;
					}
					return true;
				}
			}
		})
		
	</script>


</body>


</html>