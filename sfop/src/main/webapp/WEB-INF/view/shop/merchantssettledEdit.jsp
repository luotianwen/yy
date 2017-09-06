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
<style>
    .table-striped tbody tr td{
        width: 50%;
    }
</style>
</head>

<body class="gray-bg">
<div class="wrapper wrapper-content animated fadeInRight" id="vue">
    <div class="row">
        <div id="user-box" class="col-sm-12">
            <div class="ibox">
                <div class="ibox-content">
                    <div class="form-horizontal">
                        <div class="ico_sh"></div>

                        <div class="order_form">

                            <div class="table-responsive">
                                <table class="table table-striped">
                                    <thead>
                                    <tr>
                                        <th colspan="2" class="b-l b-r">
                                            <h4>入驻基本信息</h4>
                                        </th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <tr>
                                        <td style="font-size: 12px;">负责人姓名： {{merchantssettled!=null?merchantssettled.head_name:''}}</td>
                                        <td style="font-size: 12px;">负责人手机号：{{merchantssettled!=null?merchantssettled.head_phone:''}}</td>
                                    </tr>
                                    <tr>
                                        <td style="font-size: 12px;">负责人邮箱：{{merchantssettled!=null?merchantssettled.head_email:''}}</td>
                                        <td style="font-size: 12px;">公司官网地址：{{merchantssettled!=null?merchantssettled.website:''}}</td>
                                    </tr>

                                    <tr>
                                        <td style="font-size: 12px;">三方平台店铺网址：{{merchantssettled!=null?merchantssettled.onlinestore:''}}</td>
                                        <td style="font-size: 12px;">通过哪种渠道了解到世峰户外商城：{{merchantssettled!=null?merchantssettled.channel:''}}</td>
                                    </tr>
                                    <tr>
                                        <td style="font-size: 12px;">公司类型：{{merchantssettled!=null?merchantssettled.type:''}}</td>
                                        <td style="font-size: 12px;">预合作模式：{{merchantssettled!=null?merchantssettled.cooperation:''}}</td>
                                    </tr>
                                    <tr>
                                        <td style="font-size: 12px;">提交申请操作：{{merchantssettled!=null?merchantssettled.isEntrust:''}}</td>
                                        <td style="font-size: 12px;">授权人手机号：{{merchantssettled!=null?merchantssettled.phone:''}}</td>
                                    </tr>
                                    </tbody>
                                </table>
                            </div>
                            <div class="table-responsive">
                                <table class="table table-striped">
                                    <thead>
                                    <tr>
                                        <th colspan="2" class="b-l b-r">
                                            <h4>公司详细信息</h4>
                                        </th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <tr>
                                        <td style="font-size: 12px;">法定代表人姓名： {{merchantssettled!=null?merchantssettled.legalRepresentative:''}}</td>
                                        <td style="font-size: 12px;">法定代表人手机号：{{merchantssettled!=null?merchantssettled.legalPersonPhone:''}}</td>
                                    </tr>
                                    <tr>
                                        <td style="font-size: 12px;">身份证号：{{merchantssettled!=null?merchantssettled.id_number:''}}</td>
                                        <td style="font-size: 12px;">公司所在地：{{merchantssettled!=null?merchantssettled.companyArea:''}}</td>
                                    </tr>

                                    <tr>
                                        <td style="font-size: 12px;">公司详细地址：{{merchantssettled!=null?merchantssettled.companyAddress:''}}</td>
                                        <td style="font-size: 12px;">公司电话号：{{merchantssettled!=null?merchantssettled.companyPhone:''}}</td>
                                    </tr>
                                    <tr>
                                        <td style="font-size: 12px;">ERP类型：{{merchantssettled!=null?merchantssettled.erptype:''}}</td>
                                        <td style="font-size: 12px;">银行开户名：{{merchantssettled!=null?merchantssettled.bankName:''}}</td>
                                    </tr>
                                    <tr>
                                        <td style="font-size: 12px;">公司银行账号：{{merchantssettled!=null?merchantssettled.bankNum:''}}</td>
                                        <td style="font-size: 12px;">开户银行支行名称：{{merchantssettled!=null?merchantssettled.bankBranchName:''}}</td>
                                    </tr>
                                    <tr>
                                        <td style="font-size: 12px;">开户银行支行所在地：{{merchantssettled!=null?merchantssettled.locationBankbranch:''}}</td>
                                        <td style="font-size: 12px;">纳税人类型：{{merchantssettled!=null?merchantssettled.taxpayerType:''}}</td>
                                    </tr>
                                    <tr>
                                        <td style="font-size: 12px;">纳税类型税码：{{merchantssettled!=null?merchantssettled.taxpayerCoding:''}}%</td>
                                    </tr>
                                    </tbody>
                                </table>
                            </div>
                            <div class="table-responsive">
                                <table class="table table-striped">
                                    <thead>
                                    <tr>
                                        <th colspan="2" class="b-l b-r">
                                            <h4>电子版资质证明</h4>
                                        </th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <tr>
                                        <td style="font-size: 12px;">法人身份证(正面)电子版：<img v-bind:src="merchantssettled!=null?merchantssettled.corporate_front_card:''"> </td>
                                        <td style="font-size: 12px;">法人身份证(反面)电子版：<img v-bind:src="merchantssettled!=null?merchantssettled.corporate_back_card:''"> </td>
                                    </tr>
                                    <tr>
                                        <td style="font-size: 12px;">银行开户许可证电子版：<img v-bind:src="merchantssettled!=null?merchantssettled.bank_image:''"> </td>
                                        <td style="font-size: 12px;" v-if="merchantssettled!=null&&merchantssettled.isThree==1">三证合一电子版：<img v-bind:src="merchantssettled!=null?merchantssettled.threeInOneImage:''"> </td>
                                    </tr>
                                    <tr v-if="merchantssettled!=null&&merchantssettled.isThree==2">
                                        <td style="font-size: 12px;">组织机构代码证电子版：<img v-bind:src="merchantssettled!=null?merchantssettled.organizationImage:''"> </td>
                                        <td style="font-size: 12px;">纳税登记证电子版：<img v-bind:src="merchantssettled!=null?merchantssettled.taxImage:''"> </td>
                                    </tr>
                                    <tr v-if="merchantssettled!=null&&merchantssettled.isThree==2">
                                        <td style="font-size: 12px;">营业执照副本电子版：<img v-bind:src="merchantssettled!=null?merchantssettled.licenseImage:''"> </td>
                                    </tr>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>

                    <form id="merchantssettled" method="post" class="form-horizontal">

                        <input type="hidden" id="id" name="id" value="${id}"/>

                        <div class="hr-line-dashed"></div>
                        <div class="form-group">
                            <label class="col-sm-2 control-label">审核说明</label>
                            <div class="col-sm-10" >
                                <textarea name="note" id="note" rows="5" cols="100"></textarea>
                            </div>
                        </div>


                        <div class="form-group" >
                            <div class="col-sm-4 col-sm-offset-2">
                                <a class="btn btn-primary"  id="submit" @click="pass">通过</a>
                                <a class="btn btn-primary" id="back" @click="back">驳回</a>
                                <a class="btn btn-white" id="cancel"
                                   onclick="parent.layer.close(parent.layer.getFrameIndex(window.name))">取消</a>
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
        data: {merchantssettled: null},
        mounted: function () {
            var _this = this;
            $.post("merchantssettled/findMerchantsSettledById.json?id=" + $("#id").val(), function (data) {
                var channel="推荐";
                var type="生产厂商";
                var cooperation="代销";
                var isEntrust="亲自提交";
                var erptype="自有ERP";
                var taxpayerType="一般纳税人";
                if(data.merchantssettled.taxpayerType==2){
                    taxpayerType="小规模纳税人";
                }
                else if(data.merchantssettled.taxpayerType==3){
                    taxpayerType="非增值税纳税人";
                }
                if(data.merchantssettled.isEntrust==1){
                    isEntrust="委托";
                }
                if(data.merchantssettled.erptype==2){
                    erptype="第三方ERP代运营";
                }
                else if(data.merchantssettled.erptype==3){
                    erptype="无";
                }
                if(data.merchantssettled.cooperation==2){
                    cooperation="入驻";
                }
                switch(data.merchantssettled.channel)
                {
                    case 2:
                        channel="广告";
                        break;
                    case 3:
                        channel="展会";
                        break;
                    case 4:
                        channel="搜索引擎";
                        break;
                    case 5:
                        channel="论坛";
                        break;
                    case 6:
                        channel="微博";
                        break;
                    case 7:
                        channel="微信";
                        break;
                }
                switch(data.merchantssettled.type)
                {
                    case 2:
                        channel="品牌商";
                        break;
                    case 3:
                        channel="中国总代";
                        break;
                    case 4:
                        channel="地区总代";
                        break;
                    case 5:
                        channel="代运营商";
                        break;
                    case 6:
                        channel="经销商";
                        break;

                }
                data.merchantssettled.erptype=erptype;
                data.merchantssettled.isEntrust=isEntrust;
                data.merchantssettled.cooperation=cooperation;
                data.merchantssettled.type=type;
                data.merchantssettled.channel=channel;
                for (var key in data) {
                        Vue.set(_this.$data, key, data[key]);
                }
            })
        },
        methods: {
            pass: function () {
                var id = $("#id").val();
                var note = $("#note").val();
                var url = "merchantssettled/passMerchantsSettled.json";
                $.post(url, {id: id, note: note}, function (data) {
                    if (data.RESPONSE_STATE == '200') {
                        layer.msg('审核成功', {
                            icon: 1,
                            time: 1 * 1000
                        }, function () {
                            parent.self.location.reload();
                        });
                    } else {
                        layer.closeAll('loading');
                        layer.alert(data.ERROR_INFO, {
                            icon: 0
                        });
                    }
                });
            }
            , back: function () {
                var id = $("#id").val();
                var note = $("#note").val();
                if(note.trim().length<1){
                    layer.alert("驳回理由必填", {
                        icon: 0
                    });
                    return false;
                }
                var url = "merchantssettled/backMerchantsSettled.json";
                $.post(url, {id: id, note: note}, function (data) {
                    if (data.RESPONSE_STATE == '200') {
                        layer.msg('驳回成功', {
                            icon: 1,
                            time: 1 * 1000
                        }, function () {
                            parent.self.location.reload();
                        });
                    } else {
                        layer.closeAll('loading');
                        layer.alert(data.ERROR_INFO, {
                            icon: 0
                        });
                    }
                });
            }
        }
    })

</script>


</body>


</html>