<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>添加</title>
	
</head>
<body>
	<form action="stu.do?method=alert" method="post">
	<input type="hidden" name="stu_id" value="${student.stu_id }">
	<table bgcolor="purple" cellspacing="1.5" width="60%" align="center">
		<tr bgcolor="white">
			<td align="center">学生姓名：</td>
			<td><input type="text" name="stu_name" value="${student.stu_name }"></td>
		</tr>
		<tr bgcolor="white" >
			<td align="center">年龄：</td>
			<td><input type="text" name="stu_age" value="${student.stu_age }"></td>
		</tr>
		<tr bgcolor="white" >
			<td align="center">性别：</td>
			<td><input type="text" name="stu_sex" value="${student.stu_sex }"></td>
		</tr>
		<tr bgcolor="white" >
			<td align="center">说明：</td>
			<td><textarea rows="5" cols="30" name="stu_desc">${student.stu_desc }</textarea> </td>
		</tr>
		<tr bgcolor="white" >
			<td align="center">经历</td>
			<td id="it">
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;开始时间&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;结束时间&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;所在学校<br>
				<c:forEach items="${student.jinglivo }" var="jl">
				<input type="hidden" name="jl_jid" value="${jl.jl_jid }">
				<input type="text" name="jl_starttime" value="${jl.jl_starttime }"><input type="text" name="jl_endtime" value="${jl.jl_endtime }"><input type="text" name="jl_school" value="${jl.jl_school }"><br>
				</c:forEach>
			</td>
		</tr>
		<tr bgcolor="white" >
			
			<td colspan="2">
				<input type="submit" value="提交">
				<input type="button" value="取消" onclick="history.back()">
			</td>
		</tr>
	</table>
	</form>
</body>
</html>