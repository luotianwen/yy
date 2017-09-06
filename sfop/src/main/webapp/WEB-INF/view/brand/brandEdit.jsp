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
							<input type="hidden" id="id" name="id" value="${id }"/>
							<div class="form-group">
								<label class="col-sm-2 control-label">品牌名称</label>

								<div class="col-sm-10">
									<input type="text" class="form-control" placeholder="品牌名称" id="name" name="name" v-bind:value="brand!=null?brand.name:''">
								</div>
							</div>

							
							<div class="form-group">
								<label class="col-sm-2 control-label">品牌logo</label>

								<div class="col-sm-10 col-md-6">
									 <input type="hidden"  name="logo"  id="logo"  v-bind:value="brand!=null?brand.logo:''"/>
									 <img  v-bind:alt="brand!=null?brand.name:''" v-bind:title="brand!=null?brand.name:''" id="logoImg"  v-bind:src="brand!=null?brand.logo:''"  style="max-width:360px;">
									 <br/><br/> 
									<input type="file"  placeholder="品牌logo" accept="image/png,image/jpeg" data-min-file-count="1"  id="uploadfile" name="file"  class="projectfile" value=""/>
								</div>
							</div>

							
							<div class="form-group">
								<label class="col-sm-2 control-label">品牌描述</label>

								<div class="col-sm-10">
									<textarea   id="descript" name="descript"></textarea>
								</div>
							</div>

							<div class="hr-line-dashed"></div>
							<div class="form-group">
								<label class="col-sm-2 control-label">状态</label>
								<div class="col-sm-10">
									<select class="form-control m-b" name="state"  >
										<option value="1" v-bind:selected="brand!=null&&brand.state==1">启用</option>
										<option value="2" v-bind:selected="brand!=null&&brand.state==2">禁用</option>
									</select>
								</div>
							</div>

							<div class="form-group">
								<label class="col-sm-2 control-label">排序</label>

								<div class="col-sm-10">
									<input type="number" class="form-control" placeholder="排序" id="rand" name="rand" v-bind:value="brand!=null?brand.rand:''">
								</div>
							</div>

							<div class="form-group">
								<label class="col-sm-2 control-label">品牌首字母</label>
								<div class="col-sm-10">
									<select class="form-control m-b" name="letter"  >
										<option value="A" v-bind:selected="brand!=null&&brand.letter=='A'">A</option>
										<option value="B" v-bind:selected="brand!=null&&brand.letter=='B'">B</option>
										<option value="C" v-bind:selected="brand!=null&&brand.letter=='C'">C</option>
										<option value="D" v-bind:selected="brand!=null&&brand.letter=='D'">D</option>
										<option value="E" v-bind:selected="brand!=null&&brand.letter=='E'">E</option>
										<option value="F" v-bind:selected="brand!=null&&brand.letter=='F'">F</option>
										<option value="G" v-bind:selected="brand!=null&&brand.letter=='G'">G</option>
										<option value="H" v-bind:selected="brand!=null&&brand.letter=='H'">H</option>
										<option value="I" v-bind:selected="brand!=null&&brand.letter=='I'">I</option>
										<option value="J" v-bind:selected="brand!=null&&brand.letter=='J'">J</option>
										<option value="K" v-bind:selected="brand!=null&&brand.letter=='K'">K</option>
										<option value="L" v-bind:selected="brand!=null&&brand.letter=='L'">L</option>
										<option value="M" v-bind:selected="brand!=null&&brand.letter=='M'">M</option>
										<option value="N" v-bind:selected="brand!=null&&brand.letter=='N'">N</option>
										<option value="O" v-bind:selected="brand!=null&&brand.letter=='O'">O</option>
										<option value="P" v-bind:selected="brand!=null&&brand.letter=='P'">P</option>
										<option value="Q" v-bind:selected="brand!=null&&brand.letter=='Q'">Q</option>
										<option value="R" v-bind:selected="brand!=null&&brand.letter=='R'">R</option>
										<option value="S" v-bind:selected="brand!=null&&brand.letter=='S'">S</option>
										<option value="T" v-bind:selected="brand!=null&&brand.letter=='T'">T</option>
										<option value="U" v-bind:selected="brand!=null&&brand.letter=='U'">U</option>
										<option value="V" v-bind:selected="brand!=null&&brand.letter=='V'">V</option>
										<option value="W" v-bind:selected="brand!=null&&brand.letter=='W'">W</option>
										<option value="X" v-bind:selected="brand!=null&&brand.letter=='X'">X</option>
										<option value="Y" v-bind:selected="brand!=null&&brand.letter=='Y'">Y</option>
										<option value="Z" v-bind:selected="brand!=null&&brand.letter=='Z'">Z</option>
									</select>
								</div>
							</div>

							<div class="form-group">
								<label class="col-sm-2 control-label">品牌类型</label>
								<div class="col-sm-10">
									<select class="form-control m-b" name="type"  >
										<option value="1" v-bind:selected="brand!=null&&brand.type==1">国际品牌</option>
										<option value="2" v-bind:selected="brand!=null&&brand.type==2">国内品牌</option>
									</select>
								</div>
							</div>

							<div class="form-group">
								<label class="col-sm-2 control-label">商标注册人</label>
								<div class="col-sm-10">
									<select class="form-control m-b" name="trademarktype"  >
										<option value="1" v-bind:selected="brand!=null&&brand.trademarktype==1">企业</option>
										<option value="2" v-bind:selected="brand!=null&&brand.trademarktype==2">个人</option>
									</select>
								</div>
							</div>

							<div class="form-group">
								<label class="col-sm-2 control-label">经营类型</label>
								<div class="col-sm-10">
									<select class="form-control m-b" name="businesstype"  >
										<option value="1" v-bind:selected="brand!=null&&brand.businesstype==1">自有品牌</option>
										<option value="2" v-bind:selected="brand!=null&&brand.businesstype==2">代理品牌</option>
									</select>
								</div>
							</div>

							
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
	<script type="text/javascript" charset="utf-8" src="static/plugins/ueditor/ueditor.min.config.js"></script>
	<script type="text/javascript" charset="utf-8" src="static/plugins/ueditor/ueditor.all.min.js"> </script>
	<script type="text/javascript" charset="utf-8" src="static/plugins/ueditor/lang/zh-cn/zh-cn.js"></script>
	
	<script type="text/javascript" src="static/plugins/bootstrap-fileinput/js/fileinput.js"></script>
	<script type="text/javascript" src="static/plugins/bootstrap-fileinput/js/locales/zh.js"></script>
 
	
	
	
	<script type="text/javascript">
		
		
		$(function() {
			
			var ue;
			var logo;
			var vue = new Vue({
				el : "#vue",
				data : {brand:null},
				mounted : function(){
					var _this = this;
					$.ajaxSetup({   
			            async : false
			        });
					$.post("brand/findBrandById.json?id="+$("#id").val(),function(data){
						for(var key in data){
							if(_this.key == undefined){
								Vue.set(_this.$data,key,data[key]);
							}else{
								_this.key = data[key];
							}
						}
						
						if(_this.brand!=undefined){
							logo = data.brand.logo;
							$("#descript").val(_this.brand.descript);
						}
						
						ue= UE.getEditor('descript');
					})
					 
				},
				methods : {
					submit : function(){
						if (this.check_in()) {
							layer.load(0, {
								shade : 0.3
							});
							var url = "brand/saveBrand.json";

							if ($("#id").val().trim()!=null && $("#id").val().trim()!='' && $("#id").val().trim()!='0') {
								url = "brand/updateBrand.json";
							}
							$.post(url, $('#brand').serialize(), function(data) {
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
						if($("#id").val().trim()==''){
							$("#id").val(0);
						}
						if ($('#name').val().trim() == '') {
							layer.tips('品牌名称！！！', '#name', {
								tips : [ 1, '#019F95' ],
								time : 1500
							});
							$('#name').focus();
							return false;
						}
						
						if ($('#logo').val().trim() == '') {
							layer.tips('品牌logo！！！', '#logo', {
								tips : [ 1, '#019F95' ],
								time : 1500
							});
							$('#logo').focus();
							return false;
						}
						var html = ue.getContent();
						if (html.trim() == '') {
							layer.tips('品牌描述！！！', '#descript', {
								tips : [ 1, '#019F95' ],
								time : 1500
							});
							$('#descript').focus();
							return false;
						}

						if ($('#rand').val().trim() == '') {
							layer.tips('排序！！！', '#rand', {
								tips : [ 1, '#019F95' ],
								time : 1500
							});
							$('#rand').focus();
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
				allowedPreviewTypes: ['image'],
			    showUploadedThumbs:false,
			    browseClass: "btn btn-primary", //按钮样式     
			    dropZoneEnabled: false,//是否显示拖拽区域
			    autoreplace:true,
			    //minImageWidth: 50, //图片的最小宽度
			    //minImageHeight: 50,//图片的最小高度
			    maxImageWidth: 200,//图片的最大宽度
				maxImageHeight: 55,//图片的最大高度
			    maxFileSize: 50,//单位为kb，如果为0表示不限制文件大小
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
			    	 $("#logo").val(data.response.url);
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
			
		 });
	 
	</script>


</body>


</html>