<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class=" row">
	<div class="box col-md-12">
		<div class="box-inner">
			<div class="box-header well">
				<h2>
					<i class="glyphicon glyphicon-th"></i> 商品咨询列表
				</h2>
			</div>
			<form id="form">
				
			</form>
			
			<div class="box-content" id="consultationList">
				
			</div>
		</div>

	</div>
</div>

<script type="text/javascript">
	$(function(){
		productList();
	})
	
	function productList(){
		$.post("productconsultation/findAllProductConsultation.html",$("#form").serialize(),function(data){
			$("#consultationList").html(data);
		})
	}
	
</script>