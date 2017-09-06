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

