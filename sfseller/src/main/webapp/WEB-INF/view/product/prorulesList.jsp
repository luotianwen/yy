<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="box-content">
	<table class="table table-bordered">
		<thead>
			<tr>
				<th></th>
				<th>商品编号</th>
				<th>商品货号</th>
				<th>商品名称</th>
				<th>商品属性</th>
				<th>库存总数</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${proruless }" var="item">
				<tr>
					<td class="center">
						<input type="checkbox" id="checkbox_id" value="${item.sku }"/>
					</td>
					<td class="center">${item.sku }</td>
					<td class="center">${item.number }</td>
					<td class="center">${item.name }</td>
					<td class="center">
						<c:if test="${item.colorid!=null && item.colorid!='' }">
							<div>颜色：${item.colorname }</div>
						</c:if>
						<c:if test="${item.specid!=null && item.specid!='' }">
							<div>规格：${item.specname }</div>
						</c:if>
					</td>
					<td class="center">
						<input type="text" name="stocks" value="${item.stocks}" style="width:80px;text-align:center" onkeyup="value=value.replace(/[^\d]/g,'')" onbeforepaste="clipboardData.setData('text',clipboardData.getData('text').replace(/[^\d]/g,''))" maxlength="5">
					</td>
				</tr>
			</c:forEach>
			<c:if test="${proruless.size()==0 }">
				<tr>
					<td style="text-align: center;" colspan="6">暂无数据</td>
				</tr>
			</c:if>
		</tbody>
	</table>
	<div>
		<input type="checkbox" id="select_all"/> 全选
		<a id="update" class="btn_vice ml10 cursor">更新库存</a>
	</div>
	<div class="text-center" id="page"></div>
</div>

<script type="text/javascript">
	$(function(){
		setPage("${page.currentPage}","prorules/findAllProRules.html","${page.totalPage}","prorulesList",$("#form").serialize());
		
		//全选
		$("#select_all").on("click",function(){
			if ($(this).is(":checked"))  { // 全选
				$("table").find("input#checkbox_id").prop("checked", true);
            } else { // 取消全选
            	$("table").find("input#checkbox_id").prop("checked", false);
            }
		})
		
		//修改库存后选中
		$("table").on("change","input[name='stocks']",function(){
			$(this).closest("tr").find("input#checkbox_id").prop("checked", true);
		})
		
		//修改库存
		$("#update").on("click",function(){
			var sku = "";
			var stocks = "";
			$("table").find("input#checkbox_id").each(function(){
				if($(this).is(":checked")){
					if(sku!=""){
						sku += ",";
					}
					sku += $(this).val();
					
					if(stocks!=""){
						stocks += ",";
					}
					stocks += $(this).closest("tr").find("input[name='stocks']").val();
				}
			})
			
			if(sku!=""&&stocks!=""){
				$.post("prorules/updateProRulesStocks.json",{sku:sku,stocks:stocks},function(data){
					if (data.RESPONSE_STATE=='200') {
						layer.msg('修改成功', {
							icon : 1,
							time : 1 * 1000
						},function(){
							p_submit();
						});
					}else{
						layer.alert(data.ERROR_INFO, {
							icon : 0
						});
					}
				})
			}else{
				layer.alert("请选择要修改的产品！",{icon:0,title:"提醒"});
			}
			
		})
	})
	function p_submit(){
		spage("${page.currentPage}","prorules/findAllProRules.html","prorulesList",$("#form").serialize());
	}
</script>
