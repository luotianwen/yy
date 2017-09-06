
function uploader(id,container,name,px){
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
				plupload.each(files, function(file) {
					makeThumb(file, function (imgsrc) {
	                    $('#'+container).find("img").attr({"src":imgsrc,"name":file.name});
	                    
	                    html = '<div id="'+file.id+'" style="margin-left: '+px+'px; margin-top: -2px;">' +
								'	<div class="progress" style="width:312px;">'+
								'		<div class="progress-bar" style="width: 0%"></div>'+
								'	</div>'+
								'</div>';
	                    
	                    $('#'+container).after(html);
	                    
	                    up.start();
	                })
				})
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
							$('#'+container).find("input[type='hidden']").val(json.url);
							$("#"+file.id).remove();
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

//身份证正面
var uploaderZ = uploader("uploadImgZ","uploadZ","z_file","15");
uploaderZ.init();
//身份证反面
var uploaderF = uploader("uploadImgF","uploadF","f_file","15");
uploaderF.init();
//银行开户许可证
var uploaderB = uploader("uploadImgB","uploadB","b_file","15");
uploaderB.init();
//三证合一
var uploaderT = uploader("uploadImgT","uploadT","t_file","66");
uploaderT.init();
//组织机构代码证
var uploaderO = uploader("uploadImgO","uploadO","o_file","15");
uploaderO.init();
//纳税登记证
var uploaderTax = uploader("uploadImgTax","uploadTax","tax_file","50");
uploaderTax.init();
//营业执照副本
var uploaderL = uploader("uploadImgL","uploadL","l_file","34");
uploaderL.init();