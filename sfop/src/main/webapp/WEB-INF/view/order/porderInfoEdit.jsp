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
						<input type="hidden" id="id" name="perentId" value="${id}"/>
						<form id="porderInfo" method="post" class="form-horizontal">
							   <div class="form-group">
									<label class="col-sm-2 control-label">提交时间</label>
									<div class="col-sm-10">
										<input type="text" class="form-control" placeholder="提交时间" id="subTime" name="subTime" v-bind:value="porderInfo!=null?porderInfo.subTime:''">
									</div>
								</div>
							<div class="hr-line-dashed"></div>
							   <div class="form-group">
									<label class="col-sm-2 control-label">卖家编号</label>
									<div class="col-sm-10">
										<input type="text" class="form-control" placeholder="卖家编号" id="sellerId" name="sellerId" v-bind:value="porderInfo!=null?porderInfo.sellerId:''">
									</div>
								</div>
							<div class="hr-line-dashed"></div>
							   <div class="form-group">
									<label class="col-sm-2 control-label">用户编号</label>
									<div class="col-sm-10">
										<input type="text" class="form-control" placeholder="用户编号" id="userId" name="userId" v-bind:value="porderInfo!=null?porderInfo.userId:''">
									</div>
								</div>
							<div class="hr-line-dashed"></div>
							   <div class="form-group">
									<label class="col-sm-2 control-label">买家姓名</label>
									<div class="col-sm-10">
										<input type="text" class="form-control" placeholder="买家姓名" id="receiveName" name="receiveName" v-bind:value="porderInfo!=null?porderInfo.receiveName:''">
									</div>
								</div>
							<div class="hr-line-dashed"></div>
							   <div class="form-group">
									<label class="col-sm-2 control-label">电话</label>
									<div class="col-sm-10">
										<input type="text" class="form-control" placeholder="电话" id="phoneNumber" name="phoneNumber" v-bind:value="porderInfo!=null?porderInfo.phoneNumber:''">
									</div>
								</div>
							<div class="hr-line-dashed"></div>
							   <div class="form-group">
									<label class="col-sm-2 control-label">地址</label>
									<div class="col-sm-10">
										<input type="text" class="form-control" placeholder="地址" id="address" name="address" v-bind:value="porderInfo!=null?porderInfo.address:''">
									</div>
								</div>
							<div class="hr-line-dashed"></div>
							   <div class="form-group">
									<label class="col-sm-2 control-label">邮编</label>
									<div class="col-sm-10">
										<input type="text" class="form-control" placeholder="邮编" id="zipCode" name="zipCode" v-bind:value="porderInfo!=null?porderInfo.zipCode:''">
									</div>
								</div>
							<div class="hr-line-dashed"></div>
							   <div class="form-group">
									<label class="col-sm-2 control-label">积分</label>
									<div class="col-sm-10">
										<input type="text" class="form-control" placeholder="积分" id="giftPoints" name="giftPoints" v-bind:value="porderInfo!=null?porderInfo.giftPoints:''">
									</div>
								</div>
							<div class="hr-line-dashed"></div>
							   <div class="form-group">
									<label class="col-sm-2 control-label">发票抬头</label>
									<div class="col-sm-10">
										<input type="text" class="form-control" placeholder="发票抬头" id="invoiceType" name="invoiceType" v-bind:value="porderInfo!=null?porderInfo.invoiceType:''">
									</div>
								</div>
							<div class="hr-line-dashed"></div>
							   <div class="form-group">
									<label class="col-sm-2 control-label">发票编号</label>
									<div class="col-sm-10">
										<input type="text" class="form-control" placeholder="发票编号" id="invoiceNumber" name="invoiceNumber" v-bind:value="porderInfo!=null?porderInfo.invoiceNumber:''">
									</div>
								</div>
							<div class="hr-line-dashed"></div>
							   <div class="form-group">
									<label class="col-sm-2 control-label">是否结算(1：是；2：否)</label>
									<div class="col-sm-10">
										<input type="text" class="form-control" placeholder="是否结算(1：是；2：否)" id="isSettlement" name="isSettlement" v-bind:value="porderInfo!=null?porderInfo.isSettlement:''">
									</div>
								</div>
							<div class="hr-line-dashed"></div>
							   <div class="form-group">
									<label class="col-sm-2 control-label">结算时间</label>
									<div class="col-sm-10">
										<input type="text" class="form-control" placeholder="结算时间" id="settlementTime" name="settlementTime" v-bind:value="porderInfo!=null?porderInfo.settlementTime:''">
									</div>
								</div>
							<div class="hr-line-dashed"></div>
							   <div class="form-group">
									<label class="col-sm-2 control-label">用户确认收货时间</label>
									<div class="col-sm-10">
										<input type="text" class="form-control" placeholder="用户确认收货时间" id="userConfirmTime" name="userConfirmTime" v-bind:value="porderInfo!=null?porderInfo.userConfirmTime:''">
									</div>
								</div>
							<div class="hr-line-dashed"></div>
							   <div class="form-group">
									<label class="col-sm-2 control-label">订单状态</label>
									<div class="col-sm-10">
										<input type="text" class="form-control" placeholder="订单状态" id="orderStatus" name="orderStatus" v-bind:value="porderInfo!=null?porderInfo.orderStatus:''">
									</div>
								</div>
							<div class="hr-line-dashed"></div>
							   <div class="form-group">
									<label class="col-sm-2 control-label">订单类型</label>
									<div class="col-sm-10">
										<input type="text" class="form-control" placeholder="订单类型" id="orderType" name="orderType" v-bind:value="porderInfo!=null?porderInfo.orderType:''">
									</div>
								</div>
							<div class="hr-line-dashed"></div>
							   <div class="form-group">
									<label class="col-sm-2 control-label">备注</label>
									<div class="col-sm-10">
										<input type="text" class="form-control" placeholder="备注" id="remark" name="remark" v-bind:value="porderInfo!=null?porderInfo.remark:''">
									</div>
								</div>
							<div class="hr-line-dashed"></div>
							   <div class="form-group">
									<label class="col-sm-2 control-label">最后修改时间</label>
									<div class="col-sm-10">
										<input type="text" class="form-control" placeholder="最后修改时间" id="lastModifiedTime" name="lastModifiedTime" v-bind:value="porderInfo!=null?porderInfo.lastModifiedTime:''">
									</div>
								</div>
							<div class="hr-line-dashed"></div>
							   <div class="form-group">
									<label class="col-sm-2 control-label">默认支付方式</label>
									<div class="col-sm-10">
										<input type="text" class="form-control" placeholder="默认支付方式" id="defaultPayment" name="defaultPayment" v-bind:value="porderInfo!=null?porderInfo.defaultPayment:''">
									</div>
								</div>
							<div class="hr-line-dashed"></div>
							   <div class="form-group">
									<label class="col-sm-2 control-label">卖家备注</label>
									<div class="col-sm-10">
										<input type="text" class="form-control" placeholder="卖家备注" id="sellerRemark" name="sellerRemark" v-bind:value="porderInfo!=null?porderInfo.sellerRemark:''">
									</div>
								</div>
							<div class="hr-line-dashed"></div>
							   <div class="form-group">
									<label class="col-sm-2 control-label">Ip</label>
									<div class="col-sm-10">
										<input type="text" class="form-control" placeholder="Ip" id="ip" name="ip" v-bind:value="porderInfo!=null?porderInfo.ip:''">
									</div>
								</div>
							<div class="hr-line-dashed"></div>
							   <div class="form-group">
									<label class="col-sm-2 control-label">支付码</label>
									<div class="col-sm-10">
										<input type="text" class="form-control" placeholder="支付码" id="pay_serial_number" name="pay_serial_number" v-bind:value="porderInfo!=null?porderInfo.pay_serial_number:''">
									</div>
								</div>
							<div class="hr-line-dashed"></div>
							   <div class="form-group">
									<label class="col-sm-2 control-label">在线支付金额</label>
									<div class="col-sm-10">
										<input type="text" class="form-control" placeholder="在线支付金额" id="onlinepayfee" name="onlinepayfee" v-bind:value="porderInfo!=null?porderInfo.onlinepayfee:''">
									</div>
								</div>
							<div class="hr-line-dashed"></div>
							   <div class="form-group">
									<label class="col-sm-2 control-label">订单总金额.</label>
									<div class="col-sm-10">
										<input type="text" class="form-control" placeholder="订单总金额." id="order_total_price" name="order_total_price" v-bind:value="porderInfo!=null?porderInfo.order_total_price:''">
									</div>
								</div>
							<div class="hr-line-dashed"></div>
							   <div class="form-group">
									<label class="col-sm-2 control-label">商家优惠金额</label>
									<div class="col-sm-10">
										<input type="text" class="form-control" placeholder="商家优惠金额" id="seller_discount" name="seller_discount" v-bind:value="porderInfo!=null?porderInfo.seller_discount:''">
									</div>
								</div>
							<div class="hr-line-dashed"></div>
							   <div class="form-group">
									<label class="col-sm-2 control-label">订单货款金额（订单总金额-商家优惠金额）</label>
									<div class="col-sm-10">
										<input type="text" class="form-control" placeholder="订单货款金额（订单总金额-商家优惠金额）" id="order_seller_price" name="order_seller_price" v-bind:value="porderInfo!=null?porderInfo.order_seller_price:''">
									</div>
								</div>
							<div class="hr-line-dashed"></div>
							   <div class="form-group">
									<label class="col-sm-2 control-label">商品总金额</label>
									<div class="col-sm-10">
										<input type="text" class="form-control" placeholder="商品总金额" id="totalMoney" name="totalMoney" v-bind:value="porderInfo!=null?porderInfo.totalMoney:''">
									</div>
								</div>
							<div class="hr-line-dashed"></div>
							   <div class="form-group">
									<label class="col-sm-2 control-label">用户应付金额</label>
									<div class="col-sm-10">
										<input type="text" class="form-control" placeholder="用户应付金额" id="order_payment" name="order_payment" v-bind:value="porderInfo!=null?porderInfo.order_payment:''">
									</div>
								</div>
							<div class="hr-line-dashed"></div>
							   <div class="form-group">
									<label class="col-sm-2 control-label">商品的运费</label>
									<div class="col-sm-10">
										<input type="text" class="form-control" placeholder="商品的运费" id="freight_price" name="freight_price" v-bind:value="porderInfo!=null?porderInfo.freight_price:''">
									</div>
								</div>
							<div class="hr-line-dashed"></div>
							   <div class="form-group">
									<label class="col-sm-2 control-label">付款确认时间</label>
									<div class="col-sm-10">
										<input type="text" class="form-control" placeholder="付款确认时间" id="payment_confirm_time" name="payment_confirm_time" v-bind:value="porderInfo!=null?porderInfo.payment_confirm_time:''">
									</div>
								</div>
							<div class="hr-line-dashed"></div>
							   <div class="form-group">
									<label class="col-sm-2 control-label">退款金额</label>
									<div class="col-sm-10">
										<input type="text" class="form-control" placeholder="退款金额" id="refundMoney" name="refundMoney" v-bind:value="porderInfo!=null?porderInfo.refundMoney:''">
									</div>
								</div>
							<div class="hr-line-dashed"></div>
							   <div class="form-group">
									<label class="col-sm-2 control-label">支付金额</label>
									<div class="col-sm-10">
										<input type="text" class="form-control" placeholder="支付金额" id="paidMoney" name="paidMoney" v-bind:value="porderInfo!=null?porderInfo.paidMoney:''">
									</div>
								</div>
							<div class="hr-line-dashed"></div>
							   <div class="form-group">
									<label class="col-sm-2 control-label">未支付金额</label>
									<div class="col-sm-10">
										<input type="text" class="form-control" placeholder="未支付金额" id="unPaidMoney" name="unPaidMoney" v-bind:value="porderInfo!=null?porderInfo.unPaidMoney:''">
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
			data : {porderInfo:null},
			mounted : function(){
				var _this = this;
				$.post("porderInfo/findPorderInfoById.json?id="+$("#id").val(),function(data){
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
						var url = "porderInfo/savePorderInfo.json";

						if ($("#id").val().trim()!=null&&$("#id").val().trim()!=''&&$("#id").val().trim()!='0') {
							url = "porderInfo/updatePorderInfo.json";
						}
						$.post(url, $('#porderInfo').serialize(), function(data) {
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