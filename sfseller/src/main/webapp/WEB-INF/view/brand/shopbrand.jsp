<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<div class="form-info">
	<form class="form-horizontal" id="shopbrand-info">
		<div class="form-group">
			<label for="FirstLetter" class="col-sm-2 control-label">品牌首字母：</label>
			<div class="col-sm-10">
				<c:if test="${dto.brand!=null }">
					${dto.brand.letter }
				</c:if>
				<c:if test="${dto.brand==null }">
					${dto.letter }
				</c:if>
			</div>
		</div>
		<div class="form-group">
			<label for="ChineseName" class="col-sm-2 control-label">品牌中文名：</label>
			<div class="col-sm-10">
				<c:if test="${dto.brand!=null }">
					${dto.brand.name }
				</c:if>
				<c:if test="${dto.brand==null }">
					${dto.name }
				</c:if>
			</div>
		</div>
		
		<div class="form-group">
			<label class="col-sm-2 control-label">品牌LOGO：</label>
			<div class="col-sm-10">
				<c:if test="${dto.brand!=null }">
					<img style="width: 300px;" src="${dto.brand.logo }" alt=""/>
				</c:if>
				<c:if test="${dto.brand==null }">
					<img style="width: 300px;" src="${dto.logo }" alt=""/>
				</c:if>
			</div>
		</div>
		
		<div class="form-group">
			<label for="Type" class="col-sm-2 control-label">品牌类型：</label>
			<div class="col-sm-10">
				<c:if test="${dto.brand!=null }">
					<c:if test="${dto.brand.type==1 }">
						国际品牌
					</c:if>
					<c:if test="${dto.brand.type==2 }">
						国内品牌
					</c:if>
				</c:if>
				<c:if test="${dto.brand==null }">
					<c:if test="${dto.type==1 }">
						国际品牌
					</c:if>
					<c:if test="${dto.type==2 }">
						国内品牌
					</c:if>
				</c:if>
			</div>
		</div>
		<div class="form-group">
			<label for="Registrant" class="col-sm-2 control-label">商标注册人：</label>
			<div class="col-sm-10">
				<c:if test="${dto.brand!=null }">
					<c:if test="${dto.brand.trademarktype==1 }">
						企业
					</c:if>
					<c:if test="${dto.brand.trademarktype==2 }">
						个人
					</c:if>
				</c:if>
				<c:if test="${dto.brand==null }">
					<c:if test="${dto.trademarktype==1 }">
						企业
					</c:if>
					<c:if test="${dto.trademarktype==2 }">
						个人
					</c:if>
				</c:if>
			</div>
		</div>
		<div class="form-group">
			<label for="ManageType" class="col-sm-2 control-label">经营类型：</label>
			<div class="col-sm-10">
				<c:if test="${dto.brand!=null }">
					<c:if test="${dto.brand.businesstype==1 }">
						自有品牌
					</c:if>
					<c:if test="${dto.brand.businesstype==2 }">
						代理品牌
					</c:if>
				</c:if>
				<c:if test="${dto.brand==null }">
					<c:if test="${dto.businesstype==1 }">
						自有品牌
					</c:if>
					<c:if test="${dto.businesstype==2 }">
						代理品牌
					</c:if>
				</c:if>
			</div>
		</div>
		<div class="form-group">
			<label for="descript" class="col-sm-2 control-label">品牌描述：</label>
			<div class="col-sm-10">
				<textarea id="descript">
					<c:if test="${dto.brand!=null }">
						${dto.brand.descript }
					</c:if>
					<c:if test="${dto.brand==null }">
						${dto.descript }
					</c:if>
				</textarea>
			</div>
		</div>
		<div class="form-group">
			<label for="descript" class="col-sm-2 control-label">资质有效期：</label>
			<div class="col-sm-10">
				<fmt:formatDate value="${dto.valid_period}" pattern="yyyy-MM-dd HH:mm:ss" />
			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-2 control-label">品牌资质扫描件：</label>
			<div class="col-sm-10" id="uploadZ">
				<img width="300" src="${dto.qualification_img }" alt=""/>
			</div>
		</div>
		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-10">
				<button type="button" class="btn btn-success btn-lg" id="return">返 回</button>
			</div>
		</div>
	</form>
	
	<script type="text/javascript">
		$(function(){
			UE.delEditor('descript');
			var ue = UE.getEditor('descript');
			ue.addListener('ready', function () {
				ue.setDisabled();
            });
			
			$("#return").on("click",function(){
				$("#myTab").find("li").eq(0).addClass("active");
				$("#myTab").find("li").eq(1).removeClass("active");
				
				$("#applyBrand").removeClass("in").removeClass("active");
				$("#brandList").addClass("in").addClass("active");
				
				brandList();
			})
		})
	</script>
	
</div>