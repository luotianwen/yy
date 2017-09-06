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
						<form id="couponPackage" method="post" class="form-horizontal">
							   <div class="form-group">
									<label class="col-sm-2 control-label">名称</label>
									<div class="col-sm-10">
										<input type="text" class="form-control" placeholder="名称" id="name" name="name">
									</div>
								</div>
							<div class="hr-line-dashed"></div>
							   <div class="form-group">
									<label class="col-sm-2 control-label">发券数量</label>
									<div class="col-sm-10">
										【<span style="color:red;">{{number}}</span>】 张
									</div>
								</div>
							<div class="hr-line-dashed"></div>
							   <div class="form-group">
									<label class="col-sm-2 control-label">发行金额</label>
									<div class="col-sm-10">
										【<span style="color:red;">{{price}}</span>】 元
									</div>
								</div>
							<div class="hr-line-dashed"></div>
							   <div class="form-group">
									<label class="col-sm-2 control-label">优惠券有效期</label>
									<div class="col-sm-10">
										<input type="text" class="form-control" placeholder="优惠券有效期" id="startdate" name="startdate">
									</div>
								</div>
							<div class="hr-line-dashed"></div>
							   <div class="form-group">
									<label class="col-sm-2 control-label">优惠券有效期结束</label>
									<div class="col-sm-10">
										<input type="text" class="form-control" placeholder="优惠券有效期结束" id="enddate" name="enddate">
									</div>
								</div>
							<div class="hr-line-dashed"></div>
							   <div class="form-group">
									<label class="col-sm-2 control-label">优惠券说明</label>
									<div class="col-sm-10">
										<input type="text" class="form-control" placeholder="优惠券说明" id="note" name="note">
									</div>
								</div>
							<div class="hr-line-dashed"></div>
							   <div class="form-group">
									<label class="col-sm-2 control-label">备注</label>
									<div class="col-sm-10">
										<input type="text" class="form-control" placeholder="备注" id="remark" name="remark">
									</div>
								</div>
							<div class="hr-line-dashed"></div>
							   <div class="form-group">
									<label class="col-sm-2 control-label">领取地址</label>
									<div class="col-sm-10">
										<input type="text" class="form-control" placeholder="领取地址" id="url" name="url">
									</div>
								</div>
							<div class="hr-line-dashed"></div>
							
							<div class="form-group">
									<label class="col-sm-2 control-label">选择优惠券</label>
									<div class="col-sm-10">
										<table class="table table-striped table-hover">
											<thead>
												<tr class="tr-center">
													<th>选择</th>
													<th>优惠券名称</th>
													<th>剩余张数</th>
													<th>说明</th>
												</tr>
											</thead>
											<tbody>
												<tr v-if="coupons.length==0">
													<td style="text-align: center" colspan="4">无可用优惠券</td>
												</tr>
												<tr v-else v-for="(coupons,index) in coupons">
													<td>
														<input type="checkbox" :value="index" v-model="checkboxModel" @click="check(index)">
													</td>
													<td>{{coupons.name}}</td>
													<td>{{coupons.surplusNumber}}</td>
													<td>满{{coupons.full}}元减{{coupons.minus}}元</td>
												</tr>
											</tbody>
										</table>
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
	<script src="static/js/plugins/layer/laydate/laydate.js"></script>
	<!-- iCheck -->
	<script src="static/js/plugins/iCheck/icheck.min.js"></script>
	
	<script type="text/javascript">
		new Vue({
			el : "#vue",
			data : {coupons:[],number:0,price:0,checkboxModel:[]},
			mounted : function(){
				var _this = this;
				$.post("coupons/findAllCouponsByPackage.json",function(data){
					Vue.set(_this.$data,"coupons",data);
				})
				_this.dateinit();
			},
			methods : {
				dateinit : function(){
					var start = {
			   			elem : '#startdate',
			   			min : laydate.now(),
			   			format : 'YYYY-MM-DD hh:mm:ss',
			   			istime : true,
			   		};
			   		var end = {
		   				elem : '#enddate',
			   			min : laydate.now(),
			   			format : 'YYYY-MM-DD hh:mm:ss',
			   			istime : true,
			   		};
			   		laydate(start);
			   		laydate(end);
				},
				submit : function(){
					if (this.check_in()) {
						layer.load(0, {
							shade : 0.3
						});
						var _this = this;
						var str = "";
						for(var i=0,len=_this.checkboxModel.length;i<len;i++){
							if(i==0){
								str += "?c_coupons="+_this.coupons[_this.checkboxModel[i]].id;
							}else{
								str += ","+_this.coupons[_this.checkboxModel[i]].id;
							}
						}
						layer.confirm("创建后无法更改优惠券信息，是否继续?",{icon:3},function(index){
							$.post("couponPackage/saveCouponPackage.json"+str, $('#couponPackage').serialize(), function(data) {
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
						});
					}
				},
				check_in : function(){
					if ($('#name').val().trim() == '') {
						layer.tips('优惠券名称不能为空！！！', '#name', {
							tips : [ 1, '#019F95' ],
							time : 1500
						});
						$('#name').focus();
						return false;
					}
					
					if ($('#startdate').val().trim() == '') {
						layer.tips('优惠券开始时间不能为空！！！', '#startdate', {
							tips : [ 1, '#019F95' ],
							time : 1500
						});
						$('#startdate').focus();
						return false;
					}
					
					if ($('#enddate').val().trim() == '') {
						layer.tips('优惠券结束时间不能为空！！！', '#enddate', {
							tips : [ 1, '#019F95' ],
							time : 1500
						});
						$('#enddate').focus();
						return false;
					}
					
					var number = "";
					for(var i=0,len=this.checkboxModel.length;i<len;i++){
						if(i==0){
							number = this.coupons[this.checkboxModel[i]].surplusNumber;
						}else{
							if(number!=this.coupons[this.checkboxModel[i]].surplusNumber){
								layer.alert("您设置的优惠券数量不同意，请重新选择！",{icon:0,title:"失败提醒"})
								return false;
							}
						}
					}
					
					return true;
				},
				check : function(index){
					if(this.coupons[index].ischeck=="undefined"){
						Vue.set(this.coupons[index],"ischeck",true);
						this.number += this.coupons[index].surplusNumber;
						this.price += this.coupons[index].minus;
					}else if(this.coupons[index].ischeck){
						this.coupons[index].ischeck = false;
						this.number -= this.coupons[index].surplusNumber;
						this.price -= this.coupons[index].minus;
					}else{
						this.coupons[index].ischeck = true;
						this.number += this.coupons[index].surplusNumber;
						this.price += this.coupons[index].minus;
					}
				}
			}
		})
		
	</script>


</body>


</html>