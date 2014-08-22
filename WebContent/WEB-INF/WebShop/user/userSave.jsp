<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>显示收藏</title>
<link href="shop.css" rel="stylesheet" type="text/css"/>
</head>
<body>
<s:include value="../header.jsp" />
<div class="bigBox">
	<div class="title">
		<span>显示收藏</span>
	</div>
	<div class="content">
		<p>
		<div align="center">
 <table border="1" width="350">
 <tr><th>商品名称</th><th>商品价格</th><th>商品类别</th><th></th></tr>
 <s:iterator value="saves" var="save">
 <tr>
 <td>
 <a href="
  <s:url action="goods!info.action">
  <s:param name="id" value="#save.good.id"></s:param>
  </s:url>">
 <s:property value="#save.good.name"/></a>
</td>
<td>
  <s:property value="#save.good.price"/>
  </td>
  <td>
  <s:property value="#save.good.type.name"/>
  </td>
  <td>
  <a href="
  <s:url action="orders!undoSave.action">
  <s:param name="id" value="#save.id"></s:param>
  </s:url>">
  取消收藏</a></td>
  </tr>
 </s:iterator>
</table>
</div>
	</div>
</div>
</body>
</html>