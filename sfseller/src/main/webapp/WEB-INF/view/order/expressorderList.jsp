<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:if test="${expressorder!=null }">
	<tr>
		<td class="center">${expressorder.orderId }</td>
		<td class="center">${expressorder.name }</td>
		<td class="center">
			<select id="expressId" name="expressId">
				<c:forEach items="${expressconfig }" var="item">
					<option value="${item.id }" <c:if test="${item.id==expressorder.expressId }">selected</c:if>>${item.name }</option>
				</c:forEach>
			</select>
		</td>
		<td class="center">
			<input type="text" id="expressNumber" maxlength="30" name="expressNumber" value="${expressorder.expressNumber }"/>
		</td>
		<td class="center">
			${expressorder.defaultPayment }
		</td>
		<td class="center">
			<c:if test="${expressorder.expressNumber!=null&&expressorder.expressNumber!='' }">
				<a data_id="${expressorder.orderId }" class="cursor" id="update">保存</a>
			</c:if>
		</td>
	</tr>
</c:if>
