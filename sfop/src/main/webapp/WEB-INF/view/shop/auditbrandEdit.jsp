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
						<form id="shopbrand" method="post" class="form-horizontal">
						<input type="hidden" id="id" name="id" value="${id}"/>
                        <div class="table-responsive">
							<table class="table table-striped">
                                <thead>
                                <tr>
                                    <th colspan="2" class="b-l b-r">
                                        <h4>店铺基本信息</h4>
                                    </th>
                                </tr>
                                </thead>
                                <tbody>
                                <tr>
                                    <td class="tdlm">店铺名称：{{shopinfo!=null?shopinfo.name:''}}</td>
                                    <td class="tdlm">店铺类型：{{shopinfo!=null?shopinfo.grade:''}}</td>
                                </tr>
                                <tr>
                                    <td style="font-size: 12px;">登录帐号：{{shopinfo!=null?shopinfo.account:''}}</td>
                                    <td style="font-size: 12px;">客服电话：{{shopinfo!=null?shopinfo.fax:''}}</td>
                                </tr>
                                </tbody>
                            </table>
                        </div>
						
						<div class="hr-line-dashed"></div>
						
						<div class="table-responsive panel panel-default">
	                        <table class="table table-condensed">
	                            <thead>
	                            <tr>
	                                <th colspan="5" class="b-l b-r">
	                                    <h4>店铺经营类目</h4>
	                                </th>
	                            </tr>
	                            <tr>
	                                <th>序号 </th>
	                                <th>产品类目</th>
	                                <th>类目保证金标准（元）</th>
	                                <th>平台使用费</th>
	                                <th>扣点</th>
	                            </tr>
	                            </thead>
	                            <tbody v-if="shopcategorys!=null">
	                            <tr v-for="(shopcategory,index) in shopcategorys">
	                                <td>{{shopcategory.c_category_id}}</td>
	                                <td>{{shopcategory.categoryName}}</td>
	                                <td>{{shopcategory.platformfee}}</td>
	                                <td>{{shopcategory.points}}</td>
	                                <td>{{shopcategory.consignmentpoints}}</td>
	                            </tr>
	                            </tbody>
	                        </table>
	                    </div>
						
						<div class="hr-line-dashed"></div>
						
						<div class="table-responsive">
							<table class="table table-striped">
	                            <thead>
	                            <tr>
	                                <th colspan="2" class="b-l b-r">
	                                    <h4>申请品牌信息</h4>
	                                </th>
	                            </tr>
	                            </thead>
	                            <tbody v-if="shopbrand!=null">
		                            <tr>
		                                <td style="font-size: 12px;">入驻编号： {{shopbrand.s_merchants_id}}</td>
                                        <td style="font-size: 12px;">品牌编号：{{shopbrand.b_brand_id}}<input type="hidden" name="b_brand_id" id="b_brand_id" :value="shopbrand.b_brand_id"/></td>
                                    </tr>
                                    <tr>
		                                <td style="font-size: 12px;">
		                                	品牌名称： 
		                                	<span v-if="shopbrand.brand!=null">{{shopbrand.brand.name}}</span>
		                                	<span v-else>
		                                		<input id="name" name="name" :value="shopbrand.name"/>
		                                	</span>
		                                </td>
                                        <td style="font-size: 12px;">提交时间：{{shopbrand.submitime}}</td>
                                    </tr>
                                    <tr>
		                                <td style="font-size: 12px;">
		                                	审核状态：
		                                	<span style="color:green;" v-if="shopbrand.state==1">
												审核成功
											</span>
											<span style="color:red;" v-else-if="shopbrand.state==2">
												审核失败
											</span>
											<span v-else>
												待审核
											</span>
		                                </td>
                                        <td style="font-size: 12px;">审核备注：{{shopbrand.remark}}</td>
                                    </tr>
									<tr>
		                                <td style="font-size: 12px;">品牌资质有效期：{{shopbrand.valid_period}}</td>
                                        <td style="font-size: 12px;">品牌资质电子版：<img width="200px" :src="shopbrand.qualification_img"/></td>
                                    </tr>
                                    <tr>
		                                <td style="font-size: 12px;">
		                                	品牌首字母：
											<select id="letter" style="width: 60px;height: 30px;" name="letter" v-if="shopbrand.brand==null">
												<option value="A" v-bind:selected="shopbrand.letter=='A'">A</option>
												<option value="B" v-bind:selected="shopbrand.letter=='B'">B</option>
												<option value="C" v-bind:selected="shopbrand.letter=='C'">C</option>
												<option value="D" v-bind:selected="shopbrand.letter=='D'">D</option>
												<option value="E" v-bind:selected="shopbrand.letter=='E'">E</option>
												<option value="F" v-bind:selected="shopbrand.letter=='F'">F</option>
												<option value="G" v-bind:selected="shopbrand.letter=='G'">G</option>
												<option value="H" v-bind:selected="shopbrand.letter=='H'">H</option>
												<option value="I" v-bind:selected="shopbrand.letter=='I'">I</option>
												<option value="J" v-bind:selected="shopbrand.letter=='J'">J</option>
												<option value="K" v-bind:selected="shopbrand.letter=='K'">K</option>
												<option value="L" v-bind:selected="shopbrand.letter=='L'">L</option>
												<option value="M" v-bind:selected="shopbrand.letter=='M'">M</option>
												<option value="N" v-bind:selected="shopbrand.letter=='N'">N</option>
												<option value="O" v-bind:selected="shopbrand.letter=='O'">O</option>
												<option value="P" v-bind:selected="shopbrand.letter=='P'">P</option>
												<option value="Q" v-bind:selected="shopbrand.letter=='Q'">Q</option>
												<option value="R" v-bind:selected="shopbrand.letter=='R'">R</option>
												<option value="S" v-bind:selected="shopbrand.letter=='S'">S</option>
												<option value="T" v-bind:selected="shopbrand.letter=='T'">T</option>
												<option value="U" v-bind:selected="shopbrand.letter=='U'">U</option>
												<option value="V" v-bind:selected="shopbrand.letter=='V'">V</option>
												<option value="W" v-bind:selected="shopbrand.letter=='W'">W</option>
												<option value="X" v-bind:selected="shopbrand.letter=='X'">X</option>
												<option value="Y" v-bind:selected="shopbrand.letter=='Y'">Y</option>
												<option value="Z" v-bind:selected="shopbrand.letter=='Z'">Z</option>
											</select>
											<span v-else>
												{{shopbrand.brand.letter}}
											</span>
		                                </td>
                                        <td style="font-size: 12px;">
                                        	品牌类型：
                                        	<span v-if="shopbrand.brand==null">
												<select id="type" style="width: 80px;height: 30px;" name="type">
													<option value="1" v-bind:selected="shopbrand.type=='1'">国际品牌</option>
													<option value="2" v-bind:selected="shopbrand.type=='2'">国内品牌</option>
												</select>
											</span>
											<span v-else>
												{{shopbrand.brand.type==1?'国际品牌':'国内品牌'}}
											</span>
                                        </td>
                                    </tr>
                                    <tr>
		                                <td style="font-size: 12px;">
		                                	商标注册人：
		                                	<span v-if="shopbrand.brand==null">
												<select id="trademarktype" style="width: 60px;height: 30px;" name="trademarktype">
													<option value="1" v-bind:selected="shopbrand.trademarktype=='1'">企业</option>
													<option value="2" v-bind:selected="shopbrand.trademarktype=='2'">个人</option>
												</select>
											</span>
											<span v-else>
												{{shopbrand.brand.trademarktype==1?'企业':'个人'}}
											</span>
		                                </td>
                                        <td style="font-size: 12px;">
                                        	经营类型：
                                        	<span v-if="shopbrand.brand==null">
												<select id="businesstype" style="width: 80px;height: 30px;" name="businesstype">
													<option value="1" v-bind:selected="shopbrand.businesstype=='1'">自有品牌</option>
													<option value="2" v-bind:selected="shopbrand.businesstype=='2'">代理品牌</option>
												</select>
											</span>
											<span v-else>
												{{shopbrand.brand.businesstype==1?'自有品牌':'代理品牌'}}
											</span>
                                        </td>
                                    </tr>
                                    <tr>
		                                <td style="font-size: 12px;" colspan="2">
		                                	品牌logo：<img id="logoimg" width="200" :src="shopbrand.brand==null?shopbrand.logo:shopbrand.brand.logo"/>
		                                	<input id="logo" type="hidden" name="logo" :value="shopbrand.brand==null?shopbrand.logo:shopbrand.brand.logo"/>
		                                	<div id="uploadImg" style="display: inline-block;">
		                                		<a class="btn btn-primary" id="file">更换图片</a>
		                                		<a class="btn btn-primary" id="upload">开始上传</a>
		                                	</div>
		                                </td>
                                    </tr>
	                            </tbody>
	                            <tbody>
	                            	<tr>
                                        <td style="font-size: 12px;" colspan="2">
                                        	品牌描述：<textarea id="descript" name="descript"></textarea>
                                        </td>
                                    </tr>
								</tbody>
	                        </table>
	                    </div>
	                    	
	                    	<div class="hr-line-dashed"></div>
	                    	
	                    	<div class="form-group" id="allbrand" style="display:none;">
                                <label class="col-sm-3 control-label">全部品牌：</label>

								<div class="col-sm-8">
                                	<ul id="temp">

									</ul>
                                </div>
                            </div>
	                    	
	                    	<div class="form-group">
                                <label class="col-sm-3 control-label">审核结果：</label>

								<div class="col-sm-8">
									<div class="radio radio-success radio-inline">
                                        <input type="radio" checked value="1" name="state">
                                        <label> 通过 </label>
                                    </div>
                                    <div class="radio radio-inline radio-danger">
                                        <input type="radio" value="2" name="state">
                                        <label> 不通过 </label>
                                    </div>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label">审核备注：</label>
                                <div class="col-sm-8">
                                    <textarea id="remark" name="remark" class="form-control"></textarea>
                                </div>
                            </div>
	                    	
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
	
	<script type="text/javascript" charset="utf-8" src="static/plugins/ueditor/ueditor.min.config.js"></script>
	<script type="text/javascript" charset="utf-8" src="static/plugins/ueditor/ueditor.all.min.js"> </script>
	<script type="text/javascript" charset="utf-8" src="static/plugins/ueditor/lang/zh-cn/zh-cn.js"></script>
	
	<script type="text/javascript" src="static/js/upload/plupload-2.1.8/js/plupload.full.min.js"></script>
	<script type="text/javascript" src="static/js/shopbrand/uploadImg.js"></script>
	
	<script type="text/javascript">
		$(function(){
			$.ajaxSetup({   
			    async : false
			});
			var ue;
			var id = "";
			var vue = new Vue({
				el : "#vue",
				data : {shopbrand:null,shopinfo:null,shopcategorys:null,option:0},
				mounted : function(){
					var _this = this;
					$.post("shopbrand/findShopBrandById.json?id="+$("#id").val(),function(data){
						for(var key in data){
							Vue.set(_this.$data,key,data[key]);
						}
						id = data.shopbrand.s_merchants_id;
						
						if(data.shopbrand.brand!=null){
							$("#descript").val(data.shopbrand.brand.descript);
						}else{
							$("#descript").val(data.shopbrand.descript);
						}
						ue= UE.getEditor('descript');
					})
					
					$.post("shopinfo/findShopinfoById.json?id=" + id, function (data) {
		                var grade="【官方旗舰店】";
		                if(data.shopinfo.grade==2){
		                    grade="【(品牌)授权专卖店】";
		                }
		                else if(data.shopinfo.grade==3){
		                    grade="【品牌专营店】";
		                }
		                data.shopinfo.grade=grade;
		                for (var key in data) {
		                    Vue.set(_this.$data, key, data[key]);
		                }
		            });
					
					$.post("shopcategory/findAllShopCategory.json?s_merchants_id=" + id, function (data) {
		                if(data.shopcategorys.length>0)
		                for (var key in data) {
		                    Vue.set(_this.$data, key, data[key]);
		                }
		            });
				},
				methods : {
					submit : function(){
						if($("input[name='state']:checked").val()==2||this.check()){
							layer.load(0, {
								shade : 0.3
							});

							$.post("shopbrand/auditShopBrand.json", $('#shopbrand').serialize(), function(data) {
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
					check : function(){
						var bool = true;
						var _this = this;
						var b_brand_id = $("#b_brand_id").val();
						if(_this.option==0){
							if(b_brand_id==0){
								/* $.post("shopbrand/check.json",function(data){
									if(data.RESPONSE_STATE=="200"){
										Vue.set(_this.$shopbrand, "b_brand_id", data.brand.id);
									}else{
										
									}
								}) */
								layer.confirm('系统不存在该品牌，您可以新增该品牌或选择系统已存在品牌。', {
									btn: ['新增','选择'] //按钮
								}, function(){
									layer.msg('请先检查品牌信息是否填写完整，之后再次保存', {icon: 0});
									_this.option = 1;
								}, function(){
									_this.option = 2;
									$.post("brand/findAllBrandFroOudit.json",{s_merchants_id:id},function(data) {
										var html="";
										data["brands"].forEach(function (item) {
											if(item.s_merchants_id==null){
												html += '<li style="width: 25%;float: left;height: 30px;list-style: none"  >'+
														'	<input type="radio" name="brand_id" value="'+item.id+'"/>'+item.name+
														'</li>';
											}
										});
										$("#temp").html(html);
										$("#allbrand").css("display","block");
									})
								});
								bool = false;
							}
						}else if(_this.option==1){
							if(_this.check_in()){
								$.post("shopbrand/saveBrand.json",$('#shopbrand').serialize(),function(data){
									if (data.RESPONSE_STATE == '200') {
										$("#b_brand_id").val(data.id);
									} else {
										layer.closeAll('loading');
										layer.alert(data.ERROR_INFO, {
											icon : 0
										});
										bool = false;
									}
								})
							}
						}else if(_this.option==2){
							if ($('#remark').val().trim() == '') {
								layer.tips('审核备注不能为空！！！', '#remark', {
									tips : [ 1, '#019F95' ],
									time : 1500
								});
								$('#remark').focus();
								bool = false;
							}
							
							if(b_brand_id==0){
								layer.alert("请选择系统已存在品牌！",{icon:0,title:"提醒"});
								bool = false;
							}
						}
						
						return bool;
					},
					check_in : function(){
						if ($('#name').val().trim() == '') {
							layer.tips('品牌名称不能为空！！！', '#name', {
								tips : [ 1, '#019F95' ],
								time : 1500
							});
							$('#name').focus();
							return false;
						}
						
						if ($('#logo').val().trim() == '') {
							layer.tips('品牌logo不能为空！！！', '#logo', {
								tips : [ 1, '#019F95' ],
								time : 1500
							});
							$('#logo').focus();
							return false;
						}
						
						var html = ue.getContent();
						if (html.trim() == '') {
							layer.tips('品牌描述不能为空！！！', '#descript', {
								tips : [ 1, '#019F95' ],
								time : 1500
							});
							$('#descript').focus();
							return false;
						}
						
						return true;
					}
				}
			})
			
			$("#temp").on("click","li input",function(){
				vue.shopbrand.b_brand_id = $(this).val();
			})
			
		})
	</script>


</body>
 

</html>