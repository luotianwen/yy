$(function(){
	$(".options").on("click",function(){
		$(".options").removeClass("selected");
		$(this).addClass("selected");
		$("#applyType").val($(this).attr("data_type"));
	})
	
	$("#submit").on("click",function(){
		var bool = true;
		$(".uploadimg").each(function(index){
			if($(this).val()==""&&bool){
				bool = false;
			}
			$(this).attr("name","imgs["+index+"]");
		})
		
		if(!bool){
			layer.alert("图片正在上传，请稍等！", {
				icon : 0
			});
			return bool;
		}
		
		$.post("/my/saveRefund",$("#form").serialize(),function(data){
			if(data.code==0){
				layer.msg('申请成功', {
					icon : 1,
					time : 1 * 1000
				}, function() {
					window.location.href = "/my/order.html";
				});
			}else{
				layer.alert(data.msg, {
					icon : 0
				});
			}
		})
	})
	
})