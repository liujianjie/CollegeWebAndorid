<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" import="java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>计算机书</title>
 <link type="text/css" href="css/main.css" rel="stylesheet">
 <link type="text/css" href="css/autoplay.css" rel="stylesheet"/> 
<script type="text/javascript" src="js/autoplay.js"></script>

</head>
<body>
<!--1.LOGO --> 
<%@include  file="head.jsp"  %>
<!-- 2.网站菜单列表 -->
<%@include  file="nav.jsp"  %>
<br/><br/><br/><br/>


<table width="200px" border="1" align="center" cellspacing="0" cellpadding="0">

<%int i=0; %>
<tr>
<c:forEach var="book" items="${books}" >

<c:if test="${book.catalog=='gl' }" >

<%if(i%4==0) out.println("<tr>"); %>

	<td ><img style="width: 150px;height: 150px" src="bookimage/${book.pic }"><br>${book.name }<br>${book.price}元<br>
	     <a href="${pageContext.request.contextPath}/PurchaseServlet?id=${book.id}" 
	        onclick="alert('成功加入购物车！！')">加入购物车</a>
	</td>
<%i++;if(i%4==0) out.println("</tr>"); %>		

</c:if>
</c:forEach>
	
</table>

<br/><br/><br/><br/><br/><br/>
<!-- 底部版权栏 -->
<%@include file="foot.jsp" %>

</body>
</html>