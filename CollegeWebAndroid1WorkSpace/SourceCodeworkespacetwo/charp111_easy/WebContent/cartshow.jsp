<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*,com.goods.book.*"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link type="text/css" href="css/main.css" rel="stylesheet">
</head>
<body>
<!--1.网站顶部 --> 
<%@include  file="logo.jsp"  %>
<!-- 2.网站菜单列表 -->
<%@include  file="nav.jsp"  %>
<br/><br/><br/><br/>

<%
List <Book> cart =null;
//获得用户购物车
cart = (List) session.getAttribute("cart");
//如果用的购物车为null,purFlag置为false
%>

<table align="center" cellspacing="0" cellpadding="0">
<tr><th>商品名称</th><th>商品图片</th><th>商品价格</th></tr>
<c:forEach var ="book" items="<%=cart %>">
<tr>
<td>${book.name }</td>
<td><img src="/charp111_easy/computerbook/${book.path}" 
width="60px"height="100px"/></td>
<td>${book.price }</td>
</tr>
</c:forEach>
</table>






















<!-- 底部版权栏 -->
<%@include  file="copy.jsp"  %>
</body>
</html>