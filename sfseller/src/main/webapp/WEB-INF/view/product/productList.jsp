<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<style type="text/css">
	.btn_vice {
	    background-color: #fff;
	    border: 1px solid #c7c7c7;
	    border-radius: 5px;
	    color: #333;
	    cursor: pointer;
	    font-size: 12px;
	    font-weight: normal;
	    margin-right: 20px;
	    padding: 2px 10px;
	}
	.ml10 {
	    margin-left: 10px;
	}
</style>

<div class="box-content">
	<div>
		<input type="checkbox" id="select_all"/> 全选
		
		<c:if test="${state==1 }">
			<a id="outAll" class="btn_vice ml10 cursor">批量下架</a>
		</c:if>
		<c:if test="${state==2 }">
			<a id="putawayAll" class="btn_vice ml10 cursor">批量上架</a>
			<a id="deleteAll" class="btn_vice cursor">批量删除</a>
		</c:if>
		<c:if test="${state==3 }">
			<a id="recoverAll" class="btn_vice ml10 cursor">批量恢复</a>
		</c:if>
		
	</div>
	<table class="table table-bordered">
		<thead>
			<tr>
				<th>商品信息</th>
				<th>世峰价（元）</th>
				<th>总库存</th>
				<th>总销量</th>
				<th>创建时间</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${products }" var="item">
				<tr>
					<td colspan="6">
						<input type="checkbox" id="checkbox_id" value="${item.id }">
						<span>商品编号：${item.id }</span>
						<span style="margin-left: 10px;">类目：${item.pcName }>>${item.cName }</span>
					</td>
				</tr>
				<tr>
					<td class="center"><img width="50" height="50" src="${item.logo }"/>${item.name }</td>
					<td class="center">${item.price }</td>
					<td class="center">${item.stocks }</td>
					<td class="center">${item.salecount }</td>
					<td class="center">
						<fmt:formatDate value="${item.submit_time }" pattern="yyyy-MM-dd HH:mm:ss"/>
					</td>
					<td class="center">
						<c:if test="${state==1 }">
							<a data_id="${item.id }" class="cursor" id="update">修改</a>
							<a data_id="${item.id }" class="cursor" id="out">下架</a>
						</c:if>
						<c:if test="${state==2 }">
							<a data_id="${item.id }" class="cursor" id="update">修改</a>
							<a data_id="${item.id }" class="cursor" id="putaway">上架</a>
							<a data_id="${item.id }" class="cursor" id="delete">删除</a>
						</c:if>
						<c:if test="${state==3 }">
							<a data_id="${item.id }" class="cursor" id="recover">恢复</a>
						</c:if>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<div>
		<input type="checkbox" id="select_all"/> 全选
		
		<c:if test="${state==1 }">
			<a id="outAll" class="btn_vice ml10 cursor">批量下架</a>
		</c:if>
		<c:if test="${state==2 }">
			<a id="putawayAll" class="btn_vice ml10 cursor">批量上架</a>
			<a id="deleteAll" class="btn_vice cursor">批量删除</a>
		</c:if>
		<c:if test="${state==3 }">
			<a id="recoverAll" class="btn_vice ml10 cursor">批量恢复</a>
		</c:if>
		
	</div>
	<div class="text-center" id="page"></div>
</div>

<script type="text/javascript">
	$(function(){
		setPage("${page.currentPage}","product/findAllProduct.html","${page.totalPage}","productList",$("#form").serialize());
		
		$("body").on("click","input#select_all",function(){
			if ($(this).is(":checked"))  { // 全选
				$("body").find("input#select_all").prop("checked", true);
				$("table").find("input#checkbox_id").prop("checked", true);
            } else { // 取消全选
            	$("body").find("input#select_all").prop("checked", false);
            	$("table").find("input#checkbox_id").prop("checked", false);
            }
		})
	})
	function p_submit(){
		spage("${page.currentPage}","product/findAllProduct.html","productList",$("#form").serialize());
	}
	
	function checkbox_id(){
		var id = "";
		$("table").find("input#checkbox_id").each(function(){
			if($(this).is(":checked")){
				if(id!=""){
					id += ",";
				}
				id += $(this).val();
			}
		})
		return id;
	}
</script>

<c:if test="${state!=3 }">
	<script type="text/javascript">
		$(function(){
			//修改
			$("tr td").on("click","a#update",function(){
				var id = $(this).attr("data_id");
				var state = $("#state").val();
				$.post("product/goProductEdit.html",{id:id,state:state},function(data){
					$("#content").html(data);
				})
			})
		})
	</script>
</c:if>

<c:if test="${state==1 }">
	<script type="text/javascript">
		$(function(){
			//下架
			$("tr td").on("click","a#out",function(){
				var id = $(this).attr("data_id");
				layer.confirm("是否确认下架该产品?",{icon:3},function(index){
					layer.load(0, {
						shade : 0.3
					});
					$.post("product/updateProductState.json",{id:id,state:2},function(data){
						layer.closeAll('loading');
						if (data.RESPONSE_STATE=='200') {
							layer.msg('下架成功', {
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
				});
			})
			
			//批量下架
			$("body").on("click","#outAll",function(){
				var id = checkbox_id();
				if(id==""){
					layer.alert("请选择要下架的产品！",{icon:0,title:"提醒"});
					return;
				}
				layer.confirm("是否确认下架所有选中的产品?",{icon:3},function(index){
					layer.load(0, {
						shade : 0.3
					});
					$.post("product/updateProductState.json",{id:id,state:2},function(data){
						layer.closeAll('loading');
						if (data.RESPONSE_STATE=='200') {
							layer.msg('下架成功', {
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
				});
			})
		})
	</script>
</c:if>

<c:if test="${state==2 }">
	<script type="text/javascript">
		$(function(){
			//上架
			$("tr td").on("click","a#putaway",function(){
				var id = $(this).attr("data_id");
				layer.confirm("是否确认上架该产品?",{icon:3},function(index){
					layer.load(0, {
						shade : 0.3
					});
					$.post("product/updateProductState.json",{id:id,state:1},function(data){
						layer.closeAll('loading');
						if (data.RESPONSE_STATE=='200') {
							layer.msg('上架成功', {
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
				});
			})
			
			//批量上架
			$("body").on("click","#putawayAll",function(){
				var id = checkbox_id();
				if(id==""){
					layer.alert("请选择要上架的产品！",{icon:0,title:"提醒"});
					return;
				}
				layer.confirm("是否确认上架所有选中的产品?",{icon:3},function(index){
					layer.load(0, {
						shade : 0.3
					});
					$.post("product/updateProductState.json",{id:id,state:1},function(data){
						layer.closeAll('loading');
						if (data.RESPONSE_STATE=='200') {
							layer.msg('上架成功', {
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
				});
			})
			
			//删除
			$("tr td").on("click","a#delete",function(){
				var id = $(this).attr("data_id");
				layer.confirm("是否确认删除该产品?",{icon:3},function(index){
					layer.load(0, {
						shade : 0.3
					});
					$.post("product/updateProductState.json",{id:id,state:3},function(data){
						layer.closeAll('loading');
						if (data.RESPONSE_STATE=='200') {
							layer.msg('删除成功', {
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
				});
			})
			
			//批量删除
			$("body").on("click","#deleteAll",function(){
				var id = checkbox_id();
				if(id==""){
					layer.alert("请选择要删除的产品！",{icon:0,title:"提醒"});
					return;
				}
				layer.confirm("是否确认删除所有选中的产品?",{icon:3},function(index){
					layer.load(0, {
						shade : 0.3
					});
					$.post("product/updateProductState.json",{id:id,state:3},function(data){
						layer.closeAll('loading');
						if (data.RESPONSE_STATE=='200') {
							layer.msg('删除成功', {
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
				});
			})
			
		})
	</script>
</c:if>

<c:if test="${state==3 }">
	<script type="text/javascript">
		$(function(){
			//恢复
			$("tr td").on("click","a#recover",function(){
				var id = $(this).attr("data_id");
				layer.confirm("是否确认恢复该产品?",{icon:3},function(index){
					layer.load(0, {
						shade : 0.3
					});
					$.post("product/updateProductState.json",{id:id,state:2},function(data){
						layer.closeAll('loading');
						if (data.RESPONSE_STATE=='200') {
							layer.msg('回复成功', {
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
				});
			})
			
			//批量恢复
			$("body").on("click","#recoverAll",function(){
				var id = checkbox_id();
				if(id==""){
					layer.alert("请选择要恢复的产品！",{icon:0,title:"提醒"});
					return;
				}
				layer.confirm("是否确认恢复所有选中的产品?",{icon:3},function(index){
					layer.load(0, {
						shade : 0.3
					});
					$.post("product/updateProductState.json",{id:id,state:2},function(data){
						layer.closeAll('loading');
						if (data.RESPONSE_STATE=='200') {
							layer.msg('回复成功', {
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
				});
			})
		})
	</script>
</c:if>


