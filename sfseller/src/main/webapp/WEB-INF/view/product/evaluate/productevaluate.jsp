<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class=" row">
	<div class="box col-md-12">
		<div class="box-inner">
			<div class="box-header well">
				<h2>
					<i class="glyphicon glyphicon-th"></i> 商品列表
				</h2>
			</div>
			<form id="form">
				
			</form>
			
			<div class="box-content" id="evaluateList">
				
			</div>
		</div>

	</div>
</div>

<script type="text/javascript">
	$(function(){
		productList();
	})
	
	function productList(){
		$.post("productevaluate/findAllProductEvaluate.html",$("#form").serialize(),function(data){
			$("#evaluateList").html(data);
		})
	}
	
</script>