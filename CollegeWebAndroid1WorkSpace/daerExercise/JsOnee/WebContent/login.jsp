<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="login.jsp" method = "get">
		<p>用户名:<input type="text" name="user"/></p>
		<p>密码:<input type="password" name="pwd"/></p>
		<p><input type="submit" value="提交"/>
	</form>
	
	<%
		String user = request.getParameter("user");
		String pwd = request.getParameter("pwd");
		if(user != null && pwd != null){
			if("liujianjie".equals(user) && "1234".equals(pwd))
			{
				session.setAttribute("flag", "ok");
				response.sendRedirect("welcome.jsp");
			}
			else{
	%>
		<font color="red">用户名或密码不正确，请重新输入</font>
	<%
			}
		}
	%>
</body>
</html>