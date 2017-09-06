<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="form-info">
	<form class="form-horizontal" id="aftersales">
		<input type="hidden" name="id" value="${aftersalespolicy.id }"/>
		<div class="form-group">
			<label for="FirstLetter" class="col-sm-2 control-label">售后标题：</label>
			<div class="col-sm-10">
				<input type="text" class="form-control inline" id="title" maxlength="20" name="title" style="width: 50%;" value="${aftersalespolicy.title }">
				<span class="help-block inline">*请输入标题,长度为20字</span>
			</div>
		</div>
		<div class="form-group">
			<label for="Introduce" class="col-sm-2 control-label">售后内容：</label>
			<div class="col-sm-10">
				<textarea id="descript" name="descript">${aftersalespolicy.descript }</textarea>
				<span class="help-block">*请输入售后内容</span>
			</div>
		</div>
		<div class="form-group">
			<label for="InputFile" class="col-sm-2 control-label">启用状态：</label>
			<div class="col-sm-10">
				<label class="radio-inline">
					<input type="radio" name="state" id="state" value="1" <c:if test="${aftersalespolicy.state==1||aftersalespolicy.state==null }">checked</c:if>> 启用
				</label>
				<label class="radio-inline">
					<input type="radio" name="state" id="state" value="2" <c:if test="${aftersalespolicy.state==2 }">checked</c:if>> 未启用
				</label>
			</div>
		</div>
		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-10">
				<button type="button" class="btn btn-success btn-lg margin-right30" id="save">保存</button>
				<button type="button" class="btn btn-default btn-lg" id="return">返 回</button>
			</div>
		</div>
	</form>
</div>

<script type="text/javascript">
	var ue;
	$(function(){
		UE.delEditor('descript');
		ue = UE.getEditor('descript');
		
		$("#save").on("click",function(){
			if(check_in()){
				layer.load(0, {
					shade : 0.3
				});
				$.post("aftersalespolicy/afterSalesPolicyEdit.json",$("#aftersales").serialize(),function(data){
					layer.closeAll('loading');
					if (data.RESPONSE_STATE=='200') {
						layer.msg('保存成功', {
							icon : 1,
							time : 1 * 1000
						},function(){
							$("#myTab").find("li").eq(0).addClass("active");
							$("#myTab").find("li").eq(1).removeClass("active");
							
							$("#aftersalesEdit").removeClass("in").removeClass("active");
							$("#aftersalesList").addClass("in").addClass("active");
							
							aftersalesList();
						});
					} else {
						layer.alert(data.ERROR_INFO, {
							icon : 0
						});
					}
				})
			}
		})
		
		$("#return").on("click",function(){
			$("#myTab").find("li").eq(0).addClass("active");
			$("#myTab").find("li").eq(1).removeClass("active");
			
			$("#aftersalesEdit").removeClass("in").removeClass("active");
			$("#aftersalesList").addClass("in").addClass("active");
			
			aftersalesList();
		})
	})
	
	function check_in(){
		if ($('#title').val().trim() == '') {
			layer.tips('请填写售后标题！！！', '#title', {
				tips : [ 1, '#019F95' ],
				time : 1500
			});
			$('#title').focus();
			return false;
		}
		
		var html = ue.getContent();
		if (html == '') {
			layer.tips('请填写售后内容！！！', '#descript', {
				tips : [ 1, '#019F95' ],
				time : 1500
			});
			$('#descript').focus();
			return false;
		}
		
		return true;
	}
	
</script>
