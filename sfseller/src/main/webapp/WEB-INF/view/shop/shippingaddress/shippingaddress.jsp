<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="row">
	<div class="box col-md-12">
		<div class="box-inner">
			<div class="box-header well">
				<h2>
					<i class="glyphicon glyphicon-th"></i> 发货地址管理
				</h2>
			</div>
			<div class="box-content">
				<ul class="nav nav-tabs" id="myTab">
					<li class="active"><a href="#shippingaddressList" data-toggle="tab">发货地址列表</a></li>
					<li><a href="#shippingaddressEdit" data-toggle="tab">增加发货地址</a></li>
				</ul>

				<div id="myTabContent" class="tab-content">
					<div class="tab-pane fade in active" id="shippingaddressList">

					</div>
					<div class="tab-pane fade" id="shippingaddressEdit">
						
					</div>
				</div>
			</div>
		</div>

	</div>
</div>

<script type="text/javascript">
	$(function(){
		shippingaddressList();
		
		$("#myTab").on("click","li",function(){
			if($(this).index()==0){
				shippingaddressList();
			}else{
				shippingaddressEdit();
			}
		})
		
	})
	
	function shippingaddressList(){
		$.post("shippingaddress/findAllShippingAddress.html",function(data){
			$("#shippingaddressList").html(data);
		})
	}
	
	function shippingaddressEdit(id){
		var str = "";
		if(id!=null){
			str = "?id="+id;
		}
		$.post("shippingaddress/goShippingAddressEdit.html"+str,function(data){
			$("#shippingaddressEdit").html(data);
		})
	}
</script>