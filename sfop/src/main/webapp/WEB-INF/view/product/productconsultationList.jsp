<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
					<form id="productconsultation" method="post">
						<div class="ibox-content">
							<h2>管理</h2>
							<div class="input-group">
								<div class="col-md-3 m-b-xs">
									<input placeholder="商品名称" name="name" class="input form-control">
								</div>
								<div class="col-md-3 m-b-xs">
									<input placeholder="买家姓名" name="receiveName" class="input form-control">
								</div>
								
								<div class="col-md-3 m-b-xs">
									<select name="state" class="input form-control">
										<option value="0">—店铺—</option>
										<c:forEach items="${shopinfos}" var="shopinfo">
											<option value="${shopinfo.s_merchants_id}">${shopinfo.name}</option>
										</c:forEach>
									</select>
								</div>
								
								<div class="col-md-3 m-b-xs">
									<select name="state" class="input form-control">
										<option value="0">—审核状态—</option>
										<option value="1">未审核</option>
										<option value="2">审核成功</option>
										<option value="3">审核失败</option>
									</select>
								</div>
								
								<div class="col-md-3">
									<button type="button" @click="submit" class="btn btn btn-primary">
										<i class="fa fa-search"></i> 搜索
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
														<th>商品名称</th>
														<th>店铺名称</th>
														<th>买家姓名</th>
														<th>内容</th>
														<th>创建时间</th>
														<th>审核状态</th>
														<th>操作</th>
													</tr>
												</thead>
												<tbody v-for="(productconsultation,index) in productconsultations">
													<tr>
														<td>{{productconsultation.name}}</td>
														<td>{{productconsultation.shopName}}</td>
														<td>{{productconsultation.receiveName}}</td>
														<td>{{productconsultation.content}}</td>
														<td>{{productconsultation.cdate}}</td>
														<td>
															<span v-if="productconsultation.state==1">未审核</span>
															<span v-if="productconsultation.state==2">审核成功</span>
															<span v-if="productconsultation.state==3">审核失败</span>
														</td>
														<td>
															<button type="button" v-if="productconsultation.state!=2" @click="audit(productconsultation.id,2)" class="btn btn-outline btn-primary">
																通过
															</button>
															<button type="button" v-if="productconsultation.state!=3" @click="audit(productconsultation.id,3)" class="btn btn-outline btn-danger">
																驳回
															</button>
														</td>
													</tr>
													<tr v-if="productconsultation.productConsultationReplay!=null">
														<td>
															管理员：  {{productconsultation.productConsultationReplay.rName}}
														</td>
														<td>
															回复时间：{{productconsultation.productConsultationReplay.rdate}}
														</td>
														<td colspan="5">
															商家回复内容：{{productconsultation.productConsultationReplay.rcontent}}
														</td>
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
			el : "#vue",
			data : {page:null,productconsultations:null},
			mounted : function(){
				spage(1,"productconsultation/findAllProductConsultation.json",this,"page");
			},
			methods : {
				audit : function(id,state){
					var _this = this;
					layer.load(0, {
						shade : 0.3
					});
					$.post("productconsultation/updateProductConsultation.json",{id:id,state:state},function(data){
						layer.closeAll('loading');
						if (data.RESPONSE_STATE == '200') {
							layer.msg('审核成功', {
								icon : 1,
								time : 1 * 1000
							},function(){
								_this.submit();
							});
						} else {
							layer.alert(data.ERROR_INFO, {
								icon : 0
							});
						}
					})
				},
				submit : function(){
					spage(1,"productconsultation/findAllProductConsultation.json",this,"page",$('#productconsultation').serialize());
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