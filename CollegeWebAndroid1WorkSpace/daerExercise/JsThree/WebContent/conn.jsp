<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.SQLException"%>
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
	<table bordercolor="#ff33aa" border="1"  align="center" >
	<%
		// 1.加载jdbc驱动程序
		try{
			Class.forName("com.mysql.jdbc.Driver");
		}catch(ClassNotFoundException e){
			System.out.println("找不到驱动程序类，加载驱动类失败");
		}
		// 2.提供jdbc链接URL
		try{
			String url = "jdbc:mysql://localhost:3306/rcm?serverTimezone=GMT&useUnicode=true&characterEncoding=utf-8"; // 协议 数据库类型 地址端口 数据库
			String user = "root";
			String pwd = "tiger";
			Connection con = DriverManager.getConnection(url, user, pwd);
			System.out.println("数据库链接成功");
			// 操作con对象，查询表
			Statement stmt = con.createStatement();
			// 删除
			String updsql = "update user set user_name = '张三' where id = 12";
			stmt.executeUpdate(updsql);
			String sql = "select * from user";
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()){
	%>
					<tr>
						<td><%=rs.getString("user_name") %></td>
						<td><%=rs.getString("pwd") %></td>
					</tr>
	<% 
			}
			rs.close();
			stmt.close();
			con.close();
		}catch(SQLException e){
			System.out.println("数据库链接失败");
			e.printStackTrace();
		}
		
	%>
	</table>
</body>
</html>