$(function () {
   $("#submit").click(function(){
       var name=    $("#name").val().trim();
       var link=    $("#link").val().trim();
       var contacts=$("#contacts").val().trim();
       var phone=   $("#phone").val().trim();
       var email=   $("#email").val().trim();
       var note=    $("#note").val().trim();
       var f=true;
       if(contacts==""){
           layer.tips('联系人必填', "#contacts", {
               tips : [ 1, '#019F95' ],
               time : 1500,
               tipsMore: true
           });
           f=false;
       }
       if(phone==""){
           layer.tips('联系电话必填', "#phone", {
               tips : [ 1, '#019F95' ],
               time : 1500,
               tipsMore: true
           });
           f=false;
       }
       if(name==""){
           layer.tips('网站名称必填', "#name", {
               tips : [ 1, '#019F95' ],
               time : 1500,
               tipsMore: true
           });
           f=false;
       }
       if(link==""){
           layer.tips('网址必填', "#link", {
               tips : [ 1, '#019F95' ],
               time : 1500,
               tipsMore: true
           });
           f=false;
       }
       if(f){
           $.post("/link/saveFriendshipLink",{name:name,link:link,contacts:contacts, phone:phone, email:email, note:note},function (data) {
                         if(data.RESPONSE_STATE==500){

                             layer.alert(data.ERROR_INFO, {
                                 icon : 0
                             });
                         }
                         else{

                             layer.alert("提交成功，近期会回复你", {
                                 icon : 0
                             });
                             $("#name").val("");
                             $("#link").val("");
                             $("#contacts").val("");
                             $("#phone").val("");
                             $("#email").val("");
                             $("#note").val("");


                         }
           });
       }
   });
});