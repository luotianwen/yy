$(function(){
	setInterval(promote, 1000);
	
	$("ul#paymethod").on("click","li",function(){
		$("ul#paymethod").find("li").removeClass("active");
		$(this).addClass("active");
	})
	
	$("#pay").on("click",function(){
		var type = $("#type").val();
		var method = $("ul#paymethod").find("li.active").attr("data_type");
		
		if(method=="1"){
			layer.open({
				type: 2,
				title:false,
				closeBtn: 0,
				shade : 0.2,
				shadeClose: true,
				area: ['220px', '220px'], //宽高
				content: "/my/pay.html?orderId="+$("#orderId").val()+"&method="+method+"&type="+type
			});
		}else{
			window.location.href = "/my/pay.html?orderId="+$("#orderId").val()+"&method="+method+"&type="+type;
		}
	})
})

function promote() {
	if(the_s>0){
		var g = Math.floor(the_s / 3600);
		var e = Math.floor((the_s - g * 3600) / 60);
		var f = (the_s - g * 3600) % 60;
		var html = "<b>" + g + "</b>时<b>" + e + "</b>分<b>" + f + "</b>秒";
		document.getElementById("down").innerHTML = html;
		the_s--;
	}
}
