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
	
	<title>商城后台 - 世峰e卡</title>
	
	<link href="static/css/bootstrap.min.css" rel="stylesheet">
	<link href="static/css/font-awesome.min.css" rel="stylesheet">
	<!-- iCheck -->
	<link href="static/css/plugins/iCheck/custom.css" rel="stylesheet">
	<link href="static/css/animate.min.css" rel="stylesheet">
	<link href="static/css/style.min.css" rel="stylesheet">
	<link href="static/css/layerdate/layerdate.css" rel="stylesheet">
	
	<style type="text/css">
		.orderby{
			cursor: pointer;
		}
		.orderby-desc i{
			background: url(<%=basePath%>/static/images/arrow.png) no-repeat 0 0;
		    display: inline-block;
		    height: 13px;
		    width: 19px;
		}
		
		
		.desc{
			background: url(<%=basePath%>/static/images/arrow.png) no-repeat 0 0;
		    display: inline-block;
		    height: 13px;
		    width: 19px;
		}
		
		.asc{
			background: url(<%=basePath%>/static/images/arrow.png) no-repeat 0 -13px;
		    display: inline-block;
		    height: 13px;
		    width: 19px;
		}
	</style>
	
</head>

<body class="gray-bg">
	<div class="wrapper wrapper-content  animated fadeInRight" id="vue">
		<div class="row">
			<div id="user-box" class="col-sm-12">
				<div class="ibox">
					<form id="card" method="post">
						<div class="ibox-content">
							<h2>管理世峰e卡</h2>
							<div class="input-group">
								<div class="col-md-3" style="padding-right:0px;">
									<input type="text" style="width:94%" placeholder="开始日期" id="sdate" name="sdate" readonly class="input form-control">
									<span style="display: inline-block;margin-top: 5px;">—</span>
								</div>
								
								<div class="col-md-3" style="padding-right:0px;padding-left:0px">
									<input type="text" style="width:94%" placeholder="开始日期" id="edate" name="edate" readonly class="input form-control">
								</div>
								
								<div class="col-md-3" style="width:80%;"></div>
								
								<div class="col-md-3" style="padding-right:0px;margin-top: 15px;">
									<input type="text" style="width:94%" placeholder="结束日期" id="sdateend" name="sdateend" readonly class="input form-control">
									<span style="display: inline-block;margin-top: 5px;">—</span>
								</div>
	
								<div class="col-md-3" style="padding-right:0px;padding-left:0px;margin-top: 15px;">
									<input type="text" style="width:94%" placeholder="结束日期" id="edateend" name="edateend" readonly class="input form-control">
								</div>
								
								<div class="col-md-3" style="width:80%;"></div>
								
								<div class="col-md-3" style="margin-top: 15px;">
									<input type="number" placeholder="卡号" id="number" name="cardnumber" class="input form-control">
								</div>
								
								<div class="col-md-3" style="margin-top: 15px;">
									<input type="text" placeholder="创建人" id="userid" name="userid" class="input form-control">
								</div>
								
								<div class="col-md-3" style="margin-top: 15px;">
									<input type="number" placeholder="生成批次" id="batch" name="batch" class="input form-control">
								</div>
								
								<div class="col-md-3" style="margin-top: 15px;">
									<select class="form-control m-b" name="status" id="status">
										<option value="0">请选择e卡状态</option>
										<option value="1">未绑定</option>
	                               		<option value="2">未使用</option>
	                               		<option value="3">部分使用</option>
	                               		<option value="4">已用完</option>
	                               		<option value="5">已作废</option>
	                               		<option value="6">已过期</option>
									</select>
	
								</div>
								
								<div class="col-md-3" style="margin-top: 15px;">
									<input type="number" placeholder="发送手机号" id="phone" name="phone" class="input form-control">
								</div>
								
								<div class="col-md-3" style="margin-top: 15px;">
									<select class="form-control m-b" name="sendstatus" id="sendstatus">
										<option value="0">请选择短信发送状态</option>
										<option value="1">未发送</option>
	                               		<option value="2">已发送</option>
	                               		<option value="3">发送失败</option>
									</select>
								</div>
								
								<div class="col-md-3" style="margin-top: 15px;">
									<button type="button" @click="submit" class="btn btn-success">
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
														<th>生成批次</th>
														<th class="orderby">
															卡号<i class=""></i>
															<input type="hidden" name="orderby.number" value=""/>
														</th>
														<th>密码</th>
														<th class="orderby">
															开始时间<i class=""></i>
															<input type="hidden" name="orderby.sdate" value=""/>
														</th>
														<th class="orderby">
															结束时间<i class=""></i>
															<input type="hidden" name="orderby.edate" value=""/>
														</th>
														<th>状态</th>
														<th>金额</th>
														<th>手机号</th>
														<th>发送状态</th>
														<th>短信备注</th>
														<th>创建人</th>
														<th class="orderby">
															创建时间<i class=""></i>
															<input type="hidden" name="orderby.cdate" value=""/>
														</th>
														<th>修改人</th>
														<th>修改时间</th>
														<th>备注</th>
														<th>操作</th>
													</tr>
												</thead>
												<tbody>
													<tr v-for="(card,index) in cards">
														<td>{{card.batch}}</td>
														<td>{{card.number}}</td>
														<td>{{card.password}}</td>
														<td>{{card.sdate}}</td>
														<td>{{card.edate}}</td>
														<td>
															{{card.status==1?"未绑定":card.status==2?"未使用":card.status==3?"部分使用":card.status==4?"已用完":card.status==5?"已作废":card.status==6?"已过期":''}}
														</td>
														<td>{{card.money}}</td>
														<td>{{card.phone}}</td>
														<td>
															{{card.sendstatus==1||card.sendstatus==0?"未发送":card.sendstatus==2?"已发送":card.sendstatus==3?"发送失败":''}}
														</td>
														<td>{{card.sendremark}}</td>
														<td>{{card.userid}}</td>
														<td>{{card.cdate}}</td>
														<td>{{card.updateuser}}</td>
														<td>{{card.udate}}</td>
														<td>{{card.remark}}</td>
														<td>
															<button v-if="card.status&lt;5" type="button" @click="edit(index)" class="btn btn-outline btn-success">
																<i class="fa fa-paste"></i> 作废
															</button>
															
															<button v-if="card.status==1&&card.sendstatus==1" type="button" @click="send(card.number)" class="btn btn-outline btn-success">
																<i class="fa fa-paste"></i> 发送短信
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
			data : {cards:null,page:null},
			mounted : function(){
				spage(1,"card/findAllCard.json",this,"page");
				this.dateinit();
			},
			methods : {
				dateinit : function(){
					var start = {
			   			elem : '#sdate',
			   			format : 'YYYY-MM-DD',
			   			istoday : false,
						choose: function(datas){
							end.min = datas; //开始日选好后，重置结束日的最小日期
						}
			   		};
			   		var end = {
			   			elem : '#edate',
			   			format : 'YYYY-MM-DD',
			   			istoday : false,
						choose: function(datas){
							start.max = datas; //开始日选好后，重置结束日的最小日期
						}
			   		};
			   		laydate(start);
			   		laydate(end);
				   		
			   		var startend = {
				   		elem : '#sdateend',
				   		format : 'YYYY-MM-DD',
				   		istoday : false,
						choose: function(datas){
							endend.min = datas; //开始日选好后，重置结束日的最小日期
						}
				   	};
				   	var endend = {
				   		elem : '#edateend',
				   		format : 'YYYY-MM-DD',
				   		istoday : false,
						choose: function(datas){
							startend.max = datas; //开始日选好后，重置结束日的最小日期
						}
				   	};
				   	laydate(startend);
				   	laydate(endend);
				},
				add : function(){
					layer.open({
						type : 2,
						title : "新增",
						shade : 0.2,
						area : [ "70%", "80%" ],
						content : "card/goCardEdit.html"
					});
				},
				edit : function(index){
					var _this = this;
					var number = _this.cards[index].number;
					
					var msg = "";
					$.post("usercard/findUserCardByCid.json",{number:number},function(data){
						if(data.RESPONSE_STATE == '200'){
							if(data.bool == true){
								msg = "<span style='color:red;'>该e卡已被用户绑定</span>，是否要作废该e卡?";
							}else{
								msg = "是否要作废该e卡?";
							}
							layer.confirm(msg,{icon:3},function(layindex){
								layer.close(layindex);
								
								$.post("card/updateCard.json",{number:number},function(data){
									if(data.RESPONSE_STATE == '200'){
					                    layer.msg('作废成功',{icon:1,time:1*1000},function(){
											 _this.cards[index].status = 5;
					                    });
					                }else{
					                    layer.closeAll('loading');
					                    layer.alert(data.ERROR_INFO,{icon:0});
					                }
								})
							});
						}else{
							layer.closeAll('loading');
		                    layer.alert(data.ERROR_INFO,{icon:0});
						}
					})
				},
				submit : function(){
					spage(1,"card/findAllCard.json",this,"page",$('#card').serialize());
				},
				send : function(id){
					layer.open({
						type: 2,
						title: "发送短信",
						shade: 0.2,
						area: ["60%", "70%"],
						content: "card/sendSMS.html?id="+id
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
		
			//排序
			$(".orderby").on("click",function(){
				var $this = $(this);
				var this_class = $this.find("i").attr("class");
				
				$(".orderby").find("i").attr("class","");
				$(".orderby").find("input").val("");
				
				if(this_class==null||this_class==''){
					$(this).removeClass("orderby-desc");
					$this.find("i").attr("class","desc");
					$this.find("input").val("desc");
				}else if(this_class=="desc"){
					$this.find("i").attr("class","asc");
					$this.find("input").val("asc");
				}else{
					$this.find("i").attr("class","");
					$this.find("input").val("");
				}
				vue.submit();
			})
			
			$(".orderby").hover(function(){
				if($(this).find("i").attr("class")==null||$(this).find("i").attr("class")==''){
					$(this).addClass("orderby-desc");
				}
			},function(){
				if($(this).find("i").attr("class")==null||$(this).find("i").attr("class")==''){
					$(this).removeClass("orderby-desc");
				}
	 		});
		})
	</script>


</body>


</html>