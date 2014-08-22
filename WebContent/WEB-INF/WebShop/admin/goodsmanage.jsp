<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>商品管理</title>
<link href="shop.css" rel="stylesheet" type="text/css"/>
</head>
<body>
<s:include value="../adminHeader.jsp" />
<div class="bigBox">
	<div class="title">
		<span>管理商品</span>
	</div>
	<div class="content">
		<p>
		<div align="center">

 <table border="1" width="350">
 <tr><th>商品名称</th><th>商品价格</th><th></th></tr>
 <s:iterator value="lg" var="good">
 <tr>
 <td>
 <s:property value="#good.name"/>
</td>
<td>
  <s:property value="#good.price"/>
  </td>
  <td>
  <a href="
  <s:url action="goods!del.action">
  <s:param name="id" value="#good.id"></s:param>
  </s:url>">删除</a></td>
  </tr>
 </s:iterator>
</table>
<hr/>
添加商品
<s:form action="goods!add.action">
	<s:textfield id="goodname" label="商品名" name="goodname"/>
    <s:textfield id="goodprice" label="商品价格" name="goodprice"/>
	<s:select list="types" label="商品种类" name="type" id="type" headerKey="0" headerValue="--请选择--"></s:select>
    <s:submit value="添加" />
</s:form> 
</div>
	</div>
</div>
</body>
</html>