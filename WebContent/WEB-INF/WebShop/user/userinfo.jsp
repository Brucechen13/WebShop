<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户信息</title>
<link href="shop.css" rel="stylesheet" type="text/css"/>
</head>
<body>
<s:include value="../header.jsp" />
<div class="bigBox">
	<div class="title">
		<span>用户信息</span>
	</div>
	<div class="content">
		<p>
		<div align="center">
用户名：${users[0].username}
用户金钱：${users[0].money}
用户积分：${users[0].scope}
</div>
	</div>
</div>
</body>
</html>