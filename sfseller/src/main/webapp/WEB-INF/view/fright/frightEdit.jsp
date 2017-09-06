<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<div class="form-info">
    <form class="form-horizontal" id="frightform">
        <input type="hidden" name="id" id="id" value="${freight.id}">
        <div class="form-group">
            <label  class="col-sm-2 control-label">运费模板名称：</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="ffreightName" required minlength="3" value="${freight.ffreightName}" name="ffreightName" placeholder="" style="width:50%;">
            </div>
        </div>

        <div class="form-group">
            <label  class="col-sm-2 control-label">是否包邮：</label>
            <div class="col-sm-10">
                <label class="radio-inline">
                    <input type="radio" name="isFree"  required id="isFree" value="1">  是
                </label>
                <label class="radio-inline">
                    <input type="radio" name="isFree" required id="isFree" value="2">  否
                </label>
            </div>
        </div>
        <div class="form-group">
            <label  class="col-sm-2 control-label">计费规则：</label>
            <div class="col-sm-10">
                <label class="radio-inline">
                    <input type="radio" name="ruleType" required id="ruleType1" value="1">  按件数
                </label>
                <label class="radio-inline">
                    <input type="radio" name="ruleType" required id="ruleType2" value="2">  按重量
                </label>
               <%-- <label class="radio-inline">
                    <input type="radio" name="inlineRadioOptions" id="inlineRadio2" value="option2">  按体积
                </label>--%>
            </div>
        </div>
        <div class="form-group">
            <label  class="col-sm-2 control-label">运送方式：</label>
            <div class="col-sm-10">
                <span class="help-block">除指定地区外，其余地区的运费采用“默认运费”</span>
				
                <div class="col-md-12 oper-area">
                    <span>默认运费：</span>
                    <input type="number" class="form-control inline" required min="1" value="${freight.defaultFirstUnit}" name="defaultFirstUnit" id="defaultFirstUnit"placeholder="" style="width:100px;">
                    <span name="defaultFirstUnitText"><span class="unit">件</span>内，</span>
                    <input type="number" class="form-control inline" required  min="0" value="${freight.defaultFirstMoney}"  name="defaultFirstMoney"id="defaultFirstMoney" placeholder="" style="width:100px;">
                    <span>元，每增加</span>
                    <input type="number" class="form-control inline" required min="1" value="${freight.defaultLastUnit}" name="defaultLastUnit"  id="defaultLastUnit" placeholder="" style="width:100px;">
                    <span name="defaultAddUnitText"><span class="unit">件</span>，增加运费</span>
                    <input type="number" class="form-control inline" required min="0" value="${freight.defaultLastMoney}" name="defaultLastMoney" id="defaultLastMoney"  placeholder="" style="width:100px;">
                    <span>元</span>

                </div>
                <table class="table table-bordered">
                    <thead>
                    <tr>
                        <th>运送到</th>
                        <th width="10%"><span class="unit2">首件(个)</span></th>
                        <th width="10%">运费(元)</th>
                        <th width="10%"><span class="unit3">续件(个)</span></th>
                        <th width="10%">运费(元)</th>
                        <th width="10%">操作</th>
                    </tr>
                    </thead>

                    <tbody  >
                        <tr id="temple" style="display: none">
                            <input type="hidden" name="details1[iii].fid" value="${freight.id}"    >
                            <input type="hidden" name="details1[iii].city"   id="details1iiicity"  >
                            <input type="hidden" name="details1[iii].cityName"  required1 id="details1iiicityName"   labels="details1iiiccityName">
                            <td><div class="area-selected" id="details1iiiccityName" ></div><a   role="button" class="btn right" data-toggle="modal" onclick="check(iii)" >编辑</a></td>
                            <td class="center"><input type="number" class="form-control" required1  min="0" name="details1[iii].firstunit" id="details1[iii].firstunit" placeholder="" style="width:100px;"> </td>
                            <td class="center"><input type="number" class="form-control" required1  min="0" name="details1[iii].firstfee"  id="details1[iii].firstfee"  placeholder="" style="width:100px;"></td>
                            <td class="center"><input type="number" class="form-control" required1  min="0" name="details1[iii].addunit"   id="details1[iii].addunit"   placeholder="" style="width:100px;"></td>
                            <td class="center"><input type="number" class="form-control" required1  min="0" name="details1[iii].addfee"    id="details1[iii].addfee"    placeholder="" style="width:100px;"></td>
                            <td class="center"><a href="javascript:void(0)" onclick="removedetails(this)">删除</a></td>
                        </tr>
                        <c:set var="row" value="0"></c:set>
                        <c:forEach  var="detail" items="${freight.details}" varStatus="status">
                            <c:set var="row" value="${status.index+1}"></c:set>
                            <tr >
                                <input type="hidden" name="details[${status.index}].fid" value="${freight.id}"    >
                                <input type="hidden" name="details[${status.index}].city"  id="details${status.index}city"   value="${detail.city}">
                                <input type="hidden" name="details[${status.index}].cityName" required labels="details${status.index}ccityName"  id="details${status.index}cityName"   value="${detail.cityName}">
                               <%-- <td class="center">${detail.cityName}</td>--%>
                                <td><div class="area-selected" id="details${status.index}ccityName"  >${detail.cityName}</div><a   role="button" class="btn right" data-toggle="modal"  onclick="check(${status.index})" >编辑</a></td>
                                <td class="center"><input type="number" class="form-control"  required min="0" value="${detail.firstunit}"   name="details[${status.index}].firstunit"  id="details[${status.index}].firstunit" placeholder="" style="width:100px;"> </td>
                                <td class="center"><input type="number" class="form-control"  required min="0" value="${detail.firstfee}"   name="details[${status.index}].firstfee"   id="details[${status.index}].firstfee"   placeholder="" style="width:100px;"></td>
                                <td class="center"><input type="number" class="form-control"  required min="0" value="${detail.addunit}"   name="details[${status.index}].addunit"     id="details[${status.index}].addunit"     placeholder="" style="width:100px;"></td>
                                <td class="center"><input type="number" class="form-control"  required min="0" value="${detail.addfee}"   name="details[${status.index}].addfee"       id="details[${status.index}].addfee"       placeholder="" style="width:100px;"></td>
                                <td class="center"><a href="javascript:void(0)" onclick="removedetails(this)" >删除</a></td>
                            </tr>
                        </c:forEach>
                        <tr id="after">
                            <td colspan="6"><a href="javascript:void(0)" id="set">为指定地区城市设置运费</a></td>
                        </tr>
                    </tbody>
                </table>
                <span class="help-block">备注：运费按照商品金额-优惠（直降/单品促销）-返现之后的订单金额收取</span>
            </div>
        </div>

        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <button type="button" id="button" class="btn btn-success btn-lg margin-right30">保 存</button>
                <button type="button" id="back" class="btn btn-default btn-lg">返 回</button>
            </div>
        </div>
    </form>
</div>
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">

    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">×</button>
                <h3>选择区域</h3>
            </div>
            <div class="modal-body">
                <ul class="area-list">
                	<c:forEach items="${citys }" var="item">
                		<li class="col-md-3"> <label class="checkbox-inline"><input type="checkbox" name="city" value="${item.id }" labell="${item.name }"> ${item.name }</label></li>
                	</c:forEach>
                </ul>
            </div>
            <div class="modal-footer">
                <a href="javascript:void(0)" class="btn btn-default" data-dismiss="modal">关闭</a>
                <a href="javascript:void(0)" class="btn btn-primary" data-dismiss="modal" onclick="ok()">保存</a>
            </div>
        </div>
    </div>
</div>
<script type="text/javascript" src="/static/js/validate/jquery.validate.min.js"></script>
<script type="text/javascript" src="/static/js/validate/messages_zh.min.js"></script>
<script>
    $(function(){
        <c:if test="${not empty freight}">
        $("input[name='isFree'][value=${freight.isFree}]").attr("checked",true);
        $("input[name='ruleType'][value=${freight.ruleType}]").attr("checked",true);
        </c:if>
		
        $("input[name='ruleType']").on("click",function(){
        	var type = $(this).val();
        	if(type==1){
        		$("span.unit").html("件");
        		$("span.unit2").html("首件(个)");
        		$("span.unit3").html("续件(个)");
        	}else{
        		$("span.unit").html("kg");
        		$("span.unit2").html("首重(kg)");
        		$("span.unit3").html("续重(kg)");
        	}
        })
        
    });
    var _index=0;
    function ok() {

         var id=[];
        var name=[];
        $("input[name='city']:checkbox:checked").each(function(){
            id.push($(this).val());
            name.push($(this).attr("labell"));
        })

        $("#details"+_index+"city").val(id.join(","));
        $("#details"+_index+"cityName").val(name.join(","));
        $("#details"+_index+"ccityName").html(name.join(","));
    }

    function check(iii){

        _index=iii;
        var _detailcityid=$("#details"+_index+"city").val();
        $("input[name='city']").prop('checked', false);
        if(_detailcityid!=""){
            ccheckbox(_detailcityid);
        }
        $('#myModal').modal('show');
    }
    function ccheckbox(city) {
         var items = city.split(",");
        $.each(items, function (index, item) {
            $("input[name='city']").each(function () {
                if ($(this).val() == item) {
                    $(this).prop('checked', true);
                    return true;
                }
            });
        });


    }
    var _row="<c:out value="${row}"></c:out>";
        $("#button").click(function () {
            if(!$("#frightform").valid()){
                return false;
            }
            var _id=$("#id").val();
            var _url="fright/frightUpdate";
            if(_id==""||_id.length==0){
                _url="fright/frightSave";
            }
            
            $.post(_url,$("#frightform").serialize(),function(data){
                if(data.code==200){
                    layer.msg('保存成功', {
                        icon : 1,
                        time : 1 * 1000
                    },function(){
                        $("#frightList").click();
                    });

                }
                else{
                    layer.msg('保存失败', {
                        icon : 2,
                        time : 1 * 1000
                    });
                }
            });
        });
        $("#set").click(function () {
            var _html="<tr>"+$("#temple").html()+"</tr>";
            _html=_html.replace(/iii/g,_row).replace(/details1/g,"details").replace(/required1/g,"required");
            $("#after").before(_html);
            _row++;
        });
        function removedetails(_this){
            layer.confirm('确认要删除？', {
                btn: ['确认','取消'] //按钮
            }, function(){
                $(_this).parent().parent().remove();
                layer.closeAll();
            }, function(){
                layer.closeAll();
            });

        }
        $("#back").click(function () {
            $("#frightList").click();
        });

    $("#frightform").validate({
        onfocusout : false,
        onkeyup : false,
        onclick : false,
        showErrors: function(errorMap, errorList) {
            var msg = "";
            var a;
            $.each(errorList,function(i,v){
                msg = v.message+"\r\n";
                a = v.element;
                var _labels=$(a).attr("labels");
                 if(i==0)
                        $("html, body").animate({scrollTop: $('#'+a.id).offset().top});

                if(_labels!=""&&_labels!=undefined)
                    a=$('#'+_labels);
                if(msg!=''){
                    layer.tips(msg, a, {
                        tips : [ 1, '#019F95' ],
                        time : 1500,
                        tipsMore: true
                    });
                }
            });
        },
        onfocusout: false
    });


</script>