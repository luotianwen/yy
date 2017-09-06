$(function(){
	$.fn.comment = function(){
		this.init();
	}
	
	$.fn.comment.prototype = {
		init : function(){
			this.bind();
		},
		bind : function(){
			this.commstar();
			this.anonymous_check();
			this.submit();
		},
		commstar : function(){
			$(".commstar").on("click","span",function(){
				var _this = $(this);
				_this.parent().find("span").removeClass("hover");
				_this.addClass("hover");
				_this.parent().parent().find("input").val(_this.attr("data_type"));
			})
		},
		anonymous_check : function(){
			$("#anonymous_check").on("click",function(){
				if($("#anonymous_check").attr("checked")=="checked"){
					$("#anonymous").val("1");
				}else{
					$("#anonymous").val("2");
				}
			})
		},
		submit : function(){
			var _this = this;
			$("#submit").on("click",function(){
				if(_this.check()){
					$.post("/my/saveComment",$("#form").serialize(),function(data){
						if (data.code == '0') {
							layer.msg('保存成功', {
								icon : 1,
								time : 1 * 1000
							}, function() {
								window.location.href = "/my/order.html";
							});
						} else {
							layer.alert(data.msg, {
								icon : 0
							});
						}
					})
				}
			})
		},
		check : function(){
			var bool = true;
			$(".score").each(function(){
				if($(this).val()==""&&bool){
					bool = false;
				}
			})
			
			if(!bool){
				layer.alert("请给商品评分！", {
					icon : 0
				});
				return bool;
			}
			
			if($("#describe_score").val()==""||$("#lservice").val()==""||$("#sservice").val()==""){
				layer.alert("请给店铺评分！", {
					icon : 0
				});
				return false;
			}
			
			$(".uploadimg").each(function(){
				if($(this).val()==""&&bool){
					bool = false;
				}
			})
			
			if(!bool){
				layer.alert("图片正在上传，请稍等！", {
					icon : 0
				});
				return bool;
			}
			
			$(".imgshow").each(function(){
				var count = $(this).attr("data_count");
				$(this).find("input.uploadimg").each(function(index){
					$(this).attr("name","wareComments["+count+"].imgs["+index+"].imgpath");
				})
			})
			
			return true;
		}
	}
	
	new $.fn.comment();
})


