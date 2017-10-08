<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="form-info">
	<form class="form-horizontal" id="shopbrand-info">
		<div class="form-group">
			<label for="letter" class="col-sm-2 control-label">品牌首字母：</label>
			<div class="col-sm-10">
				<select class="form-control inline" style="width: auto;" id="letter" name="letter">
					<option value="A">A</option>
					<option value="B">B</option>
					<option value="C">C</option>
					<option value="D">D</option>
					<option value="E">E</option>
					<option value="F">F</option>
					<option value="G">G</option>
					<option value="H">H</option>
					<option value="I">I</option>
					<option value="J">J</option>
					<option value="K">K</option>
					<option value="L">L</option>
					<option value="M">M</option>
					<option value="N">N</option>
					<option value="O">O</option>
					<option value="P">P</option>
					<option value="Q">Q</option>
					<option value="R">R</option>
					<option value="S">S</option>
					<option value="T">T</option>
					<option value="U">U</option>
					<option value="V">V</option>
					<option value="W">W</option>
					<option value="X">X</option>
					<option value="Y">Y</option>
					<option value="Z">Z</option>
				</select>
				<span class="help-block inline">*请选择品牌首字母</span>
			</div>
		</div>
		<div class="form-group">
			<label for="name" class="col-sm-2 control-label">品牌中文名：</label>
			<div class="col-sm-10">
				<input type="text" required class="form-control inline" id="name" maxlength="30" name="name" placeholder="" style="width: 300px;">
				<span class="help-block inline">*请输入品牌中文名称，不能出现“敏感”等字符，也不能使用特殊字符</span>
			</div>
		</div>
		
		<div class="form-group">
			<label class="col-sm-2 control-label">请上传品牌LOGO：</label>
			<div class="col-sm-10" id="uploadL">
				<input class="islogoImg" name="logo" type="hidden">
				<img src="" alt=""/>
				<button id="uploadImgL" type="button">上传LOGO</button>
				<span class="help-block">*请上传品牌LOGO</span>
			</div>
			
		</div>
		
		<!-- <div class="form-group">
			<label for="EnglishName" class="col-sm-2 control-label">品牌英文名：</label>
			<div class="col-sm-10">
				<input type="password" class="form-control inline" id="EnglishName"
					placeholder="" style="width: 300px;"> <span
					class="help-block inline">*请输入品牌英文名称，没有请填No</span>
			</div>
		</div> -->
		<div class="form-group">
			<label for="type" class="col-sm-2 control-label">品牌类型：</label>
			<div class="col-sm-10">
				<select class="form-control inline" style="width: auto;" id="type" name="type">
					<option value="1">国际品牌</option>
					<option value="2">国内品牌</option>
				</select>
				<span class="help-block inline">*请选择品牌类型</span>
			</div>
		</div>
		<div class="form-group">
			<label for="trademarktype" class="col-sm-2 control-label">商标注册人：</label>
			<div class="col-sm-10">
				<select class="form-control inline" style="width: auto;" id="trademarktype" name="trademarktype">
					<option value="1">企业</option>
					<option value="2">个人</option>
				</select>
				<span class="help-block inline">*请选择商标注册人</span>
			</div>
		</div>
		<div class="form-group">
			<label for="businesstype" class="col-sm-2 control-label">经营类型：</label>
			<div class="col-sm-10">
				<select class="form-control inline" style="width: auto;" id="businesstype" name="businesstype">
					<option value="1">自有品牌</option>
					<option value="2">代理品牌</option>
				</select>
				<span class="help-block inline">*请选择经营类型</span>
			</div>
		</div>
		<div class="form-group">
			<label for="descript" class="col-sm-2 control-label">品牌描述：</label>
			<div class="col-sm-10">
				<textarea id="descript" name="descript"></textarea>
				<span class="help-block">*请输入品牌介绍</span>
			</div>
		</div>
		<div class="form-group">
			<label for="descript" class="col-sm-2 control-label">资质有效期：</label>
			<div class="col-sm-10">
				<input type="text" style="width:24%;" required placeholder="资质有效期" id="valid_period" name="valid_period" readonly class="input form-control">
				<span class="help-block">*请输入资质有效期</span>
			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-2 control-label">请上传品牌资质扫描件：</label>
			<div class="col-sm-10" id="uploadZ">
				<input class="isImg" name="qualification_img" type="hidden">
				<img src="" alt=""/>
				<button id="uploadImgZ" type="button">上传资质</button>
				
				<span class="help-block">*电子版须加盖彩色企业公章，即纸质版盖章，扫描或拍摄成jpg、gif和png图片，建议图片大小不超过1MB，以免导致上传失败。</span>
			</div>
		</div>
		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-10">
				<h4>品牌资质要求：</h4>
				<p class="text-muted">1.
					自有品牌请上传由国家商标总局颁发的商标注册证书或者商标注册申请受理通知书复印件。</p>
				<p class="text-muted">2. 代理品牌请上传授权书或者能够证明授权关系的采购类证明文件。</p>
				<p class="text-muted">3.
					进口商品类品牌请上传相应的进口检疫检验文件，进口货物报关单，此资质填写到期日时，请贵公司根据单位的申请日期加算一年
					（例如：报关单的申请日为2013年10月1日，贵公司填写的到期日期为2014年10月1日）
					出入境检验检疫文件，此资质填写到期日时，请贵公司根据单位的申请日期加算一年
					（例如：报关单的申请日为2013年10月1日，贵公司填写的到期日期为2014年10月1日）。</p>
				<p class="text-muted">4.
					检验报告，此资质填写到期日，请贵公司根据检验报告的检测日期加算一年；（例如：检测报告的检测日为2013年10月1日，贵公司填写的到期日期为2014年10月1日）。</p>
				<p class="text-muted">5. 其他特殊品类请上传相应的专业资质证明文件，提供更多的资质材料可提高审核通过率；</p>
				<p class="text-muted">6.
					纸质资质请寄回如下地址：北京市通州区九棵树西路90号英特商务园写字楼A座8117-8118 悠氧商城商城（收）</p>
			</div>
		</div>
		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-10">
				<button type="button" class="btn btn-success btn-lg" id="submit">保 存</button>
				<button type="button" class="btn btn-success btn-lg" id="return">返 回</button>
			</div>
		</div>
	</form>
	
	<script type="text/javascript" src="/static/upload/plupload-2.1.8/js/plupload.full.min.js"></script>
	<script type="text/javascript" src="/static/js/applybrand/upload.js"></script>
	<script type="text/javascript" src="/static/js/validate/jquery.validate.min.js"></script>
	<script type="text/javascript" src="/static/js/validate/messages_zh.min.js"></script>
	<script type="text/javascript">
		$(function(){
			UE.delEditor('descript');
			var ue = UE.getEditor('descript');
			
			var valid_period = {
	   			elem : '#valid_period',
	   			format : 'YYYY-MM-DD',
	   			min: laydate.now(),
	   			istoday : false
	   		};
			laydate(valid_period);
			
			$("#submit").on("click",function(){
				if($("#shopbrand-info").valid()){
					layer.load(0, {
						shade : 0.3
					});
					$.post("shopbrand/applyBrand.json",$("#shopbrand-info").serialize(),function(data){
						if (data.RESPONSE_STATE=='200') {
							layer.closeAll('loading');
							layer.msg('保存成功', {
								icon : 1,
								time : 1 * 1000
							},function(){
								$("#return").trigger("click");
							});
						} else {
							layer.closeAll('loading');
							layer.alert(data.ERROR_INFO, {
								icon : 0
							});
						}
					})
				}
			})
			
			$("#return").on("click",function(){
				$("#sbd").css("display","block");
				$("#editbd").html("");
			})
			
			$("#shopbrand-info").validate({
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
	        					layer.tips(msg, a, {
									tips : [ 1, '#019F95' ],
									time : 1500,
									tipsMore: true
								});
	        				}else{
	        					layer.tips(msg, $(a).parent(), {
									tips : [ 1, '#019F95' ],
									time : 1500,
									tipsMore: true
								});
	        				}
	        			}
	        			if(i==0){
	        				$(a).focus();
	        			}
	        		});
	    		},
	    		onfocusout: false
			});
			
			// logo上传验证
			jQuery.validator.addMethod("islogoImg", function() {
				return $("input[name='logo']").val()!="";
			},"请上传品牌logo图片");
			
			// 品牌资质上传验证
			jQuery.validator.addMethod("isImg", function() {
				return $("input[name='qualification_img']").val()!="";
			},"请上传品牌资质图片");
			
		})
		
	</script>
	
	
</div>