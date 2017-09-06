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

    <title>编辑</title>

    <link href="static/css/bootstrap.min.css" rel="stylesheet">
    <link href="static/css/animate.min.css" rel="stylesheet">
    <link href="static/css/style.min.css" rel="stylesheet">
    <link href="static/css/layerdate/layerdate.css" rel="stylesheet">
    <!-- iCheck -->
    <link href="static/css/plugins/iCheck/custom.css" rel="stylesheet">

</head>

<body class="gray-bg">
<div class="wrapper wrapper-content animated fadeInRight" id="vue">
    <div class="row">
        <div id="user-box" class="col-sm-12">
            <div class="ibox">
                <div class="ibox-content">


                        <div class="table-responsive">
                            <table class="table table-striped">
                                <thead>
                                <tr>
                                    <th colspan="2" class="b-l b-r">
                                        <h4>店铺基本信息</h4>
                                    </th>
                                </tr>
                                </thead>
                                <tbody>
                                <tr>
                                    <td class="tdlm">店铺名称：{{shopinfo!=null?shopinfo.name:''}}</td>
                                    <td class="tdlm">店铺类型：{{shopinfo!=null?shopinfo.grade:''}}</td>
                                </tr>
                                <tr>
                                    <td style="font-size: 12px;">登录帐号：{{shopinfo!=null?shopinfo.account:''}}</td>
                                    <td style="font-size: 12px;">客服电话：{{shopinfo!=null?shopinfo.fax:''}}</td>
                                </tr>
                                </tbody>
                            </table>
                        </div>
                    <div class="hr-line-dashed"></div>
                        <div   class="table-responsive panel panel-default">
                            <table class="table table-condensed">
                                <thead>
                                <tr>
                                    <th colspan="6" class="b-l b-r">
                                        <h4>店铺基本信息</h4>
                                    </th>
                                </tr>
                                <tr>
                                    <th> </th>
                                    <th>店铺负责人</th>
                                    <th>运营联系人</th>
                                    <th>售后联系人</th>
                                    <th>财务联系人</th>
                                    <th>技术负责人</th>
                                </tr>
                                </thead>
                                <tbody v-if="storesupervisors!=null">
                                <tr  >
                                    <td>姓 名</td>
                                    <td>{{storesupervisors[0].name}}</td>
                                    <td>{{storesupervisors[1].name}}</td>
                                    <td>{{storesupervisors[2].name}}</td>
                                    <td>{{storesupervisors[3].name}}</td>
                                    <td>{{storesupervisors[4].name}}</td>
                                </tr>
                                <tr  >
                                    <td>手机号</td>
                                    <td>{{storesupervisors[0].phone}}</td>
                                    <td>{{storesupervisors[1].phone}}</td>
                                    <td>{{storesupervisors[2].phone}}</td>
                                    <td>{{storesupervisors[3].phone}}</td>
                                    <td>{{storesupervisors[4].phone}}</td>
                                </tr>
                                <tr  >
                                    <td>座 机</td>
                                    <td>{{storesupervisors[0].landline}}</td>
                                    <td>{{storesupervisors[1].landline}}</td>
                                    <td>{{storesupervisors[2].landline}}</td>
                                    <td>{{storesupervisors[3].landline}}</td>
                                    <td>{{storesupervisors[4].landline}}</td>
                                </tr>
                                <tr  >
                                    <td>电子邮件</td>
                                    <td>{{storesupervisors[0].email}}</td>
                                    <td>{{storesupervisors[1].email}}</td>
                                    <td>{{storesupervisors[2].email}}</td>
                                    <td>{{storesupervisors[3].email}}</td>
                                    <td>{{storesupervisors[4].email}}</td>
                                </tr>
                                <tr  >
                                    <td>QQ号码</td>
                                    <td>{{storesupervisors[0].qq}}</td>
                                    <td>{{storesupervisors[1].qq}}</td>
                                    <td>{{storesupervisors[2].qq}}</td>
                                    <td>{{storesupervisors[3].qq}}</td>
                                    <td>{{storesupervisors[4].qq}}</td>
                                </tr>
                                </tbody>
                            </table>
                        </div>
                    <div class="hr-line-dashed"></div>
                    <div   class="table-responsive panel panel-default">
                        <table class="table table-condensed">
                            <thead>
                            <tr>
                                <th colspan="5" class="b-l b-r">
                                    <h4>店铺经营类目</h4>
                                </th>
                            </tr>
                            <tr>
                                <th>序号 </th>
                                <th>产品类目</th>
                                <th>类目保证金标准（元）</th>
                                <th>平台使用费</th>
                                <th>扣点</th>
                            </tr>
                            </thead>
                            <tbody v-if="shopcategorys!=null">
                            <tr  v-for="(shopcategory,index) in shopcategorys">
                                <td>{{shopcategory.c_category_id}}</td>
                                <td>{{shopcategory.categoryName}}</td>
                                <td>{{shopcategory.deposit}}</td>
                                <td>{{shopcategory.platformfee}}</td>
                                <td>{{shopcategory.points}}</td>
                            </tr>
                            </tbody>
                        </table>
                    </div>

                    <div class="hr-line-dashed"></div>
                    <div   class="table-responsive panel panel-default">
                        <table class="table table-condensed">
                            <thead>
                            <tr>
                                <th colspan="8" class="b-l b-r">
                                    <h4>品牌信息</h4>
                                </th>
                            </tr>
                            <tr>
                                <th>序号</th>
                                <th>品牌中文名</th>
                                <th>品牌类型</th>
                                <th>商标注册人</th>
                                <th>经营类型</th>
                                <th>品牌logo</th>

                            </tr>
                            </thead>
                            <tbody v-if="brands!=null&&brands.length>0" v-for="brand in brands">
                            <tr >
                                <td>{{brand.id}}</td>
                                <td>{{brand.name}}</td>
                                <td><span v-if="brand.type==1">国际品牌</span>
                                    <span v-else>国内品牌</span>
                                </td>
                                <td><span v-if="brand.trademarktype==1">企业</span>
                                    <span v-else>个人</span> </td>
                                <td><span v-if="brand.businesstype==1">自有品牌</span>
                                    <span v-else>代理品牌</span> </td>
                                <td>
                                <td> <img v-bind:src="brand.logo" /></td>
                            </tr>

                            <tr>
                                <td class="td" colspan="8">品牌介绍</td>
                            </tr>
                            <tr>
                                <td class="td" colspan="8" style="text-align: left"  ><div v-html="brand.descript"></div>
                                </td>
                            </tr>
                            </tbody>
                        </table>
                    </div>
                    <div class="hr-line-dashed"></div>

                    <form id="shopinfo" method="post" class="form-horizontal">
                        <input type="hidden" id="id" name="s_merchants_id" value="${id}"/>



                        <div class="form-group">
                            <div class="col-sm-4 col-sm-offset-2">
                                <button type="button" class="close"
                                        onclick="parent.layer.close(parent.layer.getFrameIndex(window.name))" aria-hidden="true">关闭</button>

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

<script type="text/javascript">
    new Vue({
        el: "#vue",
        data: {shopinfo: null,storesupervisors:null,brands:null,shopcategorys:null},
        mounted: function () {
            var _this = this;
            $.post("shopinfo/findShopinfoById.json?id=" + $("#id").val(), function (data) {
                var grade="【官方旗舰店】";
                if(data.shopinfo.grade==2){
                    grade="【(品牌)授权专卖店】";
                }
                else if(data.shopinfo.grade==3){
                    grade="【品牌专营店】";
                }
                data.shopinfo.grade=grade;
                for (var key in data) {
                    Vue.set(_this.$data, key, data[key]);
                }
            });
            $.post("storesupervisor/findAllStoreSupervisor.json?s_merchants_id=" + $("#id").val(), function (data) {
                if(data.storesupervisors.length>0)
                for (var key in data) {
                    Vue.set(_this.$data, key, data[key]);
                }
            });
            $.post("shopcategory/findAllShopCategory.json?s_merchants_id=" + $("#id").val(), function (data) {
                if(data.shopcategorys.length>0)
                for (var key in data) {
                    Vue.set(_this.$data, key, data[key]);
                }
            });
            $.post("shopbrand/findAllShopBrand.json?s_merchants_id=" + $("#id").val(), function (data) {
                if(data.brands.length>0)
                for (var key in data) {
                    Vue.set(_this.$data, key, data[key]);
                }
            });

        }
    })

</script>


</body>


</html>