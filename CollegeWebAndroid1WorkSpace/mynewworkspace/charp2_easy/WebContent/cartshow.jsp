<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" import="java.util.*"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
<link type="text/css" href="css/main.css" rel="stylesheet">
 <link type="text/css" href="css/autoplay.css" rel="stylesheet"/> 
<script type="text/javascript" src="js/autoplay.js"></script>

</head>
<body style="overflow-y:auto;">
<!--1.LOGO --> 
<%@include  file="head.jsp"  %>
<!-- 2.网站菜单列表 -->
<%@include  file="nav.jsp"  %>
<br/><br/><br/><br/>


<table width="600px" align="center" cellspacing="0" cellpadding="0" border="1">
<tr><th>商品名称</th><th>商品图片</th><<th>商品价格</th>/<th>数量</th><th>商品编号</th></tr>
<c:forEach var="book" items="${cart}" >

<tr>
	<td>${book.name }</td>
	<td><img src="bookimage/${book.pic }" width="60px" height="100px"/></td>
	<td>${book.price}元</td>
	<td>${book.num}</td>
	<td>${book.number}</td>

</tr>
</c:forEach>
</table>
<br><br>

<!-- 底部版权栏 -->
<%@include file="foot.jsp" %>
</body>
</html>