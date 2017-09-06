<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<table class="table table-striped table-hover">
	<thead>
		<tr>
			<th>
				<label>
					<input type="checkbox" id="checkAll" class="i-checks">
				</label>
			</th>
			<th>词</th>
			<th>简拼</th>
			<th>全拼</th>
			<th>类型</th>
			<th>相关结果</th>
			<th>搜索指数</th>
			<th>权重</th>
			<th>是否启用</th>
			<th>添加/更新时间</th>
			<th class="text-center">操作</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${dictionaryList }" var="dic">
			<tr>
				<td>
					<label>
						<input type="checkbox" id="tgp_id" value="${dic.id }" class="i-checks">
					</label>
				</td>
				<td>${dic.word }</td>
				<td>${dic.jp }</td>
				<td>${dic.qp }</td>
				<td>
					<c:choose>
						<c:when test="${dic.dic_type == 1 }">
							<span title="基本词" class="badge badge-primary badge-rounded">基本词</span>
						</c:when>
						<c:otherwise>
							<span title="停止词" class="badge badge-success badge-rounded">停止词</span>
						</c:otherwise>
					</c:choose>
				</td>
				<td>${dic.related_count }</td>
				<td>${dic.search_count }</td>
				<td>${dic.weight }</td>
				<td>
					<input id="switch" type="checkbox" value="${dic.is_enable }" data-on-text="是" data-off-text="否" data-on-color="success" <c:if test="${dic.is_enable == '0' }">checked</c:if>>
				</td>
				<td>
					<fmt:formatDate value="${dic.update_time }" pattern="yyyy-MM-dd HH:mm:ss" />
				</td>
				<td class="center">
					<p data-id="${dic.id }" class="center">
						<button type="button" id="dic-edit" class="btn btn-outline btn-primary">
							<i class="fa fa-paste"></i> 编辑
						</button>
					</p>
				</td>
			</tr>
		</c:forEach>


	</tbody>
</table>

<script>
	$(function(){
		setPage("${page.currentPage}","dic/list.html","${page.totalPage}","dictionaryList",$("#dictionary").serialize());
	})
</script>