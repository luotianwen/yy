<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<div class="box-content">
	<table class="table table-bordered">
		<thead>
			<tr>
				<th>品牌ID</th>
				<th>品牌名</th>
				<th>品牌首字母</th>
				<th>品牌LOGO</th>
				<th>到期日</th>
				<!-- <th>授权状态</th> -->
				<th>审核状态</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody id="brands">
			<c:forEach items="${shopbrand }" var="item">
				<tr>
					<td class="center">${item.id }</td>
					<c:if test="${item.brand!=null }">
						<td class="center">
							${item.brand.name }
						</td>
						<td class="center">${item.brand.letter }</td>
						<td class="center"><img style="width:100px;" src="${item.brand.logo }"></td>
					</c:if>
					<c:if test="${item.brand==null }">
						<td class="center">
							${item.name }
						</td>
						<td class="center">${item.letter }</td>
						<td class="center"><img style="width:100px;" src="${item.logo }"></td>
					</c:if>
					
					<td class="center">
						<fmt:formatDate value="${item.valid_period}" pattern="yyyy-MM-dd HH:mm:ss" />
					</td>
					<td class="center">
						<c:if test="${item.state==1 }">
							<span style="color:green;">审核成功</span>
						</c:if>
						<c:if test="${item.state==2 }">
							<span style="color:green;">审核失败</span>
						</c:if>
						<c:if test="${item.state==3 }">
							<span style="color:green;">待审核</span>
						</c:if>
					</td>
					<td class="center">
						<a data_id="${item.id }" class="cursor" id="check">查看</a>
					</td>
			</c:forEach>
			<c:if test="${shopbrand.size()==0 }">
				<tr>
					<td style="text-align: center;" colspan="8">暂无数据</td>
				</tr>
			</c:if>
			
		</tbody>
	</table>
	<div id="page"></div>
</div>

<script type="text/javascript">
	$(function(){
		setPage("${page.currentPage}","shopbrand/findMyShopBrand.html","${page.totalPage}","allbrand",$('#shopbrand').serialize());
		$("tr td").on("click","a#check",function(){
			$("#myTab").find("li").eq(0).removeClass("active");
			$("#myTab").find("li").eq(1).addClass("active");
			
			$("#brandList").removeClass("in").removeClass("active");
			$("#applyBrand").addClass("in").addClass("active");
			
			var id = $(this).attr("data_id");
			
			$.post("shopbrand/findShopBrandById.html",{id:id},function(data){
				$("#applyBrand").html(data);
			})
		})
		
		$("#search").on("click",function(){
			b_submit();
		})
		
	})
	function b_submit(){
		spage("${page.currentPage}","shopbrand/findMyShopBrand.html","allbrand",$('#shopbrand').serialize());
	}
</script>