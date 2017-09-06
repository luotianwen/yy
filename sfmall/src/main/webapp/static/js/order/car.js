$(function() {
	//数量
	$(".lessBtn").on("click", function() {
		var _sku=$(this).attr("sku");
		$("#addBtn"+_sku).removeClass("limit");
		var num = $("#goodsNumberInput"+_sku).val();
		num--;
		$("#goodsNumberInput"+_sku).val(num);
		if(num <= 0) {
			num = 1;
			$("#lessBtn"+_sku).addClass("limit");
		} else {
			$("#lessBtn"+_sku).removeClass("limit");
		}
		$("#goodsNumberInput"+_sku).val(num);
		var _price=$(this).attr("price");
		calculation(_sku,num,_price);
	})

	$(".addBtn").on("click", function() {
		var _sku=$(this).attr("sku");
		var _price=$(this).attr("price");
		$("#lessBtn"+_sku).removeClass("limit");
		var num = $("#goodsNumberInput"+_sku).val();
		num++;
		$("#goodsNumberInput"+_sku).val(num);
		if(num >= 200) {
			num = 200;
			$("#addBtn"+_sku).addClass("limit");
		} else {
			$("#addBtn"+_sku).removeClass("limit");
		}
		$("#goodsNumberInput"+_sku).val(num);
		calculation(_sku,num,_price);
	})

	$("#deleteskus").click(
		function () {
			var skus=getCheckSkus().join(",");
			if(skus.length>0){
				layer.confirm('是否确定删除选中商品？', {
					btn: ['确定','取消'],//按钮
					title:['删除商品']
				},function () {
						$.post("/my/deleteskus",{skus:skus},function (data) {
							if(data.code==0){
								layer.alert("删除成功");
								window.location.reload();
							}
						})
				});
			}else{
				layer.alert("请选择商品");
			}
		}

	);
	$("#joinskus").click(
		function () {
			var skus=getCheckSkus();
			if(skus.length>0){
				$.post("/my/joinskus",{sku:skus},function (data) {
					if(data.code==0){
						layer.alert("添加成功");
					}
				})
			}else{
				layer.alert("请选择商品");
			}
		}
	);
	$("#all,#all2").click(function () {
		var checked=$(this).attr('checked');
		$("input#all").prop("checked",!!checked);
		$("input#all2").prop("checked",!!checked);
		$("input[name='skucheck']").prop("checked",!!checked);
		$("input[name='shopcheck']").prop("checked",!!checked);
		calculationNum();
	})
	$("input[name='skucheck']").click(calculationNum);
   $(".joincart").click(function () {
	   var sku=$(this).attr("sku");
	   $.post("/my/joinskus",{sku:sku},function (data) {
		   if(data.code==0){
			   layer.alert("移入成功", "", function () {
				   window.location.reload();
			   });
		   }
	   })
	   $.post("/my/deleteskus",{skus:sku},function (data) {
	   })
   });

	$("#st2_item_4").click(function () {
		var _count=0;
		var _skuss=[],_numss=[],_carts=[];
		$("input[name='skucheck']:checkbox:checked").each(function(){
			var _sku=$(this).val();
			_skuss.push(_sku);
			_count++;
			var _num=Number($("#goodsNumberInput"+_sku).val());
			_numss.push(_num);
			var _cart = $("#cartid"+_sku).val();
			_carts.push(_cart);
		})

		if(_count>0){
			$("#skus").val(_skuss);
			$("#nums").val(_numss);
			$("#carts").val(_carts);
			$("#cartform").attr("method", "post");
			$("#cartform").attr("action", "/my/cartorder");
			$("#cartform").submit();
		}
	});
	$(".deletecart").click(function () {
             var skus=$(this).attr("sku");
		layer.confirm('是否确定删除选中商品？', {
			btn: ['确定','取消'],//按钮
			title:['删除商品']
		},function () {
			$.post("/my/deleteskus", {skus: skus}, function (data) {
				if (data.code == 0) {
					layer.alert("删除成功", "", function () {
						window.location.reload();
					});

				}
			})
		} );
	});

})
function  getCheckSkus(){
	var _skus=[];
	$("input[name='skucheck']:checkbox:checked").each(function(){
		_skus.push($(this).val());
	});
	return _skus;
}
function calculationNum(){
    var num=0;
	var money=0.0;
	var _count=0;
	$("input[name='skucheck']:checkbox:checked").each(function(){
		var _sku=$(this).val();
		_count++;
		var _price=($(this).attr("price"));
		var _num=Number($("#goodsNumberInput"+_sku).val());
		num=num+(_num);
		money=money+(_num*_price);

	})
	if(num==0){
		$("#st2_item_4").removeClass("st2_item_4").addClass("st2_item_4_disable");
	}
	else{
		$("#st2_item_4").removeClass("st2_item_4_disable").addClass("st2_item_4");
	}
	$("#count").html(_count);
	$("#money").html("￥"+(money).toFixed(2));

}
function calculation(sku,num,price ){
	$("#price"+sku).html("￥"+(num*price).toFixed(2));
	calculationNum();
	$.post("/my/updatecart",{sku:sku,pcount:num},function (data) {
	})

}

function checkAllShop(_this,shopid) {
	var checked=$(_this).attr('checked');
	$("input[name='skucheck']").each(function(){
		var _shopid=$(this).attr('shopid');
		if(_shopid==shopid){
			$(this).prop("checked",!!checked);
		}
	})
	calculationNum();
}

