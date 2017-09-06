$(function(){
    var shopid=$("#shopid").val();
   $.post("/shop/product",{shopid:shopid},function (a) {
      $("#page").html(a);
   });

});