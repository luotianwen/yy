<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<style type="text/css">
	.assessArea {
	    border: 1px solid #88cd9c;
	    margin-top: 15px;
	    width: 1038px;
	}
	.assessArea .list {
	    overflow: hidden;
	    margin: 0 10px;
	}
	.assessArea .list .item_01 {
	    border-bottom: 1px dotted #898989;
	    height: 40px;
	    line-height: 40px;
	}
	.assessArea .list .item_02 {
	    height: 40px;
	    line-height: 40px;
	}
	.assessArea .list .item_03 {
	    background: #f9f9f9;
	    padding: 10px;
	    overflow: hidden;
	}
	.assessArea .input {
	    border: 1px solid #c0c0c0;
	    height: 22px;
	    line-height: 20px;
	    vertical-align: middle;
	    padding: 0 5px;
	}
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
	.mr50 {
	    margin-right: 50px;
	}
	p {
	    display: block;
	    -webkit-margin-before: 1em;
	    -webkit-margin-after: 1em;
	    -webkit-margin-start: 0px;
	    -webkit-margin-end: 0px;
	}
</style>

<div class="main">
	<div class="order_tbl assessArea">
		<div class="list">
			<c:forEach items="${productevaluates }" var="item">
				<div class="item_01">
					<span class="mr50">订单编号：
						<span class="txt_02">${item.orderid}</span>
					</span>
					<span class="mr50">评论时间：<fmt:formatDate value="${item.cdate }" pattern="yyyy-MM-dd HH:mm:ss"/></span>
					<span class="mr50">评论人：${item.receiveName }</span>
				</div>
				<div class="item_02">
					商品名称：
					<a href="http://www.seebong.com/detail/${item.sku}.html">
						<span class="txt_02">${item.name }</span>
					</a>
				</div>
				<div class="item_03">
					<p>
						<span>商品评分：</span>
						<span class="mr50">${item.score }</span>
					</p>
					<p>评价内容：${item.content }</p>
					<c:forEach items="${item.productEvaluateReplays }" var="ritem">
						<p>${ritem.rcontent }</p>
					</c:forEach>
					<p>
						<input name="replycontent" type="text" class="input" style="width: 800px;" placeholder="可在此输入回复内容，回复后不可更改">
						<a id="reply" class="btn_vice ml10 crusor" data_id="${item.id }">回复</a>
					</p>
				</div>
			</c:forEach>
		</div>
		<div class="text-center" id="page"></div>
	</div>
</div>

<script type="text/javascript">
	$(function(){
		setPage("${page.currentPage}","productevaluate/findAllProductEvaluate.html","${page.totalPage}","evaluateList",$("#form").serialize());
	
		$("p").on("click","a#reply",function(){
			var _this = $(this);
			var rcontent = _this.prev().val();
			if(rcontent.trim()!=""){
				layer.confirm("回复后无法删除，请确认内容是否无误?",{icon:3},function(index){
					var ppeid = _this.attr("data_id");
					layer.load(0, {
						shade : 0.3
					});
					$.post("productevaluate/saveProductEvaluateReplay.json",{ppeid:ppeid,rcontent:rcontent},function(data){
						layer.closeAll('loading');
						if (data.RESPONSE_STATE == '200') {
							layer.msg('保存成功', {
								icon : 1,
								time : 1 * 1000
							}, function() {
								p_submit();
							});
						} else {
							layer.alert(data.ERROR_INFO, {
								icon : 0
							});
						}
					})
				});
			}else{
				layer.alert("请输入回复内容！", {
					icon : 0
				});
				return;
			}
		})
	})
	
	function p_submit(){
		spage("${page.currentPage}","productevaluate/findAllProductEvaluate.html","evaluateList",$("#form").serialize());
	}
</script>

