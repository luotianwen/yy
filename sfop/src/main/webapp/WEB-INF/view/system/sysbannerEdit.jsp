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
	
	<title>编辑</title>
	
	<link href="static/css/bootstrap.min.css" rel="stylesheet">
	<link href="static/css/animate.min.css" rel="stylesheet">
	<link href="static/css/style.min.css" rel="stylesheet">
	<link href="static/css/layerdate/layerdate.css" rel="stylesheet">
	<!-- iCheck -->
	<link href="static/css/plugins/iCheck/custom.css" rel="stylesheet">
	<link rel="stylesheet" href="static/plugins/bootstrap-fileinput/css/fileinput.css" />
</head>

<body class="gray-bg">
	<div class="wrapper wrapper-content animated fadeInRight" id="vue">
		<div class="row">
			<div id="user-box" class="col-sm-12">
				<div class="ibox">
					<div class="ibox-content">
						<form id="sysbanner" method="post" class="form-horizontal">
							<input type="hidden" id="id" name="id" value="${id}"/>


							   <div class="form-group">
									<label class="col-sm-2 control-label">名称</label>
									<div class="col-sm-10">
										<input type="text" class="form-control" placeholder="名称" id="name" name="name" v-bind:value="sysbanner!=null?sysbanner.name:''">
									</div>
								</div>
							<div class="hr-line-dashed"></div>
							<div class="form-group">
								<label class="col-sm-2 control-label">图片</label>
								<div class="col-sm-10 col-md-6">
									<input type="hidden"  name="imgPath"  id="imgPath"  v-bind:value="sysbanner!=null?sysbanner.imgPath:''"/>
									<img    id="logoImg"  v-bind:src="sysbanner!=null?sysbanner.imgPath:''"  style="max-width:360px;">
									<br/><br/>
									<input type="file"  placeholder="品牌logo"  data-min-file-count="1"  id="uploadfile" name="file"  class="projectfile" value=""/>
								</div>
							</div>
							<div class="hr-line-dashed"></div>
							   <div class="form-group">
									<label class="col-sm-2 control-label">链接</label>
									<div class="col-sm-10">
										<input type="text" class="form-control" placeholder="链接" id="imgLink" name="imgLink" v-bind:value="sysbanner!=null?sysbanner.imgLink:''">
									</div>
								</div>
							<div class="hr-line-dashed"></div>
							   <div class="form-group">
									<label class="col-sm-2 control-label">类型</label>
									<div class="col-sm-10">
										<select class="form-control m-b" name="module"  >
											<option value="1" v-bind:selected="sysbanner!=null&&sysbanner.module==1">pc</option>
											<option value="2" v-bind:selected="sysbanner!=null&&sysbanner.module==2">app</option>
										</select>
									</div>
								</div>
							<div class="hr-line-dashed"></div>
							   <div class="form-group">
									<label class="col-sm-2 control-label">序号</label>
									<div class="col-sm-10">
										<input type="text" class="form-control" placeholder="序号" id="sort" name="sort" v-bind:value="sysbanner!=null?sysbanner.sort:''">
									</div>
								</div>
							<div class="hr-line-dashed"></div>
							   <div class="form-group">
									<label class="col-sm-2 control-label">状态</label>
									<div class="col-sm-10">
										<select class="form-control m-b" name="state"  >
											<option value="1" v-bind:selected="sysbanner!=null&&sysbanner.state==1">发布</option>
											<option value="2" v-bind:selected="sysbanner!=null&&sysbanner.state==2">下线</option>
										</select>
									</div>
								</div>

							   <div class="form-group">
									<label class="col-sm-2 control-label">备注</label>
									<div class="col-sm-10">
										<input type="text" class="form-control" placeholder="备注" id="remark" name="remark" v-bind:value="sysbanner!=null?sysbanner.remark:''">
									</div>
								</div>
							<div class="hr-line-dashed"></div>
					      
							
					 
							
							<div class="form-group">
								<div class="col-sm-4 col-sm-offset-2">
									<a class="btn btn-primary" id="submit" @click="submit">保存内容</a>
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
	<script type="text/javascript" src="static/plugins/bootstrap-fileinput/js/fileinput.js"></script>
	<script type="text/javascript" src="static/plugins/bootstrap-fileinput/js/locales/zh.js"></script>
	<script type="text/javascript">
		new Vue({
			el : "#vue",
			data : {sysbanner:null},
			mounted : function(){
				var _this = this;
				$.post("sysbanner/findSysBannerById.json?id="+$("#id").val(),function(data){
					for(var key in data){
						if(_this.key == undefined){
							Vue.set(_this.$data,key,data[key]);
						}else{
							_this.key = data[key];
						}
					}
				})
			},
			methods : {
				submit : function(){
					if (this.check_in()) {
						layer.load(0, {
							shade : 0.3
						});
						var url = "sysbanner/saveSysBanner.json";

						if ($("#id").val().trim()!=null&&$("#id").val().trim()!=''&&$("#id").val().trim()!='0') {
							url = "sysbanner/updateSysBanner.json";
						}
						$.post(url, $('#sysbanner').serialize(), function(data) {
							if (data.RESPONSE_STATE == '200') {
								layer.msg('保存成功', {
									icon : 1,
									time : 1 * 1000
								}, function() {
									parent.self.location.reload();
								});
							} else {
								layer.closeAll('loading');
								layer.alert(data.ERROR_INFO, {
									icon : 0
								});
							}
						});
					}
				},
				check_in : function(){
					if ($('#id').val().trim() == '') {
						$("#id").val(0);
					}
					if ($('#name').val().trim() == '') {
						layer.tips('名称！！！', '#name', {
							tips : [ 1, '#019F95' ],
							time : 1500
						});
						$('#name').focus();
						return false;
					}
					if ($('#imgPath').val().trim() == '') {
						layer.tips('图片上传！', '#uploadfile', {
							tips : [ 1, '#019F95' ],
							time : 1500
						});
						$('#uploadfile').focus();
						return false;
					}
					return true;
				}
			}
		});

		$("#uploadfile").fileinput({
			language: 'zh', //设置语言
			uploadUrl: "upload/file.html", //上传的地址(访问接口地址)
			allowedFileExtensions: ['jpg', 'gif', 'png'],//接收的文件后缀
			//uploadExtraData:{"id": 1, "fileName":'123.mp3'},
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
			//maxImageWidth: 200,//图片的最大宽度
			//maxImageHeight: 55,//图片的最大高度
			//maxFileSize: 50,//单位为kb，如果为0表示不限制文件大小
			maxFileCount: 1, //表示允许同时上传的最大文件个数
			initialCaption: "上传品牌logo",//文本框初始话value
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
				$("#imgPath").val(data.response.url);
				$("#logoImg").attr("src",data.response.url);
			}else{
				layer.alert("Logo上传失败", {
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


	</script>


</body>


</html>