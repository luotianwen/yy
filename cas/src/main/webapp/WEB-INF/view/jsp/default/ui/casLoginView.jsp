<!DOCTYPE html>
<%@ page pageEncoding="UTF-8" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<html  >
<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <meta charset="utf-8">
    <title>世峰户外商城&gt;户外用品专家&gt;销售专业户外装备专用网站</title>
    <meta name="keywords" content="户外装备,驴友商城,户外商城,户外装备商城,世峰户外商城,户外,户外用品,户外背包,户外服装,户外鞋,骑行装备,攀岩装备,驴友装备,登山装备,露营装备" />
    <meta name="description" content="世峰户外商城&gt;在线销售专业户外装备，为驴友提供包括全套露营装备、登山攀岩用具、骑行装备&gt;专业安全舒适的户外服装、登山鞋、徒步鞋、户外背包、睡袋等" />
    <meta name="Robots" content="all">
    <meta name="author" content="世峰户外商城">
    <meta name="_csrf" content="${_csrf.token}"/>
    <meta name="_csrf_header" content="${_csrf.headerName}"/>
    <spring:theme code="standard.custom.css.file" var="customCssFile" />
    <link rel="stylesheet" href="<c:url value="${customCssFile}" />" />
    <link rel="icon" href="<c:url value="/favicon.ico" />" type="image/x-icon" />

</head>
<body  >
<div class="header boxw">
    <a href=""><img src="/img/logo.png" /></a>
</div>
<div class="login_content clearfix">



<c:if test="${not pageContext.request.secure}">
    <div id="msg" class="errors">
        <h2><spring:message code="screen.nonsecure.title" /></h2>
        <p><spring:message code="screen.nonsecure.message" /></p>
    </div>
</c:if>

<div id="cookiesDisabled" class="errors" style="display:none;">
    <h2><spring:message code="screen.cookies.disabled.title" /></h2>
    <p><spring:message code="screen.cookies.disabled.message" /></p>
</div>

    <%--
    <c:if test="${not empty registeredService}">
        <c:set var="registeredServiceLogo" value="images/webapp.png"/>
        <c:set var="registeredServiceName" value="${registeredService.name}"/>
        <c:set var="registeredServiceDescription" value="${registeredService.description}"/>

        <c:choose>
            <c:when test="${not empty mduiContext}">
                <c:if test="${not empty mduiContext.logoUrl}">
                    <c:set var="registeredServiceLogo" value="${mduiContext.logoUrl}"/>
                </c:if>
                <c:set var="registeredServiceName" value="${mduiContext.displayName}"/>
                <c:set var="registeredServiceDescription" value="${mduiContext.description}"/>
            </c:when>
            <c:when test="${not empty registeredService.logo}">
                <c:set var="registeredServiceLogo" value="${registeredService.logo}"/>
            </c:when>
        </c:choose>

        <div id="serviceui" class="serviceinfo">
            <table>
                <tr>
                    <td><img src="${registeredServiceLogo}"></td>
                    <td id="servicedesc">
                        <h1>${fn:escapeXml(registeredServiceName)}</h1>
                        <p>${fn:escapeXml(registeredServiceDescription)}</p>
                    </td>
                </tr>
            </table>
        </div>
    <p/>
</c:if>
--%>

<div class="boxw" id="login">
    <!--------登录--------->
    <div class="login_interface" >
        <div class="title">
            <span class="t_1"></span>账号登录<span class="t_2"></span>
        </div>
        <!--如报错，input添加类名error_border-->
        <form:form method="post" id="fm1" commandName="${commandName}" htmlEscape="true"  >

            <div class="id_num">
                <i></i>
                <c:choose>
                    <c:when test="${not empty sessionScope.openIdLocalId}">
                        <strong><c:out value="${sessionScope.openIdLocalId}" /></strong>
                        <input type="hidden" id="username" name="username" value="<c:out value="${sessionScope.openIdLocalId}" />" />
                    </c:when>
                    <c:otherwise>
                        <spring:message code="screen.welcome.label.netid.accesskey" var="userNameAccessKey" />
                        <form:input cssClass="required " placeholder="手机号" cssErrorClass=" error_border" id="username" size="25" tabindex="1" accesskey="${userNameAccessKey}" path="username" autocomplete="off" htmlEscape="true" />
                    </c:otherwise>
                </c:choose>
            </div>
            <div class="psd_num">
                <i></i>
                <form:password cssClass="required" cssErrorClass=" error_border" placeholder="请输入密码" id="password" size="25" tabindex="2" path="password"  accesskey="${passwordAccessKey}" htmlEscape="true" autocomplete="off" />
                <span id="capslock-on" style="display:none;"><p><img src="images/warning.png" valign="top"> <spring:message code="screen.capslock.on" /></p></span>
            </div>
                <form:errors path="*" id="msg" cssClass="error" element="div" htmlEscape="false" />
            <input type="hidden" name="execution" value="${flowExecutionKey}" />
            <input type="hidden" name="_eventId" value="submit" />

            <button type="submit">登录</button>
            <ul class="other_functions clearfix">
                <li class="forget_password">
                    <a href="http://www.seebong.com/forget">忘记密码</a>
                </li>
                <li class="register_immediately">
                    <a href="http://www.seebong.com/register">立即注册</a>
                </li>
            </ul>
           <%-- <div class="other_ways clearfix">
                <span class="ow_1"></span>第三方登陆<span class="ow_2"></span>
            </div>
            <div class="login_method clearfix">
                <div class="lm_1">
                    <a href=""><img src="img/qq.png" /></a>
                </div>
                <div class="lm_2">
                    <a href=""><img src="img/wx.png" /></a>
                </div>
            </div>--%>
        </form:form>
    </div>



<div id="sidebar">
    <div class="sidebar-content">
        <p><spring:message code="screen.welcome.security" /></p>

        <c:if test="${!empty pac4jUrls}">
            <div id="list-providers">
                <h3><spring:message code="screen.welcome.label.loginwith" /></h3>
                <form>
                    <ul>
                        <c:forEach var="entry" items="${pac4jUrls}">
                            <li><a href="${entry.value}">${entry.key}</a></li>
                        </c:forEach>
                    </ul>
                </form>
            </div>
        </c:if>


    </div>
</div>
</div> <!-- END #content -->
</div>
    <div class="footer boxw">
        <div class="footer_content_1 clearfix">
            <div class="site_map">
                <div class="f_item">
                    <p class="title">-购物指南-</p>
                    <ul>
                        <li><a href="">注册协议</a></li>
                        <li><a href="">购物流程</a></li>
                        <li><a href="">会员介绍</a></li>
                        <li><a href="">发票管理</a></li>
                    </ul>
                </div>
                <div class="f_item">
                    <p class="title">-支付/配送-</p>
                    <ul>
                        <li><a href="">支付方式</a></li>
                        <li><a href="">在线支付</a></li>
                        <li><a href="">银行转账</a></li>
                        <li><a href="">配送费用</a></li>
                    </ul>
                </div>
                <div class="f_item">
                    <p class="title">-常见问题-</p>
                    <ul>
                        <li><a href="">订单查询</a></li>
                        <li><a href="">找回密码</a></li>
                        <li><a href="">客户留言</a></li>
                        <li><a href="">取消订单</a></li>
                    </ul>
                </div>
                <div class="f_item">
                    <p class="title">-售后服务-</p>
                    <ul>
                        <li><a href="">退换货说明</a></li>
                        <li><a href="">退换货流程</a></li>
                        <li><a href="">退款说明</a></li>
                        <li><a href="">常见问题</a></li>
                    </ul>
                </div>
                <div class="f_item">
                    <p class="title">-商务合作-</p>
                    <ul>
                        <li><a href="">招商标准</a></li>
                        <li><a href="">入驻流程</a></li>
                        <li><a href="">资费标准</a></li>
                        <li><a href="">招商热线</a></li>
                    </ul>
                </div>
            </div>
            <div class="contact_way">
                <span class="cw_phone">400-0928-400</span>
                <span class="cw_time">周一至周日 9:00-18:00</span>
            </div>
        </div>
        <div class="footer_content_2">
            <ul class="other_links clearfix">
                <li><a href="">户外商城</a></li>
                <li><a href="">关于世峰</a></li>
                <li><a href="">入驻商城</a></li>
                <li><a href="">友情链接</a></li>
                <li><a href="">加入世峰</a></li>
                <li><a href="">投诉建议</a></li>
                <li><a href="">联系我们</a></li>
                <li><a href="">客服中心</a></li>
                <li><a href="">专家建议</a></li>
                <li class="last_item"><a href="">京东世峰</a></li>
            </ul>
            <p>版权所有：2011-2016 北京慧斓美国际商贸有限公司　京公网安备11011202001763号　经营性网站许可证号：京IC</p>
            <p>世峰户外商城 办公地址：北京市通州区九棵树西路90号英特商务园 福乐阳光公寓4层 联系电话：400-0928-400</p>
            <ul class="credit clearfix">
                <li><a href=""><img src="/img/download_2.jpg"/></a></li>
                <li><a href=""><img src="/img/download_3.jpg"/></a></li>
                <li><a href=""><img src="/img/download_4.png"/></a></li>
                <li><a href=""><img src="/img/download_5.png"/></a></li>
            </ul>
        </div>
    </div>

</body>
</html>
