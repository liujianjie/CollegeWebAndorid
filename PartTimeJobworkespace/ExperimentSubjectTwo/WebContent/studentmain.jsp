<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>学生详细信息</title>
</head>
<body>
<table width="80%" align="center"  bgcolor="green" cellspacing="1.5">
		<tr align="center" bgcolor="white">
			<td><b>用户姓名</b></td>
			<td><b>登录密码</b></td>
			<td><b>学号</b></td>
			<td><b>学生姓名</b></td>
			<td><b>性别</b></td>
			<td><b>身份证</b></td>
		</tr>
		<tr align="center" bgcolor="white">
			<td>${studentbean.username }</td>
			<td>${studentbean.password }</td>
			<td>${studentbean.stuno }</td>
			<td>${studentbean.stuname }</td>
			<td>${studentbean.sex }</td>
			<td>${studentbean.idcard }</td>
		</tr>
	</table>
</body>
</html>