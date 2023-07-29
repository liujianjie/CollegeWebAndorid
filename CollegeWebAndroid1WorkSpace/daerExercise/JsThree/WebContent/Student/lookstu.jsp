<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@page import="java.sql.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body style="background-image: url(../images/bg.jpg); background-repeat:no-repeat;">
	<div>
		<font style="height:30px; backgroud-color: #33ccff;font-weight: bold;color: white;width: 180px;">
			当前页面--&gt;学生信息查询
		</font>
	</div>
	
	<div>
		<%
			ResultSet rs = null;
			Statement stmt = null;
			Connection con = null;
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
				con = DriverManager.getConnection(url, user, pwd);
				stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
				String sql = "select * from student";
				rs = stmt.executeQuery(sql);
				rs.last();
			}catch(SQLException e){
				System.out.println("数据库操作失败");
				e.printStackTrace();
			}
		%>
		<center>
			<div style="height:200px;">
				<table>
					<tr>
						<th>学生信息查询</th>
					</tr>
					<tr>
						<td>你要查询的学生共有<font size="5" color="red"><%=rs.getRow() %></font>人</td>
					</tr>
				</table>
			</div>
			<table border="2" bgcolor="#ccceee" width="600">
				<tr bgcolor="#cccccc" align="center">
					<th>记录条数</th>
					<th>学号</th>
					<th>姓名</th>
					<th>性别</th>
					<th>年龄</th>
					<th>体重</th>
				</tr>
				<%
					rs.beforeFirst();
					while(rs.next()){
				%>
						<tr align="center">
							<td><%=rs.getRow() %></td>
							<td><%=rs.getString("studentnumber") %></td>
							<td><%=rs.getString("studentname") %></td>
							<td><%=rs.getString("studentsex") %></td>
							<td><%=rs.getString("studentage") %></td>
							<td><%=rs.getString("studentweight") %></td>
						</tr>
				<%
					}
					rs.close();
					stmt.close();
					con.close();
				%>
			</table>
		</center>
	</div>
</body>
</html>