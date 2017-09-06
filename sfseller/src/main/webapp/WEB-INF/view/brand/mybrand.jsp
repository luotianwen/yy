<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="row">
	<div class="box col-md-12">
		<div class="box-inner">
			<div class="box-header well">
				<h2>
					<i class="glyphicon glyphicon-th"></i> 品牌管理
				</h2>
			</div>
			<div class="box-content">
				<ul class="nav nav-tabs" id="myTab">
					<li class="active"><a href="#brandList" data-toggle="tab">品牌列表</a></li>
					<li><a href="#applyBrand" data-toggle="tab">申请新品牌</a></li>
				</ul>

				<div id="myTabContent" class="tab-content">
					<div class="tab-pane fade in active" id="brandList">
						<form class="form-inline" id="shopbrand" style="margin: 20px 0;">
							<div class="form-group">
								<label>品牌名</label>
								<input type="text" class="form-control" id="name" name="name">
							</div>
							<div class="form-group">
								<label>品牌审核状态</label>
								<select	class="form-control" name="state">
									<option value="0">全部</option>
									<option value="1">审核成功</option>
									<option value="2">审核失败</option>
									<option value="3">待审核</option>
								</select>
							</div>
							<button id="search" type="button" class="btn btn-success">查 询</button>
						</form>
						<div id="allbrand"></div>
					</div>
					<div class="tab-pane fade" id="applyBrand">
						
					</div>

				</div>
			</div>
		</div>

	</div>

</div>

<script type="text/javascript">
	$(function(){
		brandList();
		
		$("#myTab").on("click","li",function(){
			if($(this).index()==0){
				brandList();
			}else{
				applyBrand();
			}
		})
	})
	
	function brandList(){
		$.post("shopbrand/findMyShopBrand.html",function(data){
			$("#allbrand").html(data);
		})
	}
	
	function applyBrand(){
		$.post("shopbrand/goApplyBrand.html",function(data){
			$("#applyBrand").html(data);
		})
	}
	
</script>