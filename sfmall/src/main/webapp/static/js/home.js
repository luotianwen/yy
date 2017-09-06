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

	
	/*Louti*/
   	//事件差 ,采用延迟,强制让浏览器滚动到顶部
   	window.onload = function() {
   		setTimeout(function() {
   			$("body,html").scrollTop(0);
   		}, 100);
   	}

   	var $navs = $("#floornav li");
   	var $floors = $("#content .Louti .maxTitle");
   	var ifNeed = true;

   	$navs.not(".lastli").click(function() {

   		ifNeed = false;
   		var index = $(this).index();
   		var ot = $floors.eq(index).offset().top;
   		$("body,html").stop(true).animate({
   			scrollTop: ot
   		}, function() {
   			ifNeed = true;
   		});
   		$(this).addClass("select").siblings().removeClass("select");
   	});
   	$("#floornav .lastli").click(function() {
   		$("body,html").animate({
   			scrollTop: 0
   		}, function() {
   			ifNeed = true;
   		});
   	});
   	$(window).scroll(function() {
   		var st = $(window).scrollTop();
   		if(st < 630) {
   			$("#floornav").stop(true).fadeOut(100);
   		} else {
   			$("#floornav").stop(true).fadeIn(100);
   		}
   		if(ifNeed == true) {
   			for(var i = 0, len = $floors.size(); i < len; i++) {
   				var boundValue = $floors.eq(i).offset().top + $floors.eq(i).height();
   				if(st < boundValue) {
   					$navs.eq(i).addClass("select").siblings().removeClass("select");
   					break;
   				}
   			}
   		}
   	});
})