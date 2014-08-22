<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>确定购买</title>
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
		<span></span>
	</div>
	<div class="content">
		<p>确定购买商品${lg[0].name}？</p>
		<p>价格${lg[0].price}</p>
		<p>种类${typename}</p>
		<p>你现有金钱${users[0].money}</p>
		<p>购买将增加积分10</p>
		<div>
		  	<div align="center">
		  		<p></p>
		  		<div class="link">
		  		<div><div><a href="
<s:url action="orders!purchase.action">
  <s:param name="id" value="#request.lg[0].id"></s:param>
  <s:param name="userid" value="#request.users[0].id"></s:param></s:url>">确定购买</a></div>
  <div><a href="goods.action">取消</a></div>
		  		</div>
		  	</div>			  
	  	</div>
	</div>
</div>
</div>

</body>
</html>