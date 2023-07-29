<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
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
		request.setCharacterEncoding("utf-8");
		String name = request.getParameter("userNo");
		String password = request.getParameter("password");
		String type = request.getParameter("userType");
		
		session.setAttribute("name", name);
		session.setAttribute("type", type);
		
		// 1.加载jdbc驱动程序
		try{
			Class.forName("com.mysql.jdbc.Driver");
		}catch(ClassNotFoundException e){
			System.out.println("找不到驱动程序类，加载驱动类失败");
		}
		// 2.提供jdbc链接URL
		try{
			String url = "jdbc:mysql://localhost:3306/mystudent?serverTimezone=GMT&useUnicode=true&characterEncoding=utf-8"; // 协议 数据库类型 地址端口 数据库
			String user = "root";
			String pwd = "tiger";
			Connection con = DriverManager.getConnection(url, user, pwd);
			Statement stmt = con.createStatement();
			String sql = "select * from login where Uname = '"+name+"' and Upass = '"+password+"' and Utype = '"+type+"'";
			ResultSet rs = stmt.executeQuery(sql);
			if(rs.next()){
				response.sendRedirect("../Stumain/stumain.jsp");
			}else{
				response.sendRedirect("login.jsp");
			}
			rs.close();
			stmt.close();
			con.close();
		}catch(SQLException e){
			System.out.println("数据库操作失败");
			e.printStackTrace();
		}
		
	%>
</body>
</html>