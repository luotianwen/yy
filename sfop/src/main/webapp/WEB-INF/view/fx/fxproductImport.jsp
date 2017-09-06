<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE html>
<html>

<head>
    <base href="<%=basePath%>">
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <title>品牌编辑</title>

    <link href="static/css/bootstrap.min.css" rel="stylesheet">
    <link href="static/css/animate.min.css" rel="stylesheet">
    <link href="static/css/style.min.css" rel="stylesheet">
    <link href="static/css/layerdate/layerdate.css" rel="stylesheet">
    <!-- iCheck -->
    <link href="static/css/plugins/iCheck/custom.css" rel="stylesheet">

    <link rel="stylesheet" href="static/plugins/bootstrap-fileinput/css/fileinput.css" />

</head>

<body class="gray-bg">
<div class="wrapper wrapper-content animated fadeInRight">
    <div class="row">
        <div id="user-box" class="col-sm-12">
            <div class="ibox">
                <div class="ibox-content" id="vue">
                    <form id="brand" method="post" class="form-horizontal">




                        <div class="form-group">
                            <label class="col-sm-2 control-label"> </label>
                            <div class="col-sm-10 col-md-6">
                                <input type="file"    data-min-file-count="1"  id="uploadfile" name="file"  class="projectfile" value=""/>

                                <a target="_blank" href="/temple/demo.xlsx">模版下载</a>
                            </div>

                        </div>
                        <div class="form-group">
                            <div class="col-sm-4 col-sm-offset-2">
                                <a class="btn btn-white" id="cancel" onclick="parent.layer.close(parent.layer.getFrameIndex(window.name))">取消</a>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- 全局js -->
<script src="static/js/vue.js"></script>
<script src="static/js/jquery-2.1.1.min.js"></script>
<script src="static/js/bootstrap.min.js"></script>
<script src="static/js/plugins/layer/layer.min.js"></script>
<!-- iCheck -->
<script src="static/js/plugins/iCheck/icheck.min.js"></script>
<script type="text/javascript" charset="utf-8" src="static/plugins/ueditor/ueditor.min.config.js"></script>
<script type="text/javascript" charset="utf-8" src="static/plugins/ueditor/ueditor.all.min.js"> </script>
<script type="text/javascript" charset="utf-8" src="static/plugins/ueditor/lang/zh-cn/zh-cn.js"></script>

<script type="text/javascript" src="static/plugins/bootstrap-fileinput/js/fileinput.js"></script>
<script type="text/javascript" src="static/plugins/bootstrap-fileinput/js/locales/zh.js"></script>




<script type="text/javascript">


    $(function() {
        $("#uploadfile").fileinput({
            language: 'zh', //设置语言
            uploadUrl: "upload/file.html", //上传的地址(访问接口地址)
            allowedFileExtensions: ['xls', 'xlsx'],//接收的文件后缀
            uploadExtraData:{"type": 3},
            uploadAsync: true, //默认异步上传
            showUpload: true, //是否显示上传按钮
            showRemove : false, //显示移除按钮
            showPreview : true, //是否显示预览
            showCaption: true,//是否显示标题
            showUploadedThumbs:false,
            browseClass: "btn btn-primary", //按钮样式
            dropZoneEnabled: false,//是否显示拖拽区域
            autoreplace:true,
            //minImageWidth: 50, //图片的最小宽度
            //minImageHeight: 50,//图片的最小高度
            maxImageWidth: 200,//图片的最大宽度
            maxImageHeight: 55,//图片的最大高度
            maxFileSize: 200,//单位为kb，如果为0表示不限制文件大小
            maxFileCount: 1, //表示允许同时上传的最大文件个数
            initialCaption: "上传excel",//文本框初始话value
            enctype: 'multipart/form-data',
            validateInitialCount:true,
            previewFileIcon: "<i class='glyphicon glyphicon-king'></i>",
            msgFilesTooMany: "选择上传的文件数量({n}) 超过允许的最大数值{m}！",
            /* 			    initialPreview: [
             "<img src='"+logo+"' class='file-preview-image kv-preview-data'  style='max-width:260px;'/>",
             ], */
        });
        //异步上传返回结果处理
        $("#uploadfile").on("fileuploaded", function (event, data, previewId, index) {
            if("SUCCESS" == data.response.state){
                        var _index = layer.load(0, {shade: false});
                        $.post("/fxproduct/analysis?url="+data.response.url ,function (data) {
                            layer.close(_index);
                            if(500!= data.RESPONSE_STATE){
                                layer.alert("上传成功", {
                                    icon : 0
                                });
                            }
                            else{
                                layer.alert("解析失败", {
                                    icon : 0
                                });
                            }
                        })


            }else{
                layer.alert("上传失败", {
                    icon : 0
                });
            }

        });
        $('#uploadfile').on('change', function(event, numFiles, label) {
            $('#uploadfile').fileinput('refresh');
        });
        $('#uploadfile').on('filepreupload', function(event, data, previewId, index) {
            $('#uploadfile').fileinput('clear').fileinput('enable');
        });

    });

</script>


</body>


</html>