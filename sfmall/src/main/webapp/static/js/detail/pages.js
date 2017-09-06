$(function() {
	var time = setTimeout(function() {
		/******放大镜效果实现*******/
		$("#preview").mouseenter(function() {
			$(".jqZoomPup").css("display", "block");
			$(".pre-right").css("display", "block");
		});
		$("#preview").mouseleave(function() {
			$(".jqZoomPup").css("display", "none");
			$(".pre-right").css("display", "none");
		});
		$("#preview").mousemove(function(e) {
				var x = e.pageX - $(this).offset().left - $("#jqZoomPup").width() / 2;
				var y = e.pageY - $(this).offset().top - $("#jqZoomPup").height() / 2;
				if(x < 0) {
					x = 0;
				}
				if(x > $("#preview").width() - $("#jqZoomPup").width()) {
					x = $("#preview").width() - $("#jqZoomPup").width();
				}
				if(y < 0) {
					y = 0;
				}
				if(y > $("#preview").height() - $("#jqZoomPup").height()) {
					y = $("#preview").height() - $("#jqZoomPup").height();
				}
				$("#jqZoomPup").css({
					left: x,
					top: y
				})
				$("#bigImg").css({
					left: -x * 2,
					top: -y * 2
				})
			})
		/*********鼠标滑过和点击切换图片并显示放大镜效果********/
		var count = $(".G_tab li").size();
		var showCount = parseInt(($(".items").width() - 50) / ($(".items li:first").width()));
		var interval = $(".items li:first").width() + 10;
		var curIndex = 0;
		if(count > showCount) {
			$(".buttons").click(function() {
				if($(this).hasClass("prev")) {
					--curIndex;
					if(curIndex < 0) {
						curIndex = 0;
					}
					$(".items ul").stop(false, true).animate({
						"marginLeft": -curIndex * interval + "px"
					})
				} else {
					++curIndex;
					if(curIndex = count - showCount - 1) {
						curIndex = count - showCount - 1;
					}
					$(".items ul").stop(false, true).animate({
						"marginLeft": -(count - showCount) * interval + "px"
					})
				}
			})
		}
		$(".items ul li img").click(function() {
			$(this).parents("li").addClass("active").siblings().removeClass("active");
			var bImg = $(this).attr("src");
			$("#preview img").attr("src", bImg);
			$(".lens a").attr("href", bImg);
			$("#bigImg").attr("src", bImg);
		})
	}, 500);

	$("#goodsNumberInput").on("change",function () {
        $(this).val($(this).val().replace(/[^0-9]*/g,""));
		show();
	});
	function show() {
		$("#errNum").hide();
		var goodsNumberInput=$("#goodsNumberInput").val();
		var num=$("#goodsNumberInput").attr("num");
		if(Number(goodsNumberInput)>Number(num)){
			$("#errMsg").html("限购"+num+"件");
			$("#errNum").show();
		}
	}
	//数量
	$("#lessBtn").on("click", function() {
		$("#addBtn").removeClass("limit");
		var num = $("#goodsNumberInput").val();
		num--;
		$("#goodsNumberInput").val(num);
		if(num <= 0) {
			num = 1;
			$("#lessBtn").addClass("limit");
		} else {
			$("#lessBtn").removeClass("limit");
		}
		$("#goodsNumberInput").val(num);
		show();

	})
	$("#addBtn").on("click", function() {
		$("#lessBtn").removeClass("limit");
		var num = $("#goodsNumberInput").val();
		num++;
		$("#goodsNumberInput").val(num);
		if(num >= 10000) {
			num = 10000;
			$("#addBtn").addClass("limit");
		} else {
			$("#addBtn").removeClass("limit");
		}
		$("#goodsNumberInput").val(num);
		show();
	})
	
	/**
	 *图片预加载
	 **/
	setTimeout(function() {
		$("img").lazyload({
			placeholder: "/static/img/grey.png",
			effect: "fadeIn",
			failurelimit: 10
		});

	}, 500);
	$(".main_function ul li").click(function() {
		$(this).addClass("active").siblings().removeClass("active");
		var _index=$(this).index();
		$(".cd_content ").children(".cd_item").eq(_index).addClass("b_show").siblings().removeClass("b_show");
	})

	//显示评分
	$(".s_grade .atar_Show p").each(function(index, element) {
		var num = $(this).attr("tip");
		var www = num * 18;
		$(this).css("width", www);
	});
})
	