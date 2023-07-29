<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>验证页面</title>
<link href="css/degin.css" rel="stylesheet"> 
</head>
<body>
	<%
		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("user");
		String pwd = request.getParameter("pass");
		String pwdcheck = request.getParameter("passcheck");
		
		if(!name.isEmpty() && !pwd.isEmpty() && !pwdcheck.isEmpty()){
			if(pwd.equals(pwdcheck)){
	%>
				<p><%=name %>欢迎您!</p>
	<%
				session.setAttribute("name", name);
				response.setHeader("refresh","2;URL=shop.jsp");
				
			}else{
	%>
				<h2><font color="red">两次输入密码不一致！</font></h2>
	<%
				response.setHeader("refresh","2;URL=register.jsp");
			}
		}else{
	%>
			<h2><font color="red">用户名或者密码为空！</font></h2>
	<%
			response.setHeader("refresh","2;URL=register.jsp");
		}
	%>
</body>
</html>