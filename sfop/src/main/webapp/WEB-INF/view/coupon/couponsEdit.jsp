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
	<link href="static/css/font-awesome.min.css" rel="stylesheet">
	<link href="static/css/animate.min.css" rel="stylesheet">
	<link href="static/css/style.min.css" rel="stylesheet">
	<link href="static/css/layerdate/layerdate.css" rel="stylesheet">
	<!-- iCheck -->
	<link href="static/css/plugins/iCheck/custom.css" rel="stylesheet">
	<link rel="stylesheet" href="static/js/zTree_v3/css/zTreeStyle/zTreeStyle.css" type="text/css">
	
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
					<div class="ibox-content">
						<div id="vue">
						<form id="coupons" method="post" class="form-horizontal ">
							<input type="hidden" id="id" name="id" value="${id}"/>
							
							   <div class="form-group">
									<label class="col-sm-2 control-label">优惠券名称：</label>
									<div class="col-sm-5">
										<input type="text" class="form-control" placeholder="优惠券名称" id="name" name="name" maxlength="50" v-bind:value="coupons!=null?coupons.name:''">
										<span class="help-block m-b-none">*名称最多50个字符</span>
									</div>
								</div>
							<div class="hr-line-dashed"></div>
							   <div class="form-group">
									<label class="col-sm-2 control-label">类型：</label>
									 <div class="col-sm-5">
		                                        <label>
		                                            <input type="radio"  v-bind:checked="coupons!=null&&coupons.type== 1"  value="1" name="type" class="radio i-checks"> <i></i> 优惠券
		                                        </label> &nbsp;
		                                        <label>
		                                            <input type="radio"  v-bind:checked="coupons!=null&&coupons.type== 2"  value="2" name="type" class="radio i-checks"> <i></i> 现金券
		                                        </label> &nbsp;
		                                        <label>
		                                            <input type="radio"  v-bind:checked="coupons!=null&&coupons.type== 3"  value="3" name="type" class="radio i-checks"> <i></i> 弹出券
		                                        </label>
		                                </div>
								</div>
							<div class="hr-line-dashed"></div>
							   <div class="form-group">
									<label class="col-sm-2 control-label">适用范围：</label>
									 <div class="col-sm-10" id="scope">
		                                        <label>
		                                            <input type="radio"  value="1"  v-bind:checked="coupons!=null&&coupons.scope== 1" name="scope" class="radio i-checks"> <i></i> 全部商品
		                                        </label> &nbsp;
		                                        <label>
		                                            <input type="radio"  value="2"  v-bind:checked="coupons!=null&&coupons.scope== 2"  name="scope" class="radio i-checks"> <i></i> 指定商品（参加）
		                                        </label> &nbsp;
		                                        <label>
		                                            <input type="radio"  value="3"  v-bind:checked="coupons!=null&&coupons.scope== '3'"  name="scope" class="radio i-checks"> <i></i> 指定商品（不参加）
		                                        </label>&nbsp;
		                                        <label>
		                                            <input type="radio"  value="4"  v-bind:checked="coupons!=null&&coupons.scope== 4"  name="scope" class="radio i-checks"> <i></i> 指定商铺（参加）
		                                        </label> &nbsp;
		                                        <label>
		                                            <input type="radio"  value="5"  v-bind:checked="coupons!=null&&coupons.scope== 5"  name="scope" class="radio i-checks"> <i></i> 指定商铺（不参加）
		                                        </label> &nbsp;
		                                        <label>
		                                            <input type="radio"  value="6"  v-bind:checked="coupons!=null&&coupons.scope== 6" name="scope" class="radio i-checks"> <i></i> 指定分类（参加）
		                                        </label>&nbsp;
		                                        <label>
		                                            <input type="radio"  value="7"  v-bind:checked="coupons!=null&&coupons.scope== 7"  name="scope" class="radio i-checks"> <i></i> 指定分类（不参加）
		                                        </label> 
		                                </div>
								</div>
							<div class="hr-line-dashed"></div>
							   <div class="form-group">
									<label class="col-sm-2 control-label">优惠券面值：</label>
									
								 <div class="col-sm-10">
                                        <label>
                                            订单满&nbsp;<input type="number" class="form-control form-control-inline" placeholder="" id="full" name="full" :value="coupons!=null?coupons.full:''">
                                            元&nbsp;&nbsp;&nbsp;
                                        </label>
                                        <label>
                                        	减
                                           <input type="number" class="form-control form-control-inline" placeholder="" id="minus" name="minus" :value="coupons!=null?coupons.minus:''">
                                        	元&nbsp;满、减金额须为正整数
                                        </label>
                                </div>  
								 
								</div>
						 
							<div class="hr-line-dashed"></div>
							   <div class="form-group">
									<label class="col-sm-2 control-label">优惠券有效期：</label>
									<div class="col-sm-10">
										<label>
											<input type="text" class="form-control form-control-inline form_datetime laydate-icon" readonly placeholder="有效期开始时间" id="startDate" name="startDate" :value="coupons!=null?coupons.startDate:''">
											&nbsp;至&nbsp;
										</label>	
									    <label>
											<input  type="text"  :value="coupons!=null?coupons.endDate:''" id="endDate" name="endDate" readonly  placeholder="有效期结束时间" class="form-control form-control-inline form_datetime laydate-icon">
										</label>
									</div>
								</div>
				 
							<div class="hr-line-dashed"></div>
							   <div class="form-group">
									<label class="col-sm-2 control-label">发券数量：</label>
									<div class="col-sm-5">
										<label>
											<input type="number" class="form-control form-control-inline" placeholder="发券数量" id="number" name="number" :value="coupons!=null?coupons.number:''">
											张
										</label>
										<span class="help-block m-b-none">*发券数量应为'1~100000'之间的整数</span>
									</div>
								</div>
								
							<div class="hr-line-dashed"></div>
							   <div class="form-group">
									<label class="col-sm-2 control-label">优惠券说明：</label>
									<div class="col-sm-5">
										<input type="text" class="form-control" placeholder="优惠券说明" id="note" name="note" :value="coupons!=null?coupons.note:''">
									</div>
								</div>
							<div class="hr-line-dashed"></div>
							   <div class="form-group">
									<label class="col-sm-2 control-label">领取地址：</label>
									<div class="col-sm-5">
										<input type="text" class="form-control" placeholder="领取地址" id="url" name="url" :value="coupons!=null?coupons.url:''">
									</div>
								</div>
								
							<div class="hr-line-dashed"></div>
							   <div class="form-group">
									<label class="col-sm-2 control-label">备注：</label>
									<div class="col-sm-5">
									    <textarea id="remark" name="remark" class="form-control" required="" aria-required="true">{{coupons!=null?coupons.remark:''}}</textarea>
										<!-- <input type="text" class="form-control" placeholder="备注" id="remark" name="remark" value="{{remark}}"> -->
									</div>
								</div>
							<div class="hr-line-dashed"></div>
					 	</form>
					 	</div>
					 	<div id="info">
					 		<!-- 指定参加/不参加商品Start -->
					 		<div v-if="isShow==2||isShow==3">
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
											<option value="">请选择二级分类</option>
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
							<div v-if="isShow==4||isShow==5">
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
							
							<!-- 指定参加/不参加分类Start -->
							<div id="category" v-show="isShow==6||isShow==7">
								<div class="alert alert-info">
									优惠券待选分类区域&gt;可根据需求设置指定分类参加活动或不参加活动
								</div>
								<div style="margin-left: 10%;">
									<ul id="tree" class="ztree"></ul>
								</div>
							</div>
							<!-- 指定参加/不参加分类End -->
						</div>
							
							<div class="form-group" id="submit">
								<div class="col-sm-4 col-sm-offset-2">
									<a class="btn btn-primary" @click="submit">写好了，创建</a>
									<a class="btn btn-white" id="cancel" onclick="parent.layer.close(parent.layer.getFrameIndex(window.name))">放弃，返回</a>
								</div>
							</div>
						
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
	<script src="static/js/plugins/layer/laypage/laypage.js"></script>
	<!-- iCheck -->
	<script src="static/js/plugins/iCheck/icheck.min.js"></script>
	<script src="static/js/plugins/validate/jquery.validate.min.js"></script>
    <script src="static/js/plugins/validate/messages_zh.min.js"></script>
    <script type="text/javascript" src="static/js/zTree_v3/js/jquery.ztree.core-3.5.js"></script>
	<script type="text/javascript" src="static/js/zTree_v3/js/jquery.ztree.excheck-3.5.js"></script>
    
	<script type="text/javascript">
		$.ajaxSetup({
			async : false
		});
		
		var info = new Vue({
			el : "#info",
			data : {
				isShow : '1',
				page : {},
				products : [],
				productc : [],
				categorys : [],
				categorysc : [],
				shopinfos : [],
				shopinfoc : [],
				checkboxModelp : [],
				checkp : true,
				checkboxModels : [],
				checks : true
			},
			methods : {
				selectScope : function(num,vue){
					var _this = this;
					if (num == 2 || num == 3) {
						_this.isShow = num;
						if(_this.categorys.length==0){
							$.post("category/findAllCategory.json",function(data){
								Vue.set(_this.$data,"categorys",data.categorys);
							})
						}
						if(vue.coupons!='undefined'&&vue.coupons!=null&&vue.coupons.scope==num){
							if(_this.productc.length==0){
								$.post("couponsrange/findAllCouponsRange.json",{id:vue.coupons.id,scope:_this.isShow},function(data){
									Vue.set(_this.$data,"productc",data);
								})
							}
						}
					} else if (num == 4 || num == 5) {
						_this.isShow = num;
						if(vue.coupons!='undefined'&&vue.coupons!=null&&vue.coupons.scope==num){
							if(_this.shopinfoc.length==0){
								$.post("couponsrange/findAllCouponsRange.json",{id:vue.coupons.id,scope:_this.isShow},function(data){
									Vue.set(_this.$data,"shopinfoc",data);
								})
							}
						}
					} else if (num == 6 || num == 7) {
						_this.isShow = num;
						if($("#tree").html()==null||$("#tree").html()==''){
							var _this = this;
							var str = '';
							if(vue.coupons!='undefined'&&vue.coupons!=null&&vue.coupons.scope==num){
								str = "?id="+vue.coupons.id;
							}
							
							$.post("couponsrange/findAllCategoryForCoupons.json"+str, function(data) {
								var setting = {
									check : {
										enable : true
									},
									data : {
										simpleData : {
											enable : true
										}
									}
								};

								var zNodes = new Array();
								if(data.category!=null){
									for(var i=0,len=data.category.length;i<len;i++){
										var category = data.category[i];
										zNodes.splice(0,0,category);
										if(category.nodes!=null){
											for(var j=0,jlen=category.nodes.length;j<jlen;j++){
												zNodes.splice(0,0,category.nodes[j]);
											}
										}
									}
									// 初始化方法
									$.fn.zTree.init($("#tree"), setting, zNodes);
								}
							})
						}
					}else{
						_this.isShow = "1";
					}
				},
				selectCategory : function(){
					var index = $("#category").val();
					if(index!=null){
						var _this = this;
						Vue.set(_this.$data,"categorysc",_this.categorys[index].nodes);
					}
				},
				queryProduct : function(){
					spage(1,"couponsrange/findProductForCoupons.json",this,"productPage",$('#product').serialize());
				},
				checkallp : function(){
					var _this = this;
					if(_this.checkp){
						if(_this.products!="undefined"){
							_this.checkboxModelp = [];
							for(var i=0,len=_this.products.length;i<len;i++){
								_this.checkboxModelp.push(i);
							}
						}
						_this.checkp = false;
					}else{
						_this.checkboxModelp = [];
						_this.checkp = true;
					}
				},
				checkboxp : function(){
					var _this = this;
					for(var i=0,len=_this.checkboxModelp.length;i<len;i++){
						var bool = true;
						for(var j=0,lenj=_this.productc.length;j<lenj;j++){
							if(_this.productc[j].sku==_this.products[_this.checkboxModelp[i]].sku){
								bool = false;
							}
						}
						if(bool){
							_this.productc.push(_this.products[_this.checkboxModelp[i]]);
						}
					}
				},
				deleteProduct : function(index){
					var _this = this;
					layer.confirm("确定删除该商品？", {
						shade : 0.3,
						btn : [ '确认', '取消' ],
						icon : 3
					}, function(layerIndex) {
						layer.close(layerIndex);
						_this.productc.splice(index,1);
					})
				},
				queryShop : function(){
					spage(1,"shopinfo/findAllShopinfo.json",this,"shopPage",$('#shopinfos').serialize());
				},
				checkalls : function(){
					var _this = this;
					if(_this.checks){
						if(_this.shopinfos!="undefined"){
							_this.checkboxModels = [];
							for(var i=0,len=_this.shopinfos.length;i<len;i++){
								_this.checkboxModels.push(i);
							}
						}
						_this.checks = false;
					}else{
						_this.checkboxModels = [];
						_this.checks = true;
					}
				},
				checkboxs : function(){
					var _this = this;
					if(_this.shopinfoc==null||_this.shopinfoc==''){
						_this.shopinfoc = [];
					}
					for(var i=0,len=_this.checkboxModels.length;i<len;i++){
						var bool = true;
						for(var j=0,lenj=_this.shopinfoc.length;j<lenj;j++){
							if(_this.shopinfoc[j].name==_this.shopinfos[_this.checkboxModels[i]].name){
								bool = false;
							}
						}
						if(bool){
							_this.shopinfoc.push(_this.shopinfos[_this.checkboxModels[i]]);
						}
						
					}
				},
				deleteShop : function(index){
					var _this = this;
					layer.confirm("确定删除该店铺？", {
						shade : 0.3,
						btn : [ '确认', '取消' ],
						icon : 3
					}, function(layerIndex) {
						layer.close(layerIndex);
						_this.shopinfoc.splice(index,1);
					})
				}
			}
		})
		
		var vue = new Vue({
			el : "#vue",
			data : {
				coupons : null
			},
			mounted : function() {
				var _this = this;
				$.post("coupons/findCouponsById.json?id="+$("#id").val(),function(data) {
					for ( var key in data) {
						if (_this.key == undefined) {
							Vue.set(_this.$data, key, data[key]);
						} else {
							_this.key = data[key];
						}
					}
					if(_this.coupons!='undefined'&&_this.coupons!=null){
						info.isShow = _this.coupons.scope;
						info.selectScope(info.isShow,_this);
					}
				})
			}
		})
	
		new Vue({
			el : "#submit",
			methods : {
				submit : function() {
					if ($("#coupons").valid()) {
						layer.load(0, {
							shade : 0.3
						});
						var url = "coupons/saveCoupons.json";

						if ($("#id").val().trim()!=null&&$("#id").val().trim()!=''&&$("#id").val().trim()!='0') {
							url = "coupons/updateCoupons.json";
						}
						
						var str = "";
						var _this = info;
						if(_this.isShow=="2"||_this.isShow=="3"){
							if(_this.productc!='undefined'&&_this.productc!=null){
								for(var i=0,len=_this.productc.length;i<len;i++){
									if(i==0){
										str = "?range="+_this.productc[i].sku;
									}else{
										str += ","+_this.productc[i].sku;
									}
								}
							}
						}else if(_this.isShow=="4"||_this.isShow=="5"){
							if(_this.shopinfoc!='undefined'&&_this.shopinfoc!=null){
								for(var i=0,len=_this.shopinfoc.length;i<len;i++){
									if(i==0){
										str = "?range="+_this.shopinfoc[i].s_merchants_id;
									}else{	
										str += ","+_this.shopinfoc[i].s_merchants_id;
									}
								}
							}
						}else if(_this.isShow=="6"||_this.isShow=="7"){
							// 获取当前被勾选的节点集合
							var treeObj = $.fn.zTree.getZTreeObj("tree");
							var nodes = treeObj.getCheckedNodes();
							var tmpNode;
							var ids = "";
							for(var i=0; i<nodes.length; i++){
								tmpNode = nodes[i];
								if(i!=nodes.length-1){
									ids += tmpNode.id+",";
								}else{
									ids += tmpNode.id;
								}
							}
							if(ids!=''){
								str = "?range="+ids
							}
						}
						$.post(url+str, $('#coupons').serialize(), function(data) {
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
					} else {
						$('.error').eq(0).focus();
					}
				},
				check_in : function() {
					if($("#id").val().trim()!=''){
						$("#id").val(0);
					}
					/* if ($('#name').val().trim() == '') {
						layer.tips('名称！！！', '#name', {
							tips : [ 1, '#019F95' ],
							time : 1500
						});
						$('#name').focus();
						return false;
					} */

					return true;
				}
			}
		})
		
		$(function() {
			//设置本页layer皮肤
			layer.config({
				skin : 'layui-layer-molv',
			});
			laydate.skin('huanglv');
			laydate({
				elem : '#startDate',
				min : laydate.now(),
				istime : true,
				format : 'YYYY-MM-DD hh:mm:ss'
			});
			laydate({
				elem : '#endDate',
				min : laydate.now(),
				istime : true,
				format : 'YYYY-MM-DD hh:mm:ss'
			});

			$('#scope').on('ifChecked', "label", function() {
				var num = $(this).find("input").val();
				info.selectScope(num,vue);
			});

			$(".i-checks").iCheck({
				labelHover : false,
				cursor : true,
				radioClass : "iradio_square-green",
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
				rules : {
					name : {
						required : true
					},
					startDate : {
						required : true
					},
					endDate : {
						required : true,
						compareDate : "#startDate"
					},
					number : {
						required : true,
						digits : true,
						min : 1,
						max : 100000
					},
					full : {
						required : true,
						digits : true,
						min : 1
					},
					minus : {
						required : true,
						digits : true,
						//compareNumber: "#full",
						min : 1
					},
					remark : {
						required : false,
						minlength : 0,
						maxlength : 20
					}
				},
				messages : {
					name : {
						required : err + "优惠券名称不能为空！"
					},
					startDate : {
						required : err + "优惠券有效期开始时间不能为空！"
					},
					endDate : {
						required : err + "优惠券有效期结束时间不能为空！",
						compareDate : err + "有效期结束日期必须大于开始日期!"
					},
					number : {
						required : err + "数量不能为空！",
						digits : err + "只能输入正整数"
					},
					full : {
						required : err + "满额不能为空！",
						digits : err + "只能输入正整数"
					},
					minus : {
						required : err + "减额不能为空！",
						compareNumber : err + "减额必须小于满额",
						digits : err + "只能输入正整数"
					}
				}
			});
		})
	</script>


</body>


</html>