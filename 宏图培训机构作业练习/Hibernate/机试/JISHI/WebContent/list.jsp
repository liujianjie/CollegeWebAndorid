<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>学生列表</title>
</head>
<body>
	<table bgcolor="purple" cellspacing="1.5" width="70%" align="center">
		<tr bgcolor="white" height="30">
			<th>学生编号</th>
			<th>学生姓名</th>
			<th>年龄</th>
			<th>性别</th>
			<th>说明</th>	
			<th>操作</th>
		</tr>
		<c:forEach items="${list }" var="list">
			<tr bgcolor="white" align="center" height="30">
				<td>${list.stu_id }</td>
				<td>${list.stu_name }</td>
				<td>${list.stu_age }</td>
				<td>${list.stu_sex }</td>
				<td>${list.stu_desc }</td>
				<td>
				 	<a href="stu.do?method=toalert&stu_id=${list.stu_id }">修改</a>
				 	<a href="stu.do?method=delete&stu_id=${list.stu_id }" onclick="return confirm('确定吗？')">删除</a>
				</td>
			</tr>
			<tr bgcolor="white" >

				<Td colspan="6">
					<c:forEach items="${list.jinglivo }" var="jl">
						经历:
						${jl.jl_starttime }~${jl.jl_endtime } 就读在 ${jl.jl_school }<br><br>
						
						</c:forEach>
				</Td>
			
			</tr>
		</c:forEach>
		<tr bgcolor="white" height="30">
			<td colspan="6">
				当前页：<font color="red">${currPage }</font>
				总页数：<font color="red">${totalPage }</font>
				总行数：<font color="red">${totalRow }</font>
				<a href="stu.do?method=list&currpage=1">首页</a>
				<a href="stu.do?method=list&currpage=${currPage-1 }">上一页</a>
				<a href="stu.do?method=list&currpage=${currPage+1 }">下一页</a>
				<a href="stu.do?method=list&currpage=${totalPage }">末页</a>
				每页：<font color="red">${pageCount }</font>条数据
			</td>
		</tr>
	</table>
	<a href="add.jsp">添加</a>
</body>
</html>