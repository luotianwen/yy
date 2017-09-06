<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<div class="box-content">
	<input type="hidden" id="categoryid" value="${categoryid }"/>
	<table class="table table-bordered">
		<thead>
			<tr>
				<th>名称</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${shopCategorySpecs }" var="item">
				<tr>
					<td class="center">
						<input id="name" value="${item.name }" readonly="true" style="border: 0;"/>
					</td>
					<td class="center">
						<a data_id="${item.id }" class="cursor" id="update">修改</a>
						<a data_id="${item.id }" class="cursor" id="delete">删除</a>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	
	<div class="ibox-content">
		<button id="add" type="button" class="btn btn-success">添 加</button>
	</div>
	
	<div class="text-center" id="page"></div>
</div>

<script type="text/javascript">
	$(function(){
		$("table tr").on("click","td a#update",function(){
			var _this = $(this);
			var input = _this.closest("tr").find("#name");
			
			if(input.attr("readonly")){
				_this.html("保存");
				input.css("border","");
				input.removeAttr("readonly");
			}else{
				$.post("shopcategoryspec/updateShopCategorySpec.json",{id:_this.attr("data_id"),name:input.val()},function(data){
					if (data.RESPONSE_STATE == '200') {
						layer.msg('保存成功', {
							icon : 1,
							time : 1 * 1000
						}, function() {
							_this.html("修改");
							input.css("border","0");
							input.attr("readonly","true");
						});
					} else {
						layer.alert(data.ERROR_INFO, {
							icon : 0
						});
					}
				})
			}
		})
		
		$("table tr").on("click","td a#delete",function(){
			var id = $(this).attr("data_id");
			layer.confirm("确认删除吗?", {
				shade : 0.3,
				btn : [ '确认', '取消' ],
				icon : 3
			}, function(layerIndex) {
				layer.close(layerIndex);
				$.post("shopcategoryspec/deleteShopCategorySpec.json",{id:id},function(data){
					if (data.RESPONSE_STATE == '200') {
						layer.msg('删除成功!', {icon : 1,time : 1 * 1000}, function() {
							c_submit();
						})
					}else{
						layer.alert(data.ERROR_INFO, {
							icon : 0
						});
					}
				})
			})
		})
		
		$("#add").on("click",function(){
			if($("#save").length==0){
				var html = '<tr>'+
							'	<td class="center">'+
							'		<input id="name"/>'+
							'	</td>'+
							'	<td class="center">'+
							'		<a class="cursor" id="save">保存</a>'+
							'	</td>'+
							'</tr>';
				$("table tbody").append(html);
			}
		})
		
		$("table").on("click","td a#save",function(){
			var name = $(this).closest("tr").find("#name").val();
			var categoryid = $("#categoryid").val();
			if(name==""){
				layer.alert("规格名称不能为空!!!", {
					icon : 0
				});
				return;
			}
			
			if(categoryid==""){
				layer.alert("请选择分类!!!", {
					icon : 0
				});
				return;
			}
			
			$.post("shopcategoryspec/saveShopCategorySpec.json",{name:name,cid:categoryid},function(data){
				if (data.RESPONSE_STATE == '200') {
					layer.msg('新增成功!', {icon : 1,time : 1 * 1000}, function() {
						c_submit();
					})
				}else{
					layer.alert(data.ERROR_INFO, {
						icon : 0
					});
				}
			})
		})
		
		setPage("${page.currentPage}","shopcategoryspec/findAllShopCategorySpec.html","${page.totalPage}","specList",$("#form").serialize());
		
	})
	function c_submit(){
		spage("${page.currentPage}","shopcategoryspec/findAllShopCategorySpec.html","specList",$("#form").serialize());
	}
	
</script>



