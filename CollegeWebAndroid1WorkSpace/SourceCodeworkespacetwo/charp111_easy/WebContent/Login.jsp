<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录</title>
<link type="text/css" href="css/main.css" rel="stylesheet">
</head>
<body>
<!--1.LOGO --> 
<%@include  file="logo.jsp"  %>
<!-- 2.网站菜单列表 -->
<%@include  file="nav.jsp" %>
<br/><br/><br/><br/>

<div align="center">
<form action="${pageContext.request.contextPath }/LoginServlet"  method="post">
用户名&nbsp;&nbsp;&nbsp;:<input type ="text" name="name"/> ${registerMessage}<br>
密&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;码:<input type ="password" name="password"/><br>
验证码：<input type="text" name="check_code"/><br/>
	<img src="/charp111_easy/CheckServlet"><br/>

<input type ="submit" value="登录"/>



</form>
</div>

<br/><br/><br/><br/><br/><br/>
<!-- 底部版权栏 -->
<%@include file="copy.jsp" %>
</body>
</html>