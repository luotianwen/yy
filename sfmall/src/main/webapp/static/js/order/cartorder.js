$(function(){


    loadcartorderproduct("");
    $(".address-more").click(function(){
        $(".address-list .item").show();
        $(".address-more").hide();
    });

    $(".btn-add").click(function () {
        $(".form-address").toggle();
    });
    $(".btn-area .btn-cancel").click(function () {
        $(".form-address").toggle();
    })
    loadaddress();
    $("#addressbtn").click(function () {
        if($("#addressform").valid()){
          $.post("/my/addaddress",$("#addressform").serialize(),function(data){
              if(data.code==0){
                  $("#city").val("");
                  $("#area").val("");
                  $("#address").val("");
                  $("#contacts").val("");
                  $("#phone").val("");
                  loadaddress();
                  $(".address-more").show();
                  
                  $(".form-address").toggle();
              }
              else{
                layer.alert("保存失败！");
              }
          });
        }
    })
    $("#province").on("change",function(){
          var _province=$(this).val();
        $.post("/getAllCityByPid",{pid:_province},function (data) {
            var _html='<option value="">请选择</option>';
            for(var i=0,len=data.length;i<len;i++){
                    _html += "<option value='"+data[i].id+"'>"+data[i].name+"</option>";
            }
            $("#city").html(_html);
        })
        $("#area").html('<option value="">请选择</option>');
    });
    $("#city").on("change",function(){
        var _cid=$(this).val();
        $.post("/getAllAreaByCid",{cid:_cid},function (data) {
            var _html='<option value="">请选择</option>';
            for(var i=0,len=data.length;i<len;i++){
                _html += "<option value='"+data[i].id+"'>"+data[i].name+"</option>";
            }
            $("#area").html(_html);
        })
    });
    $("#addressform").validate({
        onfocusout : false,
        onkeyup : false,
        onclick : false,
        showErrors: function(errorMap, errorList) {
            var msg = "";
            var a;
            $.each(errorList,function(i,v){
                msg = v.message+"\r\n";
                a = v.element;
                if(msg!=''){
                    layer.tips(msg, a, {
                        tips : [ 1, '#019F95' ],
                        time : 1500,
                        tipsMore: true
                    });
                }
                if(i==0){
                    $("html, body").animate({scrollTop: $('#'+a.id).offset().top});
                }
            });
        },
        onfocusout: false
    });
    
	$(".link-edit").click(function(){
		$("#invoice_type dd a[data_type='"+$("#type").attr("data_id")+"']").trigger("click");
		$(".pop-box").show();
	});
    
	$(".closessss").click(function(){
        $(".pop-box").hide();
        $("#invoice_type a[data_type='1']").trigger("click");
        $("#invoice_title a.options").eq(0).trigger("click");
        if($("#vatid").val().trim()==""){
        	$("#advform").find("input").val("");
        }
        
    });
    $(".btn-pay").click(function(){
        //地址
      var addressid=$(".current").attr("id");
      if(addressid==undefined){
    	  layer.alert("请选择收货地址",{icon:0,title:"失败提醒"});
    	  return;
      }
      
        //发票
       //var addressid=$(".item current").attr("id");
        //备注
        var a = [];
        $("input[name^='remark']").each(function(i, o){
            a[i] = $(o).val();
        });
        
        var invoiceId = $("#paymentsUnit").attr("data_id");
        
        $.post("/my/joinorder",{addressId:addressid,remark:a,invoiceId:invoiceId,notPutInvoice:1},function(data){
        	if(data.code==0){
        		window.location.href = "/my/goPay.html?orderId="+data.orderId+"&time="+data.time;
        	}else{
        		layer.alert(data.msg,{icon:0,title:"失败提醒"});
        	}
        })
        
    });
    
    //更改发票类型
    $("#invoice_type").on("click","a.options",function(){
    	$("#invoice_type").find("a").removeClass("selected");
    	$(this).addClass("selected");
    	
    	if($(this).attr("data_type")=="1"){
    		$(".pop-box .mc dt").css("width","80px");
    		$("#invoice_adv").css("display","none");
    		$("#invoice_title").css("display","block");
    	}else{
    		$(".pop-box .mc dt").css("width","110px");
    		$("#invoice_title").css("display","none");
    		$("#invoice_adv").css("display","block");
    	}
    })
    
    //更改发票抬头
    $("#invoice_title").on("click","a.options",function(){
    	$("#invoice_title").find("a").removeClass("selected");
    	$(this).addClass("selected");
    	
    	if($("#saveinvoice").length>0){
    		if($(this).find("#saveinvoice").length==0){
    			$("#saveinvoice").closest("dd").remove();
    			$("#addinvoice").parent().css("display","block");
    		}
    	}
    })
    
    //新增发票
    $("#addinvoice").on("click",function(){
    	var html = ' <dd class="invoice">'+
    				' 	<a class="options width">'+
    				'		<input type="text" class="border"/>'+
    				'		<span id="saveinvoice">保存</span>'+
    				'		<i></i>'+
    				'	</a>'+
    				'</dd>';
    	$(this).closest("dd").prev().append(html);
    	$(this).closest("dd").css("display","none");
    	
    	$("#allinvoice").find("input:last").trigger("click");
    	$("#allinvoice").find("input:last").focus();
    	
    	//保存
    	$("#allinvoice").find("span:last").on("click",function(){
        	var _this = $(this);
        	var input = _this.prev();
        	var paymentsUnit = input.val().trim();
        	if(paymentsUnit!=""){
        		$.post("/my/updateInvoice",{paymentsUnit:paymentsUnit,type:1},function(req){
            		if(req.code==0){
            			input.parent().attr("data_id",req.data);
            			input.attr("readonly","true")
            			input.removeClass("border");
            			input.next().remove();
            			input.after('<span id="updateinvoice">编辑</span><span id="deleteinvoice" style="margin-left: 10px;">删除</span>');
            			
            			$("#addinvoice").closest("dd").css("display","block");
            		}else{
            			layer.alert(req.msg,{icon:0,title:"失败提醒"});
            		}
            	})
        	}else{
        		layer.tips('请输入发票抬头！', input, {
					tips : [ 1, '#019F95' ],
					time : 1500
				});
        	}
        })
        
    })
    
    //确定
    $(".submiti").on("click",function(){
    	if($("#invoice_type dd a.selected").attr("data_type")=="1"){
    		if($("#saveinvoice").length==0){
        		var selected = $("#allinvoice a.selected");
            	var count = selected.length;
            	if(count>0){
            		var id = selected.attr("data_id");
            		var paymentsUnit = selected.find("input").val();
            		
            		$("#type").attr("data_id","1");
            		$("#type").html("普通发票（纸质）");
            		
            		$("#paymentsUnit").attr("data_id",id);
            		$("#paymentsUnit").html(paymentsUnit);
            		$(".closessss").trigger("click");
            	}
        	}else{
        		$("#saveinvoice").trigger("click");
        	}
    	}else{
    		$.post("/my/updateInvoice?type=2",$("#advform").serialize(),function(req){
    			$("#vatid").val(req.data);
        		$("#paymentsUnit").attr("data_id",req.data);
        		$("#paymentsUnit").html($("#vat_companyName").val());
        		$("#type").attr("data_id","2");
    			$("#type").html("增值税发票");
        		
        		$(".closessss").trigger("click");
    		})
    	}
    })
    
    //编辑
    $("div#allinvoice").on("click","dd.invoice #updateinvoice",function(){
    	var _this = $(this);
    	var input = _this.parent().find("input");
    	if(input.attr("readonly")){
    		_this.html("保存");
    		input.removeAttr("readonly");
    		input.addClass("border");
    	}else{
    		updateinvoice(_this,input);
    	}
    })
    
	//删除
    $("div#allinvoice").on("click","dd.invoice #deleteinvoice",function(){
    	var _this = $(this);
    	layer.confirm("是否确认删除?",{icon:3},function(index){
			layer.close(index);
			var id = _this.parent().attr("data_id");
			$.post("/my/deleteInvoice",{id:id},function(data){
				if(data.code==0){
					layer.msg("删除成功。",{icon:1,time:1*1000,shade:0.3},function(){
						_this.closest("dd").remove();
						$("#invoice_title a.options").eq(0).trigger("click");
					})
		        }else{
		        	layer.alert(data.msg,{icon:0,title:"失败提醒"});
		        }
			})
		});
    })
    
    $("div#allinvoice").on("blur","dd.invoice input",function(){
    	if($(this).parent().attr("data_id")!=undefined){
    		if($(this).attr("readonly")!="readonly"){
    			$(this).next().trigger("click");
    		}
    	}else{
    		$(this).removeClass("border");
    	}
    })
    
    $("div#allinvoice").on("click","dd.invoice input",function(){
    	if($(this).parent().attr("data_id")==undefined){
    		$(this).addClass("border");
    	}
    })
    
});

function updateinvoice(_this,input){
	_this.html("编辑");
	input.attr("readonly","true");
	input.removeClass("border");
	
	var paymentsUnit = input.val();
	var id = input.parent().attr("data_id");
	$.post("/my/updateInvoice",{id:id,paymentsUnit:paymentsUnit,type:1},function(data){
		if(data.code!=0){
            layer.alert(req.msg,{icon:0,title:"失败提醒"});
        }
	})
}

function loadaddress() {
    $.post("/my/addressList","",function (data) {
        $(".address-list").html(data);
    })
}

function loadcartorderproduct(addressid) {
    $.post("/my/cartorderproduct",{addressid:addressid,skucheck:$("#skucheck").val(),goodsNumberInput:$("#goodsNumberInput").val(),cart:$("#cart").val()},function (data) {
        $(".goods-list").html(data);
    })
}