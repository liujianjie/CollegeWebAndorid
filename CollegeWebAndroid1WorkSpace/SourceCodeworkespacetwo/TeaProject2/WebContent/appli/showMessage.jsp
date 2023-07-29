<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*,com.bean.*" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
table{ 
	color:#965;
	font:12px arial;
	text-align:center;
	width:800px;
}
tr{background-color:#eee;}
</style>
</head>
<body>
<img src="gbook.gif"><a href="showMessage.jsp">查看评论</a>
<img src="weite.gif"><a href="submit.jsp">我要评论</a>

<table border="1" align="center">
<c:forEach var="s" items="${Mess}">
		<tr>
		<td>昵称：${s.name}<br> <img src="${s.pic}"></td>
		<td>标题：<b>${s.title}</b><br>
			发表于：${s.date}<br>
			内容：${s.message}
			</td>
		</tr>
</c:forEach>
</table>
</body>
</html>