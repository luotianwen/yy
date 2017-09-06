<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<style type="text/css">
	.cursor{cursor: pointer;}
</style>

<div class="col-sm-2 col-lg-2">
    <div class="sidebar-nav">
        <div class="nav-canvas">
            <div class="nav-sm nav nav-stacked">

            </div>
            <ul id="menus" class="nav nav-pills nav-stacked main-menu">
                <li class="nav-header"></li>
                <li>
                    <a id="home" class="ajax-link" href="index.html"><i class="glyphicon glyphicon-home"></i><span> 首页</span></a>
                </li>
                <li class="accordion">
                    <a class="cursor"><i class="glyphicon glyphicon-plus"></i><span> 我的店铺</span></a>
                    <ul class="nav nav-pills nav-stacked">
                        <li>
                            <a data_url="shopinfo/myshop.html" class="cursor">店铺管理</a>
                        </li>
                        <li>
                            <a data_url="shopbrand/goShopBrand.html" class="cursor">品牌管理</a>
                        </li>
                        <li>
                            <a data_url="shopcategorycolor/goShopCategoryColor.html" class="cursor">颜色管理</a>
                        </li>
                        <li>
                            <a data_url="shopcategoryspec/goShopCategorySpec.html" class="cursor">规格管理</a>
                        </li>
                    </ul>
                </li>
                <li class="accordion">
					<a class="cursor"><i class="glyphicon glyphicon-plus"></i><span> 商品管理</span></a>
					<ul class="nav nav-pills nav-stacked">
						<li>
							<a data_url="product/goProductCategory.html" class="cursor">添加新商品</a>
						</li>
						<li>
							<a data_url="product/goProduct.html?state=1" class="cursor">在售商品管理</a>
						</li>
						<li>
							<a data_url="product/goProduct.html?state=2" class="cursor">待售商品管理</a>
						</li>
						<li>
							<a data_url="prorules/goProRules.html" class="cursor">商品库存管理</a>
						</li>
						<li>
							<a data_url="product/goProduct.html?state=3" class="cursor">商品回收站点</a>
						</li>
						<li>
							<a data_url="productevaluate/goProductEvaluateList.html" class="cursor">商品评价管理</a>
						</li>
						<li>
							<a data_url="productconsultation/goProductConsultationList.html" class="cursor">商品咨询管理</a>
						</li>
					</ul>
				</li>
				<li class="accordion">
					<a class="cursor"><i class="glyphicon glyphicon-plus"></i><span> 订单管理</span></a>
					<ul class="nav nav-pills nav-stacked">
						<li>
							<a data_url="orderInfo/goOrderInfoList.html" class="cursor">订单查询与跟踪</a>
						</li>
						<li>
							<a data_url="expressorder/goExpressOrder.html" class="cursor">修改快递单据号</a>
						</li>
					</ul>
				</li>
                <li class="accordion">
                    <a class="cursor"><i class="glyphicon glyphicon-plus"></i><span> 配送管理</span></a>
                    <ul class="nav nav-pills nav-stacked">
                        <li>
                            <a style="cursor: pointer" data_url="fright/goFright.html">运费模板管理</a>
                        </li>

                        <li>
                            <a data_url="shippingaddress/goShippingAddress.html" class="cursor">发货地址管理</a>
                        </li>


                    </ul>
                </li>
                <li class="accordion">
                    <a class="cursor"><i class="glyphicon glyphicon-plus"></i><span> 售后管理</span></a>
                    <ul class="nav nav-pills nav-stacked">
                        <li>
                            <a data_url="aftersalespolicy/goAfterSalesPolicy.html" class="cursor">售后模板管理</a>
                        </li>

                        <li>
                        	<a data_url="returnaddress/goReturnAddress.html" class="cursor">退货地址管理</a>
                        </li>
                        
                        <li>
                        	<a data_url="orderInfoservice/goOrderInfoServiceList.html" class="cursor">服务单据管理</a>
                        </li>
                    </ul>
                </li>

            </ul>
        </div>
    </div>
</div>