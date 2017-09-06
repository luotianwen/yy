<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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

	<title>商城后台 - 管理</title>
	<link href="static/css/bootstrap.min.css" rel="stylesheet">
	<link href="static/css/font-awesome.min.css" rel="stylesheet">
	<!-- iCheck -->
	<link href="static/css/plugins/iCheck/custom.css" rel="stylesheet">
	<link href="static/css/animate.min.css" rel="stylesheet">
	<link href="static/css/style.min.css" rel="stylesheet">
</head>

<body class="gray-bg">
<div class="wrapper wrapper-content  animated fadeInRight" id="vue">
	<div class="row">
		<div id="user-box" class="col-sm-12">
			<div class="ibox">
				<form id="product" method="post">
					<input name="state" type="hidden" value="2">
					<div class="ibox-content">
						<div class="input-group">
							<div class="col-md-3">
								<input placeholder="商品名称" name="name" class="input form-control">
							</div>
							<div class="col-md-3">
								<input placeholder="商品编号" name="id" class="input form-control">
							</div>
							<div class="col-md-3">
								<select class="form-control m-b" name="shopid" placeholder="店铺" >
									<option value="0" >--店铺--</option>
									<c:forEach items="${shopinfos}" var="shopinfo">
										<option value="${shopinfo.s_merchants_id}" >${shopinfo.name}</option>
									</c:forEach>
								</select>
							</div>
							<div class="col-md-3">
								<select class="form-control m-b" name="brandid" placeholder="品牌" >
									<option value="0" >--品牌--</option>
									<c:forEach items="${brands}" var="brand">
										<option value="${brand.id}" >${brand.name}</option>
									</c:forEach>

								</select>
							</div>
							<div class="col-md-3">
								<select class="form-control m-b" name="cid" placeholder="分类" >
									<option value="0" >--分类--</option>
									<c:forEach items="${categorys}" var="category">
										<optgroup label="${category.name}" >
											<c:forEach items="${category.nodes}" var="node">
												<option value="${node.id}" >  ${category.name}/${node.name}</option>
											</c:forEach>
										</optgroup>
									</c:forEach>
								</select>
							</div>
							<div class="col-md-4">
								<button type="button" @click="submit" class="btn btn btn-primary">
									<i class="fa fa-search"></i> 搜索
								</button>
								<button type="button" @click="submit" class="btn btn btn-primary">
									<i class="fa fa-search"></i> excel
								</button>
							</div>
						</div>

						<div class="hr-line-dashed"></div>
						<div class="tab-content">
							<div class="tab-pane active">
								<div class="full-height-scroll">
									<div class="table-responsive">
										<table class="table table-striped table-hover">
											<thead>
											<tr>
												<td colspan="11">
													<div style="float: left">
														<input type="checkbox" class="checkbox" v-model="checked"  v-on:click="checkedAll" >

													</div>
													<div style="float: left;">全选<a  v-on:click="up" style="cursor: pointer; margin-left: 10px;" class="btn-primary">批量上架</a>&nbsp;<a  v-on:click="del" style="cursor: pointer; margin-left: 10px;" class="btn-primary">批量删除</a></div>

												</td>
											</tr>
											<tr>
												<th> </th>
												<th>商品编号</th>
												<th>店铺</th>
												<th>品牌</th>
												<th>分类</th>
												<th>最后修改时间</th>
												<th>最后修改人</th>
											</tr>
											</thead>
											<tbody v-for="(product,index) in products">
											<tr>
												<td class="t-c">
													<input type="checkbox" name="checkbox_name"  v-model="checkvalue"  v-bind:value="product.id"></td>
												<td  > 商品编号:{{product.id}}  </td>
											</tr>
											<tr>
												<td>&nbsp;</td>
												<td>
													<div id="p_info">
														<div class="p_img">
															<a href="javaScript:void(0);">
																<img width="50" height="50" v-bind:src="product.logo"></a>

															{{product.name}}
														</div>
													</div>
												</td>
												<td>{{product.shopName}}</td>
												<td>{{product.brandName}}</td>
												<td>{{product.categoryName}}</td>
												<td>{{product.lasttime}}</td>
												<td>{{product.updatename}}</td>
											</tr>
											</tbody>
										</table>
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
<script src="static/js/vue.js"></script>
<script src="static/js/jquery-2.1.1.min.js"></script>
<script src="static/js/bootstrap.min.js"></script>
<script src="static/js/plugins/layer/layer.min.js"></script>
<script src="static/js/plugins/layer/laypage/laypage.js"></script>
<script src="static/js/plugins/slimscroll/jquery.slimscroll.min.js"></script>

<!-- iCheck -->
<script src="static/js/plugins/iCheck/icheck.min.js"></script>

<script type="text/javascript">

	new Vue({
		el: "#vue",
		data: {page: null, products: null, checkvalue: [], checked: ""},
		mounted: function () {
			spage(1, "product/findAllProduct.json", this, "page", $('#product').serialize());
		},
		methods: {
			checkedAll: function () {
				var _this = this;
				if (!this.checked) {//实现反选
					_this.checkvalue = [];
				} else {//实现全选
					_this.checkvalue = [];
					_this.products.forEach(function (item) {
						_this.checkvalue.push(item.id);
					});
				}
			},
			/*
			 edit : function(id){
			 layer.open({
			 type : 2,
			 title : "编辑",
			 shade : 0.2,
			 area : [ "70%", "80%" ],
			 content : "product/goProductEdit.html?id=" + id
			 });
			 },*/submit : function () {
				spage(1, "product/findAllProduct.json", this, "page", $('#product').serialize());
			},
			del: function () {
				var _this = this;
				_checkvalue=_this.checkvalue.join();
				if (_checkvalue.length > 0) {

					layer.confirm("确认删除吗?", {
						shade: 0.3,
						btn: ['确认', '取消'],
						icon: 3
					}, function (layerIndex) {
						layer.close(layerIndex);
						$.post("product/deleteProduct.json", {id: _checkvalue}, function (data) {
							if (data.RESPONSE_STATE == '200') {
								layer.msg('操作成功!', {icon: 1, time: 1 * 1000}, function () {
									_this.submit();
								})
							} else {
								layer.closeAll('loading');
								layer.alert(data.ERROR_INFO, {
									icon: 0
								});
							}
						})
					});
				}
			},
			up: function () {
				var _this = this;
				_checkvalue=_this.checkvalue.join();
				if (_checkvalue.length > 0) {

					layer.confirm("确认上架吗?", {
						shade: 0.3,
						btn: ['确认', '取消'],
						icon: 3
					}, function (layerIndex) {
						layer.close(layerIndex);
						$.post("product/upProduct.json", {id: _checkvalue}, function (data) {
							if (data.RESPONSE_STATE == '200') {
								layer.msg('操作成功!', {icon: 1, time: 1 * 1000}, function () {
									_this.submit();
								})
							} else {
								layer.closeAll('loading');
								layer.alert(data.ERROR_INFO, {
									icon: 0
								});
							}
						})
					});
				}
			}
		},
		watch: {//深度 watcher
			'checkvalue': {
				handler: function (val, oldVal) {
					if (this.checkvalue.length === this.products.length) {
						this.checked = true;
					} else {
						this.checked = false;
					}
				},
				deep: true
			}
		}
	})
	$(function() {
		$(".full-height-scroll").slimScroll({
			height : "100%"
		});

		//设置本页layer皮肤
		layer.config({
			skin : 'layui-layer-molv',
		});
	});

</script>


</body>


</html>