<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class=" row">
	<div class="box col-md-12">
		<div class="box-inner">
			<div class="box-header well">
				<h2>
					<i class="glyphicon glyphicon-th"></i> 库存列表
				</h2>
			</div>
			<form class="form-inline" id="form" style="margin: 20px 0;">
				<div class="form-group">
					<label>商品编号</label>
					<input type="text" class="form-control" id="pid" name="pid">
				</div>
				<div class="form-group">
					<label>商品名称</label>
					<input type="text" class="form-control" id="name" name="name">
				</div>
				<div class="form-group">
					<label>商品状态</label>
					<select class="form-control" name="state">
						<option value="0">—请选择商品状态—</option>
						<option value="1">出售中</option>
						<option value="2">待售中</option>
					</select>
				</div>
				<button id="search" type="button" class="btn btn-success">查 询</button>
			</form>
			<div class="box-content"id="prorulesList">
				
			</div>
		</div>

	</div>
</div>

<script type="text/javascript">
	$(function(){
		$("#search").on("click",function(){
			$.post("prorules/findAllProRules.html",$("#form").serialize(),function(data){
				$("#prorulesList").html(data);
			})
		})
		$("#search").trigger("click");
	})
	
</script>