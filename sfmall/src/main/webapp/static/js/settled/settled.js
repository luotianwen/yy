$(function(){
	$(".CheckList").on("click","li",function(){
		var num = $(this).index();
		if(num==0){
			window.location.href = "/settled/check.html";
		}else if(num==1){
			window.location.href = "/settled/progress.html";
		}else if(num==2){
			
		}else if(num==3){
			
		}
	})
	
	
})