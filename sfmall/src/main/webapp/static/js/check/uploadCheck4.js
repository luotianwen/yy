
var uploader = new plupload.Uploader({
	runtimes : 'html5,flash,silverlight,html4',
	browse_button : "uploadImg",
	container: $("#upload").get(0),
	//multi_selection: false,
	flash_swf_url : '/static/upload/plupload-2.1.8/js/Moxie.swf',
	silverlight_xap_url : '/static/upload/plupload-2.1.8/js/Moxie.xap',
    url : '/upload/file',
	init: {
		PostInit: function() {
			$('#upload').find("input[type='file']").attr("accept","image/png,image/jpeg");
		},
		FilesAdded: function(up, files) {
			plupload.each(files, function(file) {
				makeThumb(file, function (imgsrc) {
                    $("#uploadImg").attr("src",imgsrc);
                    
                    html = '<div id="'+file.id+'" style="margin-left: 20px; margin-top: -2px;position: absolute;top: 170px;">' +
					'	<div class="progress" style="width:312px;">'+
					'		<div class="progress-bar" style="width: 0%"></div>'+
					'	</div>'+
					'</div>';
                    
                    $("#uploadImg").after(html);
                    
                })
			})
		},
		BeforeUpload: function(up, file) {
			layer.load(0, {
				shade : 0.3
			});
        },
        
        UploadProgress: function(up, file) {
			var div = $("div#"+file.id).find(".progress-bar");
			div.html('<span>' + file.percent + '%</span>');
			div.css("width",file.percent+'%');
		},
        
		FileUploaded: function(uploader,file,data){
			layer.closeAll('loading');
			if(data.status == "200"){
				var json =  eval("("+data.response+")");
				if(json.state=="SUCCESS"){
					if(json.url!=null&&json.url!=''){
						var id = $("#screenshot").attr("data_id");
						$("td[data_id='"+id+"']").find("a#uscreenshot").find("input").val(json.url);
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

uploader.init();
