<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<div class="box-content">
    <c:forEach  var="fright" items="${frights}">
    <div class="col-md-12 oper-area">
        <h4>${fright.ffreightName}</h4>
        <div class="fright">
            <span class="margin-right10">最后编辑时间：<fmt:formatDate value="${fright.lasttime}" pattern="yyyy/MM/dd HH:mm:ss" /></span>
            <a style="cursor: pointer" onclick="update(${fright.id})" class="margin-right10">修改</a>
            <a style="cursor: pointer" onclick="del(${fright.id})" >删除</a>
        </div>
    </div>
    <table class="table table-bordered">
        <thead>
        <tr>
            <th>运送方式</th>
            <th>运送到</th>
            <th>首重(kg)</th>
            <th>运费(元)</th>
            <th>续重(kg)</th>
            <th>运费(元)</th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <td>快递</td>
            <td class="center">未被划分的配送地区自动归于默认运费 </td>
            <td class="center">${fright.defaultFirstUnit}</td>
            <td class="center">${fright.defaultFirstMoney}</td>
            <td class="center">${fright.defaultLastUnit} </td>
            <td class="center">${fright.defaultLastMoney} </td>
        </tr>
        <c:forEach  var="detail" items="${fright.details}">
            <tr>
                <td>快递</td>
                <td class="center">${detail.cityName}</td>
                <td class="center">${detail.firstunit}</td>
                <td class="center">${detail.firstfee}</td>
                <td class="center">${detail.addunit} </td>
                <td class="center">${detail.addfee} </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    </c:forEach>
</div>
<script>
    function del(id) {
        layer.confirm('确认要删除？', {
            btn: ['确认','取消'] //按钮
        }, function(){
            $.post("fright/frightDel",{id:id},function(data){
                if(data.code==200){
                    layer.msg('删除成功', {
                        icon : 1,
                        time : 1 * 1000
                    });
                }
                else{
                    layer.msg('删除失败', {
                        icon : 1,
                        time : 1 * 1000
                    });
                }
                $("#frightList").click();
            })
            layer.closeAll();
        }, function(){
            layer.closeAll();
        });

    }
    function update(id) {
        frightEdit1(id);
        $('#myTab a:last').tab('show');
    }
</script>