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
	<link href="static/css/layerdate/layerdate.css" rel="stylesheet">
	<style type="text/css">
	.tr-center th {
		    text-align: center;
		}
	</style>
</head>

<body class="gray-bg">
	<div class="wrapper wrapper-content  animated fadeInRight" id="vue">
		<div class="row">
			<div id="user-box" class="col-sm-12">
				<div class="ibox">
					<form id="coupons" method="post">
						<div class="ibox-content">
							<h2>管理</h2>
							<div class="input-group">
								<div class="col-md-3 m-b-xs">
									<input placeholder="优惠券编号" name="id" class="input form-control">
								</div>
								<div class="col-md-3 m-b-xs">
									<input placeholder="优惠券名称" name="name" class="input form-control">
								</div>
								
								<div class="col-md-3 m-b-xs">
									<select class="input form-control" name="type">
										<option value="0">优惠券类型</option>
										<option value="1">优惠券</option>
										<option value="2">现金券</option>
										<option value="3">弹出券</option>
									</select>	
								</div>
								
								<div class="col-md-3 m-b-xs">
									<select class="input form-control" name="scope">
										<option value="0">优惠券适用范围</option>
										<option value="1">全部商品</option>
										<option value="2">指定商品（参加）</option>
										<option value="3">指定商品（不参加）</option>
										<option value="4">指定店铺（参加）</option>
										<option value="5">指定店铺（不参加）</option>
										<option value="6">指定分类（参加）</option>
										<option value="7">指定分类（不参加）</option>
									</select>	
								</div>
								
								<div class="col-md-3 m-b-xs">
									<select class="input form-control" name="state">
										<option value="0">优惠券状态</option>
										<option value="1">正常</option>
										<option value="2">过期</option>
										<option value="3">待发放</option>
										<option value="4">暂停发放</option>
										<option value="5">领取完毕</option>
									</select>	
								</div>
								
								<div class="col-md-3 m-b-xs">
									<button type="button" @click="submit"  class="btn btn btn-primary">
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
													<tr class="tr-center">
														<th>序号</th>
														<th>券编号</th>
														<th>优惠券信息</th>
														<th>类型</th>
														<th>适用范围</th>
														<!-- <th>使用分类</th> -->
														<!-- <th>店铺</th> -->
														<th>发/剩/领/使</th>
														<!-- <th>优惠券面值</th> -->
														<th>优惠券有效期</th>
														<th>说明</th>
														<th>领取地址</th>
														<th>是否套餐</th>
														<th>状态<!-- (1：正常；2：过期；3：待发放； 4：暂停发放；5：领取完毕；6：过期) --></th>
														<th>创建</th>
														<th>修改</th>
														<th>备注</th>
														<th>操作</th>
													</tr>
												</thead>
												<tbody>
													<tr v-for="(coupons,index) in couponss" class="text-center">
														<td>{{index+1}}</td>
														<td>{{coupons.id}}</td>
														<td>
															<span :title="coupons.name">{{coupons.name.substring(0, 5)}}<span v-if="coupons.name.length>5">...</span></span>
															<br>
															满{{coupons.full}}元减{{coupons.minus}}
														</td>
														<td>
															<span v-if="coupons.type==1">优惠券</span>
															<span v-else-if="coupons.type==2">现金券</span>
															<span v-else>弹出券</span>
														</td>
														<td>
															<span v-if="coupons.scope==1">全部商品</span>
															<span v-else-if="coupons.scope==2">指定商品（参加）</span>
															<span v-else-if="coupons.scope==3">指定商品（不参加）</span>
															<span v-else-if="coupons.scope==4">指定店铺（参加）</span>
															<span v-else-if="coupons.scope==5">指定店铺（不参加）</span>
															<span v-else-if="coupons.scope==6">指定分类（参加）</span>
															<span v-else>指定分类（不参加）</span>
														</td>
														<!-- <td>{{coupons.category}}</td> -->
														<!-- <td>{{coupons.sellerId}}</td> -->
														<td>{{coupons.number}}/{{coupons.surplusNumber}}/{{coupons.receiveCount}}/{{coupons.useCount}}</td>
														<td >
																{{coupons.startDate}}
																<br><label>至</label><br>
																{{coupons.endDate}}
														</td>
														<td>
															<span :title="coupons.note">{{coupons.note.substring(0, 5)}}<span v-if="coupons.note.length>5">...</span></span>
														</td>
														<td>
															<a target="_blank" :href="coupons.url" :title="coupons.url">查看</a>
														</td>
														<td>{{coupons.isPackage}}</td>
														<td>
															<span v-if="coupons.state==1">正常</span>
															<span v-else-if="coupons.state==2">过期</span>
															<span v-else-if="coupons.state==3">待发放</span>
															<span v-else-if="coupons.state==4">暂停发放</span>
															<span v-else>过期</span>
														</td>
														<td>
															{{coupons.user_id}} 
																<br>
														 	{{coupons.createTime}}
														 </td>
														<td>
														 		{{coupons.updateName}}
																<br>
																{{coupons.lastTime}}
														</td>
														<td>{{coupons.remark}}</td>
														<td>
															<button v-if="coupons.state==3" type="button" @click="edit(coupons.id)" class="btn btn-outline btn-primary">
																<i class="fa fa-paste"></i> 编辑
															</button>
															<button v-if="coupons.state!=2&&coupons.state!=5" type="button" @click="secret(coupons.id)" class="btn btn-outline btn-primary">
																<i class="fa fa-paste"></i> 生成密钥
															</button>
															<button v-if="coupons.state==1" type="button" @click="grant(index)" class="btn btn-outline btn-danger">
																<i class="fa fa-paste"></i> 暂停发放
															</button>
															<button v-else-if="coupons.state==3||coupons.state==4" type="button" @click="grant(index)" class="btn btn-outline btn-primary">
																<i class="fa fa-paste"></i> 发放
															</button>
														</td>
													</tr>
												</tbody>
											</table>
										</div>
									</div>

									<div class="ibox-content">
										<p>
											<button type="button" id="add" @click="add" class="btn btn-sm btn-primary">
												<i class="fa fa-plus"></i> 添加
											</button>
										</p>
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
	<script src="static/js/plugins/layer/laydate/laydate.js"></script>
	<script src="static/js/plugins/slimscroll/jquery.slimscroll.min.js"></script>

	<!-- iCheck -->
	<script src="static/js/plugins/iCheck/icheck.min.js"></script>
	
	<script type="text/javascript">
		var vue = new Vue({
			el : "#vue",
			data : {couponss:null,page:null},
			created : function(){
				spage(1,"coupons/findAllCoupons.json",this,"page");
			},
			methods : {
				add : function(){
					layer.open({
						type : 2,
						title : "新建优惠券",
						shade : 0.2,
						area : [ "100%", "100%" ],
						content : "coupons/goCouponsEdit.html"
					});
				},
				edit : function(id){
					layer.open({
						type : 2,
						title : "编辑",
						shade : 0.2,
						area : [ "100%", "100%" ],
						content : "coupons/goCouponsEdit.html?id=" + id
					});
				},
				submit : function(){
					spage(1,"coupons/findAllCoupons.json",this,"page",$('#coupons').serialize());
				},
				grant : function(index){
					var _this = this;
					var coupons = _this.couponss[index];
					var id = coupons.id;
					var message = "";
					var state = "";
					if(coupons.state==3||coupons.state==4){
						message = "是否发放该优惠券?";
						state = "1";
					}else if(coupons.state==1){
						message = "是否暂停发放该优惠券?";
						state = "4";
					}
					
					layer.confirm(message,{icon:3},function(index){
						layer.close(index);
						$.post("coupons/grantCoupons.json",{id:id,state:state},function(data){
							if(data.RESPONSE_STATE=="200"){
								layer.msg("修改成功。",{icon:1,time:1*1000,shade:0.3},function(){
									_this.submit();
								})
							}else{
								layer.alert(data.ERROR_INFO, {
									icon : 0
								});
								return;
							}
						})
						
					});
				},
				secret : function(id){
					layer.open({
						type : 2,
						title : "生成密钥",
						shade : 0.2,
						area : [ "50%", "60%" ],
						content : "coupons/goCouponsSecret.html?id=" + id
					});
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