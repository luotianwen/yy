$(function(){
	//取消订单
	$("div.mc table").on("click","tr td a#cancel",function(){
		var _this = $(this);
		layer.confirm("确认取消订单?",{icon:3},function(index){
			layer.close(index);
			$.post("/my/cancelOrder.json",{order_id:_this.attr("data_id"),reason:1},function(data){
				if(data.code=="0"){
					layer.msg('取消成功', {
						icon : 1,
						time : 1 * 1000
					}, function() {
						location.reload() 
					});
				}else{
					layer.alert(data.msg,{icon:0,title:"失败提醒"});
				}
			})
		});
	})
	
	//申请退款
	$("div.mc table").on("click","tr td a#refund",function(){
		var _this = $(this);
		layer.confirm("确认申请退款?",{icon:3},function(index){
			layer.close(index);
			$.post("/my/orderRefund.json",{order_id:_this.attr("data_id"),reason:1},function(data){
				if(data.code=="0"){
					layer.msg('申请成功', {
						icon : 1,
						time : 1 * 1000
					}, function() {
						location.reload() 
					});
				}else{
					layer.alert(data.msg,{icon:0,title:"失败提醒"});
				}
			})
		});
	})
	
	//确认收货
	$("div.mc table").on("click","tr td a#confirm",function(){
		var _this = $(this);
		layer.confirm("确认收货?",{icon:3},function(index){
			layer.close(index);
			$.post("/my/orderConfirm.json",{order_id:_this.attr("data_id")},function(data){
				if(data.code=="0"){
					location.reload() 
				}else{
					layer.alert(data.msg,{icon:0,title:"失败提醒"});
				}
			})
		});
	})
	
	
})


function page(allpage,curr){
	laypage({
		cont: "page",
		pages: allpage,
		curr: curr,
		skip: true, //是否开启跳页
        groups: 5, //连续显示分页数
        skin: '#76cf8f',
        first: 1,
        prev:"<",
        next:">",
        last: allpage, //在尾页追加总页数。
		jump: function(obj, first){
			if(!first){
				var str = "";
				var li = $(".mt ul").find("li.current");
				if(li.length>0){
					if(li.attr("data_type")!=""){
						str = "&&state="+li.attr("data_type");
					}
				}
				window.location.href = "/my/order.html?currentPage="+obj.curr+str;
				
			}
		}
	});
}