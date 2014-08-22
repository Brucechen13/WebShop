<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户注册</title>
<style type="text/css">

	body{
		background-color: CornFlowerBlue;
	}

	div.bigBox{
		background-color: Azure;
		width: 70%;
		height: 500px;
		margin-left: 15%;
		margin-top: 70px;
		background-color: #fff;
		border-radius: 1em;
		position: relative;
		box-shadow: 10px 10px 20px #666;
	}

	div.title{
		position: relative;
		text-align: center;
		font-family: cursive;
		top: 40px;
	}

	div.title span{
		font-size: 48px;
		font-weight: bold;
	}

	div.content{
		position: relative;
		text-align: center;
		top: 60px;
	}

	div.content p{
		font-size: 24px;
		font-family: cursive;
	}

	div.content p.click{
		font-size: 36px;
		font-style: normal;
	}

	div.link{
		text-align: center;
		display: inline-block;
		position: relative;

	}

	div.link div{
		position: relative;
		float: left;
		display: block;
		width: 100px;
		font-size: 24px;
		margin: 20px;
		margin-top: 0;
	}

	div.link a{
		font-family: cursive;
		display: block;
		background-color: CornFlowerBlue;
		color: Azure;
		text-decoration: none;
		border-radius: 0.8em;
	}

	div.link a:hover{
		font-family: cursive;
		background-color: Azure;
		color: CornFlowerBlue;
		text-decoration: none;
		display: block;
		border-radius: 0.8em;
	}

</style>
</head>
<body>
<s:include value="../header.jsp" />
<div class="bigBox">
	<div class="title">
		<span>用户注册</span>
	</div>
	<div class="content">
		<p><div align="center"><s:form action="login!validRegister.action">
	<s:textfield id="username" label="用户名" name="username"/>
    <s:password id="password" label="密码" name="password"/>
    <s:password id="password2" label="确认密码" name="password2"/>
    <s:submit value="确认" />
</s:form></div></p>
		<div>
		  	<div align="center">
		  		<p></p>
		  		<div class="link">
		  		</div>
		  	</div>			  
	  	</div>
	</div>
</div>



</body>
</html>