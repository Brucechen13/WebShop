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
<s:if test="#session.user!=null">
<a href="user!info.action">
${session.user} 
</a>
<a href="login!quit.action">
退出
</a>
<a href="orders!userSave.action">
我的收藏
</a>
<a href="orders!showOrders.action">
我的订单
</a>
</s:if>
<s:else>
<a href="login.action">
用户登录</a>
</s:else>
<a href="goods.action">
返回首页
</a>
<a href="login!register.action">
用户注册
</a>
<hr/>
</div>
</div>
</div>

</body>
</html>