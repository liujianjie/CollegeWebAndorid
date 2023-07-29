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
			<th>员工姓名</th>
			<th>性别</th>
			<th>部门名称</th>
			<th>操作</th>
		</tr>
		<c:forEach items="${list }" var="map">
			<tr bgcolor="white">
				<th>${map.ENAME}</th>
			<th>${map.SEX }</th>
			<th>${map.DNAME}</th>
			<th>操作</th>
			</tr>
		</c:forEach>
		<tr>
			<td colspan="4">每页显示${pageCount }条,共${totalRow } 当前${currPage }/${totalPage }页
			<a href="page.do?method=list1&currPage=1">首页</a> <a href="page.do?method=list1&currPage=${currPage-1}">上一页</a><a href="page.do?method=list1&currPage=${currPage+1}">下一页</a><a href="page.do?method=list1&currPage=${totalPage}">尾页</a>
			</td>
		</tr>
	</table>
	<a href="add.jsp">新增1</a>
	<br />
	<a href="deptemp.do?method=toadd">新增2</a>
</body>
</html>