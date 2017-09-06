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
					<form id="shopbrand" method="post">
						<div class="ibox-content">
							<h2>管理</h2>
							<div class="input-group">
								<div class="col-md-6 m-b-xs">
									<input placeholder="商家编号" name="s_merchants_id" class="input form-control">
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
														<th>编号</th>
														<th>商家编号</th>
														<th>品牌编号</th>
														<th>品牌资质有效期</th>
														<th>品牌资质电子版</th>
														<th>品牌名称</th>
														<th>品牌logo</th>
														<th>品牌首字母</th>
														<th>品牌类型</th>
														<th>商标注册人</th>
														<th>经营类型</th>
														<th>提交时间</th>
														<th>审核状态</th>
														<th>审核备注</th>
														<th>操作</th>
													</tr>
												</thead>
												<tbody>
													<tr v-for="(shopbrand,index) in shopbrands">
														<td>{{shopbrand.id}}</td>
														<td>{{shopbrand.s_merchants_id}}</td>
														<td>{{shopbrand.b_brand_id}}</td>
														<td>{{shopbrand.valid_period}}</td>
														<td>
															<img width="100" alt="" :src="shopbrand.qualification_img">
														</td>
														<td>{{shopbrand.brand==null?shopbrand.name:shopbrand.brand.name}}</td>
														<td>
															<img width="100" alt="" :src="shopbrand.brand==null?shopbrand.logo:shopbrand.brand.logo">
														</td>
														<td>
															<span v-if="shopbrand.brand==null">
																{{shopbrand.letter}}
															</span>
															<span v-else>
																{{shopbrand.brand.letter}}
															</span>
														</td>
														<td>
															<span v-if="shopbrand.brand==null">
																{{shopbrand.type==1?'国际品牌':'国内品牌'}}
															</span>
															<span v-else>
																{{shopbrand.brand.type==1?'国际品牌':'国内品牌'}}
															</span>
														</td>
														<td>
															<span v-if="shopbrand.brand==null">
																{{shopbrand.trademarktype==1?'企业':'个人'}}
															</span>
															<span v-else>
																{{shopbrand.brand.trademarktype==1?'企业':'个人'}}
															</span>
														</td>
														<td>
															<span v-if="shopbrand.brand==null">
																{{shopbrand.businesstype==1?'自有品牌':'代理品牌'}}
															</span>
															<span v-else>
																{{shopbrand.brand.businesstype==1?'自有品牌':'代理品牌'}}
															</span>
														</td>
														<td>{{shopbrand.submitime}}</td>
														<td>
															<span v-if="shopbrand.state==1">
																审核成功
															</span>
															<span v-else-if="shopbrand.state==2">
																审核失败
															</span>
															<span v-else>
																待审核
															</span>
														</td>
														<td>{{shopbrand.remark}}</td>
														<td>
															<button type="button" v-if="shopbrand.state==3" @click="edit(shopbrand.id)" class="btn btn-outline btn-primary">
																<i class="fa fa-paste"></i> 审核
															</button>
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
			data : {page:null,shopbrands:null},
			mounted : function(){
				spage(1,"shopbrand/findAuditBrand.json",this,"page");
			},
			methods : {
				edit : function(id){
					layer.open({
						type : 2,
						title : "编辑",
						shade : 0.2,
						area : [ "100%", "100%" ],
						content : "shopbrand/goAuditBrandEdit.html?id=" + id
					});
				}, 
				submit : function(){
					spage(1,"shopbrand/findAuditBrand.json",this,"page",$('#shopbrand').serialize());
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