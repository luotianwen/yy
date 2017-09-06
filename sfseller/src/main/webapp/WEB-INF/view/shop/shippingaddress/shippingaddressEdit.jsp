<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="form-info">
	<form class="form-horizontal" id="shippingaddress">
		<input type="hidden" name="id" value="${shippingaddress.id }" />
		
		<div class="form-group">
			<label class="col-sm-2 control-label">所在地区：</label>
			<div class="col-sm-10">
				<select class="form-control inline" style="width: 15%;" required id="province" name="province">
					<option value="">请选择省份</option>
					<c:forEach items="${province }" var="item">
						<option value="${item.id }" <c:if test="${item.id==shippingaddress.province }">selected</c:if>>${item.name }</option>
					</c:forEach>
				</select>
				<select class="form-control inline" style="width: 15%;" required id="city" name="city">
					<option value="">请选择城市</option>
				</select>
				<select class="form-control inline" style="width: 15%;" required id="region" name="region">
					<option value="">请选择区/县</option>
				</select>
			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-2 control-label">发货详细地址：</label>
			<div class="col-sm-10">
				<input type="text" class="form-control" id="address" required name="address" style="width: 50%;" value="${shippingaddress.address }">
			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-2 control-label">联系电话：</label>
			<div class="col-sm-10">
				<input type="number" class="form-control" id="phone" required name="phone" style="width: 30%;" value="${shippingaddress.phone }">
			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-2 control-label">邮编：</label>
			<div class="col-sm-10">
				<input type="number" class="form-control" id="zipcode" maxlength="6" required name="zipcode" style="width: 30%;" value="${shippingaddress.zipcode }">
			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-2 control-label">联系人：</label>
			<div class="col-sm-10">
				<input type="text" class="form-control" id="shipper" required name="shipper" style="width: 30%;" value="${shippingaddress.shipper }">
			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-2 control-label">设为默认：</label>
			<div class="col-sm-10">
				<input type="checkbox" id="isdefault" name="isdefault" value="1" <c:if test="${shippingaddress.isdefault==1 }">checked</c:if> style="margin-top:10px;">
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

<script type="text/javascript" src="/static/js/validate/jquery.validate.min.js"></script>
<script type="text/javascript" src="/static/js/validate/messages_zh.min.js"></script>	
<script type="text/javascript">
	var city = "${shippingaddress.city}";
	var region = "${shippingaddress.region}";
	$(function(){
		$.ajaxSetup({   
		    async : false
		});
		$("#province").on("change",function(){
			$.post("getAllCityByPid.json",{pid:$(this).val()},function(data){
				$("#city").html('<option value="">请选择城市</option>');
				$("#region").html('<option value="">请选择区/县</option>');
				for(var i=0,len=data.length;i<len;i++){
					if(data[i].id==city){
						$("#city").append('<option value="'+data[i].id+'" selected>'+data[i].name+'</option>');
					}else{
						$("#city").append('<option value="'+data[i].id+'">'+data[i].name+'</option>');
					}
				}
			})
		})
		
		$("#city").on("change",function(){
			$.post("getAllAreaByCid.json",{cid:$(this).val()},function(data){
				$("#region").html('<option value="">请选择区/县</option>');
				for(var i=0,len=data.length;i<len;i++){
					if(data[i].id==region){
						$("#region").append('<option value="'+data[i].id+'" selected>'+data[i].name+'</option>');
					}else{
						$("#region").append('<option value="'+data[i].id+'">'+data[i].name+'</option>');
					}
				}
			})
		})
		
		if("${shippingaddress.province}"!=""){
			$("#province").trigger("change");
			$("#city").trigger("change");
		}
		
		$("#save").on("click",function(){
			if($("#shippingaddress").valid()){
				layer.load(0, {
					shade : 0.3
				});
				
				var str = "?"+"provinceName="+$("#province option:selected").text()+"&&cityName="+$("#city option:selected").text()+"&&regionName="+$("#region option:selected").text();
				
				$.post("shippingaddress/shippingAddressEdit.json"+str,$("#shippingaddress").serialize(),function(data){
					layer.closeAll('loading');
					if (data.RESPONSE_STATE=='200') {
						layer.msg('保存成功', {
							icon : 1,
							time : 1 * 1000
						},function(){
							$("#myTab").find("li").eq(0).addClass("active");
							$("#myTab").find("li").eq(1).removeClass("active");
							
							$("#shippingaddressEdit").removeClass("in").removeClass("active");
							$("#shippingaddressList").addClass("in").addClass("active");
							
							shippingaddressList();
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
			
			$("#shippingaddressEdit").removeClass("in").removeClass("active");
			$("#shippingaddressList").addClass("in").addClass("active");
			
			shippingaddressList();
		})
		
		$("#shippingaddress").validate({
			onfocusout : false,
			onkeyup : false,
			onclick : false,
			rules : {
				phone : {
					isMobile:true
				}
			},
			messages : {
				phone : "请输入正确的手机号",
			},
			showErrors: function(errorMap, errorList) {   
        		var msg = "";
        		var a;
        		$.each(errorList,function(i,v){
         			msg = v.message+"\r\n";
         			a = v.element;
         			if(msg!=''){
        				layer.tips(msg, a, {
							tips : [ 1, '#019F95' ],
							time : 1500,
							tipsMore: true
						});
        			}
        			if(i==0){
        				$(a).focus();
        			}
        		});
    		},
    		onfocusout: false
		});
		
		// 手机号码验证
		jQuery.validator.addMethod("isMobile", function(value, element) {
			var length = value.length;
			var mobile = /^(13[0-9]{9})|(18[0-9]{9})|(14[0-9]{9})|(17[0-9]{9})|(15[0-9]{9})$/;
			return this.optional(element) || (length == 11 && mobile.test(value));
		});
	})
	
</script>
