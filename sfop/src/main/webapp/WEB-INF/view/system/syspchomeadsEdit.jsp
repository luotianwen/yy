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
						<form id="syspchomeads" method="post" class="form-horizontal">
							<input type="hidden" id="id" name="id" value="${id}"/>
							   <div class="form-group">
									<label class="col-sm-2 control-label">类型</label>
									<div class="col-sm-10">
										<select class="form-control m-b" name="module">
											<option value="1" v-bind:selected="syspchomeads!=null&&syspchomeads.module==1">跑步</option>
											<option value="2" v-bind:selected="syspchomeads!=null&&syspchomeads.module==2">骑行</option>
											<option value="3" v-bind:selected="syspchomeads!=null&&syspchomeads.module==3">徒步</option>
											<option value="4" v-bind:selected="syspchomeads!=null&&syspchomeads.module==4">男士</option>
											<option value="5" v-bind:selected="syspchomeads!=null&&syspchomeads.module==5">女士</option>
											<option value="6" v-bind:selected="syspchomeads!=null&&syspchomeads.module==6">儿童</option>
											<option value="7" v-bind:selected="syspchomeads!=null&&syspchomeads.module==7">自驾</option>
										</select>
									</div>
								</div>
							<div class="hr-line-dashed"></div>
							   <div class="form-group">
									<label class="col-sm-2 control-label">第1张图片地址</label>
									<div class="col-sm-10">
										<input type="hidden" name="fimg1" id="fimg1" v-bind:value="syspchomeads!=null?syspchomeads.fimg1:''"/>
										<img height="150px" id="img1" v-bind:src="syspchomeads!=null?syspchomeads.fimg1:''"  >
										<br/><br/>
										<input type="file" data-min-file-count="1" data_count="1" name="file" class="projectfile uploadfile" value=""/>
									</div>
								</div>
							<div class="hr-line-dashed"></div>
							   <div class="form-group">
									<label class="col-sm-2 control-label">第1张链接</label>
									<div class="col-sm-10">
										<input type="text" class="form-control" placeholder="第1张链接" id="flink1" name="flink1" v-bind:value="syspchomeads!=null?syspchomeads.flink1:''">
									</div>
								</div>
							<div class="hr-line-dashed"></div>
							   <div class="form-group">
									<label class="col-sm-2 control-label">第1张广告价格</label>
									<div class="col-sm-10">
										<input type="number" class="form-control" placeholder="第1张广告价格" id="fprice1" name="fprice1" v-bind:value="syspchomeads!=null?syspchomeads.fprice1:''">
									</div>
								</div>
							<div class="hr-line-dashed"></div>
							   <div class="form-group">
									<label class="col-sm-2 control-label">第2张图片地址</label>
									<div class="col-sm-10">
										<input type="hidden" name="fimg2" id="fimg2" v-bind:value="syspchomeads!=null?syspchomeads.fimg2:''"/>
										<img height="150px" id="img2" v-bind:src="syspchomeads!=null?syspchomeads.fimg2:''"  >
										<br/><br/>
										<input type="file" data-min-file-count="1" data_count="2" name="file" class="projectfile uploadfile" value=""/>
									</div>
								</div>
							<div class="hr-line-dashed"></div>
							   <div class="form-group">
									<label class="col-sm-2 control-label">第2张链接</label>
									<div class="col-sm-10">
										<input type="text" class="form-control" placeholder="第2张链接" id="flink2" name="flink2" v-bind:value="syspchomeads!=null?syspchomeads.flink2:''">
									</div>
								</div>
							<div class="hr-line-dashed"></div>
							   <div class="form-group">
									<label class="col-sm-2 control-label">第2张广告价格</label>
									<div class="col-sm-10">
										<input type="number" class="form-control" placeholder="第2张广告价格" id="fprice2" name="fprice2" v-bind:value="syspchomeads!=null?syspchomeads.fprice2:''">
									</div>
								</div>
							<div class="hr-line-dashed"></div>
							   <div class="form-group">
									<label class="col-sm-2 control-label">第3张图片地址</label>
									<div class="col-sm-10">
										<input type="hidden" name="fimg3" id="fimg3" v-bind:value="syspchomeads!=null?syspchomeads.fimg3:''"/>
										<img height="150px" id="img3" v-bind:src="syspchomeads!=null?syspchomeads.fimg3:''"  >
										<br/><br/>
										<input type="file" data-min-file-count="1" data_count="3"  name="file" class="projectfile uploadfile" value=""/>
									</div>
								</div>
							<div class="hr-line-dashed"></div>
							   <div class="form-group">
									<label class="col-sm-2 control-label">第3张链接</label>
									<div class="col-sm-10">
										<input type="text" class="form-control" placeholder="第3张链接" id="flink3" name="flink3" v-bind:value="syspchomeads!=null?syspchomeads.flink3:''">
									</div>
								</div>
							<div class="hr-line-dashed"></div>
							   <div class="form-group">
									<label class="col-sm-2 control-label">第3张广告价格</label>
									<div class="col-sm-10">
										<input type="text" class="form-control" placeholder="第3张广告价格" id="fprice3" name="fprice3" v-bind:value="syspchomeads!=null?syspchomeads.fprice3:''">
									</div>
								</div>
							<div class="hr-line-dashed"></div>
							   <div class="form-group">
									<label class="col-sm-2 control-label">状态</label>
									<div class="col-sm-10">
										<select class="form-control m-b" name="state"  >
											<option value="1" v-bind:selected="syspchomeads!=null&&syspchomeads.state==1">启用</option>
											<option value="2" v-bind:selected="syspchomeads!=null&&syspchomeads.state==2">禁用</option>
										</select>
									</div>
								</div>
							<div class="hr-line-dashed"></div>
							   <div class="form-group">
									<label class="col-sm-2 control-label">备注</label>
									<div class="col-sm-10">
										<input type="text" class="form-control" placeholder="备注" id="remark" name="remark" v-bind:value="syspchomeads!=null?syspchomeads.remark:''">
									</div>
								</div>
							<div class="hr-line-dashed"></div>
					      		<div class="form-group">
									<label class="col-sm-2 control-label">备注2</label>
									<div class="col-sm-10">
										<input type="text" class="form-control" placeholder="备注2" id="remark2" name="remark2" v-bind:value="syspchomeads!=null?syspchomeads.remark2:''">
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
			data : {syspchomeads:null},
			mounted : function(){
				var _this = this;
				$.post("syspchomeads/findSysPcHomeadsById.json?id="+$("#id").val(),function(data){
					for(var key in data){
						Vue.set(_this.$data,key,data[key]);
					}
				})
			},
			methods : {
				submit : function(){
					if (this.check_in()) {
						layer.load(0, {
							shade : 0.3
						});
						var url = "syspchomeads/saveSysPcHomeads.json";

						if ($("#id").val().trim()!=null&&$("#id").val().trim()!=''&&$("#id").val().trim()!='0') {
							url = "syspchomeads/updateSysPcHomeads.json";
						}
						$.post(url, $('#syspchomeads').serialize(), function(data) {
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
					if ($('#fimg1').val().trim() == '') {
						layer.tips('请上传第一张图片！', ".uploadfile[data_count='1']", {
							tips : [ 1, '#019F95' ],
							time : 1500
						});
						$(".uploadfile[data_count='1']").focus();
						return false;
					}
					if ($('#fimg2').val().trim() == '') {
						layer.tips('请上传第二张图片！', ".uploadfile[data_count='2']", {
							tips : [ 1, '#019F95' ],
							time : 1500
						});
						$(".uploadfile[data_count='2']").focus();
						return false;
					}
					if ($('#fimg3').val().trim() == '') {
						layer.tips('请上传第三张图片！', ".uploadfile[data_count='3']", {
							tips : [ 1, '#019F95' ],
							time : 1500
						});
						$(".uploadfile[data_count='3']").focus();
						return false;
					}
					
					return true;
				}
			}
		})
		
		
		$(".uploadfile").fileinput({
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
			initialCaption: "上传",//文本框初始话value
			enctype: 'multipart/form-data',
			validateInitialCount:true,
			previewFileIcon: "<i class='glyphicon glyphicon-king'></i>",
			msgFilesTooMany: "选择上传的文件数量({n}) 超过允许的最大数值{m}！",
			/* 			    initialPreview: [
			 "<img src='"+logo+"' class='file-preview-image kv-preview-data'  style='max-width:260px;'/>",
			 ], */
		});
		//异步上传返回结果处理
		$(".uploadfile").on("fileuploaded", function (event, data, previewId, index) {
			if("SUCCESS" == data.response.state){
				var count = $(this).attr("data_count");
				$("#fimg"+count).val(data.response.url);
				$("#img"+count).attr("src",data.response.url);
			}else{
				layer.alert(data.response.msg, {
					icon : 0
				});
			}

		});
		$('.uploadfile').on('change', function(event, numFiles, label) {
			$(this).fileinput('refresh');
		});
		$('.uploadfile').on('filepreupload', function(event, data, previewId, index) {
			$(this).fileinput('clear').fileinput('enable');
		});
		
	</script>


</body>


</html>