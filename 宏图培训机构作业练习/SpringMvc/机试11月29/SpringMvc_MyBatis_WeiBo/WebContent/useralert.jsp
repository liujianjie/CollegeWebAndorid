<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>???????</title>
</head>
<body>
	<form action="${pageContext.request.contextPath }/useralert.do" method="post">
		<p>用户名:<input type="text" value="${user.u_username }" name="uname"></p>
		<p>密码:<input type="text" value="${user.u_password }" name="pwd"></p>
		<p><input type="submit" value="修改"></p>
	</form>
</body>
</html>