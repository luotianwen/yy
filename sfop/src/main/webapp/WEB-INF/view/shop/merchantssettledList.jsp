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
					<form id="merchantssettled" method="post">
						<div class="ibox-content">
							<h2>管理</h2>
							<div class="input-group">
								<div class="col-md-4">
									<input placeholder="公司名称" name="name" class="input form-control">
								</div>
								<div class="col-md-3">
									<select class="input form-control" name="type">
										<option value="">公司类型</option>
										<option value="1">生产厂商</option>
										<option value="2" >品牌商</option>
										<option value="3" >中国总代</option>
										<option value="4" >地区总代</option>
										<option value="5" >代运营商</option>
										<option value="6" >经销商</option>
									</select>
								</div>
								<div class="col-md-3">
									<select class="input form-control" name="cooperation">
										<option value="">合作模式</option>
										<option value="1">代销</option>
										<option value="2">入驻</option>
									</select>
								</div>
								<div class="col-md-2">
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
														<th>id</th>
														<th>申请人</th>
														<th>公司名称</th>
														<th>公司类型</th>
														<th>合作模式</th>
														<th>负责人姓名</th>
														<th>负责人手机号</th>
														<th>负责人邮箱</th>
														<th>初审状态</th>
														<th>操作</th>
													</tr>
												</thead>
												<tbody>
													<tr v-for="(merchantssettled,index) in merchantssettleds">
														<td>{{merchantssettled.id}}</td>
														<td>{{merchantssettled.userName}}</td>
														<td>{{merchantssettled.name}}</td>
														<td>

															<span v-if="merchantssettled.type==1">生产厂商</span>
															<span v-else-if="merchantssettled.type==2" >品牌商</span>
															<span v-else-if="merchantssettled.type==3" >中国总代</span>
															<span v-else-if="merchantssettled.type==4" >地区总代</span>
															<span v-else-if="merchantssettled.type==5" >代运营商</span>
															<span v-else-if="merchantssettled.type==6" >经销商</span>
															 </td>
														<td>
															<span v-if="merchantssettled.cooperation==1">代销</span>
															<span v-else-if="merchantssettled.cooperation==2" >入驻</span>
														</td>
														<td>{{merchantssettled.head_name}}</td>
														<td>{{merchantssettled.head_phone}}</td>
														<td>{{merchantssettled.head_email}}</td>
														<td>
															<span v-if="merchantssettled.state==1">通过</span>
															<span v-else-if="merchantssettled.state==2" >驳回</span>
															<span v-else-if="merchantssettled.state==3" >未审核</span>
                                                            <span v-else-if="merchantssettled.state==4" >重新提交</span>
														</td>
														<td>
															<button v-if="merchantssettled.state==3" type="button" @click="review(merchantssettled.id)" class="btn btn-outline btn-success">
															<i class="fa fa-paste"></i> 审核
														</button>
															<button v-if="merchantssettled.state==2||merchantssettled.state==4" type="button" @click="review(merchantssettled.id)" class="btn btn-outline btn-info">
																<i class="fa fa-paste"></i> 重审
															</button>
															<button type="button" @click="log(merchantssettled.id)" class="btn btn-outline btn-white">
																<i class="fa fa-map-marker"></i> 日志
															</button>
															<button type="button" @click="view(merchantssettled.id)" class="btn btn-outline btn-default">
																<i class="fa fa-map-marker"></i> 详情
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
	<script src="static/js/plugins/layer/laypage/laypage.js?v=1"></script>
	<script src="static/js/plugins/slimscroll/jquery.slimscroll.min.js"></script>

	<!-- iCheck -->
	<script src="static/js/plugins/iCheck/icheck.min.js"></script>
	
	<script type="text/javascript">
		new Vue({
			el : "#vue",
			data : {page:null,merchantssettleds:null},
			mounted : function(){
				spage(1,"merchantssettled/findAllMerchantsSettled.json",this);
			},
			methods : {
				log : function(id){
					layer.open({
						type : 2,
						title : "日志",
						shade : 0.2,
						area : [ "70%", "80%" ],
						content : "shopinfolog/goShopinfoLogList.html?type=1&s_merchants_id="+id
					});
				},
				review: function(id){
					layer.open({
						type : 2,
						title : "审核",
						shade : 0.2,
						area : [ "100%", "100%" ],
						content : "merchantssettled/goMerchantsSettledEdit.html?id=" + id
					});
				},
                 view: function(id){
                    layer.open({
                        type : 2,
                        title : "查看",
                        shade : 0.2,
                        area : [ "100%", "100%" ],
                        content : "merchantssettled/goMerchantsSettledView.html?id=" + id
                    });
                },
				submit : function(){
					spage(1,"merchantssettled/findAllMerchantsSettled.json",this,"page",$('#merchantssettled').serialize());
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