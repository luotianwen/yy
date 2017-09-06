<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class=" row">
    <div class="box col-md-12">
        <div class="box-inner">
            <div class="box-header well">
                <h2><i class="glyphicon glyphicon-th"></i> 运费模板管理</h2>
            </div>
            <div class="box-content">
                <ul class="nav nav-tabs" id="myTab">
                    <li class="active">
                        <a  id="frightList" href="#frightList1"   data-toggle="tab">运费模板列表</a>
                    </li>
                    <li>
                        <a id="frightEdit" href="#frightEdit1"   data-toggle="tab">新增运费模板</a>
                    </li>
                </ul>

                <div id="myTabContent" class="tab-content">
                    <div class="tab-pane fade in active" id="frightList1" >
                    </div>
                    <div class="tab-pane fade " id="frightEdit1" >
                    </div>

                </div>
            </div>
        </div>

    </div>

</div>

<script type="text/javascript">
    $(function(){
        frightList1();
        $("#myTab").on("click","li",function(){
            if($(this).index()==0){
                frightList1();
            }else{
                frightEdit1();
            }
        })

    })

     function frightList1() {
        $.post("fright/frightList",function(data){
            $("#frightList1").html(data);
        })
    }

     function frightEdit1(id) {
         $.post("fright/frightEdit",{id:id},function(data){
             $("#frightEdit1").html(data);
         })
    }

</script>