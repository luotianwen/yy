<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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
	<link href="static/css/font-awesome.min.css" rel="stylesheet">
	<link href="static/css/animate.min.css" rel="stylesheet">
	<link href="static/css/style.min.css" rel="stylesheet">
	<link href="static/css/layerdate/layerdate.css" rel="stylesheet">
	<!-- iCheck -->
	<link href="static/css/plugins/iCheck/custom.css" rel="stylesheet">
	
	<style type="text/css">
		.form-control-inline {
		    width:200px;
		    display:inline;
		} 
	   .laydate-icon, .laydate-icon-default, .laydate-icon-danlan, .laydate-icon-dahong, .laydate-icon-molv {
		    height: 34px !important;; 
	    }
	</style>


</head>

<body class="gray-bg">
	<div class="wrapper wrapper-content animated fadeInRight">
		<div class="row">
			<div id="user-box" class="col-sm-12">
				<div class="ibox">
					<div class="ibox-content" id="vue">
						<form id="coupons" method="post" class="form-horizontal ">
							<input type="hidden" id="id" name="id" value="${coupons.id}"/>
							
							   <div class="form-group">
									<label class="col-sm-2 control-label">优惠券名称：</label>
									<div class="col-sm-5">
										<input type="text" class="form-control" placeholder="优惠券名称" id="name" name="name"  value="${coupons.name }">
										<span class="help-block m-b-none">*名称最多50个字符</span>
									</div>
								</div>
							<div class="hr-line-dashed"></div>
							   <div class="form-group">
									<label class="col-sm-2 control-label">类型：</label>
									 <div class="col-sm-5">
                                        <label>
                                            <input type="radio"  <c:if test="${coupons.type == 1 }">checked</c:if> value="1" name="type" class="radio i-checks"> <i></i> 优惠券
                                        </label> &nbsp;
                                        <label>
                                            <input type="radio"  <c:if test="${coupons.type == 2 }">checked</c:if>  value="2" name="type" class="radio i-checks"> <i></i> 现金券
                                        </label> &nbsp;
                                        <label>
                                            <input type="radio"  <c:if test="${coupons.type == 3 }">checked</c:if> value="3" name="type" class="radio i-checks"> <i></i> 弹出券
                                        </label>
									</div>
								</div>
							<div class="hr-line-dashed"></div>
							   <div class="form-group">
									<label class="col-sm-2 control-label">适用范围：</label>
									 <div class="col-sm-10">
		                                        <label>
		                                            <input type="radio"  value="1"  <c:if test="${coupons.scope == 1 }">checked</c:if> name="scope" class="radio i-checks"> <i></i> 全部商品
		                                        </label> &nbsp;
		                                        <label>
		                                            <input type="radio"  value="2"  <c:if test="${coupons.scope == 2 }">checked</c:if> name="scope" class="radio i-checks"> <i></i> 指定商品（参加）
		                                        </label> &nbsp;
		                                        <label>
		                                            <input type="radio"  value="3"  <c:if test="${coupons.scope == 3 }">checked</c:if> name="scope" class="radio i-checks"> <i></i> 指定商品（不参加）
		                                        </label>&nbsp;
		                                        <label>
		                                            <input type="radio"  value="4"  <c:if test="${coupons.scope == 4 }">checked</c:if> name="scope" class="radio i-checks"> <i></i> 指定商铺（参加）
		                                        </label> &nbsp;
		                                        <label>
		                                            <input type="radio"  value="5"  <c:if test="${coupons.scope == 5 }">checked</c:if> name="scope" class="radio i-checks"> <i></i> 指定商铺（不参加）
		                                        </label> &nbsp;
		                                        <label>
		                                            <input type="radio"  value="6"  <c:if test="${coupons.scope == 6 }">checked</c:if> name="scope" class="radio i-checks"> <i></i> 指定分类（参加）
		                                        </label>&nbsp;
		                                        <label>
		                                            <input type="radio"  value="7"  <c:if test="${coupons.scope == 7 }">checked</c:if> name="scope" class="radio i-checks"> <i></i> 指定分类（不参加）
		                                        </label> 
		                                </div>
									<!-- <div class="col-sm-5">
										<input type="text" class="form-control" placeholder="适用范围" id="scope" name="scope" value="{{scope}}">
									</div> -->
								</div>
							<!-- <div class="hr-line-dashed"></div>
							   <div class="form-group">
									<label class="col-sm-2 control-label">使用分类：</label>
									<div class="col-sm-5">
										<input type="text" class="form-control" placeholder="使用分类" id="category" name="category" value="{{category}}">
									</div>
								</div> -->
						<!-- 	<div class="hr-line-dashed"></div>
							   <div class="form-group">
									<label class="col-sm-2 control-label">创建人</label>
									<div class="col-sm-5">
										<input type="text" class="form-control" placeholder="创建人" id="user_id" name="user_id" value="{{user_id}}">
									</div>
								</div> -->
							<!-- <div class="hr-line-dashed"></div>
							   <div class="form-group">
									<label class="col-sm-2 control-label">店铺：</label>
									<div class="col-sm-5">
										<input type="text" class="form-control" placeholder="店铺" id="sellerId" name="sellerId" value="{{sellerId}}">
									</div>
								</div> -->
						 
							<div class="hr-line-dashed"></div>
							   <div class="form-group">
									<label class="col-sm-2 control-label">优惠券面值：</label>
									
								 <div class="col-sm-10">
                                        <label>
                                            订单满&nbsp;<input type="number" class="form-control form-control-inline" placeholder="" id="full" name="full" value="${coupons.full}">
                                            元&nbsp;&nbsp;&nbsp;
                                        </label>
                                        <label>
                                        	减
                                           <input type="number" class="form-control form-control-inline" placeholder="" id="minus" name="minus" value="${coupons.minus}">
                                        	元&nbsp;满、减金额须为正整数
                                        </label>
                                </div>  
								 
								</div>
						 
							<div class="hr-line-dashed"></div>
							   <div class="form-group">
									<label class="col-sm-2 control-label">优惠券有效期：</label>
									<div class="col-sm-10">
										<label>
											<input type="text" class="form-control form-control-inline form_datetime laydate-icon" readonly placeholder="有效期开始时间" id="startDate" name="startDate" value="<fmt:formatDate value="${coupons.startDate}" pattern="yyyy-MM-dd HH:mm:ss"/>">
											&nbsp;至&nbsp;
										</label>	
									    <label>
											<input  type="text"  value="<fmt:formatDate value="${coupons.endDate}" pattern="yyyy-MM-dd HH:mm:ss"/>" id="endDate" name="endDate" readonly  placeholder="有效期结束时间" class="form-control form-control-inline form_datetime laydate-icon">
										</label>
									</div>
								</div>
				 
							<div class="hr-line-dashed"></div>
							   <div class="form-group">
									<label class="col-sm-2 control-label">发券数量：</label>
									<div class="col-sm-5">
										<label>
											<input type="number" class="form-control form-control-inline" placeholder="发券数量" id="number" name="number" value="${coupons.number}">
											张
										</label>
										<span class="help-block m-b-none">*发券数量应为'1~100000'之间的整数</span>
									</div>
								</div>
								
							<div class="hr-line-dashed"></div>
							   <div class="form-group">
									<label class="col-sm-2 control-label">优惠券说明：</label>
									<div class="col-sm-5">
										<input type="text" class="form-control" placeholder="优惠券说明" id="note" name="note" value="${coupons.note}">
									</div>
								</div>
							<div class="hr-line-dashed"></div>
							   <div class="form-group">
									<label class="col-sm-2 control-label">领取地址：</label>
									<div class="col-sm-5">
										<input type="text" class="form-control" placeholder="领取地址" id="url" name="url" value="${coupons.url}">
									</div>
								</div>
								
							<div class="hr-line-dashed"></div>
							   <div class="form-group">
									<label class="col-sm-2 control-label">备注：</label>
									<div class="col-sm-5">
									    <textarea id="remark" name="remark" class="form-control" required="" aria-required="true">${coupons.remark}</textarea>
										<!-- <input type="text" class="form-control" placeholder="备注" id="remark" name="remark" value="{{remark}}"> -->
									</div>
								</div>
							<div class="hr-line-dashed"></div>
					 		
					 		<!-- 指定参加/不参加商品Start -->
					 		<div id="productInfo">
					 			<form id="product" method="post" class="form-horizontal ">
									<div class="alert alert-info">
										优惠券待筛选商品区域&gt;根据活动指定参加活动商品或不参加活动商品</div>
									<div class="col-sm-2 m-b-xs">
										<input name="productId" type="text" placeholder="请输入商品编号" class="input-sm form-control">
									</div>
									<div class="col-sm-2 m-b-xs">
										<input name="sku" type="text" placeholder="请输入商品SKU" class="input-sm form-control">
									</div>
									<div class="col-sm-2 m-b-xs">
										<input name="productName" type="text" placeholder="请输入商品名称" class="input-sm form-control">
									</div>
									
									<div class="col-sm-2 m-b-xs">
										<select class="input-sm form-control" id="category" @change="selectCategory()">
											<option>请选择一级分类</option>
											<option v-for="(category,index) in categorys" :value="index">{{category.name}}</option>
										</select>
									</div>
									<div class="col-sm-2 m-b-xs">
										<select class="input-sm form-control" name="categoryc">
											<option value="0">请选择二级分类</option>
											<option v-for="category in categorysc" :value="category.id">{{category.name}}</option>
										</select>
									</div>
									
									<div class="col-sm-2 m-b-xs">
										<div class="input-group">
											<span class="input-group-btn">
												<a class="btn btn-sm btn-primary" @click="queryProduct" style="cursor: pointer">查询</a>
											</span>
										</div>
									</div>
									<table class="table table-striped">
										<thead>
											<tr>
												<th>
													<input type="checkbox" @click="checkallp()">
												</th>
												<th>商品图片</th>
												<th>SKU编码</th>
												<th>商品货号</th>
												<th>商品名称</th>
												<th>属性</th>
												<th>状态</th>
												<th>市场价</th>
												<th>世峰价</th>
												<th>库存</th>
											</tr>
										</thead>
										<tbody>
											<tr v-if="products.length==0">
												<td style="text-align: center" colspan="10">尚未找到相关商品</td>
											</tr>
											<tr v-else v-for="(product,index) in products">
												<td>
													<input type="checkbox" :value="index" v-model="checkboxModelp">
												</td>
												<td>
													<img width="50" height="50" :src="product.image">
												</td>
												<td>{{product.sku}}</td>
												<td>{{product.number}}</td>
												<td>{{product.name}}</td>
												<td>{{product.porperty}}</td>
												<td>{{product.state==1?'上架':product.state==2?'下架':'删除'}}</td>
												<td style="color: green">￥{{product.marketprice}}</td>
												<td style="color: red">￥{{product.price}}</td>
												<td>{{product.stocks}}</td>
											</tr>
										</tbody>
									</table>
									<div style="overflow: hidden; width: 100%;">
										<div style="float: left; margin-top: 10px;">
											<a class="btn btn-primary" @click="checkboxp()">设置商品</a>
										</div>
										<div id="productPage" style="float: right; margin-top: 10px; margin-bottom: 30px;"></div>
									</div>
									<div class="alert alert-info">优惠券活动商品&gt;已参加或不参加的活动商品列表</div>
									<div class="table-responsive">
										<table class="table table-striped">
											<thead>
												<tr>
													<th>商品图片</th>
													<th>SKU编码</th>
													<th>商品货号</th>
													<th>商品名称</th>
													<th>属性</th>
													<th>市场价</th>
													<th>世峰价</th>
													<th>库存</th>
													<th>操作</th>
												</tr>
											</thead>
											<tbody>
												<tr v-if="productc.length==0">
													<td style="text-align: center" colspan="9">尚未设置商品</td>
												</tr>
												<tr v-else v-for="(product,index) in productc">
													<td>
														<img width="50" height="50" :src="product.image">
													</td>
													<td>{{product.sku}}</td>
													<td>{{product.number}}</td>
													<td>{{product.name}}</td>
													<td>{{product.porperty}}</td>
													<td style="color: green">￥{{product.marketprice}}</td>
													<td style="color: red">￥{{product.price}}</td>
													<td>{{product.stocks}}</td>
													<td>
														<button class="btn btn-outline btn-danger" type="button" @click="deleteProduct(index)">
															<i class="fa fa-trash"></i> 删除
														</button>
													</td>
												</tr>
											</tbody>
										</table>
									</div>
								</form>
							</div>
							<!-- 指定参加/不参加商品end -->
							
							<!-- 指定参加/不参加店铺Start -->
							<div v-if="false">
					 			<form id="shopinfos" method="post" class="form-horizontal">
									<div class="alert alert-info">
										优惠券待选店铺区域&gt;可根据需求设置指定店铺参加活动或不参加活动
									</div>
									<div class="col-sm-2 m-b-xs">
										<input name="shopId" type="text" placeholder="请输入店铺编号" class="input-sm form-control">
									</div>
									<div class="col-sm-2 m-b-xs">
										<input name="shopName" type="text" placeholder="请输入店铺名称" class="input-sm form-control">
									</div>
									
									<div class="col-sm-2 m-b-xs">
										<div class="input-group">
											<span class="input-group-btn">
												<a class="btn btn-sm btn-primary" @click="queryShop" style="cursor: pointer">查询</a>
											</span>
										</div>
									</div>
									<table class="table table-striped">
										<thead>
											<tr>
												<th>
													<input type="checkbox" @click="checkalls()">
												</th>
												<th>
													店铺名称
												</th>
											</tr>
										</thead>
										<tbody>
											<tr v-if="shopinfos.length==0">
												<td style="text-align: center" colspan="10">尚未找到相关商品</td>
											</tr>
											<tr v-else v-for="(shop,index) in shopinfos">
												<td>
													<input type="checkbox" :value="index" v-model="checkboxModels">
												</td>
												<td>{{shop.name}}</td>
											</tr>
										</tbody>
									</table>
									<div style="overflow: hidden; width: 100%;">
										<div style="float: left; margin-top: 10px;">
											<a class="btn btn-primary" @click="checkboxs()">设置店铺</a>
										</div>
										<div id="shopPage" style="float: right; margin-top: 10px; margin-bottom: 30px;"></div>
									</div>
									<div class="alert alert-info">
										优惠券活动店铺&gt;已参加或不参加的活动店铺列表
									</div>
									<div class="table-responsive">
										<table class="table table-striped">
											<thead>
												<tr>
													<th>店铺名称</th>
													<th>操作</th>
												</tr>
											</thead>
											<tbody>
												<tr v-if="shopinfoc.length==0">
													<td style="text-align: center" colspan="9">尚未设置商品</td>
												</tr>
												<tr v-else v-for="(shop,index) in shopinfoc">
													<td name="shopId">{{shop.name}}</td>
													<td>
														<button class="btn btn-outline btn-danger" type="button" @click="deleteShop(index)">
															<i class="fa fa-trash"></i> 删除
														</button>
													</td>
												</tr>
											</tbody>
										</table>
									</div>
								</form>
							</div>
							<!-- 指定参加/不参加店铺End -->
					 		
							
							<div class="form-group">
								<div class="col-sm-4 col-sm-offset-2">
									<a class="btn btn-primary" id="submit" >写好了，创建</a>
									<a class="btn btn-white" id="cancel" onclick="parent.layer.close(parent.layer.getFrameIndex(window.name))">放弃，返回</a>
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
	<script src="static/js/plugins/layer/layer.min.js"></script>
	<!-- iCheck -->
	<script src="static/js/plugins/iCheck/icheck.min.js"></script>
	<script src="static/js/plugins/layer/laydate/laydate.js"></script>
	
    <script src="static/js/plugins/validate/jquery.validate.min.js"></script>
    <script src="static/js/plugins/validate/messages_zh.min.js"></script>
    
	<script type="text/javascript">
		$('#scope').on('ifChecked', "label", function() {
			var num = $(this).find("input").val();
			if (num == 2 || num == 3) {
				$.post("category/findAllCategory.json",function(data){
					_this.categorys = data.categorys;
				})
				if(){
					$.post("couponsrange/findAllCouponsRange.json",{id:_this.coupons.id,scope:_this.isShow},function(data){
						_this.productc = data;
					})
				}
			} else if (num == 4 || num == 5) {
				$.post("couponsrange/findAllCouponsRange.json",{id:_this.coupons.id,scope:_this.isShow},function(data){
					_this.shopinfoc = data;
				})
			} else if (num == 6 || num == 7) {
				
			}else{
				
			}
		});
		
		$(".i-checks").iCheck({
			labelHover : false, 
			cursor : true, 
		    radioClass: "iradio_square-green",
		 });
		//设置本页layer皮肤
        layer.config({
        	skin:'layui-layer-molv',
        });
        laydate.skin('huanglv');
        laydate({
            elem: '#startDate',
            min: laydate.now(),
            istime: true,
            format: 'YYYY-MM-DD hh:mm:ss'
        });
        laydate({
            elem: '#endDate',
            min: laydate.now(),
            istime: true,
            format: 'YYYY-MM-DD hh:mm:ss'
        });
        

        var err = "<i class='fa fa-times-circle'></i> ";
		 jQuery.validator.methods.compareDate = function(value, element, param) { 
	            var startDate = $(param).val();
	            var date1 = new Date(startDate);
	            var date2 = new Date(value);
	            return this.optional(element) || date1 < date2;
	     }; 
		 jQuery.validator.methods.compareNumber = function(value, element, param) { 
	            var n1 = $(param).val();
	            return this.optional(element) || value < n1;
	     }; 
	     $("#coupons").validate({
	         rules: {
	        	 name: {
	                 required: true
	             },
	        	 startDate: {
	                 required: true
	             },
	             endDate: {
	                 required: true,
	                 compareDate: "#startDate"
	             },
	             number:{
	            	 required: true,
	            	 digits: true,
	            	 min:1,
	            	 max:100000
	             },
	             full:{
	            	 required: true,
	            	 digits: true,
	            	 min:1
	             },
	             minus:{
	            	 required: true,
	            	 digits: true,
	            	 //compareNumber: "#full",
	            	 min:1
	             },
	             remark:{
	            	 required: false,
	            	 minlength: 0,
	            	 maxlength: 20 
	             }
	         },
	         messages: {
	        	 name: {
	                 required: err + "优惠券名称不能为空！"
	             },
	        	 startDate: {
	                 required: err + "优惠券有效期开始时间不能为空！"
	             },
	             endDate: {
	                 required: err + "优惠券有效期结束时间不能为空！",
	                 compareDate: err +"有效期结束日期必须大于开始日期!"
	             },
	             number:{
	            	 required: err + "数量不能为空！",
	            	 digits: err +"只能输入正整数"
	             },
	             full:{
	            	 required: err + "满额不能为空！",
	            	 digits: err +"只能输入正整数"
	             },
	             minus:{
	            	 required: err + "减额不能为空！",
	            	 compareNumber:err +"减额必须小于满额",
	            	 digits: err +"只能输入正整数"
	             }
	         }
		 });
	     
         $("#submit").on("click" , function(){
        	 if($("#coupons").valid()){
					layer.load(0, {
						shade : 0.3
					});
					var url = "coupons/saveCoupons.json";

					if ($("#id").val().trim()!=null&&$("#id").val().trim()!=''&&$("#id").val().trim()!='0') {
						url = "coupons/updateCoupons.json";
					}
					
							$.post(url, $('#coupons').serialize(), function(data) {
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
         	  
         }); 
	     
	     

	</script>


</body>


</html>