<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- content starts -->
<div class="row">
	<div class="box col-md-12" id="choosecategory">
		<div class="box-inner">
			<div class="box-header well">
				<h2>
					<i class="glyphicon glyphicon-th"></i> 添加新商品
				</h2>
			</div>
			<div class="box-content">
				<div class="form-info">
					<form class="form-horizontal">
						<h4>选择类目</h4>
						<div class="form-group">
							<label for="FirstLetter" class="col-sm-2 control-label">选择商品类目：</label>
							<div class="col-sm-10">
								<div class="category-list">
									<ul id="parent" class="c-item" style="border-right: 1px solid #ebebeb;height: 245px;">
										<c:forEach items="${shopCategoryDTO }" var="item">
											<li class="cursor">
												<a data_id="${item.parentid }">
													 ${item.parentname }
													 <!-- <i class="glyphicon glyphicon-arrow-right"></i> -->
												</a>
											</li>
										</c:forEach>
									</ul>
									<ul id="category" class="c-item" style="border-left: 0;height: 245px;"></ul>
								</div>
								<!-- <div class="btn-select">
									<button class="btn btn-success btn-sm">选 择</button>
								</div> -->
							</div>
						</div>
						<div class="form-group">
							<div class="col-sm-offset-2 col-sm-10">
								<div class="category-selected">
									您选择的类目：<span id="select_category"></span>
								</div>
							</div>
						</div>
						<div class="form-group">
							<div class="col-sm-offset-2 col-sm-10">
								<button id="submit" type="button" class="btn btn-success btn-lg">下一步，填写详细信息</button>
							</div>
						</div>
					</form>
				</div>

			</div>
		</div>

	</div>
	
	<div id="productinfo"></div>
	
	<script type="text/javascript">
		$(function(){
			$("#parent").on("click","li",function(){
				$("#parent").find("li a").removeClass("current");
				var _a = $(this).find("a")
				_a.addClass("current");
				var id = _a.attr("data_id");
				$.post("product/findShopCategoryByPid.json",{id:id},function(data){
					if(data.RESPONSE_STATE=="200"){
						var html = "";
						for(var i=0,len=data.shopCategoryDTO.length;i<len;i++){
							var category = data.shopCategoryDTO[i];
							
							html += '<li class="cursor">'+
									'	<a data_id="'+category.c_category_id+'">'+
									'		'+category.categoryName+'<!-- <i class="glyphicon glyphicon-arrow-right"></i> -->'+
									'	</a>'+
									'</li>';
							}
						$("#category").html(html);
						$("#select_category").html("");
					}else{
						layer.alert(data.ERROR_INFO, {
							icon : 0
						});
					}
					
				})
			})
			
			$("#category").on("click","li",function(){
				$("#category li a.current").removeClass("current");
				$(this).find("a").addClass("current");
				$("#select_category").html($("#parent li a.current").html()+"/"+$("#category li a.current").html());
			})
			
			$("#submit").on("click",function(){
				if($("#category").find("li a.current").length>0){
					var id = $("#category").find("li a.current").attr("data_id");
					var pid = $("#parent").find("li a.current").attr("data_id");
					$.post("product/goSaveProduct.html",{id:id,pid:pid},function(data){
						$("#choosecategory").css("display","none");
						$("#productinfo").html(data);
						$("#categoryName").html($("#parent li a.current").html()+"/"+$("#category li a.current").html()+"<input type='hidden' id='pcid' name='pcid' value='"+$("#parent li a.current").attr("data_id")+"'/>"+"<input type='hidden' id='cid' name='cid' value='"+$("#category li a.current").attr("data_id")+"'/>");
					})
				}
			})
			
		})
	</script>
	
</div>