<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录页面</title>
</head>
<body>
<% request.setCharacterEncoding("utf-8");%>
<!-- userbean获取数据库连接 -->
<jsp:useBean id="dbcon" class="conn.DBconnection"></jsp:useBean>

<%
	//获取输入的用户名和密码
	String username = request.getParameter("username");
	String password = request.getParameter("password");
	
	//sql
	String sql = "select * from user where username = '"+username+"' and password = '"+password+"'";
	ResultSet rs = dbcon.query(sql);
	if(rs.next()){
		session.setAttribute("username", username);
		response.sendRedirect("loginsuc.jsp");
	}else{
		response.sendRedirect("login.jsp");
	}
%>
</body>
</html>