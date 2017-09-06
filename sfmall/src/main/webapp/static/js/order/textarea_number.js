$(function(){
	$(".form-control").on("input",function(){
		var _this = $(this);
		var val = _this.val();
		var str = "";
		str = val.replaceAll("\n","占位");
		if(str.length>500){
			_this.val(_this.val().substr(0,(500+val.length-str.length)));
			str = _this.val().replaceAll("\n","占位");
		}
		
		var maxlength = _this.prop("maxlength"),
			residueNum = str.length;
		if(residueNum>500){
			residueNum = 500;
		}
		
		_this.next().html("<b>"+residueNum+"</b>/500");
		
	})
})

//批量替换
String.prototype.replaceAll = function(reallyDo, replaceWith, ignoreCase) {  
	if (!RegExp.prototype.isPrototypeOf(reallyDo)) {  
		return this.replace(new RegExp(reallyDo, (ignoreCase ? "gi": "g")), replaceWith);  
	} else {  
		return this.replace(reallyDo, replaceWith);  
	}  
}