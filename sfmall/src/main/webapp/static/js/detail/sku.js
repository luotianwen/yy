var cid="";
var sku="";
var pcid="";
var pid="";
$(function(){
//大家都在买
    var ebUrl="/product/everybodybuy";
    var everybodybuy=$("#everybodybuy");
      cid=everybodybuy.attr("cid");
      sku=everybodybuy.attr("sku");
      pcid=everybodybuy.attr("pcid");
      pid=everybodybuy.attr("pid");
    $(".s_code").qrcode({
        render: "table", //table方式
        width: 100, //宽度
        height:100, //高度
        text: "http://m.seebong.com/#/goods/"+sku //任意内容
    });
    $.post(ebUrl,{cid:cid,pcid:pcid, pid:pid},function(data){
        if(data.length>0){
            var _html="";
            for(var p in data){
                _html+='<li>';
                _html+= '<a href="/detail/'+data[p].sku+'.html"><img src="'+data[p].logo+'"/><span>￥'+data[p].price+'</span></a>';
                _html+='</li>';
            }
            $("#everybodybuy").html(_html);
            $(".shop_recommend").css("display","block");
        }
    });

    //guessyoulike
    var gylUrl="/product/guessyoulike";
    var guessyoulike=$("#guessyoulike");
    $.post(gylUrl,{cid:cid,pcid:pcid, pid:pid},function(data){
        if(data.length>0){
            var _html="";
            for(var p in data){
                a=data[p];
                _html+='<li  ><a href="/detail/'+a.sku+'"><img src="'+a.logo+'"/><p>'+a.pName+'</p><span>￥'+a.price+'</span></a></li>';
            }
            $("#guessyoulike").html(_html);
            $(".related").css("display","block");
        }
    });
    
	//用户是否关注收藏该商品
	if(userId!=""){
		$.post("/my/isFollowWare",{sku:sku},function(data){
			if(data.code==0){
				if(data.data){
					$(".enshrine").addClass("active");
				}
	        }
		});
	}
	
	//用户是否收藏该店铺
	var shopid = $("#bookmark").attr("shopid");
	$.post("/my/isFollowVender",{shopid:shopid},function(data){
		if(data.code==0){
			if(data.data){
				$("#bookmark").attr("data_type","yes");
				$("#bookmark").html("已收藏");
			}
        }
	});
    
	//关注收藏
    $(".enshrine").click(function () {
    	var _this = $(this);
        if(!_this.hasClass("active")){
        	$.post("/my/joinsku",{sku:sku},function(data){
                if(data.code==0){
                	_this.addClass("active");
                    layer.msg('关注成功', {
    					icon : 1,
    					time : 1 * 1000
    				});
                }
                else{
                	layer.alert("关注失败", {
    					icon : 0                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                           
    				});
                }
            })
        }else{
        	$.post("/my/deleteFollowWare",{sku:sku},function(data){
                if(data.code==0){
                	_this.removeClass("active");
                    layer.msg('取消关注成功', {
    					icon : 1,
    					time : 1 * 1000
    				});
                }
                else{
                	layer.alert("取消关注失败", {
    					icon : 0
    				});
                }
            })
        }
    });
    
    //收藏店铺
    $("#bookmark").click(function () {
    	var _this = $(this);
        if(_this.attr("data_type")=="no"){
        	$.post("/my/joinbookmark",{shopid:shopid},function(data){
                if(data.code==0){
                	layer.msg('关注成功', {
    					icon : 1,
    					time : 1 * 1000
    				},function(){
    					_this.attr("data_type","yes");
    					_this.html("已收藏");
    				});
                }
                else{
                	layer.alert("关注失败", {
    					icon : 0
    				});
                }
            })
        }else{
        	$.post("/my/deleteFollowVender",{shopid:shopid},function(data){
                if(data.code==0){
                	layer.msg('取消关注成功', {
    					icon : 1,
    					time : 1 * 1000
    				},function(){
    					_this.attr("data_type","no");
    					_this.html("收藏店铺");
    				});
                }
                else{
                	layer.alert("取消关注失败", {
    					icon : 0
    				});
                }
            })
        }
    });



    //品牌故事
    /*var bs_content=$("#bs_content");
    var brandid=bs_content.attr("brandid");
    var bandUrl="/product/getBrandInfoById";

    $.post(bandUrl,{brandid:brandid},function(a){
        var _html='<div class="bs_content"> <span class="logo"><img src="'+a.logo+'"/></span><div class="logo_msg">'+a.descript+'</div></div>';
        $("#bs_content").html(_html);
    });*/


    $.post(commentUrl,{pid:pid,pageSize:1},function(a){
        $(".tab_con").html(a);
    });
   $(".join_car").click(function () {
       var _num=$("#goodsNumberInput").val();
       if(_num>0){
         window.location.href="/my/joincart?sku="+sku+"&pcount="+_num;
       }
   });
   
   $(".buy_now").on("click",function(){
	   var _num=$("#goodsNumberInput").val();
       if(_num>0){
    	   $("#skucheck").val(sku);
    	   $("#buy_num").val(_num);
    	   $("#buy_form").attr("method", "post");
    	   $("#buy_form").attr("action", "/my/cartorder");
    	   $("#buy_form").submit();
       }
   })
    $(".end").on("click",function(){
        $(".s_menu").addClass("pitch");
    })
    
    $(window).scroll(function(){
		//滚动条高度
		var winPos = $(window).scrollTop();
		var top = $(".commodity_data").offset().top+40;
		if(winPos>=top){
			$(".cd_nav").addClass("fixed-bar");
		}else{
			$(".cd_nav").removeClass("fixed-bar");
		}
    });
    
});
var commentUrl="/product/getComment";

function commentPage(page) {
    $.post(commentUrl,{pid:pid,currentPage:page},function(a){
        $(".tab_con").html(a);
    });
}
function check(sku){
    window.location.href="/detail/"+sku+".html";
}
function checkProvince(cityId,name) {
    $(".end i").html(name);
    $(".s_menu").removeClass("pitch");
    var pcount= $("#goodsNumberInput").val();
    $.post("/detailWareFreights",{sku:sku,cityId:cityId,pcount:pcount},function(a){
        if(a==0){
            $(".freight_con").html("免运费");
        }
        else{
            $(".freight_con").html(a);
        }
    });

}