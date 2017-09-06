<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
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

    <title>商城后台 - 管理</title>

    <link href="static/css/bootstrap.min.css" rel="stylesheet">
    <link href="static/css/font-awesome.min.css" rel="stylesheet">
    <!-- iCheck -->
    <link href="static/css/plugins/iCheck/custom.css" rel="stylesheet">
    <link href="static/css/animate.min.css" rel="stylesheet">
    <link href="static/css/style.min.css" rel="stylesheet">

</head>

<body class="gray-bg">
<div class="wrapper wrapper-content  animated fadeInRight" id="vue">
    <div class="row">
        <div id="user-box" class="col-sm-12">
            <div class="ibox">
                <form id="shopbrand" method="post">
                    <div class="ibox-content">
                        <input type="hidden" name="s_merchants_id" id="s_merchants_id" value="${s_merchants_id}">

                        <div class="hr-line-dashed"></div>
                        <div class="tab-content">
                            <div class="tab-pane active">
                                <div class="full-height-scroll">
                                    <div class="table-responsive">
                                        <h4>全部品牌</h4>
                                        <ul id="temp">

                                        </ul>

                                    </div>
                                </div>
                                <div class="ibox-content">

                                        <button type="button" id="add" @click="add" class="btn btn-sm btn-primary">
                                            <i class="fa fa-plus"></i> 保存
                                        </button>

                                </div>
                            </div>

                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>

<!-- 全局js -->
<script src="static/js/vue.js"></script>
<script src="static/js/jquery-2.1.1.min.js"></script>
<script src="static/js/bootstrap.min.js"></script>
<script src="static/js/plugins/layer/layer.min.js"></script>
<script src="static/js/plugins/layer/laypage/laypage.js"></script>
<script src="static/js/plugins/slimscroll/jquery.slimscroll.min.js"></script>

<!-- iCheck -->
<script src="static/js/plugins/iCheck/icheck.min.js"></script>

<script type="text/javascript">
    new Vue({
        el: "#vue",
        data: {brands: null,brandshop:[]},
        mounted: function () {
            var _this = this;
            Vue.nextTick(function () {
                _this.submit();
            })

        },
        methods: {
            submit: function () {
                var _this = this;
                _this.$brandshop=[];
                $.post("shopbrand/findAllShopBrandByShop.json?pageSize=10000",$('#shopbrand').serialize(),function(data) {
                     var check="";
                    var _html="";
                    var _head='<li style="width: 25%;float: left;height: 30px;list-style: none"  >';
                    var _fot='</li>';
                    data["brands"].forEach(function (item) {
                        _html="<input type='checkbox'    name='brands' _checked value='_value' />_name";
                        _html=_html.replace("_value",item.b_brand_id);
                        _html=_html.replace("_name",item.name);
                        if(item.s_merchants_id>0){
                            _html=_html.replace("_checked","checked");
                        }
                        check+=_head+_html+_fot;
                    });
                    $("#temp").html(check);

                })
            },
            add: function () {
                var brandshops = [];
                $('input:checkbox[name=brands]:checked').each(function(i){
                        brandshops.push($(this).val()) ;
                });
                var s_merchants_id=$("#s_merchants_id").val();


                    $.post("shopbrand/saveShopBrand.json", {s_merchants_id:s_merchants_id,b_brand_id:brandshops.join()}, function (data) {
                        if (data.RESPONSE_STATE == '200') {
                            layer.msg('品牌设置成功', {
                                icon : 1,
                                time : 1 * 1000
                            }, function() {
                                parent.layer.closeAll();
                            });

                        } else {
                            layer.closeAll('loading');
                            layer.alert(data.ERROR_INFO, {
                                icon: 0
                            });
                        }
                    })

            }
        }
    })

    $(function () {
        $(".full-height-scroll").slimScroll({
            height: "100%"
        });

        //设置本页layer皮肤
        layer.config({
            skin: 'layui-layer-molv',
        });
    });
</script>


</body>


</html>