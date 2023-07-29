<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>部门列表</title>
</head>
<body>
	<table width="70%" cellspacing="1.5" align="center" bgcolor="purple">
		<tr bgcolor="white" height="30">
			<th>部门编号</th>
			<th>部门名称</th>
			<th>上级部门</th>
			<th>操作</th>
		</tr>
		<c:forEach items="${list}" var="list">
			<tr align="center" bgcolor="white">
				<td>${list.deptid }</td>
				<td>${list.deptname }</td>
				<td>${list.parentid }</td>
				<td>
					<a href="dept.do?method=toalert&deptid=${list.deptid }">修改</a>
					<a href="dept.do?method=delete&deptid=${list.deptid }">删除</a>
				</td>
			</tr>
			<tr bgcolor="white">
				<td colspan="4">
					这城是那么空
				</td>
			</tr>
		</c:forEach>
		<tr bgcolor="white">
			<td colspan="4">
				当前页:<font color="red">${currPage }</font>/<font color="red">${totalPage }</font>,
				共${rowCount }条数据
				<a href="page.do?method=hibernatehql&currpage=1">首页</a>
				<a href="page.do?method=hibernatehql&currpage=${currPage-1 }">上一页</a>
				<a href="page.do?method=hibernatehql&currpage=${currPage+1 }">下一页</a>
				<a href="page.do?method=hibernatehql&currpage=${totalPage }">末页</a>
			</td>
		</tr>
	</table>
</body>
</html>