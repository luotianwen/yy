<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link href="static/css/product/productTab.css" rel="stylesheet">

<div class="box col-md-12">
	<div class="box-inner">
		<input type="hidden" id="state" value="${state }"/>
		<div class="box-header well">
			<h2>
				<i class="glyphicon glyphicon-th"></i> 添加新商品
			</h2>
		</div>
		<div class="box-content">
			<div class="form-info">
				<form class="form-horizontal" id="info">
					<input type="hidden" name="id" value="${product.id }"/>
					<input type="hidden" id="cid" name="cid" value="${product.cid }"/>
					<input type="hidden" id="pcid" name="pcid" value="${product.pcid }"/>
					<h4>基本内容编辑</h4>
					<div class="form-group">
						<label class="col-sm-2 control-label">
							<span class="fred">*</span>商品名称：
						</label>
						<div class="col-sm-10">
							<input id="name" name="name" required maxlength="120" value="${product.name }" class="form-control inline" style="width: 50%;" type="text">
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-2 control-label">商品副标题：</label>
						<div class="col-sm-10">
							<input id="goods_subtitle" name="goods_subtitle" maxlength="200" value="${product.goods_subtitle }" class="form-control inline" style="width: 50%;" type="text">
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-2 control-label">关键词内容：</label>
						<div class="col-sm-10">
							<input id="keywords" name="keywords" maxlength="200" value="${product.keywords }" class="form-control inline" style="width: 50%;" type="text">
						</div>
					</div>
					
					<!-- <div class="form-group">
						<label class="col-sm-2 control-label">加链接的文字：</label>
						<div class="col-sm-10">
							<input id="ChineseName" class="form-control inline" placeholder="" style="width: 50%;" type="text">
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-2 control-label">链接地址：</label>
						<div class="col-sm-10">
							<input id="ChineseName" class="form-control inline" placeholder="" style="width: 50%;" type="text">
						</div>
					</div> -->
					<div class="form-group">
						<label class="col-sm-2 control-label">
							<span class="fred">*</span>品牌：
						</label>
						<div class="col-sm-10">
							<select class="form-control inline" id="brandid" required name="brandid" style="width: 15%;">
								<c:forEach items="${shopBrand }" var="item">
									<option <c:if test="${product.brandid==item.id }">selected</c:if> value="${item.id }">${item.name }</option>
								</c:forEach>
							</select>
							<span class="help-block inline">
								*如果无法选择您想要的品牌，请 “ <a href="#">申请新品牌</a> ”
							</span>
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-2 control-label">
							<span class="fred">*七天无理由退货</span>：
						</label>
						<div class="col-sm-10">
							<select class="form-control inline" name="is_seven_return" style="width: 15%;">
								<option <c:if test="${product.is_seven_return==1 }">selected</c:if> value="1">支持</option>
								<option <c:if test="${product.is_seven_return==2 }">selected</c:if> value="2">不支持</option>
							</select>
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-2 control-label">
							<span class="fred">*</span>售后服务：
						</label>
						<div class="col-sm-10">
							<select class="form-control inline" required id="after_service" name="after_service" style="width: 15%;">
								<c:forEach items="${afterSalesPolicy }" var="item">
									<option value="${item.id }">${item.title }</option>
								</c:forEach>
							</select>
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-2 control-label">
							<span class="fred">*</span>运费模板：
						</label>
						<div class="col-sm-10">
							<select class="form-control inline" required id="freight_master" name="freight_master" style="width: 15%;">
								<c:forEach items="${freight }" var="item">
									<option value="${item.id }">${item.ffreightName }</option>
								</c:forEach>
							</select>
						</div>
					</div>
					
					<h4>
						商品属性<span class="fred tips">*如果属性和属性值选项不满足业务需要，请联系世峰户外对接运营人员进行修改或添加</span>
					</h4>
					
					<c:forEach items="${propertycategory }" var="item" varStatus="var">
						<div class="form-group">
							<c:if test="${item.ismultiple==1 }">
								<label class="col-sm-2 control-label">${item.name }：<input type="hidden" name="productPropertys[${var.index }].propertyId" value="${item.pid }"/></label>
								<div class="col-sm-10">
									<c:forEach items="${item.propertyvalue }" var="value">
										<c:set var="check" value=""/>
										<c:forEach items="${product.productPropertys }" var="proitem">
											<c:if test="${proitem.propertyId==item.pid }">
												<c:if test="${proitem.propertyValueId==value.id }">
													<c:set var="check" value="checked"/>
													<input type="hidden" name="productPropertys[${var.index }].id" value="${proitem.id }"/>
												</c:if>
											</c:if>
										</c:forEach>
										<input type="checkbox" ${check } name="productPropertys[${var.index }].propertyValue" value="${value.id }"> ${value.content }
									</c:forEach>
								</div>
							</c:if>
							<c:if test="${item.ismultiple==0 }">
								<label class="col-sm-2 control-label">${item.name }：<input type="hidden" name="productPropertys[${var.index }].propertyId" value="${item.pid }"/></label>
								<div class="col-sm-10">
									<c:if test="${item.propertyvalue!=null }">
										<select class="form-control inline" style="width: 25%;" name="productPropertys[${var.index }].propertyValue">
											<option value="">—请选择—</option>
											<c:forEach items="${item.propertyvalue }" var="value">
												<c:set var="selected" value=""/>
												<c:forEach items="${product.productPropertys }" var="proitem">
													<c:if test="${proitem.propertyId==item.pid }">
														<c:if test="${proitem.propertyValueId==value.id }">
															<c:set var="selected" value="selected"/>
														</c:if>
													</c:if>
												</c:forEach>
												<option ${selected } value="${value.id }">${value.content }</option>
											</c:forEach>
										</select>
									</c:if>
								</div>
							</c:if>
						</div>
					</c:forEach>
					
					<h4>
						商品信息<span class="fred tips">*价格的修改和发布可能会有延迟，如果出现请谅解</span>
					</h4>
					<div class="form-group">
						<label class="col-sm-2 control-label">
							【包装】长：
						</label>
						<div class="col-sm-2">
							<input class="form-control inline" placeholder="" min="0" max="10000" value="${product.length }" id="length" name="length" type="number" style="width: 150px">
							<span class="unit-inline">mm</span>
						</div>
						<label class="col-sm-2 control-label">
							【包装】宽：
						</label>
						<div class="col-sm-2">
							<input class="form-control inline" placeholder="" min="0" max="10000" value="${product.width }" id="width" name="width" type="number" style="width: 150px">
							<span class="unit-inline">mm</span>
						</div>
						<label class="col-sm-2 control-label">
							【包装】高：
						</label>
						<div class="col-sm-2">
							<input class="form-control inline" placeholder="" min="0" max="10000" value="${product.highly }" id="highly" name="highly" type="number" style="width: 150px">
							<span class="unit-inline">mm</span>
						</div>

					</div>
					<%--<div class="form-group">

						<label class="col-sm-2 control-label">UPC编码：</label>
						<div class="col-sm-2">
							<input class="form-control" placeholder="" name="upc" type="text" style="width: 75%">
						</div>
					</div>--%>
					<div class="form-group">
						<label class="col-sm-2 control-label">发货地：</label>
						<div class="col-sm-2">
							<select required class="form-control" id="origin" name="origin" style="width: 75%">
								<c:forEach items="${citys }" var="item">
									<option <c:if test="${product.origin==item.id }">selected</c:if> value="${item.id }">${item.name }</option>
								</c:forEach>
							</select>
						</div>
						<%--<label class="col-sm-2 control-label">密度：</label>
						<div class="col-sm-2">
							<input class="form-control inline" readonly="readonly" placeholder="" type="text" style="width: 75%">
							<span class="unit-inline">g/cm3</span>
						</div>--%>
					</div>
					<h4>销售属性</h4>
					<div class="form-group">
						<label class="col-sm-2 control-label">
							颜色：
						</label>
						<div class="col-sm-10" id="allcolor">
							<c:forEach items="${colors }" var="item">
								<label class="checkbox-inline">
									<c:set var="check" value=""/>
									<c:forEach items="${product.pcolors }" var="citem">
										<c:if test="${citem.categorycolorid==item.id }">
											<c:set var="check" value="checked"/>
											<c:set var="cname" value="${citem.name }"/>
										</c:if>
									</c:forEach>
									
									<input type="checkbox" ${check } id="color" value="${item.id }">
									
									<c:if test="${check=='' }">
										<span>${item.name }</span>
									</c:if>
									<c:if test="${check!='' }">
										<input id="c_value" class="form-control inline" style="width: 70px;" value="${cname }"/>
									</c:if>
								</label>
							</c:forEach>
							<div class="add" style="z-index: 1;">
								<div class="add_btn">添加</div>
								<div class="add_msg" style="display: none;">
									<input type="text" value="" />
									<div class="am_btn">
										<span data_type="1" id="save" class="confirm cursor">确定</span>
										<span id="cancel" class="cancel cursor">取消</span>
									</div>
								</div>
							</div>
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-2 control-label">
							规格：
						</label>
						<div class="col-sm-10" id="allspec">
							<c:forEach items="${specs }" var="item">
								<label class="checkbox-inline">
									<c:set var="check" value=""/>
									<c:forEach items="${product.pspecs }" var="sitem">
										<c:if test="${sitem.categoryspecid==item.id }">
											<c:set var="check" value="checked"/>
											<c:set var="sname" value="${sitem.name }"/>
										</c:if>
									</c:forEach>
									
									<input type="checkbox" ${check } id="spec" value="${item.id }">
									
									<c:if test="${check=='' }">
										<span>${item.name }</span>
									</c:if>
									<c:if test="${check!='' }">
										<input id="s_value" class="form-control inline" style="width: 60px;" value="${sname }"/>
									</c:if>
								</label>
							</c:forEach>
							<div class="add">
								<div class="add_btn">添加</div>
								<div class="add_msg" style="display: none;">
									<input type="text" value="" />
									<div class="am_btn">
										<span data_type="2" id="save" class="confirm cursor">确定</span>
										<span id="cancel" class="cancel cursor">取消</span>
									</div>
								</div>
							</div>
						</div>
					</div>
					<div class="form-group">
						<div class="col-sm-offset-2 col-sm-10">
							<table id="p_table" class="table table-bordered" style="margin-top: 20px;">
								<thead id="p_title">
									<tr>
										<c:if test="${product.pcolors.size()>0 }">
											<th>颜色</th>
										</c:if>
										<c:if test="${product.pspecs.size()>0 }">
											<th>规格</th>
										</c:if>
										<th>世峰价（元）</th>
										<th>市场价（元）</th>
										<th>库存（件）</th>
										<th>重量（KG）</th>
										<th>货号</th>
									</tr>
								</thead>
								<tbody id="property">
									<c:set var="colorid" value=""/>
									<c:forEach items="${product.prorules }" var="item" varStatus="sta">
										<tr>
											<c:if test="${item.colorid!='' }">
												<c:if test="${colorid=='' || colorid!=item.colorid }">
													<c:set var="colorid" value="${item.colorid }"/>
													<c:set var="count" value="0"/>
												</c:if>
												<c:forEach items="${product.pcolors }" var="citem">
													<c:if test="${citem.id==item.colorid }">
														<td class="center" rowspan="${item.count }" <c:if test="${count!=0 }">style="display:none;"</c:if>>
															<span>${citem.name }</span>
															<input id="categorycolorid" value="${citem.categorycolorid }" type="hidden">
															<input id="color" value="${citem.name }" type="hidden">
														</td>
													</c:if>
												</c:forEach>
												<c:set var="count" value="${count+1 }"/>
											</c:if>
											<c:if test="${item.specid!='' }">
												<c:forEach items="${product.pspecs }" var="sitem">
													<c:if test="${sitem.id==item.specid }">
														<td class="center">
															<span>${sitem.name }</span>
															<input id="categoryspecid" value="${sitem.categoryspecid }" type="hidden">
															<input id="spec" value="${sitem.name }" type="hidden">
														</td>
													</c:if>
												</c:forEach>
											</c:if>
											<td class="center">
												<input id="price" required min="0" value="${item.price}" class="form-control" placeholder="" type="number">
											</td>
											<td class="center">
												<input id="marketprice" required min="0" value="${item.marketprice}" class="form-control" placeholder="" type="number">
											</td>
											<td class="center">
												<input id="stocks" required min="0" value="${item.stocks}" class="form-control" placeholder="" type="number">
											</td>
											<td class="center">
												<input id="weight" required min="0" value="${item.weight}" class="form-control" placeholder="" type="number">
											</td>
											<td class="center">
												<input id="number" required maxlength="30" value="${item.number}" class="form-control" placeholder="" type="text">
											</td>
											<td style="display: none;">
												<input type="hidden" id="id" value="${item.sku }"/>
											</td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>
					</div>
					
					<h4>
						商品图片<span class="fred tips">*图片尺寸为800*800px,单张大小不超过1024KB,仅支持 jpg，jpeg，png 格式</span>
						<input class="isPImg isPImgcount" type="hidden" name="productimg"/>
					</h4>
					<div class="form-group" style="margin-left: 220px" id="productimg">
						<div class="col-sm-10">
							<c:forEach items="${product.images }" var="item">
								<img class="editimg" style="height: 98px;" src="${item.ipath }"  title="<c:if test="${item.ismain==1 }">主图</c:if><c:if test="${item.ismain==2 }">细节图</c:if>" class="img-thumbnail margin-right10"">
								<input data_type="image" type="hidden" value="${item.ipath }"/>
								<input id="id" type="hidden" value="${item.id }"/>
							</c:forEach>
							
							<div style="display: inline-block;" id="uploadP">
								<img style="height: 98px;" src="static/img/s-img/bg-img-01.jpg" alt="主图" class="img-thumbnail margin-right10" id="uploadImgP">
							</div>
							<button type="button" class="btn btn-success btn-sm">上传图片</button>
						</div>
					</div>
				
					<h4 class="upload_color_img" <c:if test="${product.skuimages.size()==0 }">style="display:none;"</c:if>>
						图片管理<span class="fred tips">*图片尺寸为800*800px,单张大小不超过1024KB,仅支持 jpg，jpeg，png 格式</span>
					</h4>
					
					<c:set var="browse_button" value=""></c:set>
					<c:set var="container" value=""></c:set>
					<c:forEach items="${product.skucolors }" var="item">
						<c:set var="num" value=""></c:set>
						<c:set var="name" value=""></c:set>
						
						<c:forEach items="${product.pcolors }" var="pcolor">
							<c:if test="${pcolor.id==item.colorid}">
								<c:forEach items="${colors }" var="color" varStatus="sta">
									<c:if test="${color.id==pcolor.categorycolorid}">
										<c:set var="num" value="${sta.index }"></c:set>
										<c:set var="name" value="${pcolor.name }"></c:set>
									</c:if>
								</c:forEach>
							</c:if>
						</c:forEach>
						
						<div class="form-group upload_color_img" data_num="${num }" data_id="${item.colorid }">
							<c:forEach items="${product.pcolors }" var="pcolor">
								<c:if test="${pcolor.id==item.colorid}">
									<input type="hidden" id="colorid" value="${pcolor.categorycolorid }"/>
								</c:if>
							</c:forEach>
							<div class="col-sm-offset-1 col-sm-1 text-center margin-top30">
								<strong>${name }</strong><br>
								<span class="fred">（至少5张）</span>
							</div>
							<div class="col-sm-10" id="skuimg">
								<c:forEach items="${product.skuimages }" var="skuimage">
									<c:if test="${item.colorid == skuimage.colorid }">
										<img class="editimg" style="height: 98px;" src="${skuimage.ipath }"  title="<c:if test="${skuimage.ismain==1 }">主图</c:if><c:if test="${skuimage.ismain==2 }">细节图</c:if>" class="img-thumbnail margin-right10"">
										<input data_type="image" type="hidden" value="${skuimage.ipath }"/>
										<input id="id" type="hidden" value="${skuimage.id }"/>
									</c:if>
								</c:forEach>
								
								<div style="display: inline-block;" id="upload_color_${item.colorid }">
									<img style="height: 98px;" src="static/img/s-img/bg-img-01.jpg" alt="主图" class="img-thumbnail margin-right10" id="upload_color_${item.colorid }_img">
								</div>
								<button type="button" class="btn btn-success btn-sm">上传图片</button>
								
								<c:set var="browse_button" value="${browse_button },upload_color_${item.colorid }_img"></c:set>
								<c:set var="container" value="${container },upload_color_${item.colorid }"></c:set>
							</div>
						</div>
					</c:forEach>
					
					<h4>
						商品描述<span class="fred tips">*图片尺寸为宽度800px以内,单张大小不超过1024KB,仅支持 jpg，jpeg，png 格式</span>
					</h4>
					<div class="form-group">
						<div class="col-sm-offset-2 col-sm-10">
							<ul id="tabTitle" class="tab">
								<li class="cursor" style="float: left;">
									<span data_type="pc" class="tabspan_active">电脑版</span>
								</li>
								<li class="cursor">
									<span data_type="phone" class="tabspan">手机版</span>
								</li>
							</ul>
						</div>
						<div class="col-sm-offset-2 col-sm-10">
							<textarea id="description" name="description">${product.description}</textarea>
						</div>
						<div class="col-sm-offset-2 col-sm-10" style="display: none;">
							<textarea id="phone_describe" name="phone_describe">${product.phone_describe}</textarea>
						</div>
					</div>
					<div class="form-group">
						<div class="col-sm-offset-2 col-sm-10 margin-top30">
							<button type="button" id="updateproduct" class="btn btn-success btn-lg margin-right10">保 存</button>
							<button type="button" id="returnproduct" class="btn btn-success btn-lg margin-right10">返 回</button>
						</div>
					</div>
				</form>
			</div>

		</div>
	</div>
	
	<script type="text/javascript" src="/static/upload/plupload-2.1.8/js/plupload.full.min.js"></script>
	<script type="text/javascript" src="/static/js/product/uploadImg.js"></script>
	<script type="text/javascript" src="/static/js/validate/jquery.validate.min.js"></script>
	<script type="text/javascript" src="/static/js/validate/messages_zh.min.js"></script>
	<script type="text/javascript" src="/static/js/product/product.js"></script>
	
	<script type="text/javascript">
		$(function(){
			var browse_button = "${browse_button}".split(",");
			var container = "${container}".split(",");
			
			for(var i=0,len=browse_button.length;i<len;i++){
				if(browse_button[i]!=null&&browse_button[i]!=""){
					var uploadimg = upload(browse_button[i],container[i]);
					uploadimg.init();
				}
			}
			
			$(".editimg").on("click",function(){
				$(this).next().remove();
				$(this).remove();
			})
			
			$("#updateproduct").on("click",function(){
				check_in();
				if($("#info").valid()){
					layer.load(0, {
						shade : 0.3
					});
					$.post("product/updateProduct.json",$("#info").serialize(),function(data){
						layer.closeAll('loading');
						if (data.RESPONSE_STATE == '200') {
							layer.msg('保存成功', {
								icon : 1,
								time : 1 * 1000
							},function(){
								$.post("product/goProduct.html?state=2",function(data){
									$("#content").html(data);
								})
							});
						} else {
							layer.alert(data.ERROR_INFO, {
								icon : 0
							});
						}
					})
				}
			})
			
			$("#returnproduct").on("click",function(){
				$.post("product/goProduct.html",{state:$("#state").val()},function(data){
					$("#content").html(data);
				})
			})
			
		})
		
		function check_in(){
			//销售属性
			$("#property").find("tr").each(function(index){
				var color = $(this).attr("data_color");
				var spec = $(this).attr("data_spec");
				if(color!="undefined"){
					$(this).find("#color").attr("name","prorules["+index+"].colorname");
				}
				
				if(spec!="undefined"){
					$(this).find("#spec").attr("name","prorules["+index+"].specname");
				}
				
				var categorycolorid = $(this).find("#categorycolorid");
				if(categorycolorid.length>0){
					categorycolorid.attr("name","prorules["+index+"].categorycolorid");
				}
				
				var categoryspecid = $(this).find("#categoryspecid");
				if(categoryspecid.length>0){
					categoryspecid.attr("name","prorules["+index+"].categoryspecid");
				}
				
				var price = $(this).find("#price");
				price.attr("name","prorules["+index+"].price");
				var marketprice = $(this).find("#marketprice")
				marketprice.attr("name","prorules["+index+"].marketprice");
				var stocks = $(this).find("#stocks");
				stocks.attr("name","prorules["+index+"].stocks");
				var weight = $(this).find("#weight");
				weight.attr("name","prorules["+index+"].weight");
				var number = $(this).find("#number");
				number.attr("name","prorules["+index+"].number");
				var id = $(this).find("#id");
				if(id.length>0){
					id.attr("name","prorules["+index+"].sku");
				}
			})
			
			//商品图片
			$("#productimg").find("input[data_type='image']").each(function(index){
				$(this).attr("name","images["+index+"].ipath");
			})
			$("#productimg").find("input[type='hidden']#id").each(function(index){
				$(this).attr("name","images["+index+"].id");
			})
			
			//属性图片
			$("div.upload_color_img").each(function(index){
				$(this).find("input#colorid").attr("name","skuimages["+index+"].colorid");
				$(this).find("#skuimg").find("input[data_type='image']").each(function(count){
					$(this).attr("name","skuimages["+index+"].skuImages["+count+"].ipath");
				})
			})
		}

	</script>
</div>
