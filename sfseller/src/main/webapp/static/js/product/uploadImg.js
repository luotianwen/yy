function upload(id,container){
	return new plupload.Uploader({
		runtimes : 'html5,flash,silverlight,html4',
		browse_button : id,
		container: container,
		//multi_selection: false,
		flash_swf_url : '/static/upload/plupload-2.1.8/js/Moxie.swf',
		silverlight_xap_url : '/static/upload/plupload-2.1.8/js/Moxie.xap',
		filters: {title: "image", filetype: "jpg,jpge,gif"},
	    url : '/upload/file',
		init: {
			PostInit: function() {
				$("#"+container).find("input[type='file']").attr("accept","image/png,image/jpeg");
			},
			FilesAdded: function(up, files) {
				var count = $('#'+container).parent().find("img").length;
				var _title="主图";
				if(count>1){
					_title="细节图";
				}
				if(files.length+count<=6&&files.length+count>0){
					count = 0;
					var name = "";
					var id_index = new Array();
					plupload.each(files, function(file,index) {
						if(file.size/1024<1024){
							count++;
							makeThumb(file, function (imgsrc) {
								var html = '<img id="'+file.id+'" style="height: 98px;" src="'+imgsrc+'"  title='+_title+' class="img-thumbnail margin-right10"">'+
											'<input data_type="image" id="'+file.id+'" type="hidden"/>';
			                    $('#'+container).before(html);

			                    var left = $("img#"+file.id).offset().left - $("#productimg").find("img").eq(0).offset().left;
			                    
			                    html = '<div id="'+file.id+'" style="display:inline;">' +
								'	<div class="progress" style="position: absolute;margin-left:'+left+'px;width:'+($("img#"+file.id).width()+10)+'px;">'+
								'		<div class="progress-bar" style="width: 0%"></div>'+
								'	</div>'+
								'</div>';
			                    
			                    $('#'+container).before(html);
			                    
			                    $("div#"+file.id).find(".progress").css("display","");
			                    
			                    $('img#'+file.id).on("click",function(){
			                    	var count = 0;
			                    	var bool = true;
			                    	for(var i=0,len=up.files.length;i<len;i++){
			                    		if(bool){
			                    			if(up.files[i].id == file.id){
			                    				count = i;
				                    			var count = i;
				                    			bool =false;
				                    			$("img#"+file.id).remove();
				                    			$("input#"+file.id).remove();
				                    			$("div#"+file.id).remove();
				                    		}
			                    		}else{
			                    			var div = $("div#"+up.files[i].id).find(".progress");
		                    				var left = $("img#"+up.files[i].id).offset().left - $("#productimg").find("img").eq(0).offset().left;
		                    				div.css("margin-left",left+"px");
			                    		}
			                    	}
			                    	up.files.splice(count, 1);
			                    })
			                })
						}else{
							if(name==""){
								name += file.name;
							}else{
								name += ","+file.name;
							}
							id_index.push(index);
						}
					})
					if(name!=""){
						layer.alert("文件："+name+"大小超过了1024KB！",{icon:0,title:"提醒"});
					}
					for(var i=0,len=id_index.length;i<len;i++){
						up.files.splice(id_index[i], 1);
					}
					
					if(count>0){
						$("#"+container).next().css("display","");
						$("#"+container).next().on("click",function(){
							up.start();
							$(this).css("display","none");
						})
					}
				}else{
					up.files.splice(0, files.length);
					layer.alert("最多上传五张图片！",{icon:0,title:"提醒"});
				}
				
			},
			
			UploadProgress: function(up, file) {
				var div = $("div#"+file.id).find(".progress-bar");
				div.html('<span>' + file.percent + '%</span>');
				div.css("width",file.percent+'%');
			},
			
			FileUploaded: function(uploader,file,data){
				if(data.status == "200"){
					var json =  eval("("+data.response+")");
					if(json.state=="SUCCESS"){
						if(json.url!=null&&json.url!=''){
							$('input#'+file.id).val(json.url);
						}
					}else{
						layer.alert(json.msg, {
	        				title:"错误信息",
	        				icon:2
	        			});
					}
				}else{
					layer.alert("图片上传异常！", {
	    				title:"错误信息",
	    				icon:2
	    			});
				}
			}
		}
	});
}
	
// 生产缩略图
function makeThumb(file,callback) {// file为plupload事件监听函数参数中的file对象,callback为预览图片准备完成的回调函数
    if (!file || !/image\//.test(file.type)) return; // 确保文件是图片
    
    if (file.type == 'image/gif') {// gif使用FileReader进行预览,因为mOxie.Image只支持jpg和png
        var fr = new mOxie.FileReader();
        fr.onload = function () {
            callback(fr.result,file);
            fr.destroy();
            fr = null;
        }
        fr.readAsDataURL(file.getSource());
    } else {
        var preloader = new mOxie.Image();
        preloader.onload = function () {
            // preloader.downsize(550, 400);//先压缩一下要预览的图片,宽300，高300
            var imgsrc = preloader.type == 'image/jpeg' ? preloader.getAsDataURL('image/jpeg', 80) : preloader.getAsDataURL(); // 得到图片src,实质为一个base64编码的数据
            callback && callback(imgsrc,file); // callback传入的参数为预览图片的url
            preloader.destroy();
            preloader = null;
        };
        preloader.load(file.getSource());
    }
}

var uploadP = upload("uploadImgP","uploadP");
uploadP.init();

