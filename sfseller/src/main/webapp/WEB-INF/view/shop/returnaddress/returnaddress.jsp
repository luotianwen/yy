<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class=" row">
	<div class="box col-md-12">
		<div class="box-inner">
			<div class="box-header well">
				<h2>
					<i class="glyphicon glyphicon-th"></i> 退货地址管理
				</h2>
			</div>
			<div class="box-content">
				<ul class="nav nav-tabs" id="myTab">
					<li class="active"><a href="#returnaddressList" data-toggle="tab">退货地址列表</a></li>
					<li><a href="#returnaddressEdit" data-toggle="tab">增加退货地址</a></li>
				</ul>

				<div id="myTabContent" class="tab-content">
					<div class="tab-pane fade in active" id="returnaddressList">

					</div>
					<div class="tab-pane fade" id="returnaddressEdit">
						
					</div>
				</div>
			</div>
		</div>

	</div>
</div>

<script type="text/javascript">
	$(function(){
		returnaddressList();
		
		$("#myTab").on("click","li",function(){
			if($(this).index()==0){
				returnaddressList();
			}else{
				returnaddressEdit();
			}
		})
		
	})
	
	function returnaddressList(){
		$.post("returnaddress/findAllReturnAddress.html",function(data){
			$("#returnaddressList").html(data);
		})
	}
	
	function returnaddressEdit(id){
		var str = "";
		if(id!=null){
			str = "?id="+id;
		}
		$.post("returnaddress/goReturnAddressEdit.html"+str,function(data){
			$("#returnaddressEdit").html(data);
		})
	}
</script>