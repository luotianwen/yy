$(function(){
	var mobile = /^0?(13[0-9]|15[012356789]|17[013678]|18[0-9]|14[57])[0-9]{8}$/;
	
	$.fn.register = function(){
		this.isVerify = true;
		this.resend;
		this.init();
	}
	
	$.fn.register.prototype = {
		init : function(){
			this.bind();
		},
		bind : function(){
			//修改验证码图片
			this.updateimg();
			//发送验证码
			this.sendSMS();
			//读取cookie
			this.checkCookie();
			//提交
			this.submit();
			//用户协议
			this.open();
			this.close();
		},
		updateimg : function(){
			$("#verify-img").on("click",function(){
				var d = new Date();
	            var time = d.getTime();
				$("#verify-img").attr("src","verifyCode/getVerifyCodeImage/register?"+time);
			})
		},
		sendSMS : function(){
			var _this = this;
			$("#sendSMS").on("click",function(){
				if(_this.isVerify){
					var phone = $("#phone").val();
					
					if($("#imgyzm").val()==""){
						_this.updateError("imgyzm","请输入图片验证码");
						return;
					}else{
						$("#imgyzm").removeClass("error_border");
					}
					
					if(mobile.test(phone)){
						$("#phone").removeClass("error_border");
						$("#error").css("display","none");
						var $this = $(this);
						_this.isVerify = false;
						
						$.post("/register/postYzm.json",{phone:phone,imgyzm:$("#imgyzm").val()},function(data){
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
						$("#phone").addClass("error_border");
						$("#error").css("display","block");
						$("#error_info").html("请输入正确的手机号");
					}
				}
			})
		},
		checkCookie : function(){
			var _this = this;
			if($.cookie("registerCaptcha")){
				_this.isVerify = false;
	            var count = $.cookie("registerCaptcha");
	            
	            var $this = $("#sendSMS");
	            $this.addClass("noclick");
		   	    $this.html("重新发送<i>（"+count+"）</i>");
	            _this.resend = setInterval(function(){
	            	count--;
	            	_this.setInterval(count,$this);
	            }, 1000);
	     	}
		},
		setInterval : function(count,$this){
			var _this = this;
      		if (count > 0){
      	  		$this.html("重新发送<i>（"+count+"）</i>");
           	 	$.cookie("registerCaptcha", count, {path: "/", expires: (1/86400)*count});
        	}else {
            	clearInterval(_this.resend);
            	
            	// 绑定重新获取验证码事件
            	$this.removeClass("noclick");
		   	    $this.html("发送验证码");
            	
            	_this.isVerify = true;
        	}
		},
		updateError : function(id,info){
			$("#"+id).addClass("error_border");
			$("#error").css("display","block");
			$("#error_info").html(info);
		},
		check : function(){
			var _this = this;
			var phone = $("#phone").val();
			if(!mobile.test(phone)){
				_this.updateError("phone","请输入正确的手机号");
				return false;
			}else{
				$("#phone").removeClass("error_border");
			}
			
			var passwordReg = /^[A-Za-z0-9]{6,22}$/;
			var pass = $("#password").val();
			var again = $("#again").val();
			if(pass==""){
				_this.updateError("password","请输入登录密码");
				return false;
			}
			
			if(!passwordReg.test(pass)){
				_this.updateError("password","请输入6-22位的密码(仅支持字母和数字)");
				return false;
			}else{
				$("#password").removeClass("error_border");
			}
			
			if(again==""){
				_this.updateError("again","请再次输入登录密码");
				return false;
			}
			
			if(!passwordReg.test(pass)){
				_this.updateError("again","请输入6-22位的密码(仅支持字母和数字)");
				return false;
			}
			
			if(pass!=again){
				_this.updateError("again","两次密码不一致");
				return false;
			}else{
				$("#again").removeClass("error_border");
			}
			
			if($("#yzm").val()==""){
				_this.updateError("yzm","请输入验证码");
				return false;
			}else{
				$("#yzm").removeClass("error_border");
			}
			
			$("#error").css("display","none");
			return true;
		},
		submit : function(){
			var _this = this;
			$("#submit").on("click",function(){
				if(_this.check()){
					$.post("/register/save.json",$("#register").serialize(),function(data){
						if (data.RESPONSE_STATE == '200') {
							layer.msg('注册成功', {
								icon : 1,
								time : 1 * 1000
							}, function() {
								window.location.href = "/login";
							});
						} else {
							layer.alert(data.ERROR_INFO, {
								icon : 0
							});
						}
					})
				}
			})
		},
		open : function(){
			$("#open").on("click",function(){
				$("#shade").css("display","block");
				$("#protocol").css("display","block");
				
			})
		},
		close : function(){
			$(".close").on("click",function(){
				$("#shade").css("display","none");
				$("#protocol").css("display","none");
				
			})
		}
	}
	
	new $.fn.register();
})