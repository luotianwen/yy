$(function(){
	$.ajaxSetup({
		contentType : "application/x-www-form-urlencoded;charset=utf-8",
		complete : function(XMLHttpRequest, textStatus) {
			var sessionstatus = XMLHttpRequest.getResponseHeader("sessionstatus"); // 通过XMLHttpRequest取得响应头，sessionstatus，
			if (sessionstatus == "timeout") {
				// 如果超时就处理 ，指定要跳转的页面
				window.location.href="login/logout";
			}
		}
	});
	$("ul#menus").on("click","li.accordion ul li",function(){
		var _this= $(this);
		if(_this.find("ul").length==0){
			var url = _this.find("a").attr("data_url");
			if(url!=undefined){
				$.post(url,function(data){
						$("#content").html(data);
					}).error(function() { window.location.reload(); })
				}
		}
	})
	
})