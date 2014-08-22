<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title> 显示商品</title>
<link href="shop.css" rel="stylesheet" type="text/css"/>
<script language="javascript" type="text/javascript">
var fasong=getXmlHttpRequestObject();

//建立对象
function getXmlHttpRequestObject() 
{
	if (window.XMLHttpRequest) {
  		return new XMLHttpRequest();
 	} else if(window.ActiveXObject) {
  		return new ActiveXObject("Microsoft.XMLHTTP");
 	} else {
		alert( '状况: 无法建立 XmlHttpRequest 对象. 建议升级您的浏览器.');
 	}
	
}

function send(id)
{
 	if(id!='')
 	{
 		//fasong.setRequestHeader("content-type","application/x-www-form-urlencoded; charset=utf-8"); 
  		var content='goodid='+id;
  		if (fasong.readyState == 4 || fasong.readyState == 0) {
  			fasong.open("post", 'orders!save.action', true);
  			fasong.setRequestHeader('Content-Type','application/x-www-form-urlencoded');
  			fasong.onreadystatechange = jieshou; 
  			fasong.send(content);/*文本矿内容发送给a.asp*/
  		}
 	}
 	//return false;
}
function jieshou()    /*a.asp返回的数据*/
{
 	if (fasong.readyState == 4) 
 	{
 		
  		var textdoc = fasong.responseText;
  		alert(unescape(textdoc));
 		///*给接收文本框接受到的*/ document.getElementById('jieshou').value=textdoc;
 	}
}

</script>
</head>
<body>
<s:include value="../header.jsp" />
 <div class="bigBox">
	<div class="title">
		<span>显示商品</span>
	</div>
	<div class="content">
		<p>
		<div align="center">
 <s:form action="goods!search.action">
	<s:textfield id="goodname" name="goodname" label="商品名"/>
	<s:radio name="type" list="%{#{'0':'精确查找','1':'模糊查找'}}" theme="simple"></s:radio>
    <s:submit value="查找" />
</s:form>
 <table border="1" width="350">
 <tr><th>商品名称</th><th>商品价格</th><th>商品类别</th><th></th><th></th></tr>
 <s:iterator value="lg" var="good">
 <tr>
 <td>
 <a href="
  <s:url action="goods!info.action">
  <s:param name="id" value="#good.id"></s:param>
  </s:url>">
 <s:property value="#good.name"/></a>
</td>
<td>
  <s:property value="#good.price"/>
  </td>
  <td>
  <s:property value="#good.type.name"/>
  </td>
  <td>
  <a href="
  <s:url action="goods!purchase.action">
  <s:param name="id" value="#good.id"></s:param>
  </s:url>">
  购买</a></td>
    <td><span style="cursor:pointer">
    <a onclick="send(<s:property value="#good.id"/>)">收藏</a></span>
    </td>
  </tr>
 </s:iterator>
</table>

	<s:url id="url_pre" value="goods.action">
         <s:param name="pageNow" value="pageNow-1"></s:param>
     </s:url>
     <s:url id="url_next" value="goods.action">
         <s:param name="pageNow" value="pageNow+1"></s:param>
     </s:url> 
     <s:a href="%{url_pre}">上一页</s:a>
     <s:a href="%{url_next}">下一页</s:a> 
     </div>
     </div>
     </div>
</body>
</html>