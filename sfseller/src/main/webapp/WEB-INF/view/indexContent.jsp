<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- content starts -->
<div class="statusBox">
    <ul>
        <li><span>商铺状态：</span><strong class="fgreen">正常</strong></li>
        <li><span>入驻时间：</span><strong>2014年09月03日</strong></li>
        <li><span>到期时间：</span><strong>2020年03月22日</strong></li>
        <li><span>剩余天数：</span><strong>1109天 </strong></li>
        <li><span>如有疑问请致电商城客服电话：</span><strong class="fgreen">400-0928-400</strong></li>
    </ul>
</div>
<div class=" row">
    <div class="col-md-3 col-sm-3 col-xs-6" style="width:300px;">
        <div class="box-inner">
            <div class="box-header well" data-original-title="">
                <h2><i class="glyphicon glyphicon-list-alt"></i> 订单</h2>
            </div>
            <div class="box-content">
                <a href="#" class="order-total">待发货订单：<span>（0）</span></a>
              <%--  <a href="#" class="order-total">协商再投订单：<span>（0）</span></a>
                <a href="#" class="order-total">待回复催单：<span>（0）</span></a>--%>
            </div>
        </div>
    </div>

    <div class="col-md-3 col-sm-3 col-xs-6" style="width:300px;">
        <div class="box-inner">
            <div class="box-header well" data-original-title="">
                <h2><i class="glyphicon glyphicon-credit-card"></i> 结算</h2>
            </div>
            <div class="box-content">
                <a href="#" class="order-total">待支付：<span>（0）</span></a>
               <%-- <a href="#" class="order-total">待结算确认：<span>（0）</span></a>
                <a href="#" class="order-total">财务待处理任务：<span>（0）</span></a>--%>
            </div>
        </div>
    </div>

    <div class="col-md-3 col-sm-3 col-xs-6" style="width:300px;">
        <div class="box-inner">
            <div class="box-header well" data-original-title="">
                <h2><i class="glyphicon glyphicon-send"></i> 售后</h2>
            </div>
            <div class="box-content">
                <a href="#" class="order-total">待处理售后单：<span>（0）</span></a>
                <a href="#" class="order-total">待处理赔付单：<span>（0）</span></a>
                <a href="#" class="order-total">待退款审核：<span>（0）</span></a>
                <%--<a href="#" class="order-total">待处理投诉单：<span>（0）</span></a>
                <a href="#" class="order-total">待处理举报单：<span>（0）</span></a>--%>
            </div>
        </div>
    </div>

</div>

<div class="row">
    <div class="box col-md-12">
        <!--<div class="date-header">
 <i></i> 今日店铺数据
</div>-->
        <div class="box-inner">
            <div class="box-header well" data-original-title="">
                <h2><i class="glyphicon glyphicon-stats"></i> 今日店铺数据 </h2>
            </div>
            <div class="box-content row">
                <ul class="date-list">
                    <%--<li>
                        <P class="p1">浏览量</P>
                        <P class="p2">84</P>
                        <P class="p3">昨天：<span>1633</span></P>
                        <P class="p3">本月：<span>27914</span></P>
                    </li>
                    <li>
                        <P class="p1">访客数（PC）</P>
                        <P class="p2">84</P>
                        <P class="p3">昨天：<span>1633</span></P>
                        <P class="p3">本月：<span>27914</span></P>
                    </li>--%>
                    <li>
                        <P class="p1">下单单量</P>
                        <P class="p2">84</P>
                        <P class="p3">昨天：<span>1633</span></P>
                        <P class="p3">本月：<span>27914</span></P>
                    </li>
                    <li>
                        <P class="p1">下单金额</P>
                        <P class="p2">149.00</P>
                        <P class="p3">昨天：<span>1633</span></P>
                        <P class="p3">本月：<span>27914</span></P>
                    </li>
                    <li>
                        <P class="p1">下单商品件数</P>
                        <P class="p2">84</P>
                        <P class="p3">昨天：<span>1633</span></P>
                        <P class="p3">本月：<span>27914</span></P>
                    </li>
                </ul>

            </div>
        </div>
    </div>
</div>

<div class="row">
    <div class="box col-md-4">
        <div class="box-inner">
            <div class="box-header well" data-original-title="">
                <h2><i class="glyphicon glyphicon-glass"></i>单品销售排行 TOP8</h2>
            </div>
            <div class="box-content">
                <table class="table">
                    <thead>
                    <tr>
                        <th>排名</th>
                        <th>商品编号</th>
                        <th>商品名称</th>
                        <th>销售量</th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                        <td>1</td>
                        <td class="center">2760</td>
                        <td class="center">邮费链接，非卖家勿拍，单拍不发货</td>
                        <td class="center">1000</td>
                    </tr>

                    </tbody>
                </table>
            </div>
        </div>
    </div>
    <div class="box col-md-4">
        <div class="box-inner">
            <div class="box-header well" data-original-title="">
                <h2><i class="glyphicon glyphicon-stats"></i> 销售情况</h2>
            </div>
            <div class="box-content">
                <table class="table">
                    <thead>
                    <tr>
                        <th>项目</th>
                        <th>订单量</th>
                        <th>订单金额</th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                        <td>今日销量</td>
                        <td class="center"><span class="fred">0</span> 笔</td>
                        <td class="center"><span class="fred">¥190.00</span></td>
                    </tr>
                    <tr>

                        <td class="center">本月销量</td>
                        <td class="center"><span class="fred">3</span> 笔</td>
                        <td class="center"><span class="fred">¥1900.00</span></td>
                    </tr>
                    <tr>

                        <td class="center">全年销量</td>
                        <td class="center"><span class="fred">50</span> 笔</td>
                        <td class="center"><span class="fred">¥19000.00</span></td>
                    </tr>

                    </tbody>
                </table>
            </div>
        </div>
    </div>
    <div class="box col-md-4">
        <div class="box-inner">
            <div class="box-header well">
                <h2><i class="glyphicon glyphicon-bell"></i> 最新通知</h2>

            </div>
            <div class="box-content">
                <ul class="nav nav-tabs" id="myTab">
                    <li class="active">
                        <a href="#info">最新通知</a>
                    </li>
                    <li>
                        <a href="#custom">最新发布功能</a>
                    </li>
                    <li>
                        <a href="#messages">站内消息</a>
                    </li>
                </ul>

                <div id="myTabContent" class="tab-content">
                    <div class="tab-pane active" id="info">

                        <div class="box-content">
                            <table class="table">
                                <tbody>
                                <tr>
                                    <td>世峰社区（BBS）版主招募正式启动！！！</td>
                                    <td class="center">2015年3月05日</td>
                                </tr>
                                <tr>
                                    <td>世峰社区（BBS）版主招募正式启动！！！</td>
                                    <td class="center">2015年3月05日</td>
                                </tr>
                                <tr>
                                    <td>世峰社区（BBS）版主招募正式启动！！！</td>
                                    <td class="center">2015年3月05日</td>
                                </tr>

                                </tbody>
                            </table>

                        </div>
                    </div>
                    <div class="tab-pane" id="custom">
                        <div class="box-content">
                            <table class="table">
                                <tbody>
                                <tr>
                                    <td>世峰社区版主招募正式启动！！！</td>
                                    <td class="center">2015年3月05日</td>
                                </tr>
                                <tr>
                                    <td>世峰社区（BBS）版主招募正式启动！！！</td>
                                    <td class="center">2015年3月05日</td>
                                </tr>
                                <tr>
                                    <td>世峰社区（BBS）版主招募正式启动！！！</td>
                                    <td class="center">2015年3月05日</td>
                                </tr>

                                </tbody>
                            </table>

                        </div>
                    </div>
                    <div class="tab-pane" id="messages">
                        <div class="box-content">
                            <table class="table">
                                <tbody>
                                <tr>
                                    <td>世峰社区（BBS）版主招募正式启动！！！</td>
                                    <td class="center">2015年3月05日</td>
                                </tr>
                                <tr>
                                    <td>世峰社区（BBS）版主招募正式启动！！！</td>
                                    <td class="center">2015年3月05日</td>
                                </tr>
                                <tr>
                                    <td>世峰社区（BBS）版主招募正式启动！！！</td>
                                    <td class="center">2015年3月05日</td>
                                </tr>

                                </tbody>
                            </table>

                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

</div>

