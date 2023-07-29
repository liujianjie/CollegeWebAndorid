<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>员工列表</title>
</head>
<body>
	<H1 align="center">员工信息</H1>
	<table bgcolor="purple" align="center" width="70%" cellspacing="1.5">
		<tr bgcolor="white">
			<th>编号</th>
			<th>姓名</th>
			<th>性别</th>
			<th>薪水</th>
			<th>加入时间</th>
			<th>操作</th>
		</tr>
		<c:forEach items="${list }" var="list">
			<tr bgcolor="white" align="center">
				<td>${list.emp_id }</td>
				<td>${list.emp_name }</td>
				<td>${list.emp_sex }</td>
				<td>${list.emp_salary }</td>
				<td>${list.join_date }</td>
				<td>
					<a href="dis.do?method=delete&emp_id=${list.emp_id }" onclick="return confirm('确定吗')">删除</a>
					<a href="dis.do?method=toalter&emp_id=${list.emp_id }">修改</a>
				</td>
			</tr>	
		</c:forEach>
		
	</table>
	<br>
	<a href="addemp.jsp">添加员工</a>
</body>
</html>