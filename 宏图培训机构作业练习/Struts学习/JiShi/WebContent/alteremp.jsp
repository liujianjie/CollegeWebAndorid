<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>修改员工信息</title>
</head>
<body>
	<H1 align="center">修改员工信息</H1>
	<form action="dis.do?method=alter" method="post">
	<input type="hidden" name="emp_id" value="${list.emp_id }">
	<table width="40%" align="center" cellspacing="1.5" bgcolor="purple">
		<tr bgcolor="white">
			<td>姓名：</td>
			<td><input type="text" name="emp_name" value="${list.emp_name }"></td>
		</tr>
		<tr bgcolor="white">
			<td>性别：</td>
			<td><input type="text" name="emp_sex" value="${list.emp_sex }"></td>
		</tr>
		<tr bgcolor="white">
			<td>薪水：</td>
			<td><input type="text" name="emp_salary" value="${list.emp_salary }"></td>
		</tr>
		<tr bgcolor="white">
			<td>加入日期：</td>
			<td><input type="text" name="join_date" value="${list.join_date }"></td>
		</tr>
		<tr bgcolor="white">
			<td colspan="2">
				<input type="submit" value="提交">
				<input type="button" value="取消" onclick="location.href='dis.do?method=list'">
			</td>
			
		</tr>
	</table>
	</form>
</body>
</html>