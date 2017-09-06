<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class=" row">
	<div class="box col-md-12">
		<div class="box-inner">
			<div class="box-header well">
				<h2>
					<i class="glyphicon glyphicon-th"></i> 店铺规格
				</h2>
			</div>
			<form class="form-inline" id="form" style="margin: 20px 0;">
				<div class="form-group">
					<label>一级分类</label>
					<select id="pid" class="form-control">
						<option value="0">—请选择—</option>
						<c:forEach items="${shopCategoryDTO }" var="item">
							<option value="${item.parentid }">${item.parentname }</option>
						</c:forEach>
					</select>
				</div>
				
				<div class="form-group">
					<label>二级分类</label>
					<select id="cid" name="cid" class="form-control" style="width: 100px;"></select>
				</div>
				
				<button id="search" type="button" class="btn btn-success">查 询</button>
			</form>
			<div class="box-content"id="specList">
				
			</div>
		</div>

	</div>
</div>

<script type="text/javascript">
	$(function(){
		$("#pid").on("change",function(){
			var id = $("#pid").val();
			layer.load(0, {
				shade : 0.3
			});
			$.post("product/findShopCategoryByPid.json",{id:id},function(data){
				layer.closeAll('loading');
				if(data.RESPONSE_STATE=="200"){
					var html = "";
					for(var i=0,len=data.shopCategoryDTO.length;i<len;i++){
						var dto = data.shopCategoryDTO[i];
						html += "<option value='"+dto.c_category_id+"'>"+dto.categoryName+"</option>";
					}
					$("#cid").html(html);
				}else{
					layer.alert(data.ERROR_INFO, {
						icon : 0
					});
				}
			})
		})
		
		$("#search").on("click",function(){
			if($("#cid")==null||$("#cid")==""){
				return;
			}
			$.post("shopcategoryspec/findAllShopCategorySpec.html",$("#form").serialize(),function(data){
				$("#specList").html(data);
			})
		})
	})
	
</script>