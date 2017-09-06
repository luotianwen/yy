$(function(){
	var mobile = /^0?(13[0-9]|15[012356789]|17[013678]|18[0-9]|14[57])[0-9]{8}$/;
	var passwordReg = /^[A-Za-z0-9]{6,22}$/;
	
	$.fn.forget = function(){
		this.isVerify = true;
		this.resend;
		this.init();
	}
	
	$.fn.forget.prototype = {
		init : function(){
			this.bind();
		},
		bind : function(){
			this.updateimg();
			this.phone();
			this.imgyzm();
			this.next();
			this.last();
			this.sendSMS();
			this.end();
			this.password();
			this.again();
			this.submit();
		},
		updateimg : function(){
			$("#verify-img").on("click",function(){
				$("#imgyzm").val("");
				$("#imgyzm_error").removeClass("success");
				$("#imgyzm_error").html("请输入图片验证码");
				
				var d = new Date();
	            var time = d.getTime();
				$("#verify-img").attr("src","verifyCode/getVerifyCodeImage/forget?"+time);
			})
		},
		phone : function(){
			$("#phone").on("blur",function(){
				if(!mobile.test($("#phone").val())){
					$("#phone_error").html("<i></i>请输入正确的手机号");
					$("#phone_error").addClass("error");
					$("#phone").addClass("error_border");
					$("#phone_error").removeClass("success");
				}else{
					$("#phone_error").removeClass("error");
					$("#phone_error").addClass("success");
					$("#phone_error").html("<i></i>");
					$("#phone").removeClass("error_border");
				}
			})
		},
		imgyzm : function(){
			$("#imgyzm").on("blur",function(){
				if($("#imgyzm").val()==""){
					$("#imgyzm_error").html("<i></i>请输入图片验证码");
					$("#imgyzm_error").addClass("error");
					$("#imgyzm").addClass("error_border");
					$("#imgyzm_error").removeClass("success");
				}else{
					$.post("/forget/imgyzm",{imgyzm:$("#imgyzm").val()},function(data){
						if(data.RESPONSE_STATE=="200"){
							$("#imgyzm_error").removeClass("error");
							$("#imgyzm_error").addClass("success");
							$("#imgyzm_error").html("<i></i>");
							$("#imgyzm").removeClass("error_border");
						}else{
							$("#imgyzm_error").html("<i></i>图片验证码不正确");
							$("#imgyzm_error").addClass("error");
							$("#imgyzm").addClass("error_border");
							$("#imgyzm_error").removeClass("success");
						}
					})
				}
			})
		},
		next : function(){
			var _this = this;
			$("#next").on("click",function(){
				$("#phone").trigger("blur");
				$("#imgyzm").trigger("blur");
				if($("#phone_error").hasClass("error")||$("#imgyzm_error").hasClass("error")){
					return;
				}
				
				var $this = $("#sendSMS");
				var phone = $("#phone").val();
				$.post("/forget/postYzm",{phone:phone},function(data){
					if (data.RESPONSE_STATE == '200') {
						$(".step_1").css("display","none");
						$(".step_2").css("display","block");
						
						$("#_phone").html(phone.slice(0,-8)+"****"+phone.slice(-4));
						
						var count = 60;
						$this.addClass("noclick");
	               	  	$this.html("重新发送<i>（"+count+"）</i>");
						_this.resend = setInterval(function(){
							count--;
			            	_this.setInterval(count,$this);
			            }, 1000);
					} else {
						layer.alert(data.ERROR_INFO, {
							icon : 0
						});
					}
				})
			})
		},
		setInterval : function(count,$this){
			var _this = this;
      		if (count > 0){
      	  		$this.html("重新发送<i>（"+count+"）</i>");
        	}else {
            	clearInterval(_this.resend);
            	
            	// 绑定重新获取验证码事件
            	$this.removeClass("noclick");
		   	    $this.html("发送验证码");
            	
            	_this.isVerify = true;
        	}
		},
		last : function(){
			$("#last").on("click",function(){
				$("#yzm").val("");
				$("#verify-img").trigger("click");
				$(".step_1").css("display","block");
				$(".step_2").css("display","none");
			})
		},
		sendSMS : function(){
			var _this = this;
			$("#sendSMS").on("click",function(){
				if(_this.isVerify){
					var phone = $("#phone").val();
					
					if(mobile.test(phone)){
						var $this = $(this);
						_this.isVerify = false;
						
						$.post("/forget/postYzm.json",{phone:phone},function(data){
							if (data.RESPONSE_STATE == '200') {
								var count = 60;
								$this.addClass("noclick");
	   	               	  		$this.html("重新发送<i>（"+count+"）</i>");
								_this.resend = setInterval(function(){
									count--;
					            	_this.setInterval(count,$this);
					            }, 1000);
							} else {
								layer.alert(data.ERROR_INFO, {
									icon : 0
								});
							}
						})
					}else{
						layer.alert("手机号错误，请刷新再试！",{icon:0})
					}
				}
			})
		},
		end : function(){
			$("#end").on("click",function(){
				var yzm = $("#yzm").val();
				if(yzm==""){
					layer.alert("请输入验证码！", {
						icon : 0
					});
					return;
				}
				$.post("/forget/verifyYzm",{phone:$("#phone").val(),yzm:yzm},function(data){
					if(data.RESPONSE_STATE=="200"){
						$(".step_2").css("display","none");
						$(".step_3").css("display","block");
					}else{
						layer.alert(data.ERROR_INFO, {
							icon : 0
						});
					}
				})
			})
		},
		password : function(){
			$("#password").on("blur",function(){
				var password = $("#password").val();
				var again = $("#again").val();
				if(password==""){
					$("#password").addClass("error_border");
					$("#password_error").html("<i></i>请输入新密码");
					$("#password_error").addClass("error");
					$("#password_error").removeClass("success");
					return;
				}
				if(!passwordReg.test(password)){
					$("#password").addClass("error_border");
					$("#password_error").html("<i></i>请输入6-22位的密码(仅支持字母和数字)");
					$("#password_error").addClass("error");
					$("#password_error").removeClass("success");
					return;
				}
				
				if(again!=""&&password!=again){
					$("#password").addClass("error_border");
					$("#password_error").html("<i></i>两次密码不一致");
					$("#password_error").addClass("error");
					$("#password_error").removeClass("success");
					return;
				}
				
				if(again!=""){
					$("#again").removeClass("error_border");
					$("#again_error").removeClass("error");
					$("#again_error").html("<i></i>");
					$("#again_error").addClass("success");
				}
				$("#password").removeClass("error_border");
				$("#password_error").removeClass("error");
				$("#password_error").html("<i></i>");
				$("#password_error").addClass("success");
				
			})
		},
		again : function(){
			$("#again").on("blur",function(){
				var password = $("#password").val();
				var again = $("#again").val();
				if(password!=""&&again==""){
					$("#again").addClass("error_border");
					$("#again_error").html("<i></i>请再次输入新密码");
					$("#again_error").addClass("error");
					$("#again_error").removeClass("success");
					return;
				}
				
				if(password!=""&&password!=again){
					$("#again").addClass("error_border");
					$("#again_error").html("<i></i>两次密码不一致");
					$("#again_error").addClass("error");
					$("#again_error").removeClass("success");
					return;
				}
				
				if(password!=""){
					$("#password").removeClass("error_border");
					$("#password_error").removeClass("error");
					$("#password_error").html("<i></i>");
					$("#password_error").addClass("success");
				}
				
				$("#again").removeClass("error_border");
				$("#again_error").removeClass("error");
				$("#again_error").html("<i></i>");
				$("#again_error").addClass("success");
			})
		},
		submit : function(){
			$("#submit").on("click",function(){
				$("#password").trigger("blur");
				$("#again").trigger("blur");
				if($("#password_error").hasClass("error")||$("#again_error").hasClass("error")){
					return;
				}else{
					$.post("/forget/update",{phone:$("#phone").val(),password:$("#password").val()},function(data){
						if(data.code==0){
							layer.msg('修改成功', {
								icon : 1,
								time : 1 * 1000
							}, function() {
								$("#forget").css("display","none");
								$("#success").css("display","block");
							});
						}else{
							layer.alert(data.msg, {
								icon : 0
							});
						}
					})
				}
			})
		}
	}
	
	new $.fn.forget();
	
})