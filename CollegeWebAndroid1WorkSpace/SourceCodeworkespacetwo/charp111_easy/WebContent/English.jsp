<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*,com.goods.book.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>外语</title>
<link type="text/css" href="css/main.css" rel="stylesheet">
</head>
<body>
<!--1.LOGO --> 
<%@include  file="logo.jsp"  %>
<!-- 2.网站菜单列表 -->
<%@include  file="nav.jsp" %>
<br/><br/><br/><br/>

<%Collection<Book> books = BookBB.getAll(); %>

<table width="200px" border="1" align="center" cellspacing="0" cellpadding="0">

<tr>
<c:forEach var="book" items="<%=books%>" >
	<td><img src="computerbook/${book.path }"></td>>
</c:forEach>
</tr>

<tr align="center">
<c:forEach var="book" items="<%=books%>" >
	<td><a href="/charp111_easy/PurchaseServlet?id=${book.id }" 
	onclick="alert('成功加入购物车！！')">加入购物车</a></td>
</c:forEach>
</tr>
</table>
<br/><br/><br/><br/><br/><br/>
<!-- 底部版权栏 -->
<%@include file="copy.jsp" %>
</body>
</html>