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
<s:include value="../header.jsp" />
<div class="bigBox">
	<div class="title">
		<span>显示订单</span>
	</div>
	<div class="content">
		<p>
		<div align="center">
 <table border="1" width="350">
 <tr><th>商品名称</th><th>状态</th><th></th></tr>
 <s:iterator value="orders" var="order">
 <tr>
 <td>
 <s:property value="#order.good.name"/>
</td>
  <td>
  <s:property value="#order.status"/>
  </td>
  <td>
   <a href="
  <s:url action="orders!undoOrder.action">
  <s:param name="id" value="#order.id"></s:param>
   <s:param name="status" value="#order.status"></s:param>
  </s:url>">
  撤销
  </a>
  </td>
  </tr>
 </s:iterator>
</table>
</div>
	</div>
</div>
</body>
</html>