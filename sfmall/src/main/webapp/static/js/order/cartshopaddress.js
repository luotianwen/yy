$(function(){
    $(".address-list .item").click(function(){
        $(this).addClass("current").siblings().removeClass("current");
        var addressid=$(this).attr("id");
        loadcartorderproduct(addressid)
    });
})