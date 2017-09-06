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
					<form id="shopinfo" method="post">
						<div class="ibox-content">
							<h2>管理</h2>
							<div class="input-group">
								<div class="col-md-4">
									<input placeholder="公司名称" name="msName" class="input form-control">
								</div>

								<div class="col-md-4">
									<select class="input form-control" name="type">
										<option value="0">公司类型</option>
										<option value="1">生产厂商</option>
										<option value="2" >品牌商</option>
										<option value="3" >中国总代</option>
										<option value="4" >地区总代</option>
										<option value="5" >代运营商</option>
										<option value="6" >经销商</option>
									</select>
								</div>
								<div class="col-md-4">
									<select class="input form-control" name="grade">
										<option value="0">店铺类型</option>
										<option value="1">【官方旗舰店】</option>
										<option value="2">【(品牌)授权专卖店】</option>
										<option value="3">【品牌专营店】</option>
									</select>
								</div>
								<div class="col-md-4">
									<input placeholder="店铺名称" name="name" class="input form-control">
								</div>
								<div class="col-md-4">
									<select class="input form-control" name="cooperation">
										<option value="0">合作模式</option>
										<option value="1">代销</option>
										<option value="2">入驻</option>
									</select>
								</div>
								<div class="col-md-4">
									<select class="input form-control" name="sstate">
										<option value="0">店铺状态</option>
										<option value="1">开通</option>
										<option value="2">冻结</option>
										<option value="3">暂停</option>
										<option value="4">未开通</option>
									</select>
								</div>
								<div class="col-md-4">
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
													<th>公司名称</th>
													<th>店铺名称</th>
													<th>店铺类型</th>
													<th>公司类型</th>
													<th>合作模式</th>
													<th>注册日期</th>
													<th>到期时间</th>
													<th>负责人姓名</th>
													<th>负责人手机号</th>
													<th>负责人邮箱</th>
													<th>最后修改时间</th>
													<th>最后修改人</th>
													<th>状态</th>
													<th>支付状态</th>
													<th>操作</th>
												</tr>
												</thead>
												<tbody>
												<tr v-for="(shopinfo,index) in shopinfos">
													<td>{{shopinfo.s_merchants_id}}</td>
													<td>{{shopinfo.msName}}</td>
													<td>{{shopinfo.name}}</td>

													<td>
														<span v-if="shopinfo.grade==1">【官方旗舰店】</span>
														<span v-else-if="shopinfo.grade==2" >【(品牌)授权专卖店】</span>
														<span v-else-if="shopinfo.grade==3" >【品牌专营店】</span>
													</td>
													<td>

														<span v-if="shopinfo.type==1">生产厂商</span>
														<span v-else-if="shopinfo.type==2" >品牌商</span>
														<span v-else-if="shopinfo.type==3" >中国总代</span>
														<span v-else-if="shopinfo.type==4" >地区总代</span>
														<span v-else-if="shopinfo.type==5" >代运营商</span>
														<span v-else-if="shopinfo.type==6" >经销商</span>
													</td>
													<td>
														<span v-if="shopinfo.cooperation==1">代销</span>
														<span v-else-if="shopinfo.cooperation==2" >入驻</span>
													</td>
													<td>{{shopinfo.rtime}}</td>
													<td>{{shopinfo.endtime}}</td>
													<td>{{shopinfo.head_name}}</td>
													<td>{{shopinfo.head_phone}}</td>
													<td>{{shopinfo.head_email}}</td>
													<td>{{shopinfo.lasttime}}</td>
													<td>{{shopinfo.updatename}}</td>
													<td>
														<span v-if="shopinfo.sstate==1">开通</span>
														<span v-else-if="shopinfo.sstate==2" >冻结</span>
														<span v-else-if="shopinfo.sstate==3" >暂停</span>
														<span v-else-if="shopinfo.sstate==4" >未开通</span>
													</td>
													<td>
														<span v-if="shopinfo.pay_status==null||shopinfo.pay_status=='0'" style="color:red;">等待支付</span>
														<span v-if="shopinfo.pay_status=='1'">已支付</span>
													</td>
													<td>
														<button   type="button" @click="edit(shopinfo.s_merchants_id)" class="btn btn-outline btn-success">
															<i class="fa fa-check"></i> 编辑
														</button>
														<button   type="button" @click="brand(shopinfo.s_merchants_id)" class="btn btn-outline btn-info">
															<i class="fa fa-paste"></i> 品牌
														</button>
														<button    type="button" @click="reset(shopinfo.s_merchants_id)" class="btn btn-outline btn-danger">
															<i class="fa fa-warning"></i> 重置密码
														</button>
														<button type="button" @click="viewshop(shopinfo.s_merchants_id)" class="btn btn-outline btn-default">
															<i class="fa fa-map-marker"></i> 详情
														</button>
														<button type="button" @click="viewms(shopinfo.s_merchants_id)" class="btn btn-outline btn-warning">
															<i class="fa fa-map-marker"></i> 公司信息
														</button>

													</td>
												</tr>
												</tbody>
											</table>
										</div>
									</div>

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
			data : {page:null,shopinfos:null},
			mounted : function(){
				this.submit();
			},
			methods : {
				reset:function(id){
					url="shopinfo/updateAccount.json";
					$.post(url,{id:id},function(data){
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
				brand:function (id) {
					layer.open({
						type : 2,
						title : "新增",
						shade : 0.2,
						area : [ "70%", "80%" ],
						content : "shopbrand/goShopBrandList.json?s_merchants_id="+id
					});
				},
				add : function(){
					layer.open({
						type : 2,
						title : "新增",
						shade : 0.2,
						area : [ "70%", "80%" ],
						content : "shopinfo/goShopinfoEdit.html"
					});
				},
				edit : function(id){
					layer.open({
						type : 2,
						title : "编辑",
						shade : 0.2,
						area : [ "100%", "100%" ],
						content : "shopinfo/goShopinfoEdit.html?id=" + id
					});
				},
				submit : function(){
					spage(1,"shopinfo/findAllShopinfo.json",this,"",$('#shopinfo').serialize());
				},
				viewshop: function(id){
					layer.open({
						type : 2,
						title : "查看",
						shade : 0.2,
						area : [ "100%", "100%" ],
						content : "shopinfo/goShopinfoPassView.html?id=" + id
					});
				}
				,
				viewms: function(id){
					layer.open({
						type : 2,
						title : "查看",
						shade : 0.2,
						area : [ "100%", "100%" ],
						content : "merchantssettled/goMerchantsSettledView.html?id=" + id
					});
				},
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