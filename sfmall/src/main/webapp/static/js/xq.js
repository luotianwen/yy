$(function() {
	/*menu*/
   	$(".dd-inner").children(".item").hover(function() { //一级导航悬浮
   		$(this).addClass("hover").siblings(".item").removeClass("hover");
   		var index = $(this).index();
   		$(".dorpdown-layer").children(".item-sub").hide();
   		$(".dorpdown-layer").children(".item-sub").eq(index).show();

   	})
   	$(".dd-inner").hover(function() { 
   		$("#index_menus_sub").show();
   	}, function() {
   		$("#index_menus_sub").hide();
   		$('.item').removeClass("hover");
   	})
   	$("#index_menus_sub").children(".item-sub").hover(function() {
   		var index = $(this).index();
   		$(".dd-inner").children(".item").eq(index).addClass("hover");
   		$("#index_menus_sub").show();
   	}, function() {
   		$("#index_menus_sub").hide();
   		$(".dd-inner").children(".item").removeClass("hover");
   	})
   	
   	/*商品分类*/
 	$("#categorys-2014").mouseenter(function() {
		if($(this).children(".dd").is(":hidden"))
		{
			$(this).children(".dt").removeClass("shift_out").addClass("hover");
			if(!$(this).children(".dd").is(":animated")) {
				$(this).children(".dd").animate({ height: 'show' },200)
				$("#categorys-2014 .dd").mouseleave(function(){
					if($(this).is(":visible")){
						if(!$(this).is(":animated")) {
							$(this).animate({ height: 'hide' }, 200)
						}
					}
				})
			}
		}
	})
 	$("#categorys-2014").mouseleave(function(){
		if($(this).children(".dd").is(":visible")){
			$(this).children(".dt").addClass("shift_out").removeClass("hover");
			if(!$(this).children(".dd").is(":animated")) {
				$(this).children(".dd").animate({ height: 'hide' }, 200)
					.end().children().find(".dd").hide(200);
			}
		}
	})
	
})
