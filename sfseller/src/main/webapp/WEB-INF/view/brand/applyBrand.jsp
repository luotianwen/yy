<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<div class="box-content" id="sbd">
	<form class="form-inline" id="brand" style="margin: 20px 0;">
		<div class="form-group">
			<label for="name">品牌名</label>
			<input type="text" class="form-control" id="name" name="name">
		</div>
		<button type="button" class="btn btn-success">查 询</button>
	</form>
	<table class="table table-bordered">
		<thead>
			<tr>
				<th>品牌ID</th>
				<th>品牌名</th>
				<th>品牌LOGO</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody id="searchbrand">
			<td style="text-align: center;" colspan="8">请输入品牌名称进行查找</td>
		</tbody>
	</table>
	<div id="searchPage"></div>
</div>
<div id="editbd"></div>

<script type="text/javascript">
	function applybrand(curr){
		$.post("shopbrand/searchBrand.html?page="+curr,$('#brand').serialize(),function(data){
			var brands = data.brand;
			var html = "";
			if(brands.length>0){
				for(var i=0,len=brands.length;i<len;i++){
					var brand = brands[i];
					html += '<tr>'+
							'	<td class="center">'+brand.id+'</td>'+
							'	<td class="center">'+brand.name+'</td>'+
							'	<td class="center"><img style="width:100px;" src="'+brand.logo+'"></td>'+
							'	<td class="center"><a data_id="'+brand.id+'" id="apply" class="cursor">申请该品牌</a></td>'+
							'</tr>';
				}
			}else{
				html = '<tr><td style="text-align: center;" colspan="8">暂无数据<a class="cursor" id="apply">创建新品牌</a></td></tr>';
			}
			
			$("#searchbrand").html(html);
			var totalPage = data.page.totalPage;
			laypage({
				cont: "searchPage",
				pages: totalPage,
				curr: curr,
				skip: false, //是否开启跳页
		        groups: 5, //连续显示分页数
		        skin: '#18a689',
		        first: 1,
		        prev:"<",
		        next:">",
		        last: totalPage, //在尾页追加总页数。
				jump: function(obj, first){
					if(!first){
						applybrand(obj.curr);
					}
				}
			});
		})
	}
	
	$(function(){
		$("#brand").on("click","button",function(){
			if($("form#brand #name").val().trim()==""){
				layer.tips('请输入要查询的品牌名称！', $("form#brand #name"), {
					tips : [ 1, '#019F95' ],
					time : 1500
				});
				$('form#brand #name').focus();
			}else{
				applybrand(1);
			}
		})
		
		$("#searchbrand").on("click","a#apply",function(){
			var id = $(this).attr("data_id");
			if(id=="undefined"){
				id = "0";
			}
			
			$.post("shopbrand/findBrandById.html",{id:id},function(data){
				$("#sbd").css("display","none");
				$("#editbd").html(data);
			})
		})
		
	})

</script>

