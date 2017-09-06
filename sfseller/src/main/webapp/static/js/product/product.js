$(function(){
	//初始化PC详情
	UE.delEditor('description');
	var ue = UE.getEditor('description');

	//初始化手机详情
	UE.delEditor('phone_describe');
	var pue = UE.getEditor('phone_describe');
	
	//重选类目
	$("#again_choose").on("click",function(){
		$("#choosecategory").css("display","none");
	})
	
	//跳转申请品牌页面
	$("#goBrand").on("click",function(){
		$.post("shopbrand/goShopBrand.html",function(data){
			$("#content").html(data);
		})
	})
	
	//点击添加按钮
	$(".add_btn").on("click",function(){
		$(this).next().css("display","");
	})
	
	//取消添加
	$(".add").on("click","#cancel",function(){
		var add_msg = $(this).closest(".add_msg");
		add_msg.find("input").val("");
		add_msg.css("display","none");
	})
	
	//确认添加
	$(".add").on("click","#save",function(){
		var url = "";
		var type = "";
		var _this = $(this);
		var name = _this.closest(".add_msg").find("input").val();
		var cid = $("#cid").val();
		
		if(name.trim()==""){
			layer.alert("请输入内容！", {
				icon : 0
			});
			return;
		}
		if(_this.attr("data_type")=="1"){
			type = "color";
			url = "shopcategorycolor/saveShopCategoryColor.json";
		}else{
			type = "spec";
			url = "shopcategoryspec/saveShopCategorySpec.json";
		}
		
		layer.load(0, {
			shade : 0.3
		});
		$.post(url,{cid:cid,name:name},function(data){
			layer.closeAll('loading');
			if (data.RESPONSE_STATE == '200') {
				layer.msg('新增成功', {
					icon : 1,
					time : 1 * 1000
				},function(){
					var html = '<label class="checkbox-inline">'+
								'	<input type="checkbox" id="'+type+'" value="'+data.id+'"><span>'+data.name+'</span>'+
								'</label>';
					_this.closest(".add").before(html)
					
					_this.next().trigger("click");
				});
			} else {
				layer.alert(data.ERROR_INFO, {
					icon : 0
				});
			}
		})
		
	})
	
	//点击颜色
	$("div#allcolor").on("click","input#color",function(){
		colors = new Array();
		$("label").find("input#color:checkbox:checked").each(function(index){
			colors[index] = $(this);
		})
		
		if($(this).get(0).checked){
			var name = $(this).next().html();
			
			$(this).next().remove();
			$(this).after("<input id='c_value' class='form-control inline ' style='width: 70px' value='"+name+"'/>");
			
			add_color_property($(this));
			add_upload_color($(this));
		}else{
			var name = $(this).next().val();
			$(this).next().remove();
			$(this).after("<span>"+name+"</span>");
			
			delete_color_property($(this));
			delete_upload_color($(this));
		}
	})
	
	//点击规格
	$("div#allspec").on("click","input#spec",function(){
		specs = new Array();
		$("label").find("input#spec:checkbox:checked").each(function(index){
			specs[index] = $(this);
		})
		
		if($(this).get(0).checked){
			var name = $(this).next().html();
			$(this).next().remove();
			$(this).after("<input id='s_value' class='form-control inline' style='width: 60px' value='"+name+"'/>");
			
			add_spec_property($(this));
		}else{
			var name = $(this).next().val();
			$(this).next().remove();
			$(this).after("<span>"+name+"</span>");
			
			delete_spec_property($(this));
		}
	})
	
	//修改颜色
	$("div#allcolor").on("change","input#c_value",function(){
		var id = $(this).prev().val();
		var name = $(this).val();
		var _color = $("#property").find("tr[data_color='"+id+"']").find("td input#color");
		_color.parent().find("span").html(name);
		_color.val(name);
	})
	
	//修改规格
	$("div#allspec").on("change","input#s_value",function(){
		var id = $(this).prev().val();
		var name = $(this).val();
		var _spec = $("#property").find("tr[data_spec='"+id+"']").find("td input#spec");
		_spec.parent().find("span").html(name);
		_spec.val(name);
	})
	
	//form表单验证
	$("#info").validate({
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
     				if(a.id!=""){
     					if(a.id=="colorid"){
         					layer.tips(msg, $(a).parent().find("strong"), {
								tips : [ 1, '#019F95' ],
								time : 1500,
								tipsMore: true
							});
     					}else{
     						layer.tips(msg, a, {
								tips : [ 1, '#019F95' ],
								time : 1500,
								tipsMore: true
							});
     					}
     				}else{
     					layer.tips(msg, $("#"+a.name), {
							tips : [ 1, '#019F95' ],
							time : 1500,
							tipsMore: true
						});
     				}
    			}
    			if(i==0){
    				if(a.id!=""){
    					if(a.id=="colorid"){
        					$("html, body").animate({scrollTop: $(a).parent().find("strong").offset().top});
         				}else{
         					$("html, body").animate({scrollTop: $('#'+a.id).offset().top});
         				}
    				}else{
    					$("html, body").animate({scrollTop: $('#'+a.name).offset().top});
    				}
    			}
    		});
		},
		onfocusout: false
	});
	
	// 商品图片上传验证
	jQuery.validator.addMethod("isPImg", function() {
		var bool = true;
		$("#productimg").find("input[data_type='image']").each(function(index){
			if ($(this).val().trim() == ''){
				bool = false;
			}
		})
		return bool;
	},"商品图片没上传");
	
	// 商品图片数量验证
	jQuery.validator.addMethod("isPImgcount", function() {
		return $("#productimg").find("input[data_type='image']").length==5;
	},"商品图片数量不足5张");
	
	// 产品图片上传验证
	jQuery.validator.addMethod("isSImg", function(value, element) {
		var bool = true;
		$(element).parent().find("#skuimg").find("input[data_type='image']").each(function(count){
			if ($(this).val().trim() == ''){
				bool = false;
			}
		})
		
		return bool;
	},"产品图片没上传");
	
	// 产品图片数量验证
	jQuery.validator.addMethod("isSImgcount", function(value, element) {
		return $(element).parent().find("#skuimg").find("input[data_type='image']").length==5;
	},"产品图片数量不足5张");
	
	//更换PC/手机详情
	$("#tabTitle").on("click","li span",function(){
		if($(this).attr("data_type")=="pc"){
			if(!$(this).hasClass("tabspan_active")){
				$(this).removeClass("tabspan");
				$(this).addClass("tabspan_active");
				$("li span[data_type='phone']").removeClass("tabspan_active");
				$("li span[data_type='phone']").addClass("tabspan");
				$("#description").parent().css("display","block");
				$("#phone_describe").parent().css("display","none");
			}
		}else{
			if(!$(this).hasClass("tabspan_active")){
				$(this).removeClass("tabspan");
				$(this).addClass("tabspan_active");
				$("li span[data_type='pc']").removeClass("tabspan_active");
				$("li span[data_type='pc']").addClass("tabspan");
				$("#description").parent().css("display","none");
				$("#phone_describe").parent().css("display","block");
			}
		}
	})
	
})

var add_html = '	<td class="center">'+
				'		<input id="price" required min="0" class="form-control" placeholder="" type="number">'+
				'	</td>'+
				'	<td class="center">'+
				'		<input id="marketprice" required min="0" class="form-control" placeholder="" type="number">'+
				'	</td>'+
				'	<td class="center">'+
				'		<input id="stocks" required min="0" class="form-control" placeholder="" type="number">'+
				'	</td>'+
				'	<td class="center">'+
				'		<input id="weight" required min="0" class="form-control" placeholder="" type="number">'+
				'	</td>'+
				'	<td class="center">'+
				'		<input id="number" required maxlength="30" class="form-control" placeholder="" type="text">'+
				'	</td>';

var colors = new Array();
var specs = new Array();

$("label").find("input#color:checkbox:checked").each(function(index){
	colors[index] = $(this);
})
$("label").find("input#spec:checkbox:checked").each(function(index){
	specs[index] = $(this);
})

//选择颜色
function add_color_property(_this){
	var html = "";
	var id = _this.val();
	var name = _this.next().val();
	var _spec = $("label").find("input#spec");
	var num = $("label").find("input#color").index(_this);
	
	if(specs.length==0){
		html += '<tr data_color="'+id+'" color_num="'+num+'">';
		html += '<td class="center">'+
				'	<span>'+name+'</span>'+
				'	<input id="categorycolorid" value="'+id+'" type="hidden">'+
				'	<input id="color" value="'+name+'" type="hidden">'+
				'</td>';
		html += add_html+'</tr>';
	}else{
		for(var i=0,len=specs.length;i<len;i++){
			var spec = specs[i];
			html += '<tr data_color="'+id+'" color_num="'+num+'" spec_num="'+_spec.index(spec)+'" data_spec="'+spec.val()+'">';
			
			if(i>0){
				html += '<td class="center" rowspan="'+len+'" style="display:none;">'+
						'	<span>'+name+'</span>'+
						'	<input id="categorycolorid" value="'+id+'" type="hidden">'+
						'	<input id="color" value="'+name+'" type="hidden">'+
						'</td>'+
						'<td class="center">'+
						'	<span>'+spec.next().val()+'</span>'+
						'	<input id="categoryspecid" value="'+spec.val()+'" type="hidden">'+
						'	<input id="spec" value="'+spec.next().val()+'" type="hidden">'+
						'</td>';
			}else{
				html += '<td class="center" rowspan="'+len+'">'+
						'	<span>'+name+'</span>'+
						'	<input id="categorycolorid" value="'+id+'" type="hidden">'+
						'	<input id="color" value="'+name+'" type="hidden">'+
						'</td>'+
						'<td class="center">'+
						'	<span>'+spec.next().val()+'</span>'+
						'	<input id="categoryspecid" value="'+spec.val()+'" type="hidden">'+
						'	<input id="spec" value="'+spec.next().val()+'" type="hidden">'+
						'</td>';
			}
			html += add_html+'</tr>';
		}
	}
	
	if($("#property").find("tr").length>0){
		if(colors.length>1){
			var bool = true;
			$("#property").find("tr").each(function(){
				if(bool){
					if($(this).attr("color_num")>num){
						$(this).before(html);
						bool = false;
					}
				}
			})
			if(bool){
				$("#property").append(html);
			}
		}else{
			if($("#p_title").find("tr").find("th[data_type='color']").length==0){
				$("#p_title").find("tr").find("th").eq(0).before("<th data_type='color'>颜色</th>");
			}
			$("#property").html(html);
		}
	}else{
		$("#property").html(html);
	}
}

//添加该颜色的商品图片
function add_upload_color(_this){
	var num = $("label").find("input#color").index(_this);
	var html = '<div class="form-group upload_color_img" data_num="'+num+'" data_id="'+_this.val()+'">'+
				'	<input class="isSImgcount isSImg" type="hidden" id="colorid" value="'+_this.val()+'"/>'+
				'	<div class="col-sm-offset-1 col-sm-1 text-center margin-top30">'+
				'		<strong>'+_this.next().val()+'</strong><br>'+
				'		<span class="fred">（至少5张）</span>'+
				'	</div>'+
				'	<div class="col-sm-10" id="skuimg">'+
				'		<div style="display: inline-block;" id="upload_color_'+_this.val()+'"><img style="height: 98px;" src="static/img/s-img/bg-img-01.jpg" alt="主图" class="img-thumbnail margin-right10" id="upload_color_'+_this.val()+'_img"></div>'+
				'		<button style="display:none;" type="button" class="btn btn-success btn-sm">上传图片</button>'+
				'	</div>'+
				'</div>';
	
	if($("div.upload_color_img").length==0){
		$("h4.upload_color_img").css("display","");
		$("h4.upload_color_img").after(html);
	}else{
		$("div.upload_color_img").each(function(index){
			if(num<$(this).attr("data_num")){
				$(this).before(html);
				return false;
			}
			if(index+1 == $("div.upload_color_img").length){
				$(this).after(html);
			}
		})
	}
	
	var uploadcolor = upload("upload_color_"+_this.val()+"_img","upload_color_"+_this.val());
	uploadcolor.init();
}

//删除选中的颜色
function delete_color_property(_this){
	var _color = $("#property").find("tr[data_color='"+_this.val()+"']");
	if(colors.length==0){
		$("#p_title").find("tr").find("th[data_type='color']").remove();
		
		if(specs.length==0){
			var html = '<tr>' + add_html+'</tr>';
			$("#property").html(html);
		}else{
			for(var i=0,len=specs.length;i<len;i++){
				add_spec_property(specs[i]);
			}
		}
	}
	_color.remove();
}

//删除该颜色图片上传
function delete_upload_color(_this){
	$(".upload_color_img[data_id='"+_this.val()+"']").remove();
	if($(".upload_color_img").length==1){
		$(".upload_color_img").css("display","none");
	}
}

//选择规格
function add_spec_property(_this){
	var html = "";
	var id = _this.val();
	var name = _this.next().val();
	var num = $("label").find("input#spec").index(_this);
	
	if(colors.length>0){
		var data_color = "";
		var bool = true;
		if(specs.length>1){
			var tr_count = 0;
			var c_index = 0;
			$("#property").find("tr").each(function(index){
				var _this = $(this);
				var spec_num = _this.attr("spec_num");
				
				if(data_color==""){
					data_color = _this.attr("data_color");
				}
				
				if(!bool){
					if(data_color!=_this.attr("data_color")){
						data_color = _this.attr("data_color");
						tr_count = 0;
						c_index++;
						bool = true;
					}
				}
				
				if(bool){
					if(num<spec_num){
						html = '<tr data_color="'+data_color+'" color_num="'+_this.attr("color_num")+'" spec_num="'+num+'" data_spec="'+id+'">';
						html += '<td class="center">'+
								'	<span>'+colors[c_index].next().val()+'</span>'+
								'	<input id="categorycolorid" value="'+data_color+'" type="hidden">'+
								'	<input id="color" value="'+colors[c_index].next().val()+'" type="hidden">'+
								'</td>'+
								'<td class="center">'+
								'	<span>'+name+'</span>'+
								'	<input id="categoryspecid" value="'+id+'" type="hidden">'+
								'	<input id="spec" value="'+name+'" type="hidden">'+
								'</td>';
						html += add_html+'</tr>';
						_this.before(html);
						bool = false;
					}else{
						tr_count++;
						if(tr_count == $("#property").find("tr[data_color='"+_this.attr("data_color")+"']").length){
							html = '<tr data_color="'+data_color+'" color_num="'+_this.attr("color_num")+'" spec_num="'+num+'" data_spec="'+id+'">';
							html += '	<td class="center">'+
									'	<span>'+colors[c_index].next().val()+'</span>'+
									'	<input id="categorycolorid" value="'+data_color+'" type="hidden">'+
									'	<input id="color" value="'+colors[c_index].next().val()+'" type="hidden">'+
									'</td>'+
									'<td class="center">'+
									'	<span>'+name+'</span>'+
									'	<input id="categoryspecid" value="'+id+'" type="hidden">'+
									'	<input id="spec" value="'+name+'" type="hidden">'+
									'</td>';
							html += add_html+'</tr>';
							_this.after(html);
							bool = false;
						}
					}
					
					if(!bool){
						var count = specs.length;
						$("#property").find("tr[data_color='"+_this.attr("data_color")+"']").each(function(index){
							var td = $(this).find("td").eq(0);
							td.attr("rowspan",count);
							if(index>0){
								td.css("display","none");
							}
						})
					}
				}
			})
		}else{
			var _color = $("label").find("input#color");
			for(var i=0,len=colors.length;i<len;i++){
				var color = colors[i];
				html += '<tr data_color="'+color.val()+'" color_num="'+_color.index(color)+'" spec_num="'+num+'" data_spec="'+id+'">'+
						'	<td class="center" rowspan="'+specs.length+'">'+
						'		<span>'+color.next().val()+'</span>'+
						'		<input id="categorycolorid" value="'+color.val()+'" type="hidden">'+
						'		<input id="color" value="'+color.next().val()+'" type="hidden">'+
						'	</td>'+
						'	<td class="center">'+
						'		<span>'+name+'</span>'+
						'		<input id="categoryspecid" value="'+id+'" type="hidden">'+
						'		<input id="spec" value="'+name+'" type="hidden">'+
						'	</td>'+add_html+'</tr>';
			}
			
			$("#property").html(html);
		}
	}else{
		html += '<tr data_spec="'+id+'" spec_num="'+num+'">';
		html += '	<td class="center">'+
				'		<span>'+name+'</span>'+
				'		<input id="categoryspecid" value="'+id+'" type="hidden">'+
				'		<input id="spec" value="'+name+'" type="hidden">'+
				'	</td>';
		html += add_html+'</tr>';
		
		if(specs.length>1){
			var bool = true;
			$("#property").find("tr").each(function(){
				if(bool){
					if($(this).attr("spec_num")>num){
						$(this).before(html);
						bool = false;
					}
				}
			})
			if(bool){
				$("#property").append(html);
			}
		}else{
			$("#property").html(html);
		}
	}
	
	if(specs.length==1){
		if($("#p_title").find("tr").find("th[data_type='spec']").length==0){
			var _color = $("#p_title").find("tr").find("th[data_type='color']");
			if(_color.length==0){
				$("#p_title").find("tr").find("th").eq(0).before("<th data_type='spec'>规格</th>");
			}else{
				_color.after("<th data_type='spec'>规格</th>");
			}
		}
	}
	
}

//删除选中的规格
function delete_spec_property(_this){
	$("#property").find("tr[data_spec='"+_this.val()+"']").each(function(){
		var spec = $(this);
		
		var rowspan = Number($("#property").find("tr[data_color='"+spec.attr("data_color")+"'] td").eq(0).attr("rowspan"))-1;
		$("#property").find("tr[data_color='"+spec.attr("data_color")+"']").each(function(){
			$(this).find("td").eq(0).attr("rowspan",rowspan);
		})
		
		if(spec.find("td").eq(0).css("display")!="none"){
			spec.next().find("td").eq(0).css("display","");
		}
		
		spec.remove();
	})
	
	if(specs.length==0){
		$("#p_title").find("tr").find("th[data_type='spec']").remove();
		if(colors.length==0){
			var html = '<tr>' + add_html+'</tr>';
			$("#property").html(html);
		}else{
			for(var i=0,len=colors.length;i<len;i++){
				add_color_property(colors[i]);
			}
		}
	}
	
}