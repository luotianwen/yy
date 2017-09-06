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
			<c:forEach items="${productconsultations }" var="item">
				<div class="item_01">
					<span class="mr50">商品名称：
						<a href="http://www.seebong.com/detail/${item.sku}.html">
							<span class="txt_02">${item.name }</span>
						</a>
					</span>
					
					<span class="mr50">咨询时间：<fmt:formatDate value="${item.cdate }" pattern="yyyy-MM-dd HH:mm:ss"/></span>
					<span class="mr50">咨询人：${item.receiveName }</span>
					<span class="mr50">
						审核状态：
						<c:if test="${item.state==1 }">
							未审核
						</c:if>
						<c:if test="${item.state==2 }">
							审核成功
						</c:if>
						<c:if test="${item.state==3 }">
							审核失败
						</c:if>
					</span>
				</div>
				<div class="item_03">
					<p>
						<span>咨询类型：商品咨询</span>
					</p>
					<p>咨询内容：${item.content }</p>
					
					<c:if test="${item.productConsultationReplay!=null }">
						${item.productConsultationReplay.rName} ： 回复 ${item.receiveName } ： ${item.productConsultationReplay.rcontent } <fmt:formatDate value="${item.productConsultationReplay.rdate }" pattern="yyyy-MM-dd HH:mm:ss"/></span>
					</c:if>
					
					<c:if test="${item.productConsultationReplay==null }">
						<p>
							<input name="replycontent" type="text" class="input" style="width: 800px;" placeholder="可在此输入回复内容，回复后不可更改">
							<a id="reply" class="btn_vice ml10 crusor" data_id="${item.id }">回复</a>
						</p>
					</c:if>
				</div>
			</c:forEach>
		</div>
		<div class="text-center" id="page"></div>
	</div>
</div>

<script type="text/javascript">
	$(function(){
		setPage("${page.currentPage}","productconsultation/findAllProductConsultation.html","${page.totalPage}","consultationList",$("#form").serialize());
	
		$("p").on("click","a#reply",function(){
			var _this = $(this);
			var rcontent = _this.prev().val();
			if(rcontent.trim()!=""){
				layer.confirm("回复后无法删除，请确认内容是否无误?",{icon:3},function(index){
					var ppcid = _this.attr("data_id");
					layer.load(0, {
						shade : 0.3
					});
					$.post("productconsultation/saveProductConsultationReplay.json",{ppcid:ppcid,rcontent:rcontent},function(data){
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
		spage("${page.currentPage}","productconsultation/findAllProductConsultation.html","consultationList",$("#form").serialize());
	}
</script>

