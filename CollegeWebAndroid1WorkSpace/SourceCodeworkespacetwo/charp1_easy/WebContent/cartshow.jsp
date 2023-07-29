<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8" import="java.util.*,shop_book.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
<link type="text/css" href="css/main.css" rel="stylesheet">
<link type="text/css" href="css/autoplay.css" rel="stylesheet" />
<script type="text/javascript" src="js/autoplay.js"></script>

</head>
<body>
	<!--1.LOGO -->
	<%@include file="head.jsp"%>
	<!-- 2.网站菜单列表 -->
	<%@include file="nav.jsp"%>
	<br />
	<br />
	<br />
	<br />


	<table align="center" width="50%"  bordercolor="#40B9B5" cellspacing="0"
		cellpadding="0" border="1">
		<tr>
			<th width="25%">商品名称</th>
			<th width="25%">商品图片</th>
			<th width="25%">商品价格</th>
			<th width="25%">数量</th>
		</tr>
		<c:forEach var="book" items="${cart}">
			<tr align="center">
				<td>${book.name }</td>
				<td><img src="bookimage/${book.pic }"
					width="120px" height="160px"></td>
				<td>${book.price}元</td>
				<td>${book.num}</td>
			</tr>
		</c:forEach>
	</table>
	<br>
	<br>

	<!-- 底部版权栏 -->
	<%@include file="foot.jsp"%>
</body>
</html>