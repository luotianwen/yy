$(function(){
	var flag = 0;
	$("#keyword").on("input",function(){
		var keyword = $("#keyword").val();
		if(keyword!=""){
			$.post("/product/suggest.json",{keyword:keyword},function(data){
				if(data!=null){
					var html = "";
					for(var i=0,len=data.length;i<len;i++){
						html += '<li>'+
								'	<a class="search-item" href="/product/searchWare.html?keyword='+data[i].key+'">'+
								'		<span>'+data[i].key+'</span>'+
								'		<span style="float: right;">约'+data[i].qre+'个商品</span>'+
								'	</a>'+
								'</li>';
					}
					if(html!=""){
						$("#shelper").css("display","block");
						$("#shelper").html(html);
					}
				}
			})
		}else{
			$("#shelper").css("display","none");
			$("#shelper").html("");
		}
	})
	
	$(document).click(function(e){
		$("#shelper").css("display","none");
		$("#shelper").html("");
	});
	$("#keyword").click(function(event){
	    event.stopPropagation();
	});
	$("#shelper").click(function(event){
	    event.stopPropagation();
	});
	
	$("#keyword").focus(function(){
		flag = 1;
	})
	$("#keyword").blur(function(){
		flag = 0;
	})
	
	$(document).keyup(function(event){
		if(event.keyCode ==13){
			if(flag==1){
				$(".global").trigger("click");
			}
		}
	});
	
	$(".global").on("click",function(){
		var keyword = $("#keyword");
		var str = "";
		if(keyword.val()!=""){
			str = "?keyword="+keyword.val();
		}else if(keyword.attr("placeholder")!=""){
			str = "?keyword="+keyword.attr("placeholder");
		}
		
		window.location.href = "/product/searchWare.html"+str;
	})
	
	$(".home_office").on("click",function(){
		var keyword = $("#keyword").val();
		var shopid = $(this).attr("data_id");
		var str = "";
		if(keyword!=""){
			str = "?keyword="+keyword+"&shopid="+shopid;
		}else{
			str = "?shopid="+shopid;
		}
		
		window.location.href = "/product/searchWare.html"+str;
	})
	
})