<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">

	body{
		background-color: CornFlowerBlue;
	}

	div.headbigBox{
		background-color: Azure;
		width: 70%;
		margin-left: 15%;
		background-color: #fff;
		border-radius: 1em;
		position: relative;
		box-shadow: 10px 10px 20px #666;
	}

	div.headcontent{
		position: relative;
		text-align: center;
	}

</style>
</head>
<body>
<div class="headbigBox">
<div class="headcontent">
		<div align="center">
<hr/>

管理员
<a href="admin!quit.action">
退出
</a>
<a href="user.action">
用户管理
</a>
<a href="goods!manage.action">
商品管理
</a>
<a href="orders!manage.action">
订单管理</a>
<a href="admin.action">
返回首页
</a>
<hr/>
</div>
</div>
</div>

</body>
</html>