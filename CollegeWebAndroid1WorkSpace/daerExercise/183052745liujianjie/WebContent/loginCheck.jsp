<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录验证</title>
</head>
<body>
	<%
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
	%>
	<!-- 使用jsp动作来赋值给实例 ,scope=session,可以全局获取-->
	<jsp:useBean id="log" class="com.ljj.bean.UserLogin"></jsp:useBean>
	<jsp:setProperty property="*" name="log"/>
	
	<%
		String name = log.getUsername();
		String pwd = log.getUserpwd();
		if("刘建杰".equals(name) && "123".equals(pwd)){
			session.setAttribute("name", name);
			response.sendRedirect("loginSuc.jsp");
		}else{
			response.sendRedirect("login.jsp");
		}
	%>

</body>
</html>