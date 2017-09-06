<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="box-content">
	<form class="form-inline" style="margin: 20px 0;">
		<span class="help-block inline fred margin-left10">
			温馨提示：售后政策中不得包含敏感词语、淫秽黄色等相关违反法律法规内容，一旦违规立即关闭店铺，下架所有商品。
		</span>
	</form>
	<table class="table table-bordered">
		<thead>
			<tr>
				<th>编号</th>
				<th>标题名称</th>
				<th>描述</th>
				<th>是否启用</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${aftersalespolicys }" var="item">
				<tr>
					<td>${item.id }</td>
					<td class="center">${item.title }</td>
					<td class="center">${item.descript }</td>
					<td class="center">
						<c:if test="${item.state==1 }">
							启用
						</c:if>
						<c:if test="${item.state==2 }">
							未启用
						</c:if>
					</td>
					<td class="center"><a data_id="${item.id }" class="cursor" id="update">更新</a></td>
				</tr>
			</c:forEach>
			<c:if test="${aftersalespolicys.size()==0 }">
				<tr>
					<td style="text-align: center;" colspan="8">暂无数据</td>
				</tr>
			</c:if>
		</tbody>
	</table>
	<div class="text-center" id="page"></div>
</div>

<script type="text/javascript">
	$(function(){
		setPage("${page.currentPage}","aftersalespolicy/findAllAfterSalesPolicy.html","${page.totalPage}","aftersalesList");
		
		$("tr td").on("click","a#update",function(){
			$("#myTab").find("li").eq(0).removeClass("active");
			$("#myTab").find("li").eq(1).addClass("active");
			
			$("#aftersalesList").removeClass("in").removeClass("active");
			$("#aftersalesEdit").addClass("in").addClass("active");
			
			aftersalesEdit($(this).attr("data_id"));
		})
	})
</script>
