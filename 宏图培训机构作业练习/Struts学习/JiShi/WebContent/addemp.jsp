<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>添加员工</title>
</head>
<body>
	<H1 align="center">添加员工信息</H1>
	<form action="dis.do?method=add" method="post">
	<table width="40%" align="center" cellspacing="1.5" bgcolor="purple">
		<tr bgcolor="white">
			<td>编号：</td>
			<td><input type="text" name="emp_id" ></td>
		</tr>
		<tr bgcolor="white">
			<td>姓名：</td>
			<td><input type="text" name="emp_name" ></td>
		</tr>
		<tr bgcolor="white">
			<td>性别：</td>
			<td><input type="text" name="emp_sex" ></td>
		</tr>
		<tr bgcolor="white">
			<td>薪水：</td>
			<td><input type="text" name="emp_salary" ></td>
		</tr>
		<tr bgcolor="white">
			<td>加入日期：</td>
			<td><input type="text" name="join_date" ></td>
		</tr>
		<tr bgcolor="white">
			<td colspan="2">
				<input type="submit" value="添加">
				<input type="button" value="取消" onclick="location.href='dis.do?method=list'">
			</td>
			
		</tr>
	</table>
	</form>
</body>
</html>