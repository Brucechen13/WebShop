<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>订单管理</title>
<link href="shop.css" rel="stylesheet" type="text/css"/>
</head>
<body>
<s:include value="../adminHeader.jsp" />
<div class="bigBox">
	<div class="title">
		<span>订单管理</span>
	</div>
	<div class="content">
		<p>
		<div align="center">

<s:iterator value="orders" var="order">
<s:form action="orders!modify.action">
	<s:hidden id="id" name="id" value="%{#order.id}"> </s:hidden>
	<s:textfield id="goodname" label="商品信息" name="goodname" readonly="true" value="%{#order.good.name}"/>
    <s:textfield id="username" label="买家信息" name="username" readonly="true" value="%{#order.user.username}"/>
    <s:textfield id="status" label="订单状态" name="status" readonly="true" value="%{#order.status}"/>
	<s:select list="statusinfo" label="更改状态" name="newstatus" id="newstatus" headerKey="0" />
    <s:submit value="修改" />
</s:form> 
</s:iterator>
<s:url id="url_pre" value="orders!manage.action">
         <s:param name="pageNow" value="pageNow-1"></s:param>
     </s:url>
     <s:url id="url_next" value="orders!manage.action">
         <s:param name="pageNow" value="pageNow+1"></s:param>
     </s:url> 
     <s:a href="%{url_pre}">上一页</s:a>
     <s:a href="%{url_next}">下一页</s:a> 
</div>
	</div>
</div>
</body>
</html>