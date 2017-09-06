<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="box-content">
	<table class="table table-bordered">
		<thead>
			<tr>
				<th>所在地区</th>
				<th>详细地址</th>
				<th>邮编</th>
				<th>联系电话</th>
				<th>发货人姓名</th>
				<th>默认</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${shippingaddresss }" var="item">
				<tr>
					<td class="center">${item.provinceName }${item.cityName }${item.regionName }</td>
					<td class="center">${item.address }</td>
					<td class="center">${item.zipcode }</td>
					<td class="center">${item.phone }</td>
					<td class="center">${item.shipper }</td>
					<td class="center">
						<c:if test="${item.isdefault==1 }">
							是
						</c:if>
						<c:if test="${item.isdefault!=1 }">
							否
						</c:if>
					</td>
					<td class="center">
						<a data_id="${item.id }" class="cursor" id="update">修改</a>
						<a data_id="${item.id }" class="cursor" id="del">删除</a>
					</td>
				</tr>
			</c:forEach>
			<c:if test="${shippingaddresss.size()==0 }">
				<tr>
					<td style="text-align: center;" colspan="7">暂无数据</td>
				</tr>
			</c:if>
		</tbody>
	</table>
	<div class="text-center" id="page"></div>
</div>

<script type="text/javascript">
	$(function(){
		setPage("${page.currentPage}","shippingaddress/findAllShippingAddress.html","${page.totalPage}","shippingaddressList");
		$("tr td").on("click","a#update",function(){
			$("#myTab").find("li").eq(0).removeClass("active");
			$("#myTab").find("li").eq(1).addClass("active");
			
			$("#shippingaddressList").removeClass("in").removeClass("active");
			$("#shippingaddressEdit").addClass("in").addClass("active");
			
			shippingaddressEdit($(this).attr("data_id"));
		})
		
		$("tr td").on("click","a#del",function(){
			var id = $(this).attr("data_id");
			layer.confirm("是否确认删除?",{icon:3},function(index){
				layer.load(0, {
					shade : 0.3
				});
				$.post("shippingaddress/deleteShippingAddress.json",{id:id},function(data){
					layer.closeAll('loading');
					if (data.RESPONSE_STATE=='200') {
						layer.msg('删除成功', {
							icon : 1,
							time : 1 * 1000
						},function(){
							r_submit();
						});
					}else{
						layer.alert(data.ERROR_INFO, {
							icon : 0
						});
					}
				})
			});
		})
	})
	function r_submit(){
		spage("${page.currentPage}","shippingaddress/findAllShippingAddress.html","shippingaddressList");
	}
</script>
