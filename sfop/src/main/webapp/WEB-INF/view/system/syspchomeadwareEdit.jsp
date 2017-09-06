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
						<form id="syspchomeadware" method="post" class="form-horizontal">
							<input type="hidden" id="id" name="id" value="${id}"/>
							<input type="hidden" name="ad_id" value="${ad_id}">
							
							<div class="form-group">
									<label class="col-sm-2 control-label">sku</label>
									<div class="col-sm-10">
										<input type="text" class="form-control" placeholder="sku" id="sku" name="sku" v-bind:value="syspchomeadware!=null?syspchomeadware.sku:''">
									</div>
								</div>
							<div class="hr-line-dashed"></div>
							   <div class="form-group">
									<label class="col-sm-2 control-label">链接</label>
									<div class="col-sm-10">
										<input type="text" class="form-control" placeholder="链接" id="imgLink" name="imgLink" v-bind:value="syspchomeadware!=null?syspchomeadware.imgLink:''">
									</div>
								</div>
							<div class="hr-line-dashed"></div>
							   <div class="form-group">
									<label class="col-sm-2 control-label">顶部图标</label>
									<div class="col-sm-10">
										<input type="text" class="form-control" placeholder="顶部图标" id="top_pic" name="top_pic" v-bind:value="syspchomeadware!=null?syspchomeadware.top_pic:''">
									</div>
								</div>
							<div class="hr-line-dashed"></div>
							   <div class="form-group">
									<label class="col-sm-2 control-label">序号</label>
									<div class="col-sm-10">
										<input type="text" class="form-control" placeholder="序号" id="sort" name="sort" v-bind:value="syspchomeadware!=null?syspchomeadware.sort:''">
									</div>
								</div>
							<div class="hr-line-dashed"></div>
							   <div class="form-group">
									<label class="col-sm-2 control-label">状态</label>
									<div class="col-sm-10">
										<select class="form-control m-b" name="state"  >
                                            <option value="1" v-bind:selected="syspchomeadware!=null&&syspchomeadware.state==1">启用</option>
                                            <option value="2" v-bind:selected="syspchomeadware!=null&&syspchomeadware.state==2">禁用</option>
                                        </select>
									</div>
								</div>
							<div class="hr-line-dashed"></div>
							   <div class="form-group">
									<label class="col-sm-2 control-label">备注</label>
									<div class="col-sm-10">
										<input type="text" class="form-control" placeholder="备注" id="remark" name="remark" v-bind:value="syspchomeadware!=null?syspchomeadware.remark:''">
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
			data : {syspchomeadware:null},
			mounted : function(){
				var _this = this;
				$.post("syspchomeadware/findSysPcHomeadWareById.json?id="+$("#id").val(),function(data){
					for(var key in data){
						Vue.set(_this.$data,key,data[key]);
					}
				})
			},
			methods : {
				submit : function(){
					if (this.check_in()) {
						layer.load(0, {
							shade : 0.3
						});
						var url = "syspchomeadware/saveSysPcHomeadWare.json";

						if ($("#id").val().trim()!=null&&$("#id").val().trim()!=''&&$("#id").val().trim()!='0') {
							url = "syspchomeadware/updateSysPcHomeadWare.json";
						}
						$.post(url, $('#syspchomeadware').serialize(), function(data) {
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
					if ($('#sku').val().trim() == '') {
						layer.tips('sku不能为空！！！', '#sku', {
							tips : [ 1, '#019F95' ],
							time : 1500
						});
						$('#sku').focus();
						return false;
					}
					
					return true;
				}
			}
		})
		
	</script>


</body>


</html>