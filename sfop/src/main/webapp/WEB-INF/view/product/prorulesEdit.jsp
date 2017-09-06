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
						<form id="prorules" method="post" class="form-horizontal">
							<input type="hidden" id="id" name="id" value="${id}"/>
							   <div class="form-group">
									<label class="col-sm-2 control-label">sku</label>
									<div class="col-sm-10">
										<input type="text" class="form-control" placeholder="sku" id="sku" name="sku" v-bind:value="prorules!=null?prorules.sku:''">
									</div>
								</div>
							<div class="hr-line-dashed"></div>
							   <div class="form-group">
									<label class="col-sm-2 control-label">商品编号</label>
									<div class="col-sm-10">
										<input type="text" class="form-control" placeholder="商品编号" id="pid" name="pid" v-bind:value="prorules!=null?prorules.pid:''">
									</div>
								</div>
							<div class="hr-line-dashed"></div>
							   <div class="form-group">
									<label class="col-sm-2 control-label">库存</label>
									<div class="col-sm-10">
										<input type="text" class="form-control" placeholder="库存" id="stocks" name="stocks" v-bind:value="prorules!=null?prorules.stocks:''">
									</div>
								</div>
							<div class="hr-line-dashed"></div>
							   <div class="form-group">
									<label class="col-sm-2 control-label">重量</label>
									<div class="col-sm-10">
										<input type="text" class="form-control" placeholder="重量" id="weight" name="weight" v-bind:value="prorules!=null?prorules.weight:''">
									</div>
								</div>
							<div class="hr-line-dashed"></div>
							   <div class="form-group">
									<label class="col-sm-2 control-label">进货价</label>
									<div class="col-sm-10">
										<input type="text" class="form-control" placeholder="进货价" id="costprice" name="costprice" v-bind:value="prorules!=null?prorules.costprice:''">
									</div>
								</div>
							<div class="hr-line-dashed"></div>
							   <div class="form-group">
									<label class="col-sm-2 control-label">市场价</label>
									<div class="col-sm-10">
										<input type="text" class="form-control" placeholder="市场价" id="marketprice" name="marketprice" v-bind:value="prorules!=null?prorules.marketprice:''">
									</div>
								</div>
							<div class="hr-line-dashed"></div>
							   <div class="form-group">
									<label class="col-sm-2 control-label">世峰价</label>
									<div class="col-sm-10">
										<input type="text" class="form-control" placeholder="世峰价" id="price" name="price" v-bind:value="prorules!=null?prorules.price:''">
									</div>
								</div>
							<div class="hr-line-dashed"></div>
							   <div class="form-group">
									<label class="col-sm-2 control-label">商品货号</label>
									<div class="col-sm-10">
										<input type="text" class="form-control" placeholder="商品货号" id="number" name="number" v-bind:value="prorules!=null?prorules.number:''">
									</div>
								</div>
							<div class="hr-line-dashed"></div>
							   <div class="form-group">
									<label class="col-sm-2 control-label">图片编号</label>
									<div class="col-sm-10">
										<input type="text" class="form-control" placeholder="图片编号" id="imageid" name="imageid" v-bind:value="prorules!=null?prorules.imageid:''">
									</div>
								</div>
							<div class="hr-line-dashed"></div>
							   <div class="form-group">
									<label class="col-sm-2 control-label">最后修改时间</label>
									<div class="col-sm-10">
										<input type="text" class="form-control" placeholder="最后修改时间" id="lasttime" name="lasttime" v-bind:value="prorules!=null?prorules.lasttime:''">
									</div>
								</div>
							<div class="hr-line-dashed"></div>
							   <div class="form-group">
									<label class="col-sm-2 control-label">最后修改人</label>
									<div class="col-sm-10">
										<input type="text" class="form-control" placeholder="最后修改人" id="updatename" name="updatename" v-bind:value="prorules!=null?prorules.updatename:''">
									</div>
								</div>
							<div class="hr-line-dashed"></div>
							   <div class="form-group">
									<label class="col-sm-2 control-label">备注</label>
									<div class="col-sm-10">
										<input type="text" class="form-control" placeholder="备注" id="remark" name="remark" v-bind:value="prorules!=null?prorules.remark:''">
									</div>
								</div>
							<div class="hr-line-dashed"></div>
							   <div class="form-group">
									<label class="col-sm-2 control-label">颜色</label>
									<div class="col-sm-10">
										<input type="text" class="form-control" placeholder="颜色" id="colorid" name="colorid" v-bind:value="prorules!=null?prorules.colorid:''">
									</div>
								</div>
							<div class="hr-line-dashed"></div>
							   <div class="form-group">
									<label class="col-sm-2 control-label">规格</label>
									<div class="col-sm-10">
										<input type="text" class="form-control" placeholder="规格" id="specid" name="specid" v-bind:value="prorules!=null?prorules.specid:''">
									</div>
								</div>
							<div class="hr-line-dashed"></div>
							   <div class="form-group">
									<label class="col-sm-2 control-label">开始时间</label>
									<div class="col-sm-10">
										<input type="text" class="form-control" placeholder="开始时间" id="starttime" name="starttime" v-bind:value="prorules!=null?prorules.starttime:''">
									</div>
								</div>
							<div class="hr-line-dashed"></div>
							   <div class="form-group">
									<label class="col-sm-2 control-label">结束时间</label>
									<div class="col-sm-10">
										<input type="text" class="form-control" placeholder="结束时间" id="endtime" name="endtime" v-bind:value="prorules!=null?prorules.endtime:''">
									</div>
								</div>
							<div class="hr-line-dashed"></div>
							   <div class="form-group">
									<label class="col-sm-2 control-label">活动类型</label>
									<div class="col-sm-10">
										<input type="text" class="form-control" placeholder="活动类型" id="activitytype" name="activitytype" v-bind:value="prorules!=null?prorules.activitytype:''">
									</div>
								</div>
							<div class="hr-line-dashed"></div>
							   <div class="form-group">
									<label class="col-sm-2 control-label">活动价</label>
									<div class="col-sm-10">
										<input type="text" class="form-control" placeholder="活动价" id="activityprice" name="activityprice" v-bind:value="prorules!=null?prorules.activityprice:''">
									</div>
								</div>
							<div class="hr-line-dashed"></div>
							   <div class="form-group">
									<label class="col-sm-2 control-label">活动数量</label>
									<div class="col-sm-10">
										<input type="text" class="form-control" placeholder="活动数量" id="activitystocks" name="activitystocks" v-bind:value="prorules!=null?prorules.activitystocks:''">
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
			data : {prorules:null},
			mounted : function(){
				var _this = this;
				$.post("prorules/findProRulesById.json?id="+$("#id").val(),function(data){
					for(var key in data){
						if(_this.key == undefined){
							Vue.set(_this.$data,key,data[key]);
						}else{
							_this.key = data[key];
						}
					}
				})
			},
			methods : {
				submit : function(){
					if (this.check_in()) {
						layer.load(0, {
							shade : 0.3
						});
						var url = "prorules/saveProRules.json";

						if ($("#id").val().trim()!=null&&$("#id").val().trim()!=''&&$("#id").val().trim()!='0') {
							url = "prorules/updateProRules.json";
						}
						$.post(url, $('#prorules').serialize(), function(data) {
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
					
					return true;
				}
			}
		})
		
	</script>


</body>


</html>