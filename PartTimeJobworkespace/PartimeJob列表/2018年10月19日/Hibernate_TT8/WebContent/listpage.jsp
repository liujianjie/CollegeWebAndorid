<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table width="60%" cellspacing="1" bgcolor="red" align="center">
		<tr bgcolor="white">
			<th>部门ID</th>
			<th>部门名称</th>
			<th>操作</th>
		</tr>
		<c:forEach items="${list }" var="dept">
			<tr bgcolor="white">
				<th>${dept.did }</th>
				<th>${dept.dname }</th>
				<th><a href="deptemp.do?method=toupd&did=${dept.did }">修改</a> <a
					href="deptemp.do?method=del&did=${dept.did }">删除</a></th>
			</tr>
			<tr bgcolor="white">
				<td colspan="3"><c:forEach items="${dept.employees }" var="emp">
		员工姓名： ${emp.ename }  性别：${emp.sex }<br />
					</c:forEach></td>
			</tr>
		</c:forEach>
		<tr>
			<td colspan="3">每页显示${pageCount }条,共${totalRow } 当前${currPage }/${totalPage }页
			<a href="page.do?method=list1&currPage=1">首页</a> <a href="page.do?method=list1&currPage=${currPage-1}">上一页</a><a href="page.do?method=list1&currPage=${currPage+1}">下一页</a><a href="page.do?method=list1&currPage=${totalPage}">尾页</a>
			</td>
		</tr>
	</table>
	<a href="add.jsp">新增1</a>
	<br />
	<a href="deptemp.do?method=toadd">新增2</a>
</body>
</html>