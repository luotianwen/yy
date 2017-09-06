<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>支付</title>
<style>
html, body, div, span, applet, object, iframe, h1, h2, h3, h4, h5, h6, p, blockquote, pre, a, abbr, acronym, address, big, cite, code, del, dfn, em, font, img, ins, kbd, q, s, samp, small, strike, strong, sub, sup, tt, var, b, i, center, dl, dt, dd, ol, ul, li, fieldset, form, label, legend, table, caption, tbody, tfoot, thead, tr, th, td, article, aside, audio, canvas, details, figcaption, figure, footer, header, hgroup, mark, menu, meter, nav, output, progress, section, summary, time, video {
	margin: 0;
	padding: 0;
}
.ui-dialog {
	overflow: hidden;
	top: 0px;
	left: 0px;
	background: #fff;
	box-shadow: 0px 0px 8px rgba(0,0,0,0.35);
	outline: none;
	position: absolute;
}
:focus {
	-moz-outline-style: none;
}
.ui-widget-content {
	border: none;
	background: #fff;
}
.ui-dialog .ui-dialog-content {
	position: relative;
	border: 0;
	background: none;
	overflow: auto;
	padding: 10px 16px;
}
.ui-front {
	z-index: 100;
}
.ui-dialog {
	overflow: hidden;
	top: 0px;
	left: 0px;
	background: #fff;
	box-shadow: 0px 0px 8px rgba(0,0,0,0.35);
	outline: none;
	position: absolute;
}
.ui-widget {
	border: 1px solid #ccc\0;
}
body {
	font: 12px/1.5 "Microsoft Yahei",verdana;
	background: #fff;
	height: 100%;
	min-width: 1267px;
}
html, body {
	overflow-y: hidden;
	height: 100%;
}
.yp-pay-wrap .yp-pay-msg {
	padding: 20px 35px 0;
	*position:relative: ;
	*zoom:1: ;
}
.yp-pay-way {
	padding: 0 35px;
	*position:relative: ;
	*zoom:1: ;
}
.yp-pay-way .pay-way-hd {
	background: #f2f6fd;
	border: 1px solid #dedede;
}
.clearfix {
	zoom: 1;
}
.alipay {
	background: url(https://p.ssl.qhimg.com/t01566153e16510a6c0.png) repeat-y center;
}
.clearfix::after {
	content: ".";
	display: block;
	height: 0px;
	clear: both;
	visibility: hidden;
}
.yp-pay-way .pay-way-bd {
	margin: 25px 0;
}
.bank-payway .bank-payway-btm {
	margin-top: 20px;
}
.bank-payway .bank-payway-btm .btn-wrap {
	margin-top: 0px;
}
.y-btn {
	display: inline-block;
	min-width: 47px;
	height: 16px;
	overflow: hidden;
	padding: 6px 14px;
	border-radius: 2px;
	border-width: 1px;
	border-style: solid;
	border-color: #bbcbdf;
	background: #fff;
	color: #536083;
	font-size: 12px;
	font-family: "Microsoft Yahei";
	cursor: pointer;
	-moz-user-select: none;
	-webkit-user-select: none;
	-ms-user-select: none;
	-khtml-user-select: none;
	user-select: none;
	text-align: center;
}
.y-btn-blue {
	background-color: #06b639;
	border-color: #05A433;
	color: #fff;
}
.yp-pay-way .y-btn {
	width: 150px;
	height: 30px;
	line-height: 30px;
	font-size: 18px;
}
.y-btn .icon, .y-btn .label {
	float: left;
	overflow: hidden;
}
.y-btn .label {
	height: 16px;
	line-height: 30px;
	white-space: nowrap;
	text-align: center;
}
.yp-pay-way .y-btn .label {
	float: none;
}
li {
	list-style: none;
}
.bank-payway .back-list li {
	position: relative;
	float: left;
	width: 92px;
	height: 30px;
	padding-left: 11px;
	background: #fff;
	margin: 1px 11px 11px 1px;
	border: 1px solid #e3e3e3;
	line-height: 30px;
	cursor: pointer;
}
.bank-payway .back-list .current {
	border: 2px solid #f59c3c;
	margin: 0 10px 10px 0;
}
.bank-payway .back-list .ebank-ico {
	border-color: #fff;
	width: 119px;
	height: 32px;
	background: url(https://p.ssl.qhimg.com/t01e38c3c4783fc00b6.png) no-repeat;
	vertical-align: middle;
}
.bank-payway .back-list .ebank-ico.current {
	border: 2px solid #f59c3c;
	margin: 0 10px 10px 0;
}
.bank-payway .back-list .ebank-ico02 {
	background-position: 0 -35px;
}
.bank-payway .back-list .ebank-ico03 {
	background-position: 0 -70px;
}
.bank-payway .back-list .ebank-ico04 {
	background-position: 0 -105px;
}
.bank-payway .back-list .ebank-ico05 {
	background-position: 0 -140px;
}
.bank-payway .back-list .ebank-ico06 {
	background-position: 0 -175px;
}
.bank-payway .back-list .ebank-ico07 {
	background-position: 0 -215px;
}
.bank-payway .back-list .ebank-ico08 {
	background-position: 0 -245px;
}
.bank-payway .back-list .back-operate {
	border: 1px dashed #c7c7c7;
}
.yp-pay-way .pay-way-tit .icon-payway, .yp-pay-wrap .pay-sel-list .sel-item .right, .quantity .btn, .bank-payway .back-list .corner-right, .yp-pay-fdback .fdback-result .icon-fdback, .yp-pay-way .pay-way-tit .recom {
	background: url(https://p.ssl.qhimg.com/t01110d6d8fb4940427.png) no-repeat;
}
.bank-payway .back-list .corner-right {
	display: none;
	position: absolute;
	bottom: -1px;
	right: -1px;
	width: 18px;
	height: 18px;
	background-position: -231px 0;
}
.bank-payway .back-list .current .corner-right {
	display: block;
}
.bank-payway .back-list .ebank-ico .corner-right {
	bottom: -2px;
	background-position: -231px 0;
}
.bank-ico {
	display: inline-block;
	width: 22px;
	height: 22px;
	margin-right: 4px;
	background: url(https://p.ssl.qhimg.com/t01ef1eea3c8110030c.png) no-repeat;
	vertical-align: middle;
	margin-top: -3px;
}
.ico-14, .ico-pab {
	width: 26px;
	margin-right: 0px;
	background-position: 0 -325px;
}
.ico-17, .ico-nbcb {
	background-position: 0 -400px;
}
.ico-18 {
	background-position: 0 -425px;
}
.ico-19, .ico-bob {
	background-position: 0 -450px;
}
.ico-11, .ico-cmbc {
	background-position: 0 -250px;
}
.ico-16, .ico-cib {
	width: 26px;
	margin-right: 0px;
	background-position: 0 -375px;
}
.ico-07, .ico-citic {
	background-position: 0 -150px;
}
.ico-05, .ico-hxb {
	background-position: 0 -100px;
}
.ico-13, .ico-gdb {
	background-position: 0 -300px;
}
.ico-10, .ico-ceb {
	background-position: 0 -225px;
}
.ico-20 {
	background-position: 0 -475px;
}
.ico-15, .ico-spdb {
	background-position: 0 -350px;
}
.ico-04, .ico-psbc {
	background-position: 0 -75px;
}
.ico-09, .ico-boc {
	background-position: 0 -200px;
}
.ico-03, .ico-bcom {
	background-position: 0 -50px;
}
.ico-02, .ico-abc {
	background-position: 0 -25px;
}
.ico-08, .ico-cmb {
	background-position: 0 -175px;
}
.ico-06, .ico-ccb {
	background-position: 0 -125px;
}
.ico-01, .ico-icbc {
	background-position: 0 0;
}
.yp-pay-way .alipay .pay-way-item {
	float: left;
	width: 49.9%;
}
.yp-pay-way .pay-way-tit {
	text-align: center;
}
.yp-pay-way .pay-way-main {
	margin-top: 15px;
}
.ta-c {
	text-align: center;
}
.yp-pay-way .ali-webpay {
	text-align: center;
	padding: 36px 0;
}
fieldset, img {
	border: 0;
}
a img, img {
	-ms-interpolation-mode: bicubic;
}
img {
	vertical-align: middle;
}
.yp-pay-way .pay-way-tit .icon-payway {
	display: inline-block;
	vertical-align: middle;
	width: 42px;
	height: 42px;
	margin-right: 5px;
}
.yp-pay-way .pay-way-tit .alipay-way {
	background-position: -65px 0;
}
.yp-pay-way .pay-way-tit .txt {
	display: inline-block;
	vertical-align: middle;
	text-align: left;
	*display:inline: ;
	*zoom:1: ;
}
h1, h2, h3, h4, h5, h6 {
	font-size: 100%;
}
.yp-pay-way .pay-way-tit .payway-name {
	font-weight: 400;
}
.gray {
	color: #999 !important;
}
.yp-pay-way .pay-way-tit .name {
	font-size: 16px;
	color: #333;
}
.yp-pay-way .pay-way-tit .way-item {
	font-size: 16px;
	font-weight: 400;
}
.yp-pay-way .pay-code {
	width: 160px;
	padding: 9px;
	margin: 0 auto;
	border: 1px solid #e2e2e2;
	text-align: center;
}
.yp-pay-way .pay-code img {
	width: 160px;
	height: 160px;
}
.yp-pay-way .pay-code .code-txt {
	margin-top: 10px;
}
.yp-pay-way .pay-way-tit .recom {
	display: inline-block;
	vertical-align: middle;
	width: 27px;
	height: 18px;
	color: #fff;
	padding-left: 5px;
	text-align: center;
	font-weight: 400;
	font-size: 12px;
	background-position: -156px 0;
}
.yp-pay-way .pay-way-tit .weixin-way {
	background-position: -65px -42px;
}
.pay-tab-menu li {
	position: relative;
	float: left;
	border-right: 1px solid #dedede;
}
.pay-tab-menu .current {
	border-bottom: 1px solid #fff;
	margin-bottom: -1px;
}
.pay-tab-menu .current::after {
	content: "";
	position: absolute;
	top: -1px;
	left: 0px;
	right: 0px;
	height: 2px;
	background: #06b639;
}
a {
	color: #333;
	text-decoration: none;
	outline: none;
	cursor: pointer;
}
:focus {
	-moz-outline-style: none;
}
.pay-tab-menu a {
	display: block;
	width: 120px;
	height: 37px;
	line-height: 37px;
	text-align: center;
	color: #333;
	font-size: 16px;
	_float: left;
}
.pay-tab-menu .current a {
	background: #fff;
	color: #111;
}
.pay-top-msg {
	text-align: center;
	height: 25px;
	margin-top: -20px;
}
.yp-pay-wrap .pay-msg-item {
	position: relative;
	padding-bottom: 15px;
}
.yp-pay-wrap .pay-msg-item::after {
	content: ".";
	display: block;
	height: 0px;
	clear: both;
	visibility: hidden;
}
.yp-pay-wrap .pay-msg-item .tit {
	float: left;
	width: 78px;
	color: #333;
	line-height: 24px;
}
.yp-pay-wrap .pay-msg-item .txt {
	float: left;
	width: 580px;
	color: #333;
	line-height: 24px;
}
.yp-pay-wrap .pay-msg-item .package-money {
	font-size: 16px;
}
.orange {
	color: #ff750f !important;
}
.yp-pay-wrap .pay-msg-item .package-detail-info {
	border: 1px solid #e9e9e9;
	border-radius: 5px;
	width: auto;
}
address, caption, cite, code, dfn, em, th, var, optgroup {
	font-style: normal;
	font-weight: 400;
}
.package-detail-info .js_package_name {
	padding: 0 5px;
}
.package-detail-info span {
	border-left: 2px solid #e9e9e9;
	padding: 0 5px;
	font-weight: 800;
}
.package-detail-info span em {
	font-weight: 800;
}
.yp-pay-wrap .pay-msg-item .sel-tit {
	line-height: 52px;
}
.yp-pay-wrap .pay-sel-list .sel-item {
	float: left;
	position: relative;
	width: 120px;
	height: 20px;
	margin-right: 15px;
	padding: 14px 0;
	border: 2px solid #e9e9e9;
	border-radius: 5px;
	cursor: pointer;
	line-height: 20px;
	background: #fff;
}
.yp-pay-wrap .pay-sel-list .current {
	border-color: #ff5825;
}
.yp-pay-wrap .pay-sel-list .sel-item .price {
	float: left;
	width: 70px;
	text-align: center;
	font-size: 18px;
	line-height: 20px;
	color: #ff5825;
	font-weight: 700;
	font-family: Arial;
}
.yp-pay-wrap .pay-sel-list .sel-item .time {
	display: block;
	width: 45px;
	border-left: 2px solid #e9e9e9;
	text-align: center;
	overflow: hidden;
	zoom: 1;
}
.yp-pay-wrap .pay-sel-list .sel-item .right {
	display: none;
	position: absolute;
	right: -10px;
	bottom: -10px;
	width: 22px;
	height: 22px;
	background-position: -199px 0;
}
.yp-pay-wrap .pay-sel-list .current .right {
	display: block;
}
.pay-star {
	position: absolute;
	left: -9px;
	top: 0px;
	font-size: 20px;
	font-weight: 700;
}
.pay-top-msg .txt {
	background-color: #fffcde;
	border: 1px solid #f2dfc2;
	margin: auto;
	padding: 8px 45px;
}

/**********************************/
.yp-pay-fdback {
	padding: 50px 160px;
}
.yp-pay-fdback .fdback-result {
	font-size: 36px;
	color: #333;
	text-align: center;
}
.buy-fail-fdback {
	padding: 25px 0;
	text-align: center;
	font-size: 18px;
}
.ta-c {
	text-align: center;
}
.yp-pay-fdback .btn-wrap {
	margin-top: 30px;
}
a {
	color: #333;
	text-decoration: none;
	outline: none;
	cursor: pointer;
}
.y-btn {
	display: inline-block;
	min-width: 47px;
	height: 16px;
	overflow: hidden;
	padding: 6px 14px;
	border-radius: 2px;
	border-width: 1px;
	border-style: solid;
	border-color: #bbcbdf;
	background: #fff;
	color: #536083;
	font-size: 12px;
	font-family: "Microsoft Yahei";
	cursor: pointer;
	-moz-user-select: none;
	-webkit-user-select: none;
	-ms-user-select: none;
	-khtml-user-select: none;
	user-select: none;
	text-align: center;
}
.y-btn-gray {
	background-image: -webkit-linear-gradient(bottom, rgb(245, 249, 252), rgb(255, 255, 255));
	background-image: -moz-linear-gradient(bottom,#f5f9fc,#fff);
	background-image: -o-linear-gradient(bottom,#f5f9fc,#fff);
	background-image: linear-gradient(to top, rgb(245, 249, 252), rgb(255, 255, 255));
	filter: progid:DXImageTransform.Microsoft.gradient( startColorstr='#ffffff', endColorstr='#f5f9fc',GradientType=0 );
}
.y-btn-blue {
	background-color: #06b639;
	border-color: #05A433;
	color: #fff;
}
.yp-pay-fdback .y-btn {
	width: 300px;
	height: 30px;
	line-height: 30px;
	font-size: 18px;
}
.yp-pay-fdback .btns-wrap .y-btn {
	width: 120px;
	margin: 0 10px;
}
.y-btn .icon, .y-btn .label {
	float: left;
	overflow: hidden;
}
 
.yp-pay-fdback .y-btn .label {
	float: none;
	text-align: center;
}
.lnk {
	color: #237cd8;
}
 
.yp-pay-fdback .fdback-result .icon-fdback {
	display: inline-block;
	vertical-align: middle;
	width: 55px;
	height: 55px;
}
.yp-pay-fdback .fdback-result .icon-error {
	background-position: 0 -110px;
}


</style>
<script type="text/javascript" src="http://apps.bdimg.com/libs/jquery/1.8.0/jquery.js"></script>
</head>
 
<body>

	<div tabindex="-1"
		class="ui-dialog ui-widget ui-widget-content ui-corner-all ui-front ui-draggable"
		role="dialog" aria-describedby="js_pay_panel"
		aria-labelledby="ui-id-4"
		 >
		<div class="ui-dialog-content ui-widget-content" id="js_pay_panel"
			style="width: auto; height: 613px; min-height: 0px; max-height: none;">
			<div>
				<div class="yp-pay-wrap">
					<div class="yp-pay-msg js_pay_info">
						<!-- <div class="pay-top-msg">
							<span class="txt"> 购买套餐服务即可继续使用企业云盘哦 </span>
						</div> -->
						<div class="pay-msg-item js_pay_username">
							<span class="tit">订单编号：</span>
							<div class="txt">3345422241400832</div>
							<span class="orange pay-star">*</span>
						</div>
						<div class="pay-msg-item js_pay_username">
							<span class="tit">商品名称：</span>
							<div class="txt">人本 经典款帆布鞋 韩版百搭布鞋休闲男鞋 舒适 防滑……</div>
						</div>
 
						<div
							class="pay-msg-item js_pay_type js_pay_buy_type js_pay_package_id"
							data-pay-type="6" data-pay-package-id="5" data-pay-buy-type="0">
							<span class="tit sel-tit">购买套餐：</span>
							<div class="txt">
								<ul class="pay-sel-list js_pay_eid"
									data-pay-eid="14799922782131672">
									<li class="sel-item current  js_pay_combine_price_id"
										data-size="100G" data-package-id="5"
										data-pay-combine-price-id="4" data-users="20"><span
										class="price">¥99</span> <span class="time">体验版</span> <span
										class="right"></span></li>
									<li class="sel-item  js_pay_combine_price_id" data-size="200G"
										data-package-id="10" data-pay-combine-price-id="7"
										data-users="20"><span class="price">¥199</span> <span
										class="time">白银版</span> <span class="right"></span></li>
									<li class="sel-item  js_pay_combine_price_id" data-size="500G"
										data-package-id="20" data-pay-combine-price-id="10"
										data-users="50"><span class="price">¥499</span> <span
										class="time">黄金版</span> <span class="right"></span></li>
									<li class="sel-item  js_pay_combine_price_id" data-size="1024G"
										data-package-id="30" data-pay-combine-price-id="13"
										data-users="100"><span class="price">¥999</span> <span
										class="time">铂金版</span> <span class="right"></span></li>
								</ul>
							</div>
						</div>
						<div class="pay-msg-item">
							<span class="tit">套餐内容：</span>
							<div class="txt package-detail-info">
								<em class="js_package_name">体验版</em> <span class="orange"><em
									class="js_pay_size">100G</em>空间，<em class="js_pay_users">20</em>个成员，有效期1年</span>
							</div>
						</div>
						<div class="pay-msg-item">
							<span class="tit">应付金额：</span>
							<div class="txt">
								<span class="package-money js_pay_expire"><strong
									class="orange js_money">99.00</strong>元</span>
							</div>
						</div>
					</div>
					<div class="yp-pay-way" style="background-color: #fff">
						<div class="pay-way-hd">
							<ul class="pay-tab-menu clearfix js_pay_paytype">
								<li class="current" data-pay-type="1"><a href="#">微信支付</a>
								</li>
								<li data-pay-type="0"><a href="#">支付宝</a></li>
								<li data-pay-type="2"><a href="#">网上银行</a></li>
								<li style="display: none;" data-pay-type="3"><a href="#">企业网银</a>
								</li>
							</ul>
						</div>
						<div class="pay-way-bd clearfix" style="display: block;">
							<div class="pay-way-item">
								<div class="pay-way-tit">
									<i class="icon-payway weixin-way"></i>
									<div class="txt">
										<h3 class="payway-name">
											<span class="name">微信支付</span>
										</h3>
										<p class="gray">使用微信扫码支付</p>
									</div>
								</div>
								<div class="pay-way-main">
									<div class="pay-code">
										<img class="js_pay_loading"
											style="margin: 72px; width: 16px; height: 16px; display: none;"
											src="https://p.ssl.qhimg.com/t01e67cff7f21a058dc.gif">
										<img class="js_wxpay_qrcode" style="display: inline;"
											src="/vip/wxqrcode?content=weixin%3A%2F%2Fwxpay%2Fbizpayurl%3Fpr%3D98g2pHn">
										<p class="code-txt">
											打开手机端微信<br>扫一扫继续付款
										</p>
									</div>
								</div>
							</div>
						</div>
						<div class="pay-way-bd alipay clearfix" style="display: none;">
							<div class="pay-way-item">
								<div class="pay-way-tit">
									<i class="icon-payway alipay-way"></i>
									<div class="txt">
										<h3 class="payway-name">
											<span class="name"><img
												src="https://p.ssl.qhimg.com/t013ecfea5ac6f69dea.png"></span>
											<span class="way-item">扫码支付</span> <span class="recom">推荐</span>
										</h3>
										<p class="gray">使用支付宝钱包手机APP扫码支付</p>
									</div>
								</div>
								<div class="pay-way-main">
									<div class="pay-code">
										<img class="js_pay_loading"
											style="margin: 72px; width: 16px; height: 16px; display: none;"
											src="https://p.ssl.qhimg.com/t01e67cff7f21a058dc.gif">
										<img class="js_alipay_qrcode"
											src="https://mobilecodec.alipay.com/show.htm?code=gdxox0xox3byo4bpd6&amp;picSize=S">
										<p class="code-txt">
											打开支付宝钱包<br>扫一扫继续付款
										</p>
									</div>
								</div>
							</div>
							<div class="pay-way-item">
								<div class="pay-way-tit">
									<i class="icon-payway alipay-way"></i>
									<div class="txt">
										<h3 class="payway-name">
											<span class="name"><img
												src="https://p.ssl.qhimg.com/t013ecfea5ac6f69dea.png"></span>
											<span class="way-item">网页支付</span>
										</h3>
										<p class="gray">去支付宝网站支付</p>
									</div>
								</div>
								<div class="pay-way-main">
									<div class="ali-webpay">
										<img src="https://p.ssl.qhimg.com/t01b7e338d281f51707.png">
									</div>
								</div>
								<div class="btn-wrap ta-c">
									<span class="y-btn y-btn-blue y-btn-icon-text js_btn_alipay"
										data-alipay-url=""> <span class="label">去支付宝网站支付</span></span>
								</div>
							</div>
						</div>
						<div class="pay-way-bd clearfix" style="display: none;">
							<div class="bank-payway">
								<ul class="back-list clearfix js_bank_code">
									<li class="back-item current" data-bank-code="ICBCB2C"><i
										class="bank-ico ico-01"></i>工商银行 <span
										class="corner corner-right"></span></li>
									<li class="back-item" data-bank-code="CCB"><i
										class="bank-ico ico-06"></i> 建设银行 <span class="corner"></span>
									</li>
									<li class="back-item" data-bank-code="CMB"><i
										class="bank-ico ico-08"></i> 招商银行 <span class="corner"></span>
									</li>
									<li class="back-item" data-bank-code="ABC"><i
										class="bank-ico ico-02"></i> 农业银行 <span class="corner"></span>
									</li>
									<li class="back-item" data-bank-code="COMM"><i
										class="bank-ico ico-03"></i> 交通银行 <span class="corner"></span>
									</li>
									<li class="back-item" data-bank-code="BOCB2C"><i
										class="bank-ico ico-09"></i> 中国银行 <span class="corner"></span>
									</li>
									<li class="back-item" data-bank-code="PSBC-DEBIT"><i
										class="bank-ico ico-04"></i> 邮政银行 <span class="corner"></span>
									</li>
									<li class="back-item" data-bank-code="SPDB"><i
										class="bank-ico ico-15"></i> 浦发银行 <span class="corner"></span>
									</li>
									<li class="back-item" data-bank-code="SDB"><i
										class="bank-ico ico-20"></i> 深发银行 <span class="corner"></span>
									</li>
									<li class="back-item" data-bank-code="CEBBANK"><i
										class="bank-ico ico-10"></i> 光大银行 <span class="corner"></span>
									</li>
									<li class="back-item" data-bank-code="GDB"><i
										class="bank-ico ico-13"></i> 广发银行 <span class="corner"></span>
									</li>
									<li class="back-item" data-bank-code="HXB"><i
										class="bank-ico ico-05"></i> 华夏银行 <span class="corner"></span>
									</li>
									<li class="back-item" data-bank-code="CITIC"><i
										class="bank-ico ico-07"></i> 中信银行 <span class="corner"></span>
									</li>
									<li class="back-item" data-bank-code="CIB"><i
										class="bank-ico ico-16"></i> 兴业银行 <span class="corner"></span>
									</li>
									<li class="back-item" data-bank-code="CMBC"><i
										class="bank-ico ico-11"></i> 民生银行 <span class="corner"></span>
									</li>
									<li class="back-item" data-bank-code="BJBANK"><i
										class="bank-ico ico-19"></i> 北京银行 <span class="corner"></span>
									</li>
									<li class="back-item" data-bank-code="SHBANK"><i
										class="bank-ico ico-18"></i> 上海银行 <span class="corner"></span>
									</li>
									<li class="back-item" data-bank-code="NBBANK"><i
										class="bank-ico ico-17"></i> 宁波银行 <span class="corner"></span>
									</li>
									<li class="back-item" data-bank-code="SPABANK"><i
										class="bank-ico ico-14"></i> 平安银行 <span class="corner"></span>
									</li>
									<li class="back-operate" style="display: none"><span
										class="show-all">＋更多银行</span></li>
								</ul>
								<div class="bank-payway-btm">
									<div class="btn-wrap">
										<span class="y-btn y-btn-blue y-btn-icon-text js_btn_netbank">
											<span class="label">立即支付</span>
										</span>
									</div>
								</div>
							</div>
						</div>
						<div class="pay-way-bd clearfix" style="display: none">
							<div class="bank-payway">
								<ul class="back-list clearfix js_bank_code">
									<li class="back-item ebank-ico current" data-bank-code="BOCB2B"><span
										class="corner corner-right"></span></li>
									<li class="back-item ebank-ico ebank-ico02"
										data-bank-code="ABCBTB"><span class="corner"></span></li>
									<li class="back-item ebank-ico ebank-ico03"
										data-bank-code="CCBBTB"><span class="corner"></span></li>
									<li class="back-item ebank-ico ebank-ico04"
										data-bank-code="CEBB2B"><span class="corner"></span></li>
									<li class="back-item ebank-ico ebank-ico05"
										data-bank-code="ICBCBTB"><span class="corner"></span></li>
									<li class="back-item ebank-ico ebank-ico06"
										data-bank-code="CMBB2B"><span class="corner"></span></li>
									<li class="back-item ebank-ico ebank-ico07"
										data-bank-code="CIBB2B"><span class="corner"></span></li>
									<li class="back-item ebank-ico ebank-ico08"
										data-bank-code="SPDBB2B"><span class="corner"></span></li>
									<li class="back-operate" style="display: none"><span
										class="show-all">＋更多银行</span></li>
								</ul>
								<br>
								<div class="bank-payway-btm">
									<div class="btn-wrap">
										<span class="y-btn y-btn-blue y-btn-icon-text js_btn_netbank">
											<span class="label">立即支付</span>
										</span>
									</div>
								</div>
								<div class="bank-payway-tips"
									style="margin-top: 20px; color: #a0a0a0">
									<p>注：不同银行显示的商户名称不同，均为合作的支付公司，请放心支付，如支付有问题请及时联系首页在线客服。如：北京通融通信息技术有限公司、易宝支付有限公司、北京奇元科技有限公司、深圳市奇付通科技有限公司、上海银联电子支付服务有限公司。</p>
								</div>
							</div>
						</div>
	       
					<div class="yp-pay-fdback">
						<div class="fdback-result">
							<i class="icon-fdback icon-error"></i>支付超时
						</div>
						<div class="buy-fail-fdback">
							<p>
								如果您已支付请到<a class="lnk" href="/vip/records/">我的订单</a>中查看
							</p>
						</div>
						<div class="btn-wrap btns-wrap ta-c">
							<a class="y-btn y-btn-gray y-btn-icon-text js_cennel"
								style="display: none" href="/vip/record"> <span
								class="label">去购买记录查看</span></a> <span
								class="y-btn y-btn-blue y-btn-icon-text js_confirm"> <span
								class="label">确定</span></span>
						</div>
					</div>
					
					<div class="yp-pay-fdback">
						<div class="fdback-result">
							<i class="icon-fdback icon-error"></i>支付结果确认
						</div>
						<div class="buy-fail-fdback">
							<p>
								如果支付时遇到问题，请联系<a target="_blank" class="lnk"
									href="http://chat.live800.com/live800/chatClient/chatbox.jsp?companyID=722067&amp;configID=126139&amp;jid=3937694228">在线客服</a>，<br>如果您已支付完成，请到<a
									class="lnk" href="/vip/records/">购买记录</a>中查看
							</p>
						</div>
						<div class="btn-wrap btns-wrap ta-c">
							<a href="/vip/record"
								class="y-btn y-btn-gray y-btn-icon-text js_cennel"
								style="display: none"> <span class="label">去购买记录查看</span></a> <span
								class="y-btn y-btn-blue y-btn-icon-text js_confirm"> <span
								class="label">确定</span></span>
						</div>
					</div>
				 
					</div>
				</div>
			</div>
		</div>
	</div>
<script type="text/javascript">

$(".js_pay_paytype").find("li").on("click", function (e) {
    e.preventDefault();
    var t = $(this).index();
    $(this).addClass("current").siblings().removeClass("current");
    var n = $(this).parents(".yp-pay-way").find(".pay-way-bd").eq(t);
    n.show().siblings(".pay-way-bd").hide();
})
e = $("#js_pay_panel");
e.find(".js_btn_alipay").on("click", function (e) {
    e.preventDefault(), X({}), P("alipay")
}), e.find(".js_bank_code").find("li").on("click", function (e) {
    e.preventDefault(), $(this).addClass("current").siblings("li").removeClass("current"), $(this).find(".corner").addClass("corner-right"), $(this).find(".corner-right").removeClass(".corner-right")
}), e.find(".js_btn_netbank").on("click", function (e) {
    e.preventDefault();
    var t = $(this).parents(".bank-payway").find(".js_bank_code").find(".current").filter(":visible").attr("data-bank-code");
    t ? (X({}), B(t)) : alert("请先选择银行")
})
 e.find(".js_alipay_qrcode,.js_wxpay_qrcode").on("load", function (e) {
            $(this).fadeIn(300).siblings("img").hide()
})
    function V(e) {
        
        var t = e.title || "状态未知",
            n = e.head || "状态未知",
            r = e.content || '因网络延时，未获取到支付状态，<br>请到<a class="lnk" href="/vip/records/">购买记录</a>中查看';
       s = $("#js_pay_fail");
      s.find(".fdback-result").html('<i class="icon-fdback icon-error"></i>' + n),
      s.find(".buy-fail-fdback").html("<p>" + r + "</p>");
           
         
    }
V({
                    title: "支付超时",
                    head: "支付超时",
                    content: '如果您已支付请到<a class="lnk" href="/vip/records/">购买记录</a>中查看'
                });
                
function P(e) {
    if (e) {
        var t = window.open();
        a = 0, R({
            bank_code: "ZFB"
        }, function (e) {
            t.location = e.data.payurl
        })
    } else $(".js_pay_loading").fadeIn(200), $(".js_alipay_qrcode,.js_wxpay_qrcode").hide(), R({
        bank_code: "YY_ALIPAYQRCODE"
    }, function (e) {
        $(".js_alipay_qrcode").attr("src", e.data.payurl), u && u.to_break(), u = new q(e.data.order_id), u.start()
    })
}             
                
                
 
</script>

</body>
</html>