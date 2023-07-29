<%@page import="com.login.Login"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		Login log = new Login();
		log.setUsername("张三");
		log.setPassword("123456");
	%>
	<hr>
	输出属性的值：<br>
	姓名：<%=log.getUsername() %><br>
	密码：<%=log.getPassword() %>
</body>
</html>