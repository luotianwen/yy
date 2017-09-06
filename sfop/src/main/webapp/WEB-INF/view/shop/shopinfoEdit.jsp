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
						<form id="shopinfo" method="post" class="form-horizontal">
							<input type="hidden" id="id" name="s_merchants_id" value="${id}"/>
							   <div class="form-group">
								   <label class="col-sm-2 control-label">店铺名称</label>
								   <div class="col-sm-4">
									   <input type="text" class="form-control" placeholder="店铺名称" id="name" name="name" v-bind:value="shopinfo!=null?shopinfo.name:''">
								   </div>
								   <label class="col-sm-2 control-label">店铺类型</label>
								   <div class="col-sm-4">
									   <select class="form-control m-b" name="grade">
										   <option value="1" v-bind:selected="shopinfo!=null&&shopinfo.grade==1">【官方旗舰店】</option>
										   <option value="2" v-bind:selected="shopinfo!=null&&shopinfo.grade==2">【(品牌)授权专卖店】</option>
										   <option value="3" v-bind:selected="shopinfo!=null&&shopinfo.grade==3" >【品牌专营店】</option>
									   </select>
								   </div>

								</div>
							<div class="hr-line-dashed"></div>

							   <div class="form-group">
								   <label class="col-sm-2 control-label">登录帐号</label>
								   <div class="col-sm-4">
									   {{shopinfo!=null?shopinfo.account:''}}
								    </div>
								   <label class="col-sm-2 control-label">登录密码</label>
								   <div class="col-sm-4">
									   <a style="cursor: pointer"  @click="initializePwd">初始化密码</a>
								   </div>
								</div>

							<div class="hr-line-dashed"></div>
							   <div class="form-group">
									<label class="col-sm-2 control-label">客服电话</label>
									<div class="col-sm-4">
										<input type="text" class="form-control" placeholder="客服电话" id="fax" name="fax" v-bind:value="shopinfo!=null?shopinfo.fax:''">
									</div>

									<label class="col-sm-2 control-label">邮箱</label>
									<div class="col-sm-4">
										<input type="text" class="form-control" placeholder="邮箱" id="email" name="email" v-bind:value="shopinfo!=null?shopinfo.email:''">
									</div>
								</div>
							<div class="hr-line-dashed"></div>
							   <div class="form-group">
									<label class="col-sm-2 control-label">邮编</label>
									<div class="col-sm-4">
										<input type="text" class="form-control" placeholder="邮编" id="postcode" name="postcode" v-bind:value="shopinfo!=null?shopinfo.postcode:''">
									</div>
								</div>

							<div class="hr-line-dashed"></div>
							   <div class="form-group">
									<label class="col-sm-2 control-label">注册日期</label>
									<div class="col-sm-4">
										<input type="text" class="form-control" readonly="readonly" placeholder="注册日期" id="rtime" name="rtime" v-bind:value="shopinfo!=null?shopinfo.rtime:''">
									</div>
								   <label class="col-sm-2 control-label">结束时间</label>
								   <div class="col-sm-4">
									   <input type="text" class="form-control" readonly="readonly" placeholder="结束时间" id="endtime" name="endtime" v-bind:value="shopinfo!=null?shopinfo.endtime:''">
								   </div>
								</div>
							<div class="hr-line-dashed"></div>
							   <div class="form-group">
									<label class="col-sm-2 control-label">状态</label>
								   <div class="col-sm-10">
									   <input  type="radio" name="sstate" value="1" v-bind:checked="shopinfo!=null&&shopinfo.sstate==1">开通
									   <input  type="radio" name="sstate" value="2" v-bind:checked="shopinfo!=null&&shopinfo.sstate==2">冻结
									   <input  type="radio" name="sstate" value="3" v-bind:checked="shopinfo!=null&&shopinfo.sstate==3">暂停
									   <input  type="radio" name="sstate" value="4" v-bind:checked="shopinfo!=null&&shopinfo.sstate==4">未开通
								   </div>

								</div>



							<div class="hr-line-dashed"></div>
							   <div class="form-group">
									<label class="col-sm-2 control-label">备注</label>
									<div class="col-sm-10">
										<textarea   id="remark" name="remark"></textarea>
									</div>
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
	<script type="text/javascript" charset="utf-8" src="static/plugins/ueditor/ueditor.min.config.js"></script>
	<script type="text/javascript" charset="utf-8" src="static/plugins/ueditor/ueditor.all.min.js"> </script>
	<script type="text/javascript" charset="utf-8" src="static/plugins/ueditor/lang/zh-cn/zh-cn.js"></script>
	<script type="text/javascript">

		var ue;
		new Vue({
			el : "#vue",
			data : {shopinfo:null},
			mounted : function(){
				var _this = this;
				$.post("shopinfo/findShopinfoById.json?id="+$("#id").val(),function(data){
					for(var key in data){
						if(_this.key == undefined){
							Vue.set(_this.$data,key,data[key]);
						}else{
							_this.key = data[key];
						}
					}
					if(_this.shopinfo!=undefined){
						$("#remark").val(_this.shopinfo.remark);
					}

					ue= UE.getEditor('remark');
				});
				var start = {
					elem : '#rtime',
					format : 'YYYY-MM-DD',
					istoday : false,
					choose: function(datas){
						end.min = datas; //开始日选好后，重置结束日的最小日期
					}
				};
				var end = {
					elem : '#endtime',
					format : 'YYYY-MM-DD',
					istoday : false,

					choose: function(datas){
						start.max = datas; //开始日选好后，重置结束日的最小日期
					}
				};
				laydate(start);
				laydate(end);

			},
			methods : {
				initializePwd:function(){
					url="shopinfo/updateAccount.json";
					$.post(url,{id:$("#id").val().trim()},function(data){
						if (data.RESPONSE_STATE == '200') {
							layer.alert("重置成功！密码为"+data.info, {
								icon : 0
							});
						} else {
							layer.alert(data.ERROR_INFO, {
								icon : 0
							});
						}
					});
				},
				submit : function(){
					if (this.check_in()) {
						layer.load(0, {
							shade : 0.3
						});
						var url = "shopinfo/saveShopinfo.json";

						if ($("#id").val().trim()!=null&&$("#id").val().trim()!=''&&$("#id").val().trim()!='0') {
							url = "shopinfo/updateShopinfo.json";
						}
						$.post(url, $('#shopinfo').serialize(), function(data) {
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