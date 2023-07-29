<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>学生列表</title>
</head>
<body>
	<table width="70%" cellspacing="1.5" bgcolor="purple" align="center">
		<tr bgcolor="white" height="30" >	
			<th>学号</th>
			<th>姓名</th>
			<th>年龄</th>
			<th>性别</th>
			<th>说明</th>
			<th>爱好</th>
			<th>城市</th>
			<th>操作</th>
		</tr>
		<c:forEach items="${list }" var="list">
			<tr bgcolor="white" align="center">
				<td>${list.stu_id }</td>
				<td>${list.stu_name }</td>
				<td>${list.stu_age }</td>
				<td>${list.stu_sex }</td>
				<td>${list.stu_desc }</td>
				<td>${list.stu_aihao }</td>
				<td>${list.stu_city }</td>
				<td>
					<a href="stu.do?method=toalert&stu_id=${list.stu_id }">修改</a>
					<a href="stu.do?method=delete&stu_id=${list.stu_id }">删除</a>
				</td>
			</tr>
		</c:forEach>
		<tr bgcolor="white">
			<td colspan="8">
				当前页:<font color="red">${currPage }</font>页,共:<font color="red">${totalPage }</font>页。
				<a href="stu.do?method=list&currpage=1">首页</a>
				<a href="stu.do?method=list&currpage=${currPage-1 }">上一页</a>
				<a href="stu.do?method=list&currpage=${currPage+1 }">下一页</a>
				<a href="stu.do?method=list&currpage=${totalPage }">末页</a>
			</td>
		</tr>
		
	</table>
	<a href="add.jsp">添加</a>
</body>
</html>