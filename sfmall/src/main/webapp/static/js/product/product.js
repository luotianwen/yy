$(function(){
	$.fn.product = function(){
		this.keyword = keyword;
		this.c = "";
		this.curr = 1;
		this.init();
	}
	
	$.fn.product.prototype = {
		init : function(){
			this.bind();
		},
		bind : function(){
			//是否关注商品
			this.isCollect();
			//关注商品
			this.collect();
			//选择搜索条件
			this.key();
			this.clickvalue();
			//删除搜索条件
			this.del();
			//清空搜索条件
			this.delall();
			//排列顺序
			this.sort();
			//历史筛选
			this.history();
			//分页
			this.page(pageCount,this.curr);
			//更换图片
			this.changeSku();
			
			this.left_right();
		},
		page : function(pageCount,curr){
			var _this = this;
			laypage({
				cont: "page",
				pages: pageCount,
				curr: curr,
				skip: true, //是否开启跳页
		        groups: 5, //连续显示分页数
		        skin: '#76cf8f',
		        first: 1,
		        prev:"<",
		        next:">",
		        last: pageCount, //在尾页追加总页数。
				jump: function(obj, first){
					if(!first){
						_this.curr = obj.curr;
						_this.searchWare(true);
					}
				}
			});
		},
		searchWare : function(bool){
			var _this = this;
			var str = "";
			var keyword = _this.keyword;
			if(keyword!=""&&keyword!="*"){
				str = "?keyword="+keyword;
			}
			var c = _this.c;
			if(c!=""){
				str = "?c="+c;
			}
			var fv = "";
			$(".card").find("a.item").each(function(){
				if(fv==""){
					fv += $(this).attr("data_id");
				}else{
					fv += "," + $(this).attr("data_id");
				}
			})
			if(fv!=""){
				if(str==""){
					str = "?fv="+fv;
				}else{
					str += "&fv="+fv;
				}
			}
			var sort = $(".g-sort").find("a.current").attr("data_type");
			if(str==""){
				str = "?sort="+sort;
			}else{
				str += "&sort="+sort;
			}
			
			if(bool){
				var curr = _this.curr;
				if(curr!="1"){
					if(str==""){
						str = "?pageNow="+curr;
					}else{
						str += "&pageNow="+curr;
					}
				}
			}
			
			window.location.href = "searchWare.htm"+str;
			
			/*history.pushState("","","searchWare.htm"+str);
			$.post("/product/wareList.json"+str,function(data){
				html = '';
				for(var i=0,len=data.page.result.length;i<len;i++){
					var product = data.page.result[i];
					for(var j=0,lenj=product.skuList.length;j<lenj;j++){
						var ware = product.skuList[j];
						html += '<li data_id="'+ware.sku+'">'+
								'	<div class="g_img">'+
								'		<a href="/detail/'+ware.sku+'.html"><img src="'+ware.colorPic+'"/></a>'+
								'	</div>'+
								'	<div class="g_name"><a href="/detail/'+ware.sku+'.html">'+product.pName+'</a></div>'+
								'	<div class="g_price">'+
								'		<span>¥'+ware.marketprice+'</span>'+
								'		<del>¥'+ware.marketprice+'</del>'+
								'		<i class="ico-cart" title="加入购物车"></i>'+
								'		<i data_id="'+ware.sku+'" class="ico-collect" title="收藏"></i>'+
								'	</div>'+
								'</li>';
						break;
					}
				}
				$("#productList").html(html);
				$("#go_top").trigger("click");
				
				_this.isCollect();
				if(!bool){
					_this.page(data.page.pageCount,data.page.pageNow);
				}
			})*/
		},
		isCollect : function(){
			if(userId!=""){
				$("#productList").find("li.goods-list-li").each(function(){
					var _this = $(this);
					var sku = _this.attr("data_id");
					$.post("/my/isFollowWare",{sku:sku},function(req){
						if(req.code==0){
							if(req.data){
								_this.find(".ico-collect").addClass("selected");
							}
				        }
					});
				})
			}
		},
		collect : function(){
			$(".ico-collect").on("click",function(){
				var _this = $(this);
				var sku = _this.attr("data_id");
				if(!_this.hasClass("selected")){
		        	$.post("/my/joinsku",{sku:sku},function(data){
		                if(data.code==0){
		                	_this.addClass("selected");
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
		                	_this.removeClass("selected");
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
			})
		},
		key : function(){
			$(".sl-key").on("click",function(){
				var _this = $(this);
				var _i = _this.find("i");
				var _value = _this.next();
				if(_i.hasClass("unfold")){
					_i.removeClass("unfold");
					_i.addClass("fold");
					
					if(_value.hasClass("sl-value")){
						_value.css("display","block");
					}
				}else{
					_i.removeClass("fold");
					_i.addClass("unfold");
					
					if(_value.hasClass("sl-value")){
						_value.css("display","none");
					}
				}
				
			})
		},
		value : function($this){
			$this.css("display","none");
			$this.attr("data_type","yes");
			
			if($this.parent().find("a[data_type='no']").length==0){
				$this.closest("li").find(".sl-key").css("display","none");
			}
			
			$(".del-all").before('<a data_id="'+$this.attr("data_id")+'" class="item">'+$this.html()+'<i class="del"></i></a>');
			$(".del-all").css("display","block");
		},
		clickvalue : function(){
			var _this = this;
			$(".sl-value a").on("click",function(){
				_this.value($(this));				
				_this.searchWare();
			})
		},
		delkey : function(_this){
			var id = _this.parent().attr("data_id");
			var _a = $(".sl-value a[data_id='"+id+"']");
			_a.css("display","block");
			_a.attr("data_type","no");
			_a.closest("li").find(".sl-key").css("display","block");
			_this.parent().remove();
		},
		del : function(){
			var _this = this;
			$(".card").on("click",".del",function(){
				_this.delkey($(this));
				_this.searchWare();
			})
		},
		delall : function(){
			var _this = this;
			$(".del-all").on("click",function(){
				$(".card").find("i.del").each(function(){
					_this.delkey($(this));
				})
				_this.searchWare();
			})
		},
		sort : function(){
			var _this = this;
			$(".g-sort").on("click","a",function(){
				$(".g-sort").find("a").removeClass("current");
				$(this).addClass("current");
				
				_this.searchWare();
			})
		},
		history : function(){
			var _this = this;
			var url =  window.location.href;
			url = url.split("?");
			if(url.length>1){
				var urls = url[1].split("&");
				for(var i=0,len=urls.length;i<len;i++){
					var type = urls[i].split("=");
					if(type.length>1){
						if(type[0]=="keyword"){
							if(_this.keyword!="*"){
								$("#keyword").val(_this.keyword);
							}
						}else if(type[0]=="fv"){
							var values = type[1].split(",");
							for(var v=0,lenv=values.length;v<lenv;v++){
								var _a = $(".sl-value a[data_id='"+values[v]+"']");
								_this.value(_a);
							}
						}else if(type[0]=="sort"){
							$(".g-sort").find("a").removeClass("current");
							$(".g-sort").find("a[data_type='"+type[1]+"']").addClass("current");
						}else if(type[0]=="c"){
							_this.c = type[1];
						}else if(type[0]=="pageNow"){
							_this.curr = type[1];
						}
					}
				}
				
			}
			
		},
		changeSku : function(){
			$(".list_menu").on("click","ul li",function(){
				var _this = $(this);
				_this.closest("ul").find("li.active").removeClass("active");
				_this.addClass("active");
				
				var li = _this.closest(".goods-list-li");
				
				li.attr("data_id",_this.attr("data_id"));
				li.find(".data_src").attr("src",_this.attr("data_colorPic"));
				li.find(".data_href").attr("href","/detail/"+_this.attr("data_id")+".html");
				li.find(".data_price").html("¥"+_this.attr("data_price"));
				li.find(".data_del").html("¥"+_this.attr("data_marketprice"));
				li.find(".data_cart").attr("href","/my/joincart?sku="+_this.attr("data_id")+"&pcount=1");
				li.find(".data_id").attr("data_id",_this.attr("data_id"));
			})
		},
		left_right : function(){
			$(".bl_btn").on("click",function(){
				var ul = $(this).closest("div.g_banner").find(".list_menu ul");
				var count = ul.find("li").length;
				var ml = ul.css("margin-left").replace("px", "");
				if(ml<0){
					ml = Number(ml)+38;
					ul.css("margin-left",ml+"px");
				}
			})
			$(".br_btn").on("click",function(){
				var ul = $(this).closest("div.g_banner").find(".list_menu ul");
				var count = ul.find("li").length;
				var ml = ul.css("margin-left").replace("px", "");
				if(count!=0&&ml>(5-count)*38){
					ml = Number(ml)-38;
					ul.css("margin-left",ml+"px");
				}
			})
		}
		
	}
	
	new $.fn.product();
})

