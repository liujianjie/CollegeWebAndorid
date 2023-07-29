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
		String user = request.getParameter("user");
		String pwd = request.getParameter("pwd");
		if(pwd.isEmpty()){
	%>
		<font color="blue"> 请输入密码，以完成正常的注册</font>
	<%
		}
		else if(pwd.length() < 5){
	%>
		<font color="blue"> 密码容易被盗</font>
	<%
		}
		else if(pwd.length() > 8){
	%>
		<font color="blue"> 密码这么长你记得住？</font>
	<%
		}
		else{
	%>
		<font color="red"><%=user %> 注册成功</font>
	<%
		}
	%>
</body>
</html>


