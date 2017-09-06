<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class=" row">
	<div class="box col-md-12">
		<div class="box-inner">
			<div class="box-header well">
				<h2>
					<i class="glyphicon glyphicon-th"></i> 售后模板管理
				</h2>
			</div>
			<div class="box-content">
				<ul class="nav nav-tabs" id="myTab">
					<li class="active"><a href="#aftersalesList" data-toggle="tab">售后模板列表</a></li>
					<li><a href="#aftersalesEdit" data-toggle="tab">创建售后模板</a></li>
				</ul>

				<div id="myTabContent" class="tab-content">
					<div class="tab-pane fade in active" id="aftersalesList">

					</div>
					<div class="tab-pane fade" id="aftersalesEdit">
						
					</div>
				</div>
			</div>
		</div>

	</div>
</div>

<script type="text/javascript">
	$(function(){
		aftersalesList();
		
		$("#myTab").on("click","li",function(){
			if($(this).index()==0){
				aftersalesList();
			}else{
				aftersalesEdit();
			}
		})
		
	})
	
	function aftersalesList(){
		$.post("aftersalespolicy/findAllAfterSalesPolicy.html",function(data){
			$("#aftersalesList").html(data);
		})
	}
	
	function aftersalesEdit(id){
		var str = "";
		if(id!=null){
			str = "?id="+id;
		}
		$.post("aftersalespolicy/goAfterSalesPolicyEdit.html"+str,function(data){
			$("#aftersalesEdit").html(data);
		})
	}
</script>