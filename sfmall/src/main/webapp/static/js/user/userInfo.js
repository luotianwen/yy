$(function(){
	var birthday = {
		elem : '#birthday',
		format : 'YYYY-MM-DD',
		istoday : false
	};
	laydate(birthday);
	
	$("#province").on("change",function(){
		var _this = $(this);
		$.post("/getAllCityByPid?pid="+_this.val(),function(data){
			var html = "";
			for(var i=0,len=data.length;i<len;i++){
				if(data[i].id==cityid){
					html += "<option value='"+data[i].id+"' selected>"+data[i].name+"</option>";
				}else{
					html += "<option value='"+data[i].id+"'>"+data[i].name+"</option>";
				}
			}
			$("#city").html(html);
			$("#city").trigger("change");
		})
	});
	$("#city").on("change",function(){
		var _this = $(this);
		$.post("/getAllAreaByCid?cid="+_this.val(),function(data){
			var html = "";
			for(var i=0,len=data.length;i<len;i++){
				if(data[i].id==regionid){
					html += "<option value='"+data[i].id+"' selected>"+data[i].name+"</option>";
				}else{
					html += "<option value='"+data[i].id+"'>"+data[i].name+"</option>";
				}
			}
			_this.next().html(html);
		})
	});
	$("#province").trigger("change");
	
	$("#submit").on("click",function(){
		layer.load(0, {
			shade : 0.3
		});
		$.post("/my/updateUserInfo.html",$("#form").serialize(),function(req){
			layer.closeAll('loading');
			if (req.code == '0') {
				layer.msg('保存成功', {
					icon : 1,
					time : 1 * 1000
				}, function() {
					window.loaction.href = "/my/index.html";
				});
			} else {
				layer.alert(req.msg, {
					icon : 0
				});
			}
		})
	})
	
})