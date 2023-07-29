<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>???????</title>
</head>
<body>
	<form action="${pageContext.request.contextPath }/useradd.do" method="post" enctype="multipart/form-data">
		<p>用户名：<input type="text" name="u_username"></p>
		<p>密码：<input type="text" name="u_password"></p>
		<p>年龄：<input type="text" name="u_age"></p>
		<p>性别：<input type="text" name="u_sex"></p>
		<p>昵称：<input type="text" name="u_nickname"></p>
		<p>手机：<input type="text" name="u_mobile"></p>
		<p>住址：<input type="text" name="u_address"></p>
		<p>头像：<input type="file" name="files"></p>
		<p><input type="submit" name="提交"></p>
	</form>
</body>
</html>