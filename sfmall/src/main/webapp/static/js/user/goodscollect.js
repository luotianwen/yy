$(function(){
	$(".ico-del").on("click",function(){
		var sku = $(this).attr("data_id");
		$.post("/my/deleteFollowWare.json",{sku:sku},function(data){
			if (data.RESPONSE_STATE == '200') {
				layer.msg('删除成功', {
					icon : 1,
					time : 1 * 1000
				}, function() {
					window.location.href = window.location.href
				});
			} else {
				layer.alert(data.ERROR_INFO, {
					icon : 0
				});
			}
		})
	})
	
	$(".ico-cart").on("click",function(){
		
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
				window.location.href = "/my/goodsconllect.html?currentPage="+obj.curr;
			}
		}
	});
}