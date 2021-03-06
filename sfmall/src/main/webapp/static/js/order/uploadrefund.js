
function uploader(id,container,name){
	return new plupload.Uploader({
		runtimes : 'html5,flash,silverlight,html4',
		browse_button : id,
		container: $("#"+container).get(0),
		//multi_selection: false,
		flash_swf_url : '/static/upload/plupload-2.1.8/js/Moxie.swf',
		silverlight_xap_url : '/static/upload/plupload-2.1.8/js/Moxie.xap',
	    url : '/upload/file',
		init: {
			PostInit: function() {
				$('#'+container).find("input:file").attr("name",name);
				$('#'+container).find("input[type='file']").attr("accept","image/png,image/jpeg");
			},
			FilesAdded: function(up, files) {
				var count = $('#'+container).parent().find(".img-item").length;
				
				if(files.length+count<=10&&files.length+count>0){
					plupload.each(files, function(file) {
						makeThumb(file, function (imgsrc) {
		                    html = '<div class="img-item" id="img_'+file.id+'">'+
		                    		'	<input class="uploadimg" type="hidden"/>'+
									'	<img src="'+imgsrc+'" name="'+file.name+'" />'+
									'	<i class="btn-del" id="del_'+file.id+'" title="删除"></i>'+
									'	<div id="progress_'+file.id+'">' +
									'		<div class="progress" style="width:51px;height: 5px;">'+
									'			<div class="progress-bar" style="width: 0%"></div>'+
									'		</div>'+
									'	</div>'+
									'</div>';
		                    
		                    $('#'+container).before(html);
		                    
		                    $("#img_"+file.id).hover(function(){
		                    	$("#del_"+file.id).css("display","block");
		                    },function(){
		                    	$("#del_"+file.id).css("display","none");
		                    });
		                    
		                    $("#del_"+file.id).on("click",function(){
		                    	$("#img_"+file.id).remove();
		                    })
		                    
		                    up.start();
		                })
					})
				}else{
					up.files.splice(0, files.length);
					layer.alert("最多上传10张图片！",{icon:0,title:"提醒"});
				}
			},
			
			UploadProgress: function(up, file) {
				var div = $("div#progress_"+file.id).find(".progress-bar");
				div.css("width",file.percent+'%');
			},
			
			FileUploaded: function(uploader,file,data){
				if(data.status == "200"){
					var json =  eval("("+data.response+")");
					if(json.state=="SUCCESS"){
						if(json.url!=null&&json.url!=''){
							$('#img_'+file.id).find("input[type='hidden']").val(json.url);
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

var uploader = uploader("uploadImg","upload","upload_img");
uploader.init();

